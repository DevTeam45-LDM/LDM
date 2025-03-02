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
        ImportedData importedData = new ImportedData();

        switch (importTemplate.getMetadata().getParserType()) {
            case ParserType.JSON: //TODO: Implement JSON2JSON like CSV2JSON
                // Parse data
                ImportParserMappings importJSONParserMappings = importTemplate.getMappings().getDataMappings();
                importedData.data(Json2Json.parse(data, importJSONParserMappings));
                // Parse metadata
                importJSONParserMappings = importTemplate.getMappings().getMetadataMappings();
                importedData.metadata(Json2Json.parse(data, importJSONParserMappings));
                return importedData;
            case ParserType.XML: //TODO: Implement XML2JSON like CSV2JSON
                // Parse data
                ImportParserMappings importXMLParserMappings = importTemplate.getMappings().getDataMappings();
                importedData.data(Xml2Json.parse(data, importXMLParserMappings));
                // Parse metadata
                importXMLParserMappings = importTemplate.getMappings().getMetadataMappings();
                importedData.metadata(Xml2Json.parse(data, importXMLParserMappings));
                return importedData;
            case ParserType.CSV:
                //Parse data
                ImportParserMappings importCSVParserMappings = importTemplate.getMappings().getDataMappings();
                importedData.data(Csv2Json.parse(data, importCSVParserMappings));
                //Parse metadata
                importCSVParserMappings = importTemplate.getMappings().getMetadataMappings();
                importedData.metadata(Csv2Json.parse(data, importCSVParserMappings));
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