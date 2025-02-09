package com.devteam45ldm.ldm.parser.templates.importDataStructures;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Import {
    @JsonProperty("metadata")
    private String metadata = null;

    @JsonProperty("data")
    private String data = null;

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public Import metadata(String metadata) {
        this.metadata = metadata;
        return this;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Import data(String data) {
        this.data = data;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Import anImport)) return false;
        return Objects.equals(getMetadata(), anImport.getMetadata()) && Objects.equals(getData(), anImport.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(metadata, data);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
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
