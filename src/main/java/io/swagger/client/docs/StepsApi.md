# StepsApi

All URIs are relative to *https://elab.local:3148/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteStep**](StepsApi.md#deleteStep) | **DELETE** /{entity_type}/{id}/steps/{subid} | Delete a step.
[**patchStep**](StepsApi.md#patchStep) | **PATCH** /{entity_type}/{id}/steps/{subid} | Actions on a step. 
[**postStep**](StepsApi.md#postStep) | **POST** /{entity_type}/{id}/steps | Create a step.
[**readSteps**](StepsApi.md#readSteps) | **GET** /{entity_type}/{id}/steps | Read all steps of that entity.

<a name="deleteStep"></a>
# **deleteStep**
> deleteStep(entityType, id, subid)

Delete a step.

The step gets deleted.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.StepsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

StepsApi apiInstance = new StepsApi();
String entityType = "entityType_example"; // String | Entity type
Integer id = 56; // Integer | ID of the entity
Integer subid = 56; // Integer | ID of the step
try {
    apiInstance.deleteStep(entityType, id, subid);
} catch (ApiException e) {
    System.err.println("Exception when calling StepsApi#deleteStep");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityType** | **String**| Entity type | [enum: experiments, items, experiments_templates, items_types]
 **id** | **Integer**| ID of the entity |
 **subid** | **Integer**| ID of the step |

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="patchStep"></a>
# **patchStep**
> Step patchStep(entityType, id, subid, body)

Actions on a step. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.StepsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

StepsApi apiInstance = new StepsApi();
String entityType = "entityType_example"; // String | Entity type
Integer id = 56; // Integer | ID of the entity
Integer subid = 56; // Integer | ID of the step
StepsSubidBody body = new StepsSubidBody(); // StepsSubidBody | Parameters for modifying a step
try {
    Step result = apiInstance.patchStep(entityType, id, subid, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StepsApi#patchStep");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityType** | **String**| Entity type | [enum: experiments, items, experiments_templates, items_types]
 **id** | **Integer**| ID of the entity |
 **subid** | **Integer**| ID of the step |
 **body** | [**StepsSubidBody**](StepsSubidBody.md)| Parameters for modifying a step | [optional]

### Return type

[**Step**](Step.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postStep"></a>
# **postStep**
> postStep(entityType, id, body)

Create a step.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.StepsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

StepsApi apiInstance = new StepsApi();
String entityType = "entityType_example"; // String | Entity type
Integer id = 56; // Integer | ID of the entity
IdStepsBody body = new IdStepsBody(); // IdStepsBody | Parameters for creating a step.
try {
    apiInstance.postStep(entityType, id, body);
} catch (ApiException e) {
    System.err.println("Exception when calling StepsApi#postStep");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityType** | **String**| Entity type | [enum: experiments, items, experiments_templates, items_types]
 **id** | **Integer**| ID of the entity |
 **body** | [**IdStepsBody**](IdStepsBody.md)| Parameters for creating a step. | [optional]

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="readSteps"></a>
# **readSteps**
> List&lt;Step&gt; readSteps(entityType, id)

Read all steps of that entity.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.StepsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

StepsApi apiInstance = new StepsApi();
String entityType = "entityType_example"; // String | Entity type
Integer id = 56; // Integer | ID of the entity
try {
    List<Step> result = apiInstance.readSteps(entityType, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StepsApi#readSteps");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityType** | **String**| Entity type | [enum: experiments, items, experiments_templates, items_types]
 **id** | **Integer**| ID of the entity |

### Return type

[**List&lt;Step&gt;**](Step.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

