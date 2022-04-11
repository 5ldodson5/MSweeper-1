package MineSweeper.controller;
public class signUpController {
	private String username, password, passwordCheck ;
	
	public boolean checkSignUp(String username, String password, String passwordCheck ) {
		//System.out.println(username + ", " + password);
		if(password.equals(passwordCheck)) {
			this.username = username;
			this.password = password;
			return true;
		}
		else {
			return false;
		}
	}
}