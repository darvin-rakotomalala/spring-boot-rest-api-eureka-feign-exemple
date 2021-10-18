package com.poc.contrainte.error;

public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(String messages) {
		super(messages);
	}
}
