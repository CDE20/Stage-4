package com.cognizant.springrestlearn.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springrestlearn.model.Country;
import com.cognizant.springrestlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	public Country getCountry(String code) throws CountryNotFoundException {
		ApplicationContext context= new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries= context.getBean("countryList",java.util.ArrayList.class);
		for(Country c : countries) {
			if(c.getCode().equalsIgnoreCase(code))
				return c;
		}
		throw new CountryNotFoundException();
	}
	
}
