package com.poc.donnee.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.poc.donnee.dto.Customer;

@Entity
public class Invoice {

	@Id
	private String id;
	private Date date;
	private BigDecimal amount;
	private String customerId;
	@Transient
	private Customer customer;

	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Invoice(String id, Date date, BigDecimal amount, String customerId, Customer customer) {
		super();
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.customerId = customerId;
		this.customer = customer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
