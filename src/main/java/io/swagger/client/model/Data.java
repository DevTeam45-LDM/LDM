package io.swagger.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


public class Data {

    @JsonProperty("_t")
    private Double t;

    @JsonProperty("_h")
    private Double h;

    @JsonProperty("_m")
    private Double m;

    @JsonProperty("_b")
    private Double b;

    // Getters and setters

    /**
     * Get t
     * @return t
     */
    public Double getT() {
        return t;
    }

    /**
     * Set t
     * @param t
     */
    public void setT(Double t) {
        this.t = t;
    }

    /**
     * Get h
     * @return h
     */
    public Double getH() {
        return h;
    }

    /**
     * Set h
     * @param h
     */
    public void setH(Double h) {
        this.h = h;
    }

    /**
     * Get m
     * @return m
     */
    public Double getM() {
        return m;
    }

    /**
     * Set m
     * @param m
     */
    public void setM(Double m) {
        this.m = m;
    }

    /**
     * Get b
     * @return b
     */
    public Double getB() {
        return b;
    }

    /**
     * Set b
     * @param b
     */
    public void setB(Double b) {
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Data data = (Data) o;
        return Double.compare(data.t, t) == 0 &&
               Double.compare(data.h, h) == 0 &&
               Double.compare(data.m, m) == 0 &&
               Double.compare(data.b, b) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(t, h, m, b);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Data {\n");
        sb.append("    t: ").append(toIndentedString(t)).append("\n");
        sb.append("    h: ").append(toIndentedString(h)).append("\n");
        sb.append("    m: ").append(toIndentedString(m)).append("\n");
        sb.append("    b: ").append(toIndentedString(b)).append("\n");
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
