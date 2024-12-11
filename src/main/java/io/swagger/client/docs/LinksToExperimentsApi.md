# LinksToExperimentsApi

All URIs are relative to *https://elab.local:3148/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteEntityExperimentsLink**](LinksToExperimentsApi.md#deleteEntityExperimentsLink) | **DELETE** /{entity_type}/{id}/experiments_links/{subid} | Delete an experiment link.
[**postEntityExperimentsLinks**](LinksToExperimentsApi.md#postEntityExperimentsLinks) | **POST** /{entity_type}/{id}/experiments_links/{subid} | Create or import a link.
[**readEntityExperimentsLinks**](LinksToExperimentsApi.md#readEntityExperimentsLinks) | **GET** /{entity_type}/{id}/experiments_links | Read all experiments links of that entity.

<a name="deleteEntityExperimentsLink"></a>
# **deleteEntityExperimentsLink**
> deleteEntityExperimentsLink(entityType, id, subid)

Delete an experiment link.

The link gets deleted.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.LinksToExperimentsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

LinksToExperimentsApi apiInstance = new LinksToExperimentsApi();
String entityType = "entityType_example"; // String | Entity type
Integer id = 56; // Integer | ID of the entity
Integer subid = 56; // Integer | ID of the experiment linked
try {
    apiInstance.deleteEntityExperimentsLink(entityType, id, subid);
} catch (ApiException e) {
    System.err.println("Exception when calling LinksToExperimentsApi#deleteEntityExperimentsLink");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityType** | **String**| Entity type | [enum: experiments, items]
 **id** | **Integer**| ID of the entity |
 **subid** | **Integer**| ID of the experiment linked |

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="postEntityExperimentsLinks"></a>
# **postEntityExperimentsLinks**
> postEntityExperimentsLinks(entityType, id, subid, body)

Create or import a link.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.LinksToExperimentsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

LinksToExperimentsApi apiInstance = new LinksToExperimentsApi();
String entityType = "entityType_example"; // String | Entity type
Integer id = 56; // Integer | ID of the entity
Integer subid = 56; // Integer | ID of the experiment linked
ExperimentsLinksSubidBody body = new ExperimentsLinksSubidBody(); // ExperimentsLinksSubidBody | Parameters for creating or importing a link.
try {
    apiInstance.postEntityExperimentsLinks(entityType, id, subid, body);
} catch (ApiException e) {
    System.err.println("Exception when calling LinksToExperimentsApi#postEntityExperimentsLinks");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityType** | **String**| Entity type | [enum: experiments, items]
 **id** | **Integer**| ID of the entity |
 **subid** | **Integer**| ID of the experiment linked |
 **body** | [**ExperimentsLinksSubidBody**](ExperimentsLinksSubidBody.md)| Parameters for creating or importing a link. | [optional]

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="readEntityExperimentsLinks"></a>
# **readEntityExperimentsLinks**
> List&lt;Link&gt; readEntityExperimentsLinks(entityType, id)

Read all experiments links of that entity.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.LinksToExperimentsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

LinksToExperimentsApi apiInstance = new LinksToExperimentsApi();
String entityType = "entityType_example"; // String | Entity type
Integer id = 56; // Integer | ID of the entity
try {
    List<Link> result = apiInstance.readEntityExperimentsLinks(entityType, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LinksToExperimentsApi#readEntityExperimentsLinks");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityType** | **String**| Entity type | [enum: experiments, items]
 **id** | **Integer**| ID of the entity |

### Return type

[**List&lt;Link&gt;**](Link.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

