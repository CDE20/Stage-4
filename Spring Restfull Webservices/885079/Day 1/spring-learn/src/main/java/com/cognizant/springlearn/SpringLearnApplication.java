package com.cognizant.springlearn;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SpringLearnApplication.class, args);
		displayDate();
		displayCountry();
		displayCountries();
	}

	public static void displayDate() throws ParseException {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		String s = "31/12/2018";
		Date date1 = format.parse(s);
		LOGGER.debug(date1.toString());
		System.out.println(date1);
		LOGGER.info("END");
	}
	
	public static void displayCountry() {
	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	Country country = (Country) context.getBean("country", Country.class);
	Country anotherCountry = context.getBean("country", Country.class);
	LOGGER.debug("Country : {}", country.toString());
	//LOGGER.debug("Country : {}", anotherCountry.toString());
	}	
	public static void displayCountries() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> l= (List<Country>) context.getBean("countryList");
		LOGGER.debug("Country : {}", l);
		LOGGER.info("END");
		}
}