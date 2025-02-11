package com.devteam45ldm.ldm.parser.types;

import com.devteam45ldm.ldm.parser.templates.Metadata;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportMappings;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportTemplate;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportedData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class Csv2JsonTest {

    private final Boolean debug = false;

    @Test
    void testBasicCsvConversion() throws JSONException {
        String csv = """
                #Version,1.0
                #Author,John
                
                name,age,city
                John,25,New York
                Jane,30,Boston""";

        ArrayList<String> metadataPath = new ArrayList<>();
        metadataPath.add("#.*");
        ArrayList<String> dataPath = new ArrayList<>();
        dataPath.add(".*");

        ImportMappings mappings = new ImportMappings()
                .metadata(metadataPath)
                .metadataPattern(Pattern.compile("^#(.+),(.+)$"))
                .data(dataPath)
                .dataPattern(Pattern.compile("^(?!#).*$"));

        ImportTemplate importTemplate = new ImportTemplate()
                .metadata(new Metadata())
                .data(mappings);

        ImportedData result = Csv2Json.parse(csv, importTemplate);

        if (debug) {
            System.out.println("Result: " + result);
        }

        // Verify metadata
        JSONObject metadata = new JSONObject(result.getMetadata());
        assertEquals("1.0", metadata.getString("Version"));
        assertEquals("John", metadata.getString("Author"));

        // Verify data
        JSONObject data = new JSONObject(result.getData());
        JSONArray rows = data.getJSONArray("data");
        assertEquals(2, rows.length());

        JSONObject row1 = rows.getJSONObject(0);
        assertEquals("John", row1.getString("name"));
        assertEquals("25", row1.getString("age"));
        assertEquals("New York", row1.getString("city"));

        JSONObject row2 = rows.getJSONObject(1);
        assertEquals("Jane", row2.getString("name"));
        assertEquals("30", row2.getString("age"));
        assertEquals("Boston", row2.getString("city"));
    }

    @Test
    void testCsvWithQuotedValues() throws JSONException {
        String csv = """
                #Name,"John Doe"
                #Company,"Acme, Inc"
                
                product,price,"description"
                "Item 1",99.99,"First, best item"
                "Item 2",49.99,"Second, good item\"""";

        ArrayList<String> metadataPath = new ArrayList<>();
        metadataPath.add("#.*");
        ArrayList<String> dataPath = new ArrayList<>();
        dataPath.add(".*");

        ImportMappings mappings = new ImportMappings()
                .metadata(metadataPath)
                .metadataPattern(Pattern.compile("^#(.+),(.+)$"))
                .data(dataPath)
                .dataPattern(Pattern.compile("^(?!#).*$"));

        ImportTemplate importTemplate = new ImportTemplate()
                .metadata(new Metadata())
                .data(mappings);

        ImportedData result = Csv2Json.parse(csv, importTemplate);

        // Verify metadata
        JSONObject metadata = new JSONObject(result.getMetadata());
        assertEquals("John Doe", metadata.getString("Name"));
        assertEquals("Acme, Inc", metadata.getString("Company"));

        // Verify data with quoted values
        JSONObject data = new JSONObject(result.getData());
        JSONArray rows = data.getJSONArray("data");
        assertEquals(2, rows.length());

        JSONObject row1 = rows.getJSONObject(0);
        assertEquals("Item 1", row1.getString("product"));
        assertEquals("First, best item", row1.getString("description"));
    }

    @Test
    void testEmptyMetadataSection() throws JSONException {
        String csv = """
                name,age,city
                John,25,New York""";

        ArrayList<String> dataPath = new ArrayList<>();
        dataPath.add(".*");

        ImportMappings mappings = new ImportMappings()
                .data(dataPath)
                .dataPattern(Pattern.compile(".*"));

        ImportTemplate importTemplate = new ImportTemplate()
                .metadata(new Metadata())
                .data(mappings);

        ImportedData result = Csv2Json.parse(csv, importTemplate);

        // Verify empty metadata
        JSONObject metadata = new JSONObject(result.getMetadata());
        assertEquals(0, metadata.length());

        // Verify data still processed
        JSONObject data = new JSONObject(result.getData());
        JSONArray rows = data.getJSONArray("data");
        assertEquals(1, rows.length());
    }

    @Test
    void testCustomSeparator() throws JSONException {
        String csv = """
                #Version;1.0
                #Author;John
                
                name;age;city
                John;25;New York""";

        ArrayList<String> metadataPath = new ArrayList<>();
        metadataPath.add("#.*");
        ArrayList<String> dataPath = new ArrayList<>();
        dataPath.add(".*");

        ImportMappings mappings = new ImportMappings()
                .metadata(metadataPath)
                .metadataPattern(Pattern.compile("^#(.+);(.+)$"))
                .metadataSeparator(";")
                .data(dataPath)
                .dataPattern(Pattern.compile("^(?!#).*$"))
                .dataSeparator(";");

        ImportTemplate importTemplate = new ImportTemplate()
                .metadata(new Metadata())
                .data(mappings);

        ImportedData result = Csv2Json.parse(csv, importTemplate);

        // Verify metadata
        JSONObject metadata = new JSONObject(result.getMetadata());
        assertEquals("1.0", metadata.getString("Version"));
        assertEquals("John", metadata.getString("Author"));

        // Verify data
        JSONObject data = new JSONObject(result.getData());
        JSONArray rows = data.getJSONArray("data");
        JSONObject row = rows.getJSONObject(0);
        assertEquals("John", row.getString("name"));
        assertEquals("25", row.getString("age"));
        assertEquals("New York", row.getString("city"));
    }
}