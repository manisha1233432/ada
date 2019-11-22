package com.cg.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;



import com.cg.project.bean.Accounts;
import com.cg.project.bean.Policy;
import com.cg.project.bean.Report;
import com.cg.project.bean.UserRole;
import com.cg.project.util.DBUtil;

public class InsuranceDaoImpl implements IInsuranceDao{
	
	

	@Override
	public boolean validLogin(UserRole userrole) throws Exception {
		boolean flag = false;
			Connection con = DBUtil.getConnection();
			
			String query = "SELECT * FROM USER_ROLE_TBL WHERE USERNAME = ? AND PASSWORD = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, userrole.getUserName());
			pst.setString(2, userrole.getPassword());
			ResultSet rst = pst.executeQuery();
			
			if(rst.next()){
				String user = rst.getString(1);
				String pass = rst.getString(2);
				if(user.equals(userrole.getUserName()) && pass.equals(userrole.getPassword())){
					flag = true;
					
				}
				else{
					flag = false;
					
				}
			}
			con.close();
		return flag;
	}

	@Override
	public void createAccount(Accounts account) throws Exception {
			Connection con = DBUtil.getConnection();
			
			String qry = "insert into accounts_new_tbl values(account_seq.nextval,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(qry);
			pst.setString(1, account.getInsuredName());
			pst.setString(2, account.getInsuredStreet());
			pst.setString(3, account.getInsuredCity());
			pst.setString(4, account.getInsuredState());
			pst.setInt(5, account.getInsuredZip());
			pst.setString(6, account.getBusSegId());
			pst.setString(7, account.getAgentName());
			pst.setString(8, account.getUserName());
			pst.executeUpdate();
			
			con.close();
	}

	@Override
	public double createPremium(Map<String, String> quesAnsMap) throws Exception {
		double premium = 0;
			Connection con = DBUtil.getConnection();
			
			String query = "SELECT POL_QUES_ANS_WEIGHTAGE FROM POLICY_WEIGHT_TBL WHERE POL_QUES_DESC = ? AND POL_QUES_ANS = ?";
			PreparedStatement pst = con.prepareStatement(query);
			Set<String> ques = quesAnsMap.keySet();
			for(String questions : ques){
			pst.setString(1, questions);
			pst.setString(2, quesAnsMap.get(questions));
			ResultSet rst = pst.executeQuery();
			
			if(rst.next()){
				premium += rst.getInt("POL_QUES_ANS_WEIGHTAGE");
			}
			}
			
		return premium;
	}

	@Override
	public Report generateReport(double accountNo) throws Exception {
		Report report = null;
			Connection con = DBUtil.getConnection();
		
			String query = "SELECT A.INSUREDNAME, A.INSURESDSTREET, A.INSUREDCITY, A.INSUREDSTATE, A.INSUREDZIP, A.BUSINESSSEG, P1.POLICYPREMIUM FROM ACCOUNTS_NEW_TBL A, POLICY_TBL P1 WHERE A.ACCOUNTNO = P1.ACCOUNTNO AND A.ACCOUNTNO = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setDouble(1, accountNo);
			ResultSet rst = pst.executeQuery();
			
			if(rst.next()){
				String insuredName = rst.getString("INSUREDNAME");
				String insuredStreet = rst.getString("INSURESDSTREET");
				String insuredCity = rst.getString("INSUREDCITY");
				String insuredState = rst.getString("INSUREDSTATE");
				int insuredZip = rst.getInt("INSUREDZIP");
				String buisnessSeg = rst.getString("BUSINESSSEG");
				double premium = rst.getDouble("POLICYPREMIUM");
				report = new Report(insuredName, insuredStreet, insuredCity, insuredState, insuredZip, buisnessSeg, premium);
			}
			
		return report;
	}

	@Override
	public boolean findAccount(int accountNo) throws Exception {
		boolean flag = false;
			Connection con = DBUtil.getConnection();
			
			String query = "SELECT * FROM ACCOUNTS_NEW_TBL";
			PreparedStatement pStatement = con.prepareStatement(query);
			pStatement.setInt(1, accountNo);
			ResultSet result = pStatement.executeQuery();
			
			while(result.next()){
				if(accountNo == result.getInt(1)){ //position accountNo from table
					flag = true;
					
				}
			}
		return flag;
	}

	@Override
	public void createUser(UserRole userole) throws Exception {
			Connection con = DBUtil.getConnection();
			
			String query = "INSERT INTO USER_ROLE_TBL VALUES (?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, userole.getUserName());
			pst.setString(2, userole.getPassword());
			pst.setString(3, "insured");
			pst.executeUpdate();
			
			con.close();
		
	}

	@Override
	public int createPolicy(double premium, double accountNo) throws Exception {
		int id = 0;
			Connection con = DBUtil.getConnection();
			
			String query="INSERT INTO POLICY_TBL VALUES (POLICYNO_SEQ.NEXTVAL,?,?)";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setDouble(1, premium);
			pstmt.setDouble(2, accountNo);
			id = pstmt.executeUpdate();
			
		return id;
	}

