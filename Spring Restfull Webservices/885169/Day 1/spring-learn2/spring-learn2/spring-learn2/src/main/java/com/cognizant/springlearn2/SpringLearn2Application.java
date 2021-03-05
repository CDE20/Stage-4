package com.cognizant.springlearn2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class SpringLearn2Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearn2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringLearn2Application.class, args);
		LOGGER.info("inside main");
	}

}
