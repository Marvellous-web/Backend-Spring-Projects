package com.example.Gateway.GatewayDemo.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    RouteLocator getConfig(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p->p
                        .path("/authenticationApp/**")
                        .uri("lb://Authentication-App"))
                .route(p->p
                        .path("/movieApp/**")
                        .uri("http://localhost:8091/**"))
                .build();
    }
}
