package com.parse;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Asset {

    @JsonProperty("productTypeName")
    private String productTypeName;
    @JsonProperty("productTypeId")
    private Integer productTypeId;
    @JsonProperty("pricingParam")
    private String pricingParam;
    @JsonProperty("adamIdStr")
    private String adamIdStr;
    @JsonProperty("isIrrevocable")
    private Boolean isIrrevocable;
    @JsonProperty("deviceAssignable")
    private Boolean deviceAssignable;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("productTypeName")
    public String getProductTypeName() {
        return productTypeName;
    }

    @JsonProperty("productTypeName")
    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    @JsonProperty("productTypeId")
    public Integer getProductTypeId() {
        return productTypeId;
    }

    @JsonProperty("productTypeId")
    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    @JsonProperty("pricingParam")
    public String getPricingParam() {
        return pricingParam;
    }

    @JsonProperty("pricingParam")
    public void setPricingParam(String pricingParam) {
        this.pricingParam = pricingParam;
    }

    @JsonProperty("adamIdStr")
    public String getAdamIdStr() {
        return adamIdStr;
    }

    @JsonProperty("adamIdStr")
    public void setAdamIdStr(String adamIdStr) {
        this.adamIdStr = adamIdStr;
    }

    @JsonProperty("isIrrevocable")
    public Boolean getIsIrrevocable() {
        return isIrrevocable;
    }

    @JsonProperty("isIrrevocable")
    public void setIsIrrevocable(Boolean isIrrevocable) {
        this.isIrrevocable = isIrrevocable;
    }

    @JsonProperty("deviceAssignable")
    public Boolean getDeviceAssignable() {
        return deviceAssignable;
    }

    @JsonProperty("deviceAssignable")
    public void setDeviceAssignable(Boolean deviceAssignable) {
        this.deviceAssignable = deviceAssignable;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}