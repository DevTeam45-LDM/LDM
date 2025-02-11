package io.swagger.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NumConditioning {
    @JsonProperty("spikeFilter")
    private SpikeFilter spikeFilter;

    @JsonProperty("slopeAdjust")
    private SlopeAdjust slopeAdjust;

    public SpikeFilter getSpikeFilter() {
        return spikeFilter;
    }

    public void setSpikeFilter(SpikeFilter spikeFilter) {
        this.spikeFilter = spikeFilter;
    }

    public SlopeAdjust getSlopeAdjust() {
        return slopeAdjust;
    }

    public void setSlopeAdjust(SlopeAdjust slopeAdjust) {
        this.slopeAdjust = slopeAdjust;
    }
}
