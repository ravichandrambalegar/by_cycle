package com.example.by_cycle.model;

import java.util.List;

public class PartPriceStorage {
    List<PartPrice> partPrices;

    public List<PartPrice> getPartPrices() {
        return partPrices;
    }

    public void setPartPrices(List<PartPrice> partPrices) {
        this.partPrices = partPrices;
    }

    @Override
    public String toString() {
        return "com.priceengine.test.models.PartPriceStorage{" +
                "partPrices=" + partPrices +
                '}';
    }
}