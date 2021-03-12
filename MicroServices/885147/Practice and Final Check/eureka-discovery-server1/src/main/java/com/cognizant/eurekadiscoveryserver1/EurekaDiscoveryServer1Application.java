package com.cognizant.eurekadiscoveryserver1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaDiscoveryServer1Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaDiscoveryServer1Application.class, args);
	}

}
