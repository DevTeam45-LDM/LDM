# EventsApi

All URIs are relative to *https://elab.local:3148/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteEvent**](EventsApi.md#deleteEvent) | **DELETE** /event/{id} | Delete a booking slot.
[**patchEvent**](EventsApi.md#patchEvent) | **PATCH** /event/{id} | Modify a booking slot. Warning: only one value (target) can be edited at a time. 
[**postEvents**](EventsApi.md#postEvents) | **POST** /events/{id} | Create an event for the item specified as id.
[**readEvent**](EventsApi.md#readEvent) | **GET** /event/{id} | Read a booking slot.
[**readEvents**](EventsApi.md#readEvents) | **GET** /events | Read all events in the team.

<a name="deleteEvent"></a>
# **deleteEvent**
> deleteEvent(id)

Delete a booking slot.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.EventsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

EventsApi apiInstance = new EventsApi();
Integer id = 56; // Integer | ID of the event to modify.
try {
    apiInstance.deleteEvent(id);
} catch (ApiException e) {
    System.err.println("Exception when calling EventsApi#deleteEvent");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the event to modify. |

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="patchEvent"></a>
# **patchEvent**
> Event patchEvent(id, body)

Modify a booking slot. Warning: only one value (target) can be edited at a time. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.EventsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

EventsApi apiInstance = new EventsApi();
Integer id = 56; // Integer | ID of the event to modify.
EventIdBody body = new EventIdBody(); // EventIdBody | Parameters for modifying an event.
try {
    Event result = apiInstance.patchEvent(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EventsApi#patchEvent");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the event to modify. |
 **body** | [**EventIdBody**](EventIdBody.md)| Parameters for modifying an event. | [optional]

### Return type

[**Event**](Event.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postEvents"></a>
# **postEvents**
> postEvents(id, body)

Create an event for the item specified as id.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.EventsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

EventsApi apiInstance = new EventsApi();
Integer id = 56; // Integer | ID of the item to book.
EventsIdBody body = new EventsIdBody(); // EventsIdBody | Parameters for creating an event.
try {
    apiInstance.postEvents(id, body);
} catch (ApiException e) {
    System.err.println("Exception when calling EventsApi#postEvents");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the item to book. |
 **body** | [**EventsIdBody**](EventsIdBody.md)| Parameters for creating an event. | [optional]

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="readEvent"></a>
# **readEvent**
> Event readEvent(id)

Read a booking slot.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.EventsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

EventsApi apiInstance = new EventsApi();
Integer id = 56; // Integer | ID of the event to modify.
try {
    Event result = apiInstance.readEvent(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EventsApi#readEvent");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the event to modify. |

### Return type

[**Event**](Event.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="readEvents"></a>
# **readEvents**
> List&lt;Event&gt; readEvents()

Read all events in the team.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.EventsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

EventsApi apiInstance = new EventsApi();
try {
    List<Event> result = apiInstance.readEvents();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EventsApi#readEvents");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Event&gt;**](Event.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

