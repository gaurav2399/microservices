package com.gaurav.microservices.currency_exchange_service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class CurrencyExchange {

    @Id
    private int id;
    @Column(name = "currency_from")
    private String from;

    @Column(name = "currency_to")
    String to;
    String environment;
    private BigDecimal conversionMultiple;

    public CurrencyExchange() {}

    public CurrencyExchange(int id, String from, String to, String environment, BigDecimal conversionMultiple) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.environment = environment;
        this.conversionMultiple = conversionMultiple;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }
}
