package com.poc.service.applicatif;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poc.donnee.domain.Customer;
import com.poc.donnee.dto.CustomerRequestDTO;
import com.poc.donnee.dto.CustomerResponseDTO;
import com.poc.mapper.CustomerMapper;
import com.poc.service.repository.CustomerRepository;

@Service
@Transactional
public class CustomerSAImpl implements CustomerSA {

	private CustomerRepository customerRepository;
	private CustomerMapper customerMapper;

	// Injection via constructeur
	public CustomerSAImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
		this.customerRepository = customerRepository;
		this.customerMapper = customerMapper;
	}

	@Override
	public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {

		// Mapping Objet Objet (Manuel)
		/*
		 * Customer customer = new Customer();
		 * customer.setId(customerRequestDTO.getId());
		 * customer.setName(customerRequestDTO.getName());
		 * customer.setEmail(customerRequestDTO.getEmail());
		 */

		// customer.setId(UUID.randomUUID().toString());
		/* Customer saveCustomer = customerRepository.save(customer); */

		// Mapping Objet Objet (Manuel)
		/*
		 * CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
		 * customerResponseDTO.setId(saveCustomer.getId());
		 * customerResponseDTO.setName(saveCustomer.getName());
		 * customerResponseDTO.setEmail(saveCustomer.getEmail());
		 */

		/* return customerResponseDTO; */

		// En utilisant MapStruct
		Customer customer = customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
		Customer saveCustomer = customerRepository.save(customer);

		CustomerResponseDTO customerResponseDTO = customerMapper.customerToCustomerResponseDTO(saveCustomer);
		return customerResponseDTO;

	}

	@Override
	public CustomerResponseDTO getCustomer(String id) {
		Customer customer = customerRepository.findById(id).get();
		return customerMapper.customerToCustomerResponseDTO(customer);
	}

	@Override
	public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
		Customer customer = customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
		Customer updatedCustomer = customerRepository.save(customer);
		return customerMapper.customerToCustomerResponseDTO(updatedCustomer);
	}

	@Override
	public List<CustomerResponseDTO> listCustomers() {
		List<Customer> customers = customerRepository.findAll();
		List<CustomerResponseDTO> customerResponseDTOs = customers.stream()
				.map(cust -> customerMapper.customerToCustomerResponseDTO(cust)).collect(Collectors.toList());
		return customerResponseDTOs;
	}

}
