1. Eureka server - naming server for service registration and discovery
2. Eureka client - need to add in all MS, to register it with eureka server
3. Feign client - client side load balancing, use to call API of other MS (service invocation)[Ribbon comes with feign, ribbon is used for client side load balancing]
4. Spring cloud gateway - use to route to API, provide cross cutting concerns, previously Zuul was used which is no longer available
5. Spring cloud config server - centralise configuration for all microservices


Note: 
1. Hystrix is used for fault tolerance, it implements circuit breaker design pattern
2. Resilience4j is new framework inspired from hystrix, it also implements fault tolerance