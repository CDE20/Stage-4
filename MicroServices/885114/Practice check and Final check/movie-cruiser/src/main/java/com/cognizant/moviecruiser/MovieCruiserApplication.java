package com.cognizant.moviecruiser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableEurekaClient
public class MovieCruiserApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieCruiserApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Start");

		ApplicationContext applicationContext = SpringApplication.run(MovieCruiserApplication.class, args);
		
		LOGGER.info("End");
	}

}
