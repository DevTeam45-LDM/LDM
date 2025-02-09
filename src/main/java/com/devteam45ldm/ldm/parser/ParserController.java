package com.devteam45ldm.ldm.parser;

import com.devteam45ldm.ldm.parser.templates.exportDataStructures.ExportTemplate;
import com.devteam45ldm.ldm.parser.templates.exportDataStructures.ExportedData;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportedData;
import com.devteam45ldm.ldm.parser.types.Csv2Json;
import com.devteam45ldm.ldm.parser.types.Custom2Json;
import com.devteam45ldm.ldm.parser.types.Json2Json;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportTemplate;
import com.devteam45ldm.ldm.parser.types.Xml2Json;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONException;

public class ParserController {

    public static ImportedData importParser(String data, ImportTemplate importTemplate) throws JSONException {
        switch (importTemplate.getMetadata().getDatatype()) {
            case "json":
                return Json2Json.parse(data, importTemplate);
            //case XML2JSON: //TODO: Implement XML2JSON
            //    return new Xml2Json().convert(data).toJson();
            //case CSV2JSON: //TODO: Implement CSV2JSON
            //    return new Csv2Json(importTemplate).convert(data);
            default:
                return null; //TODO: Use custom parser;
        }
    }

    public static ExportedData exportParser(String data, ExportTemplate exportTemplate) throws JSONException {
        //TODO: Implement export parser
        return null;
    }
}