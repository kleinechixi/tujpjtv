package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import model.UserModel;
import model.LoginDAO;
import model.MyInfoDAO;

public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//get parameter from JSP as an bean?
		UserModel login = new UserModel();
		login.setUserid(req.getParameter("userid"));
		login.setPassword(req.getParameter("password"));
				
		try {
			boolean result = false;
			result = new LoginDAO().doAuthentication(login);
			
			if (result == true) {
				//session info to save login info
				HttpSession session = req.getSession(true);
				session.setAttribute("isLogin", true);
				session.setAttribute("userids", login.getUserid());
				
				//to get useridnum for further use
				String userids = (String) session.getAttribute("userids");
				UserModel myinfo = new UserModel();
				myinfo = new MyInfoDAO().getMyInfo(userids);
				session.setAttribute("useridnum",myinfo.getUseridnum());
				
				//dispatch
				RequestDispatcher rd_true = req.getRequestDispatcher("myPageView.jsp");
				rd_true.forward(req, res);
				
			} else {
				//if false, login ng
				RequestDispatcher rd_false = req.getRequestDispatcher("falseLoginView.jsp");
				rd_false.forward(req, res);	
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Exception:" + e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Exception:" + e.getMessage());
		}
	}	
}
