package com.devteam45ldm.ldm.parser.types;

import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportParserMappings;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
    public static String parse(String csv, ImportParserMappings importParserMappings) throws JSONException, IOException {
        String delimiter;

        if (importParserMappings.getDelimiter() != null && !importParserMappings.getDelimiter().isEmpty()) {
            delimiter = importParserMappings.getDelimiter();
        } else {
            throw new JSONException("No delimiter found in mappings");
        }

        // Determine if CSV has a headline row
        Boolean hasHeadline = importParserMappings.getHasHeadline();
        if (hasHeadline == null) {
            hasHeadline = false;
        }

        try {
            BufferedReader reader = new BufferedReader((new StringReader(csv)));
            String firstline = reader.readLine();
            if (firstline == null) {
                throw new JSONException("Empty CSV data");
            }

            String[] headers;
            List<String[]> rows = new ArrayList<>();

            // Parse headers or generate column names if no header
            if (hasHeadline) {
                // Use first line as headers
                headers = firstline.split(delimiter, -1);
                for (int i = 0; i < headers.length; i++) {
                    headers[i] = headers[i].trim();
                }

                // Read data rows
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] rowValues = line.split(delimiter, -1);
                    for (int i = 0; i < rowValues.length; i++) {
                        rowValues[i] = rowValues[i].trim();
                    }
                    rows.add(rowValues);
                }
            } else {
                // Generate column names and add first line as data
                String[] firstRow = firstline.split(delimiter, -1);
                headers = new String[firstRow.length];
                for (int i = 0; i < firstRow.length; i++) {
                    headers[i] = "column" + (i + 1);
                    firstRow[i] = firstRow[i].trim();
                }
                rows.add(firstRow);

                // Read additional data rows
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] rowValues = line.split(delimiter, -1);
                    // Trim all values
                    for (int i = 0; i < rowValues.length; i++) {
                        rowValues[i] = rowValues[i].trim();
                    }
                    rows.add(rowValues);
                }
            }
            // Convert to List of ordered maps for serialization
            List<Map<String, String>> orderedRows = new ArrayList<>();

            for (String[] row : rows) {
                Map<String, String> orderedMap = new LinkedHashMap<>();
                for (int i = 0; i < headers.length && i < row.length; i++) {
                    orderedMap.put(headers[i], row[i]);
                }
                orderedRows.add(orderedMap);
            }

            // Use Jackson to preserve the order
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(orderedRows);
        } catch (IOException e) {
            throw new IOException("Error reading CSV data");
        }
    }
}