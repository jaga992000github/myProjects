package control.admin.booking_admin.initializer;

import java.util.ArrayList;
import java.util.HashMap;

import model.admin.booking_admin.pojo.AvailableTrains;
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
	}
}
