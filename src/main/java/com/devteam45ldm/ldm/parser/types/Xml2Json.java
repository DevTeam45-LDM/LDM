package com.devteam45ldm.ldm.parser.types;

import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportMappings;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportTemplate;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportedData;
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
import java.util.ArrayList;
import java.util.Iterator;

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

    public static ImportedData parse(String xml, ImportTemplate importTemplate) throws JSONException{
        try {
            // Parse XML to DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xml)));

            // Convert DOM to initial JSON
            Element root = doc.getDocumentElement();
            JSONObject fullJson = new JSONObject();
            fullJson.put(root.getNodeName(), elementToJson(root));

            // Extract sections based on template
            ImportMappings mappings = importTemplate.getData();
            JSONObject metadataJson = extractSection(fullJson, mappings.getMetadata());
            JSONObject dataJson = extractSection(fullJson, mappings.getData());

            // Create ImportedData
            ImportedData importedData = new ImportedData();
            importedData.setMetadata(metadataJson.toString());
            importedData.setData(dataJson.toString());

            return importedData;
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new JSONException("Error parsing XML: " + e.getMessage());
        }
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

    private static JSONObject extractSection (JSONObject json, ArrayList<String> paths) throws JSONException {
        if (paths == null || paths.isEmpty()) {
            return new JSONObject();
        }

        JSONObject result = new JSONObject();
        for (String path : paths) {
            // Split the path into segments
            String[] segments = path.split("\\.");
            // Start from the root JSON object
            JSONObject current = json;

            // Navigate through each segment of the path
            for (String segment : segments) {
                if (current.has(segment)) {
                    Object value = current.get(segment);
                    // If the value is another JSON object, move deeper into the structure
                    if (value instanceof JSONObject) {
                        current = (JSONObject) value;
                    } else {
                        // If the value is not a JSON object, add it to result
                        result.put(segment, value);
                        break;
                    }
                }
            }

            if (current != json) {
                mergeObjects(result, current);
            }
        }
        return result;
    }

    private static void mergeObjects(JSONObject target, JSONObject source) throws JSONException {
        Iterator<String> keys = source.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            Object value = source.get(key);
            if (!target.has(key)) {
                target.put(key, value);
            } else if (value instanceof JSONObject && target.get(key) instanceof JSONObject) {
                mergeObjects(target.getJSONObject(key), (JSONObject) value);
            }
        }
    }
}