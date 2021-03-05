package com.cognizant.springlearn2.controller;

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

import com.cognizant.springlearn2.SpringLearn2Application;
import com.cognizant.springlearn2.model.Country;
import com.cognizant.springlearn2.service.CountryService;
import com.cognizant.springlearn2.service.exception.CountryNotFoundException;

@RestController
public class CountryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
	@Autowired
	CountryService service;
	
	public CountryController() {
		LOGGER.info("inside country Controller");
		
	}

	@RequestMapping("/country")
	public Country getCountryIndia()
	{
		LOGGER.info("start");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("in", Country.class);
		LOGGER.info("End");
		return country;
		
		
	}
	
	@GetMapping("/countries")
	public List<Country> getCountries()
	{
		LOGGER.info("Start");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> list=context.getBean("countryList", java.util.ArrayList.class);
		LOGGER.info("End");
		return list;
	}
	
	@GetMapping("/countries/{code}")
	public List<Country> getCountry(@PathVariable String code) throws CountryNotFoundException
	{
		LOGGER.info("start");
		//System.out.println(code);
		List<Country> list=service.getCountry(code);
		LOGGER.info("End");
		return list;
		
	}

}
