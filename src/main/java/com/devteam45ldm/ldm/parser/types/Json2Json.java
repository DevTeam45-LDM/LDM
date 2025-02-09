package com.devteam45ldm.ldm.parser.types;

import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportedData;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportMappings;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportTemplate;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The Json2Json class is responsible for converting a JSON string
 * into an Import object based on the provided ImportTemplate.
 */
public abstract class Json2Json implements Parser {

    /**
     * Converts the given JSON string into an Import object.
     *
     * @param json the JSON string to be converted
     * @return the resulting Import object
     * @throws JSONException if there is an error parsing the JSON
     */
    public static ImportedData parse(String json, ImportTemplate importTemplate) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        ImportMappings mappings = importTemplate.getData();

        ArrayList<String> metadataPath = mappings.getMetadata();
        ArrayList<String> dataPath = mappings.getData();

        String metadata = extractImmediateChildJsonValue(jsonObject, metadataPath);
        String data = extractImmediateChildJsonValue(jsonObject, dataPath);

        ImportedData anImportedData = new ImportedData();
        anImportedData.setMetadata(metadata);
        anImportedData.setData(data);

        return anImportedData;
    }

    /**
     * Extracts the immediate child value from the JSON object based on the specified path.
     *
     * @param jsonObject the JSON object to extract the value from
     * @param path the path to the value
     * @return the extracted value as a string
     * @throws JSONException if there is an error parsing the JSON
     */
    private static String extractImmediateChildJsonValue(JSONObject jsonObject, ArrayList<String> path) throws JSONException {
        JSONObject currentObject = jsonObject;
        for (String key : path) {
            if (currentObject.has(key)) {
                currentObject = currentObject.getJSONObject(key);
            } else {
                return "{}";
            }
        }
        return getImmediateChildJson(currentObject).toString();
    }

    /**
     * Gets the immediate child JSON object without further nested objects.
     *
     * @param jsonObject the JSON object to extract the immediate children from
     * @return the immediate child JSON object
     */
    private static JSONObject getImmediateChildJson(JSONObject jsonObject) throws JSONException {
        JSONObject result = new JSONObject();
        for (Iterator it = jsonObject.keys(); it.hasNext(); ) {
            String key = it.next().toString();
            Object value = jsonObject.get(key);
            if (!(value instanceof JSONObject)) {
                result.put(key, value);
            }
        }
        return result;
    }
}