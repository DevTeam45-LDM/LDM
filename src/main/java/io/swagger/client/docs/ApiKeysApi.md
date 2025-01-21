# ApiKeysApi

All URIs are relative to *https://elab.local:3148/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteApikey**](ApiKeysApi.md#deleteApikey) | **DELETE** /apikeys/{id} | Delete an API key.
[**getApikeys**](ApiKeysApi.md#getApikeys) | **GET** /apikeys | Read API keys
[**postApikeys**](ApiKeysApi.md#postApikeys) | **POST** /apikeys | Create an API key

<a name="deleteApikey"></a>
# **deleteApikey**
> deleteApikey(id)

Delete an API key.

Delete an API key

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ApiKeysApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ApiKeysApi apiInstance = new ApiKeysApi();
Integer id = 56; // Integer | ID of the API key
try {
    apiInstance.deleteApikey(id);
} catch (ApiException e) {
    System.err.println("Exception when calling ApiKeysApi#deleteApikey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the API key |

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="getApikeys"></a>
# **getApikeys**
> List&lt;Apikey&gt; getApikeys()

Read API keys

Get list of API keys for currently logged in user.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ApiKeysApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ApiKeysApi apiInstance = new ApiKeysApi();
try {
    List<Apikey> result = apiInstance.getApikeys();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ApiKeysApi#getApikeys");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Apikey&gt;**](Apikey.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="postApikeys"></a>
# **postApikeys**
> postApikeys(body)

Create an API key

Create an API key. The cleartext key is sent back in the location header. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ApiKeysApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ApiKeysApi apiInstance = new ApiKeysApi();
ApikeysBody body = new ApikeysBody(); // ApikeysBody | 
try {
    apiInstance.postApikeys(body);
} catch (ApiException e) {
    System.err.println("Exception when calling ApiKeysApi#postApikeys");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ApikeysBody**](ApikeysBody.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

