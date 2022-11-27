package Lesson5and6;

import java.util.Map;

public  class UserAuthority implements Authority{
	private View view;
	private UsersDB usersDB;

	public UserAuthority(View view, UsersDB usersDB) {
		this.view = view; this.usersDB = usersDB;
	}

	@Override
	public boolean check() {

		boolean bool = false;
		String login = view.getLogin();

		if(!usersDB.getUsersDB().containsKey(login)){
			view.print("Пользователь не найден");
			return false;
		}
		String password = view.getPassword();

		for(String user : usersDB.getUsersDB().keySet()){
			if(user.equals(login)){
				if(password.equals(usersDB.getUsersDB().get(login))){
					view.print("Авторизация успешна");
					bool =  true;
				} else {
					view.print("Ошибка авторизации");
					return false;
				}
			}
		}
		return bool;
	}
}
