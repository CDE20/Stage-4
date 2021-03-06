package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	public Country getCountry(String code) throws CountryNotFoundException{
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> array = (ArrayList<Country>) context.getBean("countryList");
		Country country = null;
		for(Country c : array){
			if(c.getCode().equalsIgnoreCase(code)){
				country = c;
				System.out.println(c);
				break;
			}
		}
		if(country == null)
			throw new CountryNotFoundException();
		return country;
	}
}
