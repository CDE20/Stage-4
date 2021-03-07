package com.cognizant.springlearn;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;

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

@RestController
@RequestMapping("/countries")
public class CountryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	@Autowired
	CountryService service;
	
	public CountryController() {
		LOGGER.info("inside country Controller");	
	}

	@RequestMapping("/country")
	public Country getCountryIndia() {
		LOGGER.info("inside getCountryIndia");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("country", Country.class);
		return country;

	}

	@GetMapping("/countries")
	public ArrayList getCountries() {
		LOGGER.info("inside getCountries");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList countries = context.getBean("countryList", ArrayList.class);
		LOGGER.info("START");
		System.out.println("List Elements :" + countries);
		LOGGER.info("END");
		return countries;

	}

	@GetMapping("/countries/{code}")
	public List<Country> getCountry(@PathVariable String code) throws CountryNotFoundException {
		LOGGER.info("START");
		List<Country> list = service.getCountry(code);
		LOGGER.info("End");
		return list;

	}

	@PostMapping()
	public Country addCountry(@RequestBody @Valid Country country) {
		LOGGER.info("start");
		LOGGER.info("country:{}", country);

		// Create validator factory
		/*ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		// Validation is done against the annotations defined in country bean
		Set<ConstraintViolation<Country>> violations = validator.validate(country);
		List<String> errors = new ArrayList<String>();
		// Accumulate all errors in an ArrayList of type String
		for (ConstraintViolation<Country> violation : violations) {
			errors.add(violation.getMessage());
		}
		// Throw exception so that the user of this web service receives appropriate
		// error message
		if (violations.size() > 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.toString());
		}*/
		
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
