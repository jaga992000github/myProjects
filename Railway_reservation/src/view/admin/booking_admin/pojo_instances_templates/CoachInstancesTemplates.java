package view.admin.booking_admin.pojo_instances_templates;

import java.util.ArrayList;
import java.util.HashMap;

public class CoachInstancesTemplates implements TemplateInterface{
	
	private static HashMap<String,HashMap<String,Object>> avalable_coach_instances=new HashMap<String,HashMap<String,Object>>();
	private static ArrayList<String> available_coach_keys=new ArrayList<String>();	
	
	@Override
	public void initiaze() {
		addNewCoachTemplate("sitting(1:3)", get1IsTo3SittingCoachTemplate());
		addNewCoachTemplate("sitting(3:3)", get3IsTo3SittingCoachTemplate());
		addNewCoachTemplate("3_tyre_sleeper", get3_tyre_SleeperCoachTemplate());
		addNewCoachTemplate("2_tyre_sleeper", get2_tyre_SleeperCoachTemplate());
		addNewCoachTemplate("1_tyre_sleeper", get1_tyre_SleeperCoachTemplate());
		
	}
	
	public void addNewCoachTemplate(String template_name,HashMap<String,Object> coach_instances) {
		avalable_coach_instances.put(template_name, coach_instances);
		available_coach_keys.add(template_name);
	}
	
	private HashMap<String,Object> get3IsTo3SittingCoachTemplate(){
 		int[] seat_ratio={1,3};
 		int total_col=seat_ratio[0]+seat_ratio[1];
 		int total_rows=24;
 		
 		HashMap<String,Object> coach_instances=new HashMap<String,Object>();
			coach_instances.put("seat_ratio", seat_ratio);
			coach_instances.put("total_col", total_col);
			coach_instances.put("total_rows", total_rows);
				
		return coach_instances;
	}

	
	private HashMap<String,Object> get1IsTo3SittingCoachTemplate(){
 		int[] seat_ratio={1,3};
 		int total_col=seat_ratio[0]+seat_ratio[1];
 		int total_rows=18;
 		
 		HashMap<String,Object> coach_instances=new HashMap<String,Object>();
			coach_instances.put("seat_ratio", seat_ratio);
			coach_instances.put("total_col", total_col);
			coach_instances.put("total_rows", total_rows);
				
		return coach_instances;
	}
	
	private HashMap<String,Object> get3_tyre_SleeperCoachTemplate(){
 		int[] seat_ratio={1,3};
 		int total_col=seat_ratio[0]+seat_ratio[1];
 		int total_rows=4;//18
 		
 		HashMap<String,Object> coach_instances=new HashMap<String,Object>();
			coach_instances.put("seat_ratio", seat_ratio);
			coach_instances.put("total_col", total_col);
			coach_instances.put("total_rows", total_rows);
				
		return coach_instances;
	}
	
	private HashMap<String,Object> get2_tyre_SleeperCoachTemplate(){
 		int[] seat_ratio={1,2};
 		int total_col=seat_ratio[0]+seat_ratio[1];
 		int total_rows=16;
 		
 		HashMap<String,Object> coach_instances=new HashMap<String,Object>();
			coach_instances.put("seat_ratio", seat_ratio);
			coach_instances.put("total_col", total_col);
			coach_instances.put("total_rows", total_rows);
				
		return coach_instances;
	}
	
	private HashMap<String,Object> get1_tyre_SleeperCoachTemplate(){
 		int[] seat_ratio={1,1};
 		int total_col=seat_ratio[0]+seat_ratio[1];
 		int total_rows=12;
 		
 		HashMap<String,Object> coach_instances=new HashMap<String,Object>();
			coach_instances.put("seat_ratio", seat_ratio);
			coach_instances.put("total_col", total_col);
			coach_instances.put("total_rows", total_rows);
				
		return coach_instances;
	}
	
	public HashMap<String,HashMap<String,Object>> getAvalable_coach_instances() {
		return avalable_coach_instances;
	}
	
	public static ArrayList<String> getAvailable_coach_keys() {
		return available_coach_keys;
	}
	
}
