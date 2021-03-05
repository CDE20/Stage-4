package com.cognizant.springlearn;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		LOGGER.info("----------------------------- Start -----------------------------");

		SpringApplication.run(SpringLearnApplication.class, args);

		displayCountries();

		LOGGER.info("----------------------------- End -----------------------------");
	}

	private static void displayCountries() {
		LOGGER.info("Start");

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("country.xml");

		ArrayList countries = applicationContext.getBean("countryList", ArrayList.class);

		LOGGER.debug("Countries: {}", countries);

		LOGGER.info("End");
	}
}
