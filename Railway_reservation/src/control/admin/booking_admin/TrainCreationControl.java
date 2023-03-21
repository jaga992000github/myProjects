package control.admin.booking_admin;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import control.admin.booking_admin.initializer.ModelInitializer;
import control.admin.booking_admin.initializer.ViewInitializer;
import model.admin.booking_admin.pojo.AvailableTrains;
import model.admin.booking_admin.pojo.Carriage;
import model.admin.booking_admin.pojo.Coach;
import model.admin.booking_admin.pojo.Seat;
import model.admin.booking_admin.pojo.Stop;
import model.admin.booking_admin.pojo.Train;
import view.admin.booking_admin.outputs.TrainOutputs;

public class TrainCreationControl {
	static {
		new ViewInitializer();
		new ModelInitializer();
	}
	
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
				//to.print(train);
			}
		}
		Train train=matched_trains.get(0);
		
		Carriage carriage=train.getCarriages().get("sleeper");
		Coach coach=carriage.getCoach_list().get(0);
		
		
		
		
		
		Seat seat=coach.getAvailable_seats().peek();
		System.out.println(seat.is_booked());
		Stop en_stop=train.getStop_map().get("viluppuram");
		Stop vac_stop=train.getStop_map().get("coimbatore");
		System.out.println(seat.is_booked());
		System.out.println("+++++++++++++++");
		
		seat.setEngaging_stop(en_stop);
		seat.setVcant_stop(vac_stop);
		coach.refreshAvailable_seats();
		System.out.println(seat.is_booked());
		//seat.setIs_booked(true);
		//seat.setBooked_as("confirm");
		
		
		//coach.refreshAvailable_seats();
		System.out.println("===="+coach.getAvailable_confirm_seats_count());
		System.out.println(coach);
	}
}
