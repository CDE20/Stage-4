package com.cognizant.springlearn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

	public Country getCountry(String code) throws CountryNotFoundException {
		LOGGER.info("Start");

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries = applicationContext.getBean("countryList", ArrayList.class);

		Optional<Country> optional = countries.stream().filter(i -> i.getCode().equalsIgnoreCase(code)).findFirst();
		
		Country country = null;
		
		if (optional.isPresent()) {
			country = optional.get();
		}

		if (country == null) {
			throw new CountryNotFoundException();
		}
		
		LOGGER.info("End");
		return country;
	}

}
