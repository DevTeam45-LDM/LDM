# ImportApi

All URIs are relative to *https://elab.local:3148/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**postImport**](ImportApi.md#postImport) | **POST** /import | Send a file to import
[**readImport**](ImportApi.md#readImport) | **GET** /import | Get information about this endpoint

<a name="postImport"></a>
# **postImport**
> postImport(file, entityType, category, canread, canwrite)

Send a file to import

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ImportApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ImportApi apiInstance = new ImportApi();
File file = new File("file_example"); // File | 
String entityType = "entityType_example"; // String | 
Integer category = 56; // Integer | 
String canread = "canread_example"; // String | 
String canwrite = "canwrite_example"; // String | 
try {
    apiInstance.postImport(file, entityType, category, canread, canwrite);
} catch (ApiException e) {
    System.err.println("Exception when calling ImportApi#postImport");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **file** | **File**|  | [optional]
 **entityType** | **String**|  | [optional] [enum: experiments, items, experiments_templates, items_types]
 **category** | **Integer**|  | [optional]
 **canread** | **String**|  | [optional]
 **canwrite** | **String**|  | [optional]

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: Not defined

<a name="readImport"></a>
# **readImport**
> InlineResponse2001 readImport()

Get information about this endpoint

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ImportApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ImportApi apiInstance = new ImportApi();
try {
    InlineResponse2001 result = apiInstance.readImport();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ImportApi#readImport");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

