package MineSweeper.derby;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import MineSweeper.db.model.HighScore;
import MineSweeper.db.model.User;


//Uses code from CS320_LibraryExample_Lab06, methods have been edited to fit this project
public class DerbyDatabase implements IDatabase {
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby driver");
		}
	}
	
	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}

	private static final int MAX_ATTEMPTS = 10;
	
	
	//Returns a list containing all users in the Users database table.
	public List<User> findAllUsers(){
		return executeTransaction(new Transaction<List<User>>() {
			public List<User> execute(Connection conn) throws SQLException{
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select * from users " +
							" order by username asc"
					);
					
					List<User> result = new ArrayList<User>();
					
					resultSet = stmt.executeQuery();
					
					Boolean found = false;
					while (resultSet.next()) {
						found = true;
						
						User user = new User();
						loadUser(user, resultSet, 1);
						
						result.add(user);
					}
					
					if(!found) {
						System.out.println("No users were found in the database");
					}
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	
	//Returns a list containing all High Scores in the HighScores database table.
	//List is in order by lowest score (time) to highest. (Score is the time taken to complete the game.)
	//Only returns the High Scores with the specified difficulty.
	@Override
	public List<HighScore> findAllHighScoresByDifficulty(final String difficulty) {
		return executeTransaction(new Transaction<List<HighScore>>() {
			@Override
			public List<HighScore> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select * from highScores " +
							" where difficulty = ? " +
							" order by score asc"
					);
					
					stmt.setString(1, difficulty);
					
					List<HighScore> result = new ArrayList<HighScore>();
					
					resultSet = stmt.executeQuery();

					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						
						HighScore highScore = new HighScore();
						loadHighScore(highScore, resultSet, 1);
						
						result.add(highScore);
					}

					if (!found) {
						System.out.println("No high scores were found in the database");
					}
					
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	
	//Inserts a new user into the Users database table.
	public Integer insertUserIntoUsersTable(final String username, final String password) {
		return executeTransaction(new Transaction<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;			
				
				ResultSet resultSet2 = null;				
				
				Integer user_id   = -1;

				try {
					
					stmt1 = conn.prepareStatement(
							"insert into users (username, password) " +
							"  values(?, ?) "
					);
					stmt1.setString(1, username);
					stmt1.setString(2, password);
	
					stmt1.executeUpdate();
					
					System.out.println("New user <" + username + "> inserted into Users table");					

					stmt2 = conn.prepareStatement(
							"select user_id from users " +
							"  where username = ? and password = ? "
									
					);
					stmt2.setString(1, username);
					stmt2.setString(2, password);

					resultSet2 = stmt2.executeQuery();
					
					if (resultSet2.next())
					{
						user_id = resultSet2.getInt(1);
						System.out.println("New user <" + username + "> ID: " + user_id);						
					}
					else	
					{
						System.out.println("New user <" + username + "> not found in Users table (ID: " + user_id);
					}				
					
					return user_id;
				} finally {
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);					
					DBUtil.closeQuietly(resultSet2);
				}
			}
		});
	}

	//Checks to see if a username with the specified password exist in the Users database table.
	public Boolean checkUsernamePassword(final String username, final String password) {
		return executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select * from users " +
							" where username = ? and " +
							" password = ?"
					);
					
					stmt.setString(1, username);
					stmt.setString(2, password);
					
					List<User> result = new ArrayList<User>();
					
					resultSet = stmt.executeQuery();
					
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
					}
					
					if (!found) {
						System.out.println("Username and password do not exist in the database");
					}
					
					return found;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}

		});
	}
	
	//Checks the Users database table to see if a specified username exists.
	public Boolean checkUsernameExists(final String username) {
		return executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select * from users " +
							" where username = ? "
					);
					
					stmt.setString(1, username);
					
					List<User> result = new ArrayList<User>();
					
					resultSet = stmt.executeQuery();
					
					
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
					}
					
					
					if (!found) {
						System.out.println("Username does not exist in the database");
					}
					
					return found;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}

		});
	}
	
	//Inserts a new High Score into the HighScores database table.
	public Integer insertHighScoreIntoHighScoresTable(final String difficulty, final String username, final int score) {
		return executeTransaction(new Transaction<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;			
				ResultSet resultSet2 = null;				
				
				Integer user_id   = -1;

				try {			
					stmt1 = conn.prepareStatement(
							"insert into users (difficulty, username, score) " +
							"  values(?, ?, ?) "
					);
					stmt1.setString(1, difficulty);
					stmt1.setString(2, username);
					stmt1.setInt(3, score);

					stmt1.executeUpdate();
					
					System.out.println("New HighScore <" + username + "> inserted into HighScores table");					
					
					return user_id;
				} finally {
					DBUtil.closeQuietly(stmt1);				
				}
			}
		});
	}
	
	//Removes a user from the Users database table.
	public List<User> removeUserByUsername(final String username) {
		return executeTransaction(new Transaction<List<User>>() {
			@Override
			public List<User> execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				ResultSet resultSet1    = null;			

				try {
					stmt1 = conn.prepareStatement(
							"select users.* " +
							"  from  users " +
							"  where users.username = ? "
					);
					
					stmt1.setString(1, username);
					resultSet1 = stmt1.executeQuery();
					
					List<User> users = new ArrayList<User>();					
				
					while (resultSet1.next()) {
						User user = new User();
						loadUser(user, resultSet1, 1);
						users.add(user);
					}
				
					stmt2 = conn.prepareStatement(
							"delete from users " +
							"  where userId = ? "
					);
					
					stmt2.setInt(1, users.get(0).getUserId());
					stmt2.executeUpdate();
					
					System.out.println("Deleted user <" + username + "> from DB");									
					
					return users;
				} finally {
					DBUtil.closeQuietly(resultSet1);
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);			
				}
			}
		});
	}
	
	
	// wrapper SQL transaction function that calls actual transaction function (which has retries)
	public<ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}
	
	// SQL transaction function which retries the transaction MAX_ATTEMPTS times before failing
	public<ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
		Connection conn = connect();
		
		try {
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;
			
			while (!success && numAttempts < MAX_ATTEMPTS) {
				try {
					result = txn.execute(conn);
					conn.commit();
					success = true;
				} catch (SQLException e) {
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
						// Deadlock: retry (unless max retry count has been reached)
						numAttempts++;
					} else {
						// Some other kind of SQLException
						throw e;
					}
				}
			}
			
			if (!success) {
				throw new SQLException("Transaction failed (too many retries)");
			}
			
			// Success!
			return result;
		} finally {
			DBUtil.closeQuietly(conn);
		}
	}

	// TODO: Here is where you name and specify the location of your Derby SQL database
	// TODO: Change it here and in SQLDemo.java
	// TODO: DO NOT PUT THE DB IN THE SAME FOLDER AS YOUR PROJECT - that will cause conflicts later w/Git
	private Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:C:/Users/matth/Documents/Code/library.db;create=true");
		//CHANGE CONNECTION HERE
		
		
		
		// Set autocommit() to false to allow the execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);
		
		return conn;
	}
	
	// retrieves HighScore information from query result set
	private void loadHighScore(HighScore highScore, ResultSet resultSet, int index) throws SQLException {
		highScore.setDifficulty(resultSet.getString(index++));
		highScore.setUsername(resultSet.getString(index++));
		highScore.setScore(resultSet.getInt(index++));
	}
	
	// retrieves User information from query result set
	private void loadUser(User user, ResultSet resultSet, int index) throws SQLException {
		user.setUserId(resultSet.getInt(index++));
		user.setUsername(resultSet.getString(index++));
		user.setPassword(resultSet.getString(index++));
	}
	
	//  creates the HighScores and Users tables
	public void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;				
			
				try {
					stmt1 = conn.prepareStatement(
						"create table highScores (" +									
						"	difficulty varchar(40)," +
						"	username varchar(40)," +
						"   score integer" +
						")"
					);	
					stmt1.executeUpdate();
					
					System.out.println("HighScores table created");
					
					stmt2 = conn.prepareStatement(
							"create table users (" +
							"	user_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
							"	username varchar(40)," +
							"	password varchar(40)" +
							")"
					);
					stmt2.executeUpdate();
					
					System.out.println("Users table created");					
										
					return true;
				} finally {
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
				}
			}
		});
	}
	
	// loads data retrieved from CSV files into DB tables in batch mode
	public void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				List<HighScore> highScoreList;
				List<User> userList;
				
				try {
					highScoreList  = InitialData.getHighScores();
					userList       = InitialData.getUsers();		
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}

				PreparedStatement insertHighScore     = null;
				PreparedStatement insertUser	      = null;

				try {
					//populate HighScores table
					insertHighScore = conn.prepareStatement("insert into highScores (difficulty, username, score) values (?, ?, ?)");
					for (HighScore highScore : highScoreList) {
						insertHighScore.setString(1, highScore.getDifficulty());
						insertHighScore.setString(2, highScore.getUsername());
						insertHighScore.setInt(3, highScore.getScore());
						
						insertHighScore.addBatch();
					}
					insertHighScore.executeBatch();
					
					System.out.println("HighScores table populated");
					
					//populate Users table
					insertUser = conn.prepareStatement("insert into users (username, password) values (?, ?)");
					for (User user : userList) {
						insertUser.setString(1, user.getUsername());
						insertUser.setString(2, user.getPassword());
						
						insertUser.addBatch();
					}
					insertUser.executeBatch();
					
					System.out.println("Users table populated");									
					
					return true;
				} finally {
					DBUtil.closeQuietly(insertHighScore);
					DBUtil.closeQuietly(insertUser);					
				}
			}
		});
	}
	
	// The main method creates the database tables and loads the initial data.
	public static void main(String[] args) throws IOException {
		System.out.println("Creating tables...");
		DerbyDatabase db = new DerbyDatabase();
		db.createTables();
		
		System.out.println("Loading initial data...");
		db.loadInitialData();
		
		System.out.println("Library DB successfully initialized!");
	}
}
