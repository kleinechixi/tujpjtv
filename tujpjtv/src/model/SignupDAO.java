package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignupDAO {
	
	//get db connection first
	DBConnectionManager connectionManager = new DBConnectionManager();
	Connection con = connectionManager.getConnection();

	public boolean doSighup(UserModel signup) throws SQLException, ClassNotFoundException {

		try {			
			//sql, select all row of userid specified
			String sql = "insert into myinfo (useridnum,userid,password,email,firstname,lastname,sex,nationality,birthday,address,phone) values (?,?,?,?,?,?,?,?,?,?,?) ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, signup.getUseridnum());
			pstmt.setString(2, signup.getUserid());
			pstmt.setString(3, signup.getPassword());
			pstmt.setString(4, signup.getEmail());
			pstmt.setString(5, signup.getFirstname());
			pstmt.setString(6, signup.getLastname());
			pstmt.setString(7, signup.getSex());
			pstmt.setString(8, signup.getNationality());
			pstmt.setString(9, signup.getBirthday());
			pstmt.setString(10, signup.getAddress());
			pstmt.setString(11, signup.getPhone());
			int i = pstmt.executeUpdate();
			
			if ( i == 1 ) {
			    //go to the right page
				con.commit();
				return true;
			} else {
		    	//go to the wrong page
				con.rollback();
				return false;
			}     
  		    
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		} finally {
			con.close();
		}
		
	}
}
