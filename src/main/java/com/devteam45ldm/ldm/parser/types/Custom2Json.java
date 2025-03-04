package com.devteam45ldm.ldm.parser.types;

import com.devteam45ldm.ldm.parser.ParserController;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportMappings;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportParserMappings;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportTemplate;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportedData;
import com.fasterxml.jackson.databind.ObjectMapper;
import netscape.javascript.JSException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TODO: Implement this class
public class Custom2Json {

    public static ImportedData parser(String custom, ImportTemplate importTemplate) throws Exception {
        // Implement custom format to JSON conversion logic
        ImportedData result = new ImportedData();
        String fileType = importTemplate.getMetadata().getDatatype();

        // Extract and prepare metadata content
        String metadataContent = extractContent(custom, importTemplate.getMappings().getMetadata(), fileType);
        if (metadataContent != null && !metadataContent.isEmpty()) {
            // Handle case where no specific parser is set for metadata
            if (importTemplate.getMetadataParserType() == null ||
                    importTemplate.getMetadataParserType() == ParserController.ParserType.CUSTOM) {
                result.metadata(convertToJson(metadataContent, importTemplate.getMappings().getMetadata()));
            } else {
                // Create a temporary import template for the metadata section
                ImportTemplate metadataTemplate = createSectionTemplate(
                        importTemplate, importTemplate.getMappings().getMetadata(), true);
                // Use ParserController to parse the metadata
                ImportedData metadataResult = ParserController.importParser(metadataContent, metadataTemplate);
                result.metadata(metadataResult.getMetadata());
            }
        }

        // Extract and prepare data content
        String dataContent = extractContent(custom, importTemplate.getMappings().getData(), fileType);
        if (dataContent != null && !dataContent.isEmpty()) {
            // Handle case where no specific parser is set for data
            if (importTemplate.getDataParserType() == null ||
                    importTemplate.getDataParserType() == ParserController.ParserType.CUSTOM) {
                result.data(convertToJson(dataContent, importTemplate.getMappings().getData()));
            } else {
                // Create a temporary import template for the data section
                ImportTemplate dataTemplate = createSectionTemplate(
                        importTemplate, importTemplate.getMappings().getData(), false);
                // Use ParserController to parse the data
                ImportedData dataResult = ParserController.importParser(dataContent, dataTemplate);
                result.data(dataResult.getData());
            }
        }

        return result;
    }

    /**
     * Extracts content from the input data based on the mappings.
     * This method handles all format types using the parameters defined in ImportParserMappings,
     * with format-specific behavior only when needed and not overriding explicit settings.
     *
     * @param data the input data
     * @param mappings the mappings defining how to extract the content
     * @param fileType the type of file being parsed (for format-specific handling when no explicit config)
     * @return the extracted content
     * @throws IOException if there is an error reading the data
     */
    private static String extractContent(String data, ImportParserMappings mappings, String fileType) throws IOException {
        if (data == null || data.isEmpty() || mappings == null) { return null; }

        Pattern pattern = mappings.getPattern();
        String lineStarter = mappings.getLineStarter();
        Integer skipLines = mappings.getSkipLinesAfterHeader();
        String delimiter = mappings.getDelimiter();
        Integer totalColumns = mappings.getTotalColumns();
        String terminator = mappings.getTerminator();

        // Only apply format defaults for parameters that weren't explicitly set
        if (fileType != null) {
            applyFormatDefaults(mappings, fileType);

            // Re-get parameters in case defaults were applied
            if (pattern == null) pattern = mappings.getPattern();
            if (lineStarter == null) lineStarter = mappings.getLineStarter();
            if (skipLines == null) skipLines = mappings.getSkipLinesAfterHeader();
            if (delimiter == null) delimiter = mappings.getDelimiter();
            if (totalColumns == null) totalColumns = mappings.getTotalColumns();
            if (terminator == null) terminator = mappings.getTerminator();
        }

        BufferedReader reader = new BufferedReader(new StringReader(data));
        StringBuilder result = new StringBuilder();
        String line;
        boolean sectionFound = (pattern == null); // If no patterns specified, start extracting immediately
        int linesSkipped = 0;

        while ((line = reader.readLine()) != null) {
            // Skip empty lines if appropriate
            if (line.trim().isEmpty()) { continue; }

            // Pattern-based section detection
            if (!sectionFound && pattern != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    sectionFound = true;
                    // Don't include the pattern line
                    continue;
                }
                continue; // Skip lines until section is found
            }

            // Check if we've reached another section marker when in a pattern-based section
            if (sectionFound && pattern != null && line.matches("\\[.*\\]")) {
                break; // End of this section
            }

            // Skip lines after header if specified
            if (sectionFound && skipLines != null && skipLines > 0 && linesSkipped < skipLines) {
                linesSkipped++;
                continue;
            }

            // Line starter filtering - only include lines that start with the specified prefix
            if (sectionFound && lineStarter != null && !line.startsWith(lineStarter)) {
                continue;
            }

            // Skip comment lines in certain formats (if not overridden by lineStarter)
            if (sectionFound && lineStarter == null && fileType != null) {
                if (("dat".equalsIgnoreCase(fileType) || "ini".equalsIgnoreCase(fileType)) &&
                        (line.startsWith(";") || line.startsWith("#"))) {
                    continue;
                }
            }

            // Process columns if needed
            if (sectionFound && totalColumns != null && totalColumns > 0 && delimiter != null) {
                line = processLineColumns(line, totalColumns, delimiter);
            }

            // Add the processed line to the result
            result.append(line);

            // Add the appropriate line terminator
            if (terminator != null) {
                result.append(terminator);
            } else {
                result.append("\n");
            }
        }

