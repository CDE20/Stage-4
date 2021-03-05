package com.cognizant.springlearn4.controller;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.springlearn4.model.Country;
import com.cognizant.springlearn4.service.CountryService;
import com.cognizant.springlearn4.service.exception.CountryNotFoundException;



@RestController
@RequestMapping("/countries")
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
	
	@PostMapping()
	public Country addCountry(@RequestBody @Valid Country country)
	{
		LOGGER.info("start");
		LOGGER.info("country:{}" ,country);
		/*ValidatorFactory factory= Validation.buildDefaultValidatorFactory();
		Validator validator=factory.getValidator();
		Set<ConstraintViolation<Country>> violations=validator.validate(country);
		List<String> errors=new ArrayList<String>();
		for(ConstraintViolation<Country> violation : violations) {
			errors.add(violation.getMessage());
		}
		if(errors.size()>0)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,errors.toString());*/
		LOGGER.info(country.toString());
		
		return country;
		}
	@GetMapping()
	@ResponseBody
	public Country getCountry(Country country)
	{
		LOGGER.info("inside get country");
		LOGGER.info("country:{}" ,country);
		return country;
	}
	@DeleteMapping()
	public Country deleteCountry(Country country)
	{
		LOGGER.info("inside delete country");
		LOGGER.info("country:{}" ,country);
		return country;
	}

}
