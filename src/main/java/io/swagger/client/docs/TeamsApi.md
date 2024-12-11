# TeamsApi

All URIs are relative to *https://elab.local:3148/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**patchTeam**](TeamsApi.md#patchTeam) | **PATCH** /teams/{id} | Actions on a team. 
[**postTeams**](TeamsApi.md#postTeams) | **POST** /teams | Create a new team.
[**readTeam**](TeamsApi.md#readTeam) | **GET** /teams/{id} | Read a team. Requires Admin permissions.
[**readTeams**](TeamsApi.md#readTeams) | **GET** /teams | Read all teams. Requires Sysadmin permissions.

<a name="patchTeam"></a>
# **patchTeam**
> Team patchTeam(id, body)

Actions on a team. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TeamsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

TeamsApi apiInstance = new TeamsApi();
Id id = new Id(); // Id | ID of the team or `current`.
TeamsIdBody body = new TeamsIdBody(); // TeamsIdBody | Parameters for modifying a team.
try {
    Team result = apiInstance.patchTeam(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TeamsApi#patchTeam");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | [**Id**](.md)| ID of the team or &#x60;current&#x60;. |
 **body** | [**TeamsIdBody**](TeamsIdBody.md)| Parameters for modifying a team. | [optional]

### Return type

[**Team**](Team.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postTeams"></a>
# **postTeams**
> postTeams(body)

Create a new team.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TeamsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

TeamsApi apiInstance = new TeamsApi();
TeamsBody body = new TeamsBody(); // TeamsBody | Parameters for creating a new team.
try {
    apiInstance.postTeams(body);
} catch (ApiException e) {
    System.err.println("Exception when calling TeamsApi#postTeams");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**TeamsBody**](TeamsBody.md)| Parameters for creating a new team. | [optional]

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="readTeam"></a>
# **readTeam**
> Team readTeam(id)

Read a team. Requires Admin permissions.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TeamsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

TeamsApi apiInstance = new TeamsApi();
Id id = new Id(); // Id | ID of the team or `current`.
try {
    Team result = apiInstance.readTeam(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TeamsApi#readTeam");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | [**Id**](.md)| ID of the team or &#x60;current&#x60;. |

### Return type

[**Team**](Team.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="readTeams"></a>
# **readTeams**
> List&lt;Team&gt; readTeams()

Read all teams. Requires Sysadmin permissions.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TeamsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

TeamsApi apiInstance = new TeamsApi();
try {
    List<Team> result = apiInstance.readTeams();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TeamsApi#readTeams");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Team&gt;**](Team.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

