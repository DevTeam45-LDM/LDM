# ImportBody

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**file** | [**File**](File.md) | The file to upload. | 
**entityType** | [**EntityTypeEnum**](#EntityTypeEnum) | The target entity type | 
**category** | **Integer** | The default category ID if no category is defined for a given entry |  [optional]
**canread** | **String** | A JSON string representing read permissions |  [optional]
**canwrite** | **String** | A JSON string representing write permissions |  [optional]

<a name="EntityTypeEnum"></a>
## Enum: EntityTypeEnum
Name | Value
---- | -----
EXPERIMENTS | &quot;experiments&quot;
ITEMS | &quot;items&quot;
EXPERIMENTS_TEMPLATES | &quot;experiments_templates&quot;
ITEMS_TYPES | &quot;items_types&quot;
