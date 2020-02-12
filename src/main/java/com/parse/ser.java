package com.parse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ser {
    @JsonProperty("getVPPAssetsSrvUrl")
    private String getVPPAssetsSrvUrl;
    @JsonProperty("getVPPAssetsSrvUrl")
    public String getGetVPPAssetsSrvUrl() {
        return getVPPAssetsSrvUrl;
    }
}
