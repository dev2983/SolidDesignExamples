package com.designs.solid.lsp.better.code.ex2;

public class CarLoanAccount implements MortgageAccount {

	private double amount;
	
	public CarLoanAccount(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}
	
	@Override
	public double calculateInterestAccruedToBank() {
		return 0.1 * amount;
	}

}