	@Override
	public List<String> getQuestions(String buisnessSegId) throws Exception {
		List<String> queslist = new ArrayList<String>();
			Connection con = DBUtil.getConnection();
			  LocalDateTime now = LocalDateTime.now(); 
			  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			  System.out.println(dtf.format(now));  
			
			
			String query = "SELECT * FROM POLICY_QUESTIONS_TBL WHERE BUS_SEG_ID = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, buisnessSegId);
			ResultSet rst = pst.executeQuery();
			
			while(rst.next()){
				queslist.add(rst.getString(3)); //position Questions from table
			}
			
		return queslist;
	}

	@Override
	public List<String> getAnswers(String name) throws Exception {
		List<String> anslist = new ArrayList<String>();
			Connection con = DBUtil.getConnection();
			
			String query = "SELECT * FROM POLICY_QUESTIONS_TBL WHERE POL_QUES_DESC = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, name);
			ResultSet rst = pst.executeQuery();
			
			while(rst.next()){
				String ans1 = rst.getString(4); //position answer1 from table
				String ans2 = rst.getString(6); //position answer2 from table
				String ans3 = rst.getString(8); //position answer3 from table
				anslist.add(ans1);
				anslist.add(ans2);
				anslist.add(ans3);
			}
			
		return anslist;
	}

	@Override
	public List<Policy> getPolicy(String username) throws Exception {
		List<Policy> policyList = new ArrayList<Policy>();
		Policy policy = null;
			Connection con = DBUtil.getConnection();
			
			String query = "SELECT P.POLICYNO, P.POLICYPREMIUM, A.ACCOUNTNO FROM POLICY_TBL P, ACCOUNTS_NEW_TBL A WHERE A.ACCOUNTNO = P.ACCOUNTNO AND A.USERNAME = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, username);
			ResultSet rst = pst.executeQuery();
			
			while(rst.next()){
			double policyno = rst.getDouble(1); //position policyno from table
			double policyprem = rst.getDouble(2); //position policyprem from table
			long accountNo = (long) rst.getDouble(3); //position accountNo from table
			policy = new Policy(policyno, policyprem, accountNo);
			policyList.add(policy);
			}
			
		return policyList;
	}

	@Override
	public boolean agentLogin(String userName, String password) throws Exception {
		boolean flag = false;
			Connection con = DBUtil.getConnection();
			
			String query = "SELECT USERNAME, PASSWORD FROM AGENT_TBL WHERE USERNAME = ? AND PASSWORD = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, userName);
			pst.setString(2, password);
			ResultSet rst = pst.executeQuery();
			
			if(rst.next()){
					flag = true;
					
			}
		return flag;
	}


	public double getAccountNo(String userName) throws Exception{
		double accountNo = 0;
			Connection con = DBUtil.getConnection();
			
			String query = "SELECT ACCOUNTNO FROM ACCOUNTS_NEW_TBL WHERE USERNAME = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, userName);
			ResultSet rst = pst.executeQuery();
			
			if(rst.next()){
				accountNo = rst.getDouble("ACCOUNTNO");
			}
			
		return accountNo;
	}	
	
	public double getPolicyNo(double accountNo) throws Exception{
		double policyNo = 0;
			Connection con = DBUtil.getConnection();
			
			String query = "SELECT POLICYNO FROM POLICY_TBL WHERE ACCOUNTNO = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setDouble(1, accountNo);
			ResultSet rst = pst.executeQuery();
			
			if(rst.next()){
				policyNo = rst.getDouble("POLICYNO");
			}
		
		return policyNo; 
	}
	
	public List<String> getUsers(String agentName) throws Exception{
		List<String> agentNameList = new ArrayList<String>();
			Connection con = DBUtil.getConnection();
			
			String query = "SELECT INSUREDNAME FROM ACCOUNTS_NEW_TBL WHERE AGENT_NAME = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, agentName);
			ResultSet rst = pst.executeQuery();
			
			while(rst.next()){
				String userName = rst.getString("INSUREDNAME");
				agentNameList.add(userName);
			}
			
		return agentNameList;
		}
	
	public void createAgent(String username, String password) throws Exception{
			Connection con = DBUtil.getConnection();
			
			String query = "INSERT INTO AGENT_TBL VALUES (?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, password);
			pst.executeUpdate();
			
	}
		
		public List<UserRole> viewAllUsers() throws Exception{
			List<UserRole> roleList = new ArrayList<UserRole>();
				Connection con = DBUtil.getConnection();
				
				String query = "SELECT * FROM USER_ROLE_TBL";
				PreparedStatement pst = con.prepareStatement(query);
				ResultSet rst = pst.executeQuery();
				
				while(rst.next()){
					String username = rst.getString("userName");
					String password = rst.getString("password");
					String urole = rst.getString("roleCode");
					UserRole userole = new UserRole(username, password, urole);
					roleList.add(userole);
				}
				
			return roleList;
		}
		
		public List<String> viewAllAgents() throws Exception{
			List<String> agentList = new ArrayList<String>();
				Connection con = DBUtil.getConnection();
				
				String query = "SELECT USERNAME FROM AGENT_TBL";
				PreparedStatement pst = con.prepareStatement(query);
				ResultSet rst = pst.executeQuery();
				
				while(rst.next()){
					String username = rst.getString("userName");
					agentList.add(username);
				}
				
			return agentList;
		}
	
}
