package com.devteam45ldm.ldm.parser.templates.persistency;

import com.devteam45ldm.ldm.parser.ParserController;
import com.devteam45ldm.ldm.parser.templates.Template;

//TODO: Implement this class analogous to ImportTemplateController
public class ExportTemplateController extends TemplateController {

    //use getExportCollection() to get the collection where the template should be

    public void createTemplate(Template template) {
        //TODO: Implement this method: Create and save a new import template in MongoDB (verison 1)
        //Last_modified_by and created_by should be set to the user who created the template
        //last_modified_at and created_at should be set to the current date and time
    }

    public Template readTemplate(int id) {
        //TODO: Implement this method: Read an existing import template from MongoDB (latest version)
        return null;
    }

    public Template readTemplate(int id, int version) {
        //TODO: Implement this method: Read an existing import template from MongoDB (specific version)
        return null;
    }

    public void modifyTemplate(int id, Template template) {
        //TODO: Implement this method: Modify an existing import template in MongoDB and save it as a new version of it (increment version number)
        //metadata.id should be the same as the id parameter (do not change it)
        //created_by and created_at should not be changed
        //last_modified_by and last_modified_at should be set to the user who modified the template and the current date and time
    }

    public void deleteTemplate(int id) {
        //TODO: Implement this method: Delete an existing import template in MongoDB (only one version or hole template)
    }
}
