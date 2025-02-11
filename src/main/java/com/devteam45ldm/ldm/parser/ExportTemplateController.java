package com.devteam45ldm.ldm.parser;

import com.devteam45ldm.ldm.parser.templates.exportDataStructures.ExportTemplate;

//TODO: Implement this class analogous to ImportTemplateController
public class ExportTemplateController implements TemplateManager {

    private ExportTemplate exportTemplate;

    public ExportTemplateController() {
        this.exportTemplate = new ExportTemplate();
    }

    public ExportTemplate getExportTemplate() {
        return exportTemplate;
    }

    @Override
    public void createTemplate() {
        //TODO: Implement this method: Create and save a new import template in MongoDB
    }

    @Override
    public void modifyTemplate() {
        //TODO: Implement this method: Modify an existing import template in MongoDB and save it as a new version of it (increment version number)
    }

    @Override
    public void deleteTemplate() {
        //TODO: Implement this method: Delete an existing import template in MongoDB (only one version or hole template)
    }
}
