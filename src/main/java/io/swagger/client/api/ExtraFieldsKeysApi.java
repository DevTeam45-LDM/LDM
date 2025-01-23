package io.swagger.client.api;

import io.swagger.client.ApiClient;

import io.swagger.client.model.ExtraFieldsKeys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2025-01-17T16:14:35.053224103Z[GMT]")
@Component("io.swagger.client.api.ExtraFieldsKeysApi")
public class ExtraFieldsKeysApi {
    private ApiClient apiClient;

    public ExtraFieldsKeysApi() {
        this(new ApiClient());
    }

    @Autowired
    public ExtraFieldsKeysApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Read extra fields keys.
     * 
     * <p><b>200</b> - A list of extra fields keys and their frequency.
     * @param q Search for a term in the extra fields keys.  (optional)
     * @param limit Number of extra fields keys that will be returned. Value &gt;&#x3D; -1; -1: no limit, 0: users default setting from UCP.  (optional, default to 0)
     * @return List&lt;ExtraFieldsKeys&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<ExtraFieldsKeys> extraFieldsKeys(String q, Integer limit) throws RestClientException {
        return extraFieldsKeysWithHttpInfo(q, limit).getBody();
    }

    /**
     * Read extra fields keys.
     * 
     * <p><b>200</b> - A list of extra fields keys and their frequency.
     * @param q Search for a term in the extra fields keys.  (optional)
     * @param limit Number of extra fields keys that will be returned. Value &gt;&#x3D; -1; -1: no limit, 0: users default setting from UCP.  (optional, default to 0)
     * @return ResponseEntity&lt;List&lt;ExtraFieldsKeys&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<ExtraFieldsKeys>> extraFieldsKeysWithHttpInfo(String q, Integer limit) throws RestClientException {
        Object postBody = null;
        String path = UriComponentsBuilder.fromPath("/extra_fields_keys").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "q", q));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "token" };

        ParameterizedTypeReference<List<ExtraFieldsKeys>> returnType = new ParameterizedTypeReference<List<ExtraFieldsKeys>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
