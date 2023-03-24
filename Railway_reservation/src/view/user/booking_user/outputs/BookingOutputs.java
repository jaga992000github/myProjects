package view.user.booking_user.outputs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.admin.booking_admin.pojo.Carriage;
import model.admin.booking_admin.pojo.Seat;
import model.admin.booking_admin.pojo.Train;
import view.validation.NumberValidations;

public class BookingOutputs {
	NumberValidations nv=new NumberValidations();
	
	public Train selectTrainFromMatchedTrains(ArrayList<Train>train_list){
		ArrayList<String> train_name_list=new ArrayList<String>();
		for(Train train : train_list) {
			System.out.println(train.getTrainDetails());
			train_name_list.add(train.getTrain_name());
		}
		System.out.println("\n\nPlease Select Train");
		int selected_train_index=nv.validateSelectionNumber(train_name_list);
		Train selected_train=train_list.get(selected_train_index-1);
		return selected_train;	
	}
	
	public Carriage selectCarriage(Train train) {
		ArrayList<String> carriage_name_list=new ArrayList<String>();
		ArrayList<Carriage> carriage_list=new ArrayList<Carriage>();
		HashMap<String,Carriage>carriages=train.getCarriages();
		for(Map.Entry<String, Carriage> entry:carriages.entrySet()) {
			Carriage carriage=entry.getValue();
			System.out.println(carriage.getCarriageDetails());
			carriage_list.add(carriage);
			carriage_name_list.add(carriage.getClass_type());
		}
		System.out.println("Select carriage");
		int selected_carriage_index=nv.validateSelectionNumber(carriage_name_list);
		Carriage selected_carriage=carriage_list.get(selected_carriage_index-1);
		return selected_carriage;
	}
	public void printNotAvailabe() {
		System.out.println("There is no train available");
	}
	public void printSeat(Seat seat) {
		System.out.println(seat);
	}
}
