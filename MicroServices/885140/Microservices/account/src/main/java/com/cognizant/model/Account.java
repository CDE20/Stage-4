
package com.cognizant.model;

public class Account {

	private long number;
	private String type;
	private int balance;
	public long getNumber() {
		return number;
	}
	
	public Account() {
		
	}
	
	public Account(long number, String type, int balance) {
		super();
		this.number = number;
		this.type = type;
		this.balance = balance;
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
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [number=" + number + ", type=" + type + ", balance=" + balance + "]";
	}
	
	
}
