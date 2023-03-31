package view.admin.booking_admin.inputs;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import view.validation.DuplicateValidations;
import view.validation.NumberValidations;
import view.validation.TimeValidations;
	
public class GetDetails {
	Scanner scan=new Scanner(System.in);
	NumberValidations nv=new NumberValidations();
	DuplicateValidations dv=new DuplicateValidations();
	
	public HashMap<String,Object> getTrainDetails(){
		HashMap<String,Object> train_instances=new HashMap<String,Object>();
		TimeValidations tv=new TimeValidations();
		String train_name=dv.checkDuplicateTrainNames();
		int train_no=dv.checkDuplicateTrainNumbers();
		System.out.println("Enter Train Average speed in km/hr ");
		double train_speed=nv.validateDoubleInput();
		LocalDateTime train_starting_time=tv.validateInputDateTime();
	
		train_instances.put("train_name",  train_name);
		train_instances.put("train_no",  train_no);
		train_instances.put("train_speed",  train_speed);
		train_instances.put("train_starting_time",  train_starting_time);
		train_instances.put("stop_instances_list", null);
		train_instances.put("carriage_list", null);
		
		return train_instances;
	}
	
	public String getRouteName() {
		String route_name=dv.checkDuplicateRouteNames();
		return route_name;
	}
	
	public ArrayList<HashMap<String,Object>> getRouteDetails() {
		System.out.println("Enter Route");
		ArrayList<HashMap<String,Object>>stop_instances_list =new ArrayList<HashMap<String,Object>>();
		while(true) {
			System.out.println("want to add Stop");
			if(nv.validateBooleanInput()) {
				System.out.println("Enter Stop Name");
				String name=scan.next();
				System.out.println("Enter Stop KM from stat");
				double km_from_start=nv.validateDoubleInput();
				System.out.println("Enter waiting time");
				long wating_time=(long) nv.validateIntegerInput();
				
				HashMap<String,Object> stop_instances=new HashMap<String,Object>();
				stop_instances.put("name",name);
				stop_instances.put("km_from_start",km_from_start);
				stop_instances.put("waiting_time",(long)wating_time);
				stop_instances_list.add(stop_instances);
			}
			else {
				break;
			}	
		}
		return stop_instances_list;
	}
	
	public  HashMap<String,Object> getCarriageDetails(){
		HashMap<String,Object>carriage_instances=new HashMap<String,Object>();
	 		String class_type=dv.checkDuplicateClassTypes();
	 		System.out.println("Enter Basic fee");
	 		double basic_fee=nv.validateDoubleInput();
	    	System.out.println("Enter cost per KM");
	 		double cost_per_km=nv.validateDoubleInput();
	    	System.out.println("Enter  how many coach");
	 		int coach_count=nv.validateIntegerInput();
	 		String alpha_coach_id=dv.checkDuplicateCoachId();
	    	System.out.println("Is Carriage having Sleeper Facility");
	    	boolean is_sleeper=nv.validateBooleanInput();
	    	System.out.println("Is Carriage having AC Facility");
	    	boolean is_ac=nv.validateBooleanInput();
	 		
	    	carriage_instances.put("alpha_coach_id", alpha_coach_id);
	    	carriage_instances.put("class_type", class_type);
	    	carriage_instances.put("basic_fee", basic_fee);
	    	carriage_instances.put("cost_per_km", cost_per_km);
	    	carriage_instances.put("coach_count", coach_count);
	    	carriage_instances.put("is_sleeper", is_sleeper);
	    	carriage_instances.put("is_ac", is_ac);
	    	carriage_instances.put("coach_instances",null);	
		return carriage_instances;
	}
	
	public String getCoachName() {
		return dv.checkDuplicateCoachNames();
	}
	public HashMap<String,Object> getCoachDetails(){
	 		System.out.println("Enter Seat ratio");
	 		int[] seat_ratio=nv.validateSeatRatioInput();
	 		int total_col=0;
	 		System.out.println("Enter total row ");
	 		int total_rows=nv.validateIntegerInput();
	 		
	 		HashMap<String,Object> coach_instances=new HashMap<String,Object>();
 			coach_instances.put("seat_ratio", seat_ratio);
 			coach_instances.put("total_col", total_col);
 			coach_instances.put("total_rows", total_rows);
 		
		return coach_instances;
	}
}
