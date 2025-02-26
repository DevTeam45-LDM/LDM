package com.devteam45ldm.ldm.parser.templates;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MetadataTest {

    /**
     * Tests if getVersion() returns the correct version.
     */
    @Test
    void getVersion_returnsCorrectVersion() {
        Metadata metadata = new Metadata();
        metadata.setVersion(1);
        assertEquals(1, metadata.getVersion());
    }

    /**
     * Tests if setVersion() sets the correct version.
     */
    @Test
    void setVersion_setsCorrectVersion() {
        Metadata metadata = new Metadata();
        metadata.setVersion(2);
        assertEquals(2, metadata.getVersion());
    }

    /**
     * Tests if getCreatedBy() returns the correct creator.
     */
    @Test
    void getCreatedBy_returnsCorrectCreatedBy() {
        Metadata metadata = new Metadata();
        metadata.setCreatedBy("user");
        assertEquals("user", metadata.getCreatedBy());
    }

    /**
     * Tests if setCreatedBy() sets the correct creator.
     */
    @Test
    void setCreatedBy_setsCorrectCreatedBy() {
        Metadata metadata = new Metadata();
        metadata.setCreatedBy("admin");
        assertEquals("admin", metadata.getCreatedBy());
    }

    /**
     * Tests if getCreatedAt() returns the correct creation date.
     */
    @Test
    void getCreatedAt_returnsCorrectCreatedAt() {
        Metadata metadata = new Metadata();
        metadata.setCreatedAt("2023-10-01");
        assertEquals("2023-10-01", metadata.getCreatedAt());
    }

    /**
     * Tests if setCreatedAt() sets the correct creation date.
     */
    @Test
    void setCreatedAt_setsCorrectCreatedAt() {
        Metadata metadata = new Metadata();
        metadata.setCreatedAt("2023-11-01");
        assertEquals("2023-11-01", metadata.getCreatedAt());
    }

    /**
     * Tests if getLastModifiedBy() returns the correct last modifier.
     */
    @Test
    void getLastModifiedBy_returnsCorrectLastModifiedBy() {
        Metadata metadata = new Metadata();
        metadata.setLastModifiedBy("editor");
        assertEquals("editor", metadata.getLastModifiedBy());
    }

    /**
     * Tests if setLastModifiedBy() sets the correct last modifier.
     */
    @Test
    void setLastModifiedBy_setsCorrectLastModifiedBy() {
        Metadata metadata = new Metadata();
        metadata.setLastModifiedBy("reviewer");
        assertEquals("reviewer", metadata.getLastModifiedBy());
    }

    /**
     * Tests if getLastModifiedAt() returns the correct last modification date.
     */
    @Test
    void getLastModifiedAt_returnsCorrectLastModifiedAt() {
        Metadata metadata = new Metadata();
        metadata.setLastModifiedAt("2023-12-01");
        assertEquals("2023-12-01", metadata.getLastModifiedAt());
    }

    /**
     * Tests if setLastModifiedAt() sets the correct last modification date.
     */
    @Test
    void setLastModifiedAt_setsCorrectLastModifiedAt() {
        Metadata metadata = new Metadata();
        metadata.setLastModifiedAt("2024-01-01");
        assertEquals("2024-01-01", metadata.getLastModifiedAt());
    }

    /**
     * Tests if getParser() returns the correct parser type.
     */
    @Test
    void getDatatype_returnsCorrectDatatype() {
        Metadata metadata = new Metadata();
        metadata.setDatatype("json");
        assertEquals("json", metadata.getDatatype());
    }

    /**
     * Tests if setParser() sets the correct parser type.
     */
    @Test
    void setDatatype_setsCorrectDatatype() {
        Metadata metadata = new Metadata();
        metadata.setDatatype("xml");
        assertEquals("xml", metadata.getDatatype());
    }

    /**
     * Tests if equals() returns true for the same object.
     */
    @Test
    void equals_sameObject_returnsTrue() {
        Metadata metadata = new Metadata();
        assertTrue(metadata.equals(metadata));
    }

    /**
     * Tests if equals() returns false for different objects.
     */
    @Test
    void equals_differentObject_returnsFalse() {
        Metadata metadata1 = new Metadata().createdBy("user");
        Metadata metadata2 = new Metadata();
        assertFalse(metadata1.equals(metadata2));
    }

    /**
     * Tests if hashCode() returns the same hash code for the same object.
     */
    @Test
    void hashCode_sameObject_returnsSameHashCode() {
        Metadata metadata = new Metadata();
        assertEquals(metadata.hashCode(), metadata.hashCode());
    }

    /**
     * Tests if toString() returns the correct string representation.
     */
    @Test
    void toString_returnsCorrectStringRepresentation() {
        Metadata metadata = new Metadata();
        metadata.setVersion(1);
        metadata.setCreatedBy("user");
        metadata.setCreatedAt("2023-10-01");
        metadata.setLastModifiedBy("editor");
        metadata.setLastModifiedAt("2023-12-01");
        metadata.setDatatype("csv");
        String expected = """
                {
                    version: 1,
                    created_by: user,
                    created_at: 2023-10-01,
                    last_modified_by: editor,
                    last_modified_at: 2023-12-01,
                    parser_type: csv
                }""";
        assertEquals(expected, metadata.toString());
    }

    /**
     * Tests if a Metadata object is correctly created from a JSON string.
     */
    @Test
    void fromJsonString_createsMetadataObject() throws Exception {
        String json = "{ \"version\": 1, \"created_by\": \"user\", \"created_at\": \"2023-10-01\", \"last_modified_by\": \"editor\", \"last_modified_at\": \"2023-12-01\", \"datatype\": \"json\" }";
        ObjectMapper objectMapper = new ObjectMapper();
        Metadata metadata = objectMapper.readValue(json, Metadata.class);

        assertEquals(1, metadata.getVersion());
        assertEquals("user", metadata.getCreatedBy());
        assertEquals("2023-10-01", metadata.getCreatedAt());
        assertEquals("editor", metadata.getLastModifiedBy());
        assertEquals("2023-12-01", metadata.getLastModifiedAt());
        assertEquals("json", metadata.getDatatype());
    }

    /**
     * Tests if a Metadata object with null fields is correctly created from a JSON string with missing fields.
     */
    @Test
    void fromJsonString_missingFields_createsMetadataObjectWithNulls() throws Exception {
        String json = "{ \"version\": 1, \"created_by\": \"user\" }";
        ObjectMapper objectMapper = new ObjectMapper();
        Metadata metadata = objectMapper.readValue(json, Metadata.class);

        assertEquals(1, metadata.getVersion());
        assertEquals("user", metadata.getCreatedBy());
        assertNull(metadata.getCreatedAt());
        assertNull(metadata.getLastModifiedBy());
        assertNull(metadata.getLastModifiedAt());
        assertNull(metadata.getDatatype());
    }

    /**
     * Tests if an exception is thrown for an invalid JSON string.
     */
    @Test
    void fromJsonString_invalidJson_throwsException() {
        String json = "{ \"version\": 1, \"created_by\": \"user\", ";
        ObjectMapper objectMapper = new ObjectMapper();
        assertThrows(Exception.class, () -> objectMapper.readValue(json, Metadata.class));
    }
}