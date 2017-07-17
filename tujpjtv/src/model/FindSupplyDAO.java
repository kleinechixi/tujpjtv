package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FindSupplyDAO {

	public static ArrayList<SupplyModel> doFind(SupplyModel ferryinfomodel) throws SQLException, ClassNotFoundException {

		//get db connection first
		DBConnectionManager connectionManager = new DBConnectionManager();
		Connection con = connectionManager.getConnection();

		//get data from database
		try {	
			//sql, select all row of userid specified
			String sql = "select * from supply where origin = ? and destination = ? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ferryinfomodel.getOrigin());
			pstmt.setString(2, ferryinfomodel.getDestination());
			ResultSet rs = pstmt.executeQuery();					

			//get result from db
			ArrayList<SupplyModel> list = new ArrayList<SupplyModel>();
			while(rs.next()){
				SupplyModel ferryinfomodel1 = new SupplyModel();
				ferryinfomodel1.setShipnum(rs.getString("shipnum"));
				ferryinfomodel1.setType(rs.getString("type"));
				ferryinfomodel1.setDate(rs.getString("date"));
				ferryinfomodel1.setOrigin(rs.getString("origin"));
				ferryinfomodel1.setDestination(rs.getString("destination"));
				ferryinfomodel1.setAvailseats(rs.getString("availseats"));
				list.add(ferryinfomodel1);
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