package com.devteam45ldm.ldm.parser.templates;

import com.devteam45ldm.ldm.parser.Parser;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Metadata {
    @JsonProperty("version")
    private Integer version = null;

    @JsonProperty("created_by")
    private String createdBy = null;

    @JsonProperty("created_at")
    private String createdAt = null;

    @JsonProperty("last_modified_by")
    private String lastModifiedBy = null;

    @JsonProperty("last_modified_at")
    private String lastModifiedAt = null;

    @JsonProperty("parser")
    private Parser.ParserType parser = null;


    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Metadata version(Integer version) {
        this.version = version;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Metadata createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Metadata createdAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Metadata lastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
        return this;
    }

    public String getLastModifiedAt() {
        return lastModifiedAt;
    }

    public void setLastModifiedAt(String lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    public Metadata lastModifiedAt(String lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
        return this;
    }

    public Parser.ParserType getParser() {
        return parser;
    }

    public void setParser(Parser.ParserType parser) {
        this.parser = parser;
    }

    public Metadata parser(Parser.ParserType parser) {
        this.parser = parser;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Metadata metadata)) return false;
        return Objects.equals(getVersion(), metadata.getVersion()) && Objects.equals(getCreatedBy(), metadata.getCreatedBy()) && Objects.equals(getCreatedAt(), metadata.getCreatedAt()) && Objects.equals(getLastModifiedBy(), metadata.getLastModifiedBy()) && Objects.equals(getLastModifiedAt(), metadata.getLastModifiedAt()) && getParser() == metadata.getParser();
    }

    @Override
    public int hashCode() {
        return Objects.hash(version, createdBy, createdAt, lastModifiedBy, lastModifiedAt, parser);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
        sb.append("    created_by: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    created_at: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    last_modified_by: ").append(toIndentedString(lastModifiedBy)).append("\n");
        sb.append("    last_modified_at: ").append(toIndentedString(lastModifiedAt)).append("\n");
        sb.append("    parser: ").append(toIndentedString(parser)).append("\n");
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
