package model.admin.booking_admin.pojo;


import java.util.HashMap;
import java.util.LinkedList;

public class Seat {
	private int seat_no;
	private char seat_position;
	private char birth_position;
	private boolean is_RAC_replacable;
	private Stop from_stop;
	private Stop to_stop;
	private boolean is_booked;
	private String booked_as;
	private LinkedList<Stop> train_route;
	
	@Override
	public String toString(){
		String str="\n\nSeat Details"
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
		this.from_stop=null;
		this.to_stop=null;
		this.is_booked=false;
		
		@SuppressWarnings("unchecked")
		LinkedList<Stop> train_route=(LinkedList<Stop>) seat_instances.get("train_route");
		this.train_route=train_route;
		
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
	
	public boolean isIs_RAC_replacable() {
		return is_RAC_replacable;
	}
	public void setIs_RAC_replacable(boolean is_RAC_replacable) {
		this.is_RAC_replacable = is_RAC_replacable;
	}
	public Stop getFrom_stop() {
		return from_stop;
	}
	public void setFrom_stop(Stop from_stop) {
		this.from_stop = from_stop;
	}
	public Stop getTo_stop() {
		return to_stop;
	}
	public void setTo_stop(Stop to_stop) {
		this.to_stop = to_stop;
	}
	public LinkedList<Stop> getTrain_route() {
		return train_route;
	}
	public void setTrain_route(LinkedList<Stop> train_route) {
		this.train_route = train_route;
	}
	public void setis_RAC_replacable(boolean is_RAC_replacable) {
		this.is_RAC_replacable = is_RAC_replacable;
	}
	public boolean is_booked() {
		return is_booked;
	}
	public void setIs_booked(boolean is_booked) {
		this.is_booked=is_booked;
	}
	
	public String getBooked_as() {
		return booked_as;
	}
	public void setBooked_asConfirm() {
		this.booked_as = "confirm";
	}
	public void setBooked_asRAC() {
		this.booked_as = "RAC";
	}
	
	
	public void engageRoute() {
		boolean is_in_the_route=false;
		for(Stop stop:this.train_route) {
			if(stop.equals(from_stop)) {
			is_in_the_route=true;
			}
			if(is_in_the_route) {
				stop.setIs_engaged(true);
			}
			if(stop.equals(to_stop)) {
				is_in_the_route=false;
				break;
			}
		}isBooked();
	}
	
	public void vacantRoute() {
		boolean is_in_the_route=false;
		for(Stop stop:this.train_route) {
			if(stop.equals(from_stop)) {
			is_in_the_route=true;
			}
			if(is_in_the_route) {
				stop.setIs_engaged(false);
			}
			if(stop.equals(to_stop)) {
				is_in_the_route=false;
				break;
			}
		}isBooked();
	}
	
	private boolean isBooked() {
		if(from_stop==null||to_stop==null) {
			is_booked=false;
			return false;
		}
		boolean is_in_the_route=false;
		for(Stop stop:train_route) {
			if(stop.equals(from_stop)) {
			is_in_the_route=true;
			}
			if(is_in_the_route) {
				if(stop.isIs_engaged()) {
					is_booked=true;
					return true;
				}
			}
			if(stop.equals(to_stop)) {
				is_in_the_route=false;
				break;
			}
		}this.is_booked=false;
		return false;
	}
}