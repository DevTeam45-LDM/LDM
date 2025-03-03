package com.devteam45ldm.ldm.parser.templates.importDataStructures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Represents the actual mappings of the import data e.g. the first level of parsing instructions.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImportMappings {

    /**
     * Path to metadata parts within the file.
     */
    @JsonProperty("metadata")
    private ImportParserMappings metadata = null;

    /**
     * Path to data parts within the file.
     */
    @JsonProperty("data")
    private ImportParserMappings data = null;

    // Getter and Setter methods with JavaDoc comments

    /**
     * Gets the metadata mappings.
     *
     * @return the metadata mappings
     */
    public ImportParserMappings getMetadata() {
        return metadata;
    }

    /**
     * Sets the metadata mappings.
     *
     * @param metadata the metadata mappings to set
     */
    public void setMetadata(ImportParserMappings metadata) {
        this.metadata = metadata;
    }

    /**
     * Sets the metadata mappings and returns the current ImportMappings object.
     *
     * @param metadata the metadata mappings to set
     * @return the current ImportMappings object
     */
    public ImportMappings metadata(ImportParserMappings metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Gets the data mappings.
     *
     * @return the data mappings
     */
    public ImportParserMappings getData() {
        return data;
    }

    /**
     * Sets the data mappings.
     *
     * @param data the data mappings to set
     */
    public void setData(ImportParserMappings data) {
        this.data = data;
    }

    /**
     * Sets the data mappings and returns the current ImportMappings object.
     *
     * @param data the data mappings to set
     * @return the current ImportMappings object
     */
    public ImportMappings data(ImportParserMappings data) {
        this.data = data;
        return this;
    }

    // Override equals, hashCode, and toString methods

    /**
     * Checks if this ImportMappings object is equal to another object.
     *
     * @param o the object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ImportMappings that)) return false;
        return Objects.equals(metadata, that.metadata) &&
                Objects.equals(data, that.data);
    }

    /**
     * Returns the hash code of this ImportMappings object.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(metadata, data);
    }

    /**
     * Returns the string representation of this ImportMappings object.
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        return "{\n" +
                "    metadata: " + toIndentedString(metadata) + ",\n" +
                "    data: " + toIndentedString(data) + "\n" +
                "}";
    }

    /**
     * Converts the given object to a string with each line indented by 4 spaces (except the first line).
     *
     * @param o the object to convert
     * @return the string representation of the object
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}