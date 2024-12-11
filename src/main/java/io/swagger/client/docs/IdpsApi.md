# IdpsApi

All URIs are relative to *https://elab.local:3148/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteIdp**](IdpsApi.md#deleteIdp) | **DELETE** /idps/{id} | Delete an idp.
[**patchIdp**](IdpsApi.md#patchIdp) | **PATCH** /idps/{id} | Actions on an idp.
[**postIdp**](IdpsApi.md#postIdp) | **POST** /idps | Create an idp.
[**readIdp**](IdpsApi.md#readIdp) | **GET** /idps/{id} | Read an idp.
[**readIdps**](IdpsApi.md#readIdps) | **GET** /idps | Read all IDPs.

<a name="deleteIdp"></a>
# **deleteIdp**
> deleteIdp(id)

Delete an idp.

The idp gets deleted.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IdpsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

IdpsApi apiInstance = new IdpsApi();
Integer id = 56; // Integer | ID of the idp
try {
    apiInstance.deleteIdp(id);
} catch (ApiException e) {
    System.err.println("Exception when calling IdpsApi#deleteIdp");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the idp |

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="patchIdp"></a>
# **patchIdp**
> Idp patchIdp(id, body)

Actions on an idp.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IdpsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

IdpsApi apiInstance = new IdpsApi();
Integer id = 56; // Integer | ID of the idp
IdpsIdBody body = new IdpsIdBody(); // IdpsIdBody | Parameters for modifying an idp.
try {
    Idp result = apiInstance.patchIdp(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IdpsApi#patchIdp");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the idp |
 **body** | [**IdpsIdBody**](IdpsIdBody.md)| Parameters for modifying an idp. | [optional]

### Return type

[**Idp**](Idp.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postIdp"></a>
# **postIdp**
> postIdp(body)

Create an idp.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IdpsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

IdpsApi apiInstance = new IdpsApi();
IdpsBody body = new IdpsBody(); // IdpsBody | Parameters for creating an idp.
try {
    apiInstance.postIdp(body);
} catch (ApiException e) {
    System.err.println("Exception when calling IdpsApi#postIdp");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**IdpsBody**](IdpsBody.md)| Parameters for creating an idp. | [optional]

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="readIdp"></a>
# **readIdp**
> Idp readIdp(id)

Read an idp.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IdpsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

IdpsApi apiInstance = new IdpsApi();
Integer id = 56; // Integer | ID of the idp
try {
    Idp result = apiInstance.readIdp(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IdpsApi#readIdp");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the idp |

### Return type

[**Idp**](Idp.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="readIdps"></a>
# **readIdps**
> List&lt;Idp&gt; readIdps()

Read all IDPs.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IdpsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

IdpsApi apiInstance = new IdpsApi();
try {
    List<Idp> result = apiInstance.readIdps();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IdpsApi#readIdps");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Idp&gt;**](Idp.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

