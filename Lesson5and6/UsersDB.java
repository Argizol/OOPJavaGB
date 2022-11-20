package Lesson5and6;

import java.util.HashMap;
import java.util.Map;

public class UsersDB {
	Map<String, String> usersDB;

	public UsersDB() {
		usersDB = new HashMap<>();
		var u1 = new Users("Vasya", "123");
		var u2 = new Users("Petya", "qwerty");
		var u3 = new Users("Galya", "qwerty1");
		usersDB.put(u1.getLogin(), u1.getPassword());
		usersDB.put(u2.getLogin(), u2.getPassword());
		usersDB.put(u3.getLogin(), u3.getPassword());
	}

	public Map<String, String> getUsersDB() {
		return usersDB;
	}
}
