package com.devteam45ldm.ldm.parser;

import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportTemplate;

public class ImportTemplateController implements TemplateManager {
    private ImportTemplate importTemplate;

    public ImportTemplateController() {
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
