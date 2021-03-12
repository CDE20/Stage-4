package com.cognizant.account.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.account.Account;





@RestController
public class AccountController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
	
	@RequestMapping(value = "/accounts/{number}")
	public Account getAccount(@PathVariable long number)
	{
		LOGGER.info("START");
		ApplicationContext context =  new ClassPathXmlApplicationContext("account.xml");
		Account account= (Account) context.getBean("acc", Account.class);
		LOGGER.info("END");
	
		return account;
		
	}
}
