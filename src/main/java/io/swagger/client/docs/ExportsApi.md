# ExportsApi

All URIs are relative to *https://elab.local:3148/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteExport**](ExportsApi.md#deleteExport) | **DELETE** /exports/{id} | Remove an export request and its associated file
[**postExport**](ExportsApi.md#postExport) | **POST** /exports | Register an export request
[**readExport**](ExportsApi.md#readExport) | **GET** /exports/{id} | Get export
[**readallExports**](ExportsApi.md#readallExports) | **GET** /exports | List exports

<a name="deleteExport"></a>
# **deleteExport**
> deleteExport(id)

Remove an export request and its associated file

This method will remove the file from the server temporary storage and clear the export request.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ExportsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ExportsApi apiInstance = new ExportsApi();
Integer id = 56; // Integer | ID of the export request
try {
    apiInstance.deleteExport(id);
} catch (ApiException e) {
    System.err.println("Exception when calling ExportsApi#deleteExport");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the export request |

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="postExport"></a>
# **postExport**
> postExport(body)

Register an export request

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ExportsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ExportsApi apiInstance = new ExportsApi();
ExportsBody body = new ExportsBody(); // ExportsBody | 
try {
    apiInstance.postExport(body);
} catch (ApiException e) {
    System.err.println("Exception when calling ExportsApi#postExport");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ExportsBody**](ExportsBody.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="readExport"></a>
# **readExport**
> List&lt;Export&gt; readExport(id)

Get export

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ExportsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ExportsApi apiInstance = new ExportsApi();
Integer id = 56; // Integer | ID of the export request
try {
    List<Export> result = apiInstance.readExport(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExportsApi#readExport");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the export request |

### Return type

[**List&lt;Export&gt;**](Export.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="readallExports"></a>
# **readallExports**
> List&lt;Export&gt; readallExports()

List exports

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ExportsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ExportsApi apiInstance = new ExportsApi();
try {
    List<Export> result = apiInstance.readallExports();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExportsApi#readallExports");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Export&gt;**](Export.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

