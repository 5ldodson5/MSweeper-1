package MineSweeper.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;


//Once the Derby project has been added, this should work. For now, this works through a reference to my local files.
//-Matt
public class highScoreController {
	public HttpServletRequest addHighScore(HttpServletRequest req) throws ClassNotFoundException {
		Connection conn = null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			conn = DriverManager.getConnection("jdbc:derby:test.db;create=true");
			
			//If the database needs to be cleared.
			//String delsql = "DROP TABLE highscores";
			Statement stmt = conn.createStatement();
			//stmt.execute(delsql);
			
			//Creates fake database.
			String sql = "CREATE TABLE highscores (id int, username varchar(30), score int, PRIMARY KEY(id))";
			
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
		return req;
	}
}
