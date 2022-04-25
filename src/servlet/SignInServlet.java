package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MineSweeper.derby.DerbyDatabase;
import MineSweeper.controller.signInController;
import MineSweeper.controller.highScoreController;

public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
			System.out.println("Sign In Servlet: doGet");
			
			req.getRequestDispatcher("/_view/signIn.jsp").forward(req, resp);
		}
		@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
				System.out.println("Sign in Servlet: doPost");
			
				String errorMessage = null;

				boolean result=false;
			
			try {
				String username = getStringFromParameter(req.getParameter("username"));
				String password = getStringFromParameter(req.getParameter("password"));
				
				//System.out.println(username + ", " + password);

				// check for errors in the form data 
				if (username == null || password == null) {
					errorMessage = "Invalid username or password";
				}
				else {
					signInController controller = new signInController();
					result = controller.checkUser(username, password);
					//System.out.println(result);
				}
				
			} catch (NumberFormatException e) {
				errorMessage = "Invalid string";
			}
			
			req.setAttribute("username", req.getParameter("username"));
			req.setAttribute("password", req.getParameter("password"));
			

			req.setAttribute("errorMessage", errorMessage);
			req.setAttribute("whetherGuestExists", result); 
			
			if(result == true) {
				req.setAttribute("userName", req.getParameter("username"));
				highScoreController highScores = new highScoreController();
				try {
					req=highScores.addHighScore(req);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
			}
			else {
				req.getRequestDispatcher("/_view/signIn.jsp").forward(req, resp);
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