package com.devteam45ldm.ldm.parser;

import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportedData;
import com.devteam45ldm.ldm.parser.types.Csv2Json;
import com.devteam45ldm.ldm.parser.types.Custom2Json;
import com.devteam45ldm.ldm.parser.types.Json2Json;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportTemplate;
import com.devteam45ldm.ldm.parser.types.Xml2Json;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONException;

public class ParserController {
    public enum ParserType {
        @JsonProperty("json_2_json")
        JSON2JSON("json_2_json", Json2Json.class),
        @JsonProperty("xml_2_json")
        XML2JSON("xml_2_json", Xml2Json.class),
        @JsonProperty("csv_2_json")
        CSV2JSON("csv_2_json", Csv2Json.class),
        @JsonProperty("custom_2_json")
        CUSTOM2JSON("custom_2_json", Custom2Json.class);

        private final String value;
        private final Class<?> clazz;

        ParserType(String value, Class<?> clazz) {
            this.value = value;
            this.clazz = clazz;
        }

        public String getDescription() {
            return value;
        }

        public Class<?> getClazz() {
            return clazz;
        }
    }
    private final ImportTemplate importTemplate;

    public ParserController(ImportTemplate importTemplate) {
        this.importTemplate = importTemplate;
    }

    public ImportedData convert(String data, ParserType parserType) throws JSONException {
        switch (parserType) {
            case JSON2JSON:
                return Json2Json.parse(data, importTemplate);
            //case XML2JSON: //TODO: Implement XML2JSON
            //    return new Xml2Json().convert(data).toJson();
            //case CSV2JSON: //TODO: Implement CSV2JSON
            //    return new Csv2Json(importTemplate).convert(data);
            //case CUSTOM2JSON: //TODO: Implement CUSTOM2JSON
            //    return new Custom2Json(importTemplate).convert(data);
            default:
                throw new IllegalArgumentException("Invalid parser type");
        }
    }
}