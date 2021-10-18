package com.poc.donnee.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class CustomerRequestDTO {

	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private String id;
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private String name;
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private String email;

	public CustomerRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerRequestDTO(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
