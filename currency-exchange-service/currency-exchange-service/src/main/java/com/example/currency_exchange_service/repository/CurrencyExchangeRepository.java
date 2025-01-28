package com.example.currency_exchange_service.repository;

import com.example.currency_exchange_service.entity.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Integer> {
    public CurrencyExchange findByFromAndTo(String from, String to);
}
