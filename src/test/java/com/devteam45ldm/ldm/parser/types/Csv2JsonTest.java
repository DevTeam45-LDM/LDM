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

    private final boolean debug = false;

    @Test
    void parse_validCsvWithMetadataSeparator_returnsCorrectJson() throws Exception {
        String csv = "name,age,city\nJohn,30,New York\nJane,25,Los Angeles";
        ImportParserMappings importParserMappings = new ImportParserMappings().delimiter(",").hasHeadline(true);
        ImportTemplate template = new ImportTemplate()
                .metadata(new Metadata())
                .mappings(new ImportMappings().metadata(importParserMappings));  // Changed from .data to .mappings
        ImportParserMappings importParserMappings2 = template.getMappings().getMetadata();

        String result = Csv2Json.parse(csv, importParserMappings2);

        if (debug) {
            System.out.println(result);
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
    void parse_validCsvWithMetadataSeparatorAndTotalColumns_returnsCorrectJson() throws Exception {
        String csv = "name,age,city\nJohn,30,New York\nJane,25,Los Angeles\nJane,25,Los Angeles,Test,Test2,Test3,Test4\nJane,25,Los Angeles,Test5,Test2\ntest";
        ImportParserMappings importParserMappings = new ImportParserMappings().delimiter(",").hasHeadline(true).totalColumns(3);
        ImportTemplate template = new ImportTemplate()
                .metadata(new Metadata())
                .mappings(new ImportMappings().metadata(importParserMappings));  // Changed from .data to .mappings
        ImportParserMappings importParserMappings2 = template.getMappings().getMetadata();

        String result = Csv2Json.parse(csv, importParserMappings2);

        if (debug) {
            System.out.println(result);
        }

        JSONArray jsonArray = new JSONArray(result);
        assertEquals(5, jsonArray.length());

        JSONObject firstRow = jsonArray.getJSONObject(0);
        assertEquals("John", firstRow.getString("name"));
        assertEquals("30", firstRow.getString("age"));
        assertEquals("New York", firstRow.getString("city"));

        JSONObject secondRow = jsonArray.getJSONObject(1);
        assertEquals("Jane", secondRow.getString("name"));
        assertEquals("25", secondRow.getString("age"));
        assertEquals("Los Angeles", secondRow.getString("city"));

        JSONObject thirdRow = jsonArray.getJSONObject(2);
        assertEquals("Jane", thirdRow.getString("name"));
        assertEquals("25", thirdRow.getString("age"));
        assertEquals("[\"Los Angeles\",\"Test\",\"Test2\",\"Test3\",\"Test4\"]", thirdRow.getString("city"));

        JSONObject fourthRow = jsonArray.getJSONObject(3);
        assertEquals("Jane", fourthRow.getString("name"));
        assertEquals("25", fourthRow.getString("age"));
        assertEquals("[\"Los Angeles\",\"Test5\",\"Test2\"]", fourthRow.getString("city"));

        JSONObject fifthRow = jsonArray.getJSONObject(4);
        assertEquals("test", fifthRow.getString("name"));
        assertEquals("null", fifthRow.getString("age"));
        assertEquals("null", fifthRow.getString("city"));
    }

    @Test
    void parse_validCsvWithDataSeparator_returnsCorrectJson() throws Exception {
        String csv = "name;age;city\nJohn;30;New York\nJane;25;Los Angeles";
        ImportParserMappings importParserMappings = new ImportParserMappings().delimiter(";").hasHeadline(true);
        ImportTemplate template = new ImportTemplate()
                .metadata(new Metadata())
                .mappings(new ImportMappings().metadata(importParserMappings));

        ImportParserMappings importParserMappings2 = template.getMappings().getMetadata();

        String result = Csv2Json.parse(csv, importParserMappings2);

        if (debug) {
            System.out.println(result);
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
        ImportParserMappings importParserMappings = new ImportParserMappings().delimiter(",");
        ImportTemplate template = new ImportTemplate()
                .metadata(new Metadata())
                .mappings(new ImportMappings().data(importParserMappings));

        ImportParserMappings importParserMappings2 = template.getMappings().getData();

        assertThrows(JSONException.class, () -> Csv2Json.parse(csv, importParserMappings2));
    }

    @Test
    void parse_csvWithOnlyHeaders_returnsEmptyArray() throws Exception {
        String csv = "name,age,city";
        ImportParserMappings importParserMappings = new ImportParserMappings().delimiter(",").hasHeadline(true);
        ImportTemplate template = new ImportTemplate()
                .metadata(new Metadata())
                .mappings(new ImportMappings().data(importParserMappings));

        ImportParserMappings importParserMappings2 = template.getMappings().getData();

        String result = Csv2Json.parse(csv, importParserMappings2);

        if (debug) {
            System.out.println(result);
        }

        JSONArray jsonArray = new JSONArray(result);
        assertEquals(0, jsonArray.length());
    }

    @Test
    void parse_csvWithDefaultSeparator_throwsNoException() throws Exception{
        String csv = "name,age,city\nJohn,30,New York";
        ImportParserMappings importParserMappings = new ImportParserMappings().delimiter(",").hasHeadline(true);
        ImportTemplate template = new ImportTemplate()
                .metadata(new Metadata())
                .mappings(new ImportMappings().metadata(importParserMappings));
        ImportedData expectedImportedData = new ImportedData().metadata("[{\"name\":\"John\",\"age\":\"30\",\"city\":\"New York\"}]");

        ImportParserMappings importParserMappings2 = template.getMappings().getMetadata();

        ImportedData importedData = new ImportedData();
        importedData.metadata(Csv2Json.parse(csv, importParserMappings));

        assertEquals(expectedImportedData,importedData);
    }

    @Test
    void parse_csvWithDefaultSeparatorAndNoHeadline_throwsNoException() throws Exception{
        String csv = "John,30,New York";
        ImportParserMappings importParserMappings = new ImportParserMappings().delimiter(",").hasHeadline(false);
        ImportTemplate template = new ImportTemplate()
                .metadata(new Metadata())
                .mappings(new ImportMappings().metadata(importParserMappings));
        ImportedData expectedImportedData = new ImportedData().metadata("[{\"column1\":\"John\",\"column2\":\"30\",\"column3\":\"New York\"}]");

        ImportParserMappings importParserMappings2 = template.getMappings().getMetadata();

        ImportedData importedData = new ImportedData();
        importedData.metadata(Csv2Json.parse(csv, importParserMappings2));

        assertEquals(expectedImportedData,importedData);
    }

    @Test
    void parse_csvWithFewerValuesThanHeaders_handlesGracefully() throws Exception {
        String csv = "name,age,city\nJohn,30";
        ImportParserMappings importParserMappings = new ImportParserMappings().delimiter(",").hasHeadline(true);
        ImportTemplate template = new ImportTemplate()
                .metadata(new Metadata())
                .mappings(new ImportMappings().metadata(importParserMappings));

        ImportParserMappings importParserMappings2 = template.getMappings().getMetadata();

        String result = Csv2Json.parse(csv, importParserMappings2);
        if (debug) {
            System.out.println(result);
        }
        JSONArray jsonArray = new JSONArray(result);

        JSONObject row = jsonArray.getJSONObject(0);
        assertEquals("John", row.getString("name"));
        assertEquals("30", row.getString("age"));
        assertEquals("null", row.getString("city"));
    }
}