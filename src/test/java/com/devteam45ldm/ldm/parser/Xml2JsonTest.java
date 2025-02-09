package com.devteam45ldm.ldm.parser;

import com.devteam45ldm.ldm.parser.types.Xml2Json;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import static org.junit.jupiter.api.Assertions.*;

class Xml2JsonTest {

    private final Boolean debug = false;

    @Test
    void parseXMLToJson_withValidXml_returnsJson() throws Exception {
        String xml = "<root><child attr=\"value\">text</child></root>";
        JSONObject json = Xml2Json.parseXMLToJson(xml);
        if(debug){
            System.out.println(json.toString(2));
        }
        assertEquals("value", json.getJSONObject("root").getJSONObject("child").getString("attr"));
        assertEquals("text", json.getJSONObject("root").getJSONObject("child").getString("content"));
    }

    @Test
    void parseXMLToJson_withEmptyXml_returnsEmptyJson() throws Exception {
        String xml = "<root></root>";
        JSONObject json = Xml2Json.parseXMLToJson(xml);
        if(debug){
            System.out.println(json.toString(2));
        }
        assertTrue(json.getJSONObject("root").isNull("root"));
    }

    @Test
    void parseXMLToJson_withAttributesOnly_returnsJsonWithAttributes() throws Exception {
        String xml = "<root attr1=\"value1\" attr2=\"value2\"></root>";
        JSONObject json = Xml2Json.parseXMLToJson(xml);
        if(debug){
            System.out.println(json.toString(2));
        }
        assertEquals("value1", json.getJSONObject("root").getString("attr1"));
        assertEquals("value2", json.getJSONObject("root").getString("attr2"));
    }

    @Test
    void parseXMLToJson_withNestedElements_returnsJsonWithNestedStructure() throws Exception {
        String xml = "<root><child><subchild>text</subchild></child></root>";
        JSONObject json = Xml2Json.parseXMLToJson(xml);
        if(debug){
            System.out.println(json.toString(2));
        }
        assertEquals("text", json.getJSONObject("root").getJSONObject("child").getJSONObject("subchild").getString("content"));
    }

    @Test
    void parseXMLToJson_withRepeatedElements_returnsJsonWithArray() throws Exception {
        String xml = "<root><child>text1</child><child>text2</child></root>";
        JSONObject json = Xml2Json.parseXMLToJson(xml);
        if(debug){
            System.out.println(json.toString(2));
        }
        JSONArray children = json.getJSONObject("root").getJSONArray("child");
        assertEquals("text1", children.getJSONObject(0).getString("content"));
        assertEquals("text2", children.getJSONObject(1).getString("content"));
    }

    @Test
    void parseXMLToJson_withInvalidXml_throwsException() {
        String xml = "<root><child></root>";
        assertThrows(SAXException.class, () -> {
            Xml2Json.parseXMLToJson(xml);
        });
    }
}