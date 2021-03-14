package com.cognizant.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.account.model.Account;

@RestController
@RequestMapping("accounts")
public class AccountController {

	@GetMapping("/{number}")
	public Account getDetails(@PathVariable long number) {
		return new Account(number,"savings",12345);
	}

}
