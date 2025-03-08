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
    private final MongoDatabase database;

    public TemplateController() {
        this.database = mongoTemplate.getDb();
        checkAndCreateCollections();
    }

    private void checkAndCreateCollections() {
        Set<String> collections = new HashSet<>();
        database.listCollectionNames().iterator().forEachRemaining(collections::add);

        if (!collections.contains("importTemplates")) {
            database.createCollection("importTemplates");
        }
        if (!collections.contains("exportTemplates")) {
            database.createCollection("exportTemplates");
        }
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
        Template template = mongoTemplate.findOne(query, Template.class, "importTemplates");
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
        Template template = mongoTemplate.findOne(query, Template.class, "exportTemplates");
        return template != null && template.getMetadata() != null ? template.getMetadata().getId() + 1 : 1;
    }

    public abstract void createTemplate(Template template);
    public abstract void modifyTemplate(int id, Template template);
    public abstract void deleteTemplate(int id);
}
