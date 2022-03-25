package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 class SignInServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

			System.out.println("SignIn Servlet: doGet");	
			
			req.getRequestDispatcher("/_view/signIn.jsp").forward(req, resp);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			
			System.out.println("SignIn Servlet: doPost");
			
			String errorMessage = null;

			Double result = null;
			
			// decode POSTed form parameters and dispatch to controller
			try {
				String userName = getStringFromParameter(req.getParameter("User Name"));
				String password = getStringFromParameter(req.getParameter("Password"));
				

				// check for errors in the form data before using is in a calculation
				if (userName == null || password == null) {
					errorMessage = "Incorrect Username or Password";
				}
		
				/*else {
					NumbersController controller = new NumbersController();
					result = controller.add(first, second, third);
				}
				*/
			} catch (NumberFormatException e) {
				errorMessage = "Invalid String";
			}

			req.setAttribute("Username", req.getParameter("Username"));
			req.setAttribute("Password", req.getParameter("Password"));
			

			req.setAttribute("errorMessage", errorMessage);
			req.setAttribute("result", result);
			
			// Forward to view to render the result HTML document
			req.getRequestDispatcher("/_view/signIn.jsp").forward(req, resp);
		}

		// gets double from the request with attribute named s
		private String getStringFromParameter(String s) {
			if (s == null || s.equals("")) {
				return null;
			} else {
				return s;
			}
		}
	}


