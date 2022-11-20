package Lesson5and6;

import java.util.Scanner;

public class UsersView implements View{

	Scanner sc;
	UsersDB usersDB;
	View view;

	public UsersView(UsersDB usersDB) {
		this.usersDB = usersDB;
		sc = new Scanner(System.in);
	}

	@Override
	public void printAll(UsersDB usersDB) {
		for (String s: usersDB.getUsersDB().keySet()){
			System.out.println(s + " " + usersDB.getUsersDB().get(s));
		}
	}

	@Override
	public void print(String s) {
		System.out.println(s);
	}

	@Override
	public String getLogin() {
		System.out.println("Введите логин: ");
		return sc.nextLine();
	}

	@Override
	public String getPassword() {
		System.out.println("Введите пароль: ");
		return sc.nextLine();
	}

}
