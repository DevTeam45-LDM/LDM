package io.swagger.client.api;

import io.swagger.client.ApiClient;

import io.swagger.client.model.Idp;
import io.swagger.client.model.IdpsBody;
import io.swagger.client.model.IdpsIdBody;

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
@Component("io.swagger.client.api.IdpsApi")
public class IdpsApi {
    private ApiClient apiClient;

    public IdpsApi() {
        this(new ApiClient());
    }

    @Autowired
    public IdpsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete an idp.
     * The idp gets deleted.
     * <p><b>204</b> - The idp was deleted.
     * @param id ID of the idp (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteIdp(Integer id) throws RestClientException {
        deleteIdpWithHttpInfo(id);
    }

    /**
     * Delete an idp.
     * The idp gets deleted.
     * <p><b>204</b> - The idp was deleted.
     * @param id ID of the idp (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteIdpWithHttpInfo(Integer id) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteIdp");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/idps/{id}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = {  };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
         };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "token" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Actions on an idp.
     * 
     * <p><b>200</b> - The updated idp.
     * @param id ID of the idp (required)
     * @param body Parameters for modifying an idp. (optional)
     * @return Idp
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Idp patchIdp(Integer id, IdpsIdBody body) throws RestClientException {
        return patchIdpWithHttpInfo(id, body).getBody();
    }

    /**
     * Actions on an idp.
     * 
     * <p><b>200</b> - The updated idp.
     * @param id ID of the idp (required)
     * @param body Parameters for modifying an idp. (optional)
     * @return ResponseEntity&lt;Idp&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Idp> patchIdpWithHttpInfo(Integer id, IdpsIdBody body) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling patchIdp");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/idps/{id}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
         };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "token" };

        ParameterizedTypeReference<Idp> returnType = new ParameterizedTypeReference<Idp>() {};
        return apiClient.invokeAPI(path, HttpMethod.PATCH, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Create an idp.
     * 
     * <p><b>201</b> - The idp has been created.
     * @param body Parameters for creating an idp. (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void postIdp(IdpsBody body) throws RestClientException {
        postIdpWithHttpInfo(body);
    }

    /**
     * Create an idp.
     * 
     * <p><b>201</b> - The idp has been created.
     * @param body Parameters for creating an idp. (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> postIdpWithHttpInfo(IdpsBody body) throws RestClientException {
        Object postBody = body;
        String path = UriComponentsBuilder.fromPath("/idps").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = {  };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
         };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "token" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Read an idp.
     * 
     * <p><b>200</b> - An idp.
     * @param id ID of the idp (required)
     * @return Idp
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Idp readIdp(Integer id) throws RestClientException {
        return readIdpWithHttpInfo(id).getBody();
    }

    /**
     * Read an idp.
     * 
     * <p><b>200</b> - An idp.
     * @param id ID of the idp (required)
     * @return ResponseEntity&lt;Idp&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Idp> readIdpWithHttpInfo(Integer id) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling readIdp");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/idps/{id}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<Idp> returnType = new ParameterizedTypeReference<Idp>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Read all IDPs.
     * 
     * <p><b>200</b> - A list of idps.
     * @return List&lt;Idp&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Idp> readIdps() throws RestClientException {
        return readIdpsWithHttpInfo().getBody();
    }

    /**
     * Read all IDPs.
     * 
     * <p><b>200</b> - A list of idps.
     * @return ResponseEntity&lt;List&lt;Idp&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Idp>> readIdpsWithHttpInfo() throws RestClientException {
        Object postBody = null;
        String path = UriComponentsBuilder.fromPath("/idps").build().toUriString();
        
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

        ParameterizedTypeReference<List<Idp>> returnType = new ParameterizedTypeReference<List<Idp>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
