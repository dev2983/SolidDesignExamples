package com.designs.solid.ocp.better.code;

import java.math.BigDecimal;

import com.designs.solid.ocp.code.InsuranceClaimDto;

public class InsuranceClaimCalculation {

public BigDecimal calculateSettlementAmount(InsuranceClaimDto claimDto) {
		
		BigDecimal settlementAmount = new BigDecimal("0.0");
		if(claimDto == null) {
			return settlementAmount;
		}
		
		InsuranceClaimCalculatorFactory calculatorFactory = InsuranceClaimCalculatorFactory.get();
		InsuranceClaimCalculator calculator = calculatorFactory.fetchInsuranceClaimCalculator(claimDto);
		settlementAmount = calculator.calculateSettlementAmount(claimDto);
		
		return settlementAmount;
	}
}
