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
 * IdItemsStatusBody
 */

@Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2024-11-15T12:02:45.960786319Z[GMT]")

public class IdItemsStatusBody {
  @SerializedName("name")
  private String name = null;

  @SerializedName("color")
  private String color = null;

  @SerializedName("default")
  private Integer _default = null;

  public IdItemsStatusBody name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Status name
   * @return name
  **/
  @Schema(description = "Status name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public IdItemsStatusBody color(String color) {
    this.color = color;
    return this;
  }

   /**
   * Hex color without leading \\#. 
   * @return color
  **/
  @Schema(description = "Hex color without leading \\#. ")
  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public IdItemsStatusBody _default(Integer _default) {
    this._default = _default;
    return this;
  }

   /**
   * Is it the default status for the team?
   * @return _default
  **/
  @Schema(description = "Is it the default status for the team?")
  public Integer getDefault() {
    return _default;
  }

  public void setDefault(Integer _default) {
    this._default = _default;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdItemsStatusBody idItemsStatusBody = (IdItemsStatusBody) o;
    return Objects.equals(this.name, idItemsStatusBody.name) &&
        Objects.equals(this.color, idItemsStatusBody.color) &&
        Objects.equals(this._default, idItemsStatusBody._default);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, color, _default);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdItemsStatusBody {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
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