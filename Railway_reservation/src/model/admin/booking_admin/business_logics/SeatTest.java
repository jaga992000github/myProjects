package model.admin.booking_admin.business_logics;

import java.util.ArrayList;
import java.util.HashMap;

import model.admin.booking_admin.pojo.Seat;
import model.admin.booking_admin.pojo.Stop;

public class SeatTest {
	 ArrayList<Stop> route =new  ArrayList<Stop>();
	 HashMap<String,Stop> rtMap=new HashMap<String,Stop>();
	 
	void init() {
		ArrayList<HashMap<String,Object>> route_instances=getMaduraiToTirupathiRoute();
		for(HashMap<String,Object> ins:route_instances) {
			Stop stop=new Stop(ins);
			route.add(stop);
			rtMap.put(stop.getName(), stop);
		}
	}
	Seat newSeat() {
		Seat seat=new Seat();
		
		seat.setBirth_position('M');
		seat.setSeat_position('M');
		
		seat.setIs_booked(false);
		seat.setis_RAC_replacable(false);
		seat.setSeat_no(1);
		seat.setBooked_as("confirm");
		
		seat.setEngaging_stop(rtMap.get("velore"));
		seat.setVcant_stop(rtMap.get("chitore"));
		return seat;
	}
	void printSeat(Seat seat) {
		String str="";
		if(seat.is_booked()){
			str+="[1]";
		}
		else {
			str+="1";
		}
		System.out.println(str);
	}

	
	private boolean checkSeatAvailabilityInRoute(Stop from_stop,Stop to_stop,Seat seat) {
		double from_stop_km=from_stop.getKm_from_start();
		double to_stop_km=to_stop.getKm_from_start();
		double eng_stop_km=seat.getEngaging_stop().getKm_from_start();
		double vac_stop_km=seat.getVcant_stop().getKm_from_start();
		if(from_stop_km<eng_stop_km
				&&to_stop_km<=eng_stop_km) {
			return true;
		}
		else if(from_stop_km>=vac_stop_km
				&&to_stop_km>vac_stop_km) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		SeatTest st=new SeatTest();
		st.init();
		Seat seat=st.newSeat();
		Stop from_stop=st.rtMap.get("katpadi");
		Stop to_stop=st.rtMap.get("tirupati");
		seat.setIs_booked(!st.checkSeatAvailabilityInRoute(from_stop,to_stop,seat));
		//System.out.println(seat.is_booked());
		st.printSeat(seat);	
	}
	
	
private ArrayList<HashMap<String,Object>> getMaduraiToTirupathiRoute() {
		
		ArrayList<HashMap<String,Object>>stop_instances_list =new ArrayList<HashMap<String,Object>>();
		HashMap<String,Object> stop_instances1=new HashMap<String,Object>();
		stop_instances1.put("name","madurai");
		stop_instances1.put("km_from_start",0.0);
		stop_instances1.put("waiting_time",(long)15);
		stop_instances_list.add(stop_instances1);
		
		HashMap<String,Object> stop_instances2=new HashMap<String,Object>();
		stop_instances2.put("name","tiruchirapalli");
		stop_instances2.put("km_from_start",30.3);
		stop_instances2.put("waiting_time",(long)5);
		stop_instances_list.add(stop_instances2);
		
		HashMap<String,Object> stop_instances3=new HashMap<String,Object>();
		stop_instances3.put("name","velore");
		stop_instances3.put("km_from_start",43.7);
		stop_instances3.put("waiting_time",(long)7);
		stop_instances_list.add(stop_instances3);
		
		HashMap<String,Object> stop_instances4=new HashMap<String,Object>();
		stop_instances4.put("name","katpadi");
		stop_instances4.put("km_from_start",72.9);
		stop_instances4.put("waiting_time",(long)5);
		stop_instances_list.add(stop_instances4);
		
		HashMap<String,Object> stop_instances5=new HashMap<String,Object>();
		stop_instances5.put("name","chitore");
		stop_instances5.put("km_from_start",88.3);
		stop_instances5.put("waiting_time",(long)10);
		stop_instances_list.add(stop_instances5);
		
		HashMap<String,Object> stop_instances6=new HashMap<String,Object>();
		stop_instances6.put("name","andhra");
		stop_instances6.put("km_from_start",98.3);
		stop_instances6.put("waiting_time",(long)10);
		stop_instances_list.add(stop_instances6);
		
		HashMap<String,Object> stop_instances7=new HashMap<String,Object>();
		stop_instances7.put("name","tirupati");
		stop_instances7.put("km_from_start",106.4);
		stop_instances7.put("waiting_time",(long)10);
		stop_instances_list.add(stop_instances7);

		return stop_instances_list;
	}
}
