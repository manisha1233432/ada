package com.cg.project.bean;

public class Policy {
	private double policyNumber;
	private double policyPremium;
	private double accountNumber;
	public Policy(double policyNumber, double policyPremium,
			double accountNumber) {
		super();
		this.policyNumber = policyNumber;
		this.policyPremium = policyPremium;
		this.accountNumber = accountNumber;
	}
	public Policy() {
		super();
		
	}
	public double getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(double policyNumber) {
		this.policyNumber = policyNumber;
	}
	public double getPolicyPremium() {
		return policyPremium;
	}
	public void setPolicyPremium(double policyPremium) {
		this.policyPremium = policyPremium;
	}
	public double getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(double accountNumber) {
		this.accountNumber = accountNumber;
	}

	
}
