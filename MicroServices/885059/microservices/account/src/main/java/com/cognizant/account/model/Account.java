package com.cognizant.account.model;

public class Account {
	private long number;
	private String type;
	private double balance;

	public Account() {
	}

	public Account(long number, String type, double balance) {
		super();
		this.number = number;
		this.type = type;
		this.balance = balance;
	}

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

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
