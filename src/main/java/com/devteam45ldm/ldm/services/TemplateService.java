package com.devteam45ldm.ldm.services;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.types.ObjectId;
import com.devteam45ldm.ldm.data.TemplateData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TemplateService {
    private final MongoClient mongoClient;
    private final MongoDatabase database;
    private final MongoCollection<Document> templateCollection;

    public TemplateService() {
        // Update with your MongoDB connection string
        this.mongoClient = MongoClients.create("mongodb://localhost:27017");
        this.database = mongoClient.getDatabase("ldm-database");
        this.templateCollection = database.getCollection("eLab-templates");
    }

    public void createTemplate(TemplateData template) {
        Document doc = new Document()
                .append("type", "template")
                .append("customId", template.getCustomId())
                .append("category", new Document()
                        .append("type", template.getCategory())
                        .append("possibleCategories", template.getPossibleCategroies()))
                .append("metadata", new Document()
                        .append("createdAt", LocalDate.now().toString())
                        .append("lastModified", LocalDate.now().toString())
                        .append("version", "1.0"))
                .append("status", template.getStatus())
                .append("tags", new Document()
                        .append("suggested", template.getSuggestedTags()))
                .append("permissions", new Document()
                        .append("baseAccess", template.getBaseAccess())
                        .append("availableAccess", template.getAvailableAccess())
                        .append("userGroups", template.getUserGroups())
                        .append("possibleUserGroups", template.getPossibleUserGroups()));

        templateCollection.insertOne(doc);
    }

    // Get all templates
    public List<TemplateData> getAllTemplates() {
        List<TemplateData> templates = new ArrayList<>();
        templateCollection.find().forEach(doc -> {
            templates.add(convertDocumentToTemplate(doc));
        });
        return templates;
    }

    // Update existing template
    public void updateTemplate(String id, TemplateData template) {
        templateCollection.updateOne(
                Filters.eq("_id", new ObjectId(id)),
                Updates.combine(
                        Updates.set("category.type", template.getCategory()),
                        Updates.set("status", template.getStatus()),
                        Updates.set("tags.suggested", template.getSuggestedTags()),
                        Updates.set("permissions.baseAccess", template.getBaseAccess()),
                        Updates.set("permissions.userGroups", template.getUserGroups()),
                        Updates.set("metadata.lastModified", LocalDate.now().toString())
                )
        );
    }

    // Delete template
    public void deleteTemplate(String id) {
        templateCollection.deleteOne(Filters.eq("_id", new ObjectId(id)));
    }

    private TemplateData convertDocumentToTemplate(Document doc) {
        Document category = doc.get("category", Document.class);
        Document metadata = doc.get("metadata", Document.class);
        Document tags = doc.get("tags", Document.class);
        Document permission = doc.get("permission", Document.class);

        return new TemplateData(
                doc.getObjectId("_id").toString(),
                doc.getString("customId"),
                doc.getString("status"),
                category.getString("type"),
                metadata.getString("createdAt"),
                metadata.getString("lastModified"),
                tags.getList("suggested", String.class),
                permission.getString("baseAccess"),
                permission.getList("userGroups", String.class)
        );
    }

    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
