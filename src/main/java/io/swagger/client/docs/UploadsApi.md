# UploadsApi

All URIs are relative to *https://elab.local:3148/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteUpload**](UploadsApi.md#deleteUpload) | **DELETE** /{entity_type}/{id}/uploads/{subid} | Delete an upload.
[**patchUpload**](UploadsApi.md#patchUpload) | **PATCH** /{entity_type}/{id}/uploads/{subid} | Modify attributes such as \&quot;real_name\&quot;, \&quot;comment\&quot; or \&quot;state\&quot; of an upload. 
[**postUpload**](UploadsApi.md#postUpload) | **POST** /{entity_type}/{id}/uploads | Create an upload.
[**postUploadReplace**](UploadsApi.md#postUploadReplace) | **POST** /{entity_type}/{id}/uploads/{subid} | Replace an existing uploaded file. The existing file will be archived and the new one will be added.
[**readUpload**](UploadsApi.md#readUpload) | **GET** /{entity_type}/{id}/uploads/{subid} | Read an upload.
[**readUploads**](UploadsApi.md#readUploads) | **GET** /{entity_type}/{id}/uploads | Read attached files of that entity.

<a name="deleteUpload"></a>
# **deleteUpload**
> deleteUpload(entityType, id, subid)

Delete an upload.

The upload gets deleted.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UploadsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

UploadsApi apiInstance = new UploadsApi();
String entityType = "entityType_example"; // String | Entity type
Integer id = 56; // Integer | ID of the entity
Integer subid = 56; // Integer | ID of the upload
try {
    apiInstance.deleteUpload(entityType, id, subid);
} catch (ApiException e) {
    System.err.println("Exception when calling UploadsApi#deleteUpload");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityType** | **String**| Entity type | [enum: experiments, items]
 **id** | **Integer**| ID of the entity |
 **subid** | **Integer**| ID of the upload |

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="patchUpload"></a>
# **patchUpload**
> Upload patchUpload(entityType, id, subid, body)

Modify attributes such as \&quot;real_name\&quot;, \&quot;comment\&quot; or \&quot;state\&quot; of an upload. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UploadsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

UploadsApi apiInstance = new UploadsApi();
String entityType = "entityType_example"; // String | Entity type
Integer id = 56; // Integer | ID of the entity
Integer subid = 56; // Integer | ID of the upload
UploadsSubidBody1 body = new UploadsSubidBody1(); // UploadsSubidBody1 | Parameters for modifying an upload attributes.
try {
    Upload result = apiInstance.patchUpload(entityType, id, subid, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UploadsApi#patchUpload");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityType** | **String**| Entity type | [enum: experiments, items]
 **id** | **Integer**| ID of the entity |
 **subid** | **Integer**| ID of the upload |
 **body** | [**UploadsSubidBody1**](UploadsSubidBody1.md)| Parameters for modifying an upload attributes. | [optional]

### Return type

[**Upload**](Upload.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postUpload"></a>
# **postUpload**
> postUpload(entityType, id, file, comment)

Create an upload.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UploadsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

UploadsApi apiInstance = new UploadsApi();
String entityType = "entityType_example"; // String | Entity type
Integer id = 56; // Integer | ID of the entity
File file = new File("file_example"); // File | 
String comment = "comment_example"; // String | 
try {
    apiInstance.postUpload(entityType, id, file, comment);
} catch (ApiException e) {
    System.err.println("Exception when calling UploadsApi#postUpload");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityType** | **String**| Entity type | [enum: experiments, items]
 **id** | **Integer**| ID of the entity |
 **file** | **File**|  | [optional]
 **comment** | **String**|  | [optional]

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: Not defined

<a name="postUploadReplace"></a>
# **postUploadReplace**
> postUploadReplace(entityType, id, subid, file, comment)

Replace an existing uploaded file. The existing file will be archived and the new one will be added.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UploadsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

UploadsApi apiInstance = new UploadsApi();
String entityType = "entityType_example"; // String | Entity type
Integer id = 56; // Integer | ID of the entity
Integer subid = 56; // Integer | ID of the upload
File file = new File("file_example"); // File | 
String comment = "comment_example"; // String | 
try {
    apiInstance.postUploadReplace(entityType, id, subid, file, comment);
} catch (ApiException e) {
    System.err.println("Exception when calling UploadsApi#postUploadReplace");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityType** | **String**| Entity type | [enum: experiments, items]
 **id** | **Integer**| ID of the entity |
 **subid** | **Integer**| ID of the upload |
 **file** | **File**|  | [optional]
 **comment** | **String**|  | [optional]

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: Not defined

<a name="readUpload"></a>
# **readUpload**
> Upload readUpload(entityType, id, subid, format)

Read an upload.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UploadsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

UploadsApi apiInstance = new UploadsApi();
String entityType = "entityType_example"; // String | Entity type
Integer id = 56; // Integer | ID of the entity
Integer subid = 56; // Integer | ID of the upload
String format = "json"; // String | To download the file itself, use `binary` format parameter. In python library, when downloading a file content, make sure to add ` _preload_content=False` into the call to `read_upload()`. 
try {
    Upload result = apiInstance.readUpload(entityType, id, subid, format);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UploadsApi#readUpload");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityType** | **String**| Entity type | [enum: experiments, items]
 **id** | **Integer**| ID of the entity |
 **subid** | **Integer**| ID of the upload |
 **format** | **String**| To download the file itself, use &#x60;binary&#x60; format parameter. In python library, when downloading a file content, make sure to add &#x60; _preload_content&#x3D;False&#x60; into the call to &#x60;read_upload()&#x60;.  | [optional] [default to json] [enum: binary, json]

### Return type

[**Upload**](Upload.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, */*

<a name="readUploads"></a>
# **readUploads**
> List&lt;Upload&gt; readUploads(entityType, id)

Read attached files of that entity.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UploadsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

UploadsApi apiInstance = new UploadsApi();
String entityType = "entityType_example"; // String | Entity type
Integer id = 56; // Integer | ID of the entity
try {
    List<Upload> result = apiInstance.readUploads(entityType, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UploadsApi#readUploads");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityType** | **String**| Entity type | [enum: experiments, items]
 **id** | **Integer**| ID of the entity |

### Return type

[**List&lt;Upload&gt;**](Upload.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

