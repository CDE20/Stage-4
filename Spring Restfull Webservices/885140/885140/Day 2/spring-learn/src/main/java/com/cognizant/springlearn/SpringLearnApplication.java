package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication(scanBasePackages = "com.cognizant.springlearn")
@SpringBootConfiguration
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	public static void displayDate(){
		LOGGER.info("Start");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml"); 
		SimpleDateFormat dateFormat = (SimpleDateFormat) context.getBean("dateFormat",SimpleDateFormat.class);
		Date date;
		try {
			date = dateFormat.parse("31/12/2018");
			LOGGER.debug("Date:[]",date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		LOGGER.info("End");
		
	}
	
	private static void displayCountry() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		Country country = (Country) context.getBean("country", Country.class);
		Country country2 = (Country) context.getBean("country", Country.class);
		LOGGER.debug("Country : {}", country.toString());
	}
	
	private static void displayCountries() {
		LOGGER.debug("Start");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> list = (ArrayList<Country>) context.getBean("countryList");
		LOGGER.debug("Country : {}", list);
		LOGGER.debug("End");
	}
	
	public static void main(String[] args){
		SpringApplication.run(SpringLearnApplication.class, args);
		//LOGGER.info("In Main");
		//displayDate();
		//displayCountry();
		displayCountries();
	}

}
