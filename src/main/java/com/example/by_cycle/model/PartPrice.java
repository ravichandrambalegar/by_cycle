package com.example.by_cycle.model;

import com.example.by_cycle.enums.HighLevelComponent;
import com.example.by_cycle.enums.Months;

import java.math.BigDecimal;

public class PartPrice {

    private HighLevelComponent highLevelComponent;

    private String partName;

    private BigDecimal partPrice;

    private Months months;

    public HighLevelComponent getHighLevelComponent() { return highLevelComponent; }

    public void setHighLevelComponent(HighLevelComponent highLevelComponent) { this.highLevelComponent = highLevelComponent; }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public BigDecimal getPartPrice() {
        return partPrice;
    }

    public void setPartPrice(BigDecimal partPrice) {
        this.partPrice = partPrice;
    }

    public Months getMonths() { return months; }

    public void setMonths(Months months) { this.months = months; }

    @Override
    public String toString() {
        return "com.priceengine.test.models.PartPrice{" +
                "partName='" + partName + '\'' +
                ", partPrice=" + partPrice +
                ", months=" + months +
                '}';
    }
}
