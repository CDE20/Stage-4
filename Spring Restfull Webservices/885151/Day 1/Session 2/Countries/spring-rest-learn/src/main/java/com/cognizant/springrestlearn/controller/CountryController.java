package com.cognizant.springrestlearn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springrestlearn.model.Country;
import com.cognizant.springrestlearn.service.CountryService;
import com.cognizant.springrestlearn.service.exception.CountryNotFoundException;

@RestController
public class CountryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
	
	@Autowired
	CountryService service;
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World!";
	}
	
	@GetMapping("/country")
	public Country getCountryIndia() {
		LOGGER.info("Start");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("in", Country.class);
		LOGGER.info("End");
		return country;
	}
	
	@GetMapping("/countries")
	public List<Country> getAllCountries(){
		LOGGER.info("Start");
		ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries=context.getBean("countryList",java.util.ArrayList.class);
		LOGGER.info("End");
		return countries;
	}
	
	@GetMapping("/countries/{code}")
	public Country getCountryByCode(@PathVariable String code) throws CountryNotFoundException {
		LOGGER.info("Start");
		Country country=service.getCountry(code);
		LOGGER.info("End");
		return country;
	}
}
