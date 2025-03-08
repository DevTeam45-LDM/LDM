package com.devteam45ldm.ldm.parser.templates.persistency;

import com.devteam45ldm.ldm.parser.ParserController;
import com.devteam45ldm.ldm.parser.templates.Template;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public abstract class TemplateController {

    @Autowired
    private MongoTemplate mongoTemplate;
    private final String importCollection = "importTemplates";
    private final String exportCollection = "exportTemplates";
    private final MongoDatabase database;

    public TemplateController() {
        this.database = mongoTemplate.getDb();
        checkAndCreateCollections();
    }

    private void checkAndCreateCollections() {
        Set<String> collections = new HashSet<>();
        database.listCollectionNames().iterator().forEachRemaining(collections::add);

        if (!collections.contains(importCollection)) {
            database.createCollection(importCollection);
        }
        if (!collections.contains(exportCollection)) {
            database.createCollection(exportCollection);
        }
    }
    
    public String getImportCollection() {
        return importCollection;
    }
    
    public String getExportCollection() {
        return exportCollection;
    }

    /**
     * Gets the next available import template ID.
     *
     * @return the next available import template ID
     */
    public int getNextImportTemplateId() {
        Query query = new Query();
        query.with(Sort.by(Sort.Order.desc("metadata.id")));
        query.limit(1);
        Template template = mongoTemplate.findOne(query, Template.class, importCollection);
        return template != null && template.getMetadata() != null ? template.getMetadata().getId() + 1 : 1;
    }

    /**
     * Gets the next available export template ID.
     *
     * @return the next available export template ID
     */
    public int getNextExportTemplateId() {
        Query query = new Query();
        query.with(Sort.by(Sort.Order.desc("metadata.id")));
        query.limit(1);
        Template template = mongoTemplate.findOne(query, Template.class, exportCollection);
        return template != null && template.getMetadata() != null ? template.getMetadata().getId() + 1 : 1;
    }

    /**
     * Creates a new template.
     *
     * @param template the template to create
     */
    public abstract void createTemplate(Template template);

    /**
     * Reads a template with a specific version.
     *
     * @param id the ID of the template to read
     * @param version the version of the template to read
     * @return the template
     */
    public abstract Template readTemplate(int id, int version);

    /**
     * Reads a template with the latest version.
     *
     * @param id the ID of the template to read
     * @return the template
     */
    public abstract Template readTemplate(int id);

    /**
     * Modifies a template.
     *
     * @param id the ID of the template to modify
     * @param template the template to modify
     */
    public abstract void modifyTemplate(int id, Template template);

    /**
     * Deletes a template.
     *
     * @param id the ID of the template to delete
     */
    public abstract void deleteTemplate(int id);
}
