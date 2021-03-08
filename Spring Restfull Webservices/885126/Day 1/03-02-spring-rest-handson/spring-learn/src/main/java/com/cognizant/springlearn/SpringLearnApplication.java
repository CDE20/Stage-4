package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void displayDate() throws ParseException {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		Date date = format.parse("31/01/2010");
		LOGGER.debug(date.toString());
		LOGGER.info("END");
	}

	private static void displayCountry() {
		LOGGER.info("Start");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("country.xml");
		Country country = applicationContext.getBean("country", Country.class);
		LOGGER.debug("Country : {}", country);
		Country anotherCountry = applicationContext.getBean("anotherCountry", Country.class);
		LOGGER.debug("Country : {}", anotherCountry);
		LOGGER.info("End");
	}

	private static void displayCountries() {
		LOGGER.info("Start");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> list = context.getBean("countryList", java.util.ArrayList.class);
		LOGGER.debug("List: {}", list);
		LOGGER.info("End");
	}

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SpringLearnApplication.class, args);
		displayDate();
		displayCountry();
		displayCountries();
	}
}
