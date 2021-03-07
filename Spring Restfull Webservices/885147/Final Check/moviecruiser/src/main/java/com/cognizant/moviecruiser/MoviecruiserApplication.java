package com.cognizant.moviecruiser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MoviecruiserApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MoviecruiserApplication.class);

	public static void main(String[] args) {
		
		LOGGER.info("Start");
		
		SpringApplication.run(MoviecruiserApplication.class, args);
		
		LOGGER.info("End");
	}

}