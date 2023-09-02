package com.designs.solid.lsp.better.code.ex2;

public class HomeLoanAccount implements MortgageAccount {

	private double amount;
	
	public HomeLoanAccount(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}
	
	@Override
	public double calculateInterestAccruedToBank() {
		return 0.085 * amount;
	}

}
