# LinksToItemsApi

All URIs are relative to *https://elab.local:3148/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteEntitiyItemsLink**](LinksToItemsApi.md#deleteEntitiyItemsLink) | **DELETE** /{entity_type}/{id}/items_links/{subid} | Delete an item link.
[**postEntityItemsLinks**](LinksToItemsApi.md#postEntityItemsLinks) | **POST** /{entity_type}/{id}/items_links/{subid} | Create or import a link.
[**readEntityItemsLinks**](LinksToItemsApi.md#readEntityItemsLinks) | **GET** /{entity_type}/{id}/items_links | Read all items links of that entity.

<a name="deleteEntitiyItemsLink"></a>
# **deleteEntitiyItemsLink**
> deleteEntitiyItemsLink(entityType, id, subid)

Delete an item link.

The link gets deleted.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.LinksToItemsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

LinksToItemsApi apiInstance = new LinksToItemsApi();
String entityType = "entityType_example"; // String | Entity type
Integer id = 56; // Integer | ID of the entity
Integer subid = 56; // Integer | ID of the item (link)
try {
    apiInstance.deleteEntitiyItemsLink(entityType, id, subid);
} catch (ApiException e) {
    System.err.println("Exception when calling LinksToItemsApi#deleteEntitiyItemsLink");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityType** | **String**| Entity type | [enum: experiments, items]
 **id** | **Integer**| ID of the entity |
 **subid** | **Integer**| ID of the item (link) |

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="postEntityItemsLinks"></a>
# **postEntityItemsLinks**
> postEntityItemsLinks(entityType, id, subid, body)

Create or import a link.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.LinksToItemsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

LinksToItemsApi apiInstance = new LinksToItemsApi();
String entityType = "entityType_example"; // String | Entity type
Integer id = 56; // Integer | ID of the entity
Integer subid = 56; // Integer | ID of the item (link)
ItemsLinksSubidBody body = new ItemsLinksSubidBody(); // ItemsLinksSubidBody | Parameters for creating or importing a link.
try {
    apiInstance.postEntityItemsLinks(entityType, id, subid, body);
} catch (ApiException e) {
    System.err.println("Exception when calling LinksToItemsApi#postEntityItemsLinks");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityType** | **String**| Entity type | [enum: experiments, items]
 **id** | **Integer**| ID of the entity |
 **subid** | **Integer**| ID of the item (link) |
 **body** | [**ItemsLinksSubidBody**](ItemsLinksSubidBody.md)| Parameters for creating or importing a link. | [optional]

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="readEntityItemsLinks"></a>
# **readEntityItemsLinks**
> List&lt;Link&gt; readEntityItemsLinks(entityType, id)

Read all items links of that entity.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.LinksToItemsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

LinksToItemsApi apiInstance = new LinksToItemsApi();
String entityType = "entityType_example"; // String | Entity type
Integer id = 56; // Integer | ID of the entity
try {
    List<Link> result = apiInstance.readEntityItemsLinks(entityType, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LinksToItemsApi#readEntityItemsLinks");
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

