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

    /**
     * Parses XML string into a JSON object, preserving the hierarchical structure.
     * Converts XML elements, attributes, and text content into corresponding JSON format.
     *
     * @param xml the XML string to parse
     * @return a JSONObject representing the XML structure where:
     *         - Element names become object keys
     *         - Attributes become key-value pairs
     *         - Text content becomes "content" value
     *         - Repeated elements become JSON arrays
     *
     * @throws ParserConfigurationException if there is an error configuring the XML parser
     * @throws IOException if there is an error reading the XML string
     * @throws SAXException if there is an error parsing the XML structure
     * @throws JSONException if there is an error creating the JSON structure
     */
    public static JSONObject parse(String xml) throws ParserConfigurationException, IOException, SAXException, JSONException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(xml)));
        doc.getDocumentElement().normalize();

        JSONObject json = new JSONObject();
        Element root = doc.getDocumentElement();
        json.put(root.getNodeName(), elementToJson(root));

        return json;
    }

    /**
     * Recursively converts an XML element to a JSON object.
     * Handles element attributes, nested elements, repeated elements, and text content.
     *
     * @param element the XML element to parse
     * @return a JSONObject containing the element's attributes, child elements, and text content where:
     *         - Attributes become direct key-value pairs
     *         - Child elements become nested objects
     *         - Repeated elements become arrays
     *         - Text content becomes "content" value
     *
     * @throws JSONException if there is an error creating the JSON structure
     */
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