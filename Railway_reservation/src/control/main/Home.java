package control.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import control.admin.booking_admin.operations.AdminOperations;
import control.user.booking_user.operations.UserOperations;
import model.user.booking_user.pojo.AvailableUsers;
import model.user.booking_user.pojo.User;
import view.user.booking_user.inputs.BookingInputs;
import view.validation.NumberValidations;

public class Home {
	private NumberValidations nv=new NumberValidations();
	
	
	public void SelectUser() {
		ArrayList<String> users=new ArrayList<String>();
		users.add("user");
		users.add("admin");
		users.add("Exit");
		Operatator operator=null;
		while(true) {
			String user =nv.validateSelectionValue(users);
			if(user.equals("Exit")) {
				break;
			}
			else if(user.equals("user")) {
				operator=new UserOperations(userLogin());
			}
			else if(user.equals("admin")) {
				adminLogin();
				operator=new AdminOperations();
			}
			operator.operate();
		}
	}
	
	
	
	private User userLogin() {
		BookingInputs bi=new BookingInputs();
		AvailableUsers a_users=new AvailableUsers();
		User user=null;
		ArrayList<String> log=new ArrayList<String>();
		log.add("login");
		log.add("Register");
		String selection=nv.validateSelectionValue(log);
		if(selection.equals("Register")) { 
			userRegister();
			System.out.println("Register Sucessfully");
		}
		while(user==null) {
			System.out.println("Please Login");
			HashMap<String,String> user_instances=bi.getUserDetails();
			String email=user_instances.get("email");
			String password=user_instances.get("password");
			if(a_users.userLogin(email, password)) {
				user=a_users.getAvailable_users().get(email);
			}
			else {
				System.out.println("Wrong User Id or PassWord");
			}
		}
		return user;
		
	}
	private void userRegister() {
		AvailableUsers a_users=new AvailableUsers();
		BookingInputs bi=new BookingInputs();
		while(true) {
			HashMap<String,String> user_instances=bi.getUserDetails();
			String email=user_instances.get("email");
			String password=user_instances.get("password");	
			if(a_users.isUserAddable(email)) {
				a_users.addUser(email, password);
				break;
			}
			else {
				System.out.println("This email already Exists");
			}
		}	
	}
	
	private void adminLogin() {
		while(true) {
			System.out.println("Enter password");
			Scanner scan=new Scanner(System.in);
			String password=scan.next();
			if(password.equals("admin")) {
				break;
			}
			else{
				System.out.println("wrong password");
			}
		}
	}
	
}
