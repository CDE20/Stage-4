package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {

	private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

	private String code;
	private String name;

	public Country() {
		LOGGER.debug("Inside Country Constructor");
	}

	public String getCode() {
		LOGGER.info("Start");

		LOGGER.info("End");
		return code;
	}

	public void setCode(String code) {
		LOGGER.info("Start");

		this.code = code;

		LOGGER.info("End");
	}

	public String getName() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return name;
	}

	public void setName(String name) {
		LOGGER.info("Start");

		this.name = name;

		LOGGER.info("End");
	}

	@Override
	public String toString() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return "Country [code=" + code + ", name=" + name + "]";
	}

}
