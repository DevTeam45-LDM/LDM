package com.devteam45ldm.ldm.parser;

import com.devteam45ldm.ldm.parser.templates.exportDataStructures.ExportTemplate;

public class ExportTemplateManager {

    private ExportTemplate exportTemplate;

    public ExportTemplateManager() {
        this.exportTemplate = new ExportTemplate();
    }

    public ExportTemplate getExportTemplate() {
        return exportTemplate;
    }
}
