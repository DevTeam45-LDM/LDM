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
 * InlineResponse200
 */

@Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2024-11-15T12:02:45.960786319Z[GMT]")

public class InlineResponse200 {
  @SerializedName("elabftw_version")
  private String elabftwVersion = null;

  @SerializedName("elabftw_version_int")
  private Integer elabftwVersionInt = null;

  @SerializedName("ts_balance")
  private Integer tsBalance = null;

  @SerializedName("all_users_count")
  private Integer allUsersCount = null;

  @SerializedName("active_users_count")
  private Integer activeUsersCount = null;

  @SerializedName("items_count")
  private Integer itemsCount = null;

  @SerializedName("teams_count")
  private Integer teamsCount = null;

  @SerializedName("experiments_count")
  private Integer experimentsCount = null;

  @SerializedName("experiments_timestamped_count")
  private Integer experimentsTimestampedCount = null;

  @SerializedName("uploads_filesize_sum")
  private Integer uploadsFilesizeSum = null;

  @SerializedName("uploads_filesize_sum_formatted")
  private String uploadsFilesizeSumFormatted = null;

  public InlineResponse200 elabftwVersion(String elabftwVersion) {
    this.elabftwVersion = elabftwVersion;
    return this;
  }

   /**
   * Current eLabFTW version
   * @return elabftwVersion
  **/
  @Schema(example = "4.8.0", description = "Current eLabFTW version")
  public String getElabftwVersion() {
    return elabftwVersion;
  }

  public void setElabftwVersion(String elabftwVersion) {
    this.elabftwVersion = elabftwVersion;
  }

  public InlineResponse200 elabftwVersionInt(Integer elabftwVersionInt) {
    this.elabftwVersionInt = elabftwVersionInt;
    return this;
  }

   /**
   * Current eLabFTW version as an integer
   * @return elabftwVersionInt
  **/
  @Schema(example = "50102", description = "Current eLabFTW version as an integer")
  public Integer getElabftwVersionInt() {
    return elabftwVersionInt;
  }

  public void setElabftwVersionInt(Integer elabftwVersionInt) {
    this.elabftwVersionInt = elabftwVersionInt;
  }

  public InlineResponse200 tsBalance(Integer tsBalance) {
    this.tsBalance = tsBalance;
    return this;
  }

   /**
   * Number of timestamp tokens left
   * @return tsBalance
  **/
  @Schema(example = "461", description = "Number of timestamp tokens left")
  public Integer getTsBalance() {
    return tsBalance;
  }

  public void setTsBalance(Integer tsBalance) {
    this.tsBalance = tsBalance;
  }

  public InlineResponse200 allUsersCount(Integer allUsersCount) {
    this.allUsersCount = allUsersCount;
    return this;
  }

   /**
   * Total count of all users
   * @return allUsersCount
  **/
  @Schema(example = "389", description = "Total count of all users")
  public Integer getAllUsersCount() {
    return allUsersCount;
  }

  public void setAllUsersCount(Integer allUsersCount) {
    this.allUsersCount = allUsersCount;
  }

  public InlineResponse200 activeUsersCount(Integer activeUsersCount) {
    this.activeUsersCount = activeUsersCount;
    return this;
  }

   /**
   * Total count of active users
   * @return activeUsersCount
  **/
  @Schema(example = "311", description = "Total count of active users")
  public Integer getActiveUsersCount() {
    return activeUsersCount;
  }

  public void setActiveUsersCount(Integer activeUsersCount) {
    this.activeUsersCount = activeUsersCount;
  }

  public InlineResponse200 itemsCount(Integer itemsCount) {
    this.itemsCount = itemsCount;
    return this;
  }

   /**
   * Total count of items
   * @return itemsCount
  **/
  @Schema(example = "666", description = "Total count of items")
  public Integer getItemsCount() {
    return itemsCount;
  }

  public void setItemsCount(Integer itemsCount) {
    this.itemsCount = itemsCount;
  }

  public InlineResponse200 teamsCount(Integer teamsCount) {
    this.teamsCount = teamsCount;
    return this;
  }

   /**
   * Total count of teams
   * @return teamsCount
  **/
  @Schema(example = "18", description = "Total count of teams")
  public Integer getTeamsCount() {
    return teamsCount;
  }

  public void setTeamsCount(Integer teamsCount) {
    this.teamsCount = teamsCount;
  }

  public InlineResponse200 experimentsCount(Integer experimentsCount) {
    this.experimentsCount = experimentsCount;
    return this;
  }

   /**
   * Total count of experiments
   * @return experimentsCount
  **/
  @Schema(example = "10189", description = "Total count of experiments")
  public Integer getExperimentsCount() {
    return experimentsCount;
  }

  public void setExperimentsCount(Integer experimentsCount) {
    this.experimentsCount = experimentsCount;
  }

