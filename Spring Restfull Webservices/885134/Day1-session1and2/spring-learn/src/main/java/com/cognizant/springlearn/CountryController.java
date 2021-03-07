package com.cognizant.springlearn;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	@Autowired
	CountryService service;
	
	@RequestMapping("/country")
	public Country getCountryIndia() throws CountryNotFoundException {
		LOGGER.info("inside getCountryIndia");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("country", Country.class);
		return country;
		
	}
	
	@RequestMapping("/countries")
	public ArrayList getCountries() {
		LOGGER.info("inside getCountries");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList countries = context.getBean("countryList", ArrayList.class);
		LOGGER.info("START");
		System.out.println("List Elements :"  + countries);
		LOGGER.info("END");
		return countries;
		
	}
	
	@GetMapping("/countries/{code}")
	public List<Country> getCountry(@PathVariable String code) throws CountryNotFoundException {
		LOGGER.info("START");
		List<Country> list=service.getCountry(code);
		LOGGER.info("End");
		return list;
		
	}

}
