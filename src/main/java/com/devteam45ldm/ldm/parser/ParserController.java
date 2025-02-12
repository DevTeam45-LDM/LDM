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
import org.json.JSONObject;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ParserController {

    public static ImportedData importParser(String data, ImportTemplate importTemplate) throws SAXException, ParserConfigurationException, IOException, JSONException {
        switch (importTemplate.getMetadata().getDatatype()) {
            case "json":
                return Json2Json.parse(data, importTemplate);
            case "xml": //TODO: Implement XML2JSON
                JSONObject xml2Json = Xml2Json.parse(data);
                return Json2Json.parse(xml2Json.toString(), importTemplate);
            case "csv": //TODO: Implement CSV2JSON
                JSONObject csv2Json = Csv2Json.parse(data);
                return Json2Json.parse(csv2Json.toString(), importTemplate);
            default:
                return null; //TODO: Use custom parser;
        }
    }

    public static ExportedData exportParser(String data, ExportTemplate exportTemplate) throws JSONException {
        //TODO: Implement export parser
        return null;
    }
}