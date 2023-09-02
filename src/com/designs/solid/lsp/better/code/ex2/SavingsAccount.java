package com.designs.solid.lsp.better.code.ex2;

public class SavingsAccount implements DepositAccount {

	private double amount;
	
	public SavingsAccount(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}
	
	@Override
	public double calculateInterestAccruedToCustomer() {
		return 0.04 * amount;
	}

	

}
