package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyInfoDAO {

	//get db connection first
	DBConnectionManager connectionManager = new DBConnectionManager();
	Connection con = connectionManager.getConnection();
	
	//public static boolean doAuthentication(LoginModel login) throws SQLException {
	public UserModel getMyInfo(String userids) throws SQLException, ClassNotFoundException {
			
		//get userid and password from database
			
			try {
				//sql, select all row of userid specified
				String sql = "select * from myinfo where userid = ? ";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, userids);
				ResultSet rs = pstmt.executeQuery();

				//get result from db
				UserModel myinfo = new UserModel();

				while(rs.next()){
			 	//columu:useridnum,userid,password,email,firstname,lastname,sex,nationality,birthday,address,phone
			 	myinfo.setUseridnum(rs.getString("useridnum"));
			 	myinfo.setUserid(rs.getString("userid"));
			 	myinfo.setPassword(rs.getString("password"));
			 	myinfo.setEmail(rs.getString("email"));
			 	myinfo.setFirstname(rs.getString("firstname"));
			 	myinfo.setLastname(rs.getString("lastname"));
			 	myinfo.setSex(rs.getString("sex"));
			 	myinfo.setNationality(rs.getString("nationality"));
			 	myinfo.setBirthday(rs.getString("birthday"));
			 	myinfo.setAddress(rs.getString("address"));
			 	myinfo.setPhone(rs.getString("phone"));
			 	}
		        return myinfo;	
		        
			} catch (Exception e) {
				System.out.println("Exception:" + e.getMessage());
				e.printStackTrace();			
			} finally {
				con.close();				
			}
			return null;				
	}
}
