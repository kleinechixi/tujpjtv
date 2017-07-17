package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FindOrderDAO {

	public static ArrayList<SharedModel> doFind(SharedModel sharedmodel, String useridnum) throws SQLException, ClassNotFoundException {

		//get db connection first
		DBConnectionManager connectionManager = new DBConnectionManager();
		Connection con = connectionManager.getConnection();

		//get data from database
		try {	
			//sql, select all row of userid specified
			String sql = "select * from supply,demand where SUPPLY.SHIPNUM = DEMAND.SHIPNUM and DEMAND.USERIDNUM = ? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, useridnum);
			ResultSet rs = pstmt.executeQuery();					

			//get result from db
			ArrayList<SharedModel> list = new ArrayList<SharedModel>();
			while(rs.next()){
				SharedModel sharedmodel1 = new SharedModel();
				sharedmodel1.setOrderid(rs.getString("orderid"));
				sharedmodel1.setShipnum(rs.getString("shipnum"));
				sharedmodel1.setType(rs.getString("type"));
				sharedmodel1.setDate(rs.getString("date"));
				sharedmodel1.setOrigin(rs.getString("origin"));
				sharedmodel1.setDestination(rs.getString("destination"));
				sharedmodel1.setNumofseats(rs.getString("numofseats"));
				list.add(sharedmodel1);
			}
			rs.close();			
			return list;		
		    
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
			e.printStackTrace();
		} finally {
			con.close();
		}
		return null;

	}


	

}