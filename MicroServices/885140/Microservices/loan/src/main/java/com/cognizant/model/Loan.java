package com.cognizant.model;

public class Loan {

	private String number;
	private String type;
	private int loan;
	private int emi;
	private int tenure;
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Loan(String number, String type, int loan, int emi, int tenure) {
		super();
		this.number = number;
		this.type = type;
		this.loan = loan;
		this.emi = emi;
		this.tenure = tenure;
	}
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
	public int getLoan() {
		return loan;
	}
	public void setLoan(int loan) {
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
	@Override
	public String toString() {
		return "Loan [number=" + number + ", type=" + type + ", loan=" + loan + ", emi=" + emi + ", tenure=" + tenure
				+ "]";
	}
	
}
