package model.user.booking_user.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import model.admin.booking_admin.pojo.Carriage;
import model.admin.booking_admin.pojo.Stop;
import model.admin.booking_admin.pojo.Train;

public class Ticket {
	public static int last_pnr_no=1000000000;
	private int pnr_no;
	private Train train;
	private Stop from_stop;
	private Stop to_stop;
	private String coach_id;
	private String class_type;
	private ArrayList<Passenger> passengers_details;
	private int basic_fee;
	private int cost_per_km;
	private int total_cost;
	
	public Ticket(HashMap<String,Object>ticket_instances){
		this.pnr_no=(last_pnr_no+1);
		last_pnr_no+=1;
		
		Train train=(Train) ticket_instances.get("train");
		this.train=train;
		
		this.coach_id=(String) ticket_instances.get("coach_id");
		this.passengers_details=(ArrayList<Passenger>) ticket_instances.get("passengers_details");
		this.from_stop=(Stop) ticket_instances.get("from_stop");
		this.to_stop=(Stop) ticket_instances.get("to_stop");
		this.class_type=(String) ticket_instances.get("class_type");
		HashMap<String,Carriage> carriages=train.getCarriages();
		
		Carriage carriage=(Carriage) carriages.get(this.class_type);
		this.basic_fee=carriage.getBasic_fee();
		this.cost_per_km=carriage.getCost_per_km();
		
		this.total_cost=getTicketCost();
	}
	
	
	@Override
	public String toString() {
		String str= "Ticket"
				+ " pnr_no=" + this.pnr_no + "\n,"
				+ this.train.getTrainDetails();
			str+= " from_stop=" + this.from_stop + "\n"
				+ " to_stop=" + this.to_stop + "\n"
				+ " coach_id=" + this.coach_id+"\n"
				+ " class_type=" + this.class_type + "\n"
				+ " passengers_details=";
				for(Passenger passenger:this.passengers_details) {
					str+="\n"+passenger.toString();
				}
				str+=" basic_fee="+" this.basic_fee" +"\n"
				+ " total_km="+this.getTotalKm()+"\n"
				+ " cost_per_km=" + this.cost_per_km + "\n"
				+ " total_cost=" + this.total_cost + "\n";
		 return str;
	}
	

	private int getTotalKm() {
		int from_km_from_start=this.from_stop.getKm_from_start();
		int to_km_from_start=this.to_stop.getKm_from_start();
		int total_km=to_km_from_start-from_km_from_start;
		return total_km;
	}
	
	private int getStopToStopCost() {
		int total_km=getTotalKm();
		int cost=(total_km*this.cost_per_km)+this.basic_fee;
		return cost;
	}
	private int getTicketCost() {
		int total_cost=0;
		for(Passenger passenger:this.passengers_details) {
			if(passenger.getAge()>5) {
				total_cost+=getStopToStopCost();
			}
		}
		return total_cost;
	}
	
	public synchronized int getPnr_no() {
		return pnr_no;
	}
	public synchronized void setPnr_no(int pnr_no) {
		this.pnr_no = pnr_no;
	}
	
	public synchronized Stop getFrom_stop() {
		return from_stop;
	}
	public synchronized void setFrom_stop(Stop from_stop) {
		this.from_stop = from_stop;
	}
	public synchronized Stop getTo_stop() {
		return to_stop;
	}
	public synchronized void setTo_stop(Stop to_stop) {
		this.to_stop = to_stop;
	}
	public synchronized String getCoach_id() {
		return coach_id;
	}
	public synchronized void setCoach_id(String coach_id) {
		this.coach_id = coach_id;
	}
	public synchronized String getClass_type() {
		return class_type;
	}
	public synchronized void setClass_type(String class_type) {
		this.class_type = class_type;
	}
	public synchronized ArrayList<Passenger> getPassengers_details() {
		return passengers_details;
	}
	public synchronized void setPassengers_details(ArrayList<Passenger> passengers_details) {
		this.passengers_details = passengers_details;
	}
	public synchronized int getTotal_cost() {
		return total_cost;
	}
	public synchronized void setTotal_cost(int total_cost) {
		this.total_cost = total_cost;
	}
	
}
