package com.devteam45ldm.ldm.parser;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JsonToELabReportBodyTest {

    private final Boolean debug = false;

    /**
     * Tests the convertJsonToHtml method with a valid JSON object.
     * Verifies that the returned HTML contains the expected measurement metadata and results.
     *
     * @throws JSONException if the JSON object is malformed
     */
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

        if(debug){
            System.out.println(json.toString(2));
        }

        String html = JsonToELabReportBody.convertJsonToHtml(json);

        if(debug){
            System.out.println(html);
        }

        assertTrue(html.contains("<h1>Measurement Metadata</h1>"));
        assertTrue(html.contains("<p><strong>id:</strong> 12345</p>"));
        assertTrue(html.contains("<p><strong>name:</strong> Test Measurement</p>"));
        assertTrue(html.contains("<h2>Measurement Results</h2>"));
        assertTrue(html.contains("<h3>Data Point 1</h3>"));
        assertTrue(html.contains("<p><strong>value:</strong> 10</p>"));
        assertTrue(html.contains("<h3>Data Point 2</h3>"));
        assertTrue(html.contains("<p><strong>value:</strong> 20</p>"));
    }

    /**
     * Tests the convertJsonToHtml method with an empty JSON object.
     * Verifies that the returned HTML contains the expected structure with no data.
     *
     * @throws JSONException if the JSON object is malformed
     */
    @Test
    void convertJsonToHtml_withEmptyJson_returnsHtmlWithNoData() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("measurement", new JSONObject());

        if(debug){
            System.out.println(json.toString(2));
        }

        String html = JsonToELabReportBody.convertJsonToHtml(json);

        if(debug){
            System.out.println(html);
        }

        assertTrue(html.contains("<h1>Measurement Metadata</h1>"));
        assertTrue(html.contains("<h2>Measurement Results</h2>"));
        assertTrue(html.contains("<p>No data available</p>"));
    }

    /**
     * Tests the convertJsonToHtml method with a JSON object missing the measurement key.
     * Verifies that a JSONException is thrown.
     */
    @Test
    void convertJsonToHtml_withMissingMeasurement_throwsJSONException() throws JSONException {
        JSONObject json = new JSONObject();

        if(debug){
            System.out.println(json.toString(2));
        }

        assertThrows(JSONException.class, () -> JsonToELabReportBody.convertJsonToHtml(json));
    }

    /**
     * Tests the convertJsonToHtml method with an invalid JSON object.
     * Verifies that a JSONException is thrown.
     *
     * @throws JSONException if the JSON object is malformed
     */
    @Test
    void convertJsonToHtml_withInvalidJson_throwsJSONException() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("measurement", "invalid");

        if(debug){
            System.out.println(json.toString(2));
        }

        assertThrows(JSONException.class, () -> JsonToELabReportBody.convertJsonToHtml(json));
    }

    /**
     * Tests the convertJsonToHtml method with a JSON object containing an empty datablock.
     * Verifies that the returned HTML contains the expected measurement metadata with no data.
     *
     * @throws JSONException if the JSON object is malformed
     */
    @Test
    void convertJsonToHtml_withEmptyDatablock_returnsHtmlWithNoData() throws JSONException {
        JSONObject json = new JSONObject();
        JSONObject measurement = new JSONObject();
        measurement.put("id", "12345");
        measurement.put("name", "Test Measurement");
        measurement.put("datablock", new JSONObject().put("data", new JSONArray()));
        json.put("measurement", measurement);

        if(debug){
            System.out.println(json.toString(2));
        }

        String html = JsonToELabReportBody.convertJsonToHtml(json);

        if(debug){
            System.out.println(html);
        }

        assertTrue(html.contains("<h1>Measurement Metadata</h1>"));
        assertTrue(html.contains("<p><strong>id:</strong> 12345</p>"));
        assertTrue(html.contains("<p><strong>name:</strong> Test Measurement</p>"));
        assertTrue(html.contains("<h2>Measurement Results</h2>"));
    }

    /**
     * Tests the convertJsonToHtml method with a JSON object containing a null measurement.
     * Verifies that a JSONException is thrown.
     *
     * @throws JSONException if the JSON object is malformed
     */
    @Test
    void convertJsonToHtml_withNullMeasurement_throwsJSONException() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("measurement", JSONObject.NULL);

        if(debug){
            System.out.println(json.toString(2));
        }

        assertThrows(JSONException.class, () -> JsonToELabReportBody.convertJsonToHtml(json));
    }

    /**
     * Tests the convertJsonToHtml method with a JSON object containing a null datablock.
     * Verifies that the returned HTML contains the expected message indicating no data is available.
     *
     * @throws JSONException if the JSON object is malformed
     */
    @Test
    void convertJsonToHtml_withNullDatablock_returnsHtmlWithNoData() throws JSONException {
        JSONObject json = new JSONObject();
        JSONObject measurement = new JSONObject();
        measurement.put("id", "12345");
        measurement.put("name", "Test Measurement");
        measurement.put("datablock", JSONObject.NULL);
        json.put("measurement", measurement);

        if(debug){
            System.out.println(json.toString(2));
        }

        String html = JsonToELabReportBody.convertJsonToHtml(json);

        if(debug){
            System.out.println(html);
        }

        assertTrue(html.contains("<p>No data available</p>"));
        assertTrue(html.endsWith("</body></html>"));
    }

    /**
     * Tests the convertJsonToHtml method with a JSON object containing an empty data array.
     * Verifies that the returned HTML contains the expected measurement metadata with no data points.
     *
     * @throws JSONException if the JSON object is malformed
     */
    @Test
    void convertJsonToHtml_withEmptyDataArray_returnsHtmlWithNoDataPoints() throws JSONException {
        JSONObject json = new JSONObject();
        JSONObject measurement = new JSONObject();
        measurement.put("id", "12345");
        measurement.put("name", "Test Measurement");
        measurement.put("datablock", new JSONObject().put("data", new JSONArray()));
        json.put("measurement", measurement);

        if(debug){
            System.out.println(json.toString(2));
        }

        String html = JsonToELabReportBody.convertJsonToHtml(json);

        if(debug){
            System.out.println(html);
        }

        assertTrue(html.contains("<h1>Measurement Metadata</h1>"));
        assertTrue(html.contains("<p><strong>id:</strong> 12345</p>"));
        assertTrue(html.contains("<p><strong>name:</strong> Test Measurement</p>"));
        assertTrue(html.contains("<h2>Measurement Results</h2>"));
    }
}