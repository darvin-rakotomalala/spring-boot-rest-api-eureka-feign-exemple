package com.poc.service.applicatif;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poc.contrainte.error.CustomerNotFoundException;
import com.poc.donnee.domain.Invoice;
import com.poc.donnee.dto.Customer;
import com.poc.donnee.dto.InvoiceRequestDTO;
import com.poc.donnee.dto.InvoiceResponseDTO;
import com.poc.mapper.InvoiceMapper;
import com.poc.service.businessdelegate.CustomerRestClient;
import com.poc.service.repository.InvoiceRepository;

@Service
@Transactional
public class InvoiceSAImpl implements InvoiceSA {

	private InvoiceRepository invoiceRepository;
	private InvoiceMapper invoiceMapper;
	private CustomerRestClient customerRestClient;

	public InvoiceSAImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper,
			CustomerRestClient customerRestClient) {
		this.invoiceRepository = invoiceRepository;
		this.invoiceMapper = invoiceMapper;
		this.customerRestClient = customerRestClient;
	}

	@Override
	public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) {

		/*
		 * Vérification de l'intégrité référentielle Invoice / Customer
		 */
		Customer customer = null;
		try {
			customerRestClient.getCustomer(invoiceRequestDTO.getCustomerId());
		} catch (Exception e) {
			throw new CustomerNotFoundException("Customer not found");
		}

		// if(customer == null) throw new CustomerNotFoundException("Customer not
		// found!");

		Invoice invoice = invoiceMapper.fromInvoiceRequestDTO(invoiceRequestDTO);
		invoice.setId(UUID.randomUUID().toString());
		invoice.setDate(new Date());
		// invoiceRequestDTO.setCustomerId(UUID.randomUUID().toString());

		Invoice saveInvoice = invoiceRepository.save(invoice);
		saveInvoice.setCustomer(customer);
		
		return invoiceMapper.fromInvoice(saveInvoice);
	}

	@Override
	public InvoiceResponseDTO getInvoice(String invoiveId) {
		Invoice invoice = invoiceRepository.findById(invoiveId).get();
		Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
		invoice.setCustomer(customer);
		return invoiceMapper.fromInvoice(invoice);
	}

	@Override
	public List<InvoiceResponseDTO> invoicesByCustomerId(String customerId) {
		List<Invoice> invoices = invoiceRepository.findByCustomerId(customerId);

		for (Invoice invoice : invoices) {
			Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
			invoice.setCustomer(customer);
		}

		return invoices.stream().map(invoice -> invoiceMapper.fromInvoice(invoice)).collect(Collectors.toList());
	}

	@Override
	public List<InvoiceResponseDTO> allInvoices() {
		List<Invoice> invoices = invoiceRepository.findAll();

		for (Invoice invoice : invoices) {
			Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
			invoice.setCustomer(customer);
		}

		/*
		 * invoices.forEach(inv -> { Customer customer =
		 * customerRestClient.getCustomer(inv.getCustomerId());
		 * inv.setCustomer(customer); });
		 */

		return invoices.stream().map(inv -> invoiceMapper.fromInvoice(inv)).collect(Collectors.toList());
	}

}
