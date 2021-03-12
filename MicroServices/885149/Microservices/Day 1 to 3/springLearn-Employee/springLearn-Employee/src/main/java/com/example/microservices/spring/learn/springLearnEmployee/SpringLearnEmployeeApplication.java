package com.example.microservices.spring.learn.springLearnEmployee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages="com.*")
@EnableDiscoveryClient
public class SpringLearnEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnEmployeeApplication.class, args);
	}

}
