# TeamTagsApi

All URIs are relative to *https://elab.local:3148/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteTeamTag**](TeamTagsApi.md#deleteTeamTag) | **DELETE** /teams/{id}/tags/{subid} | Delete a tag.
[**patchTags**](TeamTagsApi.md#patchTags) | **PATCH** /teams/{id}/tags | Actions on tags. 
[**patchTeamTag**](TeamTagsApi.md#patchTeamTag) | **PATCH** /teams/{id}/tags/{subid} | Actions on a tag. 
[**postTeamTag**](TeamTagsApi.md#postTeamTag) | **POST** /teams/{id}/tags | Create a tag in the team.
[**readTeamTag**](TeamTagsApi.md#readTeamTag) | **GET** /teams/{id}/tags/{subid} | Read a tag.
[**readTeamTags**](TeamTagsApi.md#readTeamTags) | **GET** /teams/{id}/tags | Read all tags for the team.

<a name="deleteTeamTag"></a>
# **deleteTeamTag**
> deleteTeamTag(id, subid)

Delete a tag.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TeamTagsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

TeamTagsApi apiInstance = new TeamTagsApi();
Integer id = 56; // Integer | ID of the team.
Integer subid = 56; // Integer | ID of the tag.
try {
    apiInstance.deleteTeamTag(id, subid);
} catch (ApiException e) {
    System.err.println("Exception when calling TeamTagsApi#deleteTeamTag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the team. |
 **subid** | **Integer**| ID of the tag. |

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="patchTags"></a>
# **patchTags**
> List&lt;Tag&gt; patchTags(id, body)

Actions on tags. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TeamTagsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

TeamTagsApi apiInstance = new TeamTagsApi();
Integer id = 56; // Integer | ID of the team.
IdTagsBody1 body = new IdTagsBody1(); // IdTagsBody1 | Parameters for modifying team tags.
try {
    List<Tag> result = apiInstance.patchTags(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TeamTagsApi#patchTags");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the team. |
 **body** | [**IdTagsBody1**](IdTagsBody1.md)| Parameters for modifying team tags. | [optional]

### Return type

[**List&lt;Tag&gt;**](Tag.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="patchTeamTag"></a>
# **patchTeamTag**
> Tag patchTeamTag(id, subid, body)

Actions on a tag. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TeamTagsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

TeamTagsApi apiInstance = new TeamTagsApi();
Integer id = 56; // Integer | ID of the team.
Integer subid = 56; // Integer | ID of the tag.
TagsSubidBody body = new TagsSubidBody(); // TagsSubidBody | Parameters for modifying a tag.
try {
    Tag result = apiInstance.patchTeamTag(id, subid, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TeamTagsApi#patchTeamTag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the team. |
 **subid** | **Integer**| ID of the tag. |
 **body** | [**TagsSubidBody**](TagsSubidBody.md)| Parameters for modifying a tag. | [optional]

### Return type

[**Tag**](Tag.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postTeamTag"></a>
# **postTeamTag**
> postTeamTag(id, body)

Create a tag in the team.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TeamTagsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

TeamTagsApi apiInstance = new TeamTagsApi();
Integer id = 56; // Integer | ID of the team.
IdTagsBody body = new IdTagsBody(); // IdTagsBody | Parameters for adding a tag in the team.
try {
    apiInstance.postTeamTag(id, body);
} catch (ApiException e) {
    System.err.println("Exception when calling TeamTagsApi#postTeamTag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the team. |
 **body** | [**IdTagsBody**](IdTagsBody.md)| Parameters for adding a tag in the team. | [optional]

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="readTeamTag"></a>
# **readTeamTag**
> InlineResponse2004 readTeamTag(id, subid)

Read a tag.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TeamTagsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

TeamTagsApi apiInstance = new TeamTagsApi();
Integer id = 56; // Integer | ID of the team.
Integer subid = 56; // Integer | ID of the tag.
try {
    InlineResponse2004 result = apiInstance.readTeamTag(id, subid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TeamTagsApi#readTeamTag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the team. |
 **subid** | **Integer**| ID of the tag. |

### Return type

[**InlineResponse2004**](InlineResponse2004.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="readTeamTags"></a>
# **readTeamTags**
> InlineResponse2003 readTeamTags(id)

Read all tags for the team.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TeamTagsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

TeamTagsApi apiInstance = new TeamTagsApi();
Integer id = 56; // Integer | ID of the team.
try {
    InlineResponse2003 result = apiInstance.readTeamTags(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TeamTagsApi#readTeamTags");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the team. |

### Return type

[**InlineResponse2003**](InlineResponse2003.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

