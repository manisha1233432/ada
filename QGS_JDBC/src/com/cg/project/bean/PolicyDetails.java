package com.cg.project.bean;

public class PolicyDetails {

	private double policyNumber;
	private String questionId;
	private String answer;
	
	
	
	
	public PolicyDetails(double policyNumber, String questionId, String answer) {
		super();
		this.policyNumber = policyNumber;
		this.questionId = questionId;
		this.answer = answer;
	}
	
	
	public PolicyDetails() {
		super();
	}


	public double getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(double policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	
}
