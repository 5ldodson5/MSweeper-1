package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

				String result = null;
			
			try {
				String username = getStringFromParameter(req.getParameter("Username"));
				String password = getStringFromParameter(req.getParameter("Password"));
				

				// check for errors in the form data 
				if (username == null || password == null) {
					errorMessage = "Invalid username or password";
				}
				/*else {
					NumbersController controller = new NumbersController();
					result = controller.add(first, second, third);
				}*/
				
			} catch (NumberFormatException e) {
				errorMessage = "Invalid string";
			}
			
			req.setAttribute("Username", req.getParameter("Username"));
			req.setAttribute("Password", req.getParameter("Password"));
			

			req.setAttribute("errorMessage", errorMessage);
			// req.setAttribute("Name of Guest", guestName); 
			
			req.getRequestDispatcher("/_view/signIn.jsp").forward(req, resp);
		}

		private String getStringFromParameter(String s) {
			if (s == null || s.equals("")) {
				return null;
			} else {
				return s;
			}
		}
	}