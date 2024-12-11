# FavoriteTagsApi

All URIs are relative to *https://elab.local:3148/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteFavtag**](FavoriteTagsApi.md#deleteFavtag) | **DELETE** /favtags/{id} | Unfavorite a tag.
[**postFavtags**](FavoriteTagsApi.md#postFavtags) | **POST** /favtags | Add a tag as favorite.
[**readFavtags**](FavoriteTagsApi.md#readFavtags) | **GET** /favtags | Read all favorite tags for the user.

<a name="deleteFavtag"></a>
# **deleteFavtag**
> deleteFavtag(id)

Unfavorite a tag.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.FavoriteTagsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

FavoriteTagsApi apiInstance = new FavoriteTagsApi();
Integer id = 56; // Integer | ID of the tag.
try {
    apiInstance.deleteFavtag(id);
} catch (ApiException e) {
    System.err.println("Exception when calling FavoriteTagsApi#deleteFavtag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the tag. |

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="postFavtags"></a>
# **postFavtags**
> postFavtags(body)

Add a tag as favorite.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.FavoriteTagsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

FavoriteTagsApi apiInstance = new FavoriteTagsApi();
FavtagsBody body = new FavtagsBody(); // FavtagsBody | Parameters for adding a favorite tag.
try {
    apiInstance.postFavtags(body);
} catch (ApiException e) {
    System.err.println("Exception when calling FavoriteTagsApi#postFavtags");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**FavtagsBody**](FavtagsBody.md)| Parameters for adding a favorite tag. | [optional]

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="readFavtags"></a>
# **readFavtags**
> InlineResponse2002 readFavtags()

Read all favorite tags for the user.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.FavoriteTagsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

FavoriteTagsApi apiInstance = new FavoriteTagsApi();
try {
    InlineResponse2002 result = apiInstance.readFavtags();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FavoriteTagsApi#readFavtags");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**InlineResponse2002**](InlineResponse2002.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

