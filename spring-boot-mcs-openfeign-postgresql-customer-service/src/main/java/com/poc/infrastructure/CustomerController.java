package com.poc.infrastructure;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.donnee.dto.CustomerRequestDTO;
import com.poc.donnee.dto.CustomerResponseDTO;
import com.poc.service.applicatif.CustomerSA;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "/api")
public class CustomerController {

	private CustomerSA customerSA;

	public CustomerController(CustomerSA customerSA) {
		this.customerSA = customerSA;
	}

	@Operation(summary = "find all customers")
	@GetMapping(path = "/customers")
	public List<CustomerResponseDTO> allCustomers() {
		return customerSA.listCustomers();
	}

	@Operation(summary = "add customer")
	@PostMapping(path = "/customers")
	public CustomerResponseDTO saveCustomer(@RequestBody CustomerRequestDTO customerRequestDTO) {
		customerRequestDTO.setId(UUID.randomUUID().toString());
		return customerSA.save(customerRequestDTO);
	}

	@Operation(summary = "find customer by Id")
	@GetMapping(path = "/customers/{id}")
	public CustomerResponseDTO getCustomer(@PathVariable String id) {
		return customerSA.getCustomer(id);
	}
}
