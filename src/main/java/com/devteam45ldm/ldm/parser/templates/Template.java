package com.devteam45ldm.ldm.parser.templates;

import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportTemplate;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Template {
    @JsonProperty("metadata")
    private Metadata metadata = null;

    /**
     * Gets the metadata.
     *
     * @return the metadata
     */
    public Metadata getMetadata() {
        return metadata;
    }

    /**
     * Sets the metadata.
     *
     * @param metadata the metadata to set
     */
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    /**
     * Sets the metadata and returns the current ImportTemplate object.
     *
     * @param metadata the metadata to set
     * @return the current ImportTemplate object
     */
    public Template metadata(Metadata metadata) {
        this.metadata = metadata;
        return this;
    }
}
