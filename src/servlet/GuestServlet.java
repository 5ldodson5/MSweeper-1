package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



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
		

		try {
			String guestName = getStringFromParameter(req.getParameter("Guest Name"));
			

			// check for errors in the form data 
			if (guestName == null) {
				errorMessage = "Please Input a name";
			}
			/*else {
				NumbersController controller = new NumbersController();
				result = controller.add(first, second, third);
			}*/
			
		} catch (NumberFormatException e) {
			errorMessage = "Invalid string";
		}
		
		req.setAttribute("Guest Name", req.getParameter("Guest Name"));
		

		req.setAttribute("errorMessage", errorMessage);
		// req.setAttribute("Name of Guest", guestName); 
		
		req.getRequestDispatcher("/_view/guest.jsp").forward(req, resp);
	}

	private String getStringFromParameter(String s) {
		if (s == null || s.equals("")) {
			return null;
		} else {
			return s;
		}
	}
}


