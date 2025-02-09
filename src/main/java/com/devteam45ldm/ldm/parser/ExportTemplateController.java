package com.devteam45ldm.ldm.parser;

import com.devteam45ldm.ldm.parser.templates.exportDataStructures.ExportTemplate;

public class ExportTemplateController {

    private ExportTemplate exportTemplate;

    public ExportTemplateController() {
        this.exportTemplate = new ExportTemplate();
    }

    public ExportTemplate getExportTemplate() {
        return exportTemplate;
    }
}
