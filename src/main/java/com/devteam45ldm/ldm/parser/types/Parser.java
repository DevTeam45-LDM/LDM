package com.devteam45ldm.ldm.parser.types;

import com.devteam45ldm.ldm.parser.templates.exportDataStructures.ExportTemplate;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.Import;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportTemplate;
import org.json.JSONException;

public interface Parser {
    public abstract Import parse();
}
