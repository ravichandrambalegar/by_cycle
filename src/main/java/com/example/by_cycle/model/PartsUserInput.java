package com.example.by_cycle.model;

public class PartsUserInput {

    private String partName;

    private String component;

    public PartsUserInput(){}

    public PartsUserInput(String partName, String component) {
        this.partName = partName;
        this.component = component;
    }

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

    @Override
    public String toString() {
        return "com.priceengine.test.models.PartsUserInput{" +
                "partName='" + partName + '\'' +
                ", component='" + component + '\'' +
                '}';
    }
}
