package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionManager {
	
	static Connection con;

	public Connection getConnection() {
		//set parameters to login
		String url = "jdbc:derby://localhost:1527/sample";
		String dbuser = "travel";
		String dbpassword = "travel";
		
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			con = DriverManager.getConnection(url,dbuser,dbpassword);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
			e.printStackTrace();
		}
		return con;
	} 
}



