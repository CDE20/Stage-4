package com.cognizant.loan;

public class Loan {
	
	private String loanNo;
	private String loanType;
	private double loanAmount;
	private double emi;
	private int tenure;
	public String getLoanNo() {
		return loanNo;
	}
	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public double getEmi() {
		return emi;
	}
	public void setEmi(double emi) {
		this.emi = emi;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public Loan(String loanNo, String loanType, double loanAmount, double emi, int tenure) {
		super();
		this.loanNo = loanNo;
		this.loanType = loanType;
		this.loanAmount = loanAmount;
		this.emi = emi;
		this.tenure = tenure;
	}
	@Override
	public String toString() {
		return "Loan [loanNo=" + loanNo + ", loanType=" + loanType + ", loanAmount=" + loanAmount + ", emi=" + emi
				+ ", tenure=" + tenure + "]";
	}
	
	
}
