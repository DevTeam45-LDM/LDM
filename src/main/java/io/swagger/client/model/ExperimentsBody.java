package io.swagger.client.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represents the body of a request to create or update an experiment.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExperimentsBody {

  @JsonProperty("title")
  private String title;

  @JsonProperty("body")
  private String body;

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
            Objects.equals(this.metadata, experimentsBody.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, body, metadata);
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