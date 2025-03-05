package com.devteam45ldm.ldm.parser.types;

import com.devteam45ldm.ldm.parser.ParserController;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportParserMappings;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportTemplate;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportedData;
import org.json.JSONException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class to convert custom data to JSON format
 */
public class Custom2Json {

    /**
     * Parses the data using the provided ImportTemplate
     * @param data the data to parse
     * @param importTemplate the ImportTemplate to use for parsing
     * @return the ImportedData object containing the parsed metadata and data
     * @throws IllegalArgumentException if the data is empty or the mappings are not set correctly
     * @throws JSONException if there is an error creating the JSON structure
     * @throws ParserConfigurationException if there is an error parsing the XML
     * @throws IOException if there is an error reading the data
     * @throws SAXException if there is an error parsing the XML
     */
    public static ImportedData parse(String data, ImportTemplate importTemplate) throws IllegalArgumentException, JSONException, ParserConfigurationException, IOException, SAXException {
        ImportedData importedData = new ImportedData();
        String metadataSection;
        String dataSection;

        if(data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Data is empty");
        }

        //Metadata and Data Sections are defined by strings
        if(!importTemplate.getMappings().getMetadata().isSectionStringEmpty() && !importTemplate.getMappings().getData().isSectionStringEmpty()) {
            metadataSection = getMetadataSectionByStrings(data, importTemplate.getMappings().getMetadata().getSectionString(), importTemplate.getMappings().getData().getSectionString());
            dataSection = getDataSectionByString(data, importTemplate.getMappings().getData().getSectionString());
        }
        //Metadata and Data Sections are defined by patterns
        else if(!importTemplate.getMappings().getMetadata().isSectionPatternEmpty() && !importTemplate.getMappings().getData().isSectionPatternEmpty()) {
            metadataSection = getSectionByPattern(data, importTemplate.getMappings().getMetadata().getSectionPattern());
            dataSection = getSectionByPattern(data, importTemplate.getMappings().getData().getSectionPattern());
        }
        //Metadata Section is defined by a pattern and Data Section is defined by a string
        else if(!importTemplate.getMappings().getMetadata().isSectionPatternEmpty() && !importTemplate.getMappings().getData().isSectionStringEmpty()) {
            metadataSection = getSectionByPattern(data, importTemplate.getMappings().getMetadata().getSectionPattern());
            dataSection = getDataSectionByString(data, importTemplate.getMappings().getData().getSectionString());
        }
        //Metadata Section is defined by a string and Data Section is defined by a pattern
        else if(!importTemplate.getMappings().getMetadata().isSectionStringEmpty() && !importTemplate.getMappings().getData().isSectionPatternEmpty()) {
            dataSection = getSectionByPattern(data, importTemplate.getMappings().getData().getSectionPattern());
            metadataSection = getMetadataSectionByStrings(data, importTemplate.getMappings().getMetadata().getSectionString(), importedData.getData()); //TODO: NOT CORRECT, Header should be considered
        }
        else {
            throw new IllegalArgumentException("Parser mappings are not set correctly");
        }

        metadataSection = CommonMethods.skipLines(metadataSection, importTemplate.getMappings().getMetadata().getSkipLines());
        dataSection = CommonMethods.skipLines(dataSection, importTemplate.getMappings().getData().getSkipLines());

        importedData.setMetadata(getParsedData(metadataSection, importTemplate.getMappings().getMetadataParserType(), importTemplate.getMappings().getMetadata()));
        importedData.setData(getParsedData(dataSection, importTemplate.getMappings().getDataParserType(), importTemplate.getMappings().getData()));

        System.out.println(importedData.getData());

        return importedData;
    }

    /**
     * Gets the section of the file content that matches the provided pattern
     * @param fileContent the content of the file
     * @param pattern the pattern to match
     * @return the section of the file content that matches the pattern
     * @throws IllegalArgumentException if the pattern is not found in the file content
     */
    private static String getSectionByPattern(String fileContent, Pattern pattern) throws IllegalArgumentException {
        Matcher matcher = pattern.matcher(fileContent);

        if (matcher.find()) {
            return matcher.group();
        } else {
            throw new IllegalArgumentException("Patterns not found in the file content");
        }
    }

    /**
     * Gets the data section of the file content that matches the provided string
     * @param fileContent the content of the file
     * @param dataSection the string to match
     * @return the data section of the file content that matches the string
     * @throws IllegalArgumentException if the string is not found in the file content
     */
    private static String getDataSectionByString(String fileContent, String dataSection) throws IllegalArgumentException{
        if (fileContent.contains(dataSection)) {
            return fileContent.substring(fileContent.indexOf(dataSection) + dataSection.length());
        } else {
            throw new IllegalArgumentException("Section not found in the file content");
        }
    }

    /**
     * Gets the metadata section of the file content that matches the provided strings
     * @param fileContent the content of the file
     * @param metadataSection the string to match
     * @param dataSection the string to match
     * @return the metadata section of the file content that matches the strings
     * @throws IllegalArgumentException if the strings are not found in the file content
     */
    private static String getMetadataSectionByStrings(String fileContent, String metadataSection, String dataSection) {
        if (fileContent.contains(metadataSection) && fileContent.contains(dataSection)) {
            return fileContent.substring(fileContent.indexOf(metadataSection) + metadataSection.length(), fileContent.indexOf(dataSection));
        } else {
            throw new IllegalArgumentException("Section not found in the file content");
        }
    }

    /**
     * Parses the data section using the provided parser type
     * @param dataSection the data section to parse
     * @param parserType the parser type to use
     * @param importParserMappings the mappings to use for parsing
     * @return the parsed data section
     * @throws IllegalArgumentException if the parser type is not supported
     * @throws JSONException if there is an error creating the JSON structure
     * @throws ParserConfigurationException if there is an error parsing the XML
     * @throws IOException if there is an error reading the data
     * @throws SAXException if there is an error parsing the XML
     */
    private static String getParsedData(String dataSection, ParserController.ParserType parserType, ImportParserMappings importParserMappings) throws IllegalArgumentException, JSONException, ParserConfigurationException, IOException, SAXException {
        return switch (parserType) {
            case JSON -> Json2Json.parse(dataSection, importParserMappings);
            case XML -> Xml2Json.parse(dataSection, importParserMappings);
            case CSV -> Csv2Json.parse(dataSection, importParserMappings);
            case TEXT -> Text2Json.parse(dataSection, importParserMappings);
            default -> throw new IllegalArgumentException("Parser type not supported");
        };
    }
}