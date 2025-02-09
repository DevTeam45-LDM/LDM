package com.devteam45ldm.ldm.parser.templates.importDataStructures;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Represents the actual mappings of the import data e.g. the first level of parsing instructions.
 */
public class ImportMappings {
    @JsonProperty("metadata")
    private String metadata = null;

    @JsonProperty("metadata_separator")
    private String metadataSeparator = null;

    @JsonProperty("metadata_pattern")
    private Pattern metadataPattern = null;

    @JsonProperty("data")
    private String data = null;

    @JsonProperty("data_separator")
    private String dataSeparator = null;

    @JsonProperty("data_pattern")
    private Pattern dataPattern = null;

    /**
     * Gets the metadata.
     *
     * @return the metadata
     */
    public String getMetadata() {
        return metadata;
    }

    /**
     * Sets the metadata.
     *
     * @param metadata the metadata to set
     */
    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    /**
     * Sets the metadata and returns the current ImportMappings object.
     *
     * @param metadata the metadata to set
     * @return the current ImportMappings object
     */
    public ImportMappings metadata(String metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Gets the metadata separator.
     *
     * @return the metadata separator
     */
    public String getMetadataSeparator() {
        return metadataSeparator;
    }

    /**
     * Sets the metadata separator.
     *
     * @param metadataSeparator the metadata separator to set
     */
    public void setMetadataSeparator(String metadataSeparator) {
        this.metadataSeparator = metadataSeparator;
    }

    /**
     * Sets the metadata separator and returns the current ImportMappings object.
     *
     * @param metadataSeparator the metadata separator to set
     * @return the current ImportMappings object
     */
    public ImportMappings metadataSeparator(String metadataSeparator) {
        this.metadataSeparator = metadataSeparator;
        return this;
    }

    /**
     * Gets the metadata pattern.
     *
     * @return the metadata pattern
     */
    public Pattern getMetadataPattern() {
        return metadataPattern;
    }

    /**
     * Sets the metadata pattern.
     *
     * @param metadataPattern the metadata pattern to set
     */
    public void setMetadataPattern(Pattern metadataPattern) {
        this.metadataPattern = metadataPattern;
    }

    /**
     * Sets the metadata pattern and returns the current ImportMappings object.
     *
     * @param metadataPattern the metadata pattern to set
     * @return the current ImportMappings object
     */
    public ImportMappings metadataPattern(Pattern metadataPattern) {
        this.metadataPattern = metadataPattern;
        return this;
    }

    /**
     * Gets the data.
     *
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * Sets the data.
     *
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Sets the data and returns the current ImportMappings object.
     *
     * @param data the data to set
     * @return the current ImportMappings object
     */
    public ImportMappings data(String data) {
        this.data = data;
        return this;
    }

    /**
     * Gets the data separator.
     *
     * @return the data separator
     */
    public String getDataSeparator() {
        return dataSeparator;
    }

    /**
     * Sets the data separator.
     *
     * @param dataSeparator the data separator to set
     */
    public void setDataSeparator(String dataSeparator) {
        this.dataSeparator = dataSeparator;
    }

    /**
     * Sets the data separator and returns the current ImportMappings object.
     *
     * @param dataSeparator the data separator to set
     * @return the current ImportMappings object
     */
    public ImportMappings dataSeparator(String dataSeparator) {
        this.dataSeparator = dataSeparator;
        return this;
    }

    /**
     * Gets the data pattern.
     *
     * @return the data pattern
     */
    public Pattern getDataPattern() {
        return dataPattern;
    }

    /**
     * Sets the data pattern.
     *
     * @param dataPattern the data pattern to set
     */
    public void setDataPattern(Pattern dataPattern) {
        this.dataPattern = dataPattern;
    }

    /**
     * Sets the data pattern and returns the current ImportMappings object.
     *
     * @param dataPattern the data pattern to set
     * @return the current ImportMappings object
     */
    public ImportMappings dataPattern(Pattern dataPattern) {
        this.dataPattern = dataPattern;
        return this;
    }

    /**
     * Checks if this ImportMappings object is equal to another object.
     *
     * @param o the object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ImportMappings importMappings)) return false;
        return Objects.equals(getMetadata(), importMappings.getMetadata()) && Objects.equals(getMetadataSeparator(), importMappings.getMetadataSeparator()) && Objects.equals(getMetadataPattern(), importMappings.getMetadataPattern()) && Objects.equals(getData(), importMappings.getData()) && Objects.equals(getDataSeparator(), importMappings.getDataSeparator()) && Objects.equals(getDataPattern(), importMappings.getDataPattern());
    }

    /**
     * Returns the hash code of this ImportMappings object.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(metadata, metadataSeparator, metadataPattern, data, dataSeparator, dataPattern);
    }

    /**
     * Returns the string representation of this ImportMappings object.
     *
     * @return the string representation
     */
    public String toString() {
        return "{\n" +
                "    metadata: " + toIndentedString(metadata) + "\n" +
                "    metadata_separator: " + toIndentedString(metadataSeparator) + "\n" +
                "    metadata_pattern: " + toIndentedString(metadataPattern) + "\n" +
                "    data: " + toIndentedString(data) + "\n" +
                "    data_separator: " + toIndentedString(dataSeparator) + "\n" +
                "    data_pattern: " + toIndentedString(dataPattern) + "\n" +
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
}
