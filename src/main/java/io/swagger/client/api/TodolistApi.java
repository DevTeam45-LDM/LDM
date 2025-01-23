package io.swagger.client.api;

import io.swagger.client.ApiClient;

import io.swagger.client.model.Todoitem;
import io.swagger.client.model.TodolistBody;
import io.swagger.client.model.TodolistIdBody;

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
@Component("io.swagger.client.api.TodolistApi")
public class TodolistApi {
    private ApiClient apiClient;

    public TodolistApi() {
        this(new ApiClient());
    }

    @Autowired
    public TodolistApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete a todoitem.
     * 
     * <p><b>204</b> - The todoitem was removed.
     * @param id ID of the todoitem. (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteTodoitem(Integer id) throws RestClientException {
        deleteTodoitemWithHttpInfo(id);
    }

    /**
     * Delete a todoitem.
     * 
     * <p><b>204</b> - The todoitem was removed.
     * @param id ID of the todoitem. (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteTodoitemWithHttpInfo(Integer id) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteTodoitem");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/todolist/{id}").buildAndExpand(uriVariables).toUriString();
        
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
     * Actions on a todoitem. 
     * 
     * <p><b>200</b> - The updated todoitem.
     * @param id ID of the todoitem. (required)
     * @param body Parameters for modifying a todoitem. (optional)
     * @return Todoitem
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Todoitem patchTodoitem(Integer id, TodolistIdBody body) throws RestClientException {
        return patchTodoitemWithHttpInfo(id, body).getBody();
    }

    /**
     * Actions on a todoitem. 
     * 
     * <p><b>200</b> - The updated todoitem.
     * @param id ID of the todoitem. (required)
     * @param body Parameters for modifying a todoitem. (optional)
     * @return ResponseEntity&lt;Todoitem&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Todoitem> patchTodoitemWithHttpInfo(Integer id, TodolistIdBody body) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling patchTodoitem");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/todolist/{id}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<Todoitem> returnType = new ParameterizedTypeReference<Todoitem>() {};
        return apiClient.invokeAPI(path, HttpMethod.PATCH, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Create a todo item
     * 
     * <p><b>201</b> - The todo entry has been created.
     * @param body Parameters for creating a todoitem. (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void postTodolist(TodolistBody body) throws RestClientException {
        postTodolistWithHttpInfo(body);
    }

    /**
     * Create a todo item
     * 
     * <p><b>201</b> - The todo entry has been created.
     * @param body Parameters for creating a todoitem. (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> postTodolistWithHttpInfo(TodolistBody body) throws RestClientException {
        Object postBody = body;
        String path = UriComponentsBuilder.fromPath("/todolist").build().toUriString();
        
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
     * Read a todo entry.
     * 
     * <p><b>200</b> - A todoitem.
     * @param id ID of the todoitem. (required)
     * @return Todoitem
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Todoitem readTodoitem(Integer id) throws RestClientException {
        return readTodoitemWithHttpInfo(id).getBody();
    }

    /**
     * Read a todo entry.
     * 
     * <p><b>200</b> - A todoitem.
     * @param id ID of the todoitem. (required)
     * @return ResponseEntity&lt;Todoitem&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Todoitem> readTodoitemWithHttpInfo(Integer id) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling readTodoitem");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/todolist/{id}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<Todoitem> returnType = new ParameterizedTypeReference<Todoitem>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Read all todoitems.
     * 
     * <p><b>200</b> - A list of things to do.
     * @return List&lt;Todoitem&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Todoitem> readTodolist() throws RestClientException {
        return readTodolistWithHttpInfo().getBody();
    }

    /**
     * Read all todoitems.
     * 
     * <p><b>200</b> - A list of things to do.
     * @return ResponseEntity&lt;List&lt;Todoitem&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Todoitem>> readTodolistWithHttpInfo() throws RestClientException {
        Object postBody = null;
        String path = UriComponentsBuilder.fromPath("/todolist").build().toUriString();
        
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

        ParameterizedTypeReference<List<Todoitem>> returnType = new ParameterizedTypeReference<List<Todoitem>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
