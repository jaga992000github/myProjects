package model.user.booking_user.pojo;

import java.util.HashMap;

import model.admin.booking_admin.pojo.Seat;

public class Passenger {
	private int PNR_NO;
	private String name;
	private int age;
	private String gender;
	private int ph_no;
	private String email;
	private Seat seat;
	private String coach_id;
	private String booked_status;
	private char preferd_birth;
	private int waiting_list_no;
	

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
		this.booked_status="";
		this.seat=null;
	}
	
	@Override
	public String toString(){
	String str="Passenger Details"
			+ "\n-Name:"+this.name
			+ "\n-Age:"+this.age
			+ "\n-Gender:"+this.gender
			+ "\n-Booking status:"+this.booked_status;
			
	if(this.booked_status.equals("confirm")||this.booked_status.equals("RAC")) {
		str+=//"\n-Class:"+this.class_type
				"\n-Coach ID:"+this.coach_id
				+this.seat;
	}
	else if(this.booked_status.equals("waiting_list")) {
		str+=" no: "+this.waiting_list_no;
	}
	str+="\n\n";
	return str;	
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
	public String getCoach_id() {
		return coach_id;
	}

	public void setCoach_id(String coach_id) {
		this.coach_id = coach_id;
	}
	
	public int getWaiting_list_no() {
		return waiting_list_no;
	}

	public void setWaiting_list_no(int waiting_list_no) {
		this.waiting_list_no = waiting_list_no;
	}

	public int getPNR_NO() {
		return PNR_NO;
	}

	public void setPNR_NO(int pNR_NO) {
		PNR_NO = pNR_NO;
	}
	
}
