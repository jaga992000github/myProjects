package view.admin.booking_admin.initialize;

import java.util.HashMap;

public class TrainsInitialization {

	public HashMap<String,Object> CoachTemplate(String coach_id){
 		int[] seat_ratio={1,3};
 		int total_col=seat_ratio[0]+seat_ratio[1];
 		int total_rows=4;
 		int total_seats=total_col*total_rows;
 		boolean sleeper_facility=true;
 		
 		HashMap<String,Object> coach_instances=new HashMap<String,Object>();
			coach_instances.put("seat_ratio", seat_ratio);
			coach_instances.put("total_col", total_col);
			coach_instances.put("total_rows", total_rows);
			coach_instances.put("total_seats", total_seats);
			coach_instances.put("coach_id", coach_id);
			coach_instances.put("sleeper_facility",sleeper_facility);
				
		return coach_instances;
	}
}
