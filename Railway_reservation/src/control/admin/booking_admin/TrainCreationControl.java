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
	
	private String from_stop_name;
	private String to_stop_name;
	
	public static void main(String[] args) {
		TrainCreationControl book=new TrainCreationControl();
		book.from_stop_name="chennai";
		book.to_stop_name="erode";
		System.out.println(book.from_stop_name+" to "+book.to_stop_name+"\n");
		Train train=book.getSelectedTrain();
		String class_type="sleeper";
		book.book(train, class_type);
		System.out.println("---------------------");
		book.from_stop_name="erode";
		book.to_stop_name="coimbatore";
		System.out.println(book.from_stop_name+" to "+book.to_stop_name+"\n");
		Train train2=book.getSelectedTrain();
		book.book(train2, class_type);
		System.out.println("---------------------");
		book.from_stop_name="chennai";
		book.to_stop_name="erode";
		System.out.println(book.from_stop_name+" to "+book.to_stop_name+"\n");
		Train train3=book.getSelectedTrain();
		book.book(train3, class_type);
		System.out.println("---------------------");
		book.from_stop_name="chennai";
		book.to_stop_name="coimbatore";
		System.out.println(book.from_stop_name+" to "+book.to_stop_name+"\n");
		Train train4=book.getSelectedTrain();
		book.book(train4, class_type);
	}
	
	public Train getSelectedTrain() {
		AvailableTrains at=new AvailableTrains();
		TrainOutputs to=new TrainOutputs();
		LocalDateTime today=LocalDateTime.now();
		ArrayList<Train> matched_trains =at.searchTrains(this.from_stop_name, this.to_stop_name, today);
		if(matched_trains.size()==0) {
			to.printNotAvailabe();
		}
		else {
			for(Train train:matched_trains) {
				//to.print(train);
			}
		}
		Train train=matched_trains.get(0);
		return train;
	}
	
	public void book(Train train,String class_type) {
		Carriage carriage=train.getCarriages().get(class_type);
		Coach coach=carriage.getCoach_list().get(0);
		
		
		train.refresh();
		System.out.println(carriage);
		Seat seat=coach.getAvailable_seats().peek();
		Stop en_stop=train.getStop_map().get(this.from_stop_name);
		Stop vac_stop=train.getStop_map().get(this.to_stop_name);
		seat.setEngaging_stop(en_stop);
		seat.setVcant_stop(vac_stop);
		train.refresh();
		System.out.println(carriage);
		System.out.println(seat.getEngaging_stop().getName());
		System.out.println(seat.getVcant_stop().getName());
	}

	public String getFrom_stop_name() {
		return from_stop_name;
	}

	public void setFrom_stop_name(String from_stop_name) {
		this.from_stop_name = from_stop_name;
	}

	public String getTo_stop_name() {
		return to_stop_name;
	}

	public void setTo_stop_name(String to_stop_name) {
		this.to_stop_name = to_stop_name;
	}
}
