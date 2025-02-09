package com.devteam45ldm.ldm.parser.templates.importDataStructures;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.*;

class ImportedDataMappingsTest {

    /**
     * Tests if getMetadata() returns the correct metadata.
     */
    @Test
    void getMetadata_returnsCorrectMetadata() {
        ImportMappings importMappings = new ImportMappings();
        importMappings.setMetadata("metadata");
        assertEquals("metadata", importMappings.getMetadata());
    }

    /**
     * Tests if setMetadata() sets the correct metadata.
     */
    @Test
    void setMetadata_setsCorrectMetadata() {
        ImportMappings importMappings = new ImportMappings();
        importMappings.setMetadata("new_metadata");
        assertEquals("new_metadata", importMappings.getMetadata());
    }

    /**
     * Tests if metadata() sets and returns the correct metadata.
     */
    @Test
    void metadata_setsAndReturnsCorrectMetadata() {
        ImportMappings importMappings = new ImportMappings();
        assertEquals(importMappings, importMappings.metadata("metadata"));
        assertEquals("metadata", importMappings.getMetadata());
    }

    /**
     * Tests if getMetadataSeparator() returns the correct metadata separator.
     */
    @Test
    void getMetadataSeparator_returnsCorrectMetadataSeparator() {
        ImportMappings importMappings = new ImportMappings();
        importMappings.setMetadataSeparator(",");
        assertEquals(",", importMappings.getMetadataSeparator());
    }

    /**
     * Tests if setMetadataSeparator() sets the correct metadata separator.
     */
    @Test
    void setMetadataSeparator_setsCorrectMetadataSeparator() {
        ImportMappings importMappings = new ImportMappings();
        importMappings.setMetadataSeparator(";");
        assertEquals(";", importMappings.getMetadataSeparator());
    }

    /**
     * Tests if metadataSeparator() sets and returns the correct metadata separator.
     */
    @Test
    void metadataSeparator_setsAndReturnsCorrectMetadataSeparator() {
        ImportMappings importMappings = new ImportMappings();
        assertEquals(importMappings, importMappings.metadataSeparator(","));
        assertEquals(",", importMappings.getMetadataSeparator());
    }

    /**
     * Tests if getMetadataPattern() returns the correct metadata pattern.
     */
    @Test
    void getMetadataPattern_returnsCorrectMetadataPattern() {
        ImportMappings importMappings = new ImportMappings();
        Pattern pattern = Pattern.compile(".*");
        importMappings.setMetadataPattern(pattern);
        assertEquals(pattern, importMappings.getMetadataPattern());
    }

    /**
     * Tests if setMetadataPattern() sets the correct metadata pattern.
     */
    @Test
    void setMetadataPattern_setsCorrectMetadataPattern() {
        ImportMappings importMappings = new ImportMappings();
        Pattern pattern = Pattern.compile(".*");
        importMappings.setMetadataPattern(pattern);
        assertEquals(pattern, importMappings.getMetadataPattern());
    }

    /**
     * Tests if metadataPattern() sets and returns the correct metadata pattern.
     */
    @Test
    void metadataPattern_setsAndReturnsCorrectMetadataPattern() {
        ImportMappings importMappings = new ImportMappings();
        Pattern pattern = Pattern.compile(".*");
        assertEquals(importMappings, importMappings.metadataPattern(pattern));
        assertEquals(pattern, importMappings.getMetadataPattern());
    }

    /**
     * Tests if getData() returns the correct data.
     */
    @Test
    void getData_returnsCorrectData() {
        ImportMappings importMappings = new ImportMappings();
        importMappings.setData("data");
        assertEquals("data", importMappings.getData());
    }

    /**
     * Tests if setData() sets the correct data.
     */
    @Test
    void setData_setsCorrectData() {
        ImportMappings importMappings = new ImportMappings();
        importMappings.setData("new_data");
        assertEquals("new_data", importMappings.getData());
    }

    /**
     * Tests if data() sets and returns the correct data.
     */
    @Test
    void data_setsAndReturnsCorrectData() {
        ImportMappings importMappings = new ImportMappings();
        assertEquals(importMappings, importMappings.data("data"));
        assertEquals("data", importMappings.getData());
    }

    /**
     * Tests if getDataSeparator() returns the correct data separator.
     */
    @Test
    void getDataSeparator_returnsCorrectDataSeparator() {
        ImportMappings importMappings = new ImportMappings();
        importMappings.setDataSeparator(",");
        assertEquals(",", importMappings.getDataSeparator());
    }

    /**
     * Tests if setDataSeparator() sets the correct data separator.
     */
    @Test
    void setDataSeparator_setsCorrectDataSeparator() {
        ImportMappings importMappings = new ImportMappings();
        importMappings.setDataSeparator(";");
        assertEquals(";", importMappings.getDataSeparator());
    }

