package com.sample.exception;

public class HTAException extends RuntimeException {

	public HTAException(String message) {
		super(message);
	}
	
	public HTAException(String message, Throwable couse) {
		super(message, couse);
	}
}
