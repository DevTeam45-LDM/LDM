/*
 * eLabFTW REST API v2 Documentation
 * This document describes all available endpoints and methods for eLabFTW's API version 2. 
 *
 * OpenAPI spec version: 2.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.processing.Generated;
import java.io.IOException;
/**
 * InlineResponse2002
 */

@Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2024-11-15T12:02:45.960786319Z[GMT]")

public class InlineResponse2002 {
  @SerializedName("users_id")
  private Integer usersId = null;

  @SerializedName("tags_id")
  private Integer tagsId = null;

  @SerializedName("tag")
  private String tag = null;

  public InlineResponse2002 usersId(Integer usersId) {
    this.usersId = usersId;
    return this;
  }

   /**
   * Get usersId
   * @return usersId
  **/
  @Schema(description = "")
  public Integer getUsersId() {
    return usersId;
  }

  public void setUsersId(Integer usersId) {
    this.usersId = usersId;
  }

  public InlineResponse2002 tagsId(Integer tagsId) {
    this.tagsId = tagsId;
    return this;
  }

   /**
   * Get tagsId
   * @return tagsId
  **/
  @Schema(description = "")
  public Integer getTagsId() {
    return tagsId;
  }

  public void setTagsId(Integer tagsId) {
    this.tagsId = tagsId;
  }

  public InlineResponse2002 tag(String tag) {
    this.tag = tag;
    return this;
  }

   /**
   * Get tag
   * @return tag
  **/
  @Schema(description = "")
  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse2002 inlineResponse2002 = (InlineResponse2002) o;
    return Objects.equals(this.usersId, inlineResponse2002.usersId) &&
        Objects.equals(this.tagsId, inlineResponse2002.tagsId) &&
        Objects.equals(this.tag, inlineResponse2002.tag);
  }

  @Override
  public int hashCode() {
    return Objects.hash(usersId, tagsId, tag);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2002 {\n");
    
    sb.append("    usersId: ").append(toIndentedString(usersId)).append("\n");
    sb.append("    tagsId: ").append(toIndentedString(tagsId)).append("\n");
    sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}