package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ChangeMyInfoDAO;
import model.ChangeMyInfoDAO;
import model.UserModel;

public class ChangeMyInfoController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//get params
		HttpSession session = req.getSession();
		UserModel login = new UserModel();
		//not for change from session
		login.setUseridnum((String)session.getAttribute("useridnum"));
		login.setUserid((String)session.getAttribute("userid"));
		//for change from jsp
		login.setPassword(req.getParameter("password"));
		login.setPasswordve(req.getParameter("passwordve"));
		login.setEmail(req.getParameter("email"));
		login.setFirstname(req.getParameter("firstname"));
		login.setLastname(req.getParameter("lastname"));
		login.setSex(req.getParameter("sex"));
		login.setNationality(req.getParameter("nationality"));
		login.setBirthday(req.getParameter("birthday"));
		login.setAddress(req.getParameter("address"));
		login.setPhone(req.getParameter("phone"));


					 		
		try {
			//for debug, force true
			boolean result = false;
			result = new ChangeMyInfoDAO().doChange(login);
			
			if (result == true) {
				RequestDispatcher rd_true = req.getRequestDispatcher("changeMyInfoResultView.jsp");
				rd_true.forward(req, res);
			} else {
				RequestDispatcher rd_false = req.getRequestDispatcher("falseChangeMyInfoView.jsp");
				rd_false.forward(req, res);					
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			RequestDispatcher rd_false = req.getRequestDispatcher("falseChangeMyInfoView.jsp");
			rd_false.forward(req, res);	
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequestDispatcher rd_false = req.getRequestDispatcher("falseChangeMyInfoView.jsp");
			rd_false.forward(req, res);	

		}
		
	}

}

