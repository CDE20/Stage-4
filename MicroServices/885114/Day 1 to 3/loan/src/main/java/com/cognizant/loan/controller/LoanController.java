package com.cognizant.loan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.loan.model.Loan;

@RestController
public class LoanController {

	@GetMapping("/loans/{number}")
	public Loan getLoan(@PathVariable("number") String number) {
		Loan loan = new Loan();
//		loan.setNumber("H00987987972342");
		loan.setNumber(number);
		loan.setType("car");
		loan.setLoan(400000);
		loan.setEmi(3258);
		loan.setTenure(18);
		
		return loan;
	}
}
