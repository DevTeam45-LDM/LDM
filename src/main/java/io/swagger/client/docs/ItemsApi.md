# ItemsApi

All URIs are relative to *https://elab.local:3148/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteItem**](ItemsApi.md#deleteItem) | **DELETE** /items/{id} | Delete an item.
[**getItem**](ItemsApi.md#getItem) | **GET** /items/{id} | Read an item
[**patchItem**](ItemsApi.md#patchItem) | **PATCH** /items/{id} | Modify an item
[**postItem**](ItemsApi.md#postItem) | **POST** /items | Create an item
[**postItemById**](ItemsApi.md#postItemById) | **POST** /items/{id} | Duplicate an item with its ID
[**readItems**](ItemsApi.md#readItems) | **GET** /items | Read all items that are accessible

<a name="deleteItem"></a>
# **deleteItem**
> deleteItem(id)

Delete an item.

The item gets soft-deleted.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ItemsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ItemsApi apiInstance = new ItemsApi();
Integer id = 56; // Integer | ID of the item
try {
    apiInstance.deleteItem(id);
} catch (ApiException e) {
    System.err.println("Exception when calling ItemsApi#deleteItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the item |

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="getItem"></a>
# **getItem**
> Item getItem(id, format, json, withTitle, size, changelog)

Read an item

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ItemsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ItemsApi apiInstance = new ItemsApi();
Integer id = 56; // Integer | ID of the item
String format = "json"; // String | Get the entity in a different format like csv, pdf, eln or zip. \"pdfa\" means archive pdf (PDF/A), same with \"zipa\". 
Boolean json = false; // Boolean | Include a full JSON export in the ZIP archive. Only applicable if format is zip(a). 
Boolean withTitle = true; // Boolean | Include the title in the QR code. Only applicable if format is qrpng. 
Integer size = 250; // Integer | Specify the size of the QR code in pixels. Only applicable if format is qrpng. 
Boolean changelog = false; // Boolean | Toggles if the changelog should be included in PDF exports (pdf, pdfa, zip, zipa). Changelog is by default included if the export provides PDF/A, otherwise not. 
try {
    Item result = apiInstance.getItem(id, format, json, withTitle, size, changelog);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ItemsApi#getItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the item |
 **format** | **String**| Get the entity in a different format like csv, pdf, eln or zip. \&quot;pdfa\&quot; means archive pdf (PDF/A), same with \&quot;zipa\&quot;.  | [optional] [default to json] [enum: csv, eln, json, qrpdf, qrpng, pdf, pdfa, zip, zipa]
 **json** | **Boolean**| Include a full JSON export in the ZIP archive. Only applicable if format is zip(a).  | [optional] [default to false]
 **withTitle** | **Boolean**| Include the title in the QR code. Only applicable if format is qrpng.  | [optional] [default to true]
 **size** | **Integer**| Specify the size of the QR code in pixels. Only applicable if format is qrpng.  | [optional] [default to 250]
 **changelog** | **Boolean**| Toggles if the changelog should be included in PDF exports (pdf, pdfa, zip, zipa). Changelog is by default included if the export provides PDF/A, otherwise not.  | [optional] [default to false]

### Return type

[**Item**](Item.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="patchItem"></a>
# **patchItem**
> Item patchItem(id, body)

Modify an item

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ItemsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ItemsApi apiInstance = new ItemsApi();
Integer id = 56; // Integer | ID of the item
ItemsIdBody1 body = new ItemsIdBody1(); // ItemsIdBody1 | Parameters for patching an item
try {
    Item result = apiInstance.patchItem(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ItemsApi#patchItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the item |
 **body** | [**ItemsIdBody1**](ItemsIdBody1.md)| Parameters for patching an item | [optional]

### Return type

[**Item**](Item.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postItem"></a>
# **postItem**
> postItem(body)

Create an item

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ItemsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ItemsApi apiInstance = new ItemsApi();
ItemsBody body = new ItemsBody(); // ItemsBody | Parameters for creating an item
try {
    apiInstance.postItem(body);
} catch (ApiException e) {
    System.err.println("Exception when calling ItemsApi#postItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ItemsBody**](ItemsBody.md)| Parameters for creating an item | [optional]

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="postItemById"></a>
# **postItemById**
> postItemById(id, body)

Duplicate an item with its ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ItemsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ItemsApi apiInstance = new ItemsApi();
Integer id = 56; // Integer | The unique identifier of the item to duplicate.
ItemsIdBody body = new ItemsIdBody(); // ItemsIdBody | Parameters for duplicating an item
try {
    apiInstance.postItemById(id, body);
} catch (ApiException e) {
    System.err.println("Exception when calling ItemsApi#postItemById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The unique identifier of the item to duplicate. |
 **body** | [**ItemsIdBody**](ItemsIdBody.md)| Parameters for duplicating an item | [optional]

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="readItems"></a>
# **readItems**
> List&lt;Item&gt; readItems(q, extended, related, relatedOrigin, cat, tags, limit, offset, owner, scope, order, sort)

Read all items that are accessible

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ItemsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ItemsApi apiInstance = new ItemsApi();
String q = "q_example"; // String | Search for a term in title, body or elabid. 
String extended = "extended_example"; // String | Extended search (advanced query). 
Integer related = 56; // Integer | Look only for entries linked to this item id. 
String relatedOrigin = "relatedOrigin_example"; // String | When using the \"related\" query parameter, select the type of the related ID (experiments or items) 
Integer cat = 56; // Integer | The category id of the items. 
List<String> tags = Arrays.asList("tags_example"); // List<String> | An array of tags for filtering results containing all of these tags. 
Integer limit = 15; // Integer | Limit the number of results. 
Integer offset = 0; // Integer | Skip a number of results. Use with limit to work the pagination. 
Integer owner = 56; // Integer | Filter results by author (user id) 
Integer scope = 56; // Integer | Set the scope for the results. 1: self, 2: team, 3: everything. It defaults to the user value stored in preferences. 
String order = "order_example"; // String | Change the ordering of the results. 
String sort = "sort_example"; // String | Change the sorting of results: ascending or descending. 
try {
    List<Item> result = apiInstance.readItems(q, extended, related, relatedOrigin, cat, tags, limit, offset, owner, scope, order, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ItemsApi#readItems");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **q** | **String**| Search for a term in title, body or elabid.  | [optional]
 **extended** | **String**| Extended search (advanced query).  | [optional]
 **related** | **Integer**| Look only for entries linked to this item id.  | [optional]
 **relatedOrigin** | **String**| When using the \&quot;related\&quot; query parameter, select the type of the related ID (experiments or items)  | [optional] [enum: experiments, items]
 **cat** | **Integer**| The category id of the items.  | [optional]
 **tags** | [**List&lt;String&gt;**](String.md)| An array of tags for filtering results containing all of these tags.  | [optional]
 **limit** | **Integer**| Limit the number of results.  | [optional] [default to 15]
 **offset** | **Integer**| Skip a number of results. Use with limit to work the pagination.  | [optional] [default to 0]
 **owner** | **Integer**| Filter results by author (user id)  | [optional]
 **scope** | **Integer**| Set the scope for the results. 1: self, 2: team, 3: everything. It defaults to the user value stored in preferences.  | [optional] [enum: 1, 2, 3]
 **order** | **String**| Change the ordering of the results.  | [optional] [enum: cat, comment, customid, date, id, lastchange, rating, status, title, user]
 **sort** | **String**| Change the sorting of results: ascending or descending.  | [optional] [enum: asc, desc]

### Return type

[**List&lt;Item&gt;**](Item.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

