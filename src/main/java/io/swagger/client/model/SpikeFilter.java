package io.swagger.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SpikeFilter {
    @JsonProperty("_NoseFilter")
    private Integer noseFilter;

    @JsonProperty("_TailFilter")
    private Integer tailFilter;

    public Integer getNoseFilter() {
        return noseFilter;
    }

    public void setNoseFilter(Integer noseFilter) {
        this.noseFilter = noseFilter;
    }

    public Integer getTailFilter() {
        return tailFilter;
    }

    public void setTailFilter(Integer tailFilter) {
        this.tailFilter = tailFilter;
    }
}
