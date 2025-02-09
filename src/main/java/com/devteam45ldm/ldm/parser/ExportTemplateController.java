package com.devteam45ldm.ldm.parser;

import com.devteam45ldm.ldm.parser.templates.exportDataStructures.ExportTemplate;

//TODO: Implement this class analogous to ImportTemplateController
public class ExportTemplateController {

    private ExportTemplate exportTemplate;

    public ExportTemplateController() {
        this.exportTemplate = new ExportTemplate();
    }

    public ExportTemplate getExportTemplate() {
        return exportTemplate;
    }
}
