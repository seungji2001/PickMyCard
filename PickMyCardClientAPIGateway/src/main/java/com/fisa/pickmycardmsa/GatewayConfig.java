//package com.fisa.pickmycardmsa;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//@Configuration
//public class GatewayConfig {
//
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("card-service", r -> r
//                        .path("/card/**")
//                        .filters(f -> f
//                                .circuitBreaker(config -> config
//                                        .setName("cardCircuitBreaker")
//                                        .setFallbackUri("forward:/cardFallback"))
//                                .rewritePath("/card/(?<segment>.*)", "/${segment}"))
//                        .uri("lb://PickMyCardClientCardApplication"))
//                .build();
//    }
//}