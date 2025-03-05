package com.devteam45ldm.ldm.parser.templates.importDataStructures;

import com.devteam45ldm.ldm.parser.templates.Metadata;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

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
    void getMappings_returnsCorrectMappings() {
        ImportTemplate importTemplate = new ImportTemplate();
        ImportMappings importMappings = new ImportMappings();
        importTemplate.setMappings(importMappings);
        assertEquals(importMappings, importTemplate.getMappings());
    }

    /**
     * Tests if setData sets the correct ImportMappings object.
     */
    @Test
    void setMappings_setsCorrectMappings() {
        ImportTemplate importTemplate = new ImportTemplate();
        ImportMappings importMappings = new ImportMappings();
        importTemplate.setMappings(importMappings);
        assertEquals(importMappings, importTemplate.getMappings());
    }

    /**
     * Tests if data method sets and returns the correct ImportMappings object.
     */
    @Test
    void data_setsAndReturnsCorrectMappings() {
        ImportTemplate importTemplate = new ImportTemplate();
        ImportMappings importMappings = new ImportMappings();
        assertEquals(importTemplate, importTemplate.mappings(importMappings));
        assertEquals(importMappings, importTemplate.getMappings());
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
        ImportTemplate importTemplate1 = new ImportTemplate().mappings(new ImportMappings());
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
        importTemplate1.setMappings(importMappings);

        ImportTemplate importTemplate2 = new ImportTemplate();
        importTemplate2.setMetadata(metadata);
        importTemplate2.setMappings(importMappings);

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
        importTemplate.setMappings(importMappings);
        String expected = "{\n" +
                "    metadata: {\n" +
                "        version: null,\n" +
                "        created_by: null,\n" +
                "        created_at: null,\n" +
                "        last_modified_by: null,\n" +
                "        last_modified_at: null,\n" +
                "        parser_type: null\n" +
                "    },\n" +
                "    mappings: {\n" +
                "        metadata: null,\n" +
                "        data: null,\n" +
                "        metadata_parser_type: null,\n" +
                "        data_parser_type: null\n" +
                "    }\n" +
                "}";
        assertEquals(expected, importTemplate.toString());
    }

    /**
     * Tests if toString method returns the correct string representation of the object.
     */
    @Test
    void toString_returnsCorrectStringRepresentationWithParserMappings() {
        ImportTemplate importTemplate = new ImportTemplate();
        Metadata metadata = new Metadata();
        ImportMappings importMappings = new ImportMappings();
        ImportParserMappings metadataMappings = new ImportParserMappings();
        ImportParserMappings dataMappings = new ImportParserMappings();
        importMappings.setMetadata(metadataMappings);
        importMappings.setData(dataMappings);
        importTemplate.setMetadata(metadata);
        importTemplate.setMappings(importMappings);
        String expected = "{\n" +
                "    metadata: {\n" +
                "        version: null,\n" +
                "        created_by: null,\n" +
                "        created_at: null,\n" +
                "        last_modified_by: null,\n" +
                "        last_modified_at: null,\n" +
                "        parser_type: null\n" +
                "    },\n" +
                "    mappings: {\n" +
                "        metadata: {\n" +
                "            paths: null,\n" +
                "            has_headline: null,\n" +
                "            line_starter: null,\n" +
                "            delimiter: null,\n" +
                "            total_columns: null,\n"+
                "            terminator: null,\n" +
                "            assignments: null,\n" +
                "            section_pattern: null,\n" +
                "            section_string: null,\n" +
                "            skip_lines: null\n" +
                "        },\n" +
                "        data: {\n" +
                "            paths: null,\n" +
                "            has_headline: null,\n" +
                "            line_starter: null,\n" +
                "            delimiter: null,\n" +
                "            total_columns: null,\n"+
                "            terminator: null,\n" +
                "            assignments: null,\n" +
                "            section_pattern: null,\n" +
                "            section_string: null,\n" +
                "            skip_lines: null\n" +
                "        },\n" +
                "        metadata_parser_type: null,\n" +
                "        data_parser_type: null\n" +
                "    }\n" +
                "}";
        assertEquals(expected, importTemplate.toString());
    }

    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
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
        importTemplate.setMappings(importMappings);
        String expected = JSONObject.quote(importTemplate.toString());
        assertEquals(expected, importTemplate.toJson());
    }

    /**
     * Tests if an ImportTemplate object is correctly created from a JSON string.
     */
    @Test
    void fromJsonString_createsImportTemplateObject() throws Exception {
        String json = "{\"metadata\":{\"version\":null,\"created_by\":null,\"created_at\":null,\"last_modified_by\":null,\"last_modified_at\":null,\"parser_type\":null},\"mappings\":{\"metadata\":{\"paths\":null,\"has_headline\":null,\"line_starter\":null,\"delimiter\":null,\"total_columns\":null,\"terminator\":null,\"assignments\":null,\"section_pattern\":null,\"section_string\":null,\"skip_lines\":null},\"data\":{\"paths\":null,\"has_headline\":null,\"line_starter\":null,\"delimiter\":null,\"total_columns\":null,\"terminator\":null,\"assignments\":null,\"section_pattern\":null,\"section_string\":null,\"skip_lines\":null},\"metadata_parser_type\":null,\"data_parser_type\":null}}";
        ObjectMapper objectMapper = new ObjectMapper();
        ImportTemplate importTemplate = objectMapper.readValue(json, ImportTemplate.class);

        Metadata expectedMetadata = new Metadata();
        ImportMappings expectedMappings = new ImportMappings();

        assertEquals(expectedMetadata, importTemplate.getMetadata());
        assertTrue(expectedMappings.equals(importTemplate.getMappings()));
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
        assertNull(importTemplate.getMappings());
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