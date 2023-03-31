package model.user.booking_user.operations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import model.admin.booking_admin.pojo.AvailableTrains;
import model.admin.booking_admin.pojo.Carriage;
import model.admin.booking_admin.pojo.Coach;
import model.admin.booking_admin.pojo.Seat;
import model.admin.booking_admin.pojo.Train;
import model.user.booking_user.pojo.AvailableTickets;
import model.user.booking_user.pojo.Passenger;
import model.user.booking_user.pojo.Ticket;

public class BookingModel {

	private Train train;
	private Carriage carriage;
	private  char prefered_birth;
	private int coach_id_index;
	
	public synchronized ArrayList<Train> getMatchedTrains(String from_stop_name,String to_stop_name,LocalDate today) {
		AvailableTrains at=new AvailableTrains();
		ArrayList<Train> matched_trains =at.searchTrains(from_stop_name,to_stop_name, today);
		return matched_trains;
	}
	
	public synchronized Ticket getTicket(Train train,Carriage carriage,ArrayList<HashMap<String,Object>> passenger_instances_list) {
		this.train=train;
		this.carriage=carriage;
		
		ArrayList<Passenger> passengers_details=book(passenger_instances_list);
		String class_type=carriage.getClass_type();
		
		HashMap<String,Object>ticket_instances=new HashMap<String,Object>();
		ticket_instances.put("train", train);
		ticket_instances.put("class_type", class_type);
		ticket_instances.put("passengers_details", passengers_details);
		
		Ticket ticket=new Ticket(ticket_instances);
		AvailableTickets.addTicket(ticket);
		return ticket;
	}
	
	private ArrayList<Passenger> book(ArrayList<HashMap<String,Object>> passenger_instances_list) {
		ArrayList<Passenger> passengers_list =new ArrayList<Passenger>();
		ArrayList<Passenger> waiting_list=carriage.getWaiting_list();
		for(HashMap<String,Object> passenger_instances:passenger_instances_list) {
			Passenger passenger=new Passenger(passenger_instances);
			passengers_list.add(passenger);
		}
		Collections.sort(passengers_list, new PassengerAgeSort());
		for(Passenger passenger:passengers_list) {
			if(passenger.getAge()>5) {
				train.refresh();
				if(carriage.getAvailable_confirm_seats()>0) {
					this.prefered_birth=passenger.getPreferd_birth();
					Seat seat=getSeatForPassenger();
					passenger.setSeat(seat);
					passenger.setBooked_status("confirm");
					//passenger.setClass_type(carriage.getClass_type());
					Coach coach=carriage.getCoach_list().get(coach_id_index);
					passenger.setCoach_id(coach.getCoach_id());
				}
				else {
					waiting_list.add(passenger);
					int waiting_list_no=waiting_list.size();
					passenger.setBooked_status("waiting_list");
					passenger.setWaiting_list_no(waiting_list_no);
				}
			}
			else {
				passenger.setBooked_status("confirm_child");
			}
		}
			
		return passengers_list;
	}
	
	private  Seat getSeatForPassenger() {
		Seat seat=getBirthMatchedSeat();
		seat.setBooked_asConfirm();
		seat.engageRoute();
		return seat;
	}
	
	
	private Seat getBirthMatchedSeat() {
		Seat seat=null;
		while(seat==null) {
			seat=searchSeatByBirth();
			prefered_birth=changeBirthPreference();
		}
		return seat;
	}
	private Seat searchSeatByBirth() {
		int  i=0;
		ArrayList<Coach> coach_list=carriage.getCoach_list();
		while(i<coach_list.size()) {
			Coach coach=coach_list.get(i);
			if(coach.getAvailable_confirm_seats_count()>0) {
				ArrayList<Seat> available_seats=coach.getAvailable_seats();
				for(Seat seat:available_seats) {
					if(isBirthMatch(seat)) {
						this.coach_id_index=i;
					return seat;}
				}
				break;
			}
			else {
				i++;
			}
		}
		return null;
	}

	private boolean isBirthMatch(Seat seat) {
		if(seat.getBirth_position()==prefered_birth) {
			return true;
		}
		return false;
	}
	
	private char changeBirthPreference() {
		HashMap<Character,Character> nextBirthMap=new HashMap<Character,Character>();
		nextBirthMap.put('L','M');
		nextBirthMap.put('M','U');
		nextBirthMap.put('U','L');
		return nextBirthMap.get(prefered_birth);
	}
	
	
	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	


	private class PassengerAgeSort implements Comparator<Passenger> {
		@Override
		public int compare(Passenger p1, Passenger p2) {
			if (p1.getAge() == p2.getAge())
				return 0;
			else if (p1.getAge() > p2.getAge())
				return -1;
			else
				return 1;
		}
	}
}
