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
 * Upload
 */

@Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2024-11-15T12:02:45.960786319Z[GMT]")

public class Upload {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("real_name")
  private String realName = null;

  @SerializedName("long_name")
  private String longName = null;

  @SerializedName("comment")
  private String comment = null;

  @SerializedName("item_id")
  private Integer itemId = null;

  @SerializedName("userid")
  private String userid = null;

  @SerializedName("type")
  private String type = null;

  @SerializedName("created_at")
  private String createdAt = null;

  @SerializedName("hash")
  private String hash = null;

  @SerializedName("hash_algorithm")
  private String hashAlgorithm = null;

  @SerializedName("storage")
  private Integer storage = null;

  @SerializedName("filesize")
  private Integer filesize = null;

  @SerializedName("state")
  private Integer state = null;

  @SerializedName("immutable")
  private Integer immutable = null;

  @SerializedName("fullname")
  private String fullname = null;

  public Upload id(Integer id) {
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

  public Upload realName(String realName) {
    this.realName = realName;
    return this;
  }

   /**
   * Get realName
   * @return realName
  **/
  @Schema(description = "")
  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public Upload longName(String longName) {
    this.longName = longName;
    return this;
  }

   /**
   * Get longName
   * @return longName
  **/
  @Schema(description = "")
  public String getLongName() {
    return longName;
  }

  public void setLongName(String longName) {
    this.longName = longName;
  }

  public Upload comment(String comment) {
    this.comment = comment;
    return this;
  }

   /**
   * Get comment
   * @return comment
  **/
  @Schema(description = "")
  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Upload itemId(Integer itemId) {
    this.itemId = itemId;
    return this;
  }

   /**
   * Get itemId
   * @return itemId
  **/
  @Schema(description = "")
  public Integer getItemId() {
    return itemId;
  }

  public void setItemId(Integer itemId) {
    this.itemId = itemId;
  }

  public Upload userid(String userid) {
    this.userid = userid;
    return this;
  }

   /**
   * Get userid
   * @return userid
  **/
  @Schema(description = "")
  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }

  public Upload type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @Schema(description = "")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Upload createdAt(String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Get createdAt
   * @return createdAt
  **/
  @Schema(description = "")
  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public Upload hash(String hash) {
    this.hash = hash;
    return this;
  }

   /**
   * Get hash
   * @return hash
  **/
  @Schema(description = "")
  public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }

  public Upload hashAlgorithm(String hashAlgorithm) {
    this.hashAlgorithm = hashAlgorithm;
    return this;
  }

   /**
   * Get hashAlgorithm
   * @return hashAlgorithm
  **/
  @Schema(description = "")
  public String getHashAlgorithm() {
    return hashAlgorithm;
  }

  public void setHashAlgorithm(String hashAlgorithm) {
    this.hashAlgorithm = hashAlgorithm;
  }

  public Upload storage(Integer storage) {
    this.storage = storage;
    return this;
  }

   /**
   * Get storage
   * @return storage
  **/
  @Schema(description = "")
  public Integer getStorage() {
    return storage;
  }

  public void setStorage(Integer storage) {
    this.storage = storage;
  }

  public Upload filesize(Integer filesize) {
    this.filesize = filesize;
    return this;
  }

   /**
   * Get filesize
   * @return filesize
  **/
  @Schema(description = "")
  public Integer getFilesize() {
    return filesize;
  }

  public void setFilesize(Integer filesize) {
    this.filesize = filesize;
  }

  public Upload state(Integer state) {
    this.state = state;
    return this;
  }

   /**
   * Get state
   * @return state
  **/
  @Schema(description = "")
  public Integer getState() {
    return state;
  }

  public void setState(Integer state) {
    this.state = state;
  }

  public Upload immutable(Integer immutable) {
    this.immutable = immutable;
    return this;
  }

   /**
   * Get immutable
   * @return immutable
  **/
  @Schema(description = "")
  public Integer getImmutable() {
    return immutable;
  }

  public void setImmutable(Integer immutable) {
    this.immutable = immutable;
  }

  public Upload fullname(String fullname) {
    this.fullname = fullname;
    return this;
  }

   /**
   * Get fullname
   * @return fullname
  **/
  @Schema(description = "")
  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Upload upload = (Upload) o;
    return Objects.equals(this.id, upload.id) &&
        Objects.equals(this.realName, upload.realName) &&
        Objects.equals(this.longName, upload.longName) &&
        Objects.equals(this.comment, upload.comment) &&
        Objects.equals(this.itemId, upload.itemId) &&
        Objects.equals(this.userid, upload.userid) &&
        Objects.equals(this.type, upload.type) &&
        Objects.equals(this.createdAt, upload.createdAt) &&
        Objects.equals(this.hash, upload.hash) &&
        Objects.equals(this.hashAlgorithm, upload.hashAlgorithm) &&
        Objects.equals(this.storage, upload.storage) &&
        Objects.equals(this.filesize, upload.filesize) &&
        Objects.equals(this.state, upload.state) &&
        Objects.equals(this.immutable, upload.immutable) &&
        Objects.equals(this.fullname, upload.fullname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, realName, longName, comment, itemId, userid, type, createdAt, hash, hashAlgorithm, storage, filesize, state, immutable, fullname);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Upload {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    realName: ").append(toIndentedString(realName)).append("\n");
    sb.append("    longName: ").append(toIndentedString(longName)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    itemId: ").append(toIndentedString(itemId)).append("\n");
    sb.append("    userid: ").append(toIndentedString(userid)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    hash: ").append(toIndentedString(hash)).append("\n");
    sb.append("    hashAlgorithm: ").append(toIndentedString(hashAlgorithm)).append("\n");
    sb.append("    storage: ").append(toIndentedString(storage)).append("\n");
    sb.append("    filesize: ").append(toIndentedString(filesize)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    immutable: ").append(toIndentedString(immutable)).append("\n");
    sb.append("    fullname: ").append(toIndentedString(fullname)).append("\n");
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