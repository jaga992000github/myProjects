package model.user.booking_user.pojo;

import java.util.HashMap;

public class AvailableUsers {

	private static HashMap<String,User>available_users=new HashMap<String,User>();
	
	public AvailableUsers() {
		addUser("user","pass");
		addUser("abc","123");
	}
	
	public boolean isUserAddable(String email) {
		if(available_users.containsKey(email)) {
			return false;
		}
		return true;
	}
	
	public static HashMap<String, User> getAvailable_users() {
		return available_users;
	}
	
	public void addUser(String email,String password) {
		HashMap<String, Object> user_instances=new  HashMap<String, Object>();
		user_instances.put("email", email);
		user_instances.put("password", password);
		User user=new User(user_instances);
		available_users.put(email, user);
	}
	
	public boolean userLogin(String email,String password) {
		if(isUserAddable(email)) {
			return false;
		}
		if(password.equals(available_users.get(email).getPassword())) {
			return true;
		}
		return false;
	}
}
