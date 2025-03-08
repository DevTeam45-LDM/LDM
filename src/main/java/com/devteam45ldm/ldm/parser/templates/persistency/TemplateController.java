package com.devteam45ldm.ldm.parser.templates.persistency;

import com.devteam45ldm.ldm.parser.ParserController;
import com.devteam45ldm.ldm.parser.templates.Template;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
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

    public abstract void createTemplate(Template template);
    public abstract void modifyTemplate(int id, Template template);
    public abstract void deleteTemplate(int id);
}
