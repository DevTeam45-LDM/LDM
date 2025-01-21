# RevisionsApi

All URIs are relative to *https://elab.local:3148/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**patchEntityRevision**](RevisionsApi.md#patchEntityRevision) | **PATCH** /{entity_type}/{id}/revisions/{subid} | Restore a revision.
[**readEntityRevision**](RevisionsApi.md#readEntityRevision) | **GET** /{entity_type}/{id}/revisions/{subid} | Read a revision of that entity.
[**readEntityRevisions**](RevisionsApi.md#readEntityRevisions) | **GET** /{entity_type}/{id}/revisions | Read all revisions of that entity.

<a name="patchEntityRevision"></a>
# **patchEntityRevision**
> Revision patchEntityRevision(entityType, id, subid, body)

Restore a revision.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.RevisionsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

RevisionsApi apiInstance = new RevisionsApi();
String entityType = "entityType_example"; // String | Entity type
Integer id = 56; // Integer | ID of the entity
Integer subid = 56; // Integer | ID of the revision
RevisionsSubidBody body = new RevisionsSubidBody(); // RevisionsSubidBody | Parameters for restoring an entity revision.
try {
    Revision result = apiInstance.patchEntityRevision(entityType, id, subid, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RevisionsApi#patchEntityRevision");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityType** | **String**| Entity type | [enum: experiments, items, experiments_templates]
 **id** | **Integer**| ID of the entity |
 **subid** | **Integer**| ID of the revision |
 **body** | [**RevisionsSubidBody**](RevisionsSubidBody.md)| Parameters for restoring an entity revision. | [optional]

### Return type

[**Revision**](Revision.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="readEntityRevision"></a>
# **readEntityRevision**
> Revision readEntityRevision(entityType, id, subid)

Read a revision of that entity.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.RevisionsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

RevisionsApi apiInstance = new RevisionsApi();
String entityType = "entityType_example"; // String | Entity type
Integer id = 56; // Integer | ID of the entity
Integer subid = 56; // Integer | ID of the revision
try {
    Revision result = apiInstance.readEntityRevision(entityType, id, subid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RevisionsApi#readEntityRevision");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityType** | **String**| Entity type | [enum: experiments, items, experiments_templates]
 **id** | **Integer**| ID of the entity |
 **subid** | **Integer**| ID of the revision |

### Return type

[**Revision**](Revision.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="readEntityRevisions"></a>
# **readEntityRevisions**
> List&lt;InlineResponse2009&gt; readEntityRevisions(entityType, id)

Read all revisions of that entity.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.RevisionsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

RevisionsApi apiInstance = new RevisionsApi();
String entityType = "entityType_example"; // String | Entity type
Integer id = 56; // Integer | ID of the entity
try {
    List<InlineResponse2009> result = apiInstance.readEntityRevisions(entityType, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RevisionsApi#readEntityRevisions");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityType** | **String**| Entity type | [enum: experiments, items, experiments_templates]
 **id** | **Integer**| ID of the entity |

### Return type

[**List&lt;InlineResponse2009&gt;**](InlineResponse2009.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

