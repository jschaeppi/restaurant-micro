package com.aston.employeeservice.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = {"com.aston.employeeservice.repositories"})
@EntityScan(basePackages = {"com.aston.employeeservice.domain"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
