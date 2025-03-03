package com.devteam45ldm.ldm.parser.types;

import com.devteam45ldm.ldm.parser.templates.Metadata;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportMappings;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportParserMappings;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportTemplate;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportedData;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Json2JsonTest {

    private final boolean debug = false;

    @Test
    void debug_pathTransfer() {
        // Create path and mapping
        ArrayList<String> metadataPath = new ArrayList<>();
        metadataPath.add("kopfdaten");
        ImportParserMappings importParserMappings = new ImportParserMappings().path(metadataPath);
        ImportMappings mappings = new ImportMappings().metadata(importParserMappings);

        // Debug output
        System.out.println("Original path: " + metadataPath);
        System.out.println("Path in ImportMappings.getMetadata(): " + mappings.getMetadata());

        // Get the parser mappings
        ImportParserMappings parserMappings = mappings.getMetadata();
        System.out.println("Path in ImportParserMappings.getPath(): " + parserMappings.getPaths());

        // Verify path is not empty
        assertNotNull(parserMappings.getPaths(), "Path should not be null");
        assertFalse(parserMappings.getPaths().isEmpty(), "Path should not be empty");
        assertEquals("kopfdaten", parserMappings.getPaths().getFirst(), "Path should contain 'kopfdaten'");
    }

    /**
     * Tests the Json2Json parser with a simple JSON structure - metadata path.
     *
     * @throws JSONException if there is an error parsing the JSON.
     */
    @Test
    void parse_simpleStructureMetadata_returnsCorrectJson() throws JSONException {
        String json = "{ \"kopfdaten\": { \"maschine\": \"test\", \"hersteller\": \"vw\" }, \"messwerte\": { \"wert1\": \"1test\", \"wert2\": 2, \"wert3\": \"3test\", \"wert4\": 4, \"wert5\": 5, \"wert6\": \"6test\" } }";

        ArrayList<String> metadataPath = new ArrayList<>();
        metadataPath.add("kopfdaten");
        ImportParserMappings importParserMappings = new ImportParserMappings().path(metadataPath);
        ImportTemplate template = new ImportTemplate()
                .metadata(new Metadata())
                .mappings(new ImportMappings().metadata(importParserMappings));

        ImportParserMappings importParserMappings2 = template.getMappings().getMetadata();

        String result = Json2Json.parse(json, importParserMappings2);

        if (debug) {
            System.out.println(result);
        }

        JSONObject expectedMetadata = new JSONObject("{\"kopfdaten\":{\"maschine\":\"test\",\"hersteller\":\"vw\"}}");
        assertEquals(expectedMetadata.toString(), new JSONObject(result).toString());
    }

    /**
     * Tests the Json2Json parser with a simple JSON structure - data path.
     *
     * @throws JSONException if there is an error parsing the JSON.
     */
    @Test
    void parse_simpleStructureData_returnsCorrectJson() throws JSONException {
        String json = "{ \"kopfdaten\": { \"maschine\": \"test\", \"hersteller\": \"vw\" }, \"messwerte\": { \"wert1\": \"1test\", \"wert2\": 2, \"wert3\": \"3test\", \"wert4\": 4, \"wert5\": 5, \"wert6\": \"6test\" } }";

        ArrayList<String> dataPath = new ArrayList<>();
        dataPath.add("messwerte");
        ImportParserMappings importParserMappings = new ImportParserMappings().path(dataPath);
        ImportTemplate template = new ImportTemplate()
                .metadata(new Metadata())
                .mappings(new ImportMappings().data(importParserMappings));

        ImportParserMappings importParserMappings2 = template.getMappings().getData();

        String result = Json2Json.parse(json, importParserMappings2);

        if (debug) {
            System.out.println(result);
        }

        JSONObject expectedData = new JSONObject("{\"messwerte\":{\"wert1\":\"1test\",\"wert2\":2,\"wert3\":\"3test\",\"wert4\":4,\"wert5\":5,\"wert6\":\"6test\"}}");
        assertEquals(expectedData.toString(), new JSONObject(result).toString());
    }

    /**
     * Tests the Json2Json parser with a nested JSON structure - metadata path.
     *
     * @throws JSONException if there is an error parsing the JSON.
     */
    @Test
    void parse_nestedStructureMetadata_returnsCorrectJson() throws JSONException {
        String json = "{ \"kopfdaten\": { \"maschine\": \"test\", \"hersteller\": \"vw\", \"details\": { \"baujahr\": 2020, \"modell\": \"golf\" } }, \"messwerte\": { \"wert1\": \"1test\", \"wert2\": 2, \"wert3\": \"3test\", \"wert4\": 4, \"wert5\": 5, \"wert6\": \"6test\" } }";

        ArrayList<String> metadataPath = new ArrayList<>();
        metadataPath.add("kopfdaten.details");
        ImportParserMappings importParserMappings = new ImportParserMappings().path(metadataPath);
        ImportTemplate template = new ImportTemplate()
                .metadata(new Metadata())
                .mappings(new ImportMappings().metadata(importParserMappings));

        ImportParserMappings importParserMappings2 = template.getMappings().getMetadata();

        String result = Json2Json.parse(json, importParserMappings2);

        if (debug) {
            System.out.println(result);
        }

        JSONObject expectedMetadata = new JSONObject("{\"kopfdaten\":{\"details\":{\"baujahr\":2020,\"modell\":\"golf\"}}}");
        assertEquals(expectedMetadata.toString(), new JSONObject(result).toString());
    }

    /**
     * Tests the Json2Json parser with a deeply nested JSON structure - metadata path.
     *
     * @throws JSONException if there is an error parsing the JSON.
     */
    @Test
    void parse_deeplyNestedStructureMetadata_returnsCorrectJson() throws JSONException {
        String json = "{ \"kopfdaten\": { \"maschine\": \"test\", \"hersteller\": \"vw\", \"details\": { \"baujahr\": 2020, \"modell\": \"golf\", \"spezifikationen\": { \"farbe\": \"rot\", \"ps\": 150 } } }, \"messwerte\": { \"wert1\": \"1test\", \"wert2\": 2, \"wert3\": \"3test\", \"wert4\": 4, \"wert5\": 5, \"wert6\": \"6test\" } }";

        ArrayList<String> metadataPath = new ArrayList<>();
        metadataPath.add("kopfdaten.details.spezifikationen");
        ImportParserMappings importParserMappings = new ImportParserMappings().path(metadataPath);
        ImportTemplate template = new ImportTemplate()
                .metadata(new Metadata())
                .mappings(new ImportMappings().metadata(importParserMappings));

        ImportParserMappings importParserMappings2 = template.getMappings().getMetadata();

        String result = Json2Json.parse(json, importParserMappings2);

        if (debug) {
            System.out.println(result);
        }

        JSONObject expectedMetadata = new JSONObject("{\"kopfdaten\":{\"details\":{\"spezifikationen\":{\"farbe\":\"rot\",\"ps\":150}}}}");
        assertEquals(expectedMetadata.toString(), new JSONObject(result).toString());
    }

    /**
     * Tests the Json2Json parser with a deeply nested JSON structure - non deepest level.
     *
     * @throws JSONException if there is an error parsing the JSON.
     */
    @Test
    void parse_nonDeepestLevel_returnsCorrectJson() throws JSONException {
        String json = "{ \"kopfdaten\": { \"maschine\": \"test\", \"hersteller\": \"vw\", \"details\": { \"baujahr\": 2020, \"modell\": \"golf\", \"spezifikationen\": { \"farbe\": \"rot\", \"ps\": 150 } } }, \"messwerte\": { \"wert1\": \"1test\", \"wert2\": 2, \"wert3\": \"3test\", \"wert4\": 4, \"wert5\": 5, \"wert6\": \"6test\" } }";

        ArrayList<String> dataPath = new ArrayList<>();
        dataPath.add("kopfdaten.details.spezifikationen");
        ImportParserMappings importParserMappings = new ImportParserMappings().path(dataPath);
        ImportTemplate template = new ImportTemplate()
                .metadata(new Metadata())
                .mappings(new ImportMappings().data(importParserMappings));

        ImportParserMappings importParserMappings2 = template.getMappings().getData();

        String result = Json2Json.parse(json, importParserMappings2);

        if (debug) {
            System.out.println(result);
        }

        JSONObject expectedData = new JSONObject("{\"kopfdaten\":{\"details\":{\"spezifikationen\":{\"farbe\":\"rot\",\"ps\":150}}}}");
        assertEquals(expectedData.toString(), new JSONObject(result).toString());
    }

    /**
     * Tests the Json2Json parser with multiple paths.
     *
     * @throws JSONException if there is an error parsing the JSON.
     */
    @Test
    void parse_multipleSelections_returnsCorrectJson() throws JSONException {
        String json = "{ \"kopfdaten\": { \"maschine\": \"test\", \"hersteller\": \"vw\", \"details\": { \"baujahr\": 2020, \"modell\": \"golf\", \"spezifikationen\": { \"farbe\": \"rot\", \"ps\": 150 } } }, \"messwerte\": { \"wert1\": \"1test\", \"wert2\": 2, \"wert3\": \"3test\", \"wert4\": 4, \"wert5\": 5, \"wert6\": \"6test\" } }";

        ArrayList<String> metadataPath = new ArrayList<>();
        metadataPath.add("kopfdaten.details");
        metadataPath.add("kopfdaten.details.spezifikationen");
        ImportParserMappings importParserMappings = new ImportParserMappings().path(metadataPath);
        ImportTemplate template = new ImportTemplate()
                .metadata(new Metadata())
                .mappings(new ImportMappings().metadata(importParserMappings));

        ImportParserMappings importParserMappings2 = template.getMappings().getMetadata();

        String result = Json2Json.parse(json, importParserMappings2);

        if (debug) {
            System.out.println(result);
        }

        JSONObject expectedMetadata = new JSONObject("{\"kopfdaten\":{\"details\":{\"baujahr\":2020,\"modell\":\"golf\",\"spezifikationen\":{\"farbe\":\"rot\",\"ps\":150}}}}");
        assertEquals(expectedMetadata.toString(), new JSONObject(result).toString());
    }

    /**
     * Tests the Json2Json parser with a path that doesn't exist.
     *
     * @throws JSONException if there is an error parsing the JSON.
     */
    @Test
    void parse_nonExistentPath_returnsEmptyJson() throws JSONException {
        String json = "{ \"kopfdaten\": { \"maschine\": \"test\" } }";

        ArrayList<String> dataPath = new ArrayList<>();
        dataPath.add("nonexistent.path");
        ImportParserMappings importParserMappings = new ImportParserMappings().path(dataPath);
        ImportTemplate template = new ImportTemplate()
                .metadata(new Metadata())
                .mappings(new ImportMappings().data(importParserMappings));

        ImportParserMappings importParserMappings2 = template.getMappings().getData();

        String result = Json2Json.parse(json, importParserMappings2);

        if (debug) {
            System.out.println(result);
        }

        JSONObject expectedData = new JSONObject("{}");
        assertEquals(expectedData.toString(), new JSONObject(result).toString());
    }

    /**
     * Tests the Json2Json parser with empty paths.
     */
    @Test
    void parse_emptyPaths_throwsException() {
        String json = "{ \"kopfdaten\": { \"maschine\": \"test\" } }";

        ArrayList<String> emptyPaths = new ArrayList<>();
        ImportParserMappings importParserMappings = new ImportParserMappings().path(emptyPaths);
        ImportTemplate template = new ImportTemplate()
                .metadata(new Metadata())
                .mappings(new ImportMappings().data(importParserMappings));

        ImportParserMappings importParserMappings2 = template.getMappings().getData();

        assertThrows(JSONException.class, () -> Json2Json.parse(json, importParserMappings2));
    }

    /**
     * Tests the Json2Json parser with an invalid JSON string.
     */
    @Test
    void parse_invalidJson_throwsException() {
        String invalidJson = "{ invalid json }";

        ArrayList<String> dataPath = new ArrayList<>();
        dataPath.add("kopfdaten");
        ImportParserMappings importParserMappings = new ImportParserMappings().path(dataPath);
        ImportTemplate template = new ImportTemplate()
                .metadata(new Metadata())
                .mappings(new ImportMappings().data(importParserMappings));

        ImportParserMappings importParserMappings2 = template.getMappings().getData();

        assertThrows(JSONException.class, () -> Json2Json.parse(invalidJson, importParserMappings2));
    }

    /**
     * Tests creating an ImportedData object combining results from multiple parse calls.
     *
     * @throws JSONException if there is an error parsing the JSON.
     */
    @Test
    void createImportedData_fromParseResults_returnsCorrectObject() throws JSONException {
        String json = "{ \"kopfdaten\": { \"maschine\": \"test\", \"hersteller\": \"vw\" }, \"messwerte\": { \"wert1\": \"1test\", \"wert2\": 2, \"wert3\": \"3test\", \"wert4\": 4, \"wert5\": 5, \"wert6\": \"6test\" } }";

        ArrayList<String> metadataPath = new ArrayList<>();
        metadataPath.add("kopfdaten");
        ArrayList<String> dataPath = new ArrayList<>();
        dataPath.add("messwerte");
        ImportParserMappings metadataMappings = new ImportParserMappings().path(metadataPath);
        ImportParserMappings dataMappings = new ImportParserMappings().path(dataPath);
        ImportTemplate template = new ImportTemplate()
                .metadata(new Metadata())
                .mappings(new ImportMappings().metadata(metadataMappings).data(dataMappings));

        ImportParserMappings metadataMappings2 = template.getMappings().getMetadata();
        ImportParserMappings dataMappings2 = template.getMappings().getData();

        // Create ImportedData by combining results from parse calls
        ImportedData importedData = new ImportedData()
                .metadata(Json2Json.parse(json, metadataMappings2))
                .data(Json2Json.parse(json, dataMappings2));

        JSONObject expectedMetadata = new JSONObject("{\"kopfdaten\":{\"maschine\":\"test\",\"hersteller\":\"vw\"}}");
        JSONObject expectedData = new JSONObject("{\"messwerte\":{\"wert1\":\"1test\",\"wert2\":2,\"wert3\":\"3test\",\"wert4\":4,\"wert5\":5,\"wert6\":\"6test\"}}");

        assertEquals(expectedMetadata.toString(), new JSONObject(importedData.getMetadata()).toString());
        assertEquals(expectedData.toString(), new JSONObject(importedData.getData()).toString());
    }
}