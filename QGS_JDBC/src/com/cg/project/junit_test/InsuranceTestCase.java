package com.cg.project.junit_test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.cg.project.bean.UserRole;
import com.cg.project.dao.IInsuranceDao;
import com.cg.project.dao.InsuranceDaoImpl;

public class InsuranceTestCase {
	
	IInsuranceDao dao = new InsuranceDaoImpl();
	
	@Test
	public void loginTest1() throws Exception{
		UserRole user = new UserRole("Akash08", "Akash@08", "insured");
		boolean actual = dao.validLogin(user);
		assertEquals(true, actual);
	}
	
	@Test
	public void loginTest2() throws Exception{
		UserRole user = new UserRole("A", "A", "insured");
		boolean actual = dao.validLogin(user);
		assertEquals(false, actual);
	}
	
	@Test
	public void createPremium1() throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		map.put("Restaurant Type", "Only Dining");
		map.put("Restaurant SQ Ft.", "Less than 1500sq.ft");
		double actual = dao.createPremium(map);
		assertEquals(400.0, actual,0.0);
	}
	
	@Test
	public void agentLogin1() throws Exception{
		boolean agent = dao.agentLogin("abhiram", "abhiram");
		assertEquals(true, agent);
	}
	
	@Test
	public void getAccountNo() throws Exception{
		double actual = dao.getAccountNo("Akash08");
		assertEquals(91, actual,0.0);
	}
	
	@Test
	public void getPolicyNo() throws Exception{
		double actual = dao.getPolicyNo(90);
		assertEquals(1047, actual,0.0);
	}
}
