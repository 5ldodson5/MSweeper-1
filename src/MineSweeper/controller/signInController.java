package MineSweeper.controller;

public class signInController {
	private String username, password;
	
	public boolean checkUser(String username, String password) {
		if(username == "admin" && password == "password") {
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