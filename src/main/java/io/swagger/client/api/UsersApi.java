package io.swagger.client.api;

import io.swagger.client.ApiClient;

import io.swagger.client.model.Id1;
import io.swagger.client.model.InlineResponse2006;
import io.swagger.client.model.Users;
import io.swagger.client.model.UsersBody;
import io.swagger.client.model.UsersIdBody;

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
@Component("io.swagger.client.api.UsersApi")
public class UsersApi {
    private ApiClient apiClient;

    public UsersApi() {
        this(new ApiClient());
    }

    @Autowired
    public UsersApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Modify a user.
     * Note: it is possible to use \&quot;me\&quot; instead of the userid to access the user of the API key. 
     * <p><b>200</b> - Public properties of a user.
     * @param id ID of the user or &#x60;me&#x60;. (required)
     * @param body Parameters for modifying a user. (optional)
     * @return Users
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Users patchUser(Id1 id, UsersIdBody body) throws RestClientException {
        return patchUserWithHttpInfo(id, body).getBody();
    }

    /**
     * Modify a user.
     * Note: it is possible to use \&quot;me\&quot; instead of the userid to access the user of the API key. 
     * <p><b>200</b> - Public properties of a user.
     * @param id ID of the user or &#x60;me&#x60;. (required)
     * @param body Parameters for modifying a user. (optional)
     * @return ResponseEntity&lt;Users&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Users> patchUserWithHttpInfo(Id1 id, UsersIdBody body) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling patchUser");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/users/{id}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<Users> returnType = new ParameterizedTypeReference<Users>() {};
        return apiClient.invokeAPI(path, HttpMethod.PATCH, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Create a new user.
     * An Admin can create a user in its own team only. A sysadmin can specify the team. 
     * <p><b>201</b> - The user has been created.
     * @param body Parameters for creating a user. (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void postUser(UsersBody body) throws RestClientException {
        postUserWithHttpInfo(body);
    }

    /**
     * Create a new user.
     * An Admin can create a user in its own team only. A sysadmin can specify the team. 
     * <p><b>201</b> - The user has been created.
     * @param body Parameters for creating a user. (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> postUserWithHttpInfo(UsersBody body) throws RestClientException {
        Object postBody = body;
        String path = UriComponentsBuilder.fromPath("/users").build().toUriString();
        
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
     * Read information of a user.
     * Note: it is possible to use \&quot;me\&quot; instead of the userid to access the user of the API key. 
     * <p><b>200</b> - Public properties of a user.
     * @param id ID of the user or &#x60;me&#x60;. (required)
     * @return Users
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Users readUser(Id1 id) throws RestClientException {
        return readUserWithHttpInfo(id).getBody();
    }

    /**
     * Read information of a user.
     * Note: it is possible to use \&quot;me\&quot; instead of the userid to access the user of the API key. 
     * <p><b>200</b> - Public properties of a user.
     * @param id ID of the user or &#x60;me&#x60;. (required)
     * @return ResponseEntity&lt;Users&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Users> readUserWithHttpInfo(Id1 id) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling readUser");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/users/{id}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<Users> returnType = new ParameterizedTypeReference<Users>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Read users from instance.
     * Get a list of users with an active account on the instance.
     * <p><b>200</b> - A list of users
     * @param includeArchived Include archived users in the response (optional)
     * @return List&lt;InlineResponse2006&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<InlineResponse2006> readUsers(String includeArchived) throws RestClientException {
        return readUsersWithHttpInfo(includeArchived).getBody();
    }

    /**
     * Read users from instance.
     * Get a list of users with an active account on the instance.
     * <p><b>200</b> - A list of users
     * @param includeArchived Include archived users in the response (optional)
     * @return ResponseEntity&lt;List&lt;InlineResponse2006&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<InlineResponse2006>> readUsersWithHttpInfo(String includeArchived) throws RestClientException {
        Object postBody = null;
        String path = UriComponentsBuilder.fromPath("/users").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "includeArchived", includeArchived));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "token" };

        ParameterizedTypeReference<List<InlineResponse2006>> returnType = new ParameterizedTypeReference<List<InlineResponse2006>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
