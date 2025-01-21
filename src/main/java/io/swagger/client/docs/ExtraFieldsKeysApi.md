# ExtraFieldsKeysApi

All URIs are relative to *https://elab.local:3148/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**extraFieldsKeys**](ExtraFieldsKeysApi.md#extraFieldsKeys) | **GET** /extra_fields_keys | Read extra fields keys.

<a name="extraFieldsKeys"></a>
# **extraFieldsKeys**
> List&lt;ExtraFieldsKeys&gt; extraFieldsKeys(q, limit)

Read extra fields keys.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ExtraFieldsKeysApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

ExtraFieldsKeysApi apiInstance = new ExtraFieldsKeysApi();
String q = ""; // String | Search for a term in the extra fields keys. 
Integer limit = 0; // Integer | Number of extra fields keys that will be returned. Value >= -1; -1: no limit, 0: users default setting from UCP. 
try {
    List<ExtraFieldsKeys> result = apiInstance.extraFieldsKeys(q, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExtraFieldsKeysApi#extraFieldsKeys");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **q** | **String**| Search for a term in the extra fields keys.  | [optional]
 **limit** | **Integer**| Number of extra fields keys that will be returned. Value &gt;&#x3D; -1; -1: no limit, 0: users default setting from UCP.  | [optional] [default to 0]

### Return type

[**List&lt;ExtraFieldsKeys&gt;**](ExtraFieldsKeys.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

