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
import model.CancelOrderDAO;
import model.SupplyModel;
import model.UserModel;

public class CancelOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//constructor
	public CancelOrderController(){
		super();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//debbug info
		System.out.println(getServletName());
		System.out.println("doPost method is called");

		//get data from JSP
		HttpSession session = req.getSession();
		String orderid = req.getParameter("orderid");

		//DAO
		try {
			boolean result = false;
			result = new CancelOrderDAO().doCancel(orderid);			

			if (result == true) {
			//dispatch
			RequestDispatcher rd_true = req.getRequestDispatcher("cancelOrderResultView.jsp");
			rd_true.forward(req, res);					
			} else {
			RequestDispatcher rd_false = req.getRequestDispatcher("falseCancelOrderResultView.jsp");
			rd_false.forward(req, res);				
			}
		} catch (Exception e) {
			RequestDispatcher rd_false = req.getRequestDispatcher("falseCancelOrderResultView.jsp");
			rd_false.forward(req, res);
			e.printStackTrace();
			} finally {
			
		}
	}
}

