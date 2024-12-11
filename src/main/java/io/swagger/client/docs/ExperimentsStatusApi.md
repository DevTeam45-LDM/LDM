# ExperimentsStatusApi

All URIs are relative to *https://elab.local:3148/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteExpstatus**](ExperimentsStatusApi.md#deleteExpstatus) | **DELETE** /teams/{id}/experiments_status/{subid} | Delete a status.
[**patchExpstatus**](ExperimentsStatusApi.md#patchExpstatus) | **PATCH** /teams/{id}/experiments_status/{subid} | Modify a status.
[**postTeamOneExpstatus**](ExperimentsStatusApi.md#postTeamOneExpstatus) | **POST** /teams/{id}/experiments_status | Create a new experiments status.
[**readTeamExperimentsStatus**](ExperimentsStatusApi.md#readTeamExperimentsStatus) | **GET** /teams/{id}/experiments_status | Read experiments status of a team.
[**readTeamOneExpstatus**](ExperimentsStatusApi.md#readTeamOneExpstatus) | **GET** /teams/{id}/experiments_status/{subid} | Read a status.

<a name="deleteExpstatus"></a>
# **deleteExpstatus**
> deleteExpstatus(id, subid)

Delete a status.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ExperimentsStatusApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ExperimentsStatusApi apiInstance = new ExperimentsStatusApi();
Integer id = 56; // Integer | ID of the team.
Integer subid = 56; // Integer | ID of the status
try {
    apiInstance.deleteExpstatus(id, subid);
} catch (ApiException e) {
    System.err.println("Exception when calling ExperimentsStatusApi#deleteExpstatus");
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

<a name="patchExpstatus"></a>
# **patchExpstatus**
> Statuslike patchExpstatus(id, subid, body)

Modify a status.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ExperimentsStatusApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ExperimentsStatusApi apiInstance = new ExperimentsStatusApi();
Integer id = 56; // Integer | ID of the team.
Integer subid = 56; // Integer | ID of the status
Statuslike body = new Statuslike(); // Statuslike | Parameters for modifying a status.
try {
    Statuslike result = apiInstance.patchExpstatus(id, subid, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExperimentsStatusApi#patchExpstatus");
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

<a name="postTeamOneExpstatus"></a>
# **postTeamOneExpstatus**
> postTeamOneExpstatus(id, body)

Create a new experiments status.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ExperimentsStatusApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ExperimentsStatusApi apiInstance = new ExperimentsStatusApi();
Integer id = 56; // Integer | ID of the team.
IdExperimentsStatusBody body = new IdExperimentsStatusBody(); // IdExperimentsStatusBody | Parameters for creating a status.
try {
    apiInstance.postTeamOneExpstatus(id, body);
} catch (ApiException e) {
    System.err.println("Exception when calling ExperimentsStatusApi#postTeamOneExpstatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the team. |
 **body** | [**IdExperimentsStatusBody**](IdExperimentsStatusBody.md)| Parameters for creating a status. | [optional]

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="readTeamExperimentsStatus"></a>
# **readTeamExperimentsStatus**
> List&lt;Statuslike&gt; readTeamExperimentsStatus(id)

Read experiments status of a team.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ExperimentsStatusApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ExperimentsStatusApi apiInstance = new ExperimentsStatusApi();
Integer id = 56; // Integer | ID of the team.
try {
    List<Statuslike> result = apiInstance.readTeamExperimentsStatus(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExperimentsStatusApi#readTeamExperimentsStatus");
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

<a name="readTeamOneExpstatus"></a>
# **readTeamOneExpstatus**
> Statuslike readTeamOneExpstatus(id, subid)

Read a status.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ExperimentsStatusApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ExperimentsStatusApi apiInstance = new ExperimentsStatusApi();
Integer id = 56; // Integer | ID of the team.
Integer subid = 56; // Integer | ID of the status
try {
    Statuslike result = apiInstance.readTeamOneExpstatus(id, subid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExperimentsStatusApi#readTeamOneExpstatus");
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

