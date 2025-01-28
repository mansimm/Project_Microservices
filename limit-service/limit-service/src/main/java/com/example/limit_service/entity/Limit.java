package com.example.limit_service.entity;

public class Limit {
    private Integer minimum;
    private Integer maximum;

    public Limit(Integer maximum, Integer minimum) {
        this.maximum = maximum;
        this.minimum = minimum;
    }

    public Limit() {
    }

    public Integer getMinimum() {
        return minimum;
    }

    public Integer getMaximum() {
        return maximum;
    }

    public void setMinimum(Integer minimum) {
        this.minimum = minimum;
    }

    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }
}
