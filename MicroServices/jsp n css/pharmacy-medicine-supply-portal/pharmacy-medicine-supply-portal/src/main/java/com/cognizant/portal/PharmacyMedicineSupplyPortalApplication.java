package com.cognizant.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PharmacyMedicineSupplyPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PharmacyMedicineSupplyPortalApplication.class, args);
	}

}
