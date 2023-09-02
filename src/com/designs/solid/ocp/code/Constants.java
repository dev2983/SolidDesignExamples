package com.designs.solid.ocp.code;

public class Constants {

	private Constants () {}
	
	public enum PlanType {
		Regular, Gold, Premium
	}
	
	public enum PayorCodes {
		Cigna("CG"), AETNA("AET"), ANTHEM("ANTH");
		
		private String code;
		PayorCodes(String code) {
			this.code = code;
		}
		
		public String getCode() {
			return code;
		}
		
		public enum InsuranceType {
			Medical, Rx, Dental
		}
	}
	
}
