package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
	String code;
	String name;


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "name [code=" + code + ", name=" + name + "]";
	}

	public Country() {
		
		Logger LOGGER = LoggerFactory.getLogger(Country.class);
		LOGGER.debug("Inside Country Constructor");
	}
	public Country(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
}
