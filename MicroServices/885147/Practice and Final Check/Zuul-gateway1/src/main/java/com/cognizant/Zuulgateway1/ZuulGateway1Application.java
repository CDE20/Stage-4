package com.cognizant.Zuulgateway1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulGateway1Application {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGateway1Application.class, args);
	}

}
