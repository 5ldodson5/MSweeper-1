package MineSweeper.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import MineSweeper.db.model.HighScore;
import MineSweeper.db.model.User;
import javax.servlet.http.HttpServletRequest;
import MineSweeper.derby.DerbyDatabase;


/*
 * highScoreController contains methods that fill the high score lists on the webpage.
 * 
 */
public class highScoreController {
	
	//Used to populate the index
	public HttpServletRequest addHighScore(HttpServletRequest req) throws ClassNotFoundException {
		
		DerbyDatabase derbyDB = new DerbyDatabase();
		List<HighScore> highScores;
		highScores = derbyDB.findAllHighScoresByDifficulty("Easy");
		
		req.setAttribute("userOneEasy", highScores.get(0).getUsername());
		req.setAttribute("userTwoEasy", highScores.get(1).getUsername());
		req.setAttribute("userThreeEasy", highScores.get(2).getUsername());
		req.setAttribute("userFourEasy", highScores.get(3).getUsername());
		req.setAttribute("userFiveEasy", highScores.get(4).getUsername());
		
		req.setAttribute("timeOneEasy", highScores.get(0).getScore());
		req.setAttribute("timeTwoEasy", highScores.get(1).getScore());
		req.setAttribute("timeThreeEasy", highScores.get(2).getScore());
		req.setAttribute("timeFourEasy", highScores.get(3).getScore());
		req.setAttribute("timeFiveEasy", highScores.get(4).getScore());
		
		
		highScores = derbyDB.findAllHighScoresByDifficulty("Medium");
		
		req.setAttribute("userOneMedium", highScores.get(0).getUsername());
		req.setAttribute("userTwoMedium", highScores.get(1).getUsername());
		req.setAttribute("userThreeMedium", highScores.get(2).getUsername());
		req.setAttribute("userFourMedium", highScores.get(3).getUsername());
		req.setAttribute("userFiveMedium", highScores.get(4).getUsername());
		
		req.setAttribute("timeOneMedium", highScores.get(0).getScore());
		req.setAttribute("timeTwoMedium", highScores.get(1).getScore());
		req.setAttribute("timeThreeMedium", highScores.get(2).getScore());
		req.setAttribute("timeFourMedium", highScores.get(3).getScore());
		req.setAttribute("timeFiveMedium", highScores.get(4).getScore());
		
		
		highScores = derbyDB.findAllHighScoresByDifficulty("Hard");
		
		req.setAttribute("userOneHard", highScores.get(0).getUsername());
		req.setAttribute("userTwoHard", highScores.get(1).getUsername());
		req.setAttribute("userThreeHard", highScores.get(2).getUsername());
		req.setAttribute("userFourHard", highScores.get(3).getUsername());
		req.setAttribute("userFiveHard", highScores.get(4).getUsername());
		
		req.setAttribute("timeOneHard", highScores.get(0).getScore());
		req.setAttribute("timeTwoHard", highScores.get(1).getScore());
		req.setAttribute("timeThreeHard", highScores.get(2).getScore());
		req.setAttribute("timeFourHard", highScores.get(3).getScore());
		req.setAttribute("timeFiveHard", highScores.get(4).getScore());
		
		
		
		//Code for MS2 Fake Database, should probably delete for final project.
		
		/*
		Connection conn = null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			//conn = DriverManager.getConnection("jdbc:derby:test.db;create=true");
			conn = DriverManager.getConnection("jdbc:derby:C:/Users/matth/Documents/Code/library.db;create=true");
			//IMPORTANT: Change the folder name before running the code. I cannot put the database in the project folder as git doesn't like to do anything convenient.
			//DO NOT put the database in the folder
			
			//If the database needs to be cleared.
			//String delsql = "DROP TABLE highscores";
			Statement stmt = conn.createStatement();
			//stmt.execute(delsql);
			String sql = null;
			
			sql = "SELECT * FROM highScores ";
			
			//Creates fake database.
			//String sql = "CREATE TABLE highscores (id int, username varchar(30), score int, PRIMARY KEY(id))";
			
			//stmt.execute(sql);
			
			//Once created, these lines aren't neccessary.
			//sql = "INSERT INTO highscores VALUES (1, 'Jim Bob', 50)";
			//stmt.execute(sql);
			//sql = "INSERT INTO highscores VALUES (2, 'Cereal Bowl', 60)";
			//stmt.execute(sql);
			//sql = "INSERT INTO highscores VALUES (3, 'Pizza Box', 70)";
			//stmt.execute(sql);
			//sql = "INSERT INTO highscores VALUES (4, 'Desk Lamp', 80)";
			//stmt.execute(sql);
			//sql = "INSERT INTO highscores VALUES (5, 'RGB Keyboard', 90)";
			//stmt.execute(sql);
			
			sql = "SELECT * FROM highscores";
			ResultSet rs = stmt.executeQuery(sql);
			
			String[] usernames = new String[5];
			int[] scores = new int[5];
			int counter = 0;
			while(rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				int score = rs.getInt("score");
				System.out.println(id + ": " + username + " - " + score);
				
				usernames[counter] = username;
				scores[counter] = score;
				counter++;
			}
			//for (int i=0;i<5;i++) {
			//	System.out.println(usernames[i] + " " + scores[i]);
			//}
			req.setAttribute("userOne", usernames[0]);
			req.setAttribute("userTwo", usernames[1]);
			req.setAttribute("userThree", usernames[2]);
			req.setAttribute("userFour", usernames[3]);
			req.setAttribute("userFive", usernames[4]);
			
			req.setAttribute("timeOne", scores[0]);
			req.setAttribute("timeTwo", scores[1]);
			req.setAttribute("timeThree", scores[2]);
			req.setAttribute("timeFour", scores[3]);
			req.setAttribute("timeFive", scores[4]);
			
			
			
			rs.close();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// ignore
			}
		}
		*/
		return req;
	}
	
	
	//used to populate the high score lists within the game pages
	public HttpServletRequest populateHighScoresByDifficulty(HttpServletRequest req, String difficulty) throws ClassNotFoundException {
		DerbyDatabase derbyDB = new DerbyDatabase();
		List<HighScore> highScores;
		highScores = derbyDB.findAllHighScoresByDifficulty(difficulty);
		
		req.setAttribute("userOne" + difficulty, highScores.get(0).getUsername());
		req.setAttribute("userTwo" + difficulty, highScores.get(1).getUsername());
		req.setAttribute("userThree" + difficulty, highScores.get(2).getUsername());
		req.setAttribute("userFour" + difficulty, highScores.get(3).getUsername());
		req.setAttribute("userFive" + difficulty, highScores.get(4).getUsername());
		
		req.setAttribute("timeOne" + difficulty, highScores.get(0).getScore());
		req.setAttribute("timeTwo" + difficulty, highScores.get(1).getScore());
		req.setAttribute("timeThree" + difficulty, highScores.get(2).getScore());
		req.setAttribute("timeFour" + difficulty, highScores.get(3).getScore());
		req.setAttribute("timeFive" + difficulty, highScores.get(4).getScore());
		
		return req;
	}
}
