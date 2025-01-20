package io.swagger.client.api;

import io.swagger.client.ApiClient;

import io.swagger.client.model.IdExperimentsCategoriesBody;
import io.swagger.client.model.Statuslike;

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
@Component("io.swagger.client.api.ExperimentsCategoriesApi")
public class ExperimentsCategoriesApi {
    private ApiClient apiClient;

    public ExperimentsCategoriesApi() {
        this(new ApiClient());
    }

    @Autowired
    public ExperimentsCategoriesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete a category.
     * 
     * <p><b>204</b> - The category was removed.
     * @param id ID of the team. (required)
     * @param subid ID of the category. (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteExpcat(Integer id, Integer subid) throws RestClientException {
        deleteExpcatWithHttpInfo(id, subid);
    }

    /**
     * Delete a category.
     * 
     * <p><b>204</b> - The category was removed.
     * @param id ID of the team. (required)
     * @param subid ID of the category. (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteExpcatWithHttpInfo(Integer id, Integer subid) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteExpcat");
        }
        // verify the required parameter 'subid' is set
        if (subid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subid' when calling deleteExpcat");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("subid", subid);
        String path = UriComponentsBuilder.fromPath("/teams/{id}/experiments_categories/{subid}").buildAndExpand(uriVariables).toUriString();
        
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
     * Modify a category.
     * 
     * <p><b>200</b> - The updated category.
     * @param id ID of the team. (required)
     * @param subid ID of the category. (required)
     * @param body Parameters for modifying a category. (optional)
     * @return Statuslike
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Statuslike patchExpcat(Integer id, Integer subid, Statuslike body) throws RestClientException {
        return patchExpcatWithHttpInfo(id, subid, body).getBody();
    }

    /**
     * Modify a category.
     * 
     * <p><b>200</b> - The updated category.
     * @param id ID of the team. (required)
     * @param subid ID of the category. (required)
     * @param body Parameters for modifying a category. (optional)
     * @return ResponseEntity&lt;Statuslike&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Statuslike> patchExpcatWithHttpInfo(Integer id, Integer subid, Statuslike body) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling patchExpcat");
        }
        // verify the required parameter 'subid' is set
        if (subid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subid' when calling patchExpcat");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("subid", subid);
        String path = UriComponentsBuilder.fromPath("/teams/{id}/experiments_categories/{subid}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<Statuslike> returnType = new ParameterizedTypeReference<Statuslike>() {};
        return apiClient.invokeAPI(path, HttpMethod.PATCH, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Create a new category for experiments.
     * 
     * <p><b>201</b> - Create a category.
     * @param id ID of the team. (required)
     * @param body Parameters for creating a category. (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void postTeamOneExpcat(Integer id, IdExperimentsCategoriesBody body) throws RestClientException {
        postTeamOneExpcatWithHttpInfo(id, body);
    }

    /**
     * Create a new category for experiments.
     * 
     * <p><b>201</b> - Create a category.
     * @param id ID of the team. (required)
     * @param body Parameters for creating a category. (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> postTeamOneExpcatWithHttpInfo(Integer id, IdExperimentsCategoriesBody body) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling postTeamOneExpcat");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/teams/{id}/experiments_categories").buildAndExpand(uriVariables).toUriString();
        
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
     * Read experiments categories of a team.
     * 
     * <p><b>200</b> - A list of experiments categories for the team.
     * @param id ID of the team. (required)
     * @return List&lt;Statuslike&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Statuslike> readTeamExperimentsCategories(Integer id) throws RestClientException {
        return readTeamExperimentsCategoriesWithHttpInfo(id).getBody();
    }

    /**
     * Read experiments categories of a team.
     * 
     * <p><b>200</b> - A list of experiments categories for the team.
     * @param id ID of the team. (required)
     * @return ResponseEntity&lt;List&lt;Statuslike&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Statuslike>> readTeamExperimentsCategoriesWithHttpInfo(Integer id) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling readTeamExperimentsCategories");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/teams/{id}/experiments_categories").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<List<Statuslike>> returnType = new ParameterizedTypeReference<List<Statuslike>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Read a category.
     * 
     * <p><b>200</b> - Read a category.
     * @param id ID of the team. (required)
     * @param subid ID of the category. (required)
     * @return Statuslike
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Statuslike readTeamOneExpcat(Integer id, Integer subid) throws RestClientException {
        return readTeamOneExpcatWithHttpInfo(id, subid).getBody();
    }

    /**
     * Read a category.
     * 
     * <p><b>200</b> - Read a category.
     * @param id ID of the team. (required)
     * @param subid ID of the category. (required)
     * @return ResponseEntity&lt;Statuslike&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Statuslike> readTeamOneExpcatWithHttpInfo(Integer id, Integer subid) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling readTeamOneExpcat");
        }
        // verify the required parameter 'subid' is set
        if (subid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subid' when calling readTeamOneExpcat");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("subid", subid);
        String path = UriComponentsBuilder.fromPath("/teams/{id}/experiments_categories/{subid}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<Statuslike> returnType = new ParameterizedTypeReference<Statuslike>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
