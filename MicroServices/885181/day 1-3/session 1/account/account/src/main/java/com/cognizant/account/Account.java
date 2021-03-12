package com.cognizant.account;

import org.slf4j.Logger;


public class Account {
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(Account.class);
 long number;
 String type;
 long balance;
public long getNumber() {
	return number;
}
public void setNumber(long number) {
	this.number = number;
} 

public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public long getBalance() {
	return balance;
}
public void setBalance(long balance) {
	this.balance = balance;
	
}
@Override
public String toString() {
	return "Account [number=" + number + ", type=" + type + ", balance=" + balance + "]";
}

}
