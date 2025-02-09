package com.devteam45ldm.ldm.parser.templates.importDataStructures;

import com.devteam45ldm.ldm.parser.templates.Metadata;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the ImportTemplate class.
 */
class ImportTemplateTest {

    /**
     * Tests if getMetadata returns the correct Metadata object.
     */
    @Test
    void getMetadata_returnsCorrectMetadata() {
        ImportTemplate importTemplate = new ImportTemplate();
        Metadata metadata = new Metadata();
        importTemplate.setMetadata(metadata);
        assertEquals(metadata, importTemplate.getMetadata());
    }

    /**
     * Tests if setMetadata sets the correct Metadata object.
     */
    @Test
    void setMetadata_setsCorrectMetadata() {
        ImportTemplate importTemplate = new ImportTemplate();
        Metadata metadata = new Metadata();
        importTemplate.setMetadata(metadata);
        assertEquals(metadata, importTemplate.getMetadata());
    }

    /**
     * Tests if metadata method sets and returns the correct Metadata object.
     */
    @Test
    void metadata_setsAndReturnsCorrectMetadata() {
        ImportTemplate importTemplate = new ImportTemplate();
        Metadata metadata = new Metadata();
        assertEquals(importTemplate, importTemplate.metadata(metadata));
        assertEquals(metadata, importTemplate.getMetadata());
    }

    /**
     * Tests if getData returns the correct ImportMappings object.
     */
    @Test
    void getData_returnsCorrectData() {
        ImportTemplate importTemplate = new ImportTemplate();
        ImportMappings importMappings = new ImportMappings();
        importTemplate.setData(importMappings);
        assertEquals(importMappings, importTemplate.getData());
    }

    /**
     * Tests if setData sets the correct ImportMappings object.
     */
    @Test
    void setData_setsCorrectData() {
        ImportTemplate importTemplate = new ImportTemplate();
        ImportMappings importMappings = new ImportMappings();
        importTemplate.setData(importMappings);
        assertEquals(importMappings, importTemplate.getData());
    }

    /**
     * Tests if data method sets and returns the correct ImportMappings object.
     */
    @Test
    void data_setsAndReturnsCorrectData() {
        ImportTemplate importTemplate = new ImportTemplate();
        ImportMappings importMappings = new ImportMappings();
        assertEquals(importTemplate, importTemplate.data(importMappings));
        assertEquals(importMappings, importTemplate.getData());
    }

    /**
     * Tests if equals method returns true for the same object.
     */
    @Test
    void equals_sameObject_returnsTrue() {
        ImportTemplate importTemplate = new ImportTemplate();
        assertTrue(importTemplate.equals(importTemplate));
    }

    /**
     * Tests if equals method returns false for different objects.
     */
    @Test
    void equals_differentObject_returnsFalse() {
        ImportTemplate importTemplate1 = new ImportTemplate().data(new ImportMappings());
        ImportTemplate importTemplate2 = new ImportTemplate();
        assertFalse(importTemplate1.equals(importTemplate2));
    }

    /**
     * Tests if equals method returns true for objects with the same values.
     */
    @Test
    void equals_sameValues_returnsTrue() {
        ImportTemplate importTemplate1 = new ImportTemplate();
        Metadata metadata = new Metadata();
        ImportMappings importMappings = new ImportMappings();
        importTemplate1.setMetadata(metadata);
        importTemplate1.setData(importMappings);

        ImportTemplate importTemplate2 = new ImportTemplate();
        importTemplate2.setMetadata(metadata);
        importTemplate2.setData(importMappings);

        assertTrue(importTemplate1.equals(importTemplate2));
    }

    /**
     * Tests if hashCode method returns the same hash code for the same object.
     */
    @Test
    void hashCode_sameObject_returnsSameHashCode() {
        ImportTemplate importTemplate = new ImportTemplate();
        assertEquals(importTemplate.hashCode(), importTemplate.hashCode());
    }

    /**
     * Tests if toString method returns the correct string representation of the object.
     */
    @Test
    void toString_returnsCorrectStringRepresentation() {
        ImportTemplate importTemplate = new ImportTemplate();
        Metadata metadata = new Metadata();
        ImportMappings importMappings = new ImportMappings();
        importTemplate.setMetadata(metadata);
        importTemplate.setData(importMappings);
        String expected = "{\n" +
                "    metadata: {\n" +
                "        version: null\n" +
                "        created_by: null\n" +
                "        created_at: null\n" +
                "        last_modified_by: null\n" +
                "        last_modified_at: null\n" +
                "        parser: null\n" +
                "    },\n" +
                "    data: {\n" +
                "        metadata: null\n" +
                "        metadata_separator: null\n" +
                "        metadata_pattern: null\n" +
                "        data: null\n" +
                "        data_separator: null\n" +
                "        data_pattern: null\n" +
                "    }\n" +
                "}";
        assertEquals(expected, importTemplate.toString());
    }

    /**
     * Tests if toJson method returns the correct JSON string representation of the object.
     */
    @Test
    void toJson_returnsCorrectJsonString() {
        ImportTemplate importTemplate = new ImportTemplate();
        Metadata metadata = new Metadata();
        ImportMappings importMappings = new ImportMappings();
        importTemplate.setMetadata(metadata);
        importTemplate.setData(importMappings);
        String expected = JSONObject.quote(importTemplate.toString());
        assertEquals(expected, importTemplate.toJson());
    }

    /**
     * Tests if an ImportTemplate object is correctly created from a JSON string.
     */
    @Test
    void fromJsonString_createsImportTemplateObject() throws Exception {
        String json = "{ \"metadata\": { \"version\": null, \"created_by\": null, \"created_at\": null, \"last_modified_by\": null, \"last_modified_at\": null, \"parser\": null }, \"data\": { \"metadata\": null, \"metadata_separator\": null, \"metadata_pattern\": null, \"data\": null, \"data_separator\": null, \"data_pattern\": null } }";
        ObjectMapper objectMapper = new ObjectMapper();
        ImportTemplate importTemplate = objectMapper.readValue(json, ImportTemplate.class);

        Metadata expectedMetadata = new Metadata();
        ImportMappings expectedData = new ImportMappings();

        assertEquals(expectedMetadata, importTemplate.getMetadata());
        assertEquals(expectedData, importTemplate.getData());
    }

    /**
     * Tests if an ImportTemplate object with null fields is correctly created from a JSON string with missing fields.
     */
    @Test
    void fromJsonString_missingFields_createsImportTemplateObjectWithNulls() throws Exception {
        String json = "{ \"metadata\": { \"version\": null, \"created_by\": null, \"created_at\": null, \"last_modified_by\": null, \"last_modified_at\": null, \"parser\": null } }";
        ObjectMapper objectMapper = new ObjectMapper();
        ImportTemplate importTemplate = objectMapper.readValue(json, ImportTemplate.class);

        Metadata expectedMetadata = new Metadata();

        assertEquals(expectedMetadata, importTemplate.getMetadata());
        assertNull(importTemplate.getData());
    }

    /**
     * Tests if an exception is thrown for an invalid JSON string.
     */
    @Test
    void fromJsonString_invalidJson_throwsException() {
        String json = "{ \"metadata\": { \"key\": \"value\" }, ";
        ObjectMapper objectMapper = new ObjectMapper();
        assertThrows(Exception.class, () -> objectMapper.readValue(json, ImportTemplate.class));
    }
}