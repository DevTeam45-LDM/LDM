package com.devteam45ldm.ldm.parser.templates.importDataStructures;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ImportedDataTest {

    /**
     * Tests if getMetadata() returns the correct metadata.
     */
    @Test
    void getMetadata_returnsCorrectMetadata() {
        ImportedData anImportedData = new ImportedData();
        anImportedData.setMetadata("metadata");
        assertEquals("metadata", anImportedData.getMetadata());
    }

    /**
     * Tests if setMetadata() sets the correct metadata.
     */
    @Test
    void setMetadata_setsCorrectMetadata() {
        ImportedData anImportedData = new ImportedData();
        anImportedData.setMetadata("new_metadata");
        assertEquals("new_metadata", anImportedData.getMetadata());
    }

    /**
     * Tests if metadata() sets and returns the correct metadata.
     */
    @Test
    void metadata_setsAndReturnsCorrectMetadata() {
        ImportedData anImportedData = new ImportedData();
        assertEquals(anImportedData, anImportedData.metadata("metadata"));
        assertEquals("metadata", anImportedData.getMetadata());
    }

    /**
     * Tests if getData() returns the correct data.
     */
    @Test
    void getData_returnsCorrectData() {
        ImportedData anImportedData = new ImportedData();
        anImportedData.setData("data");
        assertEquals("data", anImportedData.getData());
    }

    /**
     * Tests if setData() sets the correct data.
     */
    @Test
    void setData_setsCorrectData() {
        ImportedData anImportedData = new ImportedData();
        anImportedData.setData("new_data");
        assertEquals("new_data", anImportedData.getData());
    }

    /**
     * Tests if data() sets and returns the correct data.
     */
    @Test
    void data_setsAndReturnsCorrectData() {
        ImportedData anImportedData = new ImportedData();
        assertEquals(anImportedData, anImportedData.data("data"));
        assertEquals("data", anImportedData.getData());
    }

    /**
     * Tests if equals() returns true for the same object.
     */
    @Test
    void equals_sameObject_returnsTrue() {
        ImportedData anImportedData = new ImportedData();
        assertTrue(anImportedData.equals(anImportedData));
    }

    /**
     * Tests if equals() returns false for different objects.
     */
    @Test
    void equals_differentObject_returnsFalse() {
        ImportedData anImportedData1 = new ImportedData().data("data");
        ImportedData anImportedData2 = new ImportedData();
        assertFalse(anImportedData1.equals(anImportedData2));
    }

    /**
     * Tests if equals() returns true for objects with the same values.
     */
    @Test
    void equals_sameValues_returnsTrue() {
        ImportedData anImportedData1 = new ImportedData();
        anImportedData1.setMetadata("metadata");
        anImportedData1.setData("data");

        ImportedData anImportedData2 = new ImportedData();
        anImportedData2.setMetadata("metadata");
        anImportedData2.setData("data");

        assertTrue(anImportedData1.equals(anImportedData2));
    }

    /**
     * Tests if hashCode() returns the same hash code for the same object.
     */
    @Test
    void hashCode_sameObject_returnsSameHashCode() {
        ImportedData anImportedData = new ImportedData();
        assertEquals(anImportedData.hashCode(), anImportedData.hashCode());
    }

    /**
     * Tests if toString() returns the correct string representation.
     */
    @Test
    void toString_returnsCorrectStringRepresentation() {
        ImportedData anImportedData = new ImportedData();
        anImportedData.setMetadata("metadata");
        anImportedData.setData("data");
        String expected = """
                {
                    metadata: metadata
                    data: data
                }""";
        assertEquals(expected, anImportedData.toString());
    }

    /**
     * Tests if an Import object is correctly created from a JSON string.
     */
    @Test
    void fromJsonString_createsImportObject() throws Exception {
        String json = "{ \"metadata\": \"metadata_value\", \"data\": \"data_value\" }";
        ObjectMapper objectMapper = new ObjectMapper();
        ImportedData anImportedData = objectMapper.readValue(json, ImportedData.class);

        assertEquals("metadata_value", anImportedData.getMetadata());
        assertEquals("data_value", anImportedData.getData());
    }

    /**
     * Tests if an Import object with null fields is correctly created from a JSON string with missing fields.
     */
    @Test
    void fromJsonString_missingFields_createsImportObjectWithNulls() throws Exception {
        String json = "{ \"metadata\": \"metadata_value\" }";
        ObjectMapper objectMapper = new ObjectMapper();
        ImportedData anImportedData = objectMapper.readValue(json, ImportedData.class);

        assertEquals("metadata_value", anImportedData.getMetadata());
        assertNull(anImportedData.getData());
    }

    /**
     * Tests if an exception is thrown for an invalid JSON string.
     */
    @Test
    void fromJsonString_invalidJson_throwsException() {
        String json = "{ \"metadata\": \"metadata_value\", ";
        ObjectMapper objectMapper = new ObjectMapper();
        assertThrows(Exception.class, () -> objectMapper.readValue(json, ImportedData.class));
    }
}