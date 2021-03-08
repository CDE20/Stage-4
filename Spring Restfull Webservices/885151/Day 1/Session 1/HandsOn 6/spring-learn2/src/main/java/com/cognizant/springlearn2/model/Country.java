package com.cognizant.springlearn2.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {

	private String code;
	private String name;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);
	
	public Country() {
		
	}

	public String getCode() {
		LOGGER.info("Inside get code");
		return code;
	}

	public void setCode(String code) {
		LOGGER.info("Inside set code");
		this.code = code;
	}

	public String getName() {
		LOGGER.info("Inside get name");
		return name;
	}

	public void setName(String name) {
		LOGGER.info("Inside set name");
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}

	
}
