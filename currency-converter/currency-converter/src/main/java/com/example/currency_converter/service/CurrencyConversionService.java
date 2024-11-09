package com.example.currency_converter.service;

import com.example.currency_converter.CurrencyExchangeProxy;
import com.example.currency_converter.entity.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class CurrencyConversionService {

    @Autowired
    Environment environment;
    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    CurrencyExchangeProxy proxy;

    public CurrencyConversion calculateCurrencyConversion(String from, String to, Double quantiy){
        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        CurrencyConversion currencyConversion = restTemplate.getForObject("http://localhost:8081/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);
        //currencyConversion.setEnvironment(environment.getProperty("local.server.port"));
        return new CurrencyConversion(currencyConversion.getId(), from, currencyConversion.getConversionMultiple(),
                to, quantiy, quantiy*currencyConversion.getConversionMultiple(),currencyConversion.getEnvironment());
    }

    public CurrencyConversion calculateCurrencyConversionFeign(String from, String to, Double quantiy){
        CurrencyConversion currencyConversion = proxy.getCurrencyExchangeValue(from, to);
        return new CurrencyConversion(currencyConversion.getId(), from, currencyConversion.getConversionMultiple(),
                to, quantiy, quantiy*currencyConversion.getConversionMultiple(),currencyConversion.getEnvironment());
    }
}
