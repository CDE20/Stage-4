package com.cognizant.account.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.account.model.Account;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@GetMapping("/{number}")
	public List<Account> getAccount(@PathVariable("number") long number) {
		return Collections.singletonList(new Account(number, "savings", 123));
	}

}
