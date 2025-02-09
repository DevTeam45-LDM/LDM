package com.devteam45ldm.ldm.parser.types;

import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportTemplate;

//TODO: Implement this class
public class Custom2Json {
    private ImportTemplate importTemplate;

    public Custom2Json(ImportTemplate importTemplate) {
        this.importTemplate = importTemplate;
    }

    public String convert(String custom) {
        // Implement custom format to JSON conversion logic
        return importTemplate.toJson();
    }
}