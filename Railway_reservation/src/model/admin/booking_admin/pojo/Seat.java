package model.admin.booking_admin.pojo;

import java.util.HashMap;

public class Seat {
	private int seat_no;
	private char seat_position;
	private char birth_position;
	private boolean is_RAC_replacable;
	private Stop engaging_stop;
	private Stop vcant_stop;
	private boolean is_booked;
	private String booked_as;
	
	
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
		this.is_RAC_replacable=(boolean) seat_instances.get("is_RAC_replacable");
		this.booked_as="vacant";
		this.engaging_stop=null;
		this.vcant_stop=null;
		this.is_booked=false;
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
	public boolean isRAC_replacable() {
		return is_RAC_replacable;
	}

	public void setis_RAC_replacable(boolean is_RAC_replacable) {
		this.is_RAC_replacable = is_RAC_replacable;
	}
	public Stop getEngaging_stop() {
		return engaging_stop;
	}
	public void setEngaging_stop(Stop engaging_stop) {
		if(this.engaging_stop ==null||
				engaging_stop.getKm_from_start() < this.engaging_stop.getKm_from_start()) {
		this.engaging_stop = engaging_stop;}
	}
	public Stop getVcant_stop() {
		return vcant_stop;
	}
	public void setVcant_stop(Stop vcant_stop) {
		if(this.vcant_stop==null||
				vcant_stop.getKm_from_start()>this.vcant_stop.getKm_from_start()) {
			this.vcant_stop = vcant_stop;
		}
	}
	public boolean is_booked() {
		return is_booked;
	}
	public void setIs_booked(boolean is_booked) {
		this.is_booked = is_booked;
	}
	public String getBooked_as() {
		return booked_as;
	}
	public void setBooked_as(String booked_as) {
		this.booked_as = booked_as;
	}
	

	
}