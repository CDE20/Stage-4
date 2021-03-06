package com.cognizant.springlearn;

import org.apache.logging.log4j.Logger;

public class Country {
	
	String code;
	
	String country;

	public Country() {
		super();
		}

	@Override
	public String toString() {
		return "Country [code=" + code + ", country=" + country + "]";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
