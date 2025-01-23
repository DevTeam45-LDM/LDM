# TagsApi

All URIs are relative to *https://elab.local:3148/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteTag**](TagsApi.md#deleteTag) | **DELETE** /{entity_type}/{id}/tags | Delete all tags.
[**patchTag**](TagsApi.md#patchTag) | **PATCH** /{entity_type}/{id}/tags/{subid} | Actions on a tag (like removing it from the entity). 
[**postTag**](TagsApi.md#postTag) | **POST** /{entity_type}/{id}/tags | Create a tag.
[**readTag**](TagsApi.md#readTag) | **GET** /{entity_type}/{id}/tags/{subid} | Read a tag.
[**readTags**](TagsApi.md#readTags) | **GET** /{entity_type}/{id}/tags | Read all tags of that entity.

<a name="deleteTag"></a>
# **deleteTag**
> deleteTag(entityType, id)

Delete all tags.

All the tags from that entity get removed.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TagsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

TagsApi apiInstance = new TagsApi();
String entityType = "entityType_example"; // String | Entity type
Integer id = 56; // Integer | ID of the entity
try {
    apiInstance.deleteTag(entityType, id);
} catch (ApiException e) {
    System.err.println("Exception when calling TagsApi#deleteTag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityType** | **String**| Entity type | [enum: experiments, items, experiments_templates, items_types]
 **id** | **Integer**| ID of the entity |

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="patchTag"></a>
# **patchTag**
> Tag patchTag(entityType, id, subid, body)

Actions on a tag (like removing it from the entity). 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TagsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

TagsApi apiInstance = new TagsApi();
String entityType = "entityType_example"; // String | Entity type
Integer id = 56; // Integer | ID of the entity
Integer subid = 56; // Integer | ID of the tag
TagsSubidBody1 body = new TagsSubidBody1(); // TagsSubidBody1 | Parameters for modifying a tag
try {
    Tag result = apiInstance.patchTag(entityType, id, subid, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TagsApi#patchTag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityType** | **String**| Entity type | [enum: experiments, items, experiments_templates, items_types]
 **id** | **Integer**| ID of the entity |
 **subid** | **Integer**| ID of the tag |
 **body** | [**TagsSubidBody1**](TagsSubidBody1.md)| Parameters for modifying a tag | [optional]

### Return type

[**Tag**](Tag.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postTag"></a>
# **postTag**
> postTag(entityType, id, body)

Create a tag.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TagsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

TagsApi apiInstance = new TagsApi();
String entityType = "entityType_example"; // String | Entity type
Integer id = 56; // Integer | ID of the entity
IdTagsBody2 body = new IdTagsBody2(); // IdTagsBody2 | Parameters for creating a tag.
try {
    apiInstance.postTag(entityType, id, body);
} catch (ApiException e) {
    System.err.println("Exception when calling TagsApi#postTag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityType** | **String**| Entity type | [enum: experiments, items, experiments_templates, items_types]
 **id** | **Integer**| ID of the entity |
 **body** | [**IdTagsBody2**](IdTagsBody2.md)| Parameters for creating a tag. | [optional]

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="readTag"></a>
# **readTag**
> Tag readTag(entityType, id, subid)

Read a tag.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TagsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

TagsApi apiInstance = new TagsApi();
String entityType = "entityType_example"; // String | Entity type
Integer id = 56; // Integer | ID of the entity
Integer subid = 56; // Integer | ID of the tag
try {
    Tag result = apiInstance.readTag(entityType, id, subid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TagsApi#readTag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityType** | **String**| Entity type | [enum: experiments, items, experiments_templates, items_types]
 **id** | **Integer**| ID of the entity |
 **subid** | **Integer**| ID of the tag |

### Return type

[**Tag**](Tag.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="readTags"></a>
# **readTags**
> List&lt;Tag&gt; readTags(entityType, id)

Read all tags of that entity.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TagsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

TagsApi apiInstance = new TagsApi();
String entityType = "entityType_example"; // String | Entity type
Integer id = 56; // Integer | ID of the entity
try {
    List<Tag> result = apiInstance.readTags(entityType, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TagsApi#readTags");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityType** | **String**| Entity type | [enum: experiments, items, experiments_templates, items_types]
 **id** | **Integer**| ID of the entity |

### Return type

[**List&lt;Tag&gt;**](Tag.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

