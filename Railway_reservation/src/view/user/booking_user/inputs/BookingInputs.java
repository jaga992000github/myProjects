package view.user.booking_user.inputs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import model.admin.booking_admin.pojo.Seat;
import model.user.booking_user.pojo.Passenger;
import view.validation.NumberValidations;

public class BookingInputs {
	Scanner scan=new Scanner(System.in);
	NumberValidations nv=new NumberValidations();
	
	public HashMap<String,Object> getUserDetails() {
		HashMap<String,Object> user_instances=new HashMap<String,Object>();
		System.out.println("Enter email");
		String email=scan.next();
		System.out.println("Enter password");
		String password=scan.next();
		user_instances.put("email", email);
		user_instances.put("password",password);
		return user_instances;	
	}
	public ArrayList<HashMap<String,Object>> getPassengengerDetails() {
		ArrayList<HashMap<String,Object>>passenger_instances_list=new ArrayList<HashMap<String,Object>>();
		System.out.println("Enter how many Passengers");
		int no_of_passengers=scan.nextInt();
		int i=0;
		while(i<no_of_passengers) {
			HashMap<String,Object> passenger_instances=new HashMap<String,Object>();
			System.out.println("Enter passenger_"+(i+1)+" details");
			System.out.println("Enter Passenger Name");
			String name=scan.next();
			System.out.println("Enter Passenger Age");
			int age=scan.nextInt();
			System.out.println("Enter Passenger Gender");
			String gender=scan.next();
			ArrayList<String> birth_position_list=new ArrayList<String>();
			birth_position_list.add("U");
			birth_position_list.add("M");
			birth_position_list.add("L");
			
			if(age>5) {
				System.out.println("Enter Passenger phno");
				int ph_no=scan.nextInt();
				System.out.println("Enter Passenger Email");
				String email=scan.next();
				System.out.println("Select prefered Birth");
				char preferd_birth= nv.validateSelectionValue(birth_position_list).charAt(0);
				passenger_instances.put("ph_no",ph_no);
				passenger_instances.put("email",email);
				passenger_instances.put("preferd_birth",preferd_birth);
			}
			passenger_instances.put("gender",gender);
			passenger_instances.put("name",name);
			passenger_instances.put("age",age);
			passenger_instances_list.add(passenger_instances);
			i++;
		}
		return passenger_instances_list;
	}
	public HashMap<String,String> getStopDetails() {
		HashMap<String,String> stop_details=new HashMap<String,String>();
		System.out.println("Enter from stop");
		String from_stop=scan.next();
		System.out.println("Enter to stop");
		String to_stop=scan.next();
		stop_details.put("from_stop", from_stop);
		stop_details.put("to_stop", to_stop);
		return stop_details;	
	}
	
}
