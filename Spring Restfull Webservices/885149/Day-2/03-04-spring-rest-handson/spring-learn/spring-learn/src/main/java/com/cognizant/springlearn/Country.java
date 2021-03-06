package com.cognizant.springlearn;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.logging.log4j.Logger;

public class Country {
	@NotNull
	@Size(min=2, max=2, message="Country code should be 2 characters")
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
