package com.example.by_cycle.model;

import java.util.List;

public class InputData {

    private List<PartsUserInput> parts;

    private String pricingDate;


    public InputData(){}

    //    public com.priceengine.test.models.InputData(List<com.priceengine.test.models.PartsUserInput> parts, String pricingDate) {
//        this.parts = parts;
//        this.pricingDate = pricingDate;
//    }
    public List<PartsUserInput> getParts() { return parts; }

    public void setParts(List<PartsUserInput> parts) { this.parts = parts; }

    public String getPricingDate() {
        return pricingDate;
    }

    public void setPricingDate(String pricingDate) {
        this.pricingDate = pricingDate;
    }

    @Override
    public String toString() {
        return "com.priceengine.test.models.InputData{" +
                "parts=" + parts +
                ", pricingDate=" + pricingDate +
                '}';
    }
}
