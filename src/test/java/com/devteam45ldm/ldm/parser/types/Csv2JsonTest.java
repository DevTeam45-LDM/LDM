package com.devteam45ldm.ldm.parser.types;

import com.devteam45ldm.ldm.parser.templates.Metadata;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportMappings;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportParserMappings;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportTemplate;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportedData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Csv2JsonTest {

    private final boolean debug = true;

    @Test
    void parse_validCsvWithMetadataSeparator_returnsCorrectJson() throws Exception {
        String csv = "name,age,city\nJohn,30,New York\nJane,25,Los Angeles";

        ImportTemplate template = new ImportTemplate()
                .metadata(new Metadata())
                .mappings(new ImportMappings().metadataDelimiter(",").metadataHasHeadline(true));  // Changed from .data to .mappings
        ImportParserMappings importParserMappings = template.getMappings().getMetadataMappings();

        String result = Csv2Json.parse(csv, importParserMappings);

        if (debug) {
            System.out.println(result.toString());
        }

        JSONArray jsonArray = new JSONArray(result);
        assertEquals(2, jsonArray.length());

        JSONObject firstRow = jsonArray.getJSONObject(0);
        assertEquals("John", firstRow.getString("name"));
        assertEquals("30", firstRow.getString("age"));
        assertEquals("New York", firstRow.getString("city"));

        JSONObject secondRow = jsonArray.getJSONObject(1);
        assertEquals("Jane", secondRow.getString("name"));
        assertEquals("25", secondRow.getString("age"));
        assertEquals("Los Angeles", secondRow.getString("city"));
    }

    @Test
    void parse_validCsvWithDataSeparator_returnsCorrectJson() throws Exception {
        String csv = "name;age;city\nJohn;30;New York\nJane;25;Los Angeles";

        ImportTemplate template = new ImportTemplate()
                .metadata(new Metadata())
                .mappings(new ImportMappings().metadataDelimiter(";").metadataHasHeadline(true));

        ImportParserMappings importParserMappings = template.getMappings().getMetadataMappings();

        String result = Csv2Json.parse(csv, importParserMappings);

        if (debug) {
            System.out.println(result.toString());
        }

        JSONArray jsonArray = new JSONArray(result);
        assertEquals(2, jsonArray.length());

        JSONObject firstRow = jsonArray.getJSONObject(0);
        assertEquals("John", firstRow.getString("name"));
        assertEquals("30", firstRow.getString("age"));
        assertEquals("New York", firstRow.getString("city"));

        JSONObject secondRow = jsonArray.getJSONObject(1);
        assertEquals("Jane", secondRow.getString("name"));
        assertEquals("25", secondRow.getString("age"));
        assertEquals("Los Angeles", secondRow.getString("city"));
    }

    @Test
    void parse_emptyCSV_throwsException() throws Exception {
        String csv = "";
        ImportTemplate template = new ImportTemplate()
                .metadata(new Metadata())
                .mappings(new ImportMappings().dataDelimiter(","));

        ImportParserMappings importParserMappings = template.getMappings().getDataMappings();

        assertThrows(JSONException.class, () -> Csv2Json.parse(csv, importParserMappings));
    }

    @Test
    void parse_csvWithOnlyHeaders_returnsEmptyArray() throws Exception {
        String csv = "name,age,city";
        ImportTemplate template = new ImportTemplate()
                .metadata(new Metadata())
                .mappings(new ImportMappings().dataDelimiter(",").dataHasHeadline(true));

        ImportParserMappings importParserMappings = template.getMappings().getDataMappings();

        String result = Csv2Json.parse(csv, importParserMappings);

        if (debug) {
            System.out.println(result.toString());
        }

        JSONArray jsonArray = new JSONArray(result);
        assertEquals(0, jsonArray.length());
    }

    @Test
    void parse_csvWithDefaultSeparator_throwsNoException() throws Exception{
        String csv = "name,age,city\nJohn,30,New York";
        ImportTemplate template = new ImportTemplate()
                .metadata(new Metadata())
                .mappings(new ImportMappings().metadataDelimiter(",").metadataHasHeadline(true));
        ImportedData expectedImportedData = new ImportedData().metadata("[{\"city\":\"New York\",\"name\":\"John\",\"age\":\"30\"}]");

        ImportParserMappings importParserMappings = template.getMappings().getMetadataMappings();

        assertEquals(expectedImportedData,Csv2Json.parse(csv, importParserMappings));
    }

    @Test
    void parse_csvWithDefaultSeparatorAndNoHeadline_throwsNoException() throws Exception{
        String csv = "John,30,New York";
        ImportTemplate template = new ImportTemplate()
                .metadata(new Metadata())
                .mappings(new ImportMappings().metadataDelimiter(",").metadataHasHeadline(false));
        ImportedData expectedImportedData = new ImportedData().metadata("[{\"city\":\"New York\",\"name\":\"John\",\"age\":\"30\"}]");

        ImportParserMappings importParserMappings = template.getMappings().getMetadataMappings();

        assertEquals(expectedImportedData,Csv2Json.parse(csv, importParserMappings));
    }

    @Test
    void parse_csvWithFewerValuesThanHeaders_handlesGracefully() throws Exception {
        String csv = "name,age,city\nJohn,30";
        ImportTemplate template = new ImportTemplate()
                .metadata(new Metadata())
                .mappings(new ImportMappings().metadataDelimiter(",").metadataHasHeadline(true));

        ImportParserMappings importParserMappings = template.getMappings().getMetadataMappings();

        String result = Csv2Json.parse(csv, importParserMappings);
        if (debug) {
            System.out.println(result.toString());
        }
        JSONArray jsonArray = new JSONArray(result);

        JSONObject row = jsonArray.getJSONObject(0);
        assertEquals("John", row.getString("name"));
        assertEquals("30", row.getString("age"));
        assertFalse(row.has("city"));
    }
}