package com.poc.donnee.dto;

import java.math.BigDecimal;

public class InvoiceRequestDTO {

	private BigDecimal amount;
	private String customerId;

	public InvoiceRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvoiceRequestDTO(BigDecimal amount, String customerId) {
		super();
		this.amount = amount;
		this.customerId = customerId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

}
