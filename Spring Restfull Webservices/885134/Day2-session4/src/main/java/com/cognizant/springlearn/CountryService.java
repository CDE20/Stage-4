package com.cognizant.springlearn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

	public List<Country> getCountry(String code) throws CountryNotFoundException {
		List<Country> list=new ArrayList<Country>();
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> countries = context.getBean("countryList", ArrayList.class);
	
		for (Country country : countries) {
			if(country.getCode().equalsIgnoreCase(code))
				list.add(country);
		}
		if(list.isEmpty())
			throw new CountryNotFoundException("country not found");
		
		return list;
	}

}
