# TeamgroupsApi

All URIs are relative to *https://elab.local:3148/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteTeamgroup**](TeamgroupsApi.md#deleteTeamgroup) | **DELETE** /teams/{id}/teamgroups/{subid} | Delete a teamgroup.
[**patchTeamgroup**](TeamgroupsApi.md#patchTeamgroup) | **PATCH** /teams/{id}/teamgroups/{subid} | Modify a teamgroup.
[**postTeamgroups**](TeamgroupsApi.md#postTeamgroups) | **POST** /teams/{id}/teamgroups | Create a new teamgroup.
[**readTeamTeamgroups**](TeamgroupsApi.md#readTeamTeamgroups) | **GET** /teams/{id}/teamgroups | Read teamgroups of a team.
[**readTeamgroup**](TeamgroupsApi.md#readTeamgroup) | **GET** /teams/{id}/teamgroups/{subid} | Read a teamgroup.

<a name="deleteTeamgroup"></a>
# **deleteTeamgroup**
> deleteTeamgroup(id, subid)

Delete a teamgroup.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TeamgroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

TeamgroupsApi apiInstance = new TeamgroupsApi();
Integer id = 56; // Integer | ID of the team.
Integer subid = 56; // Integer | ID of the teamgroup.
try {
    apiInstance.deleteTeamgroup(id, subid);
} catch (ApiException e) {
    System.err.println("Exception when calling TeamgroupsApi#deleteTeamgroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the team. |
 **subid** | **Integer**| ID of the teamgroup. |

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="patchTeamgroup"></a>
# **patchTeamgroup**
> Teamgroup patchTeamgroup(id, subid, body)

Modify a teamgroup.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TeamgroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

TeamgroupsApi apiInstance = new TeamgroupsApi();
Integer id = 56; // Integer | ID of the team.
Integer subid = 56; // Integer | ID of the teamgroup.
TeamgroupsSubidBody body = new TeamgroupsSubidBody(); // TeamgroupsSubidBody | Parameters for modifying a teamgroup.
try {
    Teamgroup result = apiInstance.patchTeamgroup(id, subid, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TeamgroupsApi#patchTeamgroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the team. |
 **subid** | **Integer**| ID of the teamgroup. |
 **body** | [**TeamgroupsSubidBody**](TeamgroupsSubidBody.md)| Parameters for modifying a teamgroup. | [optional]

### Return type

[**Teamgroup**](Teamgroup.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postTeamgroups"></a>
# **postTeamgroups**
> postTeamgroups(id, body)

Create a new teamgroup.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TeamgroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

TeamgroupsApi apiInstance = new TeamgroupsApi();
Integer id = 56; // Integer | ID of the team.
IdTeamgroupsBody body = new IdTeamgroupsBody(); // IdTeamgroupsBody | Parameters for creating a teamgroup.
try {
    apiInstance.postTeamgroups(id, body);
} catch (ApiException e) {
    System.err.println("Exception when calling TeamgroupsApi#postTeamgroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the team. |
 **body** | [**IdTeamgroupsBody**](IdTeamgroupsBody.md)| Parameters for creating a teamgroup. | [optional]

### Return type

null (empty response body)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="readTeamTeamgroups"></a>
# **readTeamTeamgroups**
> List&lt;Teamgroup&gt; readTeamTeamgroups(id)

Read teamgroups of a team.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TeamgroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

TeamgroupsApi apiInstance = new TeamgroupsApi();
Integer id = 56; // Integer | ID of the team.
try {
    List<Teamgroup> result = apiInstance.readTeamTeamgroups(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TeamgroupsApi#readTeamTeamgroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the team. |

### Return type

[**List&lt;Teamgroup&gt;**](Teamgroup.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="readTeamgroup"></a>
# **readTeamgroup**
> InlineResponse2005 readTeamgroup(id, subid)

Read a teamgroup.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TeamgroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: token
ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
token.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//token.setApiKeyPrefix("Token");

TeamgroupsApi apiInstance = new TeamgroupsApi();
Integer id = 56; // Integer | ID of the team.
Integer subid = 56; // Integer | ID of the teamgroup.
try {
    InlineResponse2005 result = apiInstance.readTeamgroup(id, subid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TeamgroupsApi#readTeamgroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the team. |
 **subid** | **Integer**| ID of the teamgroup. |

### Return type

[**InlineResponse2005**](InlineResponse2005.md)

### Authorization

[token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

