package com.devteam45ldm.ldm.parser.types;

import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportTemplate;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportedData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Custom2Json {

    public static ImportedData parse(String data, ImportTemplate importTemplate) {
        ImportedData importedData = new ImportedData();

        //Metadata and Data Sections are defined by strings
        if(!importTemplate.getMappings().getMetadata().isSectionStringEmpty() && !importTemplate.getMappings().getData().isSectionStringEmpty()) {
            importedData.setMetadata(getMetadataSectionByStrings(data, importTemplate.getMappings().getMetadata().getSectionString(), importTemplate.getMappings().getData().getSectionString()));
            importedData.setData(getDataSectionByString(data, importTemplate.getMappings().getData().getSectionString()));
        }
        //Metadata and Data Sections are defined by patterns
        else if(!importTemplate.getMappings().getMetadata().isSectionPatternEmpty() && !importTemplate.getMappings().getData().isSectionPatternEmpty()) {
            importedData.setMetadata(getSectionByPattern(data, importTemplate.getMappings().getMetadata().getSectionPattern()));
            importedData.setData(getSectionByPattern(data, importTemplate.getMappings().getData().getSectionPattern()));
        }
        //Metadata Section is defined by a pattern and Data Section is defined by a string
        else if(!importTemplate.getMappings().getMetadata().isSectionPatternEmpty() && !importTemplate.getMappings().getData().isSectionStringEmpty()) {
            importedData.setMetadata(getSectionByPattern(data, importTemplate.getMappings().getMetadata().getSectionPattern()));
            importedData.setData(getDataSectionByString(data, importTemplate.getMappings().getData().getSectionString()));
        }
        //Metadata Section is defined by a string and Data Section is defined by a pattern
        else if(!importTemplate.getMappings().getMetadata().isSectionStringEmpty() && !importTemplate.getMappings().getData().isSectionPatternEmpty()) {
            importedData.setData(getSectionByPattern(data, importTemplate.getMappings().getData().getSectionPattern()));
            importedData.setMetadata(getMetadataSectionByStrings(data, importTemplate.getMappings().getMetadata().getSectionString(), importedData.getData())); //TODO: NOT CORRECT, Header should be considered
        }
        else {
            throw new IllegalArgumentException("Parser mappings are not set correctly");
        }
        return importedData;
    }

    private static String getSectionByPattern(String fileContent, Pattern pattern) {
        Matcher matcher = pattern.matcher(fileContent);

        if (matcher.find()) {
            return matcher.group();
        } else {
            throw new IllegalArgumentException("Patterns not found in the file content");
        }
    }

    private static String getDataSectionByString(String fileContent, String dataSection) {
        if (fileContent.contains(dataSection)) {
            return fileContent.substring(fileContent.indexOf(dataSection));
        } else {
            throw new IllegalArgumentException("Section not found in the file content");
        }
    }

    private static String getMetadataSectionByStrings(String fileContent, String metadataSection, String dataSection) {
        if (fileContent.contains(metadataSection) && fileContent.contains(dataSection)) {
            return fileContent.substring(fileContent.indexOf(metadataSection), fileContent.indexOf(dataSection));
        } else {
            throw new IllegalArgumentException("Section not found in the file content");
        }
    }
}