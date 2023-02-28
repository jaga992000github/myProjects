package control.admin.booking_admin;
import java.util.HashMap;
import model.admin.booking_admin.pojo.Train;
import view.admin.booking_admin.inputs.TrainInputs;
import view.admin.booking_admin.outputs.TrainOutputs;

public class TrainCreationControl {
	public static void main(String[] args) {
		TrainInputs ti=new TrainInputs();
		TrainOutputs to=new TrainOutputs();
		
		HashMap<String,Object> train_instances= ti.getTrainDetails();
		Train train=new Train(train_instances);
		to.print(train);
	}
}
