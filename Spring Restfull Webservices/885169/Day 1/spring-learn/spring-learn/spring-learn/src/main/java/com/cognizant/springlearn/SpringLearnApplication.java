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



@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SpringLearnApplication.class, args);
		LOGGER.info("Inside main");
		displayDate();
		//displayCountry();
		displayCountries();
	}
	
	private static void displayDate() throws ParseException
	{
		LOGGER.info("Start");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		String s1="31/12/2018";
		Date date1=format.parse(s1);
		//System.out.println(date1);
		LOGGER.debug(date1.toString());
		LOGGER.info("End");
	}
	
	private static void displayCountry()
	{
		LOGGER.info("Start");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		//Country anotherCountry = context.getBean("country", Country.class);
		Country country = (Country) context.getBean("country", Country.class);
		LOGGER.debug("Country : {}", country.toString());
		LOGGER.info("End");
	}
	
	private static void displayCountries()
	{
		LOGGER.info("Start");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> list=context.getBean("countryList",java.util.ArrayList.class);
		LOGGER.debug("List: {}", list);
		LOGGER.info("End");
		
	}

}
