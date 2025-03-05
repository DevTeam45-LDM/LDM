package com.devteam45ldm.ldm.parser.types;

import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportTemplate;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportedData;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TODO: Implement this class
public class Custom2Json {

    public static ImportedData parse(String data, ImportTemplate importTemplate) {
        Map<String, String> splittedFile = splitFile(data, importTemplate.getMappings().getData().getPattern(), importTemplate.getMappings().getMetadata().getPattern());
        return new ImportedData();
    }

    public static Map<String, String> splitFile(String fileContent, Pattern dataPattern, Pattern metadataPattern) {
        Matcher matcher1 = metadataPattern.matcher(fileContent);
        Matcher matcher2 = dataPattern.matcher(fileContent);

        if (matcher1.find() && matcher2.find(matcher1.end())) {
            String metadata = fileContent.substring(0, matcher2.start());
            String data = fileContent.substring(matcher2.start());
            Map<String, String> result = new HashMap<>();
            result.put("metadata", metadata);
            result.put("data", data);
            return result;
        } else {
            throw new IllegalArgumentException("Patterns not found in the file content");
        }
    }

}