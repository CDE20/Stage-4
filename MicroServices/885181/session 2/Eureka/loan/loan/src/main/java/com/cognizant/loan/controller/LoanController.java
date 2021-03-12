package com.cognizant.loan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cognizant.loan.Loan;

@RestController
public class LoanController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoanController.class);
	@RequestMapping(value = "/loans/{number}")	
	public Loan getLoan(@PathVariable String number)
	{
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("loan.xml");
		Loan loan= (Loan) context.getBean("lo" , Loan.class);
		LOGGER.info("END");
		return loan;
		
	}
}
