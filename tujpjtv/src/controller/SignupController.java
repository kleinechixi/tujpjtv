package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SignupDAO;
import model.UserModel;

public class SignupController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// timestamp to generate userid 
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	    sdf.applyPattern("yyyyMMddhhmmss");
	    String curtime = sdf.format(c.getTime());
	    
		//get params
		UserModel signup = new UserModel();
		signup.setUseridnum("u" + curtime);
		signup.setUserid(req.getParameter("userid"));
		signup.setPassword(req.getParameter("password"));	
		signup.setEmail(req.getParameter("email"));
		signup.setFirstname(req.getParameter("firstname"));
		signup.setLastname(req.getParameter("lastname"));
		signup.setSex(req.getParameter("sex"));
		signup.setNationality(req.getParameter("nationality"));
		signup.setBirthday(req.getParameter("birthday"));
		signup.setAddress(req.getParameter("address"));
		signup.setPhone(req.getParameter("phone"));
		
		try {
			//for debug, force true
			boolean result = false;
			result = new SignupDAO().doSighup(signup);
			
			if (result == true) {
				String email = (String) signup.getEmail();
				MailController mailctrler = new MailController().doSend(email);
				RequestDispatcher rd_true = req.getRequestDispatcher("succSignupView.jsp");
				rd_true.forward(req, res);
			} else {
				RequestDispatcher rd_false = req.getRequestDispatcher("falseSignupView.jsp");
				rd_false.forward(req, res);					
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			RequestDispatcher rd_false = req.getRequestDispatcher("falseSignupView.jsp");
			rd_false.forward(req, res);	
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequestDispatcher rd_false = req.getRequestDispatcher("falseSignupView.jsp");
			rd_false.forward(req, res);	

		}
		
	}

}

