package com.example.by_cycle.model;

import java.math.BigDecimal;
import java.util.List;

public class Cycles {

    private List<Parts> parts;

    private BigDecimal price;

    public List<Parts> getParts() {
        return parts;
    }

    public void setParts(List<Parts> parts) {
        this.parts = parts;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "com.priceengine.test.models.Cycles{" +
                "parts=" + parts +
                ", price=" + price +
                '}';
    }
}
