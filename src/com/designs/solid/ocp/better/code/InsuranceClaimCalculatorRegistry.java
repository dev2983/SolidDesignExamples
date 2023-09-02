package com.designs.solid.ocp.better.code;

import java.util.ArrayList;
import java.util.List;

public class InsuranceClaimCalculatorRegistry {

	private final List<InsuranceClaimCalculator> insuranceClaimCalculators = new ArrayList<>();
	private static InsuranceClaimCalculatorRegistry instance = new InsuranceClaimCalculatorRegistry();
	
	public static InsuranceClaimCalculatorRegistry get() {
		return instance;
	}
	private InsuranceClaimCalculatorRegistry() {
		register();
	}
	
	private void register() {
		
		insuranceClaimCalculators.add(new CignaMedicalClaimCalculator());
		insuranceClaimCalculators.add(new CignaRxClaimCalculator());
		insuranceClaimCalculators.add(new AetnaMedicalClaimCalculator());
		insuranceClaimCalculators.add(new AetnaRxClaimCalculator());
		insuranceClaimCalculators.add(new AetnaDentalClaimCalculator());
		insuranceClaimCalculators.add(new AnthemMedicalClaimCalculator());
		insuranceClaimCalculators.add(new AnthemRxClaimCalculator());
		insuranceClaimCalculators.add(new AnthemDentalClaimCalculator());
	}
	
	public List<InsuranceClaimCalculator> getInsuranceClaimCalculators() {
		return insuranceClaimCalculators;
	}
}
