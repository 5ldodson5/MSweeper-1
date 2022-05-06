package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MineSweeper.controller.highScoreController;
import MineSweeper.derby.DerbyDatabase;

public class MediumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
				
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Medium Servlet: doGet");
		
		req.getRequestDispatcher("/_view/medium.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Medium Servlet: doPost");
		
		String endMess = getStringFromParameter(req.getParameter("endMessSend"));
		//System.out.println("endMess = " + endMess);
		
		if(endMess == null) {
			System.out.println("No end message, the game was ended early.");
		}
		else if(endMess.equals("YOU WIN!")){
			int finalScore = Integer.valueOf(req.getParameter("finalScoreSend"));
			String username = getStringFromParameter(req.getParameter("userName"));
			
			/*
			System.out.println("endMess = " + endMess);
			System.out.println("finalScore = " + finalScore);
			System.out.println("username = " + username);
			*/
			
			DerbyDatabase derbyDB = new DerbyDatabase();
			derbyDB.insertHighScoreIntoHighScoresTable("Medium", username, finalScore);
			
		}
		else {
			System.out.println("Game resulted in a game over.");
		}
		
		String buttonBack = req.getParameter("return");
		String buttonRestart = req.getParameter("restart");
		
		
		if(buttonBack != null) {
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
			req.getRequestDispatcher("/_view/medium.jsp").forward(req, resp);
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
