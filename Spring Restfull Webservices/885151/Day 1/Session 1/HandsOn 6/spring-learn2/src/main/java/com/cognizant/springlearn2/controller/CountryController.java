package com.cognizant.springlearn2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World!";
	}
}
