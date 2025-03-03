package com.devteam45ldm.ldm.parser.templates.importDataStructures;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.*;

class ImportMappingsTest {

    /**
     * Tests if getter and setter of metadata is working.
     */
    @Test
    void metadata_getAndSet() {
        ImportMappings importMappings = new ImportMappings();
        ImportParserMappings metadata = new ImportParserMappings();
        metadata.setPath(new ArrayList<>(List.of("metadata")));
        importMappings.setMetadata(metadata);
        assertEquals("metadata", importMappings.getMetadata().getPath().get(0));
        assertEquals("[metadata]", importMappings.getMetadata().getPath().toString());
    }

    /**
     * Tests if metadata() sets and returns the correct metadata.
     */
    @Test
    void metadata_setsAndReturnsCorrectMetadata() {
        ImportMappings importMappings = new ImportMappings();
        ImportParserMappings metadata = new ImportParserMappings();
        metadata.setPath(new ArrayList<>(List.of("metadata1", "metadata2")));
        importMappings.setMetadata(metadata);
        assertEquals(importMappings, importMappings.metadata(metadata));
        assertEquals("[metadata1, metadata2]", importMappings.getMetadata().getPath().toString());
    }

    /**
     * Tests if getter and setter of metadataDelimiter is working.
     */
    @Test
    void metadataDelimiter_getAndSet() {
        ImportMappings importMappings = new ImportMappings();
        ImportParserMappings metadata = new ImportParserMappings();
        metadata.setDelimiter(",");
        importMappings.setMetadata(metadata);
        assertEquals(",", importMappings.getMetadata().getDelimiter());
    }

    /**
     * Tests if metadataDelimiter() sets and returns the correct metadata delimiter.
     */
    @Test
    void metadataDelimiter_setsAndReturnsCorrectMetadataDelimiter() {
        ImportMappings importMappings = new ImportMappings();
        ImportParserMappings metadata = new ImportParserMappings();
        metadata.setDelimiter(",");
        importMappings.setMetadata(metadata);
        assertEquals(importMappings, importMappings.metadata(metadata));
        assertEquals(",", importMappings.getMetadata().getDelimiter());
    }

    /**
     * Tests if getter and setter of metadataPattern is working.
     */
    @Test
    void metadataPattern_getAndSet() {
        ImportMappings importMappings = new ImportMappings();
        ImportParserMappings metadata = new ImportParserMappings();
        Pattern pattern = Pattern.compile(".*");
        metadata.setPattern(pattern);
        importMappings.setMetadata(metadata);
        assertEquals(pattern, importMappings.getMetadata().getPattern());
    }

    /**
     * Tests if metadataPattern() sets and returns the correct metadata pattern.
     */
    @Test
    void metadataPattern_setsAndReturnsCorrectMetadataPattern() {
        ImportMappings importMappings = new ImportMappings();
        ImportParserMappings metadata = new ImportParserMappings();
        Pattern pattern = Pattern.compile(".*");
        metadata.setPattern(pattern);
        importMappings.setMetadata(metadata);
        assertEquals(importMappings, importMappings.metadata(metadata));
        assertEquals(pattern, importMappings.getMetadata().getPattern());
    }

    /**
     * Tests if getter and setter of data is working.
     */
    @Test
    void data_getAndSet() {
        ImportMappings importMappings = new ImportMappings();
        ImportParserMappings data = new ImportParserMappings();
        data.setPath(new ArrayList<>(List.of("new_data")));
        importMappings.setData(data);
        assertEquals("new_data", importMappings.getData().getPath().get(0));
        assertEquals("[new_data]", importMappings.getData().getPath().toString());
    }

    /**
     * Tests if data() sets and returns the correct data.
     */
    @Test
    void data_setsAndReturnsCorrectData() {
        ImportMappings importMappings = new ImportMappings();
        ImportParserMappings data = new ImportParserMappings();
        data.setPath(new ArrayList<>(List.of("data", "data2")));
        importMappings.setData(data);
        assertEquals(importMappings, importMappings.data(data));
        assertEquals("[data, data2]", importMappings.getData().getPath().toString());
    }

    /**
     * Tests if getter and setter of dataDelimiter is working.
     */
    @Test
    void dataDelimiter_getAndSet() {
        ImportMappings importMappings = new ImportMappings();
        ImportParserMappings data = new ImportParserMappings();
        data.setDelimiter(",");
        importMappings.setData(data);
        assertEquals(",", importMappings.getData().getDelimiter());
    }

