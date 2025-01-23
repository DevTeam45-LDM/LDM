package io.swagger.client.api;

import io.swagger.client.ApiClient;

import java.io.File;
import io.swagger.client.model.Upload;
import io.swagger.client.model.UploadsSubidBody1;

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
@Component("io.swagger.client.api.UploadsApi")
public class UploadsApi {
    private ApiClient apiClient;

    public UploadsApi() {
        this(new ApiClient());
    }

    @Autowired
    public UploadsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete an upload.
     * The upload gets deleted.
     * <p><b>204</b> - The upload was deleted.
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param subid ID of the upload (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteUpload(String entityType, Integer id, Integer subid) throws RestClientException {
        deleteUploadWithHttpInfo(entityType, id, subid);
    }

    /**
     * Delete an upload.
     * The upload gets deleted.
     * <p><b>204</b> - The upload was deleted.
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param subid ID of the upload (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteUploadWithHttpInfo(String entityType, Integer id, Integer subid) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'entityType' is set
        if (entityType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'entityType' when calling deleteUpload");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteUpload");
        }
        // verify the required parameter 'subid' is set
        if (subid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subid' when calling deleteUpload");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("entity_type", entityType);
        uriVariables.put("id", id);
        uriVariables.put("subid", subid);
        String path = UriComponentsBuilder.fromPath("/{entity_type}/{id}/uploads/{subid}").buildAndExpand(uriVariables).toUriString();
        
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
     * Modify attributes such as \&quot;real_name\&quot;, \&quot;comment\&quot; or \&quot;state\&quot; of an upload. 
     * 
     * <p><b>200</b> - The updated upload.
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param subid ID of the upload (required)
     * @param body Parameters for modifying an upload attributes. (optional)
     * @return Upload
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Upload patchUpload(String entityType, Integer id, Integer subid, UploadsSubidBody1 body) throws RestClientException {
        return patchUploadWithHttpInfo(entityType, id, subid, body).getBody();
    }

    /**
     * Modify attributes such as \&quot;real_name\&quot;, \&quot;comment\&quot; or \&quot;state\&quot; of an upload. 
     * 
     * <p><b>200</b> - The updated upload.
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param subid ID of the upload (required)
     * @param body Parameters for modifying an upload attributes. (optional)
     * @return ResponseEntity&lt;Upload&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Upload> patchUploadWithHttpInfo(String entityType, Integer id, Integer subid, UploadsSubidBody1 body) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'entityType' is set
        if (entityType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'entityType' when calling patchUpload");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling patchUpload");
        }
        // verify the required parameter 'subid' is set
        if (subid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subid' when calling patchUpload");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("entity_type", entityType);
        uriVariables.put("id", id);
        uriVariables.put("subid", subid);
        String path = UriComponentsBuilder.fromPath("/{entity_type}/{id}/uploads/{subid}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<Upload> returnType = new ParameterizedTypeReference<Upload>() {};
        return apiClient.invokeAPI(path, HttpMethod.PATCH, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Create an upload.
     * 
     * <p><b>201</b> - The file has been uploaded.
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param file  (optional)
     * @param comment  (optional)
     * @param archived Include archived uploads in the response if the value is truthy. (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void postUpload(String entityType, Integer id, File file, String comment, String archived) throws RestClientException {
        postUploadWithHttpInfo(entityType, id, file, comment, archived);
    }

    /**
     * Create an upload.
     * 
     * <p><b>201</b> - The file has been uploaded.
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param file  (optional)
     * @param comment  (optional)
     * @param archived Include archived uploads in the response if the value is truthy. (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> postUploadWithHttpInfo(String entityType, Integer id, File file, String comment, String archived) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'entityType' is set
        if (entityType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'entityType' when calling postUpload");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling postUpload");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("entity_type", entityType);
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/{entity_type}/{id}/uploads").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "archived", archived));
        if (file != null)
            formParams.add("file", new FileSystemResource(file));
        if (comment != null)
            formParams.add("comment", comment);

        final String[] accepts = {  };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "multipart/form-data"
         };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "token" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Replace an existing uploaded file. The existing file will be archived and the new one will be added.
     * 
     * <p><b>201</b> - The file has been uploaded.
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param subid ID of the upload (required)
     * @param file  (optional)
     * @param comment  (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void postUploadReplace(String entityType, Integer id, Integer subid, File file, String comment) throws RestClientException {
        postUploadReplaceWithHttpInfo(entityType, id, subid, file, comment);
    }

    /**
     * Replace an existing uploaded file. The existing file will be archived and the new one will be added.
     * 
     * <p><b>201</b> - The file has been uploaded.
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param subid ID of the upload (required)
     * @param file  (optional)
     * @param comment  (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> postUploadReplaceWithHttpInfo(String entityType, Integer id, Integer subid, File file, String comment) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'entityType' is set
        if (entityType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'entityType' when calling postUploadReplace");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling postUploadReplace");
        }
        // verify the required parameter 'subid' is set
        if (subid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subid' when calling postUploadReplace");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("entity_type", entityType);
        uriVariables.put("id", id);
        uriVariables.put("subid", subid);
        String path = UriComponentsBuilder.fromPath("/{entity_type}/{id}/uploads/{subid}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (file != null)
            formParams.add("file", new FileSystemResource(file));
        if (comment != null)
            formParams.add("comment", comment);

        final String[] accepts = {  };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "multipart/form-data"
         };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "token" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Read an upload.
     * 
     * <p><b>200</b> - An upload. Note: with binary output, Content-Type header will vary depending of the file type being sent. 
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param subid ID of the upload (required)
     * @param format To download the file itself, use &#x60;binary&#x60; format parameter. In python library, when downloading a file content, make sure to add &#x60; _preload_content&#x3D;False&#x60; into the call to &#x60;read_upload()&#x60;.  (optional, default to json)
     * @return Upload
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Upload readUpload(String entityType, Integer id, Integer subid, String format) throws RestClientException {
        return readUploadWithHttpInfo(entityType, id, subid, format).getBody();
    }

    /**
     * Read an upload.
     * 
     * <p><b>200</b> - An upload. Note: with binary output, Content-Type header will vary depending of the file type being sent. 
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param subid ID of the upload (required)
     * @param format To download the file itself, use &#x60;binary&#x60; format parameter. In python library, when downloading a file content, make sure to add &#x60; _preload_content&#x3D;False&#x60; into the call to &#x60;read_upload()&#x60;.  (optional, default to json)
     * @return ResponseEntity&lt;Upload&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Upload> readUploadWithHttpInfo(String entityType, Integer id, Integer subid, String format) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'entityType' is set
        if (entityType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'entityType' when calling readUpload");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling readUpload");
        }
        // verify the required parameter 'subid' is set
        if (subid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subid' when calling readUpload");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("entity_type", entityType);
        uriVariables.put("id", id);
        uriVariables.put("subid", subid);
        String path = UriComponentsBuilder.fromPath("/{entity_type}/{id}/uploads/{subid}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "format", format));

        final String[] accepts = { 
            "application/json", "*/*"
         };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "token" };

        ParameterizedTypeReference<Upload> returnType = new ParameterizedTypeReference<Upload>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Read attached files of that entity.
     * 
     * <p><b>200</b> - A list of uploads.
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param archived Include archived uploads in the response if the value is truthy. (optional)
     * @return List&lt;Upload&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Upload> readUploads(String entityType, Integer id, String archived) throws RestClientException {
        return readUploadsWithHttpInfo(entityType, id, archived).getBody();
    }

    /**
     * Read attached files of that entity.
     * 
     * <p><b>200</b> - A list of uploads.
     * @param entityType Entity type (required)
     * @param id ID of the entity (required)
     * @param archived Include archived uploads in the response if the value is truthy. (optional)
     * @return ResponseEntity&lt;List&lt;Upload&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Upload>> readUploadsWithHttpInfo(String entityType, Integer id, String archived) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'entityType' is set
        if (entityType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'entityType' when calling readUploads");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling readUploads");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("entity_type", entityType);
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/{entity_type}/{id}/uploads").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "archived", archived));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "token" };

        ParameterizedTypeReference<List<Upload>> returnType = new ParameterizedTypeReference<List<Upload>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
