package com.designs.solid.ocp.problem.code;

import java.math.BigDecimal;

import com.designs.solid.ocp.code.Constants.PayorCodes.InsuranceType;
import com.designs.solid.ocp.code.Constants.PlanType;
import com.designs.solid.ocp.code.InsuranceClaimDto;

public class InsuranceClaimCalculationV1 {

	public BigDecimal calculateSettlementAmount(InsuranceClaimDto claimDto) {
		
		BigDecimal settlementAmount = new BigDecimal("0.0");
		if(claimDto == null) {
			return settlementAmount;
		}
		
		if (PlanType.Premium.name().equalsIgnoreCase(claimDto.getInsuranceType())) {
			BigDecimal multiplier = new BigDecimal(0.9);
			settlementAmount = new BigDecimal(claimDto.getClaimAmount()).multiply(multiplier);
		}
		else if (PlanType.Gold.name().equalsIgnoreCase(claimDto.getInsuranceType()) && 
				InsuranceType.Medical.toString().equalsIgnoreCase(claimDto.getInsuranceType())) {
			BigDecimal multiplier = new BigDecimal(0.75);
			settlementAmount = new BigDecimal(claimDto.getClaimAmount()).multiply(multiplier);
		}
		else if (PlanType.Gold.name().equalsIgnoreCase(claimDto.getInsuranceType()) && 
				InsuranceType.Rx.toString().equalsIgnoreCase(claimDto.getInsuranceType())) {
			BigDecimal multiplier = new BigDecimal(0.6);
			settlementAmount = new BigDecimal(claimDto.getClaimAmount()).multiply(multiplier);
		}
		else if (PlanType.Regular.name().equalsIgnoreCase(claimDto.getInsuranceType())) {
			BigDecimal multiplier = new BigDecimal(0.5);
			settlementAmount = new BigDecimal(claimDto.getClaimAmount() - claimDto.getCoPayAmount()).multiply(multiplier);
		}
		
		return settlementAmount;
	}
}
