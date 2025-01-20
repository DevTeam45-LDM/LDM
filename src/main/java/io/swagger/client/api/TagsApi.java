package io.swagger.client.api;

import io.swagger.client.ApiClient;

import io.swagger.client.model.IdTagsBody2;
import io.swagger.client.model.Tag;
import io.swagger.client.model.TagsSubidBody1;

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
@Component("io.swagger.client.api.TagsApi")
public class TagsApi {
    private ApiClient apiClient;

    public TagsApi() {
        this(new ApiClient());
    }

    @Autowired
    public TagsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete all tags.
     * All the tags from that entity get removed.
     * <p><b>204</b> - The tags were deleted.
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteTag(String entityType, Integer id) throws RestClientException {
        deleteTagWithHttpInfo(entityType, id);
    }

    /**
     * Delete all tags.
     * All the tags from that entity get removed.
     * <p><b>204</b> - The tags were deleted.
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteTagWithHttpInfo(String entityType, Integer id) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'entityType' is set
        if (entityType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'entityType' when calling deleteTag");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteTag");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("entity_type", entityType);
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/{entity_type}/{id}/tags").buildAndExpand(uriVariables).toUriString();
        
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
     * Actions on a tag (like removing it from the entity). 
     * 
     * <p><b>200</b> - The updated tag.
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param subid ID of the tag (required)
     * @param body Parameters for modifying a tag (optional)
     * @return Tag
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Tag patchTag(String entityType, Integer id, Integer subid, TagsSubidBody1 body) throws RestClientException {
        return patchTagWithHttpInfo(entityType, id, subid, body).getBody();
    }

    /**
     * Actions on a tag (like removing it from the entity). 
     * 
     * <p><b>200</b> - The updated tag.
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param subid ID of the tag (required)
     * @param body Parameters for modifying a tag (optional)
     * @return ResponseEntity&lt;Tag&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Tag> patchTagWithHttpInfo(String entityType, Integer id, Integer subid, TagsSubidBody1 body) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'entityType' is set
        if (entityType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'entityType' when calling patchTag");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling patchTag");
        }
        // verify the required parameter 'subid' is set
        if (subid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subid' when calling patchTag");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("entity_type", entityType);
        uriVariables.put("id", id);
        uriVariables.put("subid", subid);
        String path = UriComponentsBuilder.fromPath("/{entity_type}/{id}/tags/{subid}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<Tag> returnType = new ParameterizedTypeReference<Tag>() {};
        return apiClient.invokeAPI(path, HttpMethod.PATCH, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Create a tag.
     * 
     * <p><b>201</b> - The tag has been created.
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param body Parameters for creating a tag. (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void postTag(String entityType, Integer id, IdTagsBody2 body) throws RestClientException {
        postTagWithHttpInfo(entityType, id, body);
    }

    /**
     * Create a tag.
     * 
     * <p><b>201</b> - The tag has been created.
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param body Parameters for creating a tag. (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> postTagWithHttpInfo(String entityType, Integer id, IdTagsBody2 body) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'entityType' is set
        if (entityType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'entityType' when calling postTag");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling postTag");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("entity_type", entityType);
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/{entity_type}/{id}/tags").buildAndExpand(uriVariables).toUriString();
        
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
     * Read a tag.
     * 
     * <p><b>200</b> - A tag.
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param subid ID of the tag (required)
     * @return Tag
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Tag readTag(String entityType, Integer id, Integer subid) throws RestClientException {
        return readTagWithHttpInfo(entityType, id, subid).getBody();
    }

    /**
     * Read a tag.
     * 
     * <p><b>200</b> - A tag.
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param subid ID of the tag (required)
     * @return ResponseEntity&lt;Tag&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Tag> readTagWithHttpInfo(String entityType, Integer id, Integer subid) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'entityType' is set
        if (entityType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'entityType' when calling readTag");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling readTag");
        }
        // verify the required parameter 'subid' is set
        if (subid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subid' when calling readTag");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("entity_type", entityType);
        uriVariables.put("id", id);
        uriVariables.put("subid", subid);
        String path = UriComponentsBuilder.fromPath("/{entity_type}/{id}/tags/{subid}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<Tag> returnType = new ParameterizedTypeReference<Tag>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Read all tags of that entity.
     * 
     * <p><b>200</b> - A list of tags
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @return List&lt;Tag&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Tag> readTags(String entityType, Integer id) throws RestClientException {
        return readTagsWithHttpInfo(entityType, id).getBody();
    }

    /**
     * Read all tags of that entity.
     * 
     * <p><b>200</b> - A list of tags
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @return ResponseEntity&lt;List&lt;Tag&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Tag>> readTagsWithHttpInfo(String entityType, Integer id) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'entityType' is set
        if (entityType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'entityType' when calling readTags");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling readTags");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("entity_type", entityType);
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/{entity_type}/{id}/tags").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<List<Tag>> returnType = new ParameterizedTypeReference<List<Tag>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
