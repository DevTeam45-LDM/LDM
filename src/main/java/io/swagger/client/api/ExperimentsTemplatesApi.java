package io.swagger.client.api;

import com.devteam45ldm.ldm.api.eLabClient.ELabClient;
import io.swagger.client.ApiClient;
import io.swagger.client.model.ExperimentTemplate;
import io.swagger.client.model.ExperimentsTemplatesBody;
import io.swagger.client.model.ExperimentsTemplatesIdBody;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2025-01-17T16:14:35.053224103Z[GMT]")
@Component("io.swagger.client.api.ExperimentsTemplatesApi")
public class ExperimentsTemplatesApi {
    private ApiClient apiClient;

    public ExperimentsTemplatesApi() {
        this(new ApiClient());
    }

    @Autowired
    public ExperimentsTemplatesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete an experiment template.
     * The experiment template gets soft-deleted.
     * <p><b>204</b> - The key was deleted
     * @param id ID of the experiment template (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteExperimentTemplate(Integer id) throws RestClientException {
        deleteExperimentTemplateWithHttpInfo(id);
    }

    /**
     * Delete an experiment template.
     * The experiment template gets soft-deleted.
     * <p><b>204</b> - The key was deleted
     * @param id ID of the experiment template (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteExperimentTemplateWithHttpInfo(Integer id) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteExperimentTemplate");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/experiments_templates/{id}").buildAndExpand(uriVariables).toUriString();
        
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
     * Read an experiment template
     * 
     * <p><b>200</b> - An experiment template
     * @param id ID of the experiment template (required)
     * @return ExperimentTemplate
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ExperimentTemplate getExperimentTemplate(Integer id) throws RestClientException {
        return getExperimentTemplateWithHttpInfo(id).getBody();
    }

    /**
     * Read an experiment template
     * 
     * <p><b>200</b> - An experiment template
     * @param id ID of the experiment template (required)
     * @return ResponseEntity&lt;ExperimentTemplate&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ExperimentTemplate> getExperimentTemplateWithHttpInfo(Integer id) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getExperimentTemplate");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/experiments_templates/{id}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<ExperimentTemplate> returnType = new ParameterizedTypeReference<ExperimentTemplate>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Modify an experiment template
     * 
     * <p><b>200</b> - The patched experiment template
     * @param id ID of the experiment template (required)
     * @param body Parameters for modifying an experiment template (optional)
     * @return ExperimentTemplate
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ExperimentTemplate patchExperimentTemplate(Integer id, ExperimentTemplate body) throws RestClientException {
        return patchExperimentTemplateWithHttpInfo(id, body).getBody();
    }

    /*
    Der Fehler wird ursprünglich von HttpComponentsClientHttpRequestFactory geworfen und in der Methode createResourceAccessException von RestTemplate aufgefangen.
    Dort wird der Fehler in eine RessourceAccessException umgewandelt und aufgrund der fehlenden Fehlerbehandlung propagiert.
    Die Methode patchTeamTagWithHttpInfo von TeamTagsApi macht dann daraus eine RestClientException.
    Daher, wie auch der mitmproxy zeigt, wird keine PATCH-Anfrage an den Server gesendet.
    */

    /**
     * Modify an experiment template
     * 
     * <p><b>200</b> - The patched experiment template
     * @param id ID of the experiment template (required)
     * @param body Parameters for modifying an experiment template (optional)
     * @return ResponseEntity&lt;ExperimentTemplate&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ExperimentTemplate> patchExperimentTemplateWithHttpInfo(Integer id, ExperimentTemplate body) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling patchExperimentTemplate");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/experiments_templates/{id}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        headerParams.add("action", "update"); //test purpose
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

        ParameterizedTypeReference<ExperimentTemplate> returnType = new ParameterizedTypeReference<ExperimentTemplate>() {};
        return apiClient.invokeAPI(path, HttpMethod.PATCH, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Create an experiment template
     * 
     * <p><b>201</b> - The experiment template has been created.
     * @param body Parameters for creating an experiment template (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void postExperimentTemplate(ExperimentsTemplatesBody body) throws RestClientException {
        postExperimentTemplateWithHttpInfo(body);
    }

    /**
     * Create an experiment template
     * 
     * <p><b>201</b> - The experiment template has been created.
     * @param body Parameters for creating an experiment template (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> postExperimentTemplateWithHttpInfo(ExperimentsTemplatesBody body) throws RestClientException {
        Object postBody = body;
        String path = UriComponentsBuilder.fromPath("/experiments_templates").build().toUriString();
        
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
     * Duplicate an experiment template with its ID
     * 
     * <p><b>201</b> - The experiment template has been duplicated.
     * @param id The unique identifier of the experiment template to duplicate. (required)
     * @param body Parameters for duplicating an experiment template (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void postExperimentTemplateById(Integer id, ExperimentsTemplatesIdBody body) throws RestClientException {
        postExperimentTemplateByIdWithHttpInfo(id, body);
    }

    /**
     * Duplicate an experiment template with its ID
     * 
     * <p><b>201</b> - The experiment template has been duplicated.
     * @param id The unique identifier of the experiment template to duplicate. (required)
     * @param body Parameters for duplicating an experiment template (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> postExperimentTemplateByIdWithHttpInfo(Integer id, ExperimentsTemplatesIdBody body) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling postExperimentTemplateById");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/experiments_templates/{id}").buildAndExpand(uriVariables).toUriString();
        
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
     * Read all experiments_templates that are accessible
     * 
     * <p><b>200</b> - A list of experiments_templates
     * @return List&lt;ExperimentTemplate&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<ExperimentTemplate> readExperimentsTemplates() throws RestClientException {
        return readExperimentsTemplatesWithHttpInfo().getBody();
    }

    /**
     * Read all experiments_templates that are accessible
     * 
     * <p><b>200</b> - A list of experiments_templates
     * @return ResponseEntity&lt;List&lt;ExperimentTemplate&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<ExperimentTemplate>> readExperimentsTemplatesWithHttpInfo() throws RestClientException {
        Object postBody = null;
        String path = UriComponentsBuilder.fromPath("/experiments_templates").build().toUriString();
        
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

        ParameterizedTypeReference<List<ExperimentTemplate>> returnType = new ParameterizedTypeReference<List<ExperimentTemplate>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }

    /**
     * Modify an experiment template using a cURL command.
     *
     * @param apiKey The API key for authorization.
     * @param url The base URL of the API.
     * @param id The ID of the experiment template to modify.
     * @param title The new title of the experiment template.
     * @param body The new body content of the experiment template.
     * @throws RestClientException if an error occurs while attempting to invoke the API.
     */
    public void modifyExperimentTemplateCURL(String apiKey, String url, Integer id, String title, String body) throws RestClientException {
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
                curl --location --request PATCH '%s/experiments_templates/%d' \\
                --header 'Authorization: %s' \\
                --header 'action: update' \\
                --header 'Content-Type: application/json' \\
                --data '{
                    "title": "%s",
                    "body": "%s"
                }'
            """;

            String command = String.format(commandTemplate, url, id, apiKey, title, body);
            ProcessBuilder processBuilder = new ProcessBuilder("/bin/sh", "-c", command);
            processBuilder.directory(new File("/home"));
            Process process = processBuilder.start();
            InputStream inputStream = process.getInputStream();
            int exitCode = process.waitFor();

        } catch (Exception e) {
            throw new RestClientException("Undefined error while saving changes: " + e.getMessage());
        }
    }
}

/*
  curl --location --request PATCH 'https://sfb270eln.physik.uni-due.de/api/v2/experiments_templates/81' \
  --header 'Authorization: xx-xxxxxxxxxxxxxxxxxxxx' \
  --header 'action: update' \
  --header 'Content-Type: application/json' \
  --header 'Cookie: PHPSESSID=xxxxxxx' \
  --data '{
    "title": "testJonas2"
  }'

  !!! header "action" and Cookie is not needed !!!
  curl --location --request PATCH 'https://sfb270eln.physik.uni-due.de/api/v2/experiments_templates/81' \
  --header 'Authorization: xx-xxxxxxxxxxxxxxxxxxxx' \
  --header 'action: update' \
  --header 'Content-Type: application/json' \
  --header 'Cookie: PHPSESSID=xxxxxxx' \
  --data '{
    "action": "lock"
  }'
 */