package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.MyInfoDAO;
import model.UserModel;


public class MyInfoController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//debug info
		System.out.println("GetMyInfo.java");
		System.out.println("doPost method is called");
		
		//get infomation from DB		
		try {
			HttpSession session = req.getSession();
			String userids = (String) session.getAttribute("userids");
			UserModel myinfo = new UserModel();
			myinfo = new MyInfoDAO().getMyInfo(userids);

			//set sql result to each params
			//session.setAttribute("myinfo",myinfo);
			session.setAttribute("useridnum",myinfo.getUseridnum());
			session.setAttribute("userid",myinfo.getUserid());
			session.setAttribute("password",myinfo.getPassword());
			session.setAttribute("email",myinfo.getEmail());
			session.setAttribute("firstname",myinfo.getFirstname());
			session.setAttribute("lastname",myinfo.getLastname());
			session.setAttribute("sex",myinfo.getSex());
			session.setAttribute("nationality",myinfo.getNationality());
			session.setAttribute("birthday",myinfo.getBirthday());
			session.setAttribute("address",myinfo.getAddress());
			session.setAttribute("phone",myinfo.getPhone());		
			
			//dispatch to jsp
			RequestDispatcher rd_true = req.getRequestDispatcher("myInfoView.jsp");
			rd_true.forward(req, res);
				
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception:" + e.getMessage());
			RequestDispatcher rd_false = req.getRequestDispatcher("falseMyInfoView.jsp");
			rd_false.forward(req, res);	
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception:" + e.getMessage());
		}
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		//debug info
		System.out.println("GetMyInfo.java");
		System.out.println("doGet method is called");		
	
	}
	
}
