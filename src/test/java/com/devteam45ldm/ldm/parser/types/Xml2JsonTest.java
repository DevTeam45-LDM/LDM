package com.devteam45ldm.ldm.parser.types;

import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportParserMappings;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Xml2JsonTest {

    private final Boolean debug = true;

    @Test
    void parseXmlToJson_simpleElement_returnsCorrectJson() throws Exception {
        String xml = "<root><child>testString</child></root>";
        JSONObject json = Xml2Json.parseXmlToJson(xml);

        if(debug) {
            System.out.println(json.toString(2));
        }

        JSONObject root = json.getJSONObject("root");
        String childValue = root.getString("child");
        assertEquals("testString", childValue);

        String expected = """
        {
          "root": {
            "child": "testString"
          }
        }""";
        assertEquals(expected, json.toString(2));
    }

    @Test
    void parseXmlToJson_withAttribute_returnsCorrectJson() throws Exception {
        String xml = "<root><child testAttr=\"valueMJ\">testString</child></root>";
        JSONObject json = Xml2Json.parseXmlToJson(xml);

        if(debug) {
            System.out.println(json.toString(2));
        }

        JSONObject root = json.getJSONObject("root");
        JSONObject child = root.getJSONObject("child");
        assertEquals("valueMJ", child.getString("testAttr"));
        assertEquals("testString", child.getString("__child"));

        String expected = """
        {
          "root": {
            "child": {
              "__child": "testString",
              "testAttr": "valueMJ"
            }
          }
        }""";
        assertEquals(expected, json.toString(2));
    }

    @Test
    void parseXmlToJson_multipleAttributes_returnsCorrectJson() throws Exception {
        String xml = "<root><child id=\"1\" type=\"test\">content</child></root>";
        JSONObject json = Xml2Json.parseXmlToJson(xml);

        if(debug) {
            System.out.println(json.toString(2));
        }

        JSONObject child = json.getJSONObject("root").getJSONObject("child");
        assertEquals("1", child.getString("id"));
        assertEquals("test", child.getString("type"));
        assertEquals("content", child.getString("__child"));

        String expected = """
        {
          "root": {
            "child": {
              "id": "1",
              "type": "test",
              "__child": "content"
            }
          }
        }""";
        assertEquals(expected, json.toString(2));
    }

    @Test
    void parseXmlToJson_repeatedElements_returnsJsonArray() throws Exception {
        String xml = "<root><child>value1</child><child>value2</child></root>";
        JSONObject json = Xml2Json.parseXmlToJson(xml);

        if(debug) {
            System.out.println(json.toString(2));
        }

        JSONObject root = json.getJSONObject("root");
        JSONArray children = root.getJSONArray("child");
        assertEquals(2, children.length());
        assertEquals("value1", children.getString(0));
        assertEquals("value2", children.getString(1));

        String expected = """
        {
          "root": {
            "child": [
              "value1",
              "value2"
            ]
          }
        }""";
        assertEquals(expected, json.toString(2));
    }

    @Test
    void parseXmlToJson_repeatedElementsWithAttributes_returnsJsonArray() throws Exception {
        String xml = "<root><child attr=\"hi\">value1</child><child>value2</child></root>";
        JSONObject json = Xml2Json.parseXmlToJson(xml);

        if(debug) {
            System.out.println(json.toString(2));
        }

        String expected = """
        {
          "root": {
            "child": [
              {
                "attr": "hi",
                "__child": "value1"
              },
              "value2"
            ]
          }
        }""";
        assertEquals(expected, json.toString(2));
    }

    @Test
    void parseXmlToJson_nestedElements_returnsNestedJson() throws Exception {
        String xml = "<root><parent><child>value</child></parent></root>";
        JSONObject json = Xml2Json.parseXmlToJson(xml);

        if(debug) {
            System.out.println(json.toString(2));
        }

        JSONObject root = json.getJSONObject("root");
        JSONObject parent = root.getJSONObject("parent");
        assertEquals("value", parent.getString("child"));
    }

    @Test
    void parseXmlToJson_emptyElement_returnsEmptyObject() throws Exception {
        String xml = "<root><child></child></root>";
        JSONObject json = Xml2Json.parseXmlToJson(xml);

        if(debug) {
            System.out.println(json.toString(2));
        }

        JSONObject root = json.getJSONObject("root");
        assertTrue(root.has("child"));
        JSONObject child = root.getJSONObject("child");
        assertEquals(0, child.length());
    }

    @Test
    void parseXmlToJson_emptyWithAttribute_returnsOnlyAttribute() throws Exception {
        String xml = "<root><child id=\"1\"></child></root>";
        JSONObject json = Xml2Json.parseXmlToJson(xml);

        if(debug) {
            System.out.println(json.toString(2));
        }

        JSONObject root = json.getJSONObject("root");
        JSONObject child = root.getJSONObject("child");
        assertEquals("1", child.getString("id"));
        assertEquals(1, child.length());
    }

    @Test
    void parseXmlToJson_invalidXml_throwsSAXException() {
        String xml = "<root><child></root>";
        assertThrows(SAXException.class, () -> Xml2Json.parseXmlToJson(xml));
    }

    @Test
    void parseXmlToJson_mixedContent_handlesCorrectly() throws Exception {
        String xml = "<root><child>Start<nested>value</nested>End</child></root>";
        JSONObject json = Xml2Json.parseXmlToJson(xml);

        if(debug) {
            System.out.println(json.toString(2));
        }

        JSONObject root = json.getJSONObject("root");
        JSONObject child = root.getJSONObject("child");
        assertEquals("value", child.getString("nested"));
        assertEquals("StartEnd", child.getString("__child"));
    }

    @Test
    void parseXmlToJson_complexStructure_handlesCorrectly() throws Exception {
        String xml =
                "<data>" +
                        "<person id=\"1\">" +
                        "<name>John</name>" +
                        "<contacts>" +
                        "<email type=\"work\">john@work.com</email>" +
                        "<email type=\"home\">john@home.com</email>" +
                        "</contacts>" +
                        "</person>" +
                        "</data>";

        JSONObject json = Xml2Json.parseXmlToJson(xml);

        if(debug) {
            System.out.println(json.toString(2));
        }

        JSONObject data = json.getJSONObject("data");
        JSONObject person = data.getJSONObject("person");
        assertEquals("1", person.getString("id"));
        assertEquals("John", person.getString("name"));

        // contacts is an object containing email array
        JSONObject contacts = person.getJSONObject("contacts");
        JSONArray emails = contacts.getJSONArray("email");
        assertEquals(2, emails.length());

        JSONObject workEmail = emails.getJSONObject(0);
        assertEquals("work", workEmail.getString("type"));
        assertEquals("john@work.com", workEmail.getString("__email"));

        JSONObject homeEmail = emails.getJSONObject(1);
        assertEquals("home", homeEmail.getString("type"));
        assertEquals("john@home.com", homeEmail.getString("__email"));
    }

    @Test
    void parse_withPathMapping_extractsCorrectData() throws Exception {
        // Setup test data
        String xml =
                "<root>" +
                        "<metadata>" +
                        "<version>1.0</version>" +
                        "<author>Test User</author>" +
                        "</metadata>" +
                        "<data>" +
                        "<item id=\"1\">First Item</item>" +
                        "<item id=\"2\">Second Item</item>" +
                        "</data>" +
                        "</root>";

        // Create mapping for metadata path
        ArrayList<String> paths = new ArrayList<>();
        paths.add("root.metadata");

        // Create mock ImportParserMappings
        ImportParserMappings mappings = new ImportParserMappings().path(paths);

        // Test the parse method with path mappings
        String result = Xml2Json.parse(xml, mappings);
        JSONObject jsonResult = new JSONObject(result);

        if (debug) {
            System.out.println("Path extraction result:");
            System.out.println(jsonResult.toString(2));
        }

        // Verify the result contains only the metadata part
        assertTrue(jsonResult.has("root"));
        assertTrue(jsonResult.getJSONObject("root").has("metadata"));

        // Verify metadata content
        JSONObject metadata = jsonResult.getJSONObject("root").getJSONObject("metadata");
        assertEquals("1.0", metadata.getString("version"));
        assertEquals("Test User", metadata.getString("author"));

        // Verify data section is not included
        assertFalse(jsonResult.getJSONObject("root").has("data"));
    }

    @Test
    void parse_withMultiplePaths_combinedCorrectly() throws Exception {
        // Setup test data
        String xml =
                "<root>" +
                        "<section1>" +
                        "<item>Section 1 Item</item>" +
                        "</section1>" +
                        "<section2>" +
                        "<item>Section 2 Item</item>" +
                        "</section2>" +
                        "</root>";

        // Create mapping with multiple paths
        ArrayList<String> paths = new ArrayList<>();
        paths.add("root.section1");
        paths.add("root.section2");

        // Create mock ImportParserMappings
        ImportParserMappings mappings = new ImportParserMappings().path(paths);

        // Test the parse method with multiple paths
        String result = Xml2Json.parse(xml, mappings);
        JSONObject jsonResult = new JSONObject(result);

        if (debug) {
            System.out.println("Multiple paths result:");
            System.out.println(jsonResult.toString(2));
        }

        // Verify both sections are included
        assertTrue(jsonResult.has("root"));
        assertTrue(jsonResult.getJSONObject("root").has("section1"));
        assertTrue(jsonResult.getJSONObject("root").has("section2"));

        // Verify content of both sections
        assertEquals("Section 1 Item", jsonResult.getJSONObject("root").getJSONObject("section1").getString("item"));
        assertEquals("Section 2 Item", jsonResult.getJSONObject("root").getJSONObject("section2").getString("item"));
    }
}