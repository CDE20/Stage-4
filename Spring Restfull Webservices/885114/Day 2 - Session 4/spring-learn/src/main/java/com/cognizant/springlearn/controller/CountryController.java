package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
@RequestMapping(path = "/countries")
public class CountryController {
	private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("country.xml");

	private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

	@Autowired
	private CountryService countryService;

	@RequestMapping("/country")
	public Country getCountryIndia() {

		LOGGER.info("Start");

		Country country = applicationContext.getBean("in", Country.class);

		LOGGER.info("End");
		return country;
	}

	@GetMapping
	public List<Country> getAllCountries() {
		LOGGER.info("Start");

		ArrayList<Country> countries = applicationContext.getBean("countryList", ArrayList.class);

		LOGGER.info("End");
		return countries;
	}

	@GetMapping("/{code}")
	public Country getCountry(@PathVariable("code") String code) throws CountryNotFoundException {
		LOGGER.info("Start");

		ArrayList<Country> countries = applicationContext.getBean("countryList", ArrayList.class);
		Country country = countryService.getCountry(code);

		LOGGER.info("End");
		return country;
	}

	/*
	
	@PostMapping
	public Country addCountry(@RequestBody Country country) {
		LOGGER.info("Start");

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		Set<ConstraintViolation<Country>> violations = validator.validate(country);
		List<String> errors = new ArrayList<String>();
		
		for (ConstraintViolation<Country> violation : violations) {
			errors.add(violation.getMessage());
		}
		
		if (violations.size() > 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.toString());
		}
		
		LOGGER.info("End");
		return country;
	}
	
	 */

	@PostMapping
	public Country addCountry(@RequestBody @Valid Country country) {
		LOGGER.info("Start");

		
		LOGGER.info("End");
		return country;
	}
	
}
