package com.example.limit_service.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limit-service")
public class LimitConfiguration {
    private Integer minimum;
    private Integer maximum;

    public LimitConfiguration() {
    }

    public LimitConfiguration(Integer minimum, Integer maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
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
