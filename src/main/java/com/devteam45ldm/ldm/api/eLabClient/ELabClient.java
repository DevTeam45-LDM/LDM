package com.devteam45ldm.ldm.api.eLabClient;

import io.swagger.client.ApiClient;
import io.swagger.client.auth.ApiKeyAuth;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * ELabClient is a generic class that provides a client for various API types.
 *
 * @param <T> the type of the API client
 */
public class ELabClient <T> {
    private final Class<T> type;
    private T apiClient;

    /**
     * Constructor for ELabClient.
     *
     * @param type the class type of the API client
     */
    public ELabClient(Class<T> type) {
        this.type = type;
    }

    /**
     * Returns an instance of the API client.
     *
     * @param apiKey the API key for authentication
     * @param url the base URL of the API
     * @return an instance of the API client
     * @throws IllegalArgumentException if the API key or URL is invalid
     */
    public T getClient(String apiKey, String url) throws IllegalArgumentException {

        if(apiKey == null || apiKey.isEmpty() || url == null || url.isEmpty()){
            throw new IllegalArgumentException("API key and URL must not be empty.");
        }

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

    /**
     * Validates and formats the URL.
     *
     * @param url the URL to be checked
     * @return the validated and formatted URL
     * @throws IllegalArgumentException if the URL is invalid
     * @throws URISyntaxException if the URL syntax is incorrect
     * @throws MalformedURLException if the URL is malformed
     */
    private static String checkUrl(String url) throws IllegalArgumentException, URISyntaxException, MalformedURLException {

        if (url.contains(";") || url.contains("|") || url.contains("&") || url.contains("$") || url.contains("`") || url.contains("'")) {
            throw new IllegalArgumentException("URL contains potentially dangerous characters: " + url);
        }

        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }
        if (!url.endsWith("/api/v2")) {
            url = url.endsWith("/") ? url + "api/v2" : url + "/api/v2";
        }

        URL urlTest = new URI(url).toURL();

        return url;
    }

    /**
     * Validates the API key.
     *
     * @param apiKey the API key to be checked
     * @throws IllegalArgumentException if the API key contains potentially dangerous characters
     */
    private static void checkApiKey(String apiKey) throws IllegalArgumentException {
        if (apiKey.contains(";") || apiKey.contains("|") || apiKey.contains("&") || apiKey.contains("$") || apiKey.contains("`") || apiKey.contains("'")) {
            throw new IllegalArgumentException("API Key contains potentially dangerous characters: " + apiKey);
        }
    }

    /**
     * Creates an ApiClient instance with the provided API key and URL.
     *
     * @param apiKey the API key for authentication
     * @param url the base URL of the API
     * @return an instance of ApiClient
     * @throws MalformedURLException if the URL is malformed
     * @throws URISyntaxException if the URL syntax is incorrect
     */
    private static ApiClient createClient(String apiKey, String url) throws MalformedURLException, URISyntaxException {
        url = checkUrl(url);
        checkApiKey(apiKey);

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
