# InfoApi

All URIs are relative to *https://elab.local:3148/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getInfo**](InfoApi.md#getInfo) | **GET** /info | Get information about the instance.

<a name="getInfo"></a>
# **getInfo**
> InlineResponse200 getInfo()

Get information about the instance.

Get information about the instance.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.InfoApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

InfoApi apiInstance = new InfoApi();
try {
    InlineResponse200 result = apiInstance.getInfo();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InfoApi#getInfo");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

