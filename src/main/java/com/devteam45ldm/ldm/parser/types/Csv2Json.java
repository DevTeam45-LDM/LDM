package com.devteam45ldm.ldm.parser.types;

import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportParserMappings;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportedData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class Csv2Json {

    /**
     * Converts a CSV string into a JSON object.
     * Simply reformats the CSV structure into JSON format.
     *
     * @param csv the CSV string to parse
     * @return a JSONObject containing the parsed data
     * @throws JSONException if there is an error creating the JSON structure
     * @throws IOException if there is an error reading the CSV string
     */
    public static String parse(String csv, ImportParserMappings importParserMappings) throws JSONException {
        String delimiter;

        if (importParserMappings.getDelimiter() != null && !importParserMappings.getDelimiter().isEmpty()) {
            delimiter = importParserMappings.getDelimiter();
        }
        else{
            throw new JSONException("No delimiter found in mappings");
        }


        try {
            BufferedReader reader = new BufferedReader(new StringReader(csv));
            String headerLine = reader.readLine();
            if (headerLine == null) {
                throw new JSONException("Empty CSV data");
            }

            // Parse headers
            String[] headers = headerLine.split(delimiter);
            for (int i = 0; i < headers.length; i++) {
                headers[i] = headers[i].trim();
            }
            JSONArray headerArray = new JSONArray();
            for (String header : headers) {
                headerArray.put(header);
            }

            // Read data rows
            List<String[]> rows = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(delimiter);
                // Trim each value
                for (int i = 0; i < values.length; i++) {
                    values[i] = values[i].trim();
                }
                rows.add(values);
            }

            // Create JSON structure
            JSONArray jsonArray = new JSONArray();

            // Convert each row to JSON object
            for (String[] row : rows) {
                JSONObject rowObj = new JSONObject();
                for (int i = 0; i < headers.length && i < row.length; i++) {
                    rowObj.put(headers[i], row[i]);
                }
                jsonArray.put(rowObj);
            }

            // Convert array to object directly
            return jsonArray.toString();

        } catch (Exception e) {
            throw new JSONException("Error parsing CSV: " + e.getMessage());
        }
    }
}