package com.poc.infrastructure;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.donnee.dto.InvoiceRequestDTO;
import com.poc.donnee.dto.InvoiceResponseDTO;
import com.poc.service.applicatif.InvoiceSA;

@RestController
@RequestMapping(path = "/api")
public class InvoiceController {

	private InvoiceSA invoiceSA;

	public InvoiceController(InvoiceSA invoiceSA) {
		this.invoiceSA = invoiceSA;
	}

	@GetMapping(path = "/invoices/{id}")
	public InvoiceResponseDTO getInvoice(@PathVariable(name = "id") String invoiceId) {
		return invoiceSA.getInvoice(invoiceId);
	}

	@GetMapping(path = "/invoicesByCustomer/{customerId}")
	public List<InvoiceResponseDTO> getInvoiceByCustomer(@PathVariable String customerId) {
		return invoiceSA.invoicesByCustomerId(customerId);
	}

	@PostMapping(path = "/invoices")
	public InvoiceResponseDTO saveInvoice(@RequestBody InvoiceRequestDTO invoiceRequestDTO) {
		return invoiceSA.save(invoiceRequestDTO);
	}

	@GetMapping(path = "/invoices")
	public List<InvoiceResponseDTO> allInvoices() {
		return invoiceSA.allInvoices();
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> exceptionHandler(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
