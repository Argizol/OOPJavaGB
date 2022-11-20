package Lesson5and6;

public class Main {
	public static void main(String[] args) {
		boolean can_work = false;
		UsersDB usersDB = new UsersDB();
		View view = new UsersView(usersDB);
		UserAuthority userAuthority = new UserAuthority(view);
		while (!can_work){
		 can_work = userAuthority.check(view.getLogin(), view.getPassword(), usersDB.getUsersDB());
		}
		view.printAll(usersDB);

	}
}
