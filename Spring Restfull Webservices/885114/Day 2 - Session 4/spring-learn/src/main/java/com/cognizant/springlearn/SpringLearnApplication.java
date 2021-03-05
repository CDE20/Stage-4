package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.model.Country;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Start");

		SpringApplication.run(SpringLearnApplication.class, args);

//		displayDate();
//		
//		displayCountry();
//		
//		displayCountries();
		LOGGER.info("End");
	}

	private static void displayDate() {
		LOGGER.info("Start");
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat simpleDateFormat = applicationContext.getBean("dateFormat", SimpleDateFormat.class);
		try {
			Date date = simpleDateFormat.parse("31/12/2018");
			System.out.println("\n" + date + "\n");
			LOGGER.debug("Date : {}", date);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		LOGGER.info("End");
	}

	private static void displayCountry() {
		LOGGER.info("Start");
		
		LOGGER.debug("Singleton");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("country.xml");
		
		Country country = applicationContext.getBean("country", Country.class);
		Country country2 = applicationContext.getBean("country", Country.class);
		
		LOGGER.debug("Country : {}", country);
		LOGGER.debug("Country : {}", country2);
		
		LOGGER.debug("Prototype");
		Country anotherCountry = applicationContext.getBean("anotherCountry", Country.class);
		Country anotherCountry2 = applicationContext.getBean("anotherCountry", Country.class);
		
		LOGGER.debug("Country : {}", anotherCountry);
		LOGGER.debug("Country : {}", anotherCountry2);
		
		
		
		LOGGER.info("End");
	}

	private static void displayCountries() {
		LOGGER.info("Start");
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("country.xml");
		ArrayList countries = applicationContext.getBean("countryList", ArrayList.class);
		LOGGER.debug("Countries: {}", countries);
		
		LOGGER.info("End");
	}
}
