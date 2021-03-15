package com.cognizant.account.model;

public class Account {

	private long accountNumber;
	private String type;
	private double balance;

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", type=" + type + ", balance=" + balance + "]";
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
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

	public Account(long accountNumber, String type, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.type = type;
		this.balance = balance;
	}

	public Account() {

	}

}
