package io.swagger.client.api;

import io.swagger.client.ApiClient;

import io.swagger.client.model.IdExperimentsStatusBody;
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
@Component("io.swagger.client.api.ExperimentsStatusApi")
public class ExperimentsStatusApi {
    private ApiClient apiClient;

    public ExperimentsStatusApi() {
        this(new ApiClient());
    }

    @Autowired
    public ExperimentsStatusApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete a status.
     * 
     * <p><b>204</b> - The status was removed.
     * @param id ID of the team. (required)
     * @param subid ID of the status (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteExpstatus(Integer id, Integer subid) throws RestClientException {
        deleteExpstatusWithHttpInfo(id, subid);
    }

    /**
     * Delete a status.
     * 
     * <p><b>204</b> - The status was removed.
     * @param id ID of the team. (required)
     * @param subid ID of the status (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteExpstatusWithHttpInfo(Integer id, Integer subid) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteExpstatus");
        }
        // verify the required parameter 'subid' is set
        if (subid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subid' when calling deleteExpstatus");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("subid", subid);
        String path = UriComponentsBuilder.fromPath("/teams/{id}/experiments_status/{subid}").buildAndExpand(uriVariables).toUriString();
        
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
     * Modify a status.
     * 
     * <p><b>200</b> - The updated status.
     * @param id ID of the team. (required)
     * @param subid ID of the status (required)
     * @param body Parameters for modifying a status. (optional)
     * @return Statuslike
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Statuslike patchExpstatus(Integer id, Integer subid, Statuslike body) throws RestClientException {
        return patchExpstatusWithHttpInfo(id, subid, body).getBody();
    }

    /**
     * Modify a status.
     * 
     * <p><b>200</b> - The updated status.
     * @param id ID of the team. (required)
     * @param subid ID of the status (required)
     * @param body Parameters for modifying a status. (optional)
     * @return ResponseEntity&lt;Statuslike&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Statuslike> patchExpstatusWithHttpInfo(Integer id, Integer subid, Statuslike body) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling patchExpstatus");
        }
        // verify the required parameter 'subid' is set
        if (subid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subid' when calling patchExpstatus");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("subid", subid);
        String path = UriComponentsBuilder.fromPath("/teams/{id}/experiments_status/{subid}").buildAndExpand(uriVariables).toUriString();
        
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
     * Create a new experiments status.
     * 
     * <p><b>201</b> - New experiments status created.
     * @param id ID of the team. (required)
     * @param body Parameters for creating a status. (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void postTeamOneExpstatus(Integer id, IdExperimentsStatusBody body) throws RestClientException {
        postTeamOneExpstatusWithHttpInfo(id, body);
    }

    /**
     * Create a new experiments status.
     * 
     * <p><b>201</b> - New experiments status created.
     * @param id ID of the team. (required)
     * @param body Parameters for creating a status. (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> postTeamOneExpstatusWithHttpInfo(Integer id, IdExperimentsStatusBody body) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling postTeamOneExpstatus");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/teams/{id}/experiments_status").buildAndExpand(uriVariables).toUriString();
        
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
     * Read experiments status of a team.
     * 
     * <p><b>200</b> - A list of status for the team.
     * @param id ID of the team. (required)
     * @return List&lt;Statuslike&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Statuslike> readTeamExperimentsStatus(Integer id) throws RestClientException {
        return readTeamExperimentsStatusWithHttpInfo(id).getBody();
    }

    /**
     * Read experiments status of a team.
     * 
     * <p><b>200</b> - A list of status for the team.
     * @param id ID of the team. (required)
     * @return ResponseEntity&lt;List&lt;Statuslike&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Statuslike>> readTeamExperimentsStatusWithHttpInfo(Integer id) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling readTeamExperimentsStatus");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/teams/{id}/experiments_status").buildAndExpand(uriVariables).toUriString();
        
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
     * Read a status.
     * 
     * <p><b>200</b> - Read a status.
     * @param id ID of the team. (required)
     * @param subid ID of the status (required)
     * @return Statuslike
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Statuslike readTeamOneExpstatus(Integer id, Integer subid) throws RestClientException {
        return readTeamOneExpstatusWithHttpInfo(id, subid).getBody();
    }

    /**
     * Read a status.
     * 
     * <p><b>200</b> - Read a status.
     * @param id ID of the team. (required)
     * @param subid ID of the status (required)
     * @return ResponseEntity&lt;Statuslike&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Statuslike> readTeamOneExpstatusWithHttpInfo(Integer id, Integer subid) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling readTeamOneExpstatus");
        }
        // verify the required parameter 'subid' is set
        if (subid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subid' when calling readTeamOneExpstatus");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("subid", subid);
        String path = UriComponentsBuilder.fromPath("/teams/{id}/experiments_status/{subid}").buildAndExpand(uriVariables).toUriString();
        
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
