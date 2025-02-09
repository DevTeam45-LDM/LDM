package com.devteam45ldm.ldm.parser;

import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportTemplate;

public class ImportTemplateCreator {
    private ImportTemplate importTemplate;

    public CreateImportTemplate() {
        this.importTemplate = new ImportTemplate();
    }

    public ImportTemplate getImportTemplate() {
        return importTemplate;
    }
}
