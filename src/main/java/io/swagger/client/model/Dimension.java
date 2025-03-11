package io.swagger.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Dimension {

    @JsonProperty("_volume")
    private Double volume;

    @JsonProperty("_shape")
    private String shape;

    @JsonProperty("_Dim1")
    private Double dim1;

    @JsonProperty("_Dim2")
    private Double dim2;

    @JsonProperty("_Dim3")
    private Double dim3;

    @JsonProperty("_Dim4")
    private Double dim4;

    @JsonProperty("_Dim5")
    private Double dim5;

    @JsonProperty("_Dim6")
    private Double dim6;

    // Getters and setters

    /**
     * Get volume
     * @return volume
     */
    public Double getVolume() {
        return volume;
    }

    /**
     * Set volume
     * @param volume
     */
    public void setVolume(Double volume) {
        this.volume = volume;
    }

    /**
     * Get shape
     * @return shape
     */
    public String getShape() {
        return shape;
    }

    /**
     * Set shape
     * @param shape
     */
    public void setShape(String shape) {
        this.shape = shape;
    }

    /**
     * Get dim1
     * @return dim1
     */
    public Double getDim1() {
        return dim1;
    }

    /**
     * Set dim1
     * @param dim1
     */
    public void setDim1(Double dim1) {
        this.dim1 = dim1;
    }

    /**
     * Get dim2
     * @return dim2
     */
    public Double getDim2() {
        return dim2;
    }

    /**
     * Set dim2
     * @param dim2
     */
    public void setDim2(Double dim2) {
        this.dim2 = dim2;
    }

    /**
     * Get dim3
     * @return dim3
     */
    public Double getDim3() {
        return dim3;
    }

    /**
     * Set dim3
     * @param dim3
     */
    public void setDim3(Double dim3) {
        this.dim3 = dim3;
    }

    /**
     * Get dim4
     * @return dim4
     */
    public Double getDim4() {
        return dim4;
    }

    /**
     * Set dim4
     * @param dim4
     */
    public void setDim4(Double dim4) {
        this.dim4 = dim4;
    }

    /**
     * Get dim5
     * @return dim5
     */
    public Double getDim5() {
        return dim5;
    }

    /**
     * Set dim5
     * @param dim5
     */
    public void setDim5(Double dim5) {
        this.dim5 = dim5;
    }

    /**
     * Get dim6
     * @return dim6
     */
    public Double getDim6() {
        return dim6;
    }

    /**
     * Set dim6
     * @param dim6
     */
    public void setDim6(Double dim6) {
        this.dim6 = dim6;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dimension dimension = (Dimension) o;

        return volume.equals(dimension.volume) &&
                shape.equals(dimension.shape) &&
                dim1.equals(dimension.dim1) &&
                dim2.equals(dimension.dim2) &&
                dim3.equals(dimension.dim3) &&
                dim4.equals(dimension.dim4) &&
                dim5.equals(dimension.dim5) &&
                dim6.equals(dimension.dim6);
    }

    @Override
    public int hashCode() {
        return Objects.hash(volume, shape, dim1, dim2, dim3, dim4, dim5, dim6);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Dimension {\n");

        sb.append("    volume: ").append(toIndentedString(volume)).append("\n");
        sb.append("    shape: ").append(toIndentedString(shape)).append("\n");
        sb.append("    dim1: ").append(toIndentedString(dim1)).append("\n");
        sb.append("    dim2: ").append(toIndentedString(dim2)).append("\n");
        sb.append("    dim3: ").append(toIndentedString(dim3)).append("\n");
        sb.append("    dim4: ").append(toIndentedString(dim4)).append("\n");
        sb.append("    dim5: ").append(toIndentedString(dim5)).append("\n");
        sb.append("    dim6: ").append(toIndentedString(dim6)).append("\n");
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
