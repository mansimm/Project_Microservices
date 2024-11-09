package com.example.currency_exchange_service.Service;

import com.example.currency_exchange_service.entity.CurrencyExchange;
import com.example.currency_exchange_service.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {
    @Autowired
    CurrencyExchangeRepository currencyExchangeRepository;

    public CurrencyExchange getCurrencyExchangeValue(String from, String to){
        return currencyExchangeRepository.findByFromAndTo(from, to);
    }


}
