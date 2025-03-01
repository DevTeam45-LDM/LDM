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
     * Is there a line to be treated as a headline?
     * Lines with only spaces and \n are ignored.
     */
    @JsonProperty("metadata_has_headline")
    private Boolean metadataHasHeadline = null;

    /**
     * String which every line starts with.
     */
    @JsonProperty("metadata_line_start")
    private String metadataLineStarter = null;

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
     * If set, the data will be treated as key-value pairs, optionally with a delimiter for multiple values within a line.
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
     * Is there a line to be treated as a headline?
     * Lines with only spaces and \n are ignored.
     */
    @JsonProperty("data_has_headline")
    private Boolean dataHasHeadline = null;

    /**
     * String which every line starts with.
     */
    @JsonProperty("data_line_start")
    private String dataLineStarter = null;

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
     * If set, the data will be treated as key-value pairs, optionally with a delimiter for multiple values within a line.
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
     * Gets the metadata has headline.
     *
     * @return the metadata has headline
     */
    public Boolean getMetadataHasHeadline() {
        return metadataHasHeadline;
    }

    /**
     * Sets the metadata has headline.
     *
     * @param metadataHasHeadline the metadata has headline to set
     */
    public void setMetadataHasHeadline(Boolean metadataHasHeadline) {
        this.metadataHasHeadline = metadataHasHeadline;
    }

    /**
     * Sets the metadata has headline and returns the current ImportMappings object.
     *
     * @param metadataHasHeadline the metadata has headline to set
     * @return the current ImportMappings object
     */
    public ImportMappings metadataHasHeadline(Boolean metadataHasHeadline) {
        this.metadataHasHeadline = metadataHasHeadline;
        return this;
    }

    /**
     * Gets the metadata line starter.
     *
     * @return the metadata line starter
     */
    public String getMetadataLineStarter() {
        return metadataLineStarter;
    }

    /**
     * Sets the metadata line starter.
     *
     * @param metadataLineStarter the metadata line starter to set
     */
    public void setMetadataLineStarter(String metadataLineStarter) {
        this.metadataLineStarter = metadataLineStarter;
    }

    /**
     * Sets the metadata line starter and returns the current ImportMappings object.
     *
     * @param metadataLineStarter the metadata line starter to set
     * @return the current ImportMappings object
     */
    public ImportMappings metadataLineStarter(String metadataLineStarter) {
        this.metadataLineStarter = metadataLineStarter;
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
     * Gets the metadata terminator.
     *
     * @return the metadata terminator
     */
    public String getMetadataTerminator() {
        return metadataTerminator;
    }

    /**
     * Sets the metadata terminator.
     *
     * @param metadataTerminator the metadata terminator to set
     */
    public void setMetadataTerminator(String metadataTerminator) {
        this.metadataTerminator = metadataTerminator;
    }

    /**
     * Sets the metadata terminator and returns the current ImportMappings object.
     *
     * @param metadataTerminator the metadata terminator to set
     * @return the current ImportMappings object
     */
    public ImportMappings metadataTerminator(String metadataTerminator) {
        this.metadataTerminator = metadataTerminator;
        return this;
    }

    /**
     * Gets the metadata assignments.
     *
     * @return the metadata assignments
     */
    public String getMetadataAssignments() {
        return metadataAssignments;
    }

    /**
     * Sets the metadata assignments.
     *
     * @param metadataAssignments the metadata assignments to set
     */
    public void setMetadataAssignments(String metadataAssignments) {
        this.metadataAssignments = metadataAssignments;
    }

    /**
     * Sets the metadata assignments and returns the current ImportMappings object.
     *
     * @param metadataAssignments the metadata assignments to set
     * @return the current ImportMappings object
     */
    public ImportMappings metadataAssignments(String metadataAssignments) {
        this.metadataAssignments = metadataAssignments;
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
     * Gets the data has headline.
     *
     * @return the data has headline
     */
    public Boolean getDataHasHeadline() {
        return dataHasHeadline;
    }

    /**
     * Sets the data has headline.
     *
     * @param dataHasHeadline the data has headline to set
     */
    public void setDataHasHeadline(Boolean dataHasHeadline) {
        this.dataHasHeadline = dataHasHeadline;
    }

    /**
     * Sets the data has headline and returns the current ImportMappings object.
     *
     * @param dataHasHeadline the data has headline to set
     * @return the current ImportMappings object
     */
    public ImportMappings dataHasHeadline(Boolean dataHasHeadline) {
        this.dataHasHeadline = dataHasHeadline;
        return this;
    }

    /**
     * Gets the data line starter.
     *
     * @return the data line starter
     */
    public String getDataLineStarter() {
        return dataLineStarter;
    }

    /**
     * Sets the data line starter.
     *
     * @param dataLineStarter the data line starter to set
     */
    public void setDataLineStarter(String dataLineStarter) {
        this.dataLineStarter = dataLineStarter;
    }

    /**
     * Sets the data line starter and returns the current ImportMappings object.
     *
     * @param dataLineStarter the data line starter to set
     * @return the current ImportMappings object
     */
    public ImportMappings dataLineStarter(String dataLineStarter) {
        this.dataLineStarter = dataLineStarter;
        return this;
    }

    /**
     * Gets the data delimiter.
     *
     * @return the data delimiter
     */
    public String getDataDelimiter() {
        return dataDelimiter;
    }

    /**
     * Sets the data delimiter.
     *
     * @param dataDelimiter the data delimiter to set
     */
    public void setDataDelimiter(String dataDelimiter) {
        this.dataDelimiter = dataDelimiter;
    }

    /**
     * Sets the data delimiter and returns the current ImportMappings object.
     *
     * @param dataDelimiter the data delimiter to set
     * @return the current ImportMappings object
     */
    public ImportMappings dataDelimiter(String dataDelimiter) {
        this.dataDelimiter = dataDelimiter;
        return this;
    }

    /**
     * Gets the data terminator.
     *
     * @return the data terminator
     */
    public String getDataTerminator() {
        return dataTerminator;
    }

    /**
     * Sets the data terminator.
     *
     * @param dataTerminator the data terminator to set
     */
    public void setDataTerminator(String dataTerminator) {
        this.dataTerminator = dataTerminator;
    }

    /**
     * Sets the data terminator and returns the current ImportMappings object.
     *
     * @param dataTerminator the data terminator to set
     * @return the current ImportMappings object
     */
    public ImportMappings dataTerminator(String dataTerminator) {
        this.dataTerminator = dataTerminator;
        return this;
    }

    /**
     * Gets the data assignments.
     *
     * @return the data assignments
     */
    public String getDataAssignments() {
        return dataAssignments;
    }

    /**
     * Sets the data assignments.
     *
     * @param dataAssignments the data assignments to set
     */
    public void setDataAssignments(String dataAssignments) {
        this.dataAssignments = dataAssignments;
    }

    /**
     * Sets the data assignments and returns the current ImportMappings object.
     *
     * @param dataAssignments the data assignments to set
     * @return the current ImportMappings object
     */
    public ImportMappings dataAssignments(String dataAssignments) {
        this.dataAssignments = dataAssignments;
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
        return Objects.equals(getMetadata(), importMappings.getMetadata()) &&
                Objects.equals(getMetadataHasHeadline(), importMappings.getMetadataHasHeadline()) &&
                Objects.equals(getMetadataDelimiter(), importMappings.getMetadataDelimiter()) &&
                Objects.equals(getMetadataPattern(), importMappings.getMetadataPattern()) &&
                Objects.equals(getMetadataTerminator(), importMappings.getMetadataTerminator()) &&
                Objects.equals(getMetadataAssignments(), importMappings.getMetadataAssignments()) &&
                Objects.equals(getData(), importMappings.getData()) &&
                Objects.equals((getDataHasHeadline()), importMappings.getDataHasHeadline()) &&
                Objects.equals(getDataDelimiter(), importMappings.getDataDelimiter()) &&
                Objects.equals(getDataPattern(), importMappings.getDataPattern()) &&
                Objects.equals(getDataTerminator(), importMappings.getDataTerminator()) &&
                Objects.equals(getDataAssignments(), importMappings.getDataAssignments()) &&
                Objects.equals(getDataLineStarter(), importMappings.getDataLineStarter()) &&
                Objects.equals(getMetadataLineStarter(), importMappings.getMetadataLineStarter());
    }

    /**
     * Returns the hash code of this ImportMappings object.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(metadata, metadataHasHeadline, metadataDelimiter, metadataPattern, metadataTerminator, metadataAssignments, data, dataHasHeadline, dataDelimiter, dataPattern, dataTerminator, dataAssignments, metadataLineStarter, dataLineStarter);
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
                "    metadata_has_headline: " + toIndentedString(metadataHasHeadline) + ",\n" +
                "    metadata_delimiter: " + toIndentedString(metadataDelimiter) + ",\n" +
                "    metadata_pattern: " + toIndentedString(metadataPattern) + ",\n" +
                "    metadata_line_starter: " + toIndentedString(metadataLineStarter) + ",\n" +
                "    metadata_terminator: " + toIndentedString(metadataTerminator) + ",\n" +
                "    metadata_assignments: " + toIndentedString(metadataAssignments) + ",\n" +
                "    data: " + toIndentedString(data) + ",\n" +
                "    data_has_headline: " + toIndentedString(dataHasHeadline) + ",\n" +
                "    data_delimiter: " + toIndentedString(dataDelimiter) + ",\n" +
                "    data_pattern: " + toIndentedString(dataPattern) + ",\n" +
                "    data_line_starter: " + toIndentedString(dataLineStarter) + ",\n" +
                "    data_terminator: " + toIndentedString(dataTerminator) + ",\n" +
                "    data_assignments: " + toIndentedString(dataAssignments) + "\n" +
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
