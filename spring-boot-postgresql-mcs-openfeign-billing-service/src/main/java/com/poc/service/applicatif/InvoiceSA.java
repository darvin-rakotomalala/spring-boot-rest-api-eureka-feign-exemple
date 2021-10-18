package com.poc.service.applicatif;

import java.util.List;

import com.poc.donnee.dto.InvoiceRequestDTO;
import com.poc.donnee.dto.InvoiceResponseDTO;

public interface InvoiceSA {

	InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO);

	InvoiceResponseDTO getInvoice(String invoiveId);

	List<InvoiceResponseDTO> invoicesByCustomerId(String customerId);

	List<InvoiceResponseDTO> allInvoices();

}
