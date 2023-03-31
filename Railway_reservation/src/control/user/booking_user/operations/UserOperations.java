package control.user.booking_user.operations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import control.admin.booking_admin.initializer.ModelInitializer;
import control.admin.booking_admin.initializer.ViewInitializer;
import control.main.Operatator;
import model.admin.booking_admin.pojo.Carriage;
import model.admin.booking_admin.pojo.Train;
import model.user.booking_user.operations.BookingModel;
import model.user.booking_user.operations.CancelModel;
import model.user.booking_user.pojo.AvailableTickets;
import model.user.booking_user.pojo.Passenger;
import model.user.booking_user.pojo.Ticket;
import model.user.booking_user.pojo.User;
import view.user.booking_user.inputs.BookingInputs;
import view.user.booking_user.outputs.BookingOutputs;
import view.user.booking_user.outputs.CancelOutputs;
import view.validation.NumberValidations;
import view.validation.TimeValidations;

public class UserOperations implements Operatator{
	
	NumberValidations nv=new NumberValidations();
	BookingModel bm=new BookingModel();
	BookingOutputs bo=new BookingOutputs();
	BookingInputs bi=new BookingInputs();
	
	private User user;
	
	public UserOperations(User user) {
		this.user=user;
	}
	@Override
	public void operate() {
		ArrayList<String> user_operations=new ArrayList<String>();
		user_operations.add("book");
		user_operations.add("filled_book");
		user_operations.add("cancel");
		user_operations.add("read_ticket");
		user_operations.add("exit");
		while(true) {
			int operator=nv.validateSelectionNumber(user_operations);
			if(operator==1) {
				book();
			}
			else if(operator==2) {
				filledBook();
			}
			else if(operator==3) {
				cancel();
			}
			else if(operator==4) {
				readTicket();
			}
			else if(operator==5) {
				break;
			}
		}
	}
	
	private void book() {
		HashMap<String,String> stop_details=bi.getStopDetails();
		String from_stop=stop_details.get("from_stop");
		String to_stop=stop_details.get("to_stop");
		TimeValidations tv=new TimeValidations();
		LocalDate date=tv.validateInputDate();
		ArrayList<Train>matched_trains=bm.getMatchedTrains(from_stop, to_stop, date);
		if(matched_trains.size()==0) {
			bo.printNotAvailabe();
		}
		else {
			Train selected_train=bo.selectTrainFromMatchedTrains(matched_trains);
			Carriage selected_carriage=bo.selectCarriage(selected_train);
			Ticket ticket=bm.getTicket(selected_train, selected_carriage,new PassengerTemplates().getPassengengerDetails_1());//bi.getPassengengerDetails());
			System.out.println(selected_train);
			System.out.println(ticket);
			user.getTickets().add(ticket);
		}
	}
	
	private void filledBook() {
		Ticket ticket_1=filledBook_1();
		Ticket ticket_2=filledBook_2();
		CancelModel cm=new CancelModel();
		cm.cancel(ticket_1.getPassengers_details(), ticket_1);
		ticket_2.getTrain().refresh();
		System.out.println(ticket_2.getTrain());
		System.out.println(ticket_2);
	}
	
	private Ticket filledBook_1() {
		String from_stop="stop_1";
		String to_stop="stop_7";
		LocalDate date=LocalDate.now();
		Train train=bm.getMatchedTrains(from_stop, to_stop, date).get(0);
		Carriage selected_carriage=train.getCarriages().get("sleeper");
		train.refresh();
		System.out.println("++++++++Before_Booking+++++++++++++++\n"+train);
		Ticket ticket =bm.getTicket(train, selected_carriage,new PassengerTemplates().getPassengengerDetails_1());//bi.getPassengengerDetails());		System.out.println(passengers_list);
		train.refresh();
		System.out.println("+_+_+_+_+After_Booking_+_+_+_+_+_+_+_\n"+train);
		System.out.println(ticket);
		return ticket;
	}
	
	private Ticket filledBook_2() {
		String from_stop="stop_1";
		String to_stop="stop_7";
		LocalDate date=LocalDate.now();
		Train train=bm.getMatchedTrains(from_stop, to_stop, date).get(0);
		Carriage selected_carriage=train.getCarriages().get("sleeper");
		train.refresh();
		System.out.println("+++++++Before_Booking+++++++++++++++\n"+train);
		Ticket ticket =bm.getTicket(train, selected_carriage,new PassengerTemplates().getPassengengerDetails_2());//bi.getPassengengerDetails());		System.out.println(passengers_list);
		train.refresh();
		System.out.println("+_+_+_+_+After_Booking_+_+_+_+_+_+_+_\n"+train);
		System.out.println(ticket);
		return ticket;
	}
	
	private void cancel(){
		CancelModel cm=new CancelModel();
		CancelOutputs co=new CancelOutputs();
		Ticket ticket=co.selectTicket(user.getTickets());
		ArrayList<Passenger> cancel_passengers=co.selectPassengers(ticket.getPassengers_details());
		cm.cancel(cancel_passengers, ticket);
		System.out.println(ticket);
	}
	
	private void readTicket() {
		CancelOutputs co=new CancelOutputs();
		Ticket ticket=co.selectTicket(user.getTickets());
		System.out.println(ticket);
	}
}
