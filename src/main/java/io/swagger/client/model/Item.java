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
import io.swagger.client.model.Comment;
import io.swagger.client.model.Entity;
import io.swagger.client.model.ExclusiveEditMode;
import io.swagger.client.model.Link;
import io.swagger.client.model.Step;
import io.swagger.client.model.Upload;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.processing.Generated;
import java.io.IOException;
import java.util.List;
/**
 * Item
 */

@Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2024-11-15T12:02:45.960786319Z[GMT]")

public class Item extends Entity implements ItemsIdBody1 {
  @SerializedName("is_bookable")
  private Integer isBookable = null;

  @SerializedName("canbook")
  private String canbook = null;

  @SerializedName("book_max_minutes")
  private Integer bookMaxMinutes = null;

  @SerializedName("book_max_slots")
  private Integer bookMaxSlots = null;

  @SerializedName("book_can_overlap")
  private Integer bookCanOverlap = null;

  @SerializedName("book_users_can_in_past")
  private Integer bookUsersCanInPast = null;

  @SerializedName("book_is_cancellable")
  private Integer bookIsCancellable = null;

  @SerializedName("book_cancel_minutes")
  private Integer bookCancelMinutes = null;

  public Item isBookable(Integer isBookable) {
    this.isBookable = isBookable;
    return this;
  }

   /**
   * Get isBookable
   * @return isBookable
  **/
  @Schema(description = "")
  public Integer getIsBookable() {
    return isBookable;
  }

  public void setIsBookable(Integer isBookable) {
    this.isBookable = isBookable;
  }

  public Item canbook(String canbook) {
    this.canbook = canbook;
    return this;
  }

   /**
   * Get canbook
   * @return canbook
  **/
  @Schema(description = "")
  public String getCanbook() {
    return canbook;
  }

  public void setCanbook(String canbook) {
    this.canbook = canbook;
  }

  public Item bookMaxMinutes(Integer bookMaxMinutes) {
    this.bookMaxMinutes = bookMaxMinutes;
    return this;
  }

   /**
   * Get bookMaxMinutes
   * @return bookMaxMinutes
  **/
  @Schema(description = "")
  public Integer getBookMaxMinutes() {
    return bookMaxMinutes;
  }

  public void setBookMaxMinutes(Integer bookMaxMinutes) {
    this.bookMaxMinutes = bookMaxMinutes;
  }

  public Item bookMaxSlots(Integer bookMaxSlots) {
    this.bookMaxSlots = bookMaxSlots;
    return this;
  }

   /**
   * Get bookMaxSlots
   * @return bookMaxSlots
  **/
  @Schema(description = "")
  public Integer getBookMaxSlots() {
    return bookMaxSlots;
  }

  public void setBookMaxSlots(Integer bookMaxSlots) {
    this.bookMaxSlots = bookMaxSlots;
  }

  public Item bookCanOverlap(Integer bookCanOverlap) {
    this.bookCanOverlap = bookCanOverlap;
    return this;
  }

   /**
   * Get bookCanOverlap
   * @return bookCanOverlap
  **/
  @Schema(description = "")
  public Integer getBookCanOverlap() {
    return bookCanOverlap;
  }

  public void setBookCanOverlap(Integer bookCanOverlap) {
    this.bookCanOverlap = bookCanOverlap;
  }

  public Item bookUsersCanInPast(Integer bookUsersCanInPast) {
    this.bookUsersCanInPast = bookUsersCanInPast;
    return this;
  }

   /**
   * Get bookUsersCanInPast
   * @return bookUsersCanInPast
  **/
  @Schema(description = "")
  public Integer getBookUsersCanInPast() {
    return bookUsersCanInPast;
  }

  public void setBookUsersCanInPast(Integer bookUsersCanInPast) {
    this.bookUsersCanInPast = bookUsersCanInPast;
  }

  public Item bookIsCancellable(Integer bookIsCancellable) {
    this.bookIsCancellable = bookIsCancellable;
    return this;
  }

   /**
   * Get bookIsCancellable
   * @return bookIsCancellable
  **/
  @Schema(description = "")
  public Integer getBookIsCancellable() {
    return bookIsCancellable;
  }

  public void setBookIsCancellable(Integer bookIsCancellable) {
    this.bookIsCancellable = bookIsCancellable;
  }

  public Item bookCancelMinutes(Integer bookCancelMinutes) {
    this.bookCancelMinutes = bookCancelMinutes;
    return this;
  }

   /**
   * Get bookCancelMinutes
   * @return bookCancelMinutes
  **/
  @Schema(description = "")
  public Integer getBookCancelMinutes() {
    return bookCancelMinutes;
  }

  public void setBookCancelMinutes(Integer bookCancelMinutes) {
    this.bookCancelMinutes = bookCancelMinutes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Item item = (Item) o;
    return Objects.equals(this.isBookable, item.isBookable) &&
        Objects.equals(this.canbook, item.canbook) &&
        Objects.equals(this.bookMaxMinutes, item.bookMaxMinutes) &&
        Objects.equals(this.bookMaxSlots, item.bookMaxSlots) &&
        Objects.equals(this.bookCanOverlap, item.bookCanOverlap) &&
        Objects.equals(this.bookUsersCanInPast, item.bookUsersCanInPast) &&
        Objects.equals(this.bookIsCancellable, item.bookIsCancellable) &&
        Objects.equals(this.bookCancelMinutes, item.bookCancelMinutes) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isBookable, canbook, bookMaxMinutes, bookMaxSlots, bookCanOverlap, bookUsersCanInPast, bookIsCancellable, bookCancelMinutes, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Item {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    isBookable: ").append(toIndentedString(isBookable)).append("\n");
    sb.append("    canbook: ").append(toIndentedString(canbook)).append("\n");
    sb.append("    bookMaxMinutes: ").append(toIndentedString(bookMaxMinutes)).append("\n");
    sb.append("    bookMaxSlots: ").append(toIndentedString(bookMaxSlots)).append("\n");
    sb.append("    bookCanOverlap: ").append(toIndentedString(bookCanOverlap)).append("\n");
    sb.append("    bookUsersCanInPast: ").append(toIndentedString(bookUsersCanInPast)).append("\n");
    sb.append("    bookIsCancellable: ").append(toIndentedString(bookIsCancellable)).append("\n");
    sb.append("    bookCancelMinutes: ").append(toIndentedString(bookCancelMinutes)).append("\n");
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