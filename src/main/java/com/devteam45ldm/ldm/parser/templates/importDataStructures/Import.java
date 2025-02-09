package com.devteam45ldm.ldm.parser.templates.importDataStructures;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Represents the result structure of the first parsing level.
 */
public class Import {
    @JsonProperty("metadata")
    private String metadata = null;

    @JsonProperty("data")
    private String data = null;

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
     * Sets the metadata and returns the current Import object.
     *
     * @param metadata the metadata to set
     * @return the current Import object
     */
    public Import metadata(String metadata) {
        this.metadata = metadata;
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
     * Sets the data and returns the current Import object.
     *
     * @param data the data to set
     * @return the current Import object
     */
    public Import data(String data) {
        this.data = data;
        return this;
    }

    /**
     * Checks if this Import object is equal to another object.
     *
     * @param o the object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Import anImport)) return false;
        return Objects.equals(getMetadata(), anImport.getMetadata()) && Objects.equals(getData(), anImport.getData());
    }

    /**
     * Returns the hash code of this Import object.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(metadata, data);
    }

    /**
     * Returns the string representation of this Import object.
     *
     * @return the string representation
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("}");
        return sb.toString();
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
