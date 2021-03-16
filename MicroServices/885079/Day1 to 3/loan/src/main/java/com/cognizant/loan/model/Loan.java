package com.cognizant.loan.model;

public class Loan {
	
	private String number;
	private String type;
	private long loan;
	private int emi;
	private int tenure;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getLoan() {
		return loan;
	}
	public void setLoan(long loan) {
		this.loan = loan;
	}
	public int getEmi() {
		return emi;
	}
	public void setEmi(int emi) {
		this.emi = emi;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	
	public Loan(String number, String type, long loan, int emi, int tenure) {
		super();
		this.number = number;
		this.type = type;
		this.loan = loan;
		this.emi = emi;
		this.tenure = tenure;
	}
	
	@Override
	public String toString() {
		return "Loan [number=" + number + ", type=" + type + ", loan=" + loan + ", emi=" + emi + ", tenure=" + tenure
				+ "]";
	}

}
