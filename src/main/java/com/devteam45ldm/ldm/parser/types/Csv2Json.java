package com.devteam45ldm.ldm.parser.types;

import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportMappings;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportTemplate;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportedData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

//TODO: Implement this class
public abstract class Csv2Json implements Parser {
    /**
     * Static parse method as required by the Parser interface
     */
    public static ImportedData parse(String csv, ImportTemplate importTemplate) throws JSONException {
        try {
            ImportMappings mappings = importTemplate.getData();
            String[] sections = splitCsvSections(csv, importTemplate);

            JSONObject metadataJson = processMetadataSection(sections[0], mappings);
            JSONObject dataJson = processDataSection(sections[1], mappings);

            ImportedData importedData = new ImportedData();
            importedData.setMetadata(metadataJson.toString());
            importedData.setData(dataJson.toString());

            return importedData;
        } catch (IOException e) {
            throw new JSONException("Error processing CSV: " + e.getMessage());
        }
    }

    /**
     * Split CSV content into metadata and data sections
     *
     * @param csv
     * @return array containing metadata and data sections
     * @throws IOException
     */
    private static String[] splitCsvSections(String csv, ImportTemplate importTemplate) throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader(csv));
        StringBuilder metadataBuilder = new StringBuilder();
        StringBuilder dataBuilder = new StringBuilder();
        String line;
        boolean isMetadataSection = true;

        Pattern metadataPattern = importTemplate.getData().getMetadataPattern();

        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }

            // Check if line matches metadata pattern
            if (metadataPattern != null && !metadataPattern.matcher(line).matches()) {
                isMetadataSection = false;
            }

            if (isMetadataSection) {
                metadataBuilder.append(line).append("\n");
            }
            else {
                dataBuilder.append(line).append("\n");
            }
        }

        return new String[] {metadataBuilder.toString(), dataBuilder.toString()};
    }

    /**
     * Processes the metadata section of the CSV and converts it to JSON
     *
     * @param metadataSection
     * @param mappings
     * @return JSON object containing the processed metadata
     * @throws JSONException
     */
    private static JSONObject processMetadataSection (String metadataSection, ImportMappings mappings) throws JSONException {
        JSONObject metadataJson = new JSONObject();
        String separator = mappings.getMetadataSeparator();

        if (separator == null || separator.isEmpty()) {
            separator = ","; // Default separator
        }

        BufferedReader reader = new BufferedReader(new StringReader(metadataSection));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split(Pattern.quote(separator));
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    value = value.replaceAll("^\"|\"$", ""); // Remove quotes
                    metadataJson.put(key, value);
                }
            }
        } catch (IOException e) {
            throw new JSONException("Error reading metadata section" + e.getMessage());
        }
        return metadataJson;
    }

    private static JSONObject processDataSection (String dataSection, ImportMappings mappings) throws JSONException {
        JSONObject dataJson = new JSONObject();
        String separator = mappings.getDataSeparator();

        if (separator == null || separator.isEmpty()) {
            separator = ",";
        }

        try  {
            List<String[]> rows = parseCsvData(dataSection, separator);
            if (rows.isEmpty()) {
                return dataJson;
            }

            // First row contains headers
            String[] headers = rows.get(0);
            JSONArray dataArray = new JSONArray();

            // Process remaining rows
            for (int i = 0; i < rows.size(); i++) {
                String[] row = rows.get(i);
                JSONObject rowJson = new JSONObject();

                for (int j = 0; j < Math.min(headers.length, row.length);j++) {
                    String header = headers[j].trim();
                    String value = row[j].trim();
                    // Remove quotes
                    value = value.replaceAll("^\"|\"$", "");
                    rowJson.put(header, row);
                }
                dataArray.put(rowJson);
            }
            dataJson.put("data", dataArray);
        } catch (IOException e) {
            throw new JSONException ("Error processing data: " + e.getMessage());
        }

        return dataJson;
    }

    /**
     * Parses CSV data into a list of string arrays.
     *
     * @param csvData
     * @param separator
     * @return list of string arrays containing the parsed data
     * @throws IOException
     */
    private static List<String[]> parseCsvData (String csvData, String separator) throws IOException {
        List<String[]> rows = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new StringReader(csvData));
        String line;

        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }

            // Handle quoted values
            List<String> values = new ArrayList<>();
            StringBuilder currentValue = new StringBuilder();
            boolean inQuotes = false;

            for (char c : line.toCharArray()) {
                if (c == '"') {
                    inQuotes = !inQuotes;
                }
                else if (c == separator.charAt(0) && !inQuotes) {
                    values.add(currentValue.toString());
                    currentValue = new StringBuilder();
                }
                else {
                    currentValue.append(c);
                }
            }
            values.add(currentValue.toString());

            rows.add(values.toArray(new String[0]));
        }
        return rows;
    }
}