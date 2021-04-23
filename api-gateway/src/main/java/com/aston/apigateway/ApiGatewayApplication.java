package com.aston.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    //Routes for Api Gateway
    @Bean
    public RouteLocator gateway(RouteLocatorBuilder rlb) {
        return rlb
                .routes()
                .route(r -> r
                        .path("/api/v1/employee/**")
                        .uri("lb://EMPLOYEE-SERVICE"))

                .route(r -> r
                        .path("/api/v1/person/**")
                        .uri("lb://EMPLOYEE-SERVICE"))
                .route(r -> r
                        .path("/api/v1/employeeType/**")
                        .uri("lb://EMPLOYEE-SERVICE"))
                .route(r -> r
                        .path("/api/v1/orders/**")
                        .uri("lb://ORDER-SERVICE"))

                .build();
    }
}
