package com.poc;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.poc.donnee.dto.InvoiceRequestDTO;
import com.poc.service.applicatif.InvoiceSA;

@SpringBootApplication
@EnableFeignClients
public class SpringBootPostgresqlMcsOpenfeignBillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPostgresqlMcsOpenfeignBillingServiceApplication.class, args);
	}
	
	
	CommandLineRunner commandLineRunner(InvoiceSA invoiceSA) {
		return args -> {
			invoiceSA.save(new InvoiceRequestDTO(BigDecimal.valueOf(98000), "C01"));
			invoiceSA.save(new InvoiceRequestDTO(BigDecimal.valueOf(54300), "C01"));
			invoiceSA.save(new InvoiceRequestDTO(BigDecimal.valueOf(12000), "C02"));
		};
	}

}
