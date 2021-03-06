package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	private String code, name;

	public Country(){
		LOGGER.info("Inside Country Constructor");
	}
	
	
	public String getCode() {
		LOGGER.info("GET method for CODE");
		return code;
	}

	public void setCode(String code) {
		LOGGER.info("SET method for CODE");
		this.code = code;
	}

	public String getName() {
		LOGGER.info("GET method for NAME");
		return name;
	}

	public void setName(String name) {
		LOGGER.info("SET method for NAME");
		this.name = name;
	}


	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
	
	
	
}
