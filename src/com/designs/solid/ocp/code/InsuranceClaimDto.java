package com.designs.solid.ocp.code;

import java.util.List;

public class InsuranceClaimDto {

	private int claimId;
	private String payorName;
	private String payorCode;
	private double claimAmount;
	private List<String> claimItems;
	private String insuranceType;
	private double coPayAmount;
	public int getClaimId() {
		return claimId;
	}
	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}
	public String getPayorName() {
		return payorName;
	}
	public void setPayorName(String payorName) {
		this.payorName = payorName;
	}
	public String getPayorCode() {
		return payorCode;
	}
	public void setPayorCode(String payorCode) {
		this.payorCode = payorCode;
	}
	public double getClaimAmount() {
		return claimAmount;
	}
	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}
	public List<String> getClaimItems() {
		return claimItems;
	}
	public void setClaimItems(List<String> claimItems) {
		this.claimItems = claimItems;
	}
	public String getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	public double getCoPayAmount() {
		return coPayAmount;
	}
	public void setCoPayAmount(double coPayAmount) {
		this.coPayAmount = coPayAmount;
	}
	
	@Override
	public String toString() {
		return "InsuranceClaimDto [claimId=" + claimId + ", payorName=" + payorName + ", payorCode=" + payorCode
				+ ", claimAmount=" + claimAmount + ", claimItems=" + claimItems + ", insuranceType=" + insuranceType
				+ ", coPayAmount=" + coPayAmount + "]";
	}
	
}
