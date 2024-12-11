# UsersBody

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**firstname** | **String** | User&#x27;s first name. | 
**lastname** | **String** | User&#x27;s last name. | 
**email** | **String** | User&#x27;s email address. | 
**team** | **Integer** | The team id. |  [optional]
**validUntil** | **String** | Date in the YYYY-MM-DD format for account expiration date. |  [optional]
**orgid** | **String** | Internal id. |  [optional]
**usergroup** | [**UsergroupEnum**](#UsergroupEnum) | Which permissions level the user will get? &#x60;1&#x60; is Sysadmin, &#x60;2&#x60; is Admin, &#x60;4&#x60; is user (default) |  [optional]

<a name="UsergroupEnum"></a>
## Enum: UsergroupEnum
Name | Value
---- | -----
NUMBER_1 | 1
NUMBER_2 | 2
NUMBER_4 | 4
