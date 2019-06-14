package com.jsystems.qa2.api.model.device;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeviceModel {
    public String produce;

    @JsonProperty(value = "screen.size", required = true)
    public int screenSize;
}
