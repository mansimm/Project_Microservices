package com.example.currency_converter.controller;

import com.example.currency_converter.entity.CurrencyConversion;
import com.example.currency_converter.service.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency-conversion")
public class CurrencyConverterController {
    @Autowired
    CurrencyConversionService currencyConversionService;

    @GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable Double quantity){
        CurrencyConversion currencyConversion = currencyConversionService.calculateCurrencyConversion(from, to, quantity);
        return currencyConversion;
    }

    @GetMapping("/feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from, @PathVariable String to, @PathVariable Double quantity){
        CurrencyConversion currencyConversion = currencyConversionService.calculateCurrencyConversionFeign(from, to, quantity);
        return currencyConversion;
    }
}
