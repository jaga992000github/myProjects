package control.user.booking_user.operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import model.user.booking_user.pojo.Passenger;

public class PassengerTemplates implements Comparator<Passenger> {
	HashMap<String,Object> pass1(){
		HashMap<String,Object> passenger_instances=new HashMap<String,Object>();
		passenger_instances.put("ph_no",12345);
		passenger_instances.put("email","@mr_a");
		passenger_instances.put("preferd_birth",'U');
		passenger_instances.put("gender","Male");
		passenger_instances.put("name","pass_1");
		passenger_instances.put("age",10);
		return passenger_instances;
	}
	
	HashMap<String,Object> pass2(){
		HashMap<String,Object> passenger_instances=new HashMap<String,Object>();
		passenger_instances.put("ph_no",12345);
		passenger_instances.put("email","@mr_b");
		passenger_instances.put("preferd_birth",'M');
		passenger_instances.put("gender","Male");
		passenger_instances.put("name","pass_2");
		passenger_instances.put("age",20);
		return passenger_instances;
	}
	HashMap<String,Object> pass3(){
		HashMap<String,Object> passenger_instances=new HashMap<String,Object>();
		passenger_instances.put("ph_no",12345);
		passenger_instances.put("email","@mr_c");
		passenger_instances.put("preferd_birth",'L');
		passenger_instances.put("gender","Male");
		passenger_instances.put("name","pass_3");
		passenger_instances.put("age",30);
		return passenger_instances;
	}
	HashMap<String,Object> pass4(){
		HashMap<String,Object> passenger_instances=new HashMap<String,Object>();
		passenger_instances.put("ph_no",12345);
		passenger_instances.put("email","@mr_d");
		passenger_instances.put("preferd_birth",'M');
		passenger_instances.put("gender","Male");
		passenger_instances.put("name","pass_4");
		passenger_instances.put("age",40);
		return passenger_instances;
	}
	HashMap<String,Object> pass5(){
		HashMap<String,Object> passenger_instances=new HashMap<String,Object>();
		passenger_instances.put("ph_no",12345);
		passenger_instances.put("email","@mr_e");
		passenger_instances.put("preferd_birth",'U');
		passenger_instances.put("gender","Male");
		passenger_instances.put("name","pass_5");
		passenger_instances.put("age",50);
		return passenger_instances;
	}
	
	HashMap<String,Object> pass6(){
		HashMap<String,Object> passenger_instances=new HashMap<String,Object>();
		passenger_instances.put("ph_no",12345);
		passenger_instances.put("email","@mr_f");
		passenger_instances.put("preferd_birth",'U');
		passenger_instances.put("gender","Male");
		passenger_instances.put("name","pass_6");
		passenger_instances.put("age",60);
		return passenger_instances;
	}
	HashMap<String,Object> pass7(){
		HashMap<String,Object> passenger_instances=new HashMap<String,Object>();
		passenger_instances.put("ph_no",12345);
		passenger_instances.put("email","@mr_g");
		passenger_instances.put("preferd_birth",'U');
		passenger_instances.put("gender","Male");
		passenger_instances.put("name","pass_7");
		passenger_instances.put("age",70);
		return passenger_instances;
	}
	HashMap<String,Object> pass8(){
		HashMap<String,Object> passenger_instances=new HashMap<String,Object>();
		passenger_instances.put("ph_no",12345);
		passenger_instances.put("email","@mr_h");
		passenger_instances.put("preferd_birth",'U');
		passenger_instances.put("gender","Male");
		passenger_instances.put("name","pass_8");
		passenger_instances.put("age",80);
		return passenger_instances;
	}
	HashMap<String,Object> pass9(){
		HashMap<String,Object> passenger_instances=new HashMap<String,Object>();
		passenger_instances.put("ph_no",12345);
		passenger_instances.put("email","@mr_i");
		passenger_instances.put("preferd_birth",'U');
		passenger_instances.put("gender","Male");
		passenger_instances.put("name","pass_9");
		passenger_instances.put("age",90);
		return passenger_instances;
	}
	HashMap<String,Object> pass10(){
		HashMap<String,Object> passenger_instances=new HashMap<String,Object>();
		passenger_instances.put("ph_no",12345);
		passenger_instances.put("email","@mr_j");
		passenger_instances.put("preferd_birth",'U');
		passenger_instances.put("gender","Male");
		passenger_instances.put("name","pass_10");
		passenger_instances.put("age",100);
		return passenger_instances;
	}
	public ArrayList<HashMap<String,Object>> getPassengengerDetails_1() {
		ArrayList<HashMap<String,Object>>passenger_instances_list=new ArrayList<HashMap<String,Object>>();
			passenger_instances_list.add(pass1());
			passenger_instances_list.add(pass2());
			passenger_instances_list.add(pass3());
			passenger_instances_list.add(pass4());
			passenger_instances_list.add(pass5());
		return passenger_instances_list;
	}
	
	public ArrayList<HashMap<String,Object>> getPassengengerDetails_2() {
		ArrayList<HashMap<String,Object>>passenger_instances_list=new ArrayList<HashMap<String,Object>>();
			passenger_instances_list.add(pass1());
			passenger_instances_list.add(pass2());
			passenger_instances_list.add(pass3());
			passenger_instances_list.add(pass4());
			passenger_instances_list.add(pass5());
			passenger_instances_list.add(pass6());
			passenger_instances_list.add(pass7());
			passenger_instances_list.add(pass8());
			passenger_instances_list.add(pass9());
			passenger_instances_list.add(pass10());
		return passenger_instances_list;
	}
	public static void main(String[] args) {
		PassengerTemplates aot=new PassengerTemplates();
		ArrayList<HashMap<String,Object>> passengengerDetails=aot.getPassengengerDetails_1();
		ArrayList<Passenger> pasenger_list=new ArrayList<Passenger>();
		for(HashMap<String,Object> pass_ins:passengengerDetails) {
			pasenger_list.add(new Passenger(pass_ins));
		}
		Collections.sort(pasenger_list, new PassengerTemplates());
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
