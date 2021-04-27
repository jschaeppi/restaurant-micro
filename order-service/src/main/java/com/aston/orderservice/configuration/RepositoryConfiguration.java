package com.aston.orderservice.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = {"com.aston.orderservice.repositories"})
@EntityScan(basePackages = {"com.aston.orderservice.domain"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
