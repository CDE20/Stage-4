package com.cognizant.zuulgatewayy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulGatewayyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayyApplication.class, args);
	}

}
