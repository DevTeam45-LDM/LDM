# ExperimentsCategoriesApi

All URIs are relative to *https://elab.local:3148/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteExpcat**](ExperimentsCategoriesApi.md#deleteExpcat) | **DELETE** /teams/{id}/experiments_categories/{subid} | Delete a category.
[**patchExpcat**](ExperimentsCategoriesApi.md#patchExpcat) | **PATCH** /teams/{id}/experiments_categories/{subid} | Modify a category.
[**postTeamOneExpcat**](ExperimentsCategoriesApi.md#postTeamOneExpcat) | **POST** /teams/{id}/experiments_categories | Create a new category for experiments.
[**readTeamExperimentsCategories**](ExperimentsCategoriesApi.md#readTeamExperimentsCategories) | **GET** /teams/{id}/experiments_categories | Read experiments categories of a team.
[**readTeamOneExpcat**](ExperimentsCategoriesApi.md#readTeamOneExpcat) | **GET** /teams/{id}/experiments_categories/{subid} | Read a category.

<a name="deleteExpcat"></a>
# **deleteExpcat**
> deleteExpcat(id, subid)

Delete a category.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ExperimentsCategoriesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ExperimentsCategoriesApi apiInstance = new ExperimentsCategoriesApi();
Integer id = 56; // Integer | ID of the team.
Integer subid = 56; // Integer | ID of the category.
try {
    apiInstance.deleteExpcat(id, subid);
} catch (ApiException e) {
    System.err.println("Exception when calling ExperimentsCategoriesApi#deleteExpcat");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the team. |
 **subid** | **Integer**| ID of the category. |

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="patchExpcat"></a>
# **patchExpcat**
> Statuslike patchExpcat(id, subid, body)

Modify a category.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ExperimentsCategoriesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ExperimentsCategoriesApi apiInstance = new ExperimentsCategoriesApi();
Integer id = 56; // Integer | ID of the team.
Integer subid = 56; // Integer | ID of the category.
Statuslike body = new Statuslike(); // Statuslike | Parameters for modifying a category.
try {
    Statuslike result = apiInstance.patchExpcat(id, subid, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExperimentsCategoriesApi#patchExpcat");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the team. |
 **subid** | **Integer**| ID of the category. |
 **body** | [**Statuslike**](Statuslike.md)| Parameters for modifying a category. | [optional]

### Return type

[**Statuslike**](Statuslike.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postTeamOneExpcat"></a>
# **postTeamOneExpcat**
> postTeamOneExpcat(id, body)

Create a new category for experiments.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ExperimentsCategoriesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ExperimentsCategoriesApi apiInstance = new ExperimentsCategoriesApi();
Integer id = 56; // Integer | ID of the team.
IdExperimentsCategoriesBody body = new IdExperimentsCategoriesBody(); // IdExperimentsCategoriesBody | Parameters for creating a category.
try {
    apiInstance.postTeamOneExpcat(id, body);
} catch (ApiException e) {
    System.err.println("Exception when calling ExperimentsCategoriesApi#postTeamOneExpcat");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the team. |
 **body** | [**IdExperimentsCategoriesBody**](IdExperimentsCategoriesBody.md)| Parameters for creating a category. | [optional]

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="readTeamExperimentsCategories"></a>
# **readTeamExperimentsCategories**
> List&lt;Statuslike&gt; readTeamExperimentsCategories(id)

Read experiments categories of a team.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ExperimentsCategoriesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ExperimentsCategoriesApi apiInstance = new ExperimentsCategoriesApi();
Integer id = 56; // Integer | ID of the team.
try {
    List<Statuslike> result = apiInstance.readTeamExperimentsCategories(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExperimentsCategoriesApi#readTeamExperimentsCategories");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the team. |

### Return type

[**List&lt;Statuslike&gt;**](Statuslike.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="readTeamOneExpcat"></a>
# **readTeamOneExpcat**
> Statuslike readTeamOneExpcat(id, subid)

Read a category.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ExperimentsCategoriesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ExperimentsCategoriesApi apiInstance = new ExperimentsCategoriesApi();
Integer id = 56; // Integer | ID of the team.
Integer subid = 56; // Integer | ID of the category.
try {
    Statuslike result = apiInstance.readTeamOneExpcat(id, subid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExperimentsCategoriesApi#readTeamOneExpcat");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the team. |
 **subid** | **Integer**| ID of the category. |

### Return type

[**Statuslike**](Statuslike.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

