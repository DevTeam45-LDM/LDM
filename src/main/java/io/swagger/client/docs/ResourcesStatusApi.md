# ResourcesStatusApi

All URIs are relative to *https://elab.local:3148/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteResstatus**](ResourcesStatusApi.md#deleteResstatus) | **DELETE** /teams/{id}/items_status/{subid} | Delete a status.
[**patchResstatus**](ResourcesStatusApi.md#patchResstatus) | **PATCH** /teams/{id}/items_status/{subid} | Modify a status.
[**postTeamOneResstat**](ResourcesStatusApi.md#postTeamOneResstat) | **POST** /teams/{id}/items_status | Create a new status for resources.
[**readTeamItemsStatus**](ResourcesStatusApi.md#readTeamItemsStatus) | **GET** /teams/{id}/items_status | Read resources status of a team.
[**readTeamOneResstatus**](ResourcesStatusApi.md#readTeamOneResstatus) | **GET** /teams/{id}/items_status/{subid} | Read a status.

<a name="deleteResstatus"></a>
# **deleteResstatus**
> deleteResstatus(id, subid)

Delete a status.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ResourcesStatusApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ResourcesStatusApi apiInstance = new ResourcesStatusApi();
Integer id = 56; // Integer | ID of the team.
Integer subid = 56; // Integer | ID of the status
try {
    apiInstance.deleteResstatus(id, subid);
} catch (ApiException e) {
    System.err.println("Exception when calling ResourcesStatusApi#deleteResstatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the team. |
 **subid** | **Integer**| ID of the status |

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="patchResstatus"></a>
# **patchResstatus**
> Statuslike patchResstatus(id, subid, body)

Modify a status.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ResourcesStatusApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ResourcesStatusApi apiInstance = new ResourcesStatusApi();
Integer id = 56; // Integer | ID of the team.
Integer subid = 56; // Integer | ID of the status
Statuslike body = new Statuslike(); // Statuslike | Parameters for modifying a status.
try {
    Statuslike result = apiInstance.patchResstatus(id, subid, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ResourcesStatusApi#patchResstatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the team. |
 **subid** | **Integer**| ID of the status |
 **body** | [**Statuslike**](Statuslike.md)| Parameters for modifying a status. | [optional]

### Return type

[**Statuslike**](Statuslike.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postTeamOneResstat"></a>
# **postTeamOneResstat**
> postTeamOneResstat(id, body)

Create a new status for resources.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ResourcesStatusApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ResourcesStatusApi apiInstance = new ResourcesStatusApi();
Integer id = 56; // Integer | ID of the team.
IdItemsStatusBody body = new IdItemsStatusBody(); // IdItemsStatusBody | Parameters for creating a resources status.
try {
    apiInstance.postTeamOneResstat(id, body);
} catch (ApiException e) {
    System.err.println("Exception when calling ResourcesStatusApi#postTeamOneResstat");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the team. |
 **body** | [**IdItemsStatusBody**](IdItemsStatusBody.md)| Parameters for creating a resources status. | [optional]

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="readTeamItemsStatus"></a>
# **readTeamItemsStatus**
> List&lt;Statuslike&gt; readTeamItemsStatus(id)

Read resources status of a team.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ResourcesStatusApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ResourcesStatusApi apiInstance = new ResourcesStatusApi();
Integer id = 56; // Integer | ID of the team.
try {
    List<Statuslike> result = apiInstance.readTeamItemsStatus(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ResourcesStatusApi#readTeamItemsStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the team. |

### Return type

[**List&lt;Statuslike&gt;**](Statuslike.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="readTeamOneResstatus"></a>
# **readTeamOneResstatus**
> Statuslike readTeamOneResstatus(id, subid)

Read a status.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ResourcesStatusApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ResourcesStatusApi apiInstance = new ResourcesStatusApi();
Integer id = 56; // Integer | ID of the team.
Integer subid = 56; // Integer | ID of the status
try {
    Statuslike result = apiInstance.readTeamOneResstatus(id, subid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ResourcesStatusApi#readTeamOneResstatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the team. |
 **subid** | **Integer**| ID of the status |

### Return type

[**Statuslike**](Statuslike.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

