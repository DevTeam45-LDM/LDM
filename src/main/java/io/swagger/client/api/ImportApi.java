package io.swagger.client.api;

import io.swagger.client.ApiClient;

import java.io.File;
import io.swagger.client.model.InlineResponse2001;

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
@Component("io.swagger.client.api.ImportApi")
public class ImportApi {
    private ApiClient apiClient;

    public ImportApi() {
        this(new ApiClient());
    }

    @Autowired
    public ImportApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Send a file to import
     * 
     * <p><b>201</b> - The import was successful
     * @param file  (optional)
     * @param entityType  (optional)
     * @param category  (optional)
     * @param canread  (optional)
     * @param canwrite  (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void postImport(File file, String entityType, Integer category, String canread, String canwrite) throws RestClientException {
        postImportWithHttpInfo(file, entityType, category, canread, canwrite);
    }

    /**
     * Send a file to import
     * 
     * <p><b>201</b> - The import was successful
     * @param file  (optional)
     * @param entityType  (optional)
     * @param category  (optional)
     * @param canread  (optional)
     * @param canwrite  (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> postImportWithHttpInfo(File file, String entityType, Integer category, String canread, String canwrite) throws RestClientException {
        Object postBody = null;
        String path = UriComponentsBuilder.fromPath("/import").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (file != null)
            formParams.add("file", new FileSystemResource(file));
        if (entityType != null)
            formParams.add("entity_type", entityType);
        if (category != null)
            formParams.add("category", category);
        if (canread != null)
            formParams.add("canread", canread);
        if (canwrite != null)
            formParams.add("canwrite", canwrite);

        final String[] accepts = {  };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "multipart/form-data"
         };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "token" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Get information about this endpoint
     * 
     * <p><b>200</b> - Information
     * @return InlineResponse2001
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public InlineResponse2001 readImport() throws RestClientException {
        return readImportWithHttpInfo().getBody();
    }

    /**
     * Get information about this endpoint
     * 
     * <p><b>200</b> - Information
     * @return ResponseEntity&lt;InlineResponse2001&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<InlineResponse2001> readImportWithHttpInfo() throws RestClientException {
        Object postBody = null;
        String path = UriComponentsBuilder.fromPath("/import").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "token" };

        ParameterizedTypeReference<InlineResponse2001> returnType = new ParameterizedTypeReference<InlineResponse2001>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
