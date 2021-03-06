package com.cognizant.springrestlearn.model;

import java.util.ArrayList;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Country {
	
	@NotNull
	@Size(min = 2,max = 2, message = "Country code should be 2 characters")
	private String code;
	private String name;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);
	
	public Country()
	{
		LOGGER.debug("inside country constructor");
	}

	
	public String getCode() {
		LOGGER.debug("inside get code ");
		return code;
	}

	public void setCode(String code) {
		this.code = code;
		LOGGER.debug("inside set code");
	}

	public String getName() {
		LOGGER.debug("inside get name");
		return name;
	}

	public void setName(String name) {
		this.name = name;
		LOGGER.debug("inside set name");
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}

	

	

}
