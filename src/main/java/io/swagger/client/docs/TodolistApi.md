# TodolistApi

All URIs are relative to *https://elab.local:3148/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteTodoitem**](TodolistApi.md#deleteTodoitem) | **DELETE** /todolist/{id} | Delete a todoitem.
[**patchTodoitem**](TodolistApi.md#patchTodoitem) | **PATCH** /todolist/{id} | Actions on a todoitem. 
[**postTodolist**](TodolistApi.md#postTodolist) | **POST** /todolist | Create a todo item
[**readTodoitem**](TodolistApi.md#readTodoitem) | **GET** /todolist/{id} | Read a todo entry.
[**readTodolist**](TodolistApi.md#readTodolist) | **GET** /todolist | Read all todoitems.

<a name="deleteTodoitem"></a>
# **deleteTodoitem**
> deleteTodoitem(id)

Delete a todoitem.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TodolistApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

TodolistApi apiInstance = new TodolistApi();
Integer id = 56; // Integer | ID of the todoitem.
try {
    apiInstance.deleteTodoitem(id);
} catch (ApiException e) {
    System.err.println("Exception when calling TodolistApi#deleteTodoitem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the todoitem. |

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="patchTodoitem"></a>
# **patchTodoitem**
> Todoitem patchTodoitem(id, body)

Actions on a todoitem. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TodolistApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

TodolistApi apiInstance = new TodolistApi();
Integer id = 56; // Integer | ID of the todoitem.
TodolistIdBody body = new TodolistIdBody(); // TodolistIdBody | Parameters for modifying a todoitem.
try {
    Todoitem result = apiInstance.patchTodoitem(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TodolistApi#patchTodoitem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the todoitem. |
 **body** | [**TodolistIdBody**](TodolistIdBody.md)| Parameters for modifying a todoitem. | [optional]

### Return type

[**Todoitem**](Todoitem.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postTodolist"></a>
# **postTodolist**
> postTodolist(body)

Create a todo item

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TodolistApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

TodolistApi apiInstance = new TodolistApi();
TodolistBody body = new TodolistBody(); // TodolistBody | Parameters for creating a todoitem.
try {
    apiInstance.postTodolist(body);
} catch (ApiException e) {
    System.err.println("Exception when calling TodolistApi#postTodolist");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**TodolistBody**](TodolistBody.md)| Parameters for creating a todoitem. | [optional]

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="readTodoitem"></a>
# **readTodoitem**
> Todoitem readTodoitem(id)

Read a todo entry.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TodolistApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

TodolistApi apiInstance = new TodolistApi();
Integer id = 56; // Integer | ID of the todoitem.
try {
    Todoitem result = apiInstance.readTodoitem(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TodolistApi#readTodoitem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the todoitem. |

### Return type

[**Todoitem**](Todoitem.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="readTodolist"></a>
# **readTodolist**
> List&lt;Todoitem&gt; readTodolist()

Read all todoitems.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TodolistApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

TodolistApi apiInstance = new TodolistApi();
try {
    List<Todoitem> result = apiInstance.readTodolist();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TodolistApi#readTodolist");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Todoitem&gt;**](Todoitem.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

