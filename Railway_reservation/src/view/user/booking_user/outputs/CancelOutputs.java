package view.user.booking_user.outputs;

import java.util.ArrayList;

import model.user.booking_user.pojo.Passenger;
import model.user.booking_user.pojo.Ticket;
import view.validation.NumberValidations;

public class CancelOutputs {
	NumberValidations nv=new NumberValidations();
	
	public Ticket selectTicket(ArrayList<Ticket>ticket_list){
		ArrayList<String> tickets=new ArrayList<String>();
		for(Ticket ticket :ticket_list) {
			tickets.add(ticket.toString());
		}
		int index=nv.validateSelectionNumber(tickets);
		return ticket_list.get(index-1);
	}
	
	
	public ArrayList<Passenger> selectPassengers(ArrayList<Passenger>passenger_list){
		ArrayList<String> available_passengers=new ArrayList<String>();
		for(Passenger passenger :passenger_list) {
			available_passengers.add(passenger.toString());
		}
		available_passengers.add("\nExit");
		ArrayList<Passenger> selected_passengers=new ArrayList<Passenger>();
		while(true&&available_passengers.size()!=0) {
			int index=nv.validateSelectionNumber(available_passengers);
			if(index==available_passengers.size()&&selected_passengers.size()==0) {
				System.out.println("Please sealect a passenger");
			}
			else if(index==available_passengers.size()&&selected_passengers.size()>0) {
				break;
			}
			selected_passengers.add(passenger_list.get(index-1));
			available_passengers.remove(index-1);
		}
		
		return selected_passengers;
	}
}
