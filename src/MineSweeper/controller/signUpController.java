package MineSweeper.controller;

import MineSweeper.derby.DerbyDatabase;

public class signUpController {
	private String username, password, passwordCheck ;
	
	/*
	Process to add a new username.
		Checks if the password verification passes. (Both password Strings are the same)
		Checks if the username exists in the database.
		If the username does not exist already, adds the new user to the database.
	*/
	
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
				System.out.println("User already exists.");
			}
		}
		
		return goodSignUp;
	}
}