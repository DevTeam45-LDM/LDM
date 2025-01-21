# CommentsApi

All URIs are relative to *https://elab.local:3148/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteEntityComment**](CommentsApi.md#deleteEntityComment) | **DELETE** /{entity_type}/{id}/comments/{subid} | Delete an entity comment.
[**patchEntityComment**](CommentsApi.md#patchEntityComment) | **PATCH** /{entity_type}/{id}/comments/{subid} | Modify an entity comment.
[**postEntityComments**](CommentsApi.md#postEntityComments) | **POST** /{entity_type}/{id}/comments | Create a comment.
[**readEntityComment**](CommentsApi.md#readEntityComment) | **GET** /{entity_type}/{id}/comments/{subid} | Read a comment of that entity.
[**readEntityComments**](CommentsApi.md#readEntityComments) | **GET** /{entity_type}/{id}/comments | Read all comments of that entity.

<a name="deleteEntityComment"></a>
# **deleteEntityComment**
> deleteEntityComment(entityType, id, subid)

Delete an entity comment.

The comment gets deleted.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.CommentsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

CommentsApi apiInstance = new CommentsApi();
String entityType = "entityType_example"; // String | Entity type
Integer id = 56; // Integer | ID of the entity
Integer subid = 56; // Integer | ID of the comment
try {
    apiInstance.deleteEntityComment(entityType, id, subid);
} catch (ApiException e) {
    System.err.println("Exception when calling CommentsApi#deleteEntityComment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityType** | **String**| Entity type | [enum: experiments, items]
 **id** | **Integer**| ID of the entity |
 **subid** | **Integer**| ID of the comment |

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="patchEntityComment"></a>
# **patchEntityComment**
> Comment patchEntityComment(entityType, id, subid, body)

Modify an entity comment.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.CommentsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

CommentsApi apiInstance = new CommentsApi();
String entityType = "entityType_example"; // String | Entity type
Integer id = 56; // Integer | ID of the entity
Integer subid = 56; // Integer | ID of the comment
Comment body = new Comment(); // Comment | Parameters for patching an entity comment.
try {
    Comment result = apiInstance.patchEntityComment(entityType, id, subid, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CommentsApi#patchEntityComment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityType** | **String**| Entity type | [enum: experiments, items]
 **id** | **Integer**| ID of the entity |
 **subid** | **Integer**| ID of the comment |
 **body** | [**Comment**](Comment.md)| Parameters for patching an entity comment. | [optional]

### Return type

[**Comment**](Comment.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postEntityComments"></a>
# **postEntityComments**
> postEntityComments(entityType, id, body)

Create a comment.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.CommentsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

CommentsApi apiInstance = new CommentsApi();
String entityType = "entityType_example"; // String | Entity type
Integer id = 56; // Integer | ID of the entity
IdCommentsBody body = new IdCommentsBody(); // IdCommentsBody | Parameters for creating a comment
try {
    apiInstance.postEntityComments(entityType, id, body);
} catch (ApiException e) {
    System.err.println("Exception when calling CommentsApi#postEntityComments");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityType** | **String**| Entity type | [enum: experiments, items]
 **id** | **Integer**| ID of the entity |
 **body** | [**IdCommentsBody**](IdCommentsBody.md)| Parameters for creating a comment | [optional]

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="readEntityComment"></a>
# **readEntityComment**
> Comment readEntityComment(entityType, id, subid)

Read a comment of that entity.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.CommentsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

CommentsApi apiInstance = new CommentsApi();
String entityType = "entityType_example"; // String | Entity type
Integer id = 56; // Integer | ID of the entity
Integer subid = 56; // Integer | ID of the comment
try {
    Comment result = apiInstance.readEntityComment(entityType, id, subid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CommentsApi#readEntityComment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityType** | **String**| Entity type | [enum: experiments, items]
 **id** | **Integer**| ID of the entity |
 **subid** | **Integer**| ID of the comment |

### Return type

[**Comment**](Comment.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="readEntityComments"></a>
# **readEntityComments**
> List&lt;Comment&gt; readEntityComments(entityType, id)

Read all comments of that entity.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.CommentsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

CommentsApi apiInstance = new CommentsApi();
String entityType = "entityType_example"; // String | Entity type
Integer id = 56; // Integer | ID of the entity
try {
    List<Comment> result = apiInstance.readEntityComments(entityType, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CommentsApi#readEntityComments");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityType** | **String**| Entity type | [enum: experiments, items]
 **id** | **Integer**| ID of the entity |

### Return type

[**List&lt;Comment&gt;**](Comment.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

