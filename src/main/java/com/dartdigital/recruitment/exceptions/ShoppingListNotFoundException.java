package com.dartdigital.recruitment.exceptions;

public class ShoppingListNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ShoppingListNotFoundException(String message) {
		super(message);
	}
	
}