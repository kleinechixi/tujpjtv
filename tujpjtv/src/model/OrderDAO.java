package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;

public class OrderDAO {

	//get db connection first
	DBConnectionManager connectionManager = new DBConnectionManager();
	Connection con = connectionManager.getConnection();

	public boolean doBook(SupplyModel supplymodel,String useridnum,OrderModel ordermodel,String numofseats) throws SQLException, ClassNotFoundException {
		
		try {
			//sql, select all row of userid specified
			String sql = "insert into demand (orderid,shipnum,useridnum,numofseats) values (?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ordermodel.getOrderid());
			pstmt.setString(2, supplymodel.getShipnum());
			pstmt.setString(3, useridnum);
			pstmt.setString(4, numofseats);
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
