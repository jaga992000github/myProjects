package model.user.booking_user.operations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Queue;

import control.admin.booking_admin.initializer.ModelInitializer;
import control.admin.booking_admin.initializer.ViewInitializer;
import model.admin.booking_admin.business_logics.AgeOderTest;
import model.admin.booking_admin.pojo.AvailableTrains;
import model.admin.booking_admin.pojo.Carriage;
import model.admin.booking_admin.pojo.Coach;
import model.admin.booking_admin.pojo.Seat;
import model.admin.booking_admin.pojo.Stop;
import model.admin.booking_admin.pojo.Train;
import model.user.booking_user.pojo.Passenger;
import view.admin.booking_admin.outputs.TrainOutputs;

public class BookingModel {
	
	private String from_stop_name;
	private String to_stop_name;
	private Train train;
	private Carriage carriage;
	private  char prefered_birth;
	
	public synchronized ArrayList<Train> getMatchedTrains(String from_stop_name,String to_stop_name,LocalDate today) {
		this.from_stop_name=from_stop_name;
		this.to_stop_name=to_stop_name;
		AvailableTrains at=new AvailableTrains();
		ArrayList<Train> matched_trains =at.searchTrains(this.from_stop_name, this.to_stop_name, today);
		return matched_trains;
	}
	
	public synchronized ArrayList<Passenger> book(Train train,Carriage carriage,ArrayList<HashMap<String,Object>> passenger_instances_list) {
		this.train=train;
		this.carriage=carriage;
		ArrayList<Passenger> passengers_list =new ArrayList<Passenger>();
		Queue<Passenger> waiting_list=carriage.getWaiting_list();
		for(HashMap<String,Object> passenger_instances:passenger_instances_list) {
			Passenger passenger=new Passenger(passenger_instances);
			passengers_list.add(passenger);
		}
		Collections.sort(passengers_list, new PassengerAgeSort());
		for(Passenger passenger:passengers_list) {
			train.refresh();
			if(carriage.getAvailable_confirm_seats()>0) {
				this.prefered_birth=passenger.getPreferd_birth();
				Seat seat=getSeatForPassenger();
				passenger.setSeat(seat);
				passenger.setBooked_status("confirm");
				passenger.setClass_type(carriage.getClass_type());
				passenger.setCoach_id(" ");
			}
			else {
				waiting_list.add(passenger);
				int waiting_list_no=waiting_list.size();
				passenger.setBooked_status("waiting_list_no_"+waiting_list_no);
			}
		}
		return passengers_list;
	}
	
	private  Seat getSeatForPassenger() {
		Seat seat=getBirthMatchedSeat();
		Stop en_stop=train.getStop_map().get(this.from_stop_name);
		Stop vac_stop=train.getStop_map().get(this.to_stop_name);
		seat.setEngaging_stop(en_stop);
		seat.setVcant_stop(vac_stop);
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
						//String coach_id=coach.getCoach_id();
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
