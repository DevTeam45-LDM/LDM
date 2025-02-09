package com.devteam45ldm.ldm.parser.templates.importDataStructures;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ImportTest {

    /**
     * Tests if getMetadata() returns the correct metadata.
     */
    @Test
    void getMetadata_returnsCorrectMetadata() {
        Import anImport = new Import();
        anImport.setMetadata("metadata");
        assertEquals("metadata", anImport.getMetadata());
    }

    /**
     * Tests if setMetadata() sets the correct metadata.
     */
    @Test
    void setMetadata_setsCorrectMetadata() {
        Import anImport = new Import();
        anImport.setMetadata("new_metadata");
        assertEquals("new_metadata", anImport.getMetadata());
    }

    /**
     * Tests if metadata() sets and returns the correct metadata.
     */
    @Test
    void metadata_setsAndReturnsCorrectMetadata() {
        Import anImport = new Import();
        assertEquals(anImport, anImport.metadata("metadata"));
        assertEquals("metadata", anImport.getMetadata());
    }

    /**
     * Tests if getData() returns the correct data.
     */
    @Test
    void getData_returnsCorrectData() {
        Import anImport = new Import();
        anImport.setData("data");
        assertEquals("data", anImport.getData());
    }

    /**
     * Tests if setData() sets the correct data.
     */
    @Test
    void setData_setsCorrectData() {
        Import anImport = new Import();
        anImport.setData("new_data");
        assertEquals("new_data", anImport.getData());
    }

    /**
     * Tests if data() sets and returns the correct data.
     */
    @Test
    void data_setsAndReturnsCorrectData() {
        Import anImport = new Import();
        assertEquals(anImport, anImport.data("data"));
        assertEquals("data", anImport.getData());
    }

    /**
     * Tests if equals() returns true for the same object.
     */
    @Test
    void equals_sameObject_returnsTrue() {
        Import anImport = new Import();
        assertTrue(anImport.equals(anImport));
    }

    /**
     * Tests if equals() returns false for different objects.
     */
    @Test
    void equals_differentObject_returnsFalse() {
        Import anImport1 = new Import().data("data");
        Import anImport2 = new Import();
        assertFalse(anImport1.equals(anImport2));
    }

    /**
     * Tests if equals() returns true for objects with the same values.
     */
    @Test
    void equals_sameValues_returnsTrue() {
        Import anImport1 = new Import();
        anImport1.setMetadata("metadata");
        anImport1.setData("data");

        Import anImport2 = new Import();
        anImport2.setMetadata("metadata");
        anImport2.setData("data");

        assertTrue(anImport1.equals(anImport2));
    }

    /**
     * Tests if hashCode() returns the same hash code for the same object.
     */
    @Test
    void hashCode_sameObject_returnsSameHashCode() {
        Import anImport = new Import();
        assertEquals(anImport.hashCode(), anImport.hashCode());
    }

    /**
     * Tests if toString() returns the correct string representation.
     */
    @Test
    void toString_returnsCorrectStringRepresentation() {
        Import anImport = new Import();
        anImport.setMetadata("metadata");
        anImport.setData("data");
        String expected = """
                {
                    metadata: metadata
                    data: data
                }""";
        assertEquals(expected, anImport.toString());
    }

    /**
     * Tests if an Import object is correctly created from a JSON string.
     */
    @Test
    void fromJsonString_createsImportObject() throws Exception {
        String json = "{ \"metadata\": \"metadata_value\", \"data\": \"data_value\" }";
        ObjectMapper objectMapper = new ObjectMapper();
        Import anImport = objectMapper.readValue(json, Import.class);

        assertEquals("metadata_value", anImport.getMetadata());
        assertEquals("data_value", anImport.getData());
    }

    /**
     * Tests if an Import object with null fields is correctly created from a JSON string with missing fields.
     */
    @Test
    void fromJsonString_missingFields_createsImportObjectWithNulls() throws Exception {
        String json = "{ \"metadata\": \"metadata_value\" }";
        ObjectMapper objectMapper = new ObjectMapper();
        Import anImport = objectMapper.readValue(json, Import.class);

        assertEquals("metadata_value", anImport.getMetadata());
        assertNull(anImport.getData());
    }

    /**
     * Tests if an exception is thrown for an invalid JSON string.
     */
    @Test
    void fromJsonString_invalidJson_throwsException() {
        String json = "{ \"metadata\": \"metadata_value\", ";
        ObjectMapper objectMapper = new ObjectMapper();
        assertThrows(Exception.class, () -> objectMapper.readValue(json, Import.class));
    }
}