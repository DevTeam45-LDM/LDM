package com.devteam45ldm.ldm.parser.types;

import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportParserMappings;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

/**
 * Class to convert CSV data to JSON format
 */
public class Csv2Json {

    /**
     * Parses the CSV data using the provided ImportParserMappings
     *
     * @param csv the CSV data to parse
     * @param importParserMappings the ImportParserMappings to use for parsing
     *                             (contains delimiter, hasHeadline, totalColumns)
     * @return the resulting JSON string
     * @throws JSONException if there is an error parsing the JSON
     * @throws IOException if there is an error reading the CSV data
     */
    public static String parse(String csv, ImportParserMappings importParserMappings) throws JSONException, IOException {
        String delimiter;

        if (importParserMappings.getDelimiter() != null && !importParserMappings.getDelimiter().isEmpty()) {
            delimiter = importParserMappings.getDelimiter();
        } else {
            throw new JSONException("No delimiter found in mappings");
        }

        Boolean hasHeadline = importParserMappings.getHasHeadline();
        if (hasHeadline == null) {
            hasHeadline = false;
        }

        try {
            BufferedReader reader = new BufferedReader(new StringReader(csv));
            String firstLine = reader.readLine();
            if (firstLine == null) {
                throw new JSONException("Empty CSV data");
            }

            String[] headers;
            List<String[]> rows = new ArrayList<>();

            if (hasHeadline) {
                headers = firstLine.split(delimiter, -1);
                for (int i = 0; i < headers.length; i++) {
                    headers[i] = headers[i].trim();
                }

                readLine(delimiter, reader, rows);
            } else {
                String[] firstRow = firstLine.split(delimiter, -1);
                int amountOfColumns = importParserMappings.getTotalColumns() != null ? importParserMappings.getTotalColumns() : firstRow.length;
                headers = new String[amountOfColumns];
                for (int i = 0; i < amountOfColumns; i++) {
                    headers[i] = "column" + (i + 1);
                }
                rows.add(firstRow);

                readLine(delimiter, reader, rows);
            }

            List<Map<String, Object>> orderedRows = new ArrayList<>();
            int totalColumns = importParserMappings.getTotalColumns() != null ? importParserMappings.getTotalColumns() : headers.length;

            for (String[] row : rows) {
                Map<String, Object> orderedMap = new LinkedHashMap<>();
                for (int i = 0; i < totalColumns; i++) {
                    if (i < row.length) {
                        if (i == totalColumns - 1 && row.length > totalColumns) {
                            List<String> extraValues = new ArrayList<>(Arrays.asList(row).subList(i, row.length));
                            orderedMap.put(headers[i], extraValues);
                        } else {
                            orderedMap.put(headers[i], row[i]);
                        }
                    } else {
                        orderedMap.put(headers[i], null);
                    }
                }
                orderedRows.add(orderedMap);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(orderedRows);
        } catch (IOException e) {
            throw new IOException("Error reading CSV data");
        }
    }

    private static void readLine(String delimiter, BufferedReader reader, List<String[]> rows) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] rowValues = line.split(delimiter, -1);
            for (int i = 0; i < rowValues.length; i++) {
                rowValues[i] = rowValues[i].trim();
            }
            rows.add(rowValues);
        }
    }
}