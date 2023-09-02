package com.designs.solid.lsp.problem.code.ex2;

public class FixedDepositAccount implements Account {

	private double amount;
	
	public FixedDepositAccount(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}
	
	
	@Override
	public double calculateInterest() {
		return 0.07 * amount;
	}

}
