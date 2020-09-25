package com.dartdigital.recruitment.exceptions;

public class ExceptionResponse {

	private int code;
	private String message;

	public ExceptionResponse(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}