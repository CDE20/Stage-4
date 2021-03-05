package com.cognizant.springlearn4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class SpringLearn4Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearn4Application.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringLearn4Application.class, args);
		LOGGER.info("inside main");
	}

}



