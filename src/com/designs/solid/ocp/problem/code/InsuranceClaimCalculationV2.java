package com.designs.solid.ocp.problem.code;

import java.math.BigDecimal;

import com.designs.solid.ocp.code.Constants.PayorCodes;
import com.designs.solid.ocp.code.Constants.PlanType;
import com.designs.solid.ocp.code.Constants.PayorCodes.InsuranceType;
import com.designs.solid.ocp.code.InsuranceClaimDto;

/**
 * Violation of OCP Principle: code is showing high Cyclomatic Complexity
 */
public class InsuranceClaimCalculationV2 {

	public BigDecimal calculateSettlementAmount(InsuranceClaimDto claimDto) {
		
		BigDecimal settlementAmount = new BigDecimal("0.0");
		
		if(claimDto == null) {
			return settlementAmount;
		}
		
		if (PayorCodes.Cigna.getCode().equalsIgnoreCase(claimDto.getPayorCode())) {
			
			if (PlanType.Premium.name().equalsIgnoreCase(claimDto.getInsuranceType())) {
				BigDecimal multiplier = new BigDecimal(0.9);
				settlementAmount = new BigDecimal(claimDto.getClaimAmount()).multiply(multiplier);
			}
			else if (PlanType.Gold.name().equalsIgnoreCase(claimDto.getInsuranceType()) && InsuranceType.Medical.toString().equalsIgnoreCase(claimDto.getInsuranceType())) {
				BigDecimal multiplier = new BigDecimal(0.75);
				settlementAmount = new BigDecimal(claimDto.getClaimAmount()).multiply(multiplier);
			}
			else if (PlanType.Gold.name().equalsIgnoreCase(claimDto.getInsuranceType()) && InsuranceType.Rx.toString().equalsIgnoreCase(claimDto.getInsuranceType())) {
				BigDecimal multiplier = new BigDecimal(0.6);
				settlementAmount = new BigDecimal(claimDto.getClaimAmount()).multiply(multiplier);
			}
			else if (PlanType.Regular.name().equalsIgnoreCase(claimDto.getInsuranceType())) {
				BigDecimal multiplier = new BigDecimal(0.5);
				settlementAmount = new BigDecimal(claimDto.getClaimAmount() - claimDto.getCoPayAmount()).multiply(multiplier);
			}
		}
		else if (PayorCodes.AETNA.getCode().equalsIgnoreCase(claimDto.getPayorCode())) {
			
			if (PlanType.Gold.name().equalsIgnoreCase(claimDto.getInsuranceType()) && InsuranceType.Medical.toString().equalsIgnoreCase(claimDto.getInsuranceType())) {
				BigDecimal multiplier = new BigDecimal(0.8);
				settlementAmount = new BigDecimal(claimDto.getClaimAmount()).multiply(multiplier);
			}
			else if (PlanType.Gold.name().equalsIgnoreCase(claimDto.getInsuranceType()) && InsuranceType.Rx.toString().equalsIgnoreCase(claimDto.getInsuranceType())) {
				BigDecimal multiplier = new BigDecimal(0.6);
				settlementAmount = new BigDecimal(claimDto.getClaimAmount()).multiply(multiplier);
			}
			else if (PlanType.Gold.name().equalsIgnoreCase(claimDto.getInsuranceType()) && InsuranceType.Dental.toString().equalsIgnoreCase(claimDto.getInsuranceType())) {
				BigDecimal multiplier = new BigDecimal(0.7);
				settlementAmount = new BigDecimal(claimDto.getClaimAmount()).multiply(multiplier);
			}
			else if (PlanType.Regular.name().equalsIgnoreCase(claimDto.getInsuranceType())) {
				BigDecimal multiplier = new BigDecimal(0.5);
				settlementAmount = new BigDecimal(claimDto.getClaimAmount() - claimDto.getCoPayAmount()).multiply(multiplier);
			}
		}
		else if (PayorCodes.ANTHEM.getCode().equalsIgnoreCase(claimDto.getPayorCode())) {
			
			if (PlanType.Premium.name().equalsIgnoreCase(claimDto.getInsuranceType())) {
				BigDecimal multiplier = new BigDecimal(0.85);
				settlementAmount = new BigDecimal(claimDto.getClaimAmount()).multiply(multiplier);
			}
			else if (PlanType.Gold.name().equalsIgnoreCase(claimDto.getInsuranceType()) && 
					(InsuranceType.Rx.toString().equalsIgnoreCase(claimDto.getInsuranceType()) || 
							InsuranceType.Medical.toString().equalsIgnoreCase(claimDto.getInsuranceType())) ) {
				
				BigDecimal multiplier = new BigDecimal(0.8);
				settlementAmount = new BigDecimal(claimDto.getClaimAmount() - claimDto.getCoPayAmount()).multiply(multiplier);
			}
			else if (PlanType.Regular.name().equalsIgnoreCase(claimDto.getInsuranceType())) {
				BigDecimal multiplier = new BigDecimal(0.7);
				settlementAmount = new BigDecimal(claimDto.getClaimAmount() - claimDto.getCoPayAmount()).multiply(multiplier);
			}
		}
		
		
		return settlementAmount;
	}
}
