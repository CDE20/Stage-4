package com.cognizant.springlearn;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;



public class Country {
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(Country.class);
	private String code;
	private String name;
	
	public Country() {
		LOGGER.debug("Inside Country Constructor");
	}

	public String getCode() {
		LOGGER.debug("Inside Code Getter");
		return code;
	}
	public void setCode(String code) {
		LOGGER.debug("Inside Code Setter");
		this.code = code;
	}
	public String getName() {
		LOGGER.debug("Inside Name Getter");
		return name;
	}
	public void setName(String name) {
		LOGGER.debug("Inside Name Setter");
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
	
	
	
	
}
