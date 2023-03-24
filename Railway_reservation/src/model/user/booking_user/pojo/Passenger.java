package model.user.booking_user.pojo;

import java.util.HashMap;

import model.admin.booking_admin.pojo.Seat;

public class Passenger {
	private String name;
	private int age;
	private String gender;
	private int ph_no;
	private String email;
	private Seat seat;
	private String class_type;
	private String coach_id;
	private int pnr_no;
	private String booked_status;
	private char preferd_birth;
	
	public Passenger (HashMap<String, Object> passenger_instances) {
		this.name=(String) passenger_instances.get("name");
		this.age=(int) passenger_instances.get("age");
		this.gender=(String) passenger_instances.get("gender");
		if(this.age>5) {
			this.ph_no=(int) passenger_instances.get("ph_no");
			this.email=(String) passenger_instances.get("email");
			this.seat=(Seat) passenger_instances.get("seat");
			this.setPreferd_birth((char) passenger_instances.get("preferd_birth"));
		}
		this.pnr_no=0;
		this.booked_status="";
		this.seat=null;
	}
	
	@Override
	public String toString(){
	String str="Passenger Details"
			+ "\n-PNR No"+this.pnr_no
			+ "\n-Name:"+this.name
			+ "\n-Age:"+this.age
			+ "\n-Gender:"+this.gender
			+ "\n-Booking status:"+this.booked_status;
			
	if(this.booked_status.equals("confirm")||this.booked_status.equals("RAC")) {
		str+="\n-Class:"+this.class_type;
		str+="\n-Coach ID:"+this.coach_id;
		str+="\n-Seat:"+this.seat;
	}
	str+="\n\n";
	return str;	
	}
	
	public int getPnr_no() {
		return pnr_no;
	}
	public void setPnr_no(int pnr_no) {
		this.pnr_no = pnr_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getPh_no() {
		return ph_no;
	}
	public void setPh_no(int ph_no) {
		this.ph_no = ph_no;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	public String getBooked_status() {
		return booked_status;
	}
	public void setBooked_status(String booked_status) {
		this.booked_status = booked_status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getPreferd_birth() {
		return preferd_birth;
	}

	public void setPreferd_birth(char preferd_birth) {
		this.preferd_birth = preferd_birth;
	}
	public String getClass_type() {
		return class_type;
	}

	public void setClass_type(String class_type) {
		this.class_type = class_type;
	}

	public String getCoach_id() {
		return coach_id;
	}

	public void setCoach_id(String coach_id) {
		this.coach_id = coach_id;
	}
	
}
