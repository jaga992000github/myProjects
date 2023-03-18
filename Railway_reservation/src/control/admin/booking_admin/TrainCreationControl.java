package control.admin.booking_admin;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import control.admin.booking_admin.initializer.ModelInitializer;
import control.admin.booking_admin.initializer.ViewInitializer;
import model.admin.booking_admin.pojo.AvailableTrains;
import model.admin.booking_admin.pojo.Train;
import view.admin.booking_admin.outputs.TrainOutputs;

public class TrainCreationControl {
	
	
	public static void main(String[] args) {
		AvailableTrains at=new AvailableTrains();
		TrainOutputs to=new TrainOutputs();
		String from_stop_name="chennai";
		String to_stop_name="erode";
		LocalDateTime today=LocalDateTime.now();
		ArrayList<Train> matched_trains =at.searchTrains(from_stop_name, to_stop_name, today);
		if(matched_trains.size()==0) {
			to.printNotAvailabe();
		}
		else {
			for(Train train:matched_trains) {
				to.printDetails(train);
			}
		}
	}
}
