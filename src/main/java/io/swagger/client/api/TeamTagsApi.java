package io.swagger.client.api;

import com.devteam45ldm.ldm.api.eLabClient.ELabClient;
import io.swagger.client.ApiClient;

import io.swagger.client.model.IdTagsBody;
import io.swagger.client.model.IdTagsBody1;
import io.swagger.client.model.InlineResponse2004;
import io.swagger.client.model.Tag;
import io.swagger.client.model.TagsSubidBody;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
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
@Component("io.swagger.client.api.TeamTagsApi")
public class TeamTagsApi {
    private ApiClient apiClient;

    public TeamTagsApi() {
        this(new ApiClient());
    }

    @Autowired
    public TeamTagsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete a tag.
     * 
     * <p><b>204</b> - The tag was removed.
     * @param id ID of the team. (required)
     * @param subid ID of the tag. (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteTeamTag(Integer id, Integer subid) throws RestClientException {
        deleteTeamTagWithHttpInfo(id, subid);
    }

    /**
     * Delete a tag.
     * 
     * <p><b>204</b> - The tag was removed.
     * @param id ID of the team. (required)
     * @param subid ID of the tag. (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteTeamTagWithHttpInfo(Integer id, Integer subid) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteTeamTag");
        }
        // verify the required parameter 'subid' is set
        if (subid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subid' when calling deleteTeamTag");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("subid", subid);
        String path = UriComponentsBuilder.fromPath("/teams/{id}/tags/{subid}").buildAndExpand(uriVariables).toUriString();
        
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
     * Actions on tags. 
     * 
     * <p><b>200</b> - The team tag has been modified.
     * @param id ID of the team. (required)
     * @param body Parameters for modifying team tags. (optional)
     * @return List&lt;Tag&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Tag> patchTags(Integer id, IdTagsBody1 body) throws RestClientException {
        return patchTagsWithHttpInfo(id, body).getBody();
    }

    /**
     * Actions on tags. 
     * 
     * <p><b>200</b> - The team tag has been modified.
     * @param id ID of the team. (required)
     * @param body Parameters for modifying team tags. (optional)
     * @return ResponseEntity&lt;List&lt;Tag&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Tag>> patchTagsWithHttpInfo(Integer id, IdTagsBody1 body) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling patchTags");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/teams/{id}/tags").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<List<Tag>> returnType = new ParameterizedTypeReference<List<Tag>>() {};
        return apiClient.invokeAPI(path, HttpMethod.PATCH, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Actions on a tag. 
     * 
     * <p><b>200</b> - The team tag has been modified.
     * @param id ID of the team. (required)
     * @param subid ID of the tag. (required)
     * @param body Parameters for modifying a tag. (optional)
     * @return Tag
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Tag patchTeamTag(Integer id, Integer subid, TagsSubidBody body) throws RestClientException {
        return patchTeamTagWithHttpInfo(id, subid, body).getBody();
    }

    /**
     * Actions on a tag. 
     * 
     * <p><b>200</b> - The team tag has been modified.
     * @param id ID of the team. (required)
     * @param subid ID of the tag. (required)
     * @param body Parameters for modifying a tag. (optional)
     * @return ResponseEntity&lt;Tag&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Tag> patchTeamTagWithHttpInfo(Integer id, Integer subid, TagsSubidBody body) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling patchTeamTag");
        }
        // verify the required parameter 'subid' is set
        if (subid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subid' when calling patchTeamTag");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("subid", subid);
        String path = UriComponentsBuilder.fromPath("/teams/{id}/tags/{subid}").buildAndExpand(uriVariables).toUriString();
        
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
     * Create a tag in the team.
     * 
     * <p><b>201</b> - The tag has been added.
     * @param id ID of the team. (required)
     * @param body Parameters for adding a tag in the team. (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void postTeamTag(Integer id, IdTagsBody body) throws RestClientException {
        postTeamTagWithHttpInfo(id, body);
    }

    /**
     * Create a tag in the team.
     * 
     * <p><b>201</b> - The tag has been added.
     * @param id ID of the team. (required)
     * @param body Parameters for adding a tag in the team. (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> postTeamTagWithHttpInfo(Integer id, IdTagsBody body) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling postTeamTag");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/teams/{id}/tags").buildAndExpand(uriVariables).toUriString();
        
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
     * @param id ID of the team. (required)
     * @param subid ID of the tag. (required)
     * @return InlineResponse2004
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public InlineResponse2004 readTeamTag(Integer id, Integer subid) throws RestClientException {
        return readTeamTagWithHttpInfo(id, subid).getBody();
    }

    /**
     * Read a tag.
     * 
     * <p><b>200</b> - A tag.
     * @param id ID of the team. (required)
     * @param subid ID of the tag. (required)
     * @return ResponseEntity&lt;InlineResponse2004&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<InlineResponse2004> readTeamTagWithHttpInfo(Integer id, Integer subid) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling readTeamTag");
        }
        // verify the required parameter 'subid' is set
        if (subid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subid' when calling readTeamTag");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("subid", subid);
        String path = UriComponentsBuilder.fromPath("/teams/{id}/tags/{subid}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<InlineResponse2004> returnType = new ParameterizedTypeReference<InlineResponse2004>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Read all tags for the team.
     * 
     * <p><b>200</b> - A list of tags.
     * @param id ID of the team. (required)
     * @return InlineResponse2003
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Tag> readTeamTags(Integer id) throws RestClientException {
        return readTeamTagsWithHttpInfo(id).getBody();
    }

    /**
     * Read all tags for the team.
     * 
     * <p><b>200</b> - A list of tags.
     * @param id ID of the team. (required)
     * @return ResponseEntity&lt;InlineResponse2003&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Tag>> readTeamTagsWithHttpInfo(Integer id) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling readTeamTags");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/teams/{id}/tags").buildAndExpand(uriVariables).toUriString();
        
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
        try {
            return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
        } catch (RestClientException e) {
            throw e;
        }
    }

    /**
     * Modify a tag using a cURL command.
     *
     * @param apiKey The API key for authorization. (required)
     * @param url The base URL of the API. (required)
     * @param team The ID of the team. (required)
     * @param id The ID of the tag. (required)
     * @param title The new title for the tag. (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void modifyTagCURL(String apiKey, String url, Integer team, Integer id, String title) throws RestClientException {
        ELabClient.checkApiKey(apiKey);
        try {
            url = ELabClient.checkUrl(url);
        } catch (URISyntaxException e) {
            throw new RestClientException(e.getMessage());
        } catch (MalformedURLException e) {
            throw new RestClientException(e.getMessage());
        }

        try { //TODO use ApiClient
            String commandTemplate = """
                curl --location --request PATCH '%s/teams/%d/tags/%d' \\
                      --header 'Authorization: %s' \\
                      --header 'action: update' \\
                      --header 'Content-Type: application/json' \\
                      --data '{
                          "title": "%s"
                      }'
            """;

            String command = String.format(commandTemplate, url, team, id, apiKey, title);
            ProcessBuilder processBuilder = new ProcessBuilder("/bin/sh", "-c", command);
            processBuilder.directory(new File("/home"));
            Process process = processBuilder.start();
            InputStream inputStream = process.getInputStream();
            int exitCode = process.waitFor();
        } catch (Exception e) {
            throw new RestClientException(e.getMessage());
        }
    }
}
