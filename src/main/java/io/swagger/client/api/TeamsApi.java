package io.swagger.client.api;

import io.swagger.client.ApiClient;

import io.swagger.client.model.Id;
import io.swagger.client.model.Team;
import io.swagger.client.model.TeamsBody;
import io.swagger.client.model.TeamsIdBody;

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
@Component("io.swagger.client.api.TeamsApi")
public class TeamsApi {
    private ApiClient apiClient;

    public TeamsApi() {
        this(new ApiClient());
    }

    @Autowired
    public TeamsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Actions on a team. 
     * 
     * <p><b>200</b> - The updated team.
     * @param id ID of the team or &#x60;current&#x60;. (required)
     * @param body Parameters for modifying a team. (optional)
     * @return Team
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Team patchTeam(Id id, TeamsIdBody body) throws RestClientException {
        return patchTeamWithHttpInfo(id, body).getBody();
    }

    /**
     * Actions on a team. 
     * 
     * <p><b>200</b> - The updated team.
     * @param id ID of the team or &#x60;current&#x60;. (required)
     * @param body Parameters for modifying a team. (optional)
     * @return ResponseEntity&lt;Team&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Team> patchTeamWithHttpInfo(Id id, TeamsIdBody body) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling patchTeam");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/teams/{id}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<Team> returnType = new ParameterizedTypeReference<Team>() {};
        return apiClient.invokeAPI(path, HttpMethod.PATCH, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Create a new team.
     * 
     * <p><b>201</b> - The team has been created.
     * @param body Parameters for creating a new team. (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void postTeams(TeamsBody body) throws RestClientException {
        postTeamsWithHttpInfo(body);
    }

    /**
     * Create a new team.
     * 
     * <p><b>201</b> - The team has been created.
     * @param body Parameters for creating a new team. (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> postTeamsWithHttpInfo(TeamsBody body) throws RestClientException {
        Object postBody = body;
        String path = UriComponentsBuilder.fromPath("/teams").build().toUriString();
        
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
     * Read a team. Requires Admin permissions.
     * 
     * <p><b>200</b> - A team.
     * @param id ID of the team or &#x60;current&#x60;. (required)
     * @return Team
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Team readTeam(Id id) throws RestClientException {
        return readTeamWithHttpInfo(id).getBody();
    }

    /**
     * Read a team. Requires Admin permissions.
     * 
     * <p><b>200</b> - A team.
     * @param id ID of the team or &#x60;current&#x60;. (required)
     * @return ResponseEntity&lt;Team&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Team> readTeamWithHttpInfo(Id id) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling readTeam");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/teams/{id}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<Team> returnType = new ParameterizedTypeReference<Team>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Read all teams. Requires Sysadmin permissions.
     * 
     * <p><b>200</b> - A list of teams.
     * @return List&lt;Team&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Team> readTeams() throws RestClientException {
        return readTeamsWithHttpInfo().getBody();
    }

    /**
     * Read all teams. Requires Sysadmin permissions.
     * 
     * <p><b>200</b> - A list of teams.
     * @return ResponseEntity&lt;List&lt;Team&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Team>> readTeamsWithHttpInfo() throws RestClientException {
        Object postBody = null;
        String path = UriComponentsBuilder.fromPath("/teams").build().toUriString();
        
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

        ParameterizedTypeReference<List<Team>> returnType = new ParameterizedTypeReference<List<Team>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
