package io.swagger.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ValidSubset {

    @JsonProperty("_intStart")
    private Integer intStart;

    @JsonProperty("_intEnd")
    private Integer intEnd;

    @JsonProperty("_intMaxNumOfSamples")
    private Integer intMaxNumOfSamples;

    /**
     * Get intStart
     * @return intStart
     */
    public Integer getIntStart() {
        return intStart;
    }

    /**
     * Set intStart
     * @param intStart
     */
    public void setIntStart(Integer intStart) {
        this.intStart = intStart;
    }

    /**
     * Get intEnd
     * @return intEnd
     */
    public Integer getIntEnd() {
        return intEnd;
    }

    /**
     * Set intEnd
     * @param intEnd
     */
    public void setIntEnd(Integer intEnd) {
        this.intEnd = intEnd;
    }

    /**
     * Get intMaxNumOfSamples
     * @return intMaxNumOfSamples
     */
    public Integer getIntMaxNumOfSamples() {
        return intMaxNumOfSamples;
    }

    /**
     * Set intMaxNumOfSamples
     * @param intMaxNumOfSamples
     */
    public void setIntMaxNumOfSamples(Integer intMaxNumOfSamples) {
        this.intMaxNumOfSamples = intMaxNumOfSamples;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ValidSubset validSubset = (ValidSubset) o;
        return intStart.equals(validSubset.intStart) &&
                intEnd.equals(validSubset.intEnd) &&
                intMaxNumOfSamples.equals(validSubset.intMaxNumOfSamples);
    }

    @Override
    public int hashCode() {
        return Objects.hash(intStart, intEnd, intMaxNumOfSamples);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ValidSubset {\n");
        sb.append("    intStart: ").append(toIndentedString(intStart)).append("\n");
        sb.append("    intEnd: ").append(toIndentedString(intEnd)).append("\n");
        sb.append("    intMaxNumOfSamples: ").append(toIndentedString(intMaxNumOfSamples)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
