package com.devteam45ldm.ldm.parser.templates.importDataStructures;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.regex.Pattern;

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


    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public ImportMappings metadata(String metadata) {
        this.metadata = metadata;
        return this;
    }

    public String getMetadataSeparator() {
        return metadataSeparator;
    }

    public void setMetadataSeparator(String metadataSeparator) {
        this.metadataSeparator = metadataSeparator;
    }

    public ImportMappings metadataSeparator(String metadataSeparator) {
        this.metadataSeparator = metadataSeparator;
        return this;
    }

    public Pattern getMetadataPattern() {
        return metadataPattern;
    }

    public void setMetadataPattern(Pattern metadataPattern) {
        this.metadataPattern = metadataPattern;
    }

    public ImportMappings metadataPattern(Pattern metadataPattern) {
        this.metadataPattern = metadataPattern;
        return this;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ImportMappings data(String data) {
        this.data = data;
        return this;
    }

    public String getDataSeparator() {
        return dataSeparator;
    }

    public void setDataSeparator(String dataSeparator) {
        this.dataSeparator = dataSeparator;
    }

    public ImportMappings dataSeparator(String dataSeparator) {
        this.dataSeparator = dataSeparator;
        return this;
    }

    public Pattern getDataPattern() {
        return dataPattern;
    }

    public void setDataPattern(Pattern dataPattern) {
        this.dataPattern = dataPattern;
    }

    public ImportMappings dataPattern(Pattern dataPattern) {
        this.dataPattern = dataPattern;
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ImportMappings importMappings)) return false;
        return Objects.equals(getMetadata(), importMappings.getMetadata()) && Objects.equals(getMetadataSeparator(), importMappings.getMetadataSeparator()) && Objects.equals(getMetadataPattern(), importMappings.getMetadataPattern()) && Objects.equals(getData(), importMappings.getData()) && Objects.equals(getDataSeparator(), importMappings.getDataSeparator()) && Objects.equals(getDataPattern(), importMappings.getDataPattern());
    }

    @Override
    public int hashCode() {
        return Objects.hash(metadata, metadataSeparator, metadataPattern, data, dataSeparator, dataPattern);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    metadata_separator: ").append(toIndentedString(metadataSeparator)).append("\n");
        sb.append("    metadata_pattern: ").append(toIndentedString(metadataPattern)).append("\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("    data_separator: ").append(toIndentedString(dataSeparator)).append("\n");
        sb.append("    data_pattern: ").append(toIndentedString(dataPattern)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
