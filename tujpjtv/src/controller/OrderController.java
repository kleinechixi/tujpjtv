package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FindSupplyDAO;
import model.UserModel;
import model.OrderDAO;
import model.OrderModel;
import model.SupplyModel;

public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//constructor
	public OrderController(){
		super();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//debbug info
		System.out.println(getServletName());
		System.out.println("doPost method is called");

		//useridnum
		HttpSession session = req.getSession();
		String useridnum = (String)session.getAttribute("useridnum");
	
		//orderid generated from timestamp and useridnum
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	    sdf.applyPattern("yyyyMMddhhmmss");
	    String curtime = sdf.format(c.getTime());
		OrderModel ordermodel = new OrderModel();
		ordermodel.setOrderid("o" + curtime + useridnum );
		
		//shipnum
		SupplyModel supplymodel = new SupplyModel();
		supplymodel.setShipnum(req.getParameter("shipnum"));

		//numofseatss
		String numofseats = req.getParameter("numofseats");

		//debug
		System.out.println(useridnum);
		System.out.println(ordermodel.getOrderid());
		System.out.println(supplymodel.getShipnum());
		System.out.println(numofseats);
		
		//DAO
		try {
			boolean result = false;
			result = new OrderDAO().doBook(supplymodel,useridnum,ordermodel,numofseats);			

			if (result == true) {
			//dispatch
			req.setAttribute("orderid", ordermodel.getOrderid());
			RequestDispatcher rd_true = req.getRequestDispatcher("orderResultView.jsp");
			rd_true.forward(req, res);					
			} else {
			RequestDispatcher rd_false = req.getRequestDispatcher("falseOrderResultView.jsp");
			rd_false.forward(req, res);				
			}
		} catch (Exception e) {
			RequestDispatcher rd_false = req.getRequestDispatcher("falseOrderResultView.jsp");
			rd_false.forward(req, res);
			e.printStackTrace();
			} finally {
			
		}
	}
}

