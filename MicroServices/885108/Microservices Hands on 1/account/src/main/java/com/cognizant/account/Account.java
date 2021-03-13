package com.cognizant.account;

public class Account {

	private String accNo;
	private String accType;
	private double balance;
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Account(String accNo, String accType, double balance) {
		super();
		this.accNo = accNo;
		this.accType = accType;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", accType=" + accType + ", balance=" + balance + "]";
	}
	
}
