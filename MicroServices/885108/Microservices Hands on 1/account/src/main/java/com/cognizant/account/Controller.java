package com.cognizant.account;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@GetMapping("/accounts/{number}")
	public Account showAccount(@PathVariable("number") String number) {
		Account a = new Account("2398273498273498","savings",238222);
		return a;
	}
	
}
