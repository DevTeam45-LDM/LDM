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
            String firstline = reader.readLine();
            if (firstline == null) {
                throw new JSONException("Empty CSV data");
            }

            String[] headers;
            List<String[]> rows = new ArrayList<>();

            if (hasHeadline) {
                headers = firstline.split(delimiter, -1);
                for (int i = 0; i < headers.length; i++) {
                    headers[i] = headers[i].trim();
                }

                String line;
                while ((line = reader.readLine()) != null) {
                    String[] rowValues = line.split(delimiter, -1);
                    for (int i = 0; i < rowValues.length; i++) {
                        rowValues[i] = rowValues[i].trim();
                    }
                    rows.add(rowValues);
                }
            } else {
                String[] firstRow = firstline.split(delimiter, -1);
                int amountOfColumns = importParserMappings.getTotalColumns() != null ? importParserMappings.getTotalColumns() : firstRow.length;
                headers = new String[amountOfColumns];
                for (int i = 0; i < amountOfColumns; i++) {
                    headers[i] = "column" + (i + 1);
                }
                rows.add(firstRow);

                String line;
                while ((line = reader.readLine()) != null) {
                    String[] rowValues = line.split(delimiter, -1);
                    for (int i = 0; i < rowValues.length; i++) {
                        rowValues[i] = rowValues[i].trim();
                    }
                    rows.add(rowValues);
                }
            }

            List<Map<String, Object>> orderedRows = new ArrayList<>();
            int totalColumns = importParserMappings.getTotalColumns() != null ? importParserMappings.getTotalColumns() : headers.length;

            for (String[] row : rows) {
                Map<String, Object> orderedMap = new LinkedHashMap<>();
                for (int i = 0; i < totalColumns; i++) {
                    if (i < row.length) {
                        if (i == totalColumns - 1 && row.length > totalColumns) {
                            List<String> extraValues = new ArrayList<>();
                            for (int j = i; j < row.length; j++) {
                                extraValues.add(row[j]);
                            }
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
}