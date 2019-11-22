package com.cg.project.bean;

public class PolicyQuestions {

	private String polQuesDesc;
	private String polQuesAns1;
	private int polQuesAns1Weightage;
	private String polQuesAns2;
	private int polQuesAns2Weightage;
	private String polQuesAns3;
	private int polQuesAns3Weightage;

	public PolicyQuestions(String polQuesDesc, String polQuesAns1, int polQuesAns1Weightage,
			String polQuesAns2, int polQuesAns2Weightage, String polQuesAns3,
			int polQuesAns3Weightage) {
		super();
		this.polQuesDesc = polQuesDesc;
		this.polQuesAns1 = polQuesAns1;
		this.polQuesAns1Weightage = polQuesAns1Weightage;
		this.polQuesAns2 = polQuesAns2;
		this.polQuesAns2Weightage = polQuesAns2Weightage;
		this.polQuesAns3 = polQuesAns3;
		this.polQuesAns3Weightage = polQuesAns3Weightage;
	}

	public PolicyQuestions() {
		super();
	}

	public String getPolQuesDesc() {
		return polQuesDesc;
	}

	public void setPolQuesDesc(String polQuesDesc) {
		this.polQuesDesc = polQuesDesc;
	}

	public String getPolQuesAns1() {
		return polQuesAns1;
	}

	public void setPolQuesAns1(String polQuesAns1) {
		this.polQuesAns1 = polQuesAns1;
	}

	public int getPolQuesAns1Weightage() {
		return polQuesAns1Weightage;
	}

	public void setPolQuesAns1Weightage(int polQuesAns1Weightage) {
		this.polQuesAns1Weightage = polQuesAns1Weightage;
	}

	public String getPolQuesAns2() {
		return polQuesAns2;
	}

	public void setPolQuesAns2(String polQuesAns2) {
		this.polQuesAns2 = polQuesAns2;
	}

	public int getPolQuesAns2Weightage() {
		return polQuesAns2Weightage;
	}

	public void setPolQuesAns2Weightage(int polQuesAns2Weightage) {
		this.polQuesAns2Weightage = polQuesAns2Weightage;
	}

	public String getPolQuesAns3() {
		return polQuesAns3;
	}

	public void setPolQuesAns3(String polQuesAns3) {
		this.polQuesAns3 = polQuesAns3;
	}

	public int getPolQuesAns3Weightage() {
		return polQuesAns3Weightage;
	}

	public void setPolQuesAns3Weightage(int polQuesAns3Weightage) {
		this.polQuesAns3Weightage = polQuesAns3Weightage;
	}

}
