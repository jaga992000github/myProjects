package control.user.booking_user.operations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import control.admin.booking_admin.initializer.ModelInitializer;
import control.admin.booking_admin.initializer.ViewInitializer;
import model.admin.booking_admin.business_logics.AgeOderTest;
import model.admin.booking_admin.pojo.Carriage;
import model.admin.booking_admin.pojo.Seat;
import model.admin.booking_admin.pojo.Train;
import model.user.booking_user.operations.BookingModel;
import model.user.booking_user.pojo.Passenger;
import view.user.booking_user.inputs.BookingInputs;
import view.user.booking_user.outputs.BookingOutputs;
import view.validation.TimeValidations;

public class BookingControl {
	BookingModel bm=new BookingModel();
	BookingOutputs bo=new BookingOutputs();
	BookingInputs bi=new BookingInputs();
	static {
		new ViewInitializer();
		new ModelInitializer();
	}
	
	public static void main(String[] args) {
		BookingControl bc=new BookingControl();
		//bc.book();
		bc.filledBook();
		bc.filledBook();
	}
	
	public void book() {
		HashMap<String,String> stop_details=bi.getStopDetails();
		String from_stop=stop_details.get("from_stop");
		String to_stop=stop_details.get("to_stop");
		TimeValidations tv=new TimeValidations();
		LocalDate date=LocalDate.now();//tv.validateInputDate();
		ArrayList<Train>matched_trains=bm.getMatchedTrains(from_stop, to_stop, date);
		if(matched_trains.size()==0) {
			bo.printNotAvailabe();
		}
		else {
			Train selected_train=bo.selectTrainFromMatchedTrains(matched_trains);
			Carriage selected_carriage=bo.selectCarriage(selected_train);
			ArrayList<Passenger> passengers_list=bm.book(selected_train, selected_carriage,new AgeOderTest().getPassengengerDetails());//bi.getPassengengerDetails());
			System.out.println(passengers_list);
		}
	}
	
	public void filledBook() {
		String from_stop="stop_1";
		String to_stop="stop_7";
		LocalDate date=LocalDate.now();
		Train train=bm.getMatchedTrains(from_stop, to_stop, date).get(0);
		Carriage selected_carriage=train.getCarriages().get("sleeper");
		ArrayList<Passenger> passengers_list=bm.book(train, selected_carriage,new AgeOderTest().getPassengengerDetails());//bi.getPassengengerDetails());		System.out.println(passengers_list);
		//train.refresh();
		System.out.println(train);
	}
	
	
}
