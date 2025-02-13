package com.devteam45ldm.ldm.parser.types;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO: Implement this class analogous to Json2Json class
public class Xml2Json {

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
    private static Object elementToJson(Element element) throws JSONException {
        JSONObject json = new JSONObject();

        // Handle attributes
        NamedNodeMap attributes = element.getAttributes();
        boolean hasAttributes = attributes.getLength() > 0;
        for (int i = 0; i < attributes.getLength(); i++) {
            Attr attr = (Attr) attributes.item(i);
            json.put(attr.getName(), attr.getValue());
        }

        // Handle child elements
        NodeList children = element.getChildNodes();
        boolean hasElementChildren = false;

        //Create a map to track repeated elements
        Map<String, List<Object>> repeatedElements =  new HashMap<>();

        // Process elements
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child instanceof Element childElement) {
                hasElementChildren = true;
                String nodeName = childElement.getNodeName();
                Object childJson = elementToJson(childElement);

                // If child has children or attributes, keep its structure
                if (childElement.hasChildNodes() || childElement.hasAttributes()) {
                    repeatedElements.computeIfAbsent(nodeName, k -> new ArrayList<>()).add(childJson);
                } else {
                    // For leaf elements with just text, use text directly
                    String textContent = childElement.getTextContent().trim();
                    repeatedElements.computeIfAbsent(nodeName, k -> new ArrayList<>())
                            .add(textContent.isEmpty() ? new JSONObject() : textContent);
                }
            }
        }

        for (Map.Entry<String, List<Object>> entry : repeatedElements.entrySet()) {
            String nodeName = entry.getKey();
            List<Object> elements = entry.getValue();

            if (elements.size() == 1) {
                json.put(nodeName, elements.getFirst());
            } else {
                JSONArray array = new JSONArray();
                elements.forEach(array::put);
                json.put(nodeName, array);
            }
        }

        // Handle text content
        String textContent = "";
        for (Node node = element.getFirstChild(); node != null; node = node.getNextSibling()) {
            if (node.getNodeType() == Node.TEXT_NODE) {
                textContent += node.getTextContent().trim();
            }
        }

        if (!hasElementChildren && !hasAttributes) {
            return textContent.isEmpty() ? new JSONObject() : textContent;
        } else if (!textContent.isEmpty()) {
            json.put("__" + element.getNodeName(), textContent);
        }

        return json;
    }
}