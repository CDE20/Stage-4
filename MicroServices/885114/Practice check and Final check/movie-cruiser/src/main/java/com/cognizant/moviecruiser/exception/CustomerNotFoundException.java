package com.cognizant.moviecruiser.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Customer Not Found")
public class CustomerNotFoundException extends Exception {
	public CustomerNotFoundException(String message) {
		super(message);
	}
}