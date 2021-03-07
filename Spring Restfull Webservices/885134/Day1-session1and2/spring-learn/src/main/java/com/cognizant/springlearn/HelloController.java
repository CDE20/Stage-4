package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	@RequestMapping("/hello")
	public String hello() {
		LOGGER.info("inside hello");
		return "Hello World RESTful with Spring Boot";
		
	}
}
