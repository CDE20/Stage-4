package com.cognizant.truyum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Cart is Empty")
public class CartEmptyException extends Exception {
	public CartEmptyException(String message) {
		super(message);
	}
}
