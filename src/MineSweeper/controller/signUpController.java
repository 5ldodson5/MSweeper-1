package MineSweeper.controller;
public class signUpController {
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