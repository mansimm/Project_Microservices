# Microservices using Springboot

1. Eureka server - naming server for service registration and discovery
2. Eureka client - need to add in all MS, to register it with eureka server
3. Feign client - client side load balancing, use to call API of other MS (service invocation)[Ribbon comes with feign, ribbon is used for client side load balancing]
4. Spring cloud gateway - use to route to API, provide cross cutting concerns, previously Zuul was used which is no longer available
5. Spring cloud config server - centralise configuration for all microservices
6. Resilience4j - use for fault tolerence, implement circuit breaker pattern (need to add actuator, aop and resilience4j-spring-boot2 starter dependencies)
7. zipkin: use for distributed tracing [use 2.2 or above versions for zipkin]


Note: 
1. Hystrix is used for fault tolerance, it implements circuit breaker design pattern
2. Resilience4j is new framework inspired from hystrix, it also implements fault tolerance
3. in spring boot 2, for distributed tracing following is used =
   sleuth > brave > zipkin
   in spring boot 3 following is used =
   Micrometer > Opentelemeter > zipkin
   sleuth can handle traces only, but micrometer can handle logs, metrics and traces
   
   V4- with zipkin(pending to autocanfigure resttemplate so it can be traced too, and rest template call not working for conversion)
