package com.example.currency_exchange_service.controller;


import com.example.currency_exchange_service.Service.CurrencyExchangeService;
import com.example.currency_exchange_service.entity.CurrencyExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {
    @Autowired
    Environment environment;

    @Autowired
    CurrencyExchangeService currencyExchangeService;

    @GetMapping("from/{from}/to/{to}")
    public CurrencyExchange getCurrencyExchangeValue(@PathVariable String from , @PathVariable String to){
        CurrencyExchange currencyExchange = currencyExchangeService.getCurrencyExchangeValue(from, to);
        if(currencyExchange==null){
            throw new RuntimeException("Unable to find data for from: "+from + ", to: "+to);
        }
        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
        return currencyExchange;
    }

}
