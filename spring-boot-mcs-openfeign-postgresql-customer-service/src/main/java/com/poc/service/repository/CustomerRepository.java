package com.poc.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.donnee.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
