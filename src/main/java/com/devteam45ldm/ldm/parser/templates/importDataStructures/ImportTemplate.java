package com.devteam45ldm.ldm.parser.templates.importDataStructures;

import com.devteam45ldm.ldm.parser.ParserController;
import com.devteam45ldm.ldm.parser.templates.Metadata;
import com.devteam45ldm.ldm.parser.templates.Template;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONObject;

import java.util.Objects;

/**
 * Represents the first parsing level instructions and is a user defined semantic model of the import data.
 */
public class ImportTemplate extends Template {

    @JsonProperty("mappings")
    private ImportMappings importMappings = null;

    /**
     * Sets the metadata and returns the current ImportTemplate object.
     *
     * @param metadata the metadata to set
     * @return the current ImportTemplate object
     */
    public ImportTemplate metadata(Metadata metadata) {
        super.setMetadata(metadata);
        return this;
    }

    /**
     * Gets the import mappings.
     *
     * @return the import mappings
     */
    public ImportMappings getMappings() {
        return importMappings;
    }

    /**
     * Sets the import mappings.
     *
     * @param importMappings the import mappings to set
     */
    public void setMappings(ImportMappings importMappings) {
        this.importMappings = importMappings;
    }

    /**
     * Sets the import mappings and returns the current ImportTemplate object.
     *
     * @param importMappings the import mappings to set
     * @return the current ImportTemplate object
     */
    public ImportTemplate mappings(ImportMappings importMappings) {
        this.importMappings = importMappings;
        return this;
    }

    /**
     * Checks if this ImportTemplate object is equal to another object.
     *
     * @param o the object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ImportTemplate that)) return false;
        return  Objects.equals(getMetadata(), that.getMetadata()) &&
                Objects.equals(importMappings, that.importMappings);
    }

    /**
     * Returns the hash code of this ImportTemplate object.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(getMetadata(), importMappings);
    }

    /**
     * Returns the string representation of this ImportTemplate object.
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        return "{\n" +
                "    metadata: " + toIndentedString(super.getMetadata()) + ",\n" +
                "    mappings: " + toIndentedString(importMappings) + "\n" +
                "}";
    }

    /**
     * Converts the given object to a string with each line indented by 4 spaces (except the first line).
     *
     * @param o the object to convert
     * @return the string representation of the object
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    /**
     * Converts this ImportTemplate object to a JSON string.
     *
     * @return the JSON string representation of this ImportTemplate object
     */
    public String toJson() {
        return JSONObject.quote(toString());
    }
}