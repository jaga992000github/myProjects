package model.user.booking_user.operations;

import java.util.ArrayList;

import model.admin.booking_admin.pojo.*;
import model.user.booking_user.pojo.Passenger;

public class Booking {
	public void book(Carriage carriage,ArrayList<Passenger> passengers_list) {
		ArrayList<Coach> coach_list=carriage.getCoach_list();
		if(carriage.getAvailable_confirm_seats()>0) {
		}
	}
	
	private Coach getCoachForFamily(ArrayList<Coach>coach_list,int passengers_count) {
		for(Coach coach:coach_list) {
			if(coach.getAvailable_confirm_seats()>=passengers_count) {
				return coach;
			}
		}
		return null;
	}
	
	private int getPassengersCountWithoutBaby(ArrayList<Passenger> passengers_list) {
		int passengers_count=0;
		for(Passenger passenger:passengers_list) {
			if(passenger.getAge()>5) {
				passengers_count++;
			}
		}
		return passengers_count;
	}
	
	private void setPreferedBirth() {
		
	}
	
	private boolean isSeatBookable(Seat seat,Stop from_stop) {
		if(seat.isBooked_status()&&seat.getLast_stop_km_from_start())
	}
	
}
