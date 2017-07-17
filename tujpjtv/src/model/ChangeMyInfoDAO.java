package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangeMyInfoDAO {
	
	//get db connection first
	DBConnectionManager connectionManager = new DBConnectionManager();
	Connection con = connectionManager.getConnection();

	public boolean doChange(UserModel login) throws SQLException, ClassNotFoundException {

		try {			
			//sql, select all row of userid specified
			String sql = "update myinfo set userid = ? , password = ? , email = ? ,firstname = ?,lastname = ?,sex = ?,nationality = ?,birthday = ?,address = ?,phone = ? where useridnum = ? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, login.getUserid());
			pstmt.setString(2, login.getPassword());
			pstmt.setString(3, login.getEmail());
			pstmt.setString(4, login.getFirstname());
			pstmt.setString(5, login.getLastname());
			pstmt.setString(6, login.getSex());
			pstmt.setString(7, login.getNationality());
			pstmt.setString(8, login.getBirthday());
			pstmt.setString(9, login.getAddress());
			pstmt.setString(10, login.getPhone());
			pstmt.setString(11, login.getUseridnum());
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
