package io.swagger.client.api;

import io.swagger.client.ApiClient;

import io.swagger.client.model.UnfinishedSteps;

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
@Component("io.swagger.client.api.UnfinishedStepsApi")
public class UnfinishedStepsApi {
    private ApiClient apiClient;

    public UnfinishedStepsApi() {
        this(new ApiClient());
    }

    @Autowired
    public UnfinishedStepsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Read all unfinished steps.
     * 
     * <p><b>200</b> - A list of unfinished steps
     * @param scope Set to \&quot;team\&quot; to extend the list to other members.  (optional, default to user)
     * @return List&lt;UnfinishedSteps&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<UnfinishedSteps> readUnfinishedSteps(String scope) throws RestClientException {
        return readUnfinishedStepsWithHttpInfo(scope).getBody();
    }

    /**
     * Read all unfinished steps.
     * 
     * <p><b>200</b> - A list of unfinished steps
     * @param scope Set to \&quot;team\&quot; to extend the list to other members.  (optional, default to user)
     * @return ResponseEntity&lt;List&lt;UnfinishedSteps&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<UnfinishedSteps>> readUnfinishedStepsWithHttpInfo(String scope) throws RestClientException {
        Object postBody = null;
        String path = UriComponentsBuilder.fromPath("/unfinished_steps").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "scope", scope));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "token" };

        ParameterizedTypeReference<List<UnfinishedSteps>> returnType = new ParameterizedTypeReference<List<UnfinishedSteps>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
