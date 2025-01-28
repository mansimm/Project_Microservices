package com.example.currency_converter;

import com.example.currency_converter.entity.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange-service", url="localhost:8081")
/*removed url in below @FeignClient, bcoz once eureka server is configured url will be fetched from there
name should match with spring.application.name of app whose services we are calling
feign also does client side load balancing.
when 2 instances of currency-exchange-service are up it automatically load balanced request among them ie. 8001 and 8002
(we can validate this by checking environment field in get currency-conversion-feign api output)
* */
@FeignClient(name="currency-exchange-service")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion getCurrencyExchangeValue
            (@PathVariable String from, @PathVariable String to);
}
