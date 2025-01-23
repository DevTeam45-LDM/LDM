# UnfinishedStepsApi

All URIs are relative to *https://elab.local:3148/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**readUnfinishedSteps**](UnfinishedStepsApi.md#readUnfinishedSteps) | **GET** /unfinished_steps | Read all unfinished steps.

<a name="readUnfinishedSteps"></a>
# **readUnfinishedSteps**
> List&lt;UnfinishedSteps&gt; readUnfinishedSteps(scope)

Read all unfinished steps.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UnfinishedStepsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

UnfinishedStepsApi apiInstance = new UnfinishedStepsApi();
String scope = "user"; // String | Set to \"team\" to extend the list to other members. 
try {
    List<UnfinishedSteps> result = apiInstance.readUnfinishedSteps(scope);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UnfinishedStepsApi#readUnfinishedSteps");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **scope** | **String**| Set to \&quot;team\&quot; to extend the list to other members.  | [optional] [default to user] [enum: team, user]

### Return type

[**List&lt;UnfinishedSteps&gt;**](UnfinishedSteps.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

