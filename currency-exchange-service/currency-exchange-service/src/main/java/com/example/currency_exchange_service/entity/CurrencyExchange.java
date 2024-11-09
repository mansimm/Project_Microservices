package com.example.currency_exchange_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "currency_exchange")
public class CurrencyExchange {
    @Id
    private Integer id;
    @Column(name= "currency_from")
    private String from;
    @Column(name= "currency_to")
    private String to;
    private Double conversionMultiple;
    private String environment;

    public CurrencyExchange() {
    }
    public CurrencyExchange(Integer id, String from, String to, Double conversionMultiple) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        //this.environment = environment;
    }

    public Integer getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Double getConversionMultiple() {
        return conversionMultiple;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setConversionMultiple(Double conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
/*
* {
   "id":10001,
   "from":"USD",
   "to":"INR",
   "conversionMultiple":65.00,
   "environment":"8000 instance-id"
}*/