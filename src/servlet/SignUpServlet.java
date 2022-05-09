package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MineSweeper.derby.DerbyDatabase;

import MineSweeper.controller.signInController;
import MineSweeper.controller.signUpController;
import MineSweeper.controller.highScoreController;

public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
			System.out.println("Sign Up Servlet: doGet");
			
			req.getRequestDispatcher("/_view/signUp.jsp").forward(req, resp);
		}
		@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
				System.out.println("Sign Up Servlet: doPost");
			
				String errorMessage = null;

				boolean result=false;
				String username = getStringFromParameter(req.getParameter("username"));
				
			try {
				String password = getStringFromParameter(req.getParameter("password"));
				String passwordCheck = getStringFromParameter(req.getParameter("passwordCheck"));
				

				if (username == null || password == null) {
					errorMessage = "Invalid username or password!";
				}
				else if(password.equals(passwordCheck)) {
					signUpController controller = new signUpController();
					result = controller.checkSignUp(username, password, passwordCheck);
					//System.out.println(result);
					if(result==false) {
						errorMessage = "Username already exists!";
					}
				}
				else {
					errorMessage = "Passwords don't match!";
				}
				
			} catch (NumberFormatException e) {
				errorMessage = "Invalid string";
			}
			
			req.setAttribute("username", req.getParameter("username"));
			req.setAttribute("password", req.getParameter("password"));
			req.setAttribute("passwordCheck", req.getParameter("passwordCheck"));
			

			req.setAttribute("errorMessage", errorMessage);
			req.setAttribute("whetherGuestExists", result); 
			
			if(result == true) {
				req.getSession().setAttribute("userName", username);
				//req.setAttribute("userName", req.getParameter("username"));
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
				req.getRequestDispatcher("/_view/signUp.jsp").forward(req, resp);
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