    /**
     * Tests if dataDelimiter() sets and returns the correct data delimiter.
     */
    @Test
    void dataDelimiter_setsAndReturnsCorrectDataDelimiter() {
        ImportMappings importMappings = new ImportMappings();
        ImportParserMappings data = new ImportParserMappings();
        data.setDelimiter(";");
        importMappings.setData(data);
        assertEquals(importMappings, importMappings.data(data));
        assertEquals(";", importMappings.getData().getDelimiter());
    }

    /**
     * Tests if getter and setter of dataPattern is working.
     */
    @Test
    void dataPattern_getAndSet() {
        ImportMappings importMappings = new ImportMappings();
        ImportParserMappings data = new ImportParserMappings();
        Pattern pattern = Pattern.compile(".*");
        data.setPattern(pattern);
        importMappings.setData(data);
        assertEquals(pattern, importMappings.getData().getPattern());
    }

    /**
     * Tests if dataPattern() sets and returns the correct data pattern.
     */
    @Test
    void dataPattern_setsAndReturnsCorrectDataPattern() {
        ImportMappings importMappings = new ImportMappings();
        ImportParserMappings data = new ImportParserMappings();
        Pattern pattern = Pattern.compile(".*");
        data.setPattern(pattern);
        importMappings.setData(data);
        assertEquals(importMappings, importMappings.data(data));
        assertEquals(pattern, importMappings.getData().getPattern());
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
        ImportMappings importMappings1 = new ImportMappings();
        ImportParserMappings data = new ImportParserMappings();
        data.setDelimiter(";");
        importMappings1.setData(data);
        ImportMappings importMappings2 = new ImportMappings();
        assertFalse(importMappings1.equals(importMappings2));
    }

    /**
     * Tests if equals() returns true for objects with the same values.
     */
    @Test
    void equals_sameValues_returnsTrue() {
        ImportMappings importMappings1 = new ImportMappings();
        ImportParserMappings metadata = new ImportParserMappings();
        metadata.setPath(new ArrayList<>(List.of("metadata")));
        ImportParserMappings data = new ImportParserMappings();
        data.setPath(new ArrayList<>(List.of("data")));
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
        ImportParserMappings metadata = new ImportParserMappings();
        metadata.setPath(new ArrayList<>(List.of("metadata")));
        ImportParserMappings data = new ImportParserMappings();
        data.setPath(new ArrayList<>(List.of("data")));
        importMappings.setMetadata(metadata);
        importMappings.setData(data);
        String expected = "{\n" +
                "    metadata: " + toIndentedString(metadata) + ",\n" +
                "    data: " + toIndentedString(data) + "\n" +
                "}";
        assertEquals(expected, importMappings.toString());
    }

    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    /**
     * Tests if an ImportMappings object is correctly created from a JSON string.
     */
    @Test
    void fromJsonString_createsImportMappingsObject() throws Exception {
        String json = "{ \"metadata\": { \"path\": [\"metadata_value\"] }, \"data\": { \"path\": [\"data_value\"] } }";
        ObjectMapper objectMapper = new ObjectMapper();
        ImportMappings importMappings;
        importMappings = objectMapper.readValue(json, ImportMappings.class);

        assertEquals("[metadata_value]", importMappings.getMetadata().getPath().toString());
        assertEquals("[data_value]", importMappings.getData().getPath().toString());
        assertEquals("metadata_value", importMappings.getMetadata().getPath().get(0));
        assertEquals("data_value", importMappings.getData().getPath().get(0));
    }

    /**
     * Tests if an ImportMappings object with null fields is correctly created from a JSON string with missing fields.
     */
    @Test
    void fromJsonString_missingFields_createsImportMappingsObjectWithNulls() throws Exception {
        String json = "{ \"metadata\": { \"path\": [\"metadata_value\"] } }";
        ObjectMapper objectMapper = new ObjectMapper();
        ImportMappings importMappings;
        importMappings = objectMapper.readValue(json, ImportMappings.class);

        assertEquals("metadata_value", importMappings.getMetadata().getPath().get(0));
        assertEquals("[metadata_value]", importMappings.getMetadata().getPath().toString());
        assertNull(importMappings.getData());
    }

    /**
     * Tests if an exception is thrown for an invalid JSON string.
     */
    @Test
    void fromJsonString_invalidJson_throwsException() {
        String json = "{ \"metadata\": { \"path\": [\"metadata_value\"] }, ";
        ObjectMapper objectMapper = new ObjectMapper();
        assertThrows(Exception.class, () -> objectMapper.readValue(json, ImportMappings.class));
    }
}