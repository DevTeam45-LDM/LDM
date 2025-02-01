package com.devteam45ldm.ldm.parser;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JsonToELabReportBodyTest {

    @Test
    void convertJsonToHtml_withValidJson_returnsHtml() throws JSONException {
        JSONObject json = new JSONObject();
        JSONObject measurement = new JSONObject();
        measurement.put("id", "12345");
        measurement.put("name", "Test Measurement");
        JSONArray data = new JSONArray();
        JSONObject dataPoint1 = new JSONObject();
        dataPoint1.put("value", "10");
        data.put(dataPoint1);
        JSONObject dataPoint2 = new JSONObject();
        dataPoint2.put("value", "20");
        data.put(dataPoint2);
        measurement.put("datablock", new JSONObject().put("data", data));
        json.put("measurement", measurement);

        String html = JsonToELabReportBody.convertJsonToHtml(json);

        assertTrue(html.contains("<h1>Measurement Metadata</h1>"));
        assertTrue(html.contains("<p><strong>id:</strong> 12345</p>"));
        assertTrue(html.contains("<p><strong>name:</strong> Test Measurement</p>"));
        assertTrue(html.contains("<h2>Measurement Results</h2>"));
        assertTrue(html.contains("<h3>Data Point 1</h3>"));
        assertTrue(html.contains("<p><strong>value:</strong> 10</p>"));
        assertTrue(html.contains("<h3>Data Point 2</h3>"));
        assertTrue(html.contains("<p><strong>value:</strong> 20</p>"));
    }

    @Test
    void convertJsonToHtml_withEmptyJson_returnsHtmlWithNoData() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("measurement", new JSONObject());

        String html = JsonToELabReportBody.convertJsonToHtml(json);

        assertTrue(html.contains("<h1>Measurement Metadata</h1>"));
        assertTrue(html.contains("<h2>Measurement Results</h2>"));
        assertTrue(html.contains("<p>No data available</p>"));
    }

    @Test
    void convertJsonToHtml_withMissingMeasurement_throwsJSONException() {
        JSONObject json = new JSONObject();

        assertThrows(JSONException.class, () -> {
            JsonToELabReportBody.convertJsonToHtml(json);
        });
    }

    @Test
    void convertJsonToHtml_withInvalidJson_throwsJSONException() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("measurement", "invalid");

        assertThrows(JSONException.class, () -> {
            JsonToELabReportBody.convertJsonToHtml(json);
        });
    }

    @Test
    void convertJsonToHtml_withEmptyDatablock_returnsHtmlWithNoData() throws JSONException {
        JSONObject json = new JSONObject();
        JSONObject measurement = new JSONObject();
        measurement.put("id", "12345");
        measurement.put("name", "Test Measurement");
        measurement.put("datablock", new JSONObject().put("data", new JSONArray()));
        json.put("measurement", measurement);

        String html = JsonToELabReportBody.convertJsonToHtml(json);

        assertTrue(html.contains("<h1>Measurement Metadata</h1>"));
        assertTrue(html.contains("<p><strong>id:</strong> 12345</p>"));
        assertTrue(html.contains("<p><strong>name:</strong> Test Measurement</p>"));
        assertTrue(html.contains("<h2>Measurement Results</h2>"));
    }

    @Test
    void convertJsonToHtml_withNullMeasurement_throwsJSONException() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("measurement", JSONObject.NULL);

        assertThrows(JSONException.class, () -> {
            JsonToELabReportBody.convertJsonToHtml(json);
        });
    }

    @Test
    void convertJsonToHtml_withNullDatablock_throwsJSONException() throws JSONException {
        JSONObject json = new JSONObject();
        JSONObject measurement = new JSONObject();
        measurement.put("id", "12345");
        measurement.put("name", "Test Measurement");
        measurement.put("datablock", JSONObject.NULL);
        json.put("measurement", measurement);

        assertThrows(JSONException.class, () -> {
            JsonToELabReportBody.convertJsonToHtml(json);
        });
    }

    @Test
    void convertJsonToHtml_withEmptyDataArray_returnsHtmlWithNoDataPoints() throws JSONException {
        JSONObject json = new JSONObject();
        JSONObject measurement = new JSONObject();
        measurement.put("id", "12345");
        measurement.put("name", "Test Measurement");
        measurement.put("datablock", new JSONObject().put("data", new JSONArray()));
        json.put("measurement", measurement);

        String html = JsonToELabReportBody.convertJsonToHtml(json);

        assertTrue(html.contains("<h1>Measurement Metadata</h1>"));
        assertTrue(html.contains("<p><strong>id:</strong> 12345</p>"));
        assertTrue(html.contains("<p><strong>name:</strong> Test Measurement</p>"));
        assertTrue(html.contains("<h2>Measurement Results</h2>"));
    }
}