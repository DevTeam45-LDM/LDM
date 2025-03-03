package com.devteam45ldm.ldm.parser.types;

import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportParserMappings;
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
import java.util.*;


//TODO: Implement this class analogous to Json2Json class
public class Xml2Json {

    public static String parse(String xml, ImportParserMappings importParserMappings) throws ParserConfigurationException, IOException, JSONException, SAXException {
        // First convert the XML string to a JSONObject
        JSONObject xmlAsJson = parseXmlToJson(xml);

        // Extract paths from the JSONObject and merge them
        ArrayList<String> paths = importParserMappings.getPaths();

        // Create a default path if none exists
        if (paths == null) {
            // If no path is provided, look for the first property in the JSON
            String firstKey;

            // Get the first key from the JSON object
            if (xmlAsJson.length() > 0) {
                firstKey = xmlAsJson.keys().next().toString();
                paths = new ArrayList<>();
                paths.add(firstKey);
            } else {
                throw new JSONException("Path is null and JSON is empty");
            }
        } else if (paths.isEmpty()) {
            throw new JSONException("No paths found in mappings (empty list)");
        }

        // Extract and combine data from all paths
        JSONObject result = new JSONObject();
        for (String path : paths) {
            JSONObject pathData = getPathValue(xmlAsJson, path);
            combineJsonObjects(result, pathData);
        }

        return result.toString();
    }

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
    public static JSONObject parseXmlToJson(String xml) throws ParserConfigurationException, IOException, SAXException, JSONException {
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

    /**
     * Extracts a value from a JSON object using a dot-notation path.
     *
     * @param json the JSON object to extract from
     * @param path the dot-notation path (e.g., "root.child.value")
     * @return a JSON object containing the extracted value
     * @throws JSONException if there is an error working with JSON
     */
    private static JSONObject getPathValue(JSONObject json, String path) throws JSONException {
        String[] parts = path.split("\\.");

        // Start with empty result that will build the structure
        JSONObject result = new JSONObject();

        // Current position in result tree where we're adding
        JSONObject current = result;

        // Current position in source JSON we're reading from
        JSONObject source = json;

        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];

            // Check if path exists in source
            if (!source.has(part)) {
                return new JSONObject(); // Path not found
            }

            if (i == parts.length - 1) {
                // Last part of path - add value directly
                current.put(part, source.get(part));
            } else {
                // Intermediate path - create nested object and advance pointers
                Object value = source.get(part);
                if (!(value instanceof JSONObject)) {
                    return new JSONObject(); // Expected object but found something else
                }

                JSONObject newObject = new JSONObject();
                current.put(part, newObject);

                // Advance pointers
                current = newObject;
                source = (JSONObject) value;
            }
        }

        return result;
    }

    /**
     * Combines two JSON objects, merging nested structures.
     *
     * @param target the target object to merge into
     * @param source the source object with values to add
     * @throws JSONException if there is an error working with JSON
     */
    private static void combineJsonObjects(JSONObject target, JSONObject source) throws JSONException {
        for (Iterator<String> it = source.keys(); it.hasNext(); ) {
            String key = it.next();

            // If key doesn't exist in target, just add it
            if (!target.has(key)) {
                target.put(key, source.get(key));
                continue;
            }

            // If key exists in both, we need to merge
            Object sourceValue = source.get(key);
            Object targetValue = target.get(key);

            // If both are JSON objects, merge recursively
            if (sourceValue instanceof JSONObject && targetValue instanceof JSONObject) {
                combineJsonObjects((JSONObject) targetValue, (JSONObject) sourceValue);
            } else {
                // For non-objects, source overwrites target
                target.put(key, sourceValue);
            }
        }
    }
}