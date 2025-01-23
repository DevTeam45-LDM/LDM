package io.swagger.client.api;

import io.swagger.client.ApiClient;

import io.swagger.client.model.Id3;
import io.swagger.client.model.Id4;
import io.swagger.client.model.InlineResponse2008;
import io.swagger.client.model.Notification;

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
@Component("io.swagger.client.api.NotificationsApi")
public class NotificationsApi {
    private ApiClient apiClient;

    public NotificationsApi() {
        this(new ApiClient());
    }

    @Autowired
    public NotificationsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete all notifications of the user.
     * All notifications for the user are deleted.
     * <p><b>204</b> - The notifications were deleted.
     * @param id ID of the user or &#x60;me&#x60;. (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteNotifications(Id3 id) throws RestClientException {
        deleteNotificationsWithHttpInfo(id);
    }

    /**
     * Delete all notifications of the user.
     * All notifications for the user are deleted.
     * <p><b>204</b> - The notifications were deleted.
     * @param id ID of the user or &#x60;me&#x60;. (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteNotificationsWithHttpInfo(Id3 id) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteNotifications");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/users/{id}/notifications").buildAndExpand(uriVariables).toUriString();
        
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
     * Actions on a notification. Only changing &#x60;is_ack&#x60; column is possible. 
     * 
     * <p><b>200</b> - The updated notification.
     * @param id ID of the user or &#x60;me&#x60;. (required)
     * @param subid ID of the notification. (required)
     * @return Notification
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Notification patchNotification(Id4 id, Integer subid) throws RestClientException {
        return patchNotificationWithHttpInfo(id, subid).getBody();
    }

    /**
     * Actions on a notification. Only changing &#x60;is_ack&#x60; column is possible. 
     * 
     * <p><b>200</b> - The updated notification.
     * @param id ID of the user or &#x60;me&#x60;. (required)
     * @param subid ID of the notification. (required)
     * @return ResponseEntity&lt;Notification&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Notification> patchNotificationWithHttpInfo(Id4 id, Integer subid) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling patchNotification");
        }
        // verify the required parameter 'subid' is set
        if (subid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subid' when calling patchNotification");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("subid", subid);
        String path = UriComponentsBuilder.fromPath("/users/{id}/notifications/{subid}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<Notification> returnType = new ParameterizedTypeReference<Notification>() {};
        return apiClient.invokeAPI(path, HttpMethod.PATCH, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Read a notification.
     * 
     * <p><b>200</b> - A notification.
     * @param id ID of the user or &#x60;me&#x60;. (required)
     * @param subid ID of the notification. (required)
     * @return Notification
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Notification readNotification(Id4 id, Integer subid) throws RestClientException {
        return readNotificationWithHttpInfo(id, subid).getBody();
    }

    /**
     * Read a notification.
     * 
     * <p><b>200</b> - A notification.
     * @param id ID of the user or &#x60;me&#x60;. (required)
     * @param subid ID of the notification. (required)
     * @return ResponseEntity&lt;Notification&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Notification> readNotificationWithHttpInfo(Id4 id, Integer subid) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling readNotification");
        }
        // verify the required parameter 'subid' is set
        if (subid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subid' when calling readNotification");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("subid", subid);
        String path = UriComponentsBuilder.fromPath("/users/{id}/notifications/{subid}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<Notification> returnType = new ParameterizedTypeReference<Notification>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Read notifications of a user.
     * 
     * <p><b>200</b> - Notifications of a user.
     * @param id ID of the user or &#x60;me&#x60;. (required)
     * @return InlineResponse2008
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public InlineResponse2008 readNotifications(Id3 id) throws RestClientException {
        return readNotificationsWithHttpInfo(id).getBody();
    }

    /**
     * Read notifications of a user.
     * 
     * <p><b>200</b> - Notifications of a user.
     * @param id ID of the user or &#x60;me&#x60;. (required)
     * @return ResponseEntity&lt;InlineResponse2008&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<InlineResponse2008> readNotificationsWithHttpInfo(Id3 id) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling readNotifications");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/users/{id}/notifications").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<InlineResponse2008> returnType = new ParameterizedTypeReference<InlineResponse2008>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
