package com.example.by_cycle.model;

import java.math.BigDecimal;

public class Parts {

    private String partName;

    private String component;

    private BigDecimal price;

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "com.priceengine.test.models.Parts{" +
                "partName='" + partName + '\'' +
                ", component='" + component + '\'' +
                ", price=" + price +
                '}';
    }
}
