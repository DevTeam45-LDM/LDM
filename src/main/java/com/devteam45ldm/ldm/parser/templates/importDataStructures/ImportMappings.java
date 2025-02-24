package com.devteam45ldm.ldm.parser.templates.importDataStructures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Represents the actual mappings of the import data e.g. the first level of parsing instructions.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImportMappings {

    /**
     * Path to metadata parts within the file.
     */
    @JsonProperty("metadata")
    private ArrayList<String> metadata = null;

    /**
     * Delimiter for metadata e.g. a csv delimiter.
     */
    @JsonProperty("metadata_delimiter")
    private String metadataDelimiter = null;

    /**
     * Terminator for metadata e.g. a csv terminator like a newline.
     */
    @JsonProperty("metadata_terminator")
    private String metadataTerminator = null;

    /**
     * Assignment operators e.g. in txt files.
     * Example: "key: value" -> ":" is the assignment operator.
     */
    @JsonProperty("metadata_assignments")
    private String metadataAssignments = null;

    /**
     * Regex pattern to find headlines and define metadata parts.
     */
    @JsonProperty("metadata_pattern")
    private Pattern metadataPattern = null;

    /**
     * Path to data parts within the file.
     */
    @JsonProperty("data")
    private ArrayList<String> data = null;

    /**
     * Delimiter for data e.g. a csv delimiter.
     */
    @JsonProperty("data_delimiter")
    private String dataDelimiter = null;

    /**
     * Terminator for data e.g. a csv terminator like a newline.
     */
    @JsonProperty("data_terminator")
    private String dataTerminator = null;

    /**
     * Assignment operators e.g. in txt files.
     * Example: "key: value" -> ":" is the assignment operator.
     */
    @JsonProperty("data_Assignments")
    private String dataAssignments = null;

    /**
     * Regex pattern to find headlines and define data parts.
     */
    @JsonProperty("data_pattern")
    private Pattern dataPattern = null;

    /**
     * Gets the metadata.
     *
     * @return the metadata
     */
    public ArrayList<String> getMetadata() {
        return metadata;
    }

    /**
     * Sets the metadata.
     *
     * @param metadata the metadata to set
     */
    @JsonSetter("metadata")
    public void setMetadata(ArrayList<String> metadata) {
        this.metadata = metadata;
    }


    /**
     * Sets the metadata and returns the current ImportMappings object.
     *
     * @param metadata the metadata to set
     * @return the current ImportMappings object
     */
    public ImportMappings metadata(ArrayList<String> metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Sets the metadata and returns the current ImportMappings object.
     *
     * @param metadata the metadata to set
     * @return the current ImportMappings object
     */
    public ImportMappings metadata(String metadata) {
        ArrayList<String> metadataArray = new ArrayList<>();
        metadataArray.add(metadata);
        this.metadata = metadataArray;
        return this;
    }

    /**
     * Gets the metadata delimiter.
     *
     * @return the metadata delimiter
     */
    public String getMetadataDelimiter() {
        return metadataDelimiter;
    }

    /**
     * Sets the metadata delimiter.
     *
     * @param metadataDelimiter the metadata delimiter to set
     */
    public void setMetadataDelimiter(String metadataDelimiter) {
        this.metadataDelimiter = metadataDelimiter;
    }

    /**
     * Sets the metadata delimiter and returns the current ImportMappings object.
     *
     * @param metadataDelimiter the metadata delimiter to set
     * @return the current ImportMappings object
     */
    public ImportMappings metadataDelimiter(String metadataDelimiter) {
        this.metadataDelimiter = metadataDelimiter;
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
    public ArrayList<String> getData() {
        return data;
    }

    /**
     * Sets the data.
     *
     * @param data the data to set
     */
    @JsonSetter("data")
    public void setData(ArrayList<String> data) {
        this.data = data;
    }


    /**
     * Sets the data and returns the current ImportMappings object.
     *
     * @param data the data to set
     * @return the current ImportMappings object
     */
    public ImportMappings data(ArrayList<String> data) {
        this.data = data;
        return this;
    }

    /**
     * Sets the data and returns the current ImportMappings object.
     *
     * @param data the data to set
     * @return the current ImportMappings object
     */
    public ImportMappings data(String data) {
        ArrayList<String> dataArray = new ArrayList<>();
        dataArray.add(data);
        this.data = dataArray;
        return this;
    }

    /**
     * Gets the data separator.
     *
     * @return the data separator
     */
    public String getDataDelimiter() {
        return dataDelimiter;
    }

    /**
     * Sets the data separator.
     *
     * @param dataDelimiter the data separator to set
     */
    public void setDataDelimiter(String dataDelimiter) {
        this.dataDelimiter = dataDelimiter;
    }

    /**
     * Sets the data separator and returns the current ImportMappings object.
     *
     * @param dataSeparator the data separator to set
     * @return the current ImportMappings object
     */
    public ImportMappings dataSeparator(String dataSeparator) {
        this.dataDelimiter = dataSeparator;
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
        return Objects.equals(getMetadata(), importMappings.getMetadata()) && Objects.equals(getMetadataDelimiter(), importMappings.getMetadataDelimiter()) && Objects.equals(getMetadataPattern(), importMappings.getMetadataPattern()) && Objects.equals(getData(), importMappings.getData()) && Objects.equals(getDataDelimiter(), importMappings.getDataDelimiter()) && Objects.equals(getDataPattern(), importMappings.getDataPattern());
    }

    /**
     * Returns the hash code of this ImportMappings object.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(metadata, metadataDelimiter, metadataPattern, data, dataDelimiter, dataPattern);
    }

    /**
     * Returns the string representation of this ImportMappings object.
     *
     * @return the string representation
     */
    public String toString() {
        return "{\n" +
                "    metadata: " + toIndentedString(metadata) + "\n" +
                "    metadata_separator: " + toIndentedString(metadataDelimiter) + "\n" +
                "    metadata_pattern: " + toIndentedString(metadataPattern) + "\n" +
                "    data: " + toIndentedString(data) + "\n" +
                "    data_separator: " + toIndentedString(dataDelimiter) + "\n" +
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
