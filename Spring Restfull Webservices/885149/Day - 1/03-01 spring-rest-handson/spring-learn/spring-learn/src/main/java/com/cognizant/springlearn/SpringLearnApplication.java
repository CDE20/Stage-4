package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.catalina.core.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	public static void main(String[] args) {
		LOGGER.info("Inside main");
		SpringApplication.run(SpringLearnApplication.class, args);
		
		displayDate();
		displayCountry();
		displayAllCountry();
	}
	
	
	private static void displayDate() {
		LOGGER.info("START");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat",SimpleDateFormat.class);
		try {
			Date date = format.parse("31/12/2018");
			LOGGER.debug("Date={}",date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		LOGGER.info("END");
	}
	
	
	private static void displayCountry() {
		LOGGER.info("Start");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Country.xml");
		Country bean = context.getBean("in",Country.class);
		LOGGER.debug("Country={}",bean);
		LOGGER.info("END");
	}
	private static void displayAllCountry() {
		LOGGER.info("Start");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Country.xml");
		ArrayList<Country> bean = (ArrayList<Country>) context.getBean("countryList");
		LOGGER.debug("Country={}",bean);
		LOGGER.info("END");
	}

}
