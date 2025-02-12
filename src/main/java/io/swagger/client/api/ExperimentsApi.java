package io.swagger.client.api;

import com.devteam45ldm.ldm.api.eLabClient.ELabClient;
import io.swagger.client.ApiClient;

import io.swagger.client.model.Experiment;
import io.swagger.client.model.ExperimentsBody;
import io.swagger.client.model.ExperimentsIdBody;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
@Component("io.swagger.client.api.ExperimentsApi")
public class ExperimentsApi {
    private ApiClient apiClient;

    public ExperimentsApi() {
        this(new ApiClient());
    }

    @Autowired
    public ExperimentsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete an experiment.
     * The experiment gets soft-deleted.
     * <p><b>204</b> - The experiment was deleted
     * @param id ID of the experiment (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteExperiment(Integer id) throws RestClientException {
        deleteExperimentWithHttpInfo(id);
    }

    /**
     * Delete an experiment.
     * The experiment gets soft-deleted.
     * <p><b>204</b> - The experiment was deleted
     * @param id ID of the experiment (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteExperimentWithHttpInfo(Integer id) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteExperiment");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/experiments/{id}").buildAndExpand(uriVariables).toUriString();
        
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
     * Read an experiment
     * 
     * <p><b>200</b> - An experiment
     * @param id ID of the experiment (required)
     * @param format Get the entity in a different format like csv, pdf, eln or zip. \&quot;pdfa\&quot; means archive pdf (PDF/A), same with \&quot;zipa\&quot;.  (optional, default to json)
     * @param json Include a full JSON export in the ZIP archive. Only applicable if format is zip(a).  (optional, default to false)
     * @param withTitle Include the title in the QR code. Only applicable if format is qrpng.  (optional, default to true)
     * @param size Specify the size of the QR code in pixels. Only applicable if format is qrpng.  (optional, default to 250)
     * @param changelog Toggles if the changelog should be included in PDF exports (pdf, pdfa, zip, zipa). Changelog is by default included if the export provides PDF/A, otherwise not.  (optional, default to false)
     * @return Experiment
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Experiment getExperiment(Integer id, String format, Boolean json, Boolean withTitle, Integer size, Boolean changelog) throws RestClientException {
        return getExperimentWithHttpInfo(id, format, json, withTitle, size, changelog).getBody();
    }

    /**
     * Read an experiment
     * 
     * <p><b>200</b> - An experiment
     * @param id ID of the experiment (required)
     * @param format Get the entity in a different format like csv, pdf, eln or zip. \&quot;pdfa\&quot; means archive pdf (PDF/A), same with \&quot;zipa\&quot;.  (optional, default to json)
     * @param json Include a full JSON export in the ZIP archive. Only applicable if format is zip(a).  (optional, default to false)
     * @param withTitle Include the title in the QR code. Only applicable if format is qrpng.  (optional, default to true)
     * @param size Specify the size of the QR code in pixels. Only applicable if format is qrpng.  (optional, default to 250)
     * @param changelog Toggles if the changelog should be included in PDF exports (pdf, pdfa, zip, zipa). Changelog is by default included if the export provides PDF/A, otherwise not.  (optional, default to false)
     * @return ResponseEntity&lt;Experiment&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Experiment> getExperimentWithHttpInfo(Integer id, String format, Boolean json, Boolean withTitle, Integer size, Boolean changelog) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getExperiment");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/experiments/{id}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "format", format));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "json", json));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "withTitle", withTitle));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "changelog", changelog));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "token" };

        ParameterizedTypeReference<Experiment> returnType = new ParameterizedTypeReference<Experiment>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Modify an experiment
     * 
     * <p><b>200</b> - The patched experiment
     * @param id ID of the experiment (required)
     * @param body Parameters for patching an experiment (optional)
     * @return Experiment
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Experiment patchExperiment(Integer id, ExperimentsBody body) throws RestClientException {
        return patchExperimentWithHttpInfo(id, body).getBody();
    }

    /*
    Der Fehler wird ursprünglich von HttpComponentsClientHttpRequestFactory geworfen und in der Methode createResourceAccessException von RestTemplate aufgefangen.
    Dort wird der Fehler in eine RessourceAccessException umgewandelt und aufgrund der fehlenden Fehlerbehandlung propagiert.
    Die Methode patchTeamTagWithHttpInfo von TeamTagsApi macht dann daraus eine RestClientException.
    Daher, wie auch der mitmproxy zeigt, wird keine PATCH-Anfrage an den Server gesendet.
    */

    /**
     * Modify an experiment
     * 
     * <p><b>200</b> - The patched experiment
     * @param id ID of the experiment (required)
     * @param body Parameters for patching an experiment (optional)
     * @return ResponseEntity&lt;Experiment&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Experiment> patchExperimentWithHttpInfo(Integer id, ExperimentsBody body) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling patchExperiment");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/experiments/{id}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<Experiment> returnType = new ParameterizedTypeReference<Experiment>() {};
        return apiClient.invokeAPIOKHTTPClient(path, HttpMethod.PATCH, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Create an experiment
     * 
     * <p><b>201</b> - The experiment has been created.
     * @param body Parameters for creating an experiment (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void postExperiment(ExperimentsBody body) throws RestClientException {
        postExperimentWithHttpInfo(body);
    }

    /**
     * Create an experiment
     * 
     * <p><b>201</b> - The experiment has been created.
     * @param body Parameters for creating an experiment (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> postExperimentWithHttpInfo(ExperimentsBody body) throws RestClientException {
        Object postBody = body;
        String path = UriComponentsBuilder.fromPath("/experiments").build().toUriString();
        
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
     * Duplicate an experiment with its ID
     * 
     * <p><b>201</b> - The experiment has been duplicated.
     * @param id The unique identifier of the experiment to duplicate. (required)
     * @param body Parameters for duplicating an experiment (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void postExperimentById(Integer id, ExperimentsIdBody body) throws RestClientException {
        postExperimentByIdWithHttpInfo(id, body);
    }

    /**
     * Duplicate an experiment with its ID
     * 
     * <p><b>201</b> - The experiment has been duplicated.
     * @param id The unique identifier of the experiment to duplicate. (required)
     * @param body Parameters for duplicating an experiment (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> postExperimentByIdWithHttpInfo(Integer id, ExperimentsIdBody body) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling postExperimentById");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/experiments/{id}").buildAndExpand(uriVariables).toUriString();
        
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
     * Read all experiments that are accessible
     * 
     * <p><b>200</b> - A list of experiments
     * @param q Search for a term in title, body or elabid.  (optional)
     * @param extended Extended search (advanced query).  (optional)
     * @param related Look only for entries linked to this item id.  (optional)
     * @param relatedOrigin When using the \&quot;related\&quot; query parameter, select the type of the related ID (experiments or items)  (optional)
     * @param cat The status id of the experiments.  (optional)
     * @param tags An array of tags for filtering results containing all of these tags.  (optional)
     * @param limit Limit the number of results.  (optional, default to 15)
     * @param offset Skip a number of results. Use with limit to work the pagination.  (optional, default to 0)
     * @param owner Filter results by author (user id)  (optional)
     * @param scope Set the scope for the results. 1: self, 2: team, 3: everything. It defaults to the user value stored in preferences.  (optional)
     * @param order Change the ordering of the results.  (optional)
     * @param sort Change the sorting of results: ascending or descending.  (optional)
     * @return List&lt;Experiment&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Experiment> readExperiments(String q, String extended, Integer related, String relatedOrigin, Integer cat, List<String> tags, Integer limit, Integer offset, Integer owner, Integer scope, String order, String sort) throws RestClientException {
        return readExperimentsWithHttpInfo(q, extended, related, relatedOrigin, cat, tags, limit, offset, owner, scope, order, sort).getBody();
    }

    /**
     * Read all experiments that are accessible
     * 
     * <p><b>200</b> - A list of experiments
     * @param q Search for a term in title, body or elabid.  (optional)
     * @param extended Extended search (advanced query).  (optional)
     * @param related Look only for entries linked to this item id.  (optional)
     * @param relatedOrigin When using the \&quot;related\&quot; query parameter, select the type of the related ID (experiments or items)  (optional)
     * @param cat The status id of the experiments.  (optional)
     * @param tags An array of tags for filtering results containing all of these tags.  (optional)
     * @param limit Limit the number of results.  (optional, default to 15)
     * @param offset Skip a number of results. Use with limit to work the pagination.  (optional, default to 0)
     * @param owner Filter results by author (user id)  (optional)
     * @param scope Set the scope for the results. 1: self, 2: team, 3: everything. It defaults to the user value stored in preferences.  (optional)
     * @param order Change the ordering of the results.  (optional)
     * @param sort Change the sorting of results: ascending or descending.  (optional)
     * @return ResponseEntity&lt;List&lt;Experiment&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Experiment>> readExperimentsWithHttpInfo(String q, String extended, Integer related, String relatedOrigin, Integer cat, List<String> tags, Integer limit, Integer offset, Integer owner, Integer scope, String order, String sort) throws RestClientException {
        Object postBody = null;
        String path = UriComponentsBuilder.fromPath("/experiments").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "q", q));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "extended", extended));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "related", related));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "related_origin", relatedOrigin));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "cat", cat));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase()), "tags[]", tags));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "owner", owner));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "scope", scope));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "order", order));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort", sort));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "token" };

        ParameterizedTypeReference<List<Experiment>> returnType = new ParameterizedTypeReference<List<Experiment>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }

    /**
     * Creates an experiment using a cURL command.
     *
     * @param apiKey The API key for authorization.
     * @param url The base URL of the API.
     * @param title The title of the experiment.
     * @param body The body content of the experiment.
     * @throws RestClientException if an error occurs while attempting to invoke the API.
     */
    public Integer createExperimentCURL(String apiKey, String url, String title) throws RestClientException {
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
                curl -v --request POST '%s/experiments/' \\
                --header 'Authorization: %s' \\
                --header 'Content-Type: application/json' \\
                --data '{
                    "title": "%s"
                }'
            """;

            String command = String.format(commandTemplate, url, apiKey, title);
            ProcessBuilder processBuilder = new ProcessBuilder("/bin/sh", "-c", command);
            processBuilder.directory(new File("/home"));
            Process process = processBuilder.start();
            InputStream inputStream = process.getInputStream();

            // Read the error stream from the command
            InputStream errorStream = process.getErrorStream();
            String errorResult = new BufferedReader(new InputStreamReader(errorStream, StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n"));
            int exitCode = process.waitFor();

            return extractId(errorResult);
        } catch (Exception e) {
            throw new RestClientException("Undefined error while creating an experiment: " + e.getMessage());
        }
    }

    /**
     * Extracts the ID from the input string.
     *
     * @param input The input string containing the ID.
     * @return The extracted ID, or null if not found.
     */
    private Integer extractId(String input) {
        // Define the regex pattern to match the ID after the last /
        Pattern pattern = Pattern.compile("location: https://.*/(\\d+)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return Integer.valueOf(matcher.group(1));
        } else {
            return null;
        }
    }

    /**
     * Modifies an experiment using a cURL command.
     *
     * @param apiKey The API key for authorization.
     * @param url The base URL of the API.
     * @param id The ID of the experiment to modify.
     * @param title The new title of the experiment.
     * @param body The new body content of the experiment.
     * @throws RestClientException if an error occurs while attempting to invoke the API.
     */
    public void modifyExperimentCURL(String apiKey, String url, Integer id, String title, String body) throws RestClientException {
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
                curl -v --request PATCH '%s/experiments/%d' \\
                --header 'Authorization: %s' \\
                --header 'action: update' \\
                --header 'Content-Type: application/json' \\
                --data '{
                    "body": "%s",
                    "title": "%s"
                }'
            """;

            String command = String.format(commandTemplate, url, id, apiKey, body, title);
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
