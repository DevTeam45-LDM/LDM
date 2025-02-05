package io.swagger.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class MeasureInfo {

    @JsonProperty("_shot")
    private Integer shot;

    @JsonProperty("_energy")
    private Double energy;

    @JsonProperty("_target")
    private Double target;

    @JsonProperty("_N")
    private Double n;

    @JsonProperty("_A")
    private Double a;

    @JsonProperty("_FullSine")
    private Double fullSine;

    @JsonProperty("_date")
    private String date;

    @JsonProperty("_time")
    private String time;

    @JsonProperty("_Operator")
    private String operator;

    @JsonProperty("_Remarks")
    private String remarks;

    // Getters and setters
    public Integer getShot() {
        return shot;
    }

    public void setShot(Integer shot) {
        this.shot = shot;
    }

    public Double getEnergy() {
        return energy;
    }

    public void setEnergy(Double energy) {
        this.energy = energy;
    }

    public Double getTarget() {
        return target;
    }

    public void setTarget(Double target) {
        this.target = target;
    }

    public Double getN() {
        return n;
    }

    public void setN(Double n) {
        this.n = n;
    }

    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }

    public Double getFullSine() {
        return fullSine;
    }

    public void setFullSine(Double fullSine) {
        this.fullSine = fullSine;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }



}
