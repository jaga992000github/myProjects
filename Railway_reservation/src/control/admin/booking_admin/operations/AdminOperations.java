package control.admin.booking_admin.operations;

import java.util.ArrayList;

import control.main.Operatator;
import model.admin.booking_admin.pojo.AvailableTrains;
import model.admin.booking_admin.pojo.Train;
import view.admin.booking_admin.inputs.TrainCreation;
import view.admin.booking_admin.outputs.TrainOutputs;
import view.validation.NumberValidations;

public class AdminOperations implements Operatator{
	
	NumberValidations nv=new NumberValidations();
	
	@Override
	public void operate() {
		ArrayList<String> admin_operations=new ArrayList<String>();
		admin_operations.add("createTrain");
		admin_operations.add("readTrain");
		admin_operations.add("deleateTrain");
		admin_operations.add("exit");
		while(true) {
			int operator=nv.validateSelectionNumber(admin_operations);
			if(operator==1) {
				createTrain();
			}
			else if(operator==2) {
				readTrain();
			}
			else if(operator==3) {
				deleateTrain();
			}
			else if(operator==4) {
				break;
			}
		}
	}
	
	private void createTrain() {
		TrainCreation tc=new TrainCreation();
		TrainOutputs to=new TrainOutputs();
		Train train=new Train(tc.createTrain());
		AvailableTrains.addTrain(train);
		to.print(train);
	}
	private void readTrain() {
		TrainOutputs to=new TrainOutputs();
		to.print(selectTrain());
	}
	private void deleateTrain() {
		AvailableTrains.deleateTrain(selectTrain());
	}
	private Train selectTrain() {
		ArrayList<String>available_train_no=AvailableTrains.getAvailable_train_no();
		String selected_train_no=nv.validateSelectionValue(available_train_no);
		Train train=AvailableTrains.getTrain_no_map().get(selected_train_no);
		train.refresh();
		return train;
	}
	
}
