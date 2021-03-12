package com.cognizant.moviecruiser.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Menu Item Not Found")
public class MovieNotFoundException extends Exception {
	public MovieNotFoundException(String message) {
		super(message);
	}
}