package com.devteam45ldm.ldm.parser.types;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import static org.junit.jupiter.api.Assertions.*;

class Xml2JsonTest {

    private final Boolean debug = true;

    @Test
    void parseXMLToJson_simpleElement_returnsCorrectJson() throws Exception {
        String xml = "<root><child>testString</child></root>";
        JSONObject json = Xml2Json.parse(xml);

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
    void parseXMLToJson_withAttribute_returnsCorrectJson() throws Exception {
        String xml = "<root><child testAttr=\"valueMJ\">testString</child></root>";
        JSONObject json = Xml2Json.parse(xml);

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
    void parseXMLToJson_multipleAttributes_returnsCorrectJson() throws Exception {
        String xml = "<root><child id=\"1\" type=\"test\">content</child></root>";
        JSONObject json = Xml2Json.parse(xml);

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
    void parseXMLToJson_repeatedElements_returnsJsonArray() throws Exception {
        String xml = "<root><child>value1</child><child>value2</child></root>";
        JSONObject json = Xml2Json.parse(xml);

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
    void parseXMLToJson_repeatedElementsWithAttributes_returnsJsonArray() throws Exception {
        String xml = "<root><child attr=\"hi\">value1</child><child>value2</child></root>";
        JSONObject json = Xml2Json.parse(xml);

        if(debug) {
            System.out.println(json.toString(2));
        }

        //TODO adapt the following commands to String expected = ...
        //JSONObject root = json.getJSONObject("root");
        //JSONArray children = root.getJSONArray("child");
        //assertEquals(2, children.length());
        //assertEquals("value1", children.getJSONObject(0).getString("value"));
        //assertEquals("value2", children.getJSONObject(1).getString("value"));

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
    void parseXMLToJson_nestedElements_returnsNestedJson() throws Exception {
        String xml = "<root><parent><child>value</child></parent></root>";
        JSONObject json = Xml2Json.parse(xml);

        if(debug) {
            System.out.println(json.toString(2));
        }

        JSONObject root = json.getJSONObject("root");
        JSONObject parent = root.getJSONObject("parent");
        assertEquals("value", parent.getString("child"));
    }

    @Test
    void parseXMLToJson_emptyElement_returnsEmptyObject() throws Exception {
        String xml = "<root><child></child></root>";
        JSONObject json = Xml2Json.parse(xml);

        if(debug) {
            System.out.println(json.toString(2));
        }

        JSONObject root = json.getJSONObject("root");
        assertTrue(root.has("child"));
        JSONObject child = root.getJSONObject("child");
        assertEquals(0, child.length());
    }

    @Test
    void parseXMLToJson_emptyWithAttribute_returnsOnlyAttribute() throws Exception {
        String xml = "<root><child id=\"1\"></child></root>";
        JSONObject json = Xml2Json.parse(xml);

        if(debug) {
            System.out.println(json.toString(2));
        }

        JSONObject root = json.getJSONObject("root");
        JSONObject child = root.getJSONObject("child");
        assertEquals("1", child.getString("id"));
        assertEquals(1, child.length());
    }

    @Test
    void parseXMLToJson_invalidXml_throwsSAXException() {
        String xml = "<root><child></root>";
        assertThrows(SAXException.class, () -> Xml2Json.parse(xml));
    }

    @Test
    void parseXMLToJson_mixedContent_handlesCorrectly() throws Exception {
        String xml = "<root><child>Start<nested>value</nested>End</child></root>";
        JSONObject json = Xml2Json.parse(xml);

        if(debug) {
            System.out.println(json.toString(2));
        }

        JSONObject root = json.getJSONObject("root");
        JSONObject child = root.getJSONObject("child");
        JSONObject nested = child.getJSONObject("nested");
        assertEquals("value", nested.getString("value"));
        assertEquals("StartEnd", child.getString("value"));
    }

    @Test
    void parseXMLToJson_complexStructure_handlesCorrectly() throws Exception {
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

        JSONObject json = Xml2Json.parse(xml);

        if(debug) {
            System.out.println(json.toString(2));
        }

        JSONObject data = json.getJSONObject("data");
        JSONObject person = data.getJSONObject("person");
        assertEquals("1", person.getString("id"));
        assertEquals("John", person.getString("name"));

        JSONArray contacts = person.getJSONArray("contacts");
        assertEquals(2, contacts.length());

        JSONObject workEmail = contacts.getJSONObject(0);
        assertEquals("work", workEmail.getString("type"));
        assertEquals("john@work.com", workEmail.toString());

        JSONObject homeEmail = contacts.getJSONObject(1);
        assertEquals("home", homeEmail.getString("type"));
        assertEquals("john@home.com", homeEmail.toString());
    }
}