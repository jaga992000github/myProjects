package model.admin.booking_admin.pojo;

import java.util.HashMap;

public class Seat {
	private int seat_no;
	private char seat_position;
	private char birth_position;
	private boolean booked_status;
	private String booked_as;
	private boolean RAC_replacable;
	private int last_stop_km_from_start;
	
	
	@Override
	public String toString(){
		String str="\nSeat Details"
				+ "\n-Seat No:"+this.seat_no
				+ "\n-Seat position:"+this.seat_position
				+ "\n-Birth_position:"+this.birth_position+"\n";
		return str;
	}
	public Seat() {
		
	}
	public Seat(HashMap<String,Object> seat_instances) {
		this.seat_no=(int) seat_instances.get("seat_no");
		this.seat_position=(char) seat_instances.get("seat_position");
		this.birth_position=(char) seat_instances.get("birth_position");
		this.booked_status=(boolean) seat_instances.get("booked_status");
		this.booked_as=(String) seat_instances.get("booked_as");
		this.RAC_replacable=(boolean) seat_instances.get("RAC_replacable");
	}
	public int getSeat_no() {
		return seat_no;
	}
	public void setSeat_no(int seat_no) {
		this.seat_no = seat_no;
	}
	public char getSeat_position() {
		return seat_position;
	}
	public void setSeat_position(char seat_position) {
		this.seat_position = seat_position;
	}
	public char getBirth_position() {
		return birth_position;
	}
	public void setBirth_position(char birth_position) {
		this.birth_position = birth_position;
	}
	public boolean isBooked_status() {
		return booked_status;
	}
	public void setBooked_status(boolean booked_status) {
		this.booked_status = booked_status;
	}
	public String getBooked_as() {
		return booked_as;
	}

	public void setBooked_as(String booked_as) {
		this.booked_as = booked_as;
	}

	public boolean isRAC_replacable() {
		return RAC_replacable;
	}

	public void setRAC_replacable(boolean rAC_replacable) {
		RAC_replacable = rAC_replacable;
	}
	public int getLast_stop_km_from_start() {
		return last_stop_km_from_start;
	}
	public void setLast_stop_km_from_start(int last_stop_km_from_start) {
		this.last_stop_km_from_start = last_stop_km_from_start;
	}

	
}