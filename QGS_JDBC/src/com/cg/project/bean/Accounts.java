package com.cg.project.bean;

public class Accounts {

	private double accountNumber;
	private String insuredName;
	private String insuredStreet;
	private String insuredCity;
	private String insuredState;
	private int insuredZip;
	private String busSegId;
	private String agentName;
	private String userName;

	public Accounts() {
		super();
	}

	public Accounts(String insuredName, String insuredStreet, String insuredCity, String insuredState, int insuredZip,
			String busSegId, String agentName, String userName) {
		super();
		this.insuredName = insuredName;
		this.insuredStreet = insuredStreet;
		this.insuredCity = insuredCity;
		this.insuredState = insuredState;
		this.insuredZip = insuredZip;
		this.busSegId = busSegId;
		this.agentName = agentName;
		this.userName = userName;
	}


	public double getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(double accountNumber) {
		this.accountNumber = accountNumber;
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

	public int getInsuredZip() {
		return insuredZip;
	}

	public void setInsuredZip(int insuredZip) {
		this.insuredZip = insuredZip;
	}

	public String getBusSegId() {
		return busSegId;
	}

	public void setBusSegId(String busSegId) {
		this.busSegId = busSegId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	
	
	
}
