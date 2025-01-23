package io.swagger.client.api;

import io.swagger.client.ApiClient;

import io.swagger.client.model.ExperimentsLinksSubidBody;
import io.swagger.client.model.Link;

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
@Component("io.swagger.client.api.LinksToExperimentsApi")
public class LinksToExperimentsApi {
    private ApiClient apiClient;

    public LinksToExperimentsApi() {
        this(new ApiClient());
    }

    @Autowired
    public LinksToExperimentsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete an experiment link.
     * The link gets deleted.
     * <p><b>204</b> - The link was deleted.
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param subid ID of the experiment linked (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteEntityExperimentsLink(String entityType, Integer id, Integer subid) throws RestClientException {
        deleteEntityExperimentsLinkWithHttpInfo(entityType, id, subid);
    }

    /**
     * Delete an experiment link.
     * The link gets deleted.
     * <p><b>204</b> - The link was deleted.
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param subid ID of the experiment linked (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteEntityExperimentsLinkWithHttpInfo(String entityType, Integer id, Integer subid) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'entityType' is set
        if (entityType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'entityType' when calling deleteEntityExperimentsLink");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteEntityExperimentsLink");
        }
        // verify the required parameter 'subid' is set
        if (subid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subid' when calling deleteEntityExperimentsLink");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("entity_type", entityType);
        uriVariables.put("id", id);
        uriVariables.put("subid", subid);
        String path = UriComponentsBuilder.fromPath("/{entity_type}/{id}/experiments_links/{subid}").buildAndExpand(uriVariables).toUriString();
        
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
     * Create or import a link.
     * 
     * <p><b>201</b> - The link has been created.
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param subid ID of the experiment linked (required)
     * @param body Parameters for creating or importing a link. (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void postEntityExperimentsLinks(String entityType, Integer id, Integer subid, ExperimentsLinksSubidBody body) throws RestClientException {
        postEntityExperimentsLinksWithHttpInfo(entityType, id, subid, body);
    }

    /**
     * Create or import a link.
     * 
     * <p><b>201</b> - The link has been created.
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param subid ID of the experiment linked (required)
     * @param body Parameters for creating or importing a link. (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> postEntityExperimentsLinksWithHttpInfo(String entityType, Integer id, Integer subid, ExperimentsLinksSubidBody body) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'entityType' is set
        if (entityType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'entityType' when calling postEntityExperimentsLinks");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling postEntityExperimentsLinks");
        }
        // verify the required parameter 'subid' is set
        if (subid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subid' when calling postEntityExperimentsLinks");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("entity_type", entityType);
        uriVariables.put("id", id);
        uriVariables.put("subid", subid);
        String path = UriComponentsBuilder.fromPath("/{entity_type}/{id}/experiments_links/{subid}").buildAndExpand(uriVariables).toUriString();
        
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
     * Read all experiments links of that entity.
     * 
     * <p><b>200</b> - A list of links
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @return List&lt;Link&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Link> readEntityExperimentsLinks(String entityType, Integer id) throws RestClientException {
        return readEntityExperimentsLinksWithHttpInfo(entityType, id).getBody();
    }

    /**
     * Read all experiments links of that entity.
     * 
     * <p><b>200</b> - A list of links
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @return ResponseEntity&lt;List&lt;Link&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Link>> readEntityExperimentsLinksWithHttpInfo(String entityType, Integer id) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'entityType' is set
        if (entityType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'entityType' when calling readEntityExperimentsLinks");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling readEntityExperimentsLinks");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("entity_type", entityType);
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/{entity_type}/{id}/experiments_links").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<List<Link>> returnType = new ParameterizedTypeReference<List<Link>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
