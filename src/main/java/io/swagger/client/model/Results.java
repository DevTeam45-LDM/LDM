package io.swagger.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;

public class Results {
    @JsonProperty("results")
    private Map<String, Object> properties = new HashMap<>();

    public void setProperty(String key, Object value) {
        properties.put(key, value);
    }

    public Object getProperty(String key) {
        return properties.get(key);
    }

    public Map<String, Object> getAllProperties() {
        return properties;
    }
}
