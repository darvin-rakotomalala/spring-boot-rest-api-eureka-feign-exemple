package com.poc;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.poc.donnee.dto.InvoiceRequestDTO;
import com.poc.service.applicatif.InvoiceSA;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info = @Info(title = "BILLING-SERVICE", version = "2.0", description = "Spring Boot billing service API REST"))
public class SpringBootPostgresqlMcsOpenfeignBillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPostgresqlMcsOpenfeignBillingServiceApplication.class, args);
	}
	
	
	CommandLineRunner commandLineRunner(InvoiceSA invoiceSA) {
		return args -> {
			invoiceSA.save(new InvoiceRequestDTO(BigDecimal.valueOf(98000), "c01"));
			invoiceSA.save(new InvoiceRequestDTO(BigDecimal.valueOf(54300), "c02"));
			invoiceSA.save(new InvoiceRequestDTO(BigDecimal.valueOf(12000), "c03"));
		};
	}

}
