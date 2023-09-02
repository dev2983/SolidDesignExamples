package com.designs.solid.lsp.problem.code.ex2;

public class HomeLoanAccount implements Account {

	private double amount;
	
	public HomeLoanAccount(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}
	
	@Override
	public double calculateInterest() {
		
		throw new UnsupportedOperationException();
	}

}
