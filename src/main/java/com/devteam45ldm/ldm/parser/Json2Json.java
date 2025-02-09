package com.devteam45ldm.ldm.parser;

import com.devteam45ldm.ldm.parser.templates.importDataStructures.Import;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportMappings;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportTemplate;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * The Json2Json class is responsible for converting a JSON string
 * into an Import object based on the provided ImportTemplate.
 */
public class Json2Json {
    private final ImportTemplate importTemplate;

    /**
     * Constructs a Json2Json parser with the specified ImportTemplate.
     *
     * @param importTemplate the template that defines the metadata and data paths
     */
    public Json2Json(ImportTemplate importTemplate) {
        this.importTemplate = importTemplate;
    }

    /**
     * Converts the given JSON string into an Import object.
     *
     * @param json the JSON string to be converted
     * @return the resulting Import object
     * @throws JSONException if there is an error parsing the JSON
     */
    public Import convert(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        ImportMappings mappings = importTemplate.getData();

        String metadataPath = mappings.getMetadata();
        String dataPath = mappings.getData();

        String metadata = extractJsonValue(jsonObject, metadataPath);
        String data = extractJsonValue(jsonObject, dataPath);

        Import anImport = new Import();
        anImport.setMetadata(metadata);
        anImport.setData(data);

        return anImport;
    }

    /**
     * Extracts the value from the JSON object based on the specified path.
     *
     * @param jsonObject the JSON object to extract the value from
     * @param path the dot-separated path to the value
     * @return the extracted value as a string
     * @throws JSONException if there is an error parsing the JSON
     */
    private String extractJsonValue(JSONObject jsonObject, String path) throws JSONException {
        String[] keys = path.split("\\.");
        JSONObject currentObject = jsonObject;
        for (int i = 0; i < keys.length - 1; i++) {
            currentObject = currentObject.getJSONObject(keys[i]);
        }
        return currentObject.get(keys[keys.length - 1]).toString();
    }
}