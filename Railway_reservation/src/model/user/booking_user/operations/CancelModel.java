package model.user.booking_user.operations;

import java.util.ArrayList;

import model.admin.booking_admin.pojo.Carriage;
import model.admin.booking_admin.pojo.Seat;
import model.admin.booking_admin.pojo.Stop;
import model.user.booking_user.pojo.AvailableTickets;
import model.user.booking_user.pojo.Passenger;
import model.user.booking_user.pojo.Ticket;

public class CancelModel {
	
	public void cancel(ArrayList<Passenger> passenger_list,Ticket ticket) {
		Stop from_stop=ticket.getFrom_stop();
		Stop to_stop=ticket.getTo_stop();
		Carriage carriage=ticket.getTrain().getCarriages().get(ticket.getClass_type());
		for(Passenger passenger:passenger_list) {
			Seat seat=passenger.getSeat();
			seat.setFrom_stop(from_stop);
			seat.setTo_stop(to_stop);
			if(seat!=null) {
				String coach_id=passenger.getCoach_id();
				seat.setFrom_stop(from_stop);
				seat.setTo_stop(to_stop);
				seat.vacantRoute();
				ConfirmCancel(carriage,seat,coach_id);
			}
			else {
				waitingListCancel(carriage, passenger);
			}
			passenger.setBooked_status("cancel");
			refreshWaitingList(carriage);
		}
	}
	
	private void ConfirmCancel(Carriage carriage, Seat seat,String coach_id) {
		ArrayList<Passenger> waiting_list=carriage.getWaiting_list();
		if(!(waiting_list==null)||waiting_list.size()>0) {
			Passenger passenger_1=bookWaitingListPassenger(waiting_list, seat);
			if(!(passenger_1==null)) {
				seat.setBooked_asConfirm();
				passenger_1.setBooked_status("confirm");
				passenger_1.setCoach_id(coach_id);
				if(seat.isIs_RAC_replacable()&&waiting_list.size()>0) {
					Passenger passenger_2=bookWaitingListPassenger(waiting_list, seat);
					if(!(passenger_2==null)) {
						seat.setBooked_asRAC();
						passenger_1.setBooked_status("RAC");
						passenger_2.setBooked_status("RAC");
						passenger_2.setCoach_id(coach_id);
					}
				}
			}
		}
	}
	private Passenger bookWaitingListPassenger(ArrayList<Passenger> waiting_list,Seat seat) {
		for(Passenger passenger:waiting_list) {
			Ticket ticket=AvailableTickets.getTicket(passenger.getPNR_NO());
			Stop from_stop=ticket.getFrom_stop();
			Stop to_stop=ticket.getTo_stop();
			if(seat.getFrom_stop().equals(from_stop)
					&&seat.getTo_stop().equals(to_stop)) {
				seat.engageRoute();
				passenger.setSeat(seat);
				waiting_list.remove(passenger);
				return passenger;
				}
			}
		return null;
		}
	
	private void refreshWaitingList(Carriage carriage) {
		ArrayList<Passenger> waiting_list=carriage.getWaiting_list();
		for(Passenger passenger:waiting_list){
			passenger.setWaiting_list_no(carriage.getCurrentWaitingListNO(passenger));
		}
	}
	
	private void waitingListCancel(Carriage carriage,Passenger passenger) {
		ArrayList<Passenger> waiting_list=carriage.getWaiting_list();
		waiting_list.remove(passenger);
	}
}
