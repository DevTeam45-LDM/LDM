package io.swagger.client.model;

import java.util.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public class ExperimentsBody {

  @JsonProperty("title")
  private String title;

  @JsonProperty("body")
  private String body;

  @JsonProperty("tags")
  private ArrayList<String> tags = null;

  @JsonProperty("metadata")
  private String metadata;

  public ExperimentsBody title(String title) {
    this.title = title;
    return this;
  }

  @Schema(description = "The title of the experiment.")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ExperimentsBody body(String body) {
    this.body = body;
    return this;
  }

  @Schema(description = "The body content of the experiment.")
  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public ExperimentsBody tags(ArrayList<String> tags) {
    this.tags = tags;
    return this;
  }

  public ExperimentsBody tags(String tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<>();
    }
    this.tags.add(tagsItem);
    return this;
  }

  @Schema(description = "An array of tags to assign to the created entry.")
  public List<String> getTags() {
    return tags;
  }

  public void setTags(ArrayList<String> tags) {
    this.tags = tags;
  }

  public ExperimentsBody metadata(String metadata) {
    this.metadata = metadata;
    return this;
  }

  @Schema(description = "Metadata for the experiment.")
  public String getMetadata() {
    return metadata;
  }

  public void setMetadata(String metadata) {
    this.metadata = metadata;
  }

  public Experiment toExperiment(){
    String tagsString = null;
    if (this.tags != null && !this.tags.isEmpty()) {
      StringJoiner joiner = new StringJoiner(",");
      for (String tag : this.tags) {
        joiner.add(tag);
      }
      tagsString = joiner.toString();
    }
    return  new Experiment().title(this.title)
            .body(this.body)
            .tags(tagsString)
            .metadata(this.metadata);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExperimentsBody experimentsBody = (ExperimentsBody) o;
    return Objects.equals(this.title, experimentsBody.title) &&
            Objects.equals(this.body, experimentsBody.body) &&
            Objects.equals(this.tags, experimentsBody.tags) &&
            Objects.equals(this.metadata, experimentsBody.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, body, tags, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    //if(this.title != null && !title.isEmpty()){
      sb.append("    title: ").append(toIndentedString(title)).append("\n");
    //}
    //if(this.body != null && !body.isEmpty()) {
      sb.append("    body: ").append(toIndentedString(body)).append("\n");
    //}
    //if(this.tags != null && !tags.isEmpty()) {
      sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    //}
    //if(this.metadata != null && !metadata.isEmpty()){
      sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    //}
    sb.append("}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}