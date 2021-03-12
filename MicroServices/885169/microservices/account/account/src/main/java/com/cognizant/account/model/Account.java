package com.cognizant.account.model;

public class Account {
	private String number;
	private String type;
	private int balance;
	public Account(String number, String type, int balance) {
		
		this.number= number;
		this.type = type;
		this.balance = balance;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumbers(String number) {
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
	public void setBalnce(int balance) {
		this.balance = balance;
	}
	
	
	@Override
	public String toString() {
		return "[numbers=" + number + ", type=" + type + ", balance=" + balance + "]";
	}
	

}
