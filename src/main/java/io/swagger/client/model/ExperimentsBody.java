package io.swagger.client.model;

import java.util.Objects;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public class ExperimentsBody {

  @JsonProperty("title")
  private String title;

  @JsonProperty("body")
  private String body;

  @JsonProperty("tags")
  private List<String> tags = null;

  @JsonProperty("metadata")
  private String metadata;

  @JsonProperty("template")
  private String template;

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

  public ExperimentsBody tags(List<String> tags) {
    this.tags = tags;
    return this;
  }

  public ExperimentsBody addTagsItem(String tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<String>();
    }
    this.tags.add(tagsItem);
    return this;
  }

  @Schema(description = "An array of tags to assign to the created entry.")
  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
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

  public ExperimentsBody template(String template) {
    this.template = template;
    return this;
  }

  @Schema(description = "The template used for the experiment.")
  public String getTemplate() {
    return template;
  }

  public void setTemplate(String template) {
    this.template = template;
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
            Objects.equals(this.metadata, experimentsBody.metadata) &&
            Objects.equals(this.template, experimentsBody.template);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, body, tags, metadata, template);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    template: ").append(toIndentedString(template)).append("\n");
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