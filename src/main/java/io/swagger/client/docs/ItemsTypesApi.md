# ItemsTypesApi

All URIs are relative to *https://elab.local:3148/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteItemsType**](ItemsTypesApi.md#deleteItemsType) | **DELETE** /items_types/{id} | Delete a resource category.
[**getItemsType**](ItemsTypesApi.md#getItemsType) | **GET** /items_types/{id} | Read a resource category.
[**patchItemsType**](ItemsTypesApi.md#patchItemsType) | **PATCH** /items_types/{id} | Modify a resource category.
[**postItemsTypes**](ItemsTypesApi.md#postItemsTypes) | **POST** /items_types | Create a resource category
[**readItemsTypes**](ItemsTypesApi.md#readItemsTypes) | **GET** /items_types | Read all resources categories that are accessible.

<a name="deleteItemsType"></a>
# **deleteItemsType**
> deleteItemsType(id)

Delete a resource category.

The resource category gets soft-deleted.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ItemsTypesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ItemsTypesApi apiInstance = new ItemsTypesApi();
Integer id = 56; // Integer | ID of the resource category.
try {
    apiInstance.deleteItemsType(id);
} catch (ApiException e) {
    System.err.println("Exception when calling ItemsTypesApi#deleteItemsType");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the resource category. |

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="getItemsType"></a>
# **getItemsType**
> ItemsType getItemsType(id)

Read a resource category.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ItemsTypesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ItemsTypesApi apiInstance = new ItemsTypesApi();
Integer id = 56; // Integer | ID of the resource category.
try {
    ItemsType result = apiInstance.getItemsType(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ItemsTypesApi#getItemsType");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the resource category. |

### Return type

[**ItemsType**](ItemsType.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="patchItemsType"></a>
# **patchItemsType**
> ItemsType patchItemsType(id, body)

Modify a resource category.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ItemsTypesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ItemsTypesApi apiInstance = new ItemsTypesApi();
Integer id = 56; // Integer | ID of the resource category.
ItemsType body = new ItemsType(); // ItemsType | 
try {
    ItemsType result = apiInstance.patchItemsType(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ItemsTypesApi#patchItemsType");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the resource category. |
 **body** | [**ItemsType**](ItemsType.md)|  | [optional]

### Return type

[**ItemsType**](ItemsType.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postItemsTypes"></a>
# **postItemsTypes**
> postItemsTypes(body)

Create a resource category

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ItemsTypesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ItemsTypesApi apiInstance = new ItemsTypesApi();
ItemsTypesBody body = new ItemsTypesBody(); // ItemsTypesBody | Parameters for creating a resource category
try {
    apiInstance.postItemsTypes(body);
} catch (ApiException e) {
    System.err.println("Exception when calling ItemsTypesApi#postItemsTypes");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ItemsTypesBody**](ItemsTypesBody.md)| Parameters for creating a resource category | [optional]

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="readItemsTypes"></a>
# **readItemsTypes**
> List&lt;ItemsType&gt; readItemsTypes()

Read all resources categories that are accessible.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ItemsTypesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ItemsTypesApi apiInstance = new ItemsTypesApi();
try {
    List<ItemsType> result = apiInstance.readItemsTypes();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ItemsTypesApi#readItemsTypes");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;ItemsType&gt;**](ItemsType.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

