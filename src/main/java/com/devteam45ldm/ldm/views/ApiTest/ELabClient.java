package com.devteam45ldm.ldm.views.ApiTest;

import io.swagger.client.ApiClient;
import io.swagger.client.auth.ApiKeyAuth;

public class ELabClient <T> {
    private final Class<T> type;

    public ELabClient(Class<T> type) {
        this.type = type;
    }

    private T apiClient;

    public T getClient(String apiKey, String url){

        if(apiClient == null){
            try {
                apiClient = type.getDeclaredConstructor(ApiClient.class).newInstance(createClient(apiKey, url));
            } catch (Exception e) {
                throw new RuntimeException("Failed to create an instance of " + type.getName(), e);
            }
        }
        else if(apiClient instanceof ApiClient && (!((ApiClient)apiClient).getBasePath().equals(url) || !((ApiKeyAuth)((ApiClient)apiClient).getAuthentication("token")).getApiKey().equals(apiKey))){
            try {
                apiClient = type.getDeclaredConstructor(ApiClient.class).newInstance(createClient(apiKey, url));
            } catch (Exception e) {
                throw new RuntimeException("Failed to create an instance of " + type.getName(), e);
            }
        }

        return apiClient;
    }
    private static ApiClient createClient(String apiKey, String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }
        if (!url.endsWith("/api/v2")) {
            url = url.endsWith("/") ? url + "api/v2" : url + "/api/v2";
        }

        // Set up the API client
        ApiClient client = new ApiClient();
        client.setBasePath(url);
        client.setDebugging(true);

        // Configure API key authorization: token
        ApiKeyAuth token = (ApiKeyAuth) client.getAuthentication("token");
        token.setApiKey(apiKey);
        return client;
    }
}
