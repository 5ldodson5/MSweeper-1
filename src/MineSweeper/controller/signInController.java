package MineSweeper.controller;

public class signInController {
	private String username, password;
	
	public boolean checkUser(String username, String password) {
		//System.out.println(username + ", " + password);
		if(username.equals("admin") && password.equals("password")) {
			this.username = username;
			this.password = password;
			return true;
		}
		else {
			return false;
		}
	}
	public String guestName(String guestName) {
		return guestName;
	}
}