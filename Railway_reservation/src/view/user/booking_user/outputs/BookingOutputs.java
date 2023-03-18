package view.user.booking_user.outputs;

import java.util.ArrayList;
import model.admin.booking_admin.pojo.Train;

public class BookingOutputs {
	
	public void printAvailableTrains(ArrayList<Train>train_list){
		for(Train train : train_list) {
			System.out.println(train.getTrainDetails());
		}
	}
}
