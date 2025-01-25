package com.enviro.assessment.grad001.phillimonmotsinoni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration  // Enable auto-configuration for Spring Boot
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})  // Exclude DataSource auto-configuration
@ComponentScan(basePackages = {"com.enviro.assessment.grad001.phillimonmotsinoni"})  // Scan specified package for components
public class WasteSortingMobileAppApi {
	public static void main(String[] args) {
		SpringApplication.run(WasteSortingMobileAppApi.class, args);  // Launch the Spring Boot application
	}
}
