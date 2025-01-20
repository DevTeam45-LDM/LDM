package io.swagger.client.api;

import io.swagger.client.ApiClient;

import io.swagger.client.model.InlineResponse2009;
import io.swagger.client.model.Revision;
import io.swagger.client.model.RevisionsSubidBody;

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
@Component("io.swagger.client.api.RevisionsApi")
public class RevisionsApi {
    private ApiClient apiClient;

    public RevisionsApi() {
        this(new ApiClient());
    }

    @Autowired
    public RevisionsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Restore a revision.
     * 
     * <p><b>200</b> - The (unchanged) revision
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param subid ID of the revision (required)
     * @param body Parameters for restoring an entity revision. (optional)
     * @return Revision
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Revision patchEntityRevision(String entityType, Integer id, Integer subid, RevisionsSubidBody body) throws RestClientException {
        return patchEntityRevisionWithHttpInfo(entityType, id, subid, body).getBody();
    }

    /**
     * Restore a revision.
     * 
     * <p><b>200</b> - The (unchanged) revision
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param subid ID of the revision (required)
     * @param body Parameters for restoring an entity revision. (optional)
     * @return ResponseEntity&lt;Revision&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Revision> patchEntityRevisionWithHttpInfo(String entityType, Integer id, Integer subid, RevisionsSubidBody body) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'entityType' is set
        if (entityType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'entityType' when calling patchEntityRevision");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling patchEntityRevision");
        }
        // verify the required parameter 'subid' is set
        if (subid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subid' when calling patchEntityRevision");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("entity_type", entityType);
        uriVariables.put("id", id);
        uriVariables.put("subid", subid);
        String path = UriComponentsBuilder.fromPath("/{entity_type}/{id}/revisions/{subid}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<Revision> returnType = new ParameterizedTypeReference<Revision>() {};
        return apiClient.invokeAPI(path, HttpMethod.PATCH, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Read a revision of that entity.
     * 
     * <p><b>200</b> - A revision.
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param subid ID of the revision (required)
     * @return Revision
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Revision readEntityRevision(String entityType, Integer id, Integer subid) throws RestClientException {
        return readEntityRevisionWithHttpInfo(entityType, id, subid).getBody();
    }

    /**
     * Read a revision of that entity.
     * 
     * <p><b>200</b> - A revision.
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param subid ID of the revision (required)
     * @return ResponseEntity&lt;Revision&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Revision> readEntityRevisionWithHttpInfo(String entityType, Integer id, Integer subid) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'entityType' is set
        if (entityType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'entityType' when calling readEntityRevision");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling readEntityRevision");
        }
        // verify the required parameter 'subid' is set
        if (subid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subid' when calling readEntityRevision");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("entity_type", entityType);
        uriVariables.put("id", id);
        uriVariables.put("subid", subid);
        String path = UriComponentsBuilder.fromPath("/{entity_type}/{id}/revisions/{subid}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<Revision> returnType = new ParameterizedTypeReference<Revision>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Read all revisions of that entity.
     * 
     * <p><b>200</b> - A list of revisions for that entity
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @return List&lt;InlineResponse2009&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<InlineResponse2009> readEntityRevisions(String entityType, Integer id) throws RestClientException {
        return readEntityRevisionsWithHttpInfo(entityType, id).getBody();
    }

    /**
     * Read all revisions of that entity.
     * 
     * <p><b>200</b> - A list of revisions for that entity
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @return ResponseEntity&lt;List&lt;InlineResponse2009&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<InlineResponse2009>> readEntityRevisionsWithHttpInfo(String entityType, Integer id) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'entityType' is set
        if (entityType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'entityType' when calling readEntityRevisions");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling readEntityRevisions");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("entity_type", entityType);
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/{entity_type}/{id}/revisions").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<List<InlineResponse2009>> returnType = new ParameterizedTypeReference<List<InlineResponse2009>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
