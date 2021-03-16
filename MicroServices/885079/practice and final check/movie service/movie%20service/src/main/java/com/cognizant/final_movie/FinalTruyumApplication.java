package com.cognizant.final_movie;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FinalTruyumApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(FinalTruyumApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FinalTruyumApplication.class, args);
		LOGGER.info("inside main");
	}

}
