# ExperimentsTemplatesApi

All URIs are relative to *https://elab.local:3148/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteExperimentTemplate**](ExperimentsTemplatesApi.md#deleteExperimentTemplate) | **DELETE** /experiments_templates/{id} | Delete an experiment template.
[**getExperimentTemplate**](ExperimentsTemplatesApi.md#getExperimentTemplate) | **GET** /experiments_templates/{id} | Read an experiment template
[**patchExperimentTemplate**](ExperimentsTemplatesApi.md#patchExperimentTemplate) | **PATCH** /experiments_templates/{id} | Modify an experiment template
[**postExperimentTemplate**](ExperimentsTemplatesApi.md#postExperimentTemplate) | **POST** /experiments_templates | Create an experiment template
[**postExperimentTemplateById**](ExperimentsTemplatesApi.md#postExperimentTemplateById) | **POST** /experiments_templates/{id} | Duplicate an experiment template with its ID
[**readExperimentsTemplates**](ExperimentsTemplatesApi.md#readExperimentsTemplates) | **GET** /experiments_templates | Read all experiments_templates that are accessible

<a name="deleteExperimentTemplate"></a>
# **deleteExperimentTemplate**
> deleteExperimentTemplate(id)

Delete an experiment template.

The experiment template gets soft-deleted.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ExperimentsTemplatesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ExperimentsTemplatesApi apiInstance = new ExperimentsTemplatesApi();
Integer id = 56; // Integer | ID of the experiment template
try {
    apiInstance.deleteExperimentTemplate(id);
} catch (ApiException e) {
    System.err.println("Exception when calling ExperimentsTemplatesApi#deleteExperimentTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the experiment template |

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="getExperimentTemplate"></a>
# **getExperimentTemplate**
> ExperimentTemplate getExperimentTemplate(id)

Read an experiment template

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ExperimentsTemplatesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ExperimentsTemplatesApi apiInstance = new ExperimentsTemplatesApi();
Integer id = 56; // Integer | ID of the experiment template
try {
    ExperimentTemplate result = apiInstance.getExperimentTemplate(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExperimentsTemplatesApi#getExperimentTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the experiment template |

### Return type

[**ExperimentTemplate**](ExperimentTemplate.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="patchExperimentTemplate"></a>
# **patchExperimentTemplate**
> ExperimentTemplate patchExperimentTemplate(id, body)

Modify an experiment template

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ExperimentsTemplatesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ExperimentsTemplatesApi apiInstance = new ExperimentsTemplatesApi();
Integer id = 56; // Integer | ID of the experiment template
ExperimentsTemplatesIdBody1 body = new ExperimentsTemplatesIdBody1(); // ExperimentsTemplatesIdBody1 | Parameters for modifying an experiment template
try {
    ExperimentTemplate result = apiInstance.patchExperimentTemplate(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExperimentsTemplatesApi#patchExperimentTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the experiment template |
 **body** | [**ExperimentsTemplatesIdBody1**](ExperimentsTemplatesIdBody1.md)| Parameters for modifying an experiment template | [optional]

### Return type

[**ExperimentTemplate**](ExperimentTemplate.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postExperimentTemplate"></a>
# **postExperimentTemplate**
> postExperimentTemplate(body)

Create an experiment template

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ExperimentsTemplatesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ExperimentsTemplatesApi apiInstance = new ExperimentsTemplatesApi();
ExperimentsTemplatesBody body = new ExperimentsTemplatesBody(); // ExperimentsTemplatesBody | Parameters for creating an experiment template
try {
    apiInstance.postExperimentTemplate(body);
} catch (ApiException e) {
    System.err.println("Exception when calling ExperimentsTemplatesApi#postExperimentTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ExperimentsTemplatesBody**](ExperimentsTemplatesBody.md)| Parameters for creating an experiment template | [optional]

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="postExperimentTemplateById"></a>
# **postExperimentTemplateById**
> postExperimentTemplateById(id, body)

Duplicate an experiment template with its ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ExperimentsTemplatesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ExperimentsTemplatesApi apiInstance = new ExperimentsTemplatesApi();
Integer id = 56; // Integer | The unique identifier of the experiment template to duplicate.
ExperimentsTemplatesIdBody body = new ExperimentsTemplatesIdBody(); // ExperimentsTemplatesIdBody | Parameters for duplicating an experiment template
try {
    apiInstance.postExperimentTemplateById(id, body);
} catch (ApiException e) {
    System.err.println("Exception when calling ExperimentsTemplatesApi#postExperimentTemplateById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The unique identifier of the experiment template to duplicate. |
 **body** | [**ExperimentsTemplatesIdBody**](ExperimentsTemplatesIdBody.md)| Parameters for duplicating an experiment template | [optional]

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="readExperimentsTemplates"></a>
# **readExperimentsTemplates**
> List&lt;ExperimentTemplate&gt; readExperimentsTemplates()

Read all experiments_templates that are accessible

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ExperimentsTemplatesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ExperimentsTemplatesApi apiInstance = new ExperimentsTemplatesApi();
try {
    List<ExperimentTemplate> result = apiInstance.readExperimentsTemplates();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExperimentsTemplatesApi#readExperimentsTemplates");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;ExperimentTemplate&gt;**](ExperimentTemplate.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

