package com.jsystems.qa2.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Device {
    public String type;

    @JsonProperty(value = "device.model", required = true)
    List<Device> deviceModel;
}
