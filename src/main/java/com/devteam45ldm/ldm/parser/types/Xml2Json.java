package com.devteam45ldm.ldm.parser.types;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import java.io.IOException;

//TODO: Implement this class analogous to Json2Json class
public abstract class Xml2Json implements Parser {

    public static JSONObject parse(String xml) throws ParserConfigurationException, IOException, SAXException, JSONException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(xml)));

        Element root = doc.getDocumentElement();
        JSONObject json = new JSONObject();
        json.put(root.getNodeName(), elementToJson(root));

        return json;
    }

    private static JSONObject elementToJson(Element element) throws JSONException {
        JSONObject json = new JSONObject();

        NamedNodeMap attributes = element.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            Attr attr = (Attr) attributes.item(i);
            json.put(attr.getName(), attr.getValue());
        }

        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child instanceof Element childElement) {
                if (json.has(childElement.getNodeName())) {
                    Object existing = json.get(childElement.getNodeName());
                    if (existing instanceof JSONArray) {
                        ((JSONArray) existing).put(elementToJson(childElement));
                    } else {
                        JSONArray array = new JSONArray();
                        array.put(existing);
                        array.put(elementToJson(childElement));
                        json.put(childElement.getNodeName(), array);
                    }
                } else {
                    json.put(childElement.getNodeName(), elementToJson(childElement));
                }
            } else if (child instanceof Text) {
                String textContent = child.getTextContent().trim();
                if (!textContent.isEmpty()) {
                    json.put("content", textContent);
                }
            }
        }

        return json;
    }
}