package com.cognizant.MovieCruiser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@ComponentScan(basePackages = {"com.practicecheck.MovieCruiser"})

@SpringBootApplication
@EnableDiscoveryClient
public class MovieCruiserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieCruiserApplication.class, args);
	}

}
