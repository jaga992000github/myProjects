package view.admin.booking_admin.outputs;

import model.admin.booking_admin.pojo.Train;

public class TrainOutputs {
	public void print(Train train) {
		System.out.println(train.getTrainDetails());
	}
}
