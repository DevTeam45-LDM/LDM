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
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static com.devteam45ldm.ldm.CommonMethods.getCurrentTimestamp;
import static com.devteam45ldm.ldm.CommonMethods.getCurrentUser;


@Service
public class ImportTemplateController extends TemplateController<ImportTemplate> {
    public ImportTemplateController() throws IOException {
    }

    //use getImportCollection() to get the collection where the template should be

    /**
     * Creates a new template.
     *
     * @param template the template to create
     * @throws IllegalArgumentException if the template is null or if the template's metadata datatype is null
     */
    @Override
    public void createTemplate(ImportTemplate template) {
        //TODO: Implement this method: Create and save a new import template in MongoDB (version 1)
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
        metadata.id(getNextImportTemplateId())
                .version(1)
                .createdBy(currentUser)
                .createdAt(currentTimestamp)
                .lastModifiedBy(currentUser)
                .lastModifiedAt(currentTimestamp);

        // Save to MongoDB
        MongoCollection<Document> collection = getImportCollection();
        Document document = convertTemplateToDocument(template);
        collection.insertOne(document);
    }

    /**
     * Reads all latest templates from the database.
     *
     * @return the list of latest templates
     */
    @Override
    public List<ImportTemplate> readAllTemplates() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.sort(Sort.by(Sort.Order.desc("metadata.version"))),
                Aggregation.group("metadata.id").first(Aggregation.ROOT).as("latestTemplate"),
                Aggregation.replaceRoot("latestTemplate")
        );

        AggregationResults<ImportTemplate> results = getMongoTemplate().aggregate(aggregation, getImportCollection().getNamespace().getCollectionName(), ImportTemplate.class);
        return results.getMappedResults();
    }

    /**
     * Reads the latest version of an existing import template from MongoDB
     *
     * @param id the ID of the template to read
     * @return the template with the latest version, or null if not found
     */
    @Override
    public ImportTemplate readTemplate(int id) {
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
    public ImportTemplate readTemplate(int id, int version) {
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
    public void modifyTemplate(int id, ImportTemplate template) {
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

        metadata.createdBy(existingTemplate.getMetadata().getCreatedBy())
                .createdAt(existingTemplate.getMetadata().getCreatedAt());

        int newVersion = existingTemplate.getMetadata().getVersion() + 1;
        metadata.version(newVersion)
                .lastModifiedBy(getCurrentUser())
                .lastModifiedAt(getCurrentTimestamp());

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
    private ImportTemplate convertDocumentToTemplate(Document document) {
        ImportTemplate template = new ImportTemplate();

        // Convert metadata with careful attention to all fields
        Document metadataDoc = (Document) document.get("metadata");
        if (metadataDoc != null) {
            Metadata metadata = new Metadata()
                    .id(metadataDoc.getInteger("id"))
                    .version(metadataDoc.getInteger("version"))
                    .createdBy(metadataDoc.getString("created_by"))
                    .createdAt(metadataDoc.getString("created_at"))
                    .lastModifiedBy(metadataDoc.getString("last_modified_by"))
                    .lastModifiedAt(metadataDoc.getString("last_modified_at"))
                    .datatype(metadataDoc.getString("datatype"));

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
