package model.admin.booking_admin.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import model.user.booking_user.pojo.Passenger;

public class Carriage {
	private String alpha_coach_id;
	private String class_type;
	private boolean is_ac;
	private boolean is_sleeper;
	private ArrayList<Coach> coach_list;
	private ArrayList<Passenger> waiting_list ;
	private int available_confirm_seats;
	private double basic_fee;
	private double cost_per_km;
	private Stop passenger_starting_stop;
	private Stop passenger_reaching_stop;

	@Override
	public String toString(){
		String str="";
		str+=getCarriageDetails() ;
		for(Coach coach:coach_list) {
			str+=coach.toString()+"\n";
		}
		return str;
	}
	public Carriage() {
		
	}
	
	public String getCarriageDetails() {
		String str="";
		str+="\n\nCarriage: "+this.class_type+"\n";
		str+="available confirm seats: "+this.available_confirm_seats+"\n";
		str+="waiting List: "+waiting_list.size()+"\n";
		str+="Cost per Person:"+calculateTravelCost()+"\n";
		return str;
	}
	private double calculateTravelCost() {
		double travel_cost=0.0;
		double travel_distance_in_km=this.passenger_reaching_stop.getKm_from_start()-
				this.passenger_starting_stop.getKm_from_start();
		travel_cost+=this.basic_fee;
		travel_cost+=travel_distance_in_km*this.cost_per_km;	
		return travel_cost;
	}
	
	public Carriage (HashMap<String,Object> carriage_instances) {
		this.alpha_coach_id=((String) carriage_instances.get("alpha_coach_id"));
		this.class_type=(String) carriage_instances.get("class_type");
		this.is_ac=(boolean) carriage_instances.get("is_ac");
		this.is_sleeper=(boolean) carriage_instances.get("is_sleeper");
		this.basic_fee=(double) carriage_instances.get("basic_fee");
		this.cost_per_km=(double) carriage_instances.get("cost_per_km");
		this.available_confirm_seats=0;
		this.passenger_starting_stop=(Stop) carriage_instances.get("passenger_starting_stop");
		this.passenger_reaching_stop=(Stop) carriage_instances.get("passenger_reaching_stop");
		@SuppressWarnings("unchecked")
		HashMap<String,Object>coach_instances=(HashMap<String, Object>) carriage_instances.get("coach_instances");
		int coach_count=(int) carriage_instances.get("coach_count");
		@SuppressWarnings("unchecked")
		LinkedList<Stop>train_route=(LinkedList<Stop>) carriage_instances.get("train_route");
		this.coach_list=this.bindCoach(coach_instances, coach_count,train_route);
		for(Coach coach:coach_list) {
			this.available_confirm_seats+=coach.getAvailable_confirm_seats_count();
		}
		this.waiting_list=new ArrayList<Passenger>();
	}
	
	public void setPassengerRoute(Stop from_stop,Stop to_stop) {
		this.passenger_starting_stop= from_stop;
		this.passenger_reaching_stop = to_stop;
		for(Coach coach :coach_list) {
			coach.setPassengerRoute(from_stop, to_stop);
		}
	}
	
	void refresh() {
		this.available_confirm_seats=0;
		for(Coach coach:coach_list) {
			coach.refresh();
			this.available_confirm_seats+=coach.getAvailable_confirm_seats_count();
		}
	}
	
	private ArrayList<Coach> bindCoach(HashMap<String,Object>coach_instances,int coach_count,LinkedList<Stop>train_route){
		ArrayList<Coach> coach_list=new ArrayList<Coach>();
		for(int i=1;i<=coach_count;i++) {
			String alpha_num_coach_id=this.alpha_coach_id+"-"+i;
			coach_instances.put("coach_id", alpha_num_coach_id);
			coach_instances.put("is_sleeper", this.is_sleeper);
			coach_instances.put("train_route", train_route);
			Coach coach=new Coach(coach_instances);
			coach_list.add(coach);
		}
		return coach_list;
	}

	public String getClass_type() {
		return class_type;
	}
	public void setClass_type(String class_type) {
		this.class_type = class_type;
	}
	
	public ArrayList<Coach> getCoach_list() {
		return coach_list;
	}


	public void setCoach_list(ArrayList<Coach> coach_list) {
		this.coach_list = coach_list;
	}
	public ArrayList<Passenger> getWaiting_list() {
		return waiting_list;
	}
	public void setWaiting_list(ArrayList<Passenger> waiting_list) {
		this.waiting_list = waiting_list;
	}
	public int getAvailable_confirm_seats() {
		for(Coach coach:coach_list) {
			this.available_confirm_seats+=coach.getAvailable_confirm_seats_count();
		}
		return available_confirm_seats;
	}
	public void setAvailable_confirm_seats(int available_confirm_seats) {
		this.available_confirm_seats = available_confirm_seats;
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
	public String getAlpha_coach_id() {
		return alpha_coach_id;
	}
	public void setAlpha_coach_id(String alpha_coach_id) {
		this.alpha_coach_id = alpha_coach_id;
	}
	public boolean isIs_ac() {
		return is_ac;
	}
	public void setIs_ac(boolean is_ac) {
		this.is_ac = is_ac;
	}
	public boolean isIs_sleeper() {
		return is_sleeper;
	}
	public void setIs_sleeper(boolean is_sleeper) {
		this.is_sleeper = is_sleeper;
	}
	public int getCurrentWaitingListNO(Passenger passenger) {
		int index=1;
		for(Passenger current_passenger :this.waiting_list) {
			if(passenger.equals(current_passenger)){
				break;
			}
			else {
			index++;}
		}
		return index;
	}
}
