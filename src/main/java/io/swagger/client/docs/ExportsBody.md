# ExportsBody

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**format** | [**FormatEnum**](#FormatEnum) | File format for the export | 
**experiments** | **String** | Set to \&quot;on\&quot; to include experiments in the export |  [optional]
**items** | **String** | Set to \&quot;on\&quot; to include resources in the export |  [optional]
**experimentsTemplates** | **String** | Set to \&quot;on\&quot; to include experiments templates in the export |  [optional]
**itemsTypes** | **String** | Set to \&quot;on\&quot; to include resources categories in the export |  [optional]
**changelog** | **String** | Set to \&quot;on\&quot; to include the changelog in PDF files |  [optional]
**json** | **String** | Set to \&quot;on\&quot; to include a full JSON export in the ZIP archives |  [optional]
**pdfa** | **String** | Set to \&quot;on\&quot; to create PDF files with the PDF/A specification |  [optional]

<a name="FormatEnum"></a>
## Enum: FormatEnum
Name | Value
---- | -----
CSV | &quot;csv&quot;
ELN | &quot;eln&quot;
JSON | &quot;json&quot;
PDF | &quot;pdf&quot;
ZIP | &quot;zip&quot;
