package com.cognizant.truYum1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.cognizant.truYum1")
public class TruYum1Application {

	public static void main(String[] args) {
		SpringApplication.run(TruYum1Application.class, args);
	}

}
