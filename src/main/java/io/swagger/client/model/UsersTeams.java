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
 * UsersTeams
 */

@Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2024-11-15T12:02:45.960786319Z[GMT]")

public class UsersTeams {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("usergroup")
  private Integer usergroup = null;

  @SerializedName("is_owner")
  private Integer isOwner = null;

  public UsersTeams id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @Schema(description = "")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public UsersTeams name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @Schema(description = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UsersTeams usergroup(Integer usergroup) {
    this.usergroup = usergroup;
    return this;
  }

   /**
   * Get usergroup
   * @return usergroup
  **/
  @Schema(description = "")
  public Integer getUsergroup() {
    return usergroup;
  }

  public void setUsergroup(Integer usergroup) {
    this.usergroup = usergroup;
  }

  public UsersTeams isOwner(Integer isOwner) {
    this.isOwner = isOwner;
    return this;
  }

   /**
   * Get isOwner
   * @return isOwner
  **/
  @Schema(description = "")
  public Integer getIsOwner() {
    return isOwner;
  }

  public void setIsOwner(Integer isOwner) {
    this.isOwner = isOwner;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UsersTeams usersTeams = (UsersTeams) o;
    return Objects.equals(this.id, usersTeams.id) &&
        Objects.equals(this.name, usersTeams.name) &&
        Objects.equals(this.usergroup, usersTeams.usergroup) &&
        Objects.equals(this.isOwner, usersTeams.isOwner);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, usergroup, isOwner);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UsersTeams {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    usergroup: ").append(toIndentedString(usergroup)).append("\n");
    sb.append("    isOwner: ").append(toIndentedString(isOwner)).append("\n");
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