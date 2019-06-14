package com.jsystems.qa2.api.model.device;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Device {
    public String type;

    @JsonProperty(value = "device.model", required = true)
    public List<DeviceModel> deviceModel;
}
