package MineSweeper.db.model;

//Uses code from CS320_LibraryExample_Lab06, edited to fit this project
public class HighScore {
	private int score;
	private String username;
	private String difficulty;
	
	public HighScore() {
		
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	
	public String getDifficulty() {
		return difficulty;
	}
}
