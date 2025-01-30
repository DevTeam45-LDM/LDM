package com.devteam45ldm.ldm.views.eLabClient.createReport;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class JsonToELabReportBody {
    public static String convertJsonToHtml(JSONObject json) throws JSONException {
        StringBuilder html = new StringBuilder();
        html.append("<html><body>");

        // Add metadata
        html.append("<h1>Measurement Metadata</h1>");
        JSONObject measurement = json.getJSONObject("measurement");
        Iterator<String> keys = measurement.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            if (!key.equals("datablock")) {
                html.append("<p><strong>").append(key).append(":</strong> ").append(measurement.get(key)).append("</p>");
            }
        }

        // Add measurement results
        html.append("<h2>Measurement Results</h2>");
        JSONArray data = measurement.getJSONObject("datablock").getJSONArray("data");
        int dataSize = data.length();
        for (int i = 0; i < dataSize; i++) {
            if (i < 2 || i >= dataSize - 2) {
                JSONObject dataPoint = data.getJSONObject(i);
                html.append("<h3>Data Point ").append(i + 1).append("</h3>");
                Iterator<String> dataKeys = dataPoint.keys();
                while (dataKeys.hasNext()) {
                    String key = dataKeys.next();
                    html.append("<p><strong>").append(key).append(":</strong> ").append(dataPoint.get(key)).append("</p>");
                }
            }
        }

        html.append("</body></html>");
        return html.toString();
    }
}