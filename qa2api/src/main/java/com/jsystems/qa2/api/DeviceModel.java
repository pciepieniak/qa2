package com.jsystems.qa2.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeviceModel {
    public String produce;

    @JsonProperty(value = "screen.size", required = true)
    public int screenSize;
}
