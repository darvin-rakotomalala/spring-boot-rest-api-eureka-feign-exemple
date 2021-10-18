package com.poc.mapper;

import org.mapstruct.Mapper;

import com.poc.donnee.domain.Invoice;
import com.poc.donnee.dto.InvoiceRequestDTO;
import com.poc.donnee.dto.InvoiceResponseDTO;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

	Invoice fromInvoiceRequestDTO(InvoiceRequestDTO invoiceRequestDTO);

	InvoiceResponseDTO fromInvoice(Invoice invoice);

}
