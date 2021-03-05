package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	
	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	ArrayList<Country> list = (ArrayList<Country>) context.getBean("countryList");
	public Country getCountry(String code) throws CountryNotFoundException{

		Country C = null;
		for (Country country : list) {
			if(country.getCode().equalsIgnoreCase(code)) {
				C = country;
			}
		}
		if(C == null)
			throw new CountryNotFoundException();
		else
			return C;
	}
	
	public Country addCountry(Country country) {
		
		if(list.add(country))
			return country;
		
		return null;
	}
}
