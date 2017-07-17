package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import model.UserModel;
import model.LoginDAO;
import model.MyInfoDAO;

public class LogoutController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession(true);
		session.invalidate();
		RequestDispatcher rd_true = req.getRequestDispatcher("loginView.jsp");
		rd_true.forward(req, res);
	}	
}
