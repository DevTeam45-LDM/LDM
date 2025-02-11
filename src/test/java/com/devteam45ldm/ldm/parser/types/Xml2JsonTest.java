package com.devteam45ldm.ldm.parser.types;

import com.devteam45ldm.ldm.parser.templates.Metadata;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportMappings;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportTemplate;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportedData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

//TODO: Implement this test suite and adapt to the new Xml2Json implementation
class Xml2JsonTest {
    private final Boolean debug = false;

    @Test
    void parseXMLToJson_withValidXml_returnsJson() throws Exception {
        String xml = "<root><child attr=\"value\">text</child></root>";
        String metadataPath = "root.child.attr";
        String dataPath = "root.child.content";

        ArrayList<String> metadataPaths = new ArrayList<>();
        metadataPaths.add(metadataPath);
        ArrayList<String> dataPaths = new ArrayList<>();
        dataPaths.add(dataPath);

        ImportMappings mappings = new ImportMappings()
                .metadata(metadataPaths)
                .data(dataPaths);

        ImportTemplate importTemplate = new ImportTemplate()
                .metadata(new Metadata())
                .data(mappings);

        ImportedData result = Xml2Json.parse(xml, importTemplate);

        if(debug) {
            System.out.println("Result: " + result.toString());
        }

        JSONObject metadata = new JSONObject(result.getMetadata());
        assertEquals("value", metadata.getString("attr"));

        JSONObject data = new JSONObject(result.getData());
        assertEquals("text", data.getString("content"));
    }

    @Test
    void parseXMLToJson_withNestedElements_returnsJsonWithNestedStructure() throws Exception {
        String xml = "<root><child><subchild>text</subchild></child></root>";
        String path = "root.child.subchild";

        ArrayList<String> paths = new ArrayList<>();
        paths.add(path);

        ImportMappings mappings = new ImportMappings()
                .data(paths);

        ImportTemplate importTemplate = new ImportTemplate()
                .metadata(new Metadata())
                .data(mappings);

        ImportedData result = Xml2Json.parse(xml, importTemplate);

        if(debug) {
            System.out.println("Result: " + result.toString());
        }

        JSONObject data = new JSONObject(result.getData());
        assertEquals("text", data.getJSONObject("subchild").getString("content"));
    }

    @Test
    void parseXMLToJson_withRepeatedElements_returnsJsonWithArray() throws Exception {
        String xml = "<root><child>text1</child><child>text2</child></root>";
        String path = "root.child";

        ArrayList<String> paths = new ArrayList<>();
        paths.add(path);

        ImportMappings mappings = new ImportMappings()
                .data(paths);

        ImportTemplate importTemplate = new ImportTemplate()
                .metadata(new Metadata())
                .data(mappings);

        ImportedData result = Xml2Json.parse(xml, importTemplate);

        if(debug) {
            System.out.println("Result: " + result.toString());
        }

        JSONObject data = new JSONObject(result.getData());
        JSONArray children = data.getJSONArray("child");
        assertEquals("text1", children.getJSONObject(0).getString("content"));
        assertEquals("text2", children.getJSONObject(1).getString("content"));
    }

    @Test
    void parseXMLToJson_withInvalidXml_throwsException() {
        String xml = "<root><child></root>";
        String path = "root.child";

        ArrayList<String> paths = new ArrayList<>();
        paths.add(path);

        ImportMappings mappings = new ImportMappings()
                .data(paths);

        ImportTemplate importTemplate = new ImportTemplate()
                .metadata(new Metadata())
                .data(mappings);

        assertThrows(JSONException.class, () -> Xml2Json.parse(xml, importTemplate));
    }
}