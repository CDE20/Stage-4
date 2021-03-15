package com.cognizant.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.account.model.Account;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@GetMapping("/{number}")
	public Account AccountDetails(@PathVariable String number) {
	Account acct=new Account();
	acct.setNumber("00987987973432");
	acct.setType("savings");
	acct.setBalance(234343);
		return acct;
		
	}
	
}
