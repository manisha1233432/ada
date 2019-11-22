package com.cg.project.service;


import java.util.List;
import java.util.Map;

import com.cg.project.bean.Accounts;
import com.cg.project.bean.Policy;
import com.cg.project.bean.Report;
import com.cg.project.bean.UserRole;

public interface IInsuranceService {
	
	public boolean validLogin(UserRole userrole) throws Exception;
	
	public void createAccount(Accounts account) throws Exception;
	
	public double createPremium(Map<String, String> quesAnsMap) throws Exception;
	
	public Report generateReport(double accountNo) throws Exception;
	
	public boolean findAccount(int accountNo) throws Exception;
	
	public void createUser(UserRole userole) throws Exception;
	
	public int createPolicy(double premium, double accountNo) throws Exception;
	
	public List<String> getQuestions(String buisnessSegId) throws Exception;
	
	public List<String> getAnswers(String name) throws Exception;
	
	public List<Policy> getPolicy(String username) throws Exception;
	
	public boolean agentLogin(String userName, String password) throws Exception;
	
	//public Policy showOnePolicy(double policyNo) throws Exception;
	
	public double getAccountNo(String userName) throws Exception;
	
	public double getPolicyNo(double accountNo) throws Exception;
	
	public List<String> getUsers(String agentName) throws Exception;
	
	public void createAgent(String username, String password) throws Exception;
	
	public List<UserRole> viewAllUsers() throws Exception;
	
	public List<String> viewAllAgents() throws Exception;

}
