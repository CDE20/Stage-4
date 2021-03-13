package com.example.microservices.zuul.zuulapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulapigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulapigatewayApplication.class, args);
	}

}
