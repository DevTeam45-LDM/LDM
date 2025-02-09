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


    /**
     * Gets the version of the metadata.
     *
     * @return the version of the metadata
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * Sets the version of the metadata.
     *
     * @param version the version to set
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * Sets the version of the metadata and returns the updated Metadata object.
     *
     * @param version the version to set
     * @return the updated Metadata object
     */
    public Metadata version(Integer version) {
        this.version = version;
        return this;
    }

    /**
     * Gets the creator of the metadata.
     *
     * @return the creator of the metadata
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets the creator of the metadata.
     *
     * @param createdBy the creator to set
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Sets the creator of the metadata and returns the updated Metadata object.
     *
     * @param createdBy the creator to set
     * @return the updated Metadata object
     */
    public Metadata createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    /**
     * Gets the creation date of the metadata.
     *
     * @return the creation date of the metadata
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the creation date of the metadata.
     *
     * @param createdAt the creation date to set
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Sets the creation date of the metadata and returns the updated Metadata object.
     *
     * @param createdAt the creation date to set
     * @return the updated Metadata object
     */
    public Metadata createdAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Gets the last modifier of the metadata.
     *
     * @return the last modifier of the metadata
     */
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     * Sets the last modifier of the metadata.
     *
     * @param lastModifiedBy the last modifier to set
     */
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    /**
     * Sets the last modifier of the metadata and returns the updated Metadata object.
     *
     * @param lastModifiedBy the last modifier to set
     * @return the updated Metadata object
     */
    public Metadata lastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
        return this;
    }

    /**
     * Gets the last modification date of the metadata.
     *
     * @return the last modification date of the metadata
     */
    public String getLastModifiedAt() {
        return lastModifiedAt;
    }

    /**
     * Sets the last modification date of the metadata.
     *
     * @param lastModifiedAt the last modification date to set
     */
    public void setLastModifiedAt(String lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    /**
     * Sets the last modification date of the metadata and returns the updated Metadata object.
     *
     * @param lastModifiedAt the last modification date to set
     * @return the updated Metadata object
     */
    public Metadata lastModifiedAt(String lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
        return this;
    }

    /**
     * Gets the parser type of the metadata.
     *
     * @return the parser type of the metadata
     */
    public Parser.ParserType getParser() {
        return parser;
    }

    /**
     * Gets the parser type of the metadata.
     *
     * @return the parser type of the metadata
     */
    public void setParser(Parser.ParserType parser) {
        this.parser = parser;
    }

    /**
     * Sets the parser type of the metadata and returns the updated Metadata object.
     *
     * @param parser the parser type to set
     * @return the updated Metadata object
     */
    public Metadata parser(Parser.ParserType parser) {
        this.parser = parser;
        return this;
    }

    /**
     * Checks if this metadata is equal to another object.
     *
     * @param o the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Metadata metadata)) return false;
        return Objects.equals(getVersion(), metadata.getVersion()) && Objects.equals(getCreatedBy(), metadata.getCreatedBy()) && Objects.equals(getCreatedAt(), metadata.getCreatedAt()) && Objects.equals(getLastModifiedBy(), metadata.getLastModifiedBy()) && Objects.equals(getLastModifiedAt(), metadata.getLastModifiedAt()) && getParser() == metadata.getParser();
    }

    /**
     * Returns the hash code of this metadata.
     *
     * @return the hash code of this metadata
     */
    @Override
    public int hashCode() {
        return Objects.hash(version, createdBy, createdAt, lastModifiedBy, lastModifiedAt, parser);
    }

    /**
     * Returns the string representation of this metadata.
     *
     * @return the string representation of this metadata
     */
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
     * Converts the given object to string with each line indented by 4 spaces
     * (except the first line).
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
