package com.devteam45ldm.ldm.parser;

import com.devteam45ldm.ldm.parser.templates.exportDataStructures.ExportTemplate;

public class ExportTemplateCreator {

    private ExportTemplate exportTemplate;

    public ExportTemplateCreator() {
        this.exportTemplate = new ExportTemplate();
    }

    public ExportTemplate getExportTemplate() {
        return exportTemplate;
    }
}
