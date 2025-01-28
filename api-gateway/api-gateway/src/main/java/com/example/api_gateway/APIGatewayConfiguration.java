package com.example.api_gateway;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class APIGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p -> p.path("/get")
                        .filters(f -> f.addRequestHeader("customHeader", "My Header")
                                .addRequestParameter("param", "myparam"))
                        .uri("http://httpbin.org:80"))
                .route(p -> p.path("/currency-exchange/**").
                        uri("lb://currency-exchange-service"))
                .route(p -> p.path("/currency-conversion/feign/**").
                        uri("lb://currency-converter"))
                .route(p -> p.path("/currency-conversion/**").
                        uri("lb://currency-converter"))
                .route(p -> p.path("/currency-conversion-new/**").
                        filters(f -> f.rewritePath("/currency-conversion-new/(?<segment>.*)",
                                        "/currency-conversion/feign/${segment}")).
                        uri("lb://currency-converter"))
                .build();
    }
}
