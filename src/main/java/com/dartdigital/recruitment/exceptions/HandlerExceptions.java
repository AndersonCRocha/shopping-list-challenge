package com.dartdigital.recruitment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerExceptions {
	
	@ExceptionHandler(InvalidQuantityException.class)
	public ResponseEntity<ExceptionResponse> handlerInvalidQuantityException(InvalidQuantityException ex) {
		ExceptionResponse response = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	@ExceptionHandler(ShoppingListNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handlerProductNotFoundException(ShoppingListNotFoundException ex) {
		ExceptionResponse response = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handlerProductNotFoundException(ProductNotFoundException ex) {
		ExceptionResponse response = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> handlerException(Exception ex) {
		ExceptionResponse response = new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}

}