    /**
     * Tests if dataSeparator() sets and returns the correct data separator.
     */
    @Test
    void dataSeparator_setsAndReturnsCorrectDataSeparator() {
        ImportMappings importMappings = new ImportMappings();
        assertEquals(importMappings, importMappings.dataSeparator(","));
        assertEquals(",", importMappings.getDataSeparator());
    }

    /**
     * Tests if getDataPattern() returns the correct data pattern.
     */
    @Test
    void getDataPattern_returnsCorrectDataPattern() {
        ImportMappings importMappings = new ImportMappings();
        Pattern pattern = Pattern.compile(".*");
        importMappings.setDataPattern(pattern);
        assertEquals(pattern, importMappings.getDataPattern());
    }

    /**
     * Tests if setDataPattern() sets the correct data pattern.
     */
    @Test
    void setDataPattern_setsCorrectDataPattern() {
        ImportMappings importMappings = new ImportMappings();
        Pattern pattern = Pattern.compile(".*");
        importMappings.setDataPattern(pattern);
        assertEquals(pattern, importMappings.getDataPattern());
    }

    /**
     * Tests if dataPattern() sets and returns the correct data pattern.
     */
    @Test
    void dataPattern_setsAndReturnsCorrectDataPattern() {
        ImportMappings importMappings = new ImportMappings();
        Pattern pattern = Pattern.compile(".*");
        assertEquals(importMappings, importMappings.dataPattern(pattern));
        assertEquals(pattern, importMappings.getDataPattern());
    }

    /**
     * Tests if equals() returns true for the same object.
     */
    @Test
    void equals_sameObject_returnsTrue() {
        ImportMappings importMappings = new ImportMappings();
        assertTrue(importMappings.equals(importMappings));
    }

    /**
     * Tests if equals() returns false for different objects.
     */
    @Test
    void equals_differentObject_returnsFalse() {
        ImportMappings importMappings1 = new ImportMappings().data("data");
        ImportMappings importMappings2 = new ImportMappings();
        assertFalse(importMappings1.equals(importMappings2));
    }

    /**
     * Tests if equals() returns true for objects with the same values.
     */
    @Test
    void equals_sameValues_returnsTrue() {
        ImportMappings importMappings1 = new ImportMappings();
        importMappings1.setMetadata("metadata");
        importMappings1.setData("data");

        ImportMappings importMappings2 = new ImportMappings();
        importMappings2.setMetadata("metadata");
        importMappings2.setData("data");

        assertTrue(importMappings1.equals(importMappings2));
    }

    /**
     * Tests if hashCode() returns the same hash code for the same object.
     */
    @Test
    void hashCode_sameObject_returnsSameHashCode() {
        ImportMappings importMappings = new ImportMappings();
        assertEquals(importMappings.hashCode(), importMappings.hashCode());
    }

    /**
     * Tests if toString() returns the correct string representation.
     */
    @Test
    void toString_returnsCorrectStringRepresentation() {
        ImportMappings importMappings = new ImportMappings();
        importMappings.setMetadata("metadata");
        importMappings.setData("data");
        String expected = """
                {
                    metadata: metadata
                    metadata_separator: null
                    metadata_pattern: null
                    data: data
                    data_separator: null
                    data_pattern: null
                }""";
        assertEquals(expected, importMappings.toString());
    }

    /**
     * Tests if an ImportMappings object is correctly created from a JSON string.
     */
    @Test
    void fromJsonString_createsImportMappingsObject() throws Exception {
        String json = "{ \"metadata\": \"metadata_value\", \"data\": \"data_value\" }";
        ObjectMapper objectMapper = new ObjectMapper();
        ImportMappings importMappings = objectMapper.readValue(json, ImportMappings.class);

        assertEquals("metadata_value", importMappings.getMetadata());
        assertEquals("data_value", importMappings.getData());
    }

    /**
     * Tests if an ImportMappings object with null fields is correctly created from a JSON string with missing fields.
     */
    @Test
    void fromJsonString_missingFields_createsImportMappingsObjectWithNulls() throws Exception {
        String json = "{ \"metadata\": \"metadata_value\" }";
        ObjectMapper objectMapper = new ObjectMapper();
        ImportMappings importMappings = objectMapper.readValue(json, ImportMappings.class);

        assertEquals("metadata_value", importMappings.getMetadata());
        assertNull(importMappings.getData());
    }

    /**
     * Tests if an exception is thrown for an invalid JSON string.
     */
    @Test
    void fromJsonString_invalidJson_throwsException() {
        String json = "{ \"metadata\": \"metadata_value\", ";
        ObjectMapper objectMapper = new ObjectMapper();
        assertThrows(Exception.class, () -> objectMapper.readValue(json, ImportMappings.class));
    }
}