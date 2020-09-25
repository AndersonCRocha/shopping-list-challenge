package com.dartdigital.recruitment.exceptions;

public class InvalidQuantityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidQuantityException() {
		super("The number of items must be greater than 0");
	}
	
}