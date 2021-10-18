package com.poc.mapper;

import org.mapstruct.Mapper;

import com.poc.donnee.domain.Customer;
import com.poc.donnee.dto.CustomerRequestDTO;
import com.poc.donnee.dto.CustomerResponseDTO;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

	CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);

	Customer customerRequestDTOToCustomer(CustomerRequestDTO customerRequestDTO);
	
}
