package com.devteam45ldm.ldm.parser.templates.importDataStructures;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.*;

class ImportMappingsTest {

    /**
     * Tests if getter and setter of metadata is working.
     */
    @Test
    void metadata_getAndSet() {
        ImportMappings importMappings = new ImportMappings();
        ArrayList<String> metadata = new ArrayList<>();
        metadata.add("metadata");
        importMappings.setMetadata(metadata);
        assertEquals("metadata", importMappings.getMetadata().getFirst());
        assertEquals("[metadata]", importMappings.getMetadata().toString());
    }

    /**
     * Tests if metadata() sets and returns the correct metadata.
     */
    @Test
    void metadata_setsAndReturnsCorrectMetadata() {
        ImportMappings importMappings = new ImportMappings();
        ArrayList<String> metadata = new ArrayList<>();
        metadata.add("metadata1");
        metadata.add("metadata2");
        assertEquals(importMappings, importMappings.metadata(metadata));
        assertEquals("[metadata1, metadata2]", importMappings.getMetadata().toString());
    }

    /**
     * Tests if getter and setter of metadataSeparator is working.
     */
    @Test
    void metadataDelimiter_getAndSet() {
        ImportMappings importMappings = new ImportMappings();
        importMappings.setMetadataDelimiter(",");
        assertEquals(",", importMappings.getMetadataDelimiter());
    }

    /**
     * Tests if metadataSeparator() sets and returns the correct metadata separator.
     */
    @Test
    void metadataSeparator_setsAndReturnsCorrectMetadataDelimiter() {
        ImportMappings importMappings = new ImportMappings();
        assertEquals(importMappings, importMappings.metadataSeparator(","));
        assertEquals(",", importMappings.getMetadataDelimiter());
    }

    /**
     * Tests if getter and setter of metadataPattern is working.
     */
    @Test
    void metadataPattern_getAndSet() {
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
     * Tests if getter and setter of data is working.
     */
    @Test
    void data_getAndSet() {
        ImportMappings importMappings = new ImportMappings();
        ArrayList<String> data = new ArrayList<>();
        data.add("new_data");
        importMappings.setData(data);
        assertEquals("new_data", importMappings.getData().getFirst());
        assertEquals("[new_data]", importMappings.getData().toString());
    }

    /**
     * Tests if data() sets and returns the correct data.
     */
    @Test
    void data_setsAndReturnsCorrectData() {
        ImportMappings importMappings = new ImportMappings();
        ArrayList<String> data = new ArrayList<>();
        data.add("data");
        data.add("data2");
        assertEquals(importMappings, importMappings.data(data));
        assertEquals("[data, data2]", importMappings.getData().toString());
    }

    /**
     * Tests if getter and setter of dataSeparator is working.
     */
    @Test
    void dataDelimiter_getAndSet() {
        ImportMappings importMappings = new ImportMappings();
        importMappings.setDataDelimiter(",");
        assertEquals(",", importMappings.getDataDelimiter());
    }

    /**
     * Tests if dataSeparator() sets and returns the correct data separator.
     */
    @Test
    void dataSeparator_setsAndReturnsCorrectDataDelimiter() {
        ImportMappings importMappings = new ImportMappings();
        assertEquals(importMappings, importMappings.dataDelimiter(";"));
        assertEquals(";", importMappings.getDataDelimiter());
    }

    /**
     * Tests if getter and setter of dataPattern is working.
     */
    @Test
    void dataPattern_getAndSet() {
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
        ImportMappings importMappings1 = new ImportMappings().dataDelimiter(",");
        ImportMappings importMappings2 = new ImportMappings();
        assertFalse(importMappings1.equals(importMappings2));
    }

    /**
     * Tests if equals() returns true for objects with the same values.
     */
    @Test
    void equals_sameValues_returnsTrue() {
        ImportMappings importMappings1 = new ImportMappings();
        ArrayList<String> metadata = new ArrayList<>();
        metadata.add("metadata");
        ArrayList<String> data = new ArrayList<>();
        data.add("data");
        importMappings1.setMetadata(metadata);
        importMappings1.setData(data);

        ImportMappings importMappings2 = new ImportMappings();
        importMappings2.setMetadata(metadata);
        importMappings2.setData(data);

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
        ArrayList<String> metadata = new ArrayList<>();
        metadata.add("metadata");
        ArrayList<String> data = new ArrayList<>();
        data.add("data");
        importMappings.setMetadata(metadata);
        importMappings.setData(data);
        String expected = """
                {
                    metadata: [metadata]
                    metadata_separator: null
                    metadata_pattern: null
                    data: [data]
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
        String json = "{ \"metadata\": [\"metadata_value\"], \"data\": [\"data_value\"] }";
        ObjectMapper objectMapper = new ObjectMapper();
        ImportMappings importMappings;
        importMappings = objectMapper.readValue(json, ImportMappings.class);

        assertEquals("[metadata_value]", importMappings.getMetadata().toString());
        assertEquals("[data_value]", importMappings.getData().toString());
        assertEquals("metadata_value", importMappings.getMetadata().getFirst());
        assertEquals("data_value", importMappings.getData().getFirst());
    }

    /**
     * Tests if an ImportMappings object with null fields is correctly created from a JSON string with missing fields.
     */
    @Test
    void fromJsonString_missingFields_createsImportMappingsObjectWithNulls() throws Exception {
        String json = "{ \"metadata\": [\"metadata_value\"] }";
        ObjectMapper objectMapper = new ObjectMapper();
        ImportMappings importMappings;
        importMappings = objectMapper.readValue(json, ImportMappings.class);

        assertEquals("metadata_value", importMappings.getMetadata().getFirst());
        assertEquals("[metadata_value]", importMappings.getMetadata().toString());
        assertNull(importMappings.getData());
    }

    /**
     * Tests if an exception is thrown for an invalid JSON string.
     */
    @Test
    void fromJsonString_invalidJson_throwsException() {
        String json = "{ \"metadata\": [\"metadata_value\"], ";
        ObjectMapper objectMapper = new ObjectMapper();
        assertThrows(Exception.class, () -> objectMapper.readValue(json, ImportMappings.class));
    }
}