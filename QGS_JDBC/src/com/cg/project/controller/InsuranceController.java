package com.cg.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.cg.project.bean.Accounts;
import com.cg.project.bean.Policy;
import com.cg.project.bean.PolicyQuestions;
import com.cg.project.bean.Report;
import com.cg.project.bean.UserRole;
import com.cg.project.service.IInsuranceService;
import com.cg.project.service.InsuranceServiceImpl;

/**
 * Servlet implementation class InsuranceController
 */
@WebServlet("*.qgs")
public class InsuranceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IInsuranceService service = new InsuranceServiceImpl();
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsuranceController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = null;
		String path = request.getServletPath().trim();
		String resource = "";
		System.out.println("Path = " + path);
		switch (path) {
		case "/admin.qgs":
			String user = request.getParameter("user").trim();
			String pass = request.getParameter("pass").trim();
			if (user.equals("admin") && pass.equals("admin")) {
				resource = "adminTask.jsp"; // admin login success
				
			} else {
				resource = "failure.jsp"; // admin login failed
				
			}
			RequestDispatcher rd = request.getRequestDispatcher(resource);
			rd.forward(request, response);
			break;
		case "/agent.qgs":
			String user2 = request.getParameter("user").trim();
			String pass2 = request.getParameter("pass").trim();
			boolean agentflag = false;
			try {
				agentflag = service.agentLogin(user2, pass2);
				if (agentflag == true) {
					session = request.getSession(true);
					session.setAttribute("agent", user2);
					
					resource = "agentTask.jsp"; // agent login success
				} else {
					resource = "failure.jsp"; // agent login failed
					
				}
			} catch (Exception e) {
				resource = "failure.jsp";
			}
			RequestDispatcher rdagent = request.getRequestDispatcher(resource);
			rdagent.forward(request, response);
			break;
		case "/insuredCheckLogin.qgs":
			String user1 = request.getParameter("user").trim();
			String pass1 = request.getParameter("pass").trim();
			UserRole userrole = new UserRole(user1, pass1, "insured");
			boolean insuredflag = false;
			try {
				insuredflag = service.validLogin(userrole);
			} catch (Exception e) {
				resource = "failure.jsp";
				
			}
			if (insuredflag == true) {
				try {
					session = request.getSession(true);
					session.setAttribute("user", user1);
					
					out.println("<h1> Login success ");
					resource = "policy.jsp";
				} catch (Exception e) {
					resource = "failure.jsp";
					
				}
			} else {
				resource = "failure.jsp";
				
			}
			RequestDispatcher rd1 = request.getRequestDispatcher(resource);
			rd1.forward(request, response);
			break;
		case "/createUser.qgs":
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			UserRole userole = new UserRole(username, password, "insured");
			try {
				service.createUser(userole);
				resource = "signupForCustomer.jsp";	
				
			} catch (Exception e) {
				resource = "failure.jsp";
				
			}
			RequestDispatcher rdcreateUser = request.getRequestDispatcher(resource);
			rdcreateUser.forward(request, response);
			break;
		case "/signUpAgent.qgs" :
			String usernameAgent = request.getParameter("username");
			String passwordAgent = request.getParameter("password");
			try{
				service.createAgent(usernameAgent, passwordAgent);
				
				resource = "adminTask.jsp";
			} catch (Exception e) {
				resource = "failure.jsp";
				
			}
			RequestDispatcher rdcreateAgent = request.getRequestDispatcher(resource);
			rdcreateAgent.forward(request, response);
			break;
		case "/createAccount.qgs":
			System.out.println("start1");
			String insuredName = request.getParameter("insuredName");
			String insuredStreet = request.getParameter("insuredStreet");
			String insuredCity = request.getParameter("insuredCity");
			String insuredState = request.getParameter("insuredState");
			Integer insuredZip = Integer.parseInt(request.getParameter("insuredZip"));
			String buisnessSeg = request.getParameter("businessSeg");
			String agentUser = request.getParameter("agentUser");
			String userName = request.getParameter("userName");
			System.out.println("start2");
			Accounts account = new Accounts(insuredName, insuredStreet, insuredCity, insuredState, insuredZip,
					buisnessSeg, agentUser, userName);
			try {
				System.out.println("start");
				service.createAccount(account);
				System.out.println("Account Created");
				
				request.setAttribute("accountNo", account.getAccountNumber());
				System.out.println(service.getAccountNo(userName));
				resource = "customerLogin.jsp";
				RequestDispatcher rdcreateAcc = request.getRequestDispatcher(resource);
				rdcreateAcc.forward(request, response);
			} catch (Exception e) {
				resource = "failure.jsp";
				
			}
			break;
		case "/viewPolicies.qgs":
			try {
				session = request.getSession(true);
				String userName1 =(String)session.getAttribute("user");
				List<Policy> policies = service.getPolicy(userName1);
				
				request.setAttribute("policies", policies);
				resource = "viewPolicies.jsp";
				RequestDispatcher rdcreatePol = request.getRequestDispatcher(resource);
				rdcreatePol.forward(request, response);
			} catch (Exception e) {
				resource = "failure.jsp";
				
			}
			break;
		case "/getQuesAnswers.qgs":
			List<String> quesList = null;
			List<String> ansList = null;
			String businessId = "";
			List<PolicyQuestions> polList = new ArrayList<PolicyQuestions>();
			String businessIdSeg = request.getParameter("businessSeg");
			if(businessIdSeg.equals("RESTAURANT")){
				businessId = "10001";
			} else if(businessIdSeg.equals("VEHICLE")){
				businessId = "10002";
			} else if(businessIdSeg.equals("APARTMENT")){
				businessId = "10003";
			} else if(businessIdSeg.equals("GENERAL MERCHANT")){
				businessId = "10004";
			}
			try {
				quesList = service.getQuestions(businessId);
				
				for (String qstr : quesList) {
					System.out.println(qstr);
					
					ansList = service.getAnswers(qstr);
					
					for (String astr : ansList) {
						System.out.print(" " + astr + " ");
						
					}
					System.out.println();
					PolicyQuestions polques = new PolicyQuestions(qstr, ansList.get(0), 200, ansList.get(1), 400,
							ansList.get(2), 600);
					polList.add(polques);
				}
				
				request.setAttribute("polquesList", polList);
				resource = "policyQuestions.jsp";
			} catch (Exception e) {
				resource = "failure.jsp";
				
			}
			RequestDispatcher rdgetQuesAns = request.getRequestDispatcher(resource);
			rdgetQuesAns.forward(request, response);
			break;
		case "/calWeightage.qgs":
			int listSize = Integer.parseInt(request.getParameter("listSize"));
			double ptotal = 0;
			Map<String, String> quesAnsMap = new LinkedHashMap<>();
			for (int i = 1; i <= listSize; i++) {
				String ques = request.getParameter("quesVal" + i);
				String ans = request.getParameter("radio" + i);
				quesAnsMap.put(ques, ans);
			}
			
			try{
			ptotal = service.createPremium(quesAnsMap);//function call
			
			System.out.println(ptotal);
			request.setAttribute("premium", ptotal);
			} catch (Exception e) {
				resource = "failure.jsp";
				
			}
			session = request.getSession(true);
			String userName2 =(String)session.getAttribute("user");
			System.out.println(""+userName2);
			try{
			double accountNo1 = service.getAccountNo(userName2);
			
			System.out.println(""+accountNo1);
			service.createPolicy(ptotal, accountNo1);
			
			} catch(Exception e){
				resource = "failure.jsp";
				
			}
			resource = "showPremium.jsp";
			RequestDispatcher rdprem = request.getRequestDispatcher(resource);
			rdprem.forward(request, response);
			break;
		case "/viewReport.qgs":
			Report repList = null;
			try {
				session = request.getSession(true);
				String userName1 = (String) session.getAttribute("user");
				System.out.println(""+userName1);
				double accountNo = service.getAccountNo(userName1);
				System.out.println(""+accountNo);
				repList = service.generateReport(accountNo);
				
				double policyNo1 = service.getPolicyNo(accountNo);
				System.out.println(repList);
				request.setAttribute("policyNo1", policyNo1);
				request.setAttribute("repList", repList);
				resource = "showReport.jsp";
			} catch (Exception e) {
				resource = "failure.jsp";
				
			}
			RequestDispatcher rdreport = request.getRequestDispatcher(resource);
			rdreport.forward(request, response);
			break;
		case "/agentUser.qgs" :
			try{
				session = request.getSession(true);
				String userName1 = (String) session.getAttribute("agent");
				System.out.println(""+userName1);
				List<String> agentNameList = service.getUsers(userName1);
				
				request.setAttribute("agentNameList", agentNameList);
				resource = "showAgentUsers.jsp";
			} catch (Exception e) {
				resource = "failure.jsp";
				
			}
			RequestDispatcher rdAgentUser = request.getRequestDispatcher(resource);
			rdAgentUser.forward(request, response);
			break;
		case "/logout.qgs" :
			session = request.getSession(false);
			if(session == null )
			{
				resource = "failure.jsp";
				
			}
			else
			{
			session.getAttribute("user");
			
			resource = "Intro.jsp";
			}
			RequestDispatcher rdlogout = request.getRequestDispatcher(resource);
			rdlogout.forward(request, response);
			break;
		case "/viewAllUsers.qgs" :
			try{
				List<UserRole> roleList = service.viewAllUsers();
				request.setAttribute("roleList", roleList);
				
				resource = "viewAllUsers.jsp";
				} catch (Exception e) {
				resource = "failure.jsp";
				
			}
			RequestDispatcher rdAllUsers = request.getRequestDispatcher(resource);
			rdAllUsers.forward(request, response);
			break;
		case "/viewAllAgents.qgs" :
			try{
				List<String> agentList = service.viewAllAgents();
				request.setAttribute("agentList", agentList);
				
				resource = "viewAllAgents.jsp";
			} catch (Exception e) {
				resource = "failure.jsp";
				
			}
			RequestDispatcher rdAllAgents = request.getRequestDispatcher(resource);
			rdAllAgents.forward(request, response);
			break;
			
		}
	}

}
