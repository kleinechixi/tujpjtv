package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FindSupplyDAO;
import model.SupplyModel;

public class FindSupplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//constructor
	public FindSupplyController(){
		super();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//debbug info
		System.out.println(getServletName());
		System.out.println("doPost method is called");
		
		//data get data from JSP
		SupplyModel ferryinfomodel = new SupplyModel();
		ferryinfomodel.setOrigin(req.getParameter("origin"));
		ferryinfomodel.setDestination(req.getParameter("destination"));
		
		//DAO
		try {
			ArrayList<SupplyModel>list = FindSupplyDAO.doFind(ferryinfomodel);			
			req.setAttribute("list", list);
			
			//dispatch
				RequestDispatcher rd_true = req.getRequestDispatcher("findSupplyResultView.jsp");
				rd_true.forward(req, res);					
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception:" + e.getMessage());
		}finally {
			
		}
	}
}

