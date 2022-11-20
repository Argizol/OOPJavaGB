package Lesson5and6;

import java.util.HashMap;
import java.util.Map;

public class Users {

	private String login, password;


	public Users(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "Users{" +
				"login='" + login + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
