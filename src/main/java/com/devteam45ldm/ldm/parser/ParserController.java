package com.devteam45ldm.ldm.parser;

import com.devteam45ldm.ldm.parser.templates.exportDataStructures.ExportTemplate;
import com.devteam45ldm.ldm.parser.templates.exportDataStructures.ExportedData;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportParserMappings;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportedData;
import com.devteam45ldm.ldm.parser.types.Csv2Json;
import com.devteam45ldm.ldm.parser.types.Json2Json;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportTemplate;
import com.devteam45ldm.ldm.parser.types.Xml2Json;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public abstract class ParserController {

    public enum ParserType {
        JSON,
        XML,
        CSV,
        CUSTOM
    }

    public static ImportedData importParser(String data, ImportTemplate importTemplate) throws SAXException, ParserConfigurationException, IOException, JSONException {
        switch (importTemplate.getMetadata().getParserType()) {
            case ParserType.JSON:
                return Json2Json.parse(data, importTemplate);
            case ParserType.XML: //TODO: Implement XML2JSON
                JSONObject xml2Json = Xml2Json.parse(data);
                return Json2Json.parse(xml2Json.toString(), importTemplate);
            case ParserType.CSV: //TODO: Implement CSV2JSON
                ImportedData importedData = new ImportedData();
                //Parse data
                ImportParserMappings importParserMappings = importTemplate.getMappings().getDataMappings();
                importedData.data(Csv2Json.parse(data, importParserMappings));
                //Parse metadata
                importParserMappings = importTemplate.getMappings().getMetadataMappings();
                importedData.metadata(Csv2Json.parse(data, importParserMappings));
                return importedData;
            default:
                return null; //TODO: Use custom parser;
        }
    }

    public static ExportedData exportParser(String data, ExportTemplate exportTemplate) throws JSONException {
        //TODO: Implement export parser
        return null;
    }
}