package com.designs.solid.ocp.better.code;

import java.util.List;

import com.designs.solid.ocp.code.InsuranceClaimDto;

public class InsuranceClaimCalculatorFactory {
	
	private static InsuranceClaimCalculatorFactory instance = new InsuranceClaimCalculatorFactory();
	
	private InsuranceClaimCalculatorFactory() {}
	
	public static InsuranceClaimCalculatorFactory get() {
		return instance;
	}
	
	public InsuranceClaimCalculator fetchInsuranceClaimCalculator(InsuranceClaimDto claimDto) {
		
		InsuranceClaimCalculatorRegistry registry = InsuranceClaimCalculatorRegistry.get();
		List<InsuranceClaimCalculator> calulators = registry.getInsuranceClaimCalculators();
		
		InsuranceClaimCalculator outputCalculator = null;
		for(InsuranceClaimCalculator calculator : calulators) {
			
			if (calculator.getPayorCode().equalsIgnoreCase(claimDto.getPayorCode()) && calculator.getInsuranceType().equalsIgnoreCase(claimDto.getInsuranceType())) {
				outputCalculator = calculator;
				break;
			}
		}
		
		return outputCalculator;
	}

}
