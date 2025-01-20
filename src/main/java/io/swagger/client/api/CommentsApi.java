package io.swagger.client.api;

import io.swagger.client.ApiClient;

import io.swagger.client.model.Comment;
import io.swagger.client.model.IdCommentsBody;

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
@Component("io.swagger.client.api.CommentsApi")
public class CommentsApi {
    private ApiClient apiClient;

    public CommentsApi() {
        this(new ApiClient());
    }

    @Autowired
    public CommentsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete an entity comment.
     * The comment gets deleted.
     * <p><b>204</b> - The comment was deleted
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param subid ID of the comment (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteEntityComment(String entityType, Integer id, Integer subid) throws RestClientException {
        deleteEntityCommentWithHttpInfo(entityType, id, subid);
    }

    /**
     * Delete an entity comment.
     * The comment gets deleted.
     * <p><b>204</b> - The comment was deleted
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param subid ID of the comment (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteEntityCommentWithHttpInfo(String entityType, Integer id, Integer subid) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'entityType' is set
        if (entityType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'entityType' when calling deleteEntityComment");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteEntityComment");
        }
        // verify the required parameter 'subid' is set
        if (subid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subid' when calling deleteEntityComment");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("entity_type", entityType);
        uriVariables.put("id", id);
        uriVariables.put("subid", subid);
        String path = UriComponentsBuilder.fromPath("/{entity_type}/{id}/comments/{subid}").buildAndExpand(uriVariables).toUriString();
        
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
     * Modify an entity comment.
     * 
     * <p><b>200</b> - The patched comment
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param subid ID of the comment (required)
     * @param body Parameters for patching an entity comment. (optional)
     * @return Comment
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Comment patchEntityComment(String entityType, Integer id, Integer subid, Comment body) throws RestClientException {
        return patchEntityCommentWithHttpInfo(entityType, id, subid, body).getBody();
    }

    /**
     * Modify an entity comment.
     * 
     * <p><b>200</b> - The patched comment
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param subid ID of the comment (required)
     * @param body Parameters for patching an entity comment. (optional)
     * @return ResponseEntity&lt;Comment&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Comment> patchEntityCommentWithHttpInfo(String entityType, Integer id, Integer subid, Comment body) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'entityType' is set
        if (entityType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'entityType' when calling patchEntityComment");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling patchEntityComment");
        }
        // verify the required parameter 'subid' is set
        if (subid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subid' when calling patchEntityComment");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("entity_type", entityType);
        uriVariables.put("id", id);
        uriVariables.put("subid", subid);
        String path = UriComponentsBuilder.fromPath("/{entity_type}/{id}/comments/{subid}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<Comment> returnType = new ParameterizedTypeReference<Comment>() {};
        return apiClient.invokeAPI(path, HttpMethod.PATCH, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Create a comment.
     * 
     * <p><b>201</b> - The comment has been created.
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param body Parameters for creating a comment (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void postEntityComments(String entityType, Integer id, IdCommentsBody body) throws RestClientException {
        postEntityCommentsWithHttpInfo(entityType, id, body);
    }

    /**
     * Create a comment.
     * 
     * <p><b>201</b> - The comment has been created.
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param body Parameters for creating a comment (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> postEntityCommentsWithHttpInfo(String entityType, Integer id, IdCommentsBody body) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'entityType' is set
        if (entityType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'entityType' when calling postEntityComments");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling postEntityComments");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("entity_type", entityType);
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/{entity_type}/{id}/comments").buildAndExpand(uriVariables).toUriString();
        
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
     * Read a comment of that entity.
     * 
     * <p><b>200</b> - A comment.
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param subid ID of the comment (required)
     * @return Comment
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Comment readEntityComment(String entityType, Integer id, Integer subid) throws RestClientException {
        return readEntityCommentWithHttpInfo(entityType, id, subid).getBody();
    }

    /**
     * Read a comment of that entity.
     * 
     * <p><b>200</b> - A comment.
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param subid ID of the comment (required)
     * @return ResponseEntity&lt;Comment&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Comment> readEntityCommentWithHttpInfo(String entityType, Integer id, Integer subid) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'entityType' is set
        if (entityType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'entityType' when calling readEntityComment");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling readEntityComment");
        }
        // verify the required parameter 'subid' is set
        if (subid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subid' when calling readEntityComment");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("entity_type", entityType);
        uriVariables.put("id", id);
        uriVariables.put("subid", subid);
        String path = UriComponentsBuilder.fromPath("/{entity_type}/{id}/comments/{subid}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<Comment> returnType = new ParameterizedTypeReference<Comment>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Read all comments of that entity.
     * 
     * <p><b>200</b> - A list of comments
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @return List&lt;Comment&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Comment> readEntityComments(String entityType, Integer id) throws RestClientException {
        return readEntityCommentsWithHttpInfo(entityType, id).getBody();
    }

    /**
     * Read all comments of that entity.
     * 
     * <p><b>200</b> - A list of comments
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @return ResponseEntity&lt;List&lt;Comment&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Comment>> readEntityCommentsWithHttpInfo(String entityType, Integer id) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'entityType' is set
        if (entityType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'entityType' when calling readEntityComments");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling readEntityComments");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("entity_type", entityType);
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/{entity_type}/{id}/comments").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<List<Comment>> returnType = new ParameterizedTypeReference<List<Comment>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
