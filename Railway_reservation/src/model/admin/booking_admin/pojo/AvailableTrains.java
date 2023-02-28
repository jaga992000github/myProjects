package model.admin.booking_admin.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class AvailableTrains {
	
	public static HashMap<HashMap<String,Stop>,Train> available_trains; 
	public static ArrayList<HashMap<String,Stop>>search_route_list;

	
	public void addTrain(Train train) {
		LinkedList<Stop> train_route=train.getTrain_route();
		HashMap<String,Stop>search_route=new HashMap<String,Stop>();
		for(Stop stop:train_route) {
			String stop_name=stop.getName();
			search_route.put(stop_name, stop);
		}
		available_trains.put(search_route, train);
		search_route_list.add(search_route);
	}
	
	public ArrayList<Train>searchTrainsByRoute(HashMap<String,String> stop_details){
		ArrayList<Train> train_list=new ArrayList<Train>();
		String from_stop=stop_details.get("from_stop");
		String to_stop=stop_details.get("to_stop");
		for(HashMap<String,Stop> search_route:search_route_list) {
			if(search_route.get(from_stop)!=null&&search_route.get(to_stop)!=null) {
				train_list.add(available_trains.get(search_route));
			}
		}
		return train_list;
	}
}