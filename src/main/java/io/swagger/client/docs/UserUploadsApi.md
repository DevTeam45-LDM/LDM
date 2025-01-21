# UserUploadsApi

All URIs are relative to *https://elab.local:3148/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**readUserUploads**](UserUploadsApi.md#readUserUploads) | **GET** /users/{id}/uploads | Read attached files from a user

<a name="readUserUploads"></a>
# **readUserUploads**
> List&lt;InlineResponse2007&gt; readUserUploads(id)

Read attached files from a user

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UserUploadsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

UserUploadsApi apiInstance = new UserUploadsApi();
Id2 id = new Id2(); // Id2 | ID of the user or `me`.
try {
    List<InlineResponse2007> result = apiInstance.readUserUploads(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserUploadsApi#readUserUploads");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | [**Id2**](.md)| ID of the user or &#x60;me&#x60;. |

### Return type

[**List&lt;InlineResponse2007&gt;**](InlineResponse2007.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

