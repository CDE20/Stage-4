package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
public class CountryController {
	
	 private static final Logger logger = LoggerFactory.getLogger(CountryController.class);
	 
	
	
	@RequestMapping("/country")
	public Country getCounryIndia() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Country.xml");
		Country bean = context.getBean("in",Country.class);
		return bean;
	}
	
	
	@GetMapping("/countries")
	public List<Country> getAllCounry() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Country.xml");
		List<Country> bean = (List<Country>) context.getBean("countryList");
		return bean;
	}
	
	@GetMapping("/country/{code}")
	public Country getCounry(@PathVariable String code) throws CountryNotFoundException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Country.xml");
		Country bean=null;
		try {
		 bean = context.getBean(code,Country.class);
		}catch(Exception e) {
			throw new CountryNotFoundException();
		}
		return bean;
	}
	
	@PostMapping(value="/countries")
	public Country addCountry(@RequestBody() @Valid Country country) {
		logger.info("Country={}",country);
		 
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Country.xml");
		//country=(Country) context.getBean("in");
		List<Country> bean = (List<Country>) context.getBean("countryList");
		bean.add(country);		
		logger.info("Countries={}",bean);
		return country;
	}
}
