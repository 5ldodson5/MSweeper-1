package MineSweeper.derby;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import MineSweeper.db.model.HighScore;
import MineSweeper.db.model.User;


//Uses code from CS320_LibraryExample_Lab06, methods have been edited to fit this project
public class InitialData {

	// reads initial HighScore data from CSV file and returns a List of HighScores
	public static List<HighScore> getHighScores() throws IOException {
		List<HighScore> highScoreList = new ArrayList<HighScore>();
		ReadCSV readHighScores = new ReadCSV("highScores.csv");
		try {
			while (true) {
				List<String> tuple = readHighScores.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				HighScore highScore = new HighScore();

				highScore.setDifficulty(i.next());
				highScore.setUsername(i.next());
				highScore.setScore(Integer.parseInt(i.next()));

				highScoreList.add(highScore);
			}
			System.out.println("highScoreList loaded from CSV file");
			return highScoreList;
		} finally {
			readHighScores.close();
		}
	}
	
	// reads initial User data from CSV file and returns a List of Users
	public static List<User> getUsers() throws IOException {
		List<User> userList = new ArrayList<User>();
		ReadCSV readUsers = new ReadCSV("users.csv");
		try {
			// auto-generated primary key for table users
			Integer userId = 1;
			while (true) {
				List<String> tuple = readUsers.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				User user = new User();
				
				// auto-generate user ID
				user.setUserId(userId++);
				user.setUsername(i.next());
				user.setPassword(i.next());
				
				userList.add(user);
			}
			System.out.println("userList loaded from CSV file");			
			return userList;
		} finally {
			readUsers.close();
		}
	}
	
}