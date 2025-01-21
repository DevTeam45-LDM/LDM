# NotificationsApi

All URIs are relative to *https://elab.local:3148/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteNotifications**](NotificationsApi.md#deleteNotifications) | **DELETE** /users/{id}/notifications | Delete all notifications of the user.
[**patchNotification**](NotificationsApi.md#patchNotification) | **PATCH** /users/{id}/notifications/{subid} | Actions on a notification. Only changing &#x60;is_ack&#x60; column is possible. 
[**readNotification**](NotificationsApi.md#readNotification) | **GET** /users/{id}/notifications/{subid} | Read a notification.
[**readNotifications**](NotificationsApi.md#readNotifications) | **GET** /users/{id}/notifications | Read notifications of a user.

<a name="deleteNotifications"></a>
# **deleteNotifications**
> deleteNotifications(id)

Delete all notifications of the user.

All notifications for the user are deleted.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.NotificationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

NotificationsApi apiInstance = new NotificationsApi();
Id3 id = new Id3(); // Id3 | ID of the user or `me`.
try {
    apiInstance.deleteNotifications(id);
} catch (ApiException e) {
    System.err.println("Exception when calling NotificationsApi#deleteNotifications");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | [**Id3**](.md)| ID of the user or &#x60;me&#x60;. |

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="patchNotification"></a>
# **patchNotification**
> Notification patchNotification(id, subid)

Actions on a notification. Only changing &#x60;is_ack&#x60; column is possible. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.NotificationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

NotificationsApi apiInstance = new NotificationsApi();
Id4 id = new Id4(); // Id4 | ID of the user or `me`.
Integer subid = 56; // Integer | ID of the notification.
try {
    Notification result = apiInstance.patchNotification(id, subid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotificationsApi#patchNotification");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | [**Id4**](.md)| ID of the user or &#x60;me&#x60;. |
 **subid** | **Integer**| ID of the notification. |

### Return type

[**Notification**](Notification.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="readNotification"></a>
# **readNotification**
> Notification readNotification(id, subid)

Read a notification.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.NotificationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

NotificationsApi apiInstance = new NotificationsApi();
Id4 id = new Id4(); // Id4 | ID of the user or `me`.
Integer subid = 56; // Integer | ID of the notification.
try {
    Notification result = apiInstance.readNotification(id, subid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotificationsApi#readNotification");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | [**Id4**](.md)| ID of the user or &#x60;me&#x60;. |
 **subid** | **Integer**| ID of the notification. |

### Return type

[**Notification**](Notification.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="readNotifications"></a>
# **readNotifications**
> InlineResponse2008 readNotifications(id)

Read notifications of a user.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.NotificationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

NotificationsApi apiInstance = new NotificationsApi();
Id3 id = new Id3(); // Id3 | ID of the user or `me`.
try {
    InlineResponse2008 result = apiInstance.readNotifications(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotificationsApi#readNotifications");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | [**Id3**](.md)| ID of the user or &#x60;me&#x60;. |

### Return type

[**InlineResponse2008**](InlineResponse2008.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

