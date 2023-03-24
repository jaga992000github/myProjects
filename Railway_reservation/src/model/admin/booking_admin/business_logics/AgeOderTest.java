package model.admin.booking_admin.business_logics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import model.user.booking_user.pojo.Passenger;

public class AgeOderTest implements Comparator<Passenger> {
	HashMap<String,Object> pass1(){
		HashMap<String,Object> passenger_instances=new HashMap<String,Object>();
		passenger_instances.put("ph_no",12345);
		passenger_instances.put("email","@mr_a");
		passenger_instances.put("preferd_birth",'U');
		passenger_instances.put("gender","Male");
		passenger_instances.put("name","pass_1");
		passenger_instances.put("age",20);
		return passenger_instances;
	}
	
	HashMap<String,Object> pass2(){
		HashMap<String,Object> passenger_instances=new HashMap<String,Object>();
		passenger_instances.put("ph_no",12345);
		passenger_instances.put("email","@mr_b");
		passenger_instances.put("preferd_birth",'M');
		passenger_instances.put("gender","Male");
		passenger_instances.put("name","pass_2");
		passenger_instances.put("age",30);
		return passenger_instances;
	}
	HashMap<String,Object> pass3(){
		HashMap<String,Object> passenger_instances=new HashMap<String,Object>();
		passenger_instances.put("ph_no",12345);
		passenger_instances.put("email","@mr_c");
		passenger_instances.put("preferd_birth",'L');
		passenger_instances.put("gender","Male");
		passenger_instances.put("name","pass_3");
		passenger_instances.put("age",40);
		return passenger_instances;
	}
	HashMap<String,Object> pass4(){
		HashMap<String,Object> passenger_instances=new HashMap<String,Object>();
		passenger_instances.put("ph_no",12345);
		passenger_instances.put("email","@mr_d");
		passenger_instances.put("preferd_birth",'M');
		passenger_instances.put("gender","Male");
		passenger_instances.put("name","pass_4");
		passenger_instances.put("age",50);
		return passenger_instances;
	}
	HashMap<String,Object> pass5(){
		HashMap<String,Object> passenger_instances=new HashMap<String,Object>();
		passenger_instances.put("ph_no",12345);
		passenger_instances.put("email","@mr_e");
		passenger_instances.put("preferd_birth",'U');
		passenger_instances.put("gender","Male");
		passenger_instances.put("name","pass_5");
		passenger_instances.put("age",60);
		return passenger_instances;
	}
	
	
	public ArrayList<HashMap<String,Object>> getPassengengerDetails() {
		ArrayList<HashMap<String,Object>>passenger_instances_list=new ArrayList<HashMap<String,Object>>();
			passenger_instances_list.add(pass1());
			passenger_instances_list.add(pass2());
			passenger_instances_list.add(pass3());
			passenger_instances_list.add(pass4());
			passenger_instances_list.add(pass5());
		return passenger_instances_list;
	}
	
	public static void main(String[] args) {
		AgeOderTest aot=new AgeOderTest();
		ArrayList<HashMap<String,Object>> passengengerDetails=aot.getPassengengerDetails();
		ArrayList<Passenger> pasenger_list=new ArrayList<Passenger>();
		for(HashMap<String,Object> pass_ins:passengengerDetails) {
			pasenger_list.add(new Passenger(pass_ins));
		}
		Collections.sort(pasenger_list, new AgeOderTest());
		System.out.println(pasenger_list);
	}

	@Override
	public int compare(Passenger p1, Passenger p2) {
		if (p1.getAge() == p2.getAge())
			return 0;
		else if (p1.getAge() > p2.getAge())
			return -1;
		else
			return 1;
	}
}
