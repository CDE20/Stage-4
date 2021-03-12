package com.cognizant.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Loan;

@RestController
@RequestMapping("/loans")
public class loanController {
	
	@GetMapping("/{number}")
	public Loan getLoan(@PathVariable String number)
	{
		return new Loan("H00987987972342","car",400000,3258,18);
	}

}
