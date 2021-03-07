package com.cognizant.springlearn;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND,reason = "Country Not Found")
public class CountryNotFoundException extends Exception {
	public CountryNotFoundException(String msg) {
		super(msg);
	}
}
