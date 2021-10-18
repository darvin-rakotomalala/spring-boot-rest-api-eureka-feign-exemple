package com.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceCustomerBillingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceCustomerBillingApplication.class, args);
	}

}
