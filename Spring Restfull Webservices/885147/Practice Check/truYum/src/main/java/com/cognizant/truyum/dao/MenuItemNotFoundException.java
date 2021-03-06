package com.cognizant.truyum.dao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MenuItemNotFoundException extends Exception{
	
	public MenuItemNotFoundException(String message) {
		super(message);
	}

}