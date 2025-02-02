package com.devteam45ldm.ldm.views.eLabClient.login;

import java.util.EventObject;

public class LoginEvent extends EventObject {
    private final String url;
    private final String apiKey;

    public LoginEvent(Object source, String url, String apiKey) {
        super(source);
        this.url = url;
        this.apiKey = apiKey;
    }

    public String getUrl() {
        return url;
    }

    public String getApiKey() {
        return apiKey;
    }
}