package com.cognizant.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.account.model.Account;

@RestController
@RequestMapping("/accounts")
public class accountController {
	
	@GetMapping("/{number}")
	public Account getAccount(@PathVariable String number)
	{
		return new Account("00987987973432","savings",234343);
		
	}
	

}
