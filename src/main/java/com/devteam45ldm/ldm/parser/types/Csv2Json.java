package com.devteam45ldm.ldm.parser.types;

import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportTemplate;

//TODO: Implement this class
public class Csv2Json {
    private ImportTemplate importTemplate;

    public Csv2Json(ImportTemplate importTemplate) {
        this.importTemplate = importTemplate;
    }

    public String convert(String csv) {
        // Implement CSV to JSON conversion logic
        return importTemplate.toJson();
    }
}