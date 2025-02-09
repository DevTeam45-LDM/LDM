package com.devteam45ldm.ldm.parser;

import com.devteam45ldm.ldm.parser.templates.Metadata;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.Import;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportMappings;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportTemplate;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Json2JsonTest {

    /**
     * Tests the Json2Json parser with a simple JSON structure.
     *
     * @throws JSONException if there is an error parsing the JSON.
     */
    @Test
    void testJson2JsonParser() throws JSONException {
        String json = "{ \"kopfdaten\": { \"maschine\": \"test\", \"hersteller\": \"vw\" }, \"messwerte\": { \"wert1\": \"1test\", \"wert2\": 2, \"wert3\": \"3test\", \"wert4\": 4, \"wert5\": 5, \"wert6\": \"6test\" } }";

        ImportMappings mappings = new ImportMappings()
                .metadata("kopfdaten")
                .data("messwerte");

        ImportTemplate importTemplate = new ImportTemplate()
                .metadata(new Metadata())
                .data(mappings);

        Json2Json parser = new Json2Json(importTemplate);
        Import result = parser.convert(json);

        JSONObject expectedMetadata = new JSONObject("{\"maschine\":\"test\",\"hersteller\":\"vw\"}");
        JSONObject expectedData = new JSONObject("{\"wert1\":\"1test\",\"wert2\":2,\"wert3\":\"3test\",\"wert4\":4,\"wert5\":5,\"wert6\":\"6test\"}");

        assertEquals(expectedMetadata.toString(), new JSONObject(result.getMetadata()).toString());
        assertEquals(expectedData.toString(), new JSONObject(result.getData()).toString());
    }

    /**
     * Tests the Json2Json parser with a nested JSON structure.
     *
     * @throws JSONException if there is an error parsing the JSON.
     */
    @Test
    void testNestedJson2JsonParser() throws JSONException {
        String json = "{ \"kopfdaten\": { \"maschine\": \"test\", \"hersteller\": \"vw\", \"details\": { \"baujahr\": 2020, \"modell\": \"golf\" } }, \"messwerte\": { \"wert1\": \"1test\", \"wert2\": 2, \"wert3\": \"3test\", \"wert4\": 4, \"wert5\": 5, \"wert6\": \"6test\" } }";

        ImportMappings mappings = new ImportMappings()
                .metadata("kopfdaten.details")
                .data("messwerte");

        ImportTemplate importTemplate = new ImportTemplate()
                .metadata(new Metadata())
                .data(mappings);

        Json2Json parser = new Json2Json(importTemplate);
        Import result = parser.convert(json);

        JSONObject expectedMetadata = new JSONObject("{\"baujahr\":2020,\"modell\":\"golf\"}");
        JSONObject expectedData = new JSONObject("{\"wert1\":\"1test\",\"wert2\":2,\"wert3\":\"3test\",\"wert4\":4,\"wert5\":5,\"wert6\":\"6test\"}");

        assertEquals(expectedMetadata.toString(), new JSONObject(result.getMetadata()).toString());
        assertEquals(expectedData.toString(), new JSONObject(result.getData()).toString());
    }

    /**
     * Tests the Json2Json parser with a deeply nested JSON structure.
     *
     * @throws JSONException if there is an error parsing the JSON.
     */
    @Test
    void testDeeplyNestedJson2JsonParser() throws JSONException {
        String json = "{ \"kopfdaten\": { \"maschine\": \"test\", \"hersteller\": \"vw\", \"details\": { \"baujahr\": 2020, \"modell\": \"golf\", \"spezifikationen\": { \"farbe\": \"rot\", \"ps\": 150 } } }, \"messwerte\": { \"wert1\": \"1test\", \"wert2\": 2, \"wert3\": \"3test\", \"wert4\": 4, \"wert5\": 5, \"wert6\": \"6test\" } }";

        ImportMappings mappings = new ImportMappings()
                .metadata("kopfdaten.details.spezifikationen")
                .data("messwerte");

        ImportTemplate importTemplate = new ImportTemplate()
                .metadata(new Metadata())
                .data(mappings);

        Json2Json parser = new Json2Json(importTemplate);
        Import result = parser.convert(json);

        JSONObject expectedMetadata = new JSONObject("{\"farbe\":\"rot\",\"ps\":150}");
        JSONObject expectedData = new JSONObject("{\"wert1\":\"1test\",\"wert2\":2,\"wert3\":\"3test\",\"wert4\":4,\"wert5\":5,\"wert6\":\"6test\"}");

        assertEquals(expectedMetadata.toString(), new JSONObject(result.getMetadata()).toString());
        assertEquals(expectedData.toString(), new JSONObject(result.getData()).toString());
    }
}