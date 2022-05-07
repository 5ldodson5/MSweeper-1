package MineSweeper.derby;

import java.util.List;

import MineSweeper.db.model.HighScore;
import MineSweeper.db.model.User;


//Uses code from CS320_LibraryExample_Lab06, methods have been edited to fit this project
public interface IDatabase {
	public Integer insertUserIntoUsersTable(String username, String password);
	public List<User> findAllUsers();
	public List<HighScore> findAllHighScoresByDifficulty(String difficulty);
	public Boolean checkUsernameExists(String username);
	
	//public List<HighScore> findTopTenHighScoresByDifficulty(String difficulty);
	//public Integer insertNewUser(String username, String password);
}
