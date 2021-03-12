package com.example.microservices.spring.learn.springLearnuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringLearnUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnUserApplication.class, args);
	}

}
