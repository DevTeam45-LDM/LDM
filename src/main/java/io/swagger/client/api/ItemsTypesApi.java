package io.swagger.client.api;

import io.swagger.client.ApiClient;

import io.swagger.client.model.ItemsType;
import io.swagger.client.model.ItemsTypesBody;

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
@Component("io.swagger.client.api.ItemsTypesApi")
public class ItemsTypesApi {
    private ApiClient apiClient;

    public ItemsTypesApi() {
        this(new ApiClient());
    }

    @Autowired
    public ItemsTypesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete a resource category.
     * The resource category gets soft-deleted.
     * <p><b>204</b> - The resource category was marked as deleted.
     * @param id ID of the resource category. (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteItemsType(Integer id) throws RestClientException {
        deleteItemsTypeWithHttpInfo(id);
    }

    /**
     * Delete a resource category.
     * The resource category gets soft-deleted.
     * <p><b>204</b> - The resource category was marked as deleted.
     * @param id ID of the resource category. (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteItemsTypeWithHttpInfo(Integer id) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteItemsType");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/items_types/{id}").buildAndExpand(uriVariables).toUriString();
        
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
     * Read a resource category.
     * 
     * <p><b>200</b> - A resource category.
     * @param id ID of the resource category. (required)
     * @return ItemsType
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ItemsType getItemsType(Integer id) throws RestClientException {
        return getItemsTypeWithHttpInfo(id).getBody();
    }

    /**
     * Read a resource category.
     * 
     * <p><b>200</b> - A resource category.
     * @param id ID of the resource category. (required)
     * @return ResponseEntity&lt;ItemsType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ItemsType> getItemsTypeWithHttpInfo(Integer id) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getItemsType");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/items_types/{id}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<ItemsType> returnType = new ParameterizedTypeReference<ItemsType>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Modify a resource category.
     * 
     * <p><b>200</b> - The patched resource category.
     * @param id ID of the resource category. (required)
     * @param body  (optional)
     * @return ItemsType
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ItemsType patchItemsType(Integer id, ItemsType body) throws RestClientException {
        return patchItemsTypeWithHttpInfo(id, body).getBody();
    }

    /**
     * Modify a resource category.
     * 
     * <p><b>200</b> - The patched resource category.
     * @param id ID of the resource category. (required)
     * @param body  (optional)
     * @return ResponseEntity&lt;ItemsType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ItemsType> patchItemsTypeWithHttpInfo(Integer id, ItemsType body) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling patchItemsType");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/items_types/{id}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<ItemsType> returnType = new ParameterizedTypeReference<ItemsType>() {};
        return apiClient.invokeAPI(path, HttpMethod.PATCH, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Create a resource category
     * 
     * <p><b>201</b> - The items type has been created.
     * @param body Parameters for creating a resource category (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void postItemsTypes(ItemsTypesBody body) throws RestClientException {
        postItemsTypesWithHttpInfo(body);
    }

    /**
     * Create a resource category
     * 
     * <p><b>201</b> - The items type has been created.
     * @param body Parameters for creating a resource category (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> postItemsTypesWithHttpInfo(ItemsTypesBody body) throws RestClientException {
        Object postBody = body;
        String path = UriComponentsBuilder.fromPath("/items_types").build().toUriString();
        
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
     * Read all resources categories that are accessible.
     * 
     * <p><b>200</b> - A list of resources categories.
     * @return List&lt;ItemsType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<ItemsType> readItemsTypes() throws RestClientException {
        return readItemsTypesWithHttpInfo().getBody();
    }

    /**
     * Read all resources categories that are accessible.
     * 
     * <p><b>200</b> - A list of resources categories.
     * @return ResponseEntity&lt;List&lt;ItemsType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<ItemsType>> readItemsTypesWithHttpInfo() throws RestClientException {
        Object postBody = null;
        String path = UriComponentsBuilder.fromPath("/items_types").build().toUriString();
        
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

        ParameterizedTypeReference<List<ItemsType>> returnType = new ParameterizedTypeReference<List<ItemsType>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
