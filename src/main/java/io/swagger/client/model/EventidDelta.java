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
 * The difference (delta) of time with the previous value.
 */
@Schema(description = "The difference (delta) of time with the previous value.")
@Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2024-11-15T12:02:45.960786319Z[GMT]")

public class EventidDelta {
  @SerializedName("days")
  private Integer days = null;

  @SerializedName("milliseconds")
  private Integer milliseconds = null;

  @SerializedName("months")
  private Integer months = null;

  @SerializedName("years")
  private Integer years = null;

  public EventidDelta days(Integer days) {
    this.days = days;
    return this;
  }

   /**
   * Get days
   * @return days
  **/
  @Schema(description = "")
  public Integer getDays() {
    return days;
  }

  public void setDays(Integer days) {
    this.days = days;
  }

  public EventidDelta milliseconds(Integer milliseconds) {
    this.milliseconds = milliseconds;
    return this;
  }

   /**
   * Get milliseconds
   * @return milliseconds
  **/
  @Schema(description = "")
  public Integer getMilliseconds() {
    return milliseconds;
  }

  public void setMilliseconds(Integer milliseconds) {
    this.milliseconds = milliseconds;
  }

  public EventidDelta months(Integer months) {
    this.months = months;
    return this;
  }

   /**
   * Get months
   * @return months
  **/
  @Schema(description = "")
  public Integer getMonths() {
    return months;
  }

  public void setMonths(Integer months) {
    this.months = months;
  }

  public EventidDelta years(Integer years) {
    this.years = years;
    return this;
  }

   /**
   * Get years
   * @return years
  **/
  @Schema(description = "")
  public Integer getYears() {
    return years;
  }

  public void setYears(Integer years) {
    this.years = years;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventidDelta eventidDelta = (EventidDelta) o;
    return Objects.equals(this.days, eventidDelta.days) &&
        Objects.equals(this.milliseconds, eventidDelta.milliseconds) &&
        Objects.equals(this.months, eventidDelta.months) &&
        Objects.equals(this.years, eventidDelta.years);
  }

  @Override
  public int hashCode() {
    return Objects.hash(days, milliseconds, months, years);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventidDelta {\n");
    
    sb.append("    days: ").append(toIndentedString(days)).append("\n");
    sb.append("    milliseconds: ").append(toIndentedString(milliseconds)).append("\n");
    sb.append("    months: ").append(toIndentedString(months)).append("\n");
    sb.append("    years: ").append(toIndentedString(years)).append("\n");
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