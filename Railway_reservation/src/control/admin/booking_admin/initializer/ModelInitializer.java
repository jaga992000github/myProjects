package control.admin.booking_admin.initializer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import model.admin.booking_admin.pojo.AvailableTrains;
import model.admin.booking_admin.pojo.Carriage;
import model.admin.booking_admin.pojo.Coach;
import model.admin.booking_admin.pojo.Seat;
import model.admin.booking_admin.pojo.Stop;
import model.admin.booking_admin.pojo.Train;
import view.admin.booking_admin.pojo_instances_templates.TrainInstancesTemplates;

public class ModelInitializer {
	AvailableTrains at=new AvailableTrains();
	TrainInstancesTemplates tt= new TrainInstancesTemplates();
	
	
	
	public ModelInitializer() {
		ArrayList<String> avaiable_train_instances_keys =tt.getAvailabe_train_instances_keys();
		HashMap<String,HashMap<String,Object>>avaiable_train_instances=tt.getAvaiable_train_instances();	
		for(String train_instances_key:avaiable_train_instances_keys) {
			HashMap<String,Object> train_instances=avaiable_train_instances.get(train_instances_key);
			at.addTrain(train_instances);
		}
		String from_stop="stop_1";
		String to_stop="stop_9";
		LocalDate current_date=LocalDate.now();
		Train filled_train=at.searchTrains(from_stop, to_stop, current_date).get(0);
		seatFiller(filled_train);
	}
	
	private void seatFiller(Train train) {
		
		Carriage carriage=train.getCarriages().get("sleeper");
		ArrayList<Coach> coach_list=carriage.getCoach_list();
		Stop enggaging_stop=train.getTrain_route().getFirst();
		Stop vacant_stop=train.getTrain_route().getLast();
		for(Coach coach:coach_list) {
			int seat_no=1;
			int total_seats=coach.getTotal_seats()-2;
			for(int i=1;i<=coach.getTotal_rows();i++) {
				int row=i;
				
				for(int j=1;j<=coach.getTotal_col();j++) {
					if(seat_no>total_seats) {
						break;
					}
					int col=j;
					HashMap<HashMap<String,Object>,Seat> coach_seats=coach.getCoach_seats();
					HashMap<String,Object> seat_map=new HashMap<String,Object>();
					seat_map.put("row", row);
					seat_map.put("col", col);
					seat_map.put("seat_no", seat_no);
					Seat seat=coach_seats.get(seat_map);
					seat.setEngaging_stop(enggaging_stop);
					seat.setVcant_stop(vacant_stop);
					seat.setBooked_as("confirm");
					seat.setIs_booked(true);
					seat_no++;
				}
			}
		}
	}
}
