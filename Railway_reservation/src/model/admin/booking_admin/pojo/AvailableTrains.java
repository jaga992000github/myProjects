package model.admin.booking_admin.pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class AvailableTrains {
	
	private static HashMap<HashMap<String,Stop>,Train> available_trains=new  HashMap<HashMap<String,Stop>,Train>(); 
	private static ArrayList<HashMap<String,Stop>>search_route_list=new ArrayList<HashMap<String,Stop>>();
	private static HashMap<String,Train>train_no_map=new HashMap<String,Train>();
	private static ArrayList<String> available_train_no=new ArrayList<String>();

	public static void addTrain(Train train) {
		HashMap<String,Stop>search_route=train.getStop_map();
		AvailableTrains.available_trains.put(search_route, train);
		AvailableTrains.search_route_list.add(search_route);
		AvailableTrains.train_no_map.put(train.getTrain_no()+"", train);
		AvailableTrains.available_train_no.add(train.getTrain_no()+"");
	}
	
	public static void deleateTrain(Train train) {
		String train_no=train.getTrain_no()+"";
		available_train_no.remove(train_no);
		train_no_map.remove(train_no);
		search_route_list.remove(train.getStop_map());
		available_trains.remove(train.getStop_map());
	}
	
	private ArrayList<Train> searchTrainsByRoute(String from_stop_name,String to_stop_name){
		ArrayList<Train> route_matched_trains=new ArrayList<Train>();
		for(HashMap<String,Stop> search_route:search_route_list) {
			Stop from_stop=search_route.get(from_stop_name);
			Stop to_stop=search_route.get(to_stop_name);
			if(from_stop!=null&&to_stop!=null&&from_stop.getKm_from_start() < to_stop.getKm_from_start()){
				Train train =available_trains.get(search_route);
				train.setPassengerRoute(from_stop, to_stop);
				route_matched_trains.add(train);
			}
		}
		return route_matched_trains;
	}
	
	private ArrayList<Train> searchTrainsByTime(ArrayList<Train> route_matched_trains,LocalDate date){
		ArrayList<Train> time_matched_trains=new ArrayList<Train>();
		for(Train train:route_matched_trains) {
			if((date).equals(train.getTrain_starting_time().toLocalDate())) {
				time_matched_trains.add(train);
			}
		}
		return time_matched_trains;
	}
	
	
	public ArrayList<Train> searchTrains(String from_stop_name,String to_stop_name,LocalDate date){
		ArrayList<Train> route_matched_trains=searchTrainsByRoute(from_stop_name, to_stop_name);
		return searchTrainsByTime(route_matched_trains, date);
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
	public static HashMap<String, Train> getTrain_no_map() {
		return train_no_map;
	}

	public static ArrayList<String> getAvailable_train_no() {
		return available_train_no;
	}
}