        return result.toString();
    }

    /**
     * Applies format-specific default settings to the mappings if they're not already set.
     * This provides sensible defaults based on the file type, but ONLY for parameters
     * that haven't been explicitly set by the user.
     *
     * @param mappings the mappings to potentially modify
     * @param fileType the type of file being parsed
     */
    private static void applyFormatDefaults(ImportParserMappings mappings, String fileType) throws IOException {
        if (fileType == null) { return; }

        // Apply defaults based on file type, but only for settings that aren't already defined
        switch(fileType.toLowerCase()) {
            case "dat":
                // DAT files typically use comma as delimiter
                if (mappings.getDelimiter() == null) {
                    mappings.setDelimiter(",");
                }
                break;

            case "csv":
                // CSV files typically use comma as delimiter
                if (mappings.getDelimiter() == null) {
                    mappings.setDelimiter(",");
                }
                break;

            case "tsv":
                // TSV files typically use tab as delimiter
                if (mappings.getDelimiter() == null) {
                    mappings.setDelimiter("\t");
                }
                break;

            case "ini":
                // INI files typically use equals sign as delimiter
                if (mappings.getDelimiter() == null) {
                    mappings.setDelimiter("=");
                }
                break;
            // Add more file types as needed
        }
    }

    /**
     * Processes a line to ensure it has the specified number of columns.
     *
     * @param line the line to process
     * @param totalColumns the total number of columns the line should have
     * @param delimiter the delimiter used to separate columns
     * @return the processed line
     */
    private static String processLineColumns(String line, int totalColumns, String delimiter) {
        String[] columns = line.split(delimiter, -1);

        if (columns.length == totalColumns) {
            return line; // No modification needed
        } else if (columns.length < totalColumns) {
            // Pad with null values if too few columns
            StringBuilder paddedLine = new StringBuilder(line);
            for (int i = columns.length; i < totalColumns; i++) {
                paddedLine.append(delimiter).append("null");
            }
            return paddedLine.toString();
        } else {
            // Too many columns, combine excess columns into the last column
            StringBuilder truncatedLine = new StringBuilder();
            for (int i = 0; i < totalColumns; i++) {
                truncatedLine.append(columns[i]).append(delimiter);
            }

            // Combine remaining columns into the last column
            StringBuilder lastColumn = new StringBuilder(columns[totalColumns - 1]);
            for (int i = totalColumns; i < columns.length; i++) {
                lastColumn.append(delimiter).append(columns[i]);
            }
            truncatedLine.append(lastColumn);

            return truncatedLine.toString();
        }
    }

    /**
     * Converts the extracted content to a JSON string based on the mappings.
     * This is used only when no specific parser type is set or the type is CUSTOM.
     *
     * @param content the content to convert
     * @param mappings the mappings defining how to convert the content
     * @return the JSON string representation
     * @throws JSONException if there is an error creating the JSON
     */
    private static String convertToJson(String content, ImportParserMappings mappings) throws JSONException{
        if (content == null || content.isEmpty()) { return null; }

        String delimiter = mappings.getDelimiter();
        String assignments = mappings.getAssignments();
        Boolean hasHeadline = mappings.getHasHeadline();

        if (delimiter != null) {
            // CSV-like content with a delimiter
            return convertDelimitedContentToJson(content, delimiter, hasHeadline);
        } else if (assignments != null) {
            // Key-value like content with assignments
            return convertKeyValueContentToJson(content, assignments);
        } else {
            // Plain text content
            return new JSONObject().put("content", content).toString();
        }
    }

    /**
     * Creates a template for parsing a specific section of the data.
     *
     * @param originalTemplate the original import template
     * @param mappings the mappings for the section
     * @param isMetadata whether this is for metadata or data
     * @return a new import template for the section
     */
    private static ImportTemplate createSectionTemplate(ImportTemplate originalTemplate,
                                                        ImportParserMappings mappings,
                                                        boolean isMetadata) {
        ImportTemplate sectionTemplate = new ImportTemplate();
        sectionTemplate.metadata(originalTemplate.getMetadata());

        // Create appropriate mappings for the section template
        ImportMappings newMappings = new ImportMappings();
        if (isMetadata) {
            // For metadata section, set the metadata mappings
            newMappings.metadata(mappings);
            // Set parser type for metadata
            ParserController.ParserType parserType = originalTemplate.getMetadataParserType();
            sectionTemplate.metadataParserType(parserType);
            sectionTemplate.dataParserType(parserType);
        } else {
            // For data section, set the data mappings
            newMappings.data(mappings);
            // Set parser type for data
            ParserController.ParserType parserType = originalTemplate.getDataParserType();
            sectionTemplate.metadataParserType(parserType);
            sectionTemplate.dataParserType(parserType);
        }

        // Set the mappings on the template
        sectionTemplate.mappings(newMappings);

        return sectionTemplate;
    }

    /**
     * Converts delimited content to a JSON string with preserved column order using Jackson.
     *
     * @param content the delimited content
     * @param delimiter the delimiter used in the content
     * @param hasHeadline whether the content has a headline row
     * @return the JSON string representation with preserved column order
     * @throws JSONException if there is an error creating the JSON
     */
    private static String convertDelimitedContentToJson(String content, String delimiter, Boolean hasHeadline) throws JSONException {
        BufferedReader reader = new BufferedReader(new StringReader(content));
        List<Map<String, String>> rows = new ArrayList<>();
        String[] headers = null;
        String line;

        try {
            // Read header or first data line
            if ((line = reader.readLine()) != null) {
                String[] firstRow = line.split(delimiter, -1);

                // If it has headline, use first row as headers
                if (Boolean.TRUE.equals(hasHeadline)) {
                    headers = firstRow;
                } else {
                    // Generate column names
                    headers = new String[firstRow.length];
                    for (int i = 0; i < firstRow.length; i++) {
                        headers[i] = "column" + (i + 1);
                    }

                    // Add first row as data
                    Map<String, String> firstRowMap = new LinkedHashMap<>();
                    for (int i = 0; i < headers.length; i++) {
                        firstRowMap.put(headers[i], firstRow[i]);
                    }
                    rows.add(firstRowMap);
                }

                // Read remaining rows
                while ((line = reader.readLine()) != null) {
                    if (!line.trim().isEmpty()) {
                        String[] rowValues = line.split(delimiter, -1);
                        Map<String, String> rowMap = new LinkedHashMap<>();

                        for (int i = 0; i < headers.length && i < rowValues.length; i++) {
                            rowMap.put(headers[i], rowValues[i]);
                        }

                        // Handle any missing values
                        for (int i = rowValues.length; i < headers.length; i++) {
                            rowMap.put(headers[i], null);
                        }

                        rows.add(rowMap);
                    }
                }
            }

            // Use Jackson to serialize while preserving order
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(rows);
        } catch (IOException e) {
            throw new JSONException("Error reading content: " + e.getMessage());
        }
    }

    /**
     * Converts key-value content to a JSON string using Jackson to preserve key order.
     *
     * @param content the key-value content
     * @param assignment the assignment operator used in the content
     * @return the JSON string representation that preserves key order
     * @throws JSONException if there is an error creating the JSON
     */
    private static String convertKeyValueContentToJson(String content, String assignment)
            throws JSONException {

        BufferedReader reader = new BufferedReader(new StringReader(content));
        // Use LinkedHashMap to preserve insertion order of keys
        Map<String, String> orderedMap = new LinkedHashMap<>();
        String line;

        try {
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty() && !line.startsWith(";") && !line.startsWith("//") && !line.startsWith("#")) {
                    int assignmentIndex = line.indexOf(assignment);
                    if (assignmentIndex > 0) {
                        String key = line.substring(0, assignmentIndex).trim();
                        String value = line.substring(assignmentIndex + assignment.length()).trim();
                        orderedMap.put(key, value);
                    }
                }
            }

            // Use Jackson to serialize while preserving order from LinkedHashMap
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(orderedMap);

        } catch (IOException e) {
            throw new JSONException("Error reading content: " + e.getMessage());
        }
    }
}