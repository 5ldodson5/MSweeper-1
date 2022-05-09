package MineSweeper.controller;

import MineSweeper.derby.DerbyDatabase;

public class signInController {
	private String username, password;
	
	//Checks to see if a user with the given password exists in the database.
	public boolean checkUser(String username, String password) {
		
		DerbyDatabase derbyDB = new DerbyDatabase();
		
		boolean userExists = derbyDB.checkUsernamePassword(username, password);
		
		/*
		//System.out.println(username + ", " + password);
		if(username.equals("admin") && password.equals("password")) {
			this.username = username;
			this.password = password;
			return true;
		}
		else {
			return false;
		}
		*/
		return userExists;
	}
	public String guestName(String guestName) {
		return guestName + " (Guest)";
	}
}