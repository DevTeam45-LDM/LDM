package com.devteam45ldm.ldm.api.eLabClient;

import io.swagger.client.ApiClient;
import io.swagger.client.api.TagsApi;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class ELabClientTest {

    @Test
    void getClient_withValidApiKeyAndUrl_returnsApiClient() {
        ELabClient<TagsApi> client = new ELabClient<>(TagsApi.class);
        TagsApi apiClient = client.getClient("validApiKey", "https://valid.url/api/v2");
        assertNotNull(apiClient);
    }

    @Test
    void getClient_withEmptyApiKey_throwsIllegalArgumentException() {
        ELabClient<TagsApi> client = new ELabClient<>(TagsApi.class);
        assertThrows(IllegalArgumentException.class, () -> {
            client.getClient("", "https://valid.url/api/v2");
        });
    }

    @Test
    void getClient_withEmptyUrl_throwsIllegalArgumentException() {
        ELabClient<TagsApi> client = new ELabClient<>(TagsApi.class);
        assertThrows(IllegalArgumentException.class, () -> {
            client.getClient("validApiKey", "");
        });
    }

    @Test
    void checkUrl_withInvalidUrlFormat_throwsIllegalArgumentException() throws Exception {
        Method method = ELabClient.class.getDeclaredMethod("checkUrl", String.class);
        method.setAccessible(true);
        assertThrows(IllegalArgumentException.class, () -> {
            method.invoke(null, "invalid-url");
        });
    }

    @Test
    void checkUrl_withInjectionCharacters_throwsIllegalArgumentException() throws Exception {
        Method method = ELabClient.class.getDeclaredMethod("checkUrl", String.class);
        method.setAccessible(true);
        assertThrows(IllegalArgumentException.class, () -> {
            method.invoke(null, "https://valid.url/api/v2;rm -rf /");
        });
    }

    @Test
    void checkUrl_withoutHttpOrHttps_addsHttpsPrefix() throws Exception {
        Method method = ELabClient.class.getDeclaredMethod("checkUrl", String.class);
        method.setAccessible(true);
        String result = (String) method.invoke(null, "valid.url/api/v2");
        assertEquals("https://valid.url/api/v2", result);
    }

    @Test
    void checkUrl_withoutApiV2Suffix_addsApiV2Suffix() throws Exception {
        Method method = ELabClient.class.getDeclaredMethod("checkUrl", String.class);
        method.setAccessible(true);
        String result = (String) method.invoke(null, "https://valid.url");
        assertEquals("https://valid.url/api/v2", result);
    }

    @Test
    void checkApiKey_withInjectionCharacters_throwsIllegalArgumentException() throws Exception {
        Method method = ELabClient.class.getDeclaredMethod("checkApiKey", String.class);
        method.setAccessible(true);
        assertThrows(IllegalArgumentException.class, () -> {
            method.invoke(null, "validApiKey;rm -rf /");
        });
    }

    @Test
    void createClient_withValidApiKeyAndUrl_returnsApiClient() throws Exception {
        Method method = ELabClient.class.getDeclaredMethod("createClient", String.class, String.class);
        method.setAccessible(true);
        ApiClient client = (ApiClient) method.invoke(null, "validApiKey", "https://valid.url/api/v2");
        assertNotNull(client);
        assertEquals("https://valid.url/api/v2", client.getBasePath());
    }

    @Test
    void checkUrl_withMalformedUrl_throwsMalformedURLException() throws Exception {
        Method method = ELabClient.class.getDeclaredMethod("checkUrl", String.class);
        method.setAccessible(true);
        assertThrows(MalformedURLException.class, () -> {
            method.invoke(null, "http://invalid-url^");
        });
    }

    @Test
    void checkUrl_withInvalidUriSyntax_throwsURISyntaxException() throws Exception {
        Method method = ELabClient.class.getDeclaredMethod("checkUrl", String.class);
        method.setAccessible(true);
        assertThrows(URISyntaxException.class, () -> {
            method.invoke(null, "http://invalid-url|");
        });
    }

    @Test
    void createClient_withMalformedUrl_throwsMalformedURLException() throws Exception {
        Method method = ELabClient.class.getDeclaredMethod("createClient", String.class, String.class);
        method.setAccessible(true);
        assertThrows(MalformedURLException.class, () -> {
            method.invoke(null, "validApiKey", "http://invalid-url^");
        });
    }

    @Test
    void createClient_withInvalidUriSyntax_throwsURISyntaxException() throws Exception {
        Method method = ELabClient.class.getDeclaredMethod("createClient", String.class, String.class);
        method.setAccessible(true);
        assertThrows(URISyntaxException.class, () -> {
            method.invoke(null, "validApiKey", "http://invalid-url|");
        });
    }

}