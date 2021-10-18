package com.poc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.poc.donnee.dto.CustomerRequestDTO;
import com.poc.service.applicatif.CustomerSA;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "CUSTOMER-SERVICE", version = "2.0", description = "Spring Boot Customer service API REST"))
public class SpringBootMcsOpenfeignPostgresqlCustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMcsOpenfeignPostgresqlCustomerServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(CustomerSA customerSA) {
		return Args -> {
			customerSA.save(new CustomerRequestDTO("c01", "Darvin", "darvin@gmail.com"));
			customerSA.save(new CustomerRequestDTO("c02", "Tojo", "tojo@gmail.com"));
			customerSA.save(new CustomerRequestDTO("c03", "Mampy", "mampy@gmail.com"));
		};
	}

}
