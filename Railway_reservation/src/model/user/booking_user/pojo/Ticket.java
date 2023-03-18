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
	private double basic_fee;
	private double cost_per_km;
	private double total_cost;
	
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
	

	private double getTotalKm() {
		double from_km_from_start=this.from_stop.getKm_from_start();
		double to_km_from_start=this.to_stop.getKm_from_start();
		double total_km=to_km_from_start-from_km_from_start;
		return total_km;
	}
	
	private double getStopToStopCost() {
		double total_km=getTotalKm();
		double cost=(total_km*this.cost_per_km)+this.basic_fee;
		return cost;
	}
	private double getTicketCost() {
		double total_cost=0;
		for(Passenger passenger:this.passengers_details) {
			if(passenger.getAge()>5) {
				total_cost+=getStopToStopCost();
			}
		}
		return total_cost;
	}


	public static int getLast_pnr_no() {
		return last_pnr_no;
	}


	public static void setLast_pnr_no(int last_pnr_no) {
		Ticket.last_pnr_no = last_pnr_no;
	}


	public int getPnr_no() {
		return pnr_no;
	}


	public void setPnr_no(int pnr_no) {
		this.pnr_no = pnr_no;
	}


	public Train getTrain() {
		return train;
	}


	public void setTrain(Train train) {
		this.train = train;
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


	public String getCoach_id() {
		return coach_id;
	}


	public void setCoach_id(String coach_id) {
		this.coach_id = coach_id;
	}


	public String getClass_type() {
		return class_type;
	}


	public void setClass_type(String class_type) {
		this.class_type = class_type;
	}


	public ArrayList<Passenger> getPassengers_details() {
		return passengers_details;
	}


	public void setPassengers_details(ArrayList<Passenger> passengers_details) {
		this.passengers_details = passengers_details;
	}


	public double getBasic_fee() {
		return basic_fee;
	}


	public void setBasic_fee(double basic_fee) {
		this.basic_fee = basic_fee;
	}


	public double getCost_per_km() {
		return cost_per_km;
	}


	public void setCost_per_km(double cost_per_km) {
		this.cost_per_km = cost_per_km;
	}
	
	public double getTotal_cost() {
		return total_cost;
	}


	public void setTotal_cost(double total_cost) {
		this.total_cost = total_cost;
	}
	
	
}
