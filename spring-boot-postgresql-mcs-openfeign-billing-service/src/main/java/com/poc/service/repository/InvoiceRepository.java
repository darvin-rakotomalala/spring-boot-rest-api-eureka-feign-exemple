package com.poc.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.donnee.domain.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {

	List<Invoice> findByCustomerId(String customerId);
}
