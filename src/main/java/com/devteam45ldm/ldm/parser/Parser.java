package com.devteam45ldm.ldm.parser;

import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportTemplate;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Parser {
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

    public Parser(ImportTemplate importTemplate) {
        this.importTemplate = importTemplate;
    }

    public
}