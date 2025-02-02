package com.devteam45ldm.ldm.api.eLabClient;

import io.swagger.client.ApiClient;
import io.swagger.client.api.TagsApi;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class ELabClientTest {

    /**
     * Tests if the getClient method returns a non-null TagsApi client
     * when provided with a valid API key and URL.
     */
    @Test
    void getClient_withValidApiKeyAndUrl_returnsApiClient() {
        ELabClient<TagsApi> client = new ELabClient<>(TagsApi.class);
        TagsApi apiClient = client.getClient("validApiKey", "https://valid.url/api/v2");
        assertNotNull(apiClient);
    }

    /**
     * Tests if the getClient method throws an IllegalArgumentException
     * when provided with an empty API key.
     */
    @Test
    void getClient_withEmptyApiKey_throwsIllegalArgumentException() {
        ELabClient<TagsApi> client = new ELabClient<>(TagsApi.class);
        assertThrows(IllegalArgumentException.class, () -> {
            client.getClient("", "https://valid.url/api/v2");
        });
    }

    /**
     * Tests if the getClient method throws an IllegalArgumentException
     * when provided with an empty URL.
     */
    @Test
    void getClient_withEmptyUrl_throwsIllegalArgumentException() {
        ELabClient<TagsApi> client = new ELabClient<>(TagsApi.class);
        assertThrows(IllegalArgumentException.class, () -> {
            client.getClient("validApiKey", "");
        });
    }

    /**
     * Tests if the checkUrl method throws an IllegalArgumentException
     * when the URL contains injection characters.
     */
    @Test
    void checkUrl_withInjectionCharacters_throwsIllegalArgumentException() throws Exception {
        Method method = ELabClient.class.getDeclaredMethod("checkUrl", String.class);
        method.setAccessible(true);
        InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> {
            method.invoke(null, "https://valid.url/api/v2;rm -rf /");
        });
        assertTrue(exception.getCause() instanceof IllegalArgumentException);
    }

    /**
     * Tests if the checkUrl method adds an https prefix
     * when the URL does not start with http or https.
     */
    @Test
    void checkUrl_withoutHttpOrHttps_addsHttpsPrefix() throws Exception {
        Method method = ELabClient.class.getDeclaredMethod("checkUrl", String.class);
        method.setAccessible(true);
        String result = (String) method.invoke(null, "valid.url/api/v2");
        assertEquals("https://valid.url/api/v2", result);
    }

    /**
     * Tests if the checkUrl method adds an /api/v2 suffix
     * when the URL does not end with /api/v2.
     */
    @Test
    void checkUrl_withoutApiV2Suffix_addsApiV2Suffix() throws Exception {
        Method method = ELabClient.class.getDeclaredMethod("checkUrl", String.class);
        method.setAccessible(true);
        String result = (String) method.invoke(null, "https://valid.url");
        assertEquals("https://valid.url/api/v2", result);
    }

    /**
     * Tests if the checkApiKey method throws an IllegalArgumentException
     * when the API key contains injection characters.
     */
    @Test
    void checkApiKey_withInjectionCharacters_throwsIllegalArgumentException() throws Exception {
        Method method = ELabClient.class.getDeclaredMethod("checkApiKey", String.class);
        method.setAccessible(true);
        InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> {
            method.invoke(null, "validApiKey;rm -rf /");
        });
        assertTrue(exception.getCause() instanceof IllegalArgumentException);
    }

    /**
     * Tests if the createClient method returns a non-null ApiClient
     * when provided with a valid API key and URL.
     */
    @Test
    void createClient_withValidApiKeyAndUrl_returnsApiClient() throws Exception {
        Method method = ELabClient.class.getDeclaredMethod("createClient", String.class, String.class);
        method.setAccessible(true);
        ApiClient client = (ApiClient) method.invoke(null, "validApiKey", "https://valid.url/api/v2");
        assertNotNull(client);
        assertEquals("https://valid.url/api/v2", client.getBasePath());
    }

    /**
     * Tests if the checkUrl method throws a URISyntaxException
     * when the URL is malformed.
     */
    @Test
    void checkUrl_withMalformedUrl_throwsMalformedURLException() throws Exception {
        Method method = ELabClient.class.getDeclaredMethod("checkUrl", String.class);
        method.setAccessible(true);
        InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> {
            method.invoke(null, "http://invalid-url^");
        });
        assertTrue(exception.getCause() instanceof URISyntaxException);
    }

    /**
     * Tests if the checkUrl method throws an IllegalArgumentException
     * when the URL contains invalid URI syntax.
     */
    @Test
    void checkUrl_withInvalidUriSyntax_throwsURISyntaxException() throws Exception {
        Method method = ELabClient.class.getDeclaredMethod("checkUrl", String.class);
        method.setAccessible(true);
        InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> {
            method.invoke(null, "http://invalid-url|");
        });
        assertTrue(exception.getCause() instanceof IllegalArgumentException);
    }

    /**
     * Tests if the createClient method throws a URISyntaxException
     * when the URL is malformed.
     */
    @Test
    void createClient_withMalformedUrl_throwsMalformedURLException() throws Exception {
        Method method = ELabClient.class.getDeclaredMethod("createClient", String.class, String.class);
        method.setAccessible(true);
        InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> {
            method.invoke(null, "validApiKey", "http://invalid-url^");
        });
        assertTrue(exception.getCause() instanceof URISyntaxException);
    }

    /**
     * Tests if the createClient method throws an IllegalArgumentException
     * when the URL contains invalid URI syntax.
     */
    @Test
    void createClient_withInvalidUriSyntax_throwsURISyntaxException() throws Exception {
        Method method = ELabClient.class.getDeclaredMethod("createClient", String.class, String.class);
        method.setAccessible(true);
        InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> {
            method.invoke(null, "validApiKey", "http://invalid-url|");
        });
        assertTrue(exception.getCause() instanceof IllegalArgumentException);
    }
}