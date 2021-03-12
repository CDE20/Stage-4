package com.cognizant.account.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.account.model.Account;

@RestController
public class AccountController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
	
	@GetMapping("/accounts/{number}")
	public Account getAccount(@PathVariable("number") String number) {
		LOGGER.info("Start");
		
		Account account = new Account();
//		account.setNumber("00987987973432");
		account.setNumber(number);
		account.setType("savings");
		account.setBalance(234343);
		
		LOGGER.info("End");
		return account;
	}

}
