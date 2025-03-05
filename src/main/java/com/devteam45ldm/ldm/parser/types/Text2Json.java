package com.devteam45ldm.ldm.parser.types;

import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportParserMappings;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Text2Json {
    public static String parse(String text, ImportParserMappings importParserMappings) {
        String lineStarter = importParserMappings.getLineStarter();
        String delimiter = importParserMappings.getDelimiter();
        String terminator = importParserMappings.getTerminator();
        String assignments = importParserMappings.getAssignments();

        Map<String, String> resultMap = new HashMap<>();
        String[] lines = text.split(terminator);

        for (String line : lines) {
            if (line.startsWith(lineStarter)) {
                String[] keyValuePairs = line.substring(lineStarter.length()).split(delimiter);
                for (String pair : keyValuePairs) {
                    String[] keyValue = pair.split(assignments, 2);
                    if (keyValue.length == 2) {
                        resultMap.put(keyValue[0].trim(), keyValue[1].trim());
                    }
                }
            }
        }

        JSONObject jsonObject = new JSONObject(resultMap);
        return jsonObject.toString();
    }
}
