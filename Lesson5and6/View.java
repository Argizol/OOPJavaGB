package Lesson5and6;

import java.util.Map;

public interface View {
	void printAll(UsersDB usersDB);
	void print(String s);
	String getLogin();
	String getPassword();
}
