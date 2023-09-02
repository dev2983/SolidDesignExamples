package com.designs.solid.ocp.better.code;

import java.math.BigDecimal;

import com.designs.solid.ocp.code.InsuranceClaimDto;
import com.designs.solid.ocp.code.Constants.PayorCodes;
import com.designs.solid.ocp.code.Constants.PlanType;
import com.designs.solid.ocp.code.Constants.PayorCodes.InsuranceType;

public class AetnaMedicalClaimCalculator implements InsuranceClaimCalculator {

	public String getPayorCode() {
		return PayorCodes.AETNA.getCode();
	}

	public String getInsuranceType() {
		return InsuranceType.Medical.name();
	}

	@Override
	public BigDecimal calculateSettlementAmount(InsuranceClaimDto claimDto) {
		
		BigDecimal settlementAmount = new BigDecimal("0.0");

		if (PlanType.Gold.name().equalsIgnoreCase(claimDto.getInsuranceType()) ) {
			BigDecimal multiplier = new BigDecimal(0.8);
			settlementAmount = new BigDecimal(claimDto.getClaimAmount()).multiply(multiplier);
		}
		else if (PlanType.Regular.name().equalsIgnoreCase(claimDto.getInsuranceType())) {
			BigDecimal multiplier = new BigDecimal(0.5);
			settlementAmount = new BigDecimal(claimDto.getClaimAmount() - claimDto.getCoPayAmount()).multiply(multiplier);
		}
	
		
		return settlementAmount;
	}

}
