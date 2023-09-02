package com.designs.solid.ocp.better.code;

import java.math.BigDecimal;

import com.designs.solid.ocp.code.InsuranceClaimDto;

public interface InsuranceClaimCalculator {

	BigDecimal calculateSettlementAmount(InsuranceClaimDto claimDto);
	String getPayorCode();
	String getInsuranceType();
}
