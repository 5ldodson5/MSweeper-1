package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
				
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Index Servlet: doGet");

		req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Index Servlet: doPost");
		
		String buttonE = req.getParameter("easy");
		String buttonM = req.getParameter("medium");
		String buttonH = req.getParameter("hard");
		
		
		if(buttonE != null) {
			req.getRequestDispatcher("/_view/easy.jsp").forward(req, resp);
		}
		else if(buttonM != null) {
			req.getRequestDispatcher("/_view/medium.jsp").forward(req, resp);
		}
		else if(buttonH != null){
			req.getRequestDispatcher("/_view/hard.jsp").forward(req, resp);
		}
		else {
			System.out.println("No option was chosen.");
			req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
		}
		
	}
}
