package io.swagger.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SlopeAdjust {
    @JsonProperty("_SlopeAdjustOn")
    private Integer slopeAdjustOn;

    @JsonProperty("_intSlopeStart")
    private Integer intSlopeStart;

    @JsonProperty("_intSlopeEnd")
    private Integer intSlopeEnd;

    public Integer getSlopeAdjustOn() {
        return slopeAdjustOn;
    }

    public void setSlopeAdjustOn(Integer slopeAdjustOn) {
        this.slopeAdjustOn = slopeAdjustOn;
    }

    public Integer getIntSlopeStart() {
        return intSlopeStart;
    }

    public void setIntSlopeStart(Integer intSlopeStart) {
        this.intSlopeStart = intSlopeStart;
    }

    public Integer getIntSlopeEnd() {
        return intSlopeEnd;
    }

    public void setIntSlopeEnd(Integer intSlopeEnd) {
        this.intSlopeEnd = intSlopeEnd;
    }
}
