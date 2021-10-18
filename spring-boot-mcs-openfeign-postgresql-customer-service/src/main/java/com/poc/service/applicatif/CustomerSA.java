package com.poc.service.applicatif;

import java.util.List;

import com.poc.donnee.dto.CustomerRequestDTO;
import com.poc.donnee.dto.CustomerResponseDTO;

public interface CustomerSA {

	CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);

	CustomerResponseDTO getCustomer(String id);

	CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);

	List<CustomerResponseDTO> listCustomers();

}
