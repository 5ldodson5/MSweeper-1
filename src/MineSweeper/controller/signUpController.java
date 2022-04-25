package MineSweeper.controller;

import MineSweeper.derby.DerbyDatabase;

public class signUpController {
	private String username, password, passwordCheck ;
	
	public boolean checkSignUp(String username, String password, String passwordCheck ) {
		boolean goodSignUp = false;
		//System.out.println(username + ", " + password);
		if(password.equals(passwordCheck)) {
			this.username = username;
			this.password = password;
			DerbyDatabase derbyDB = new DerbyDatabase();
			boolean userExists = derbyDB.checkUsernameExists(username);
			if(userExists == false) {
				derbyDB.insertUserIntoUsersTable(username, password);
				goodSignUp = true;
			}
		}
		
		return goodSignUp;
	}
}