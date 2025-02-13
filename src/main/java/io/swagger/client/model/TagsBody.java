package io.swagger.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

public class TagsBody {
    @JsonProperty("tag")
    private String tag;

    @JsonProperty("is_favorite")
    private Integer isFavorite;

    public TagsBody tag(String tag) {
        this.tag = tag;
        return this;
    }

    /**
     * Get tag
     * @return tag
     **/
    @Schema(description = "")
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public TagsBody isFavorite(Integer isFavorite) {
        this.isFavorite = isFavorite;
        return this;
    }

    /**
     * Get isFavorite
     * @return isFavorite
     **/
    @Schema(description = "")
    public Integer getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Integer isFavorite) {
        this.isFavorite = isFavorite;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tag tag = (Tag) o;
        return Objects.equals(this.getTag(), tag.getTag()) &&
                Objects.equals(this.getIsFavorite(), tag.getIsFavorite());
    }

    @Override
    public int hashCode() {
        return Objects.hash(tag, isFavorite);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("    tag: ").append(toIndentedString(getTag())).append("\n");
        sb.append("    isFavorite: ").append(toIndentedString(getIsFavorite())).append("\n");
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
