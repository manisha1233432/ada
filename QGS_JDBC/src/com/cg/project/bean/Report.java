package com.cg.project.bean;

public class Report {

	private String insuredName;
	private String insuredStreet;
	private String insuredCity;
	private String insuredState;
	private Integer insuredZip;
	private String businessSegment;
	private Double policyPremium;

	public Report(String insuredName, String insuredStreet, String insuredCity, String insuredState,
			Integer insuredZip, String businessSegment,
			Double policyPremium) {
		super();
		this.insuredName = insuredName;
		this.insuredStreet = insuredStreet;
		this.insuredCity = insuredCity;
		this.insuredState = insuredState;
		this.insuredZip = insuredZip;
		this.businessSegment = businessSegment;
		this.policyPremium = policyPremium;
	}

	public Report() {
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public String getInsuredStreet() {
		return insuredStreet;
	}

	public void setInsuredStreet(String insuredStreet) {
		this.insuredStreet = insuredStreet;
	}

	public String getInsuredCity() {
		return insuredCity;
	}

	public void setInsuredCity(String insuredCity) {
		this.insuredCity = insuredCity;
	}

	public String getInsuredState() {
		return insuredState;
	}

	public void setInsuredState(String insuredState) {
		this.insuredState = insuredState;
	}

	public Integer getInsuredZip() {
		return insuredZip;
	}

	public void setInsuredZip(Integer insuredZip) {
		this.insuredZip = insuredZip;
	}

	public String getBusinessSegment() {
		return businessSegment;
	}

	public void setBusinessSegment(String businessSegment) {
		this.businessSegment = businessSegment;
	}

	public Double getPolicyPremium() {
		return policyPremium;
	}

	public void setPolicyPremium(Double policyPremium) {
		this.policyPremium = policyPremium;
	}


	@Override
	public String toString() {
		return "ReportGeneration [insuredName=" + insuredName + ", insuredStreet=" + insuredStreet + ", insuredCity="
				+ insuredCity + ", insuredState=" + insuredState + ", insuredZip=" + insuredZip + ", businessSegment="
				+ businessSegment + ", policyPremium=" + policyPremium + "]";
	}

}
