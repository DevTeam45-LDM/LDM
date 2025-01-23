package io.swagger.client.api;

import io.swagger.client.ApiClient;

import io.swagger.client.model.IdTeamgroupsBody;
import io.swagger.client.model.InlineResponse2005;
import io.swagger.client.model.Teamgroup;
import io.swagger.client.model.TeamgroupsSubidBody;

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
@Component("io.swagger.client.api.TeamgroupsApi")
public class TeamgroupsApi {
    private ApiClient apiClient;

    public TeamgroupsApi() {
        this(new ApiClient());
    }

    @Autowired
    public TeamgroupsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete a teamgroup.
     * 
     * <p><b>204</b> - The teamgroup was removed.
     * @param id ID of the team. (required)
     * @param subid ID of the teamgroup. (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteTeamgroup(Integer id, Integer subid) throws RestClientException {
        deleteTeamgroupWithHttpInfo(id, subid);
    }

    /**
     * Delete a teamgroup.
     * 
     * <p><b>204</b> - The teamgroup was removed.
     * @param id ID of the team. (required)
     * @param subid ID of the teamgroup. (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteTeamgroupWithHttpInfo(Integer id, Integer subid) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteTeamgroup");
        }
        // verify the required parameter 'subid' is set
        if (subid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subid' when calling deleteTeamgroup");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("subid", subid);
        String path = UriComponentsBuilder.fromPath("/teams/{id}/teamgroups/{subid}").buildAndExpand(uriVariables).toUriString();
        
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
     * Modify a teamgroup.
     * 
     * <p><b>200</b> - The updated teamgroup.
     * @param id ID of the team. (required)
     * @param subid ID of the teamgroup. (required)
     * @param body Parameters for modifying a teamgroup. (optional)
     * @return Teamgroup
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Teamgroup patchTeamgroup(Integer id, Integer subid, TeamgroupsSubidBody body) throws RestClientException {
        return patchTeamgroupWithHttpInfo(id, subid, body).getBody();
    }

    /**
     * Modify a teamgroup.
     * 
     * <p><b>200</b> - The updated teamgroup.
     * @param id ID of the team. (required)
     * @param subid ID of the teamgroup. (required)
     * @param body Parameters for modifying a teamgroup. (optional)
     * @return ResponseEntity&lt;Teamgroup&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Teamgroup> patchTeamgroupWithHttpInfo(Integer id, Integer subid, TeamgroupsSubidBody body) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling patchTeamgroup");
        }
        // verify the required parameter 'subid' is set
        if (subid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subid' when calling patchTeamgroup");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("subid", subid);
        String path = UriComponentsBuilder.fromPath("/teams/{id}/teamgroups/{subid}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<Teamgroup> returnType = new ParameterizedTypeReference<Teamgroup>() {};
        return apiClient.invokeAPI(path, HttpMethod.PATCH, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Create a new teamgroup.
     * 
     * <p><b>201</b> - New teamgroup.
     * @param id ID of the team. (required)
     * @param body Parameters for creating a teamgroup. (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void postTeamgroups(Integer id, IdTeamgroupsBody body) throws RestClientException {
        postTeamgroupsWithHttpInfo(id, body);
    }

    /**
     * Create a new teamgroup.
     * 
     * <p><b>201</b> - New teamgroup.
     * @param id ID of the team. (required)
     * @param body Parameters for creating a teamgroup. (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> postTeamgroupsWithHttpInfo(Integer id, IdTeamgroupsBody body) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling postTeamgroups");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/teams/{id}/teamgroups").buildAndExpand(uriVariables).toUriString();
        
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
     * Read teamgroups of a team.
     * 
     * <p><b>200</b> - A list of teamgroups for the team.
     * @param id ID of the team. (required)
     * @return List&lt;Teamgroup&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Teamgroup> readTeamTeamgroups(Integer id) throws RestClientException {
        return readTeamTeamgroupsWithHttpInfo(id).getBody();
    }

    /**
     * Read teamgroups of a team.
     * 
     * <p><b>200</b> - A list of teamgroups for the team.
     * @param id ID of the team. (required)
     * @return ResponseEntity&lt;List&lt;Teamgroup&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Teamgroup>> readTeamTeamgroupsWithHttpInfo(Integer id) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling readTeamTeamgroups");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/teams/{id}/teamgroups").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<List<Teamgroup>> returnType = new ParameterizedTypeReference<List<Teamgroup>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Read a teamgroup.
     * 
     * <p><b>200</b> - A teamgroup.
     * @param id ID of the team. (required)
     * @param subid ID of the teamgroup. (required)
     * @return InlineResponse2005
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public InlineResponse2005 readTeamgroup(Integer id, Integer subid) throws RestClientException {
        return readTeamgroupWithHttpInfo(id, subid).getBody();
    }

    /**
     * Read a teamgroup.
     * 
     * <p><b>200</b> - A teamgroup.
     * @param id ID of the team. (required)
     * @param subid ID of the teamgroup. (required)
     * @return ResponseEntity&lt;InlineResponse2005&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<InlineResponse2005> readTeamgroupWithHttpInfo(Integer id, Integer subid) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling readTeamgroup");
        }
        // verify the required parameter 'subid' is set
        if (subid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subid' when calling readTeamgroup");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("subid", subid);
        String path = UriComponentsBuilder.fromPath("/teams/{id}/teamgroups/{subid}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<InlineResponse2005> returnType = new ParameterizedTypeReference<InlineResponse2005>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
