package com.devteam45ldm.ldm.parser.templates.importDataStructures;

import com.devteam45ldm.ldm.parser.templates.Metadata;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONObject;

import java.util.Objects;

public class ImportTemplate {

    @JsonProperty("metadata")
    private Metadata metadata = null;

    @JsonProperty("mappings")
    private ImportMappings importMappings = null;


    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public ImportTemplate metadata(Metadata metadata) {
        this.metadata = metadata;
        return this;
    }

    public ImportMappings getData() {
        return importMappings;
    }

    public void setData(ImportMappings importMappings) {
        this.importMappings = importMappings;
    }

    public ImportTemplate data(ImportMappings importMappings) {
        this.importMappings = importMappings;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ImportTemplate that)) return false;
        return Objects.equals(getMetadata(), that.getMetadata()) && Objects.equals(importMappings, that.importMappings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMetadata(), importMappings);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append(",\n");
        sb.append("    data: ").append(toIndentedString(importMappings)).append("\n");
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

    public String toJson() {
        return JSONObject.quote(toString());
    }
}