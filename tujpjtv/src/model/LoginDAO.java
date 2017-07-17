package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	//get db connection first
	DBConnectionManager connectionManager = new DBConnectionManager();
	Connection con = connectionManager.getConnection();

	public boolean doAuthentication(UserModel login) throws SQLException, ClassNotFoundException {
		
		try {
			//sql, select all row of userid specified
			String sql = "select * from myinfo where userid = ? and password = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, login.getUserid());
			pstmt.setString(2, login.getPassword());
			ResultSet rs = pstmt.executeQuery();					
			
			//get result from db and set them to in local string to check.
			int rowcount = 0;
			while(rs.next()){
		          rowcount++;		          		    
			}
			
			//if returned record is 1, allow login.
		    if (rowcount == 1) {
		    	//go to the right page
		    	return true;
		    } else {
		    	//otherwise, go to the wrong page
		    	return false;
			}    
						
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
			e.printStackTrace();
		} finally {
			con.close();
		}
		return false; 
	}
}
