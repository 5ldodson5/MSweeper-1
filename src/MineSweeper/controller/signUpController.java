package MineSweeper.controller;

import MineSweeper.derby.DerbyDatabase;

public class signUpController {
	private String username, password, passwordCheck ;
	
	public boolean checkSignUp(String username, String password, String passwordCheck ) {
		//System.out.println(username + ", " + password);
				if(password.equals(passwordCheck)) {
					return true;
				}
				else {
					return false;
				}
	}
}