package model.admin.booking_admin.pojo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import control.admin.booking_admin.initializer.ModelInitializer;

public class AvailableTrains {
	
	private static HashMap<HashMap<String,Stop>,Train> available_trains=new  HashMap<HashMap<String,Stop>,Train>(); 
	private static ArrayList<HashMap<String,Stop>>search_route_list=new ArrayList<HashMap<String,Stop>>();


	public void addTrain(HashMap<String,Object> train_instances) {
		Train train=new Train(train_instances);
		LinkedList<Stop> train_route=train.getTrain_route();
		HashMap<String,Stop>search_route=new HashMap<String,Stop>();
		for(Stop stop:train_route) {
			String stop_name=stop.getName();
			search_route.put(stop_name, stop);
		}
		AvailableTrains.available_trains.put(search_route, train);
		AvailableTrains.search_route_list.add(search_route);
	}
	
	private ArrayList<Train> searchTrainsByRoute(String from_stop_name,String to_stop_name){
		ArrayList<Train> route_matched_trains=new ArrayList<Train>();
		for(HashMap<String,Stop> search_route:search_route_list) {
			Stop from_stop=search_route.get(from_stop_name);
			Stop to_stop=search_route.get(to_stop_name);
			if(from_stop!=null&&to_stop!=null&&from_stop.getKm_from_start() < to_stop.getKm_from_start()){
				Train train =available_trains.get(search_route);
				train.setPassenger_stop_starting_stop(from_stop);
				train.setPassenger_stop_reaching_stop(to_stop);
				route_matched_trains.add(train);
			}
		}
		return route_matched_trains;
	}
	
	private ArrayList<Train> searchTrainsByTime(ArrayList<Train> route_matched_trains,LocalDateTime dateTime){
		ArrayList<Train> time_matched_trains=new ArrayList<Train>();
		for(Train train:route_matched_trains) {
			if((dateTime.toLocalDate()).equals(train.getTrain_starting_time().toLocalDate())) {
				time_matched_trains.add(train);
			}
		}
		return time_matched_trains;
	}
	
	public ArrayList<Train> searchTrains(String from_stop_name,String to_stop_name,LocalDateTime dateTime){
		ArrayList<Train> route_matched_trains=searchTrainsByRoute(from_stop_name, to_stop_name);
		return searchTrainsByTime(route_matched_trains, dateTime);
	}
	
	public static HashMap<HashMap<String, Stop>, Train> getAvailable_trains() {
		return available_trains;
	}

	public static void setAvailable_trains(HashMap<HashMap<String, Stop>, Train> available_trains) {
		AvailableTrains.available_trains = available_trains;
	}

	public static ArrayList<HashMap<String, Stop>> getSearch_route_list() {
		return search_route_list;
	}

	public static void setSearch_route_list(ArrayList<HashMap<String, Stop>> search_route_list) {
		AvailableTrains.search_route_list = search_route_list;
	}
}