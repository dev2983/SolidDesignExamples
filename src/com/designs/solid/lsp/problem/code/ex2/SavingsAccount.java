package com.designs.solid.lsp.problem.code.ex2;

public class SavingsAccount implements Account {

	private double amount;

	public SavingsAccount(double amount) {
		this.amount = amount;
	}
	public double getAmount() {
		return amount;
	}
	
	@Override
	public double calculateInterest() {
		return 0.04 * amount;
	}
}
