package model.user.booking_user.pojo;

import java.util.HashMap;

public class User {
	private String email;
	private String password;
	private HashMap<Integer,Ticket> tickets;
	
	public User (HashMap<String, Object> user_instances) {
		this.email=(String) user_instances.get("email");
		this.password=(String) user_instances.get("password");
		this.tickets=null;
	}	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public HashMap<Integer,Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(HashMap<Integer,Ticket> tickets) {
		this.tickets = tickets;
	}
}
