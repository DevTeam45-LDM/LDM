# ExperimentsApi

All URIs are relative to *https://elab.local:3148/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteExperiment**](ExperimentsApi.md#deleteExperiment) | **DELETE** /experiments/{id} | Delete an experiment.
[**getExperiment**](ExperimentsApi.md#getExperiment) | **GET** /experiments/{id} | Read an experiment
[**patchExperiment**](ExperimentsApi.md#patchExperiment) | **PATCH** /experiments/{id} | Modify an experiment
[**postExperiment**](ExperimentsApi.md#postExperiment) | **POST** /experiments | Create an experiment
[**postExperimentById**](ExperimentsApi.md#postExperimentById) | **POST** /experiments/{id} | Duplicate an experiment with its ID
[**readExperiments**](ExperimentsApi.md#readExperiments) | **GET** /experiments | Read all experiments that are accessible

<a name="deleteExperiment"></a>
# **deleteExperiment**
> deleteExperiment(id)

Delete an experiment.

The experiment gets soft-deleted.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ExperimentsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ExperimentsApi apiInstance = new ExperimentsApi();
Integer id = 56; // Integer | ID of the experiment
try {
    apiInstance.deleteExperiment(id);
} catch (ApiException e) {
    System.err.println("Exception when calling ExperimentsApi#deleteExperiment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the experiment |

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="getExperiment"></a>
# **getExperiment**
> Experiment getExperiment(id, format, json, withTitle, size, changelog)

Read an experiment

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ExperimentsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ExperimentsApi apiInstance = new ExperimentsApi();
Integer id = 56; // Integer | ID of the experiment
String format = "json"; // String | Get the entity in a different format like csv, pdf, eln or zip. \"pdfa\" means archive pdf (PDF/A), same with \"zipa\". 
Boolean json = false; // Boolean | Include a full JSON export in the ZIP archive. Only applicable if format is zip(a). 
Boolean withTitle = true; // Boolean | Include the title in the QR code. Only applicable if format is qrpng. 
Integer size = 250; // Integer | Specify the size of the QR code in pixels. Only applicable if format is qrpng. 
Boolean changelog = false; // Boolean | Toggles if the changelog should be included in PDF exports (pdf, pdfa, zip, zipa). Changelog is by default included if the export provides PDF/A, otherwise not. 
try {
    Experiment result = apiInstance.getExperiment(id, format, json, withTitle, size, changelog);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExperimentsApi#getExperiment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the experiment |
 **format** | **String**| Get the entity in a different format like csv, pdf, eln or zip. \&quot;pdfa\&quot; means archive pdf (PDF/A), same with \&quot;zipa\&quot;.  | [optional] [default to json] [enum: csv, eln, json, qrpdf, qrpng, pdf, pdfa, zip, zipa]
 **json** | **Boolean**| Include a full JSON export in the ZIP archive. Only applicable if format is zip(a).  | [optional] [default to false]
 **withTitle** | **Boolean**| Include the title in the QR code. Only applicable if format is qrpng.  | [optional] [default to true]
 **size** | **Integer**| Specify the size of the QR code in pixels. Only applicable if format is qrpng.  | [optional] [default to 250]
 **changelog** | **Boolean**| Toggles if the changelog should be included in PDF exports (pdf, pdfa, zip, zipa). Changelog is by default included if the export provides PDF/A, otherwise not.  | [optional] [default to false]

### Return type

[**Experiment**](Experiment.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="patchExperiment"></a>
# **patchExperiment**
> Experiment patchExperiment(id, body)

Modify an experiment

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ExperimentsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ExperimentsApi apiInstance = new ExperimentsApi();
Integer id = 56; // Integer | ID of the experiment
ExperimentsIdBody1 body = new ExperimentsIdBody1(); // ExperimentsIdBody1 | Parameters for patching an experiment
try {
    Experiment result = apiInstance.patchExperiment(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExperimentsApi#patchExperiment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the experiment |
 **body** | [**ExperimentsIdBody1**](ExperimentsIdBody1.md)| Parameters for patching an experiment | [optional]

### Return type

[**Experiment**](Experiment.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postExperiment"></a>
# **postExperiment**
> postExperiment(body)

Create an experiment

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ExperimentsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ExperimentsApi apiInstance = new ExperimentsApi();
ExperimentsBody body = new ExperimentsBody(); // ExperimentsBody | Parameters for creating an experiment
try {
    apiInstance.postExperiment(body);
} catch (ApiException e) {
    System.err.println("Exception when calling ExperimentsApi#postExperiment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ExperimentsBody**](ExperimentsBody.md)| Parameters for creating an experiment | [optional]

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="postExperimentById"></a>
# **postExperimentById**
> postExperimentById(id, body)

Duplicate an experiment with its ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ExperimentsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ExperimentsApi apiInstance = new ExperimentsApi();
Integer id = 56; // Integer | The unique identifier of the experiment to duplicate.
ExperimentsIdBody body = new ExperimentsIdBody(); // ExperimentsIdBody | Parameters for duplicating an experiment
try {
    apiInstance.postExperimentById(id, body);
} catch (ApiException e) {
    System.err.println("Exception when calling ExperimentsApi#postExperimentById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The unique identifier of the experiment to duplicate. |
 **body** | [**ExperimentsIdBody**](ExperimentsIdBody.md)| Parameters for duplicating an experiment | [optional]

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="readExperiments"></a>
# **readExperiments**
> List&lt;Experiment&gt; readExperiments(q, extended, related, relatedOrigin, cat, tags, limit, offset, owner, scope, order, sort)

Read all experiments that are accessible

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ExperimentsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ExperimentsApi apiInstance = new ExperimentsApi();
String q = "q_example"; // String | Search for a term in title, body or elabid. 
String extended = "extended_example"; // String | Extended search (advanced query). 
Integer related = 56; // Integer | Look only for entries linked to this item id. 
String relatedOrigin = "relatedOrigin_example"; // String | When using the \"related\" query parameter, select the type of the related ID (experiments or items) 
Integer cat = 56; // Integer | The status id of the experiments. 
List<String> tags = Arrays.asList("tags_example"); // List<String> | An array of tags for filtering results containing all of these tags. 
Integer limit = 15; // Integer | Limit the number of results. 
Integer offset = 0; // Integer | Skip a number of results. Use with limit to work the pagination. 
Integer owner = 56; // Integer | Filter results by author (user id) 
Integer scope = 56; // Integer | Set the scope for the results. 1: self, 2: team, 3: everything. It defaults to the user value stored in preferences. 
String order = "order_example"; // String | Change the ordering of the results. 
String sort = "sort_example"; // String | Change the sorting of results: ascending or descending. 
try {
    List<Experiment> result = apiInstance.readExperiments(q, extended, related, relatedOrigin, cat, tags, limit, offset, owner, scope, order, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExperimentsApi#readExperiments");
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
 **cat** | **Integer**| The status id of the experiments.  | [optional]
 **tags** | [**List&lt;String&gt;**](String.md)| An array of tags for filtering results containing all of these tags.  | [optional]
 **limit** | **Integer**| Limit the number of results.  | [optional] [default to 15]
 **offset** | **Integer**| Skip a number of results. Use with limit to work the pagination.  | [optional] [default to 0]
 **owner** | **Integer**| Filter results by author (user id)  | [optional]
 **scope** | **Integer**| Set the scope for the results. 1: self, 2: team, 3: everything. It defaults to the user value stored in preferences.  | [optional] [enum: 1, 2, 3]
 **order** | **String**| Change the ordering of the results.  | [optional] [enum: cat, comment, customid, date, id, lastchange, rating, status, title, user]
 **sort** | **String**| Change the sorting of results: ascending or descending.  | [optional] [enum: asc, desc]

### Return type

[**List&lt;Experiment&gt;**](Experiment.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

