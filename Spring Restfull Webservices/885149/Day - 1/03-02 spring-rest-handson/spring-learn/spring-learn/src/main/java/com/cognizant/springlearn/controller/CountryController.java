package com.cognizant.springlearn.controller;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
public class CountryController {
	
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
}
