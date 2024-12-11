# UsersApi

All URIs are relative to *https://elab.local:3148/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**patchUser**](UsersApi.md#patchUser) | **PATCH** /users/{id} | Modify a user.
[**postUser**](UsersApi.md#postUser) | **POST** /users | Create a new user.
[**readUser**](UsersApi.md#readUser) | **GET** /users/{id} | Read information of a user.
[**readUsers**](UsersApi.md#readUsers) | **GET** /users | Read users from instance.

<a name="patchUser"></a>
# **patchUser**
> Users patchUser(id, body)

Modify a user.

Note: it is possible to use \&quot;me\&quot; instead of the userid to access the user of the API key. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UsersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

UsersApi apiInstance = new UsersApi();
Id1 id = new Id1(); // Id1 | ID of the user or `me`.
UsersIdBody body = new UsersIdBody(); // UsersIdBody | Parameters for modifying a user.
try {
    Users result = apiInstance.patchUser(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#patchUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | [**Id1**](.md)| ID of the user or &#x60;me&#x60;. |
 **body** | [**UsersIdBody**](UsersIdBody.md)| Parameters for modifying a user. | [optional]

### Return type

[**Users**](Users.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postUser"></a>
# **postUser**
> postUser(body)

Create a new user.

An Admin can create a user in its own team only. A sysadmin can specify the team. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UsersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

UsersApi apiInstance = new UsersApi();
UsersBody body = new UsersBody(); // UsersBody | Parameters for creating a user.
try {
    apiInstance.postUser(body);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#postUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**UsersBody**](UsersBody.md)| Parameters for creating a user. | [optional]

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="readUser"></a>
# **readUser**
> Users readUser(id)

Read information of a user.

Note: it is possible to use \&quot;me\&quot; instead of the userid to access the user of the API key. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UsersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

UsersApi apiInstance = new UsersApi();
Id1 id = new Id1(); // Id1 | ID of the user or `me`.
try {
    Users result = apiInstance.readUser(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#readUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | [**Id1**](.md)| ID of the user or &#x60;me&#x60;. |

### Return type

[**Users**](Users.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="readUsers"></a>
# **readUsers**
> List&lt;InlineResponse2006&gt; readUsers(includeArchived)

Read users from instance.

Get a list of users with an active account on the instance.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UsersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

UsersApi apiInstance = new UsersApi();
String includeArchived = "includeArchived_example"; // String | Include archived users in the response
try {
    List<InlineResponse2006> result = apiInstance.readUsers(includeArchived);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#readUsers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **includeArchived** | **String**| Include archived users in the response | [optional] [enum: 0, 1]

### Return type

[**List&lt;InlineResponse2006&gt;**](InlineResponse2006.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

