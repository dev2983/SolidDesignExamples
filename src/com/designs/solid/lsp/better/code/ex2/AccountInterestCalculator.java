package com.designs.solid.lsp.better.code.ex2;

import java.util.ArrayList;
import java.util.List;

public class AccountInterestCalculator {

	public static void main(String[] args) {
		
		DepositAccount savings = new SavingsAccount(100);
		DepositAccount fd = new FixedDepositAccount(1000);
		
		List<DepositAccount> customerDepositAccounts = new ArrayList<>();
		customerDepositAccounts.add(savings);
		customerDepositAccounts.add(fd);
		
		double totalInterest = 0.0;
		for (DepositAccount account : customerDepositAccounts) {
			totalInterest += account.calculateInterestAccruedToCustomer();
		}
		System.out.println("Interest accrued to customer = " + totalInterest);
		
		MortgageAccount homeLoan = new HomeLoanAccount(50000);
		MortgageAccount carLoan = new HomeLoanAccount(20000);
		
		List<MortgageAccount> customerMortgageAccounts = new ArrayList<>();
		customerMortgageAccounts.add(homeLoan);
		customerMortgageAccounts.add(carLoan);
		
		for (MortgageAccount account : customerMortgageAccounts) {
			totalInterest += account.calculateInterestAccruedToBank();
		}
		System.out.println("Interest accrued to bank by customer = " + totalInterest);
	}

}
