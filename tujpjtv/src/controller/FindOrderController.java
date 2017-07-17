package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FindSupplyDAO;
import model.UserModel;
import model.SharedModel;
import model.FindOrderDAO;

public class FindOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//constructor
	public FindOrderController(){
		super();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//debbug info
		System.out.println(getServletName());
		System.out.println("doPost method is called");
		
		//get useridnum from session
		HttpSession session = req.getSession();
		String useridnum = (String)session.getAttribute("useridnum");
		SharedModel sharedmodel = new SharedModel();
				
		//DAO
		try {
			ArrayList<SharedModel>list = FindOrderDAO.doFind(sharedmodel,useridnum);			
			req.setAttribute("list", list);
			
			//dispatch
				RequestDispatcher rd_true = req.getRequestDispatcher("findOrderResultView.jsp");
				rd_true.forward(req, res);					
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception:" + e.getMessage());

		}finally {
			
		}
	}
}

