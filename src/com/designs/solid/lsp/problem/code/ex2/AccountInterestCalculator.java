package com.designs.solid.lsp.problem.code.ex2;

import java.util.ArrayList;
import java.util.List;

public class AccountInterestCalculator {

	public static void main(String[] args) {
		
		Account savings = new SavingsAccount(10000);
		Account fd = new FixedDepositAccount(100000);
		Account homeLoan = new HomeLoanAccount(500000);
		
		List<Account> customerAccounts = new ArrayList<>();
		customerAccounts.add(savings);
		customerAccounts.add(fd);
		customerAccounts.add(homeLoan);
		
		for (Account account : customerAccounts) {
			System.out.println(account.calculateInterest());
		}
	}

}
