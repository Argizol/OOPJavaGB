package Lesson5and6;

import java.util.Map;

public interface Authority {
	boolean check(String login, String password, Map<String, String> usersDB);
}
