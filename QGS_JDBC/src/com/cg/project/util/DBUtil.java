package com.cg.project.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBUtil {
	
	public static Connection getConnection() throws Exception{
		
		Connection con = null;
			try{
			String className = "oracle.jdbc.driver.OracleDriver";
			String user = "system";
			String pass = "oracle";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			Class.forName(className);
			con = DriverManager.getConnection(url, user, pass);
			}
			catch(Exception e){
				throw new Exception("Connection Failed");
			}
		return con;
	}

}
