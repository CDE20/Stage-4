package com.cognizant.loan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	
	@GetMapping("/loans/{number}")
	public Loan loanDetails(@PathVariable("number") String number) {
		Loan l = new Loan("23498237492","car",400000,3258,18);
		return l;
	}
	
}
