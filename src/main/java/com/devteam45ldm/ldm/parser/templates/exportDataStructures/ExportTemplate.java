package com.devteam45ldm.ldm.parser.templates.exportDataStructures;

import com.devteam45ldm.ldm.parser.templates.Metadata;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONObject;

//TODO: Implement this class
public class ExportTemplate {
    @JsonProperty("metadata")
    private Metadata metadata = null;

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public ExportTemplate metadata(Metadata metadata) {
        this.metadata = metadata;
        return this;
    }

    public String toJson() {
        return JSONObject.quote(toString());
    }
}