  public InlineResponse200 experimentsTimestampedCount(Integer experimentsTimestampedCount) {
    this.experimentsTimestampedCount = experimentsTimestampedCount;
    return this;
  }

   /**
   * Total count of experiments with timestamps
   * @return experimentsTimestampedCount
  **/
  @Schema(example = "1601", description = "Total count of experiments with timestamps")
  public Integer getExperimentsTimestampedCount() {
    return experimentsTimestampedCount;
  }

  public void setExperimentsTimestampedCount(Integer experimentsTimestampedCount) {
    this.experimentsTimestampedCount = experimentsTimestampedCount;
  }

  public InlineResponse200 uploadsFilesizeSum(Integer uploadsFilesizeSum) {
    this.uploadsFilesizeSum = uploadsFilesizeSum;
    return this;
  }

   /**
   * Sum of stored filesize in MySQL for all uploads of the instance.
   * @return uploadsFilesizeSum
  **/
  @Schema(example = "25681672", description = "Sum of stored filesize in MySQL for all uploads of the instance.")
  public Integer getUploadsFilesizeSum() {
    return uploadsFilesizeSum;
  }

  public void setUploadsFilesizeSum(Integer uploadsFilesizeSum) {
    this.uploadsFilesizeSum = uploadsFilesizeSum;
  }

  public InlineResponse200 uploadsFilesizeSumFormatted(String uploadsFilesizeSumFormatted) {
    this.uploadsFilesizeSumFormatted = uploadsFilesizeSumFormatted;
    return this;
  }

   /**
   * Sum of stored filesize in MySQL for all uploads of the instance, formatted
   * @return uploadsFilesizeSumFormatted
  **/
  @Schema(example = "24.49 MiB", description = "Sum of stored filesize in MySQL for all uploads of the instance, formatted")
  public String getUploadsFilesizeSumFormatted() {
    return uploadsFilesizeSumFormatted;
  }

  public void setUploadsFilesizeSumFormatted(String uploadsFilesizeSumFormatted) {
    this.uploadsFilesizeSumFormatted = uploadsFilesizeSumFormatted;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse200 inlineResponse200 = (InlineResponse200) o;
    return Objects.equals(this.elabftwVersion, inlineResponse200.elabftwVersion) &&
        Objects.equals(this.elabftwVersionInt, inlineResponse200.elabftwVersionInt) &&
        Objects.equals(this.tsBalance, inlineResponse200.tsBalance) &&
        Objects.equals(this.allUsersCount, inlineResponse200.allUsersCount) &&
        Objects.equals(this.activeUsersCount, inlineResponse200.activeUsersCount) &&
        Objects.equals(this.itemsCount, inlineResponse200.itemsCount) &&
        Objects.equals(this.teamsCount, inlineResponse200.teamsCount) &&
        Objects.equals(this.experimentsCount, inlineResponse200.experimentsCount) &&
        Objects.equals(this.experimentsTimestampedCount, inlineResponse200.experimentsTimestampedCount) &&
        Objects.equals(this.uploadsFilesizeSum, inlineResponse200.uploadsFilesizeSum) &&
        Objects.equals(this.uploadsFilesizeSumFormatted, inlineResponse200.uploadsFilesizeSumFormatted);
  }

  @Override
  public int hashCode() {
    return Objects.hash(elabftwVersion, elabftwVersionInt, tsBalance, allUsersCount, activeUsersCount, itemsCount, teamsCount, experimentsCount, experimentsTimestampedCount, uploadsFilesizeSum, uploadsFilesizeSumFormatted);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");
    
    sb.append("    elabftwVersion: ").append(toIndentedString(elabftwVersion)).append("\n");
    sb.append("    elabftwVersionInt: ").append(toIndentedString(elabftwVersionInt)).append("\n");
    sb.append("    tsBalance: ").append(toIndentedString(tsBalance)).append("\n");
    sb.append("    allUsersCount: ").append(toIndentedString(allUsersCount)).append("\n");
    sb.append("    activeUsersCount: ").append(toIndentedString(activeUsersCount)).append("\n");
    sb.append("    itemsCount: ").append(toIndentedString(itemsCount)).append("\n");
    sb.append("    teamsCount: ").append(toIndentedString(teamsCount)).append("\n");
    sb.append("    experimentsCount: ").append(toIndentedString(experimentsCount)).append("\n");
    sb.append("    experimentsTimestampedCount: ").append(toIndentedString(experimentsTimestampedCount)).append("\n");
    sb.append("    uploadsFilesizeSum: ").append(toIndentedString(uploadsFilesizeSum)).append("\n");
    sb.append("    uploadsFilesizeSumFormatted: ").append(toIndentedString(uploadsFilesizeSumFormatted)).append("\n");
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