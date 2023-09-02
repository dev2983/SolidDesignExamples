package com.designs.solid.lsp.better.code.ex2;

public class FixedDepositAccount implements DepositAccount {

	private double amount;
	
	public FixedDepositAccount(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}
	
	@Override
	public double calculateInterestAccruedToCustomer() {
		return 0.07 * amount;
	}

}
