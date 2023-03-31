package control.main;

import control.admin.booking_admin.initializer.ModelInitializer;
import control.admin.booking_admin.initializer.ViewInitializer;

public class Main {
	static {
		new ViewInitializer();
		new ModelInitializer();
	}
	public static void main(String[] args) {
		Home home=new Home();
		home.SelectUser();
		System.out.println("thank You");
	}
}
