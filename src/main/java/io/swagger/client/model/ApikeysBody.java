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
 * ApikeysBody
 */

@Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2024-11-15T12:02:45.960786319Z[GMT]")

public class ApikeysBody {
  @SerializedName("name")
  private String name = "RTFM";

  @SerializedName("canwrite")
  private Integer canwrite = 0;

  public ApikeysBody name(String name) {
    this.name = name;
    return this;
  }

   /**
   * A name for the API key.
   * @return name
  **/
  @Schema(description = "A name for the API key.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ApikeysBody canwrite(Integer canwrite) {
    this.canwrite = canwrite;
    return this;
  }

   /**
   * Set to 1 to allow the key to do write actions.
   * @return canwrite
  **/
  @Schema(description = "Set to 1 to allow the key to do write actions.")
  public Integer getCanwrite() {
    return canwrite;
  }

  public void setCanwrite(Integer canwrite) {
    this.canwrite = canwrite;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApikeysBody apikeysBody = (ApikeysBody) o;
    return Objects.equals(this.name, apikeysBody.name) &&
        Objects.equals(this.canwrite, apikeysBody.canwrite);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, canwrite);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApikeysBody {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    canwrite: ").append(toIndentedString(canwrite)).append("\n");
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