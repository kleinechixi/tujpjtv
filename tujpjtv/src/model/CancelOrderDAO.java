package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;

public class CancelOrderDAO {

	//get db connection first
	DBConnectionManager connectionManager = new DBConnectionManager();
	Connection con = connectionManager.getConnection();

	public boolean doCancel(String orderid) throws SQLException, ClassNotFoundException {

		try {
			//sql, select all row of userid specified
			String sql = "delete from demand where orderid = ? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, orderid);
			int rs = pstmt.executeUpdate();					
						
			//if returned record is 1, ok.
		    if (rs == 1) {
		    	//go to the right page
		    	return true;
		    } else {
		    	//otherwise, go to the wrong page
		    	return false;
			}    
						
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
			e.printStackTrace();
	    	return false;
		} finally {
			con.close();
		}
		
	}
}
