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
     * Converts the given JSON string into an ImportedData object based on the ImportTemplate.
     *
     * @param json the JSON string to be converted
     * @return the resulting ImportedData object
     * @throws JSONException if there is an error parsing the JSON
     */
    public static ImportedData parse(String json, ImportTemplate importTemplate) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        ImportMappings mappings = importTemplate.getData();

        JSONObject metadata = extractNestedJson(jsonObject, mappings.getMetadata());
        JSONObject data = extractNestedJson(jsonObject, mappings.getData());

        ImportedData importedData = new ImportedData();
        importedData.setMetadata(metadata.toString());
        importedData.setData(data.toString());

        return importedData;
    }

    /**
     * Extracts JSON data based on a list of paths and merges results.
     *
     * @param jsonObject the source JSON object
     * @param paths      list of JSON paths to extract data from
     * @return a combined JSONObject containing all extracted data
     * @throws JSONException if there is an error parsing the JSON
     */
    private static JSONObject extractNestedJson(JSONObject jsonObject, ArrayList<String> paths) throws JSONException {
        JSONObject result = new JSONObject();
        for (String path : paths) {
            JSONObject extracted = extractByPath(jsonObject, path);
            mergeJson(result, extracted);
        }
        return result;
    }

    /**
     * Extracts a JSON object based on a dot-separated path recursively.
     *
     * @param jsonObject the source JSON object
     * @param path       the JSON path (e.g., "kopfdaten.details")
     * @return the extracted JSONObject or an empty object if the path is not found
     * @throws JSONException if there is an error parsing the JSON
     */
    private static JSONObject extractByPath(JSONObject jsonObject, String path) throws JSONException {
        String[] keys = path.split("\\.");
        return extractByPathRecursive(jsonObject, keys, 0);
    }

    /**
     * Recursively extracts a JSON object based on a dot-separated path.
     *
     * @param jsonObject the source JSON object
     * @param keys       the array of keys representing the path
     * @param index      the current index in the keys array
     * @return the extracted JSONObject or an empty object if the path is not found
     * @throws JSONException if there is an error parsing the JSON
     */
    private static JSONObject extractByPathRecursive(JSONObject jsonObject, String[] keys, int index) throws JSONException {
        if (index >= keys.length) {
            return new JSONObject();
        }

        String key = keys[index];
        if (!jsonObject.has(key)) {
            return new JSONObject();
        }

        Object value = jsonObject.get(key);
        JSONObject result = new JSONObject();

        if (index == keys.length - 1) {
            // Letzte Ebene erreicht -> nur primitive Werte und Arrays behalten
            if (value instanceof JSONObject subObject) {
                JSONObject filteredSubObject = new JSONObject();

                for (Iterator it = subObject.keys(); it.hasNext(); ) {
                    String subKey = (String) it.next();
                    Object subValue = subObject.get(subKey);
                    if (!(subValue instanceof JSONObject)) {
                        filteredSubObject.put(subKey, subValue);
                    }
                }
                result.put(key, filteredSubObject);
            } else {
                result.put(key, value);
            }
        } else {
            // Rekursion fortsetzen
            if (value instanceof JSONObject) {
                JSONObject extractedSubObject = extractByPathRecursive((JSONObject) value, keys, index + 1);
                if (extractedSubObject.length() > 0) {
                    result.put(key, extractedSubObject);
                }
            }
        }

        return result;
    }


    /**
     * Merges two JSON objects, regenerating the original structure.
     *
     * @param target the target JSON object where data is merged into
     * @param source the source JSON object to merge from
     */
    private static void mergeJson(JSONObject target, JSONObject source) throws JSONException {
        for (Iterator<String> it = source.keys(); it.hasNext(); ) {
            String key = it.next();
            Object value = source.get(key);

            if (target.has(key)) {
                Object targetValue = target.get(key);
                if (targetValue instanceof JSONObject && value instanceof JSONObject) {
                    mergeJson((JSONObject) targetValue, (JSONObject) value);
                } else {
                    target.put(key, value);
                }
            } else {
                target.put(key, value);
            }
        }
    }
}
