package com.cg.project.service;

import java.util.List;
import java.util.Map;

import com.cg.project.bean.Accounts;
import com.cg.project.bean.Policy;
import com.cg.project.bean.Report;
import com.cg.project.bean.UserRole;
import com.cg.project.dao.IInsuranceDao;
import com.cg.project.dao.InsuranceDaoImpl;

public class InsuranceServiceImpl implements IInsuranceService{
	
	IInsuranceDao dao = new InsuranceDaoImpl();

	@Override
	public boolean validLogin(UserRole userrole) throws Exception {
		boolean flag = dao.validLogin(userrole);
		return flag;
	}

	@Override
	public void createAccount(Accounts account) throws Exception {
		dao.createAccount(account);
	}

	@Override
	public double createPremium(Map<String, String> quesAnsMap) throws Exception {
		double premium = dao.createPremium(quesAnsMap);
		return premium;
	}

	@Override
	public Report generateReport(double accountNo) throws Exception {
		Report reportList = dao.generateReport(accountNo);
		return reportList;
	}

	@Override
	public boolean findAccount(int accountNo) throws Exception {
		boolean account = dao.findAccount(accountNo);
		return account;
	}

	@Override
	public void createUser(UserRole userole) throws Exception {
		dao.createUser(userole);
		
	}

	@Override
	public int createPolicy(double premium, double accountNo) throws Exception {
		int policyNo = dao.createPolicy(premium, accountNo);
		return policyNo;
	}

	@Override
	public List<String> getQuestions(String buisnessSegId) throws Exception {
		List<String> quesList = dao.getQuestions(buisnessSegId);
		return quesList;
	}

	@Override
	public List<String> getAnswers(String name) throws Exception {
		List<String> ansList = dao.getAnswers(name);
		return ansList;
	}

	@Override
	public List<Policy> getPolicy(String username) throws Exception {
		List<Policy> policy = dao.getPolicy(username);
		return policy;
	}

	@Override
	public boolean agentLogin(String userName, String password) throws Exception {
		boolean flag = dao.agentLogin(userName, password);
		return flag;
	}


	public double getAccountNo(String userName) throws Exception{
		double accountNo = dao.getAccountNo(userName);
		return accountNo;
	}
	
	public double getPolicyNo(double accountNo) throws Exception {
		double policyNo = dao.getPolicyNo(accountNo);
		return policyNo;
	}
	
	public List<String> getUsers(String agentName) throws Exception{
		List<String> agentNameList = dao.getUsers(agentName);
		return agentNameList;
	}
	
	public void createAgent(String username, String password) throws Exception{
		dao.createAgent(username, password);
	}
	
	public List<UserRole> viewAllUsers() throws Exception{
		List<UserRole> roleList = dao.viewAllUsers();
		return roleList;
	}

	@Override
	public List<String> viewAllAgents() throws Exception {
		List<String> agentList = dao.viewAllAgents();
		return agentList;
	}

}
