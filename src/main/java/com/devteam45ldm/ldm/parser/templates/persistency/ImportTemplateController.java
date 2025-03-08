package com.devteam45ldm.ldm.parser.templates.persistency;

import com.devteam45ldm.ldm.parser.ParserController;
import com.devteam45ldm.ldm.parser.templates.Metadata;
import com.devteam45ldm.ldm.parser.templates.Template;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportMappings;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportTemplate;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ImportTemplateController extends TemplateController{

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    //use getImportCollection() to get the collection where the template should be

    /**
     * Creates a new template.
     *
     * @param template the template to create
     * @throws IllegalArgumentException if the template is null or if the template's metadata datatype is null
     */
    @Override
    public void createTemplate(Template template) {
        //TODO: Implement this method: Create and save a new import template in MongoDB (verison 1)
        //Last_modified_by and created_by should be set to the user who created the template
        //last_modified_at and created_at should be set to the current date and time

        if (template == null) {
            throw new IllegalArgumentException("template cannot be null");
        }

        Metadata metadata = template.getMetadata();
        // Validate required template properties
        if (metadata.getDatatype() == null) {
            throw new IllegalArgumentException("Template datatype cannot be null");
        }

        // Get the current user and timestamp
        String currentUser = getCurrentUser();
        String currentTimestamp = getCurrentTimestamp();

        // Set metadata field
        metadata.setId(getNextImportTemplateId());
        metadata.setVersion(1);
        metadata.setCreatedBy(currentUser);
        metadata.setCreatedAt(currentTimestamp);
        metadata.setLastModifiedBy(currentUser);
        metadata.setLastModifiedAt(currentTimestamp);

        // Save to MongoDB
        MongoCollection<Document> collection = getImportCollection();
        Document document = convertTemplateToDocument(template);
        collection.insertOne(document);
    }

    /**
     * Reads the latest version of an existing import template from MongoDB
     *
     * @param id the ID of the template to read
     * @return the template with the latest version, or null if not found
     */
    @Override
    public Template readTemplate(int id) {
        //TODO: Implement this method: Read an existing import template from MongoDB (latest version)
        MongoCollection<Document> collection = getImportCollection();

        Bson filter = Filters.eq("metadata.id", id);
        Bson sort = Sorts.descending("metadata.version");

        Document document = collection.find(filter).sort(sort).first();

        if (document == null) {
            return null;
        }
        return convertDocumentToTemplate(document);
    }

    /**
     * Reads the specific version of an existing import template from MongoDB
     *
     * @param id the id of the template to read
     * @param version the version of the template to read
     * @return the template with the specified version, or null if not found
     */
    @Override
    public Template readTemplate(int id, int version) {
        //TODO: Implement this method: Read an existing import template from MongoDB (specific version)
        MongoCollection<Document> collection = getImportCollection();

        Bson filter = Filters.and(
                Filters.eq("metadata.id", id),
                Filters.eq("metadata.version", version)
        );

        Document document = collection.find(filter).first();

        if (document == null) {
            return null;
        }

        return convertDocumentToTemplate(document);
    }

    /**
     * Modifies an existing import template in MongoDB and saves it as a new version.
     *
     * @param id the ID of the template to modify
     * @param template the template to modify
     * @throws IllegalArgumentException if the template is null or if the template with the specified ID is not found
     */
    @Override
    public void modifyTemplate(int id, Template template) {
        //TODO: Implement this method: Modify an existing import template in MongoDB and save it as a new version of it (increment version number)
        //metadata.id should be the same as the id parameter (do not change it)
        //created_by and created_at should not be changed
        //last_modified_by and last_modified_at should be set to the user who modified the template and the current date and time
        if (template == null) {
            throw new IllegalArgumentException("Template cannot be null");
        }

        Metadata metadata = template.getMetadata();
        Template existingTemplate = readTemplate(id);
        if (existingTemplate == null) {
            throw new IllegalArgumentException("Template with ID " + id + " not found");
        }

        metadata.setCreatedBy(existingTemplate.getMetadata().getCreatedBy());
        metadata.setCreatedAt(existingTemplate.getMetadata().getCreatedAt());

        int newVersion = existingTemplate.getMetadata().getVersion() + 1;
        metadata.setVersion(newVersion);
        metadata.setLastModifiedBy(getCurrentUser());
        metadata.setLastModifiedAt(getCurrentTimestamp());

        MongoCollection<Document> collection = getImportCollection();
        Document document = convertTemplateToDocument(template);
        collection.insertOne(document);
    }

    /**
     * Deletes an existing import template in MongoDB.
     *
     * @param id the ID of the template to delete
     */
    @Override
    public void deleteTemplate(int id) {
        //TODO: Implement this method: Delete an existing import template in MongoDB (only one version or hole template)
        MongoCollection<Document> collection = getImportCollection();

        Bson filter = Filters.eq("metadata.id", id);
        collection.deleteMany(filter);
    }

    /**
     * Gets the current user from Spring Security context
     *
     * @return the current authenticated user's name, or "anonymous" if not authenticated
     */
    private String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return authentication.getName();
        }
        return "anonymous";
    }

    /**
     * Gets the current timestamp in the required format
     *
     * @return the current timestamp
     */
    private String getCurrentTimestamp() {
        return LocalDateTime.now().format(DATE_FORMATTER);
    }

    /**
     * Converts a Template object to a MongoDB Document
     * Focuses on correctly storing metadata and preserving mappings
     *
     * @param template the template to convert
     * @return the MongoDB document
     */
    private Document convertTemplateToDocument(Template template) {
        Document document = new Document();

        if (template instanceof ImportTemplate importTemplate) {
            // Convert metadata with careful attention to all fields
            Metadata metadata = importTemplate.getMetadata();
            Document metadataDoc = new Document()
                    .append("id", metadata.getId())
                    .append("version", metadata.getVersion())
                    .append("created_by", metadata.getCreatedBy())
                    .append("created_at", metadata.getCreatedAt())
                    .append("last_modified_by", metadata.getLastModifiedBy())
                    .append("last_modified_at", metadata.getLastModifiedAt())
                    .append("datatype", metadata.getDatatype());

            // Add parser type if present
            if (metadata.getParserType() != null) {
                metadataDoc.append("parser_type", metadata.getParserType().name());
            }

            // Store mappings as a simple structure
            ImportMappings mappings = importTemplate.getMappings();
            Document mappingsDoc = new Document();

            if (mappings != null) {
                // Add parser types if present
                if (mappings.getMetadataParserType() != null) {
                    mappingsDoc.append("metadata_parser_type",
                            mappings.getMetadataParserType().name());
                }
                if (mappings.getDataParserType() != null) {
                    mappingsDoc.append("data_parser_type",
                            mappings.getDataParserType().name());
                }

                // Store metadata and data mappings
                if (mappings.getMetadata() != null) {
                    Document metadataMappingsDoc = Document.parse(mappings.getMetadata().toString());
                    mappingsDoc.append("metadata", metadataMappingsDoc);
                }

                if (mappings.getData() != null) {
                    Document dataMappingsDoc = Document.parse(mappings.getData().toString());
                    mappingsDoc.append("data", dataMappingsDoc);
                }
            }

            document.append("metadata", metadataDoc)
                    .append("mappings", mappingsDoc);
        }

        return document;
    }

    /**
     * Converts a MongoDB Document to a Template object
     * Focuses on correctly restoring metadata and preserving mappings
     *
     * @param document the document to convert
     * @return the template
     */
    private Template convertDocumentToTemplate(Document document) {
        ImportTemplate template = new ImportTemplate();

        // Convert metadata with careful attention to all fields
        Document metadataDoc = (Document) document.get("metadata");
        if (metadataDoc != null) {
            Metadata metadata = new Metadata();
            metadata.setId(metadataDoc.getInteger("id", 0));
            metadata.setVersion(metadataDoc.getInteger("version", 1));
            metadata.setCreatedBy(metadataDoc.getString("created_by"));
            metadata.setCreatedAt(metadataDoc.getString("created_at"));
            metadata.setLastModifiedBy(metadataDoc.getString("last_modified_by"));
            metadata.setLastModifiedAt(metadataDoc.getString("last_modified_at"));
            metadata.setDatatype(metadataDoc.getString("datatype"));

            // Convert parser type if present
            String parserTypeStr = metadataDoc.getString("parser_type");
            if (parserTypeStr != null) {
                try {
                    metadata.setParserType(ParserController.ParserType.valueOf(parserTypeStr));
                } catch (IllegalArgumentException e) {
                    // Log warning but continue
                }
            }

            template.setMetadata(metadata);
        }

        // Convert mappings as a simple structure
        Document mappingsDoc = (Document) document.get("mappings");
        if (mappingsDoc != null) {
            ImportMappings importMappings = new ImportMappings();

            // Convert parser types if present
            String metadataParserTypeStr = mappingsDoc.getString("metadata_parser_type");
            if (metadataParserTypeStr != null) {
                try {
                    importMappings.setMetadataParserType(
                            ParserController.ParserType.valueOf(metadataParserTypeStr));
                } catch (IllegalArgumentException e) {
                    // Log warning but continue
                }
            }

            String dataParserTypeStr = mappingsDoc.getString("data_parser_type");
            if (dataParserTypeStr != null) {
                try {
                    importMappings.setDataParserType(
                            ParserController.ParserType.valueOf(dataParserTypeStr));
                } catch (IllegalArgumentException e) {
                    // Log warning but continue
                }
            }

            template.setMappings(importMappings);
        }

        return template;
    }
}
