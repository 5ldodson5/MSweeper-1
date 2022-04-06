package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MineSweeper.controller.signInController;
import MineSweeper.controller.highScoreController;


public class GuestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
				
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Index Servlet: doGet");
		
		req.getRequestDispatcher("/_view/guest.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Guest Servlet: doPost");
		


		String errorMessage = null;


		String result = null;
		
		Boolean validName = false;
		

		try {
			String guestName = getStringFromParameter(req.getParameter("guestName"));
			

			// check for errors in the form data 
			if (guestName == null) {
				errorMessage = "Please Input a name";
			}
			else {
				signInController controller = new signInController();
				result = controller.guestName(guestName);
				validName = true;
			}
			
		} catch (NumberFormatException e) {
			errorMessage = "Invalid string";
		}
		
		req.setAttribute("userName", req.getParameter("guestName"));
		

		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("result", result); 
		
		if(validName==true) {
			highScoreController controller = new highScoreController();
			try {
				req=controller.addHighScore(req);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("/_view/guest.jsp").forward(req, resp);
		}
	}

	private String getStringFromParameter(String s) {
		if (s == null || s.equals("")) {
			return null;
		} else {
			return s;
		}
	}
}
