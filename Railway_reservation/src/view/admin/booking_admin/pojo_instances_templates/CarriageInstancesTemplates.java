package view.admin.booking_admin.pojo_instances_templates;

import java.util.ArrayList;
import java.util.HashMap;

public class CarriageInstancesTemplates implements TemplateInterface {
	
	private static HashMap<String,HashMap<String,Object>> avaiable_carriage_instances= new HashMap<String,HashMap<String,Object>>();
	private static ArrayList<String> available_coach_id_list=new ArrayList<String>();
	private static ArrayList<String> available_class_name_keys=new ArrayList<String>();
	
	CoachInstancesTemplates chit=new CoachInstancesTemplates();
	HashMap<String,HashMap<String,Object>> avalable_coach_instances=chit.getAvalable_coach_instances();
	
	@Override
	public void initiaze() {
		addNewCarriageTemplate(get1IsTo3SitterCarriageTemplate());
		addNewCarriageTemplate(get3IsTo3SitterCarriageTemplate());
		addNewCarriageTemplate(get3IsTo3ACSitterCarriageTemplate());
		
		addNewCarriageTemplate(getSleeperCarriageTemplate());
		addNewCarriageTemplate(get3AcSleeperCarriageTemplate());
		addNewCarriageTemplate(get2AcSleeperCarriageTemplate());
		addNewCarriageTemplate(get1AcSleeperCarriageTemplate());
	}
	
	public void addNewCarriageTemplate(HashMap<String,Object> carriage_instances) {
		avaiable_carriage_instances.put((String) carriage_instances.get("class_type"), carriage_instances);
		available_coach_id_list.add((String)carriage_instances.get("coach_id"));
		available_class_name_keys.add((String) carriage_instances.get("class_type"));
	}
	private HashMap<String,Object> get1IsTo3SitterCarriageTemplate(){
		HashMap<String,Object>carriage_instances=new HashMap<String,Object>();
	 		String class_type="sitter(1:3)";
	 		String alpha_coach_id="B";
	 		double basic_fee=50.5;
	 		double cost_per_km=0.7;
	 		HashMap<String,Object> coach_instances=avalable_coach_instances.get("sitting(1:3)");
	 		boolean is_ac=false;
	 		boolean is_sleeper=false;
	 		
	 		carriage_instances.put("is_sleeper", is_sleeper);
	 		carriage_instances.put("is_ac", is_ac);
	 		carriage_instances.put("alpha_coach_id", alpha_coach_id);
	    	carriage_instances.put("class_type", class_type);
	    	carriage_instances.put("basic_fee", basic_fee);
	    	carriage_instances.put("cost_per_km", cost_per_km);
	    	carriage_instances.put("coach_count", null);
	    	carriage_instances.put("coach_instances",coach_instances);	
		return carriage_instances;
	}
	private HashMap<String,Object> get3IsTo3ACSitterCarriageTemplate(){
		HashMap<String,Object>carriage_instances=new HashMap<String,Object>();
	 		String class_type="ACsitter(3:3)";
	 		String alpha_coach_id="C";
	 		double basic_fee=65.5;
	 		double cost_per_km=0.9;
	 		HashMap<String,Object> coach_instances=avalable_coach_instances.get("sitting(3:3)");
	 		boolean is_ac=true;
	 		boolean is_sleeper=false;
	 		
	 		carriage_instances.put("is_sleeper", is_sleeper);
	 		carriage_instances.put("is_ac", is_ac);
	 		carriage_instances.put("alpha_coach_id", alpha_coach_id);
	    	carriage_instances.put("class_type", class_type);
	    	carriage_instances.put("basic_fee", basic_fee);
	    	carriage_instances.put("cost_per_km", cost_per_km);
	    	carriage_instances.put("coach_count", null);
	    	carriage_instances.put("coach_instances",coach_instances);	
		return carriage_instances;
	}
	
	private HashMap<String,Object> get3IsTo3SitterCarriageTemplate(){
		HashMap<String,Object>carriage_instances=new HashMap<String,Object>();
	 		String class_type="sitter(3:3)";
	 		String alpha_coach_id="D";
	 		double basic_fee=45.5;
	 		double cost_per_km=0.7;
	 		HashMap<String,Object> coach_instances=avalable_coach_instances.get("sitting(3:3)");
	 		boolean is_ac=false;
	 		boolean is_sleeper=false;
	 		
	 		carriage_instances.put("is_sleeper", is_sleeper);
	 		carriage_instances.put("is_ac", is_ac);
	 		carriage_instances.put("alpha_coach_id", alpha_coach_id);
	    	carriage_instances.put("class_type", class_type);
	    	carriage_instances.put("basic_fee", basic_fee);
	    	carriage_instances.put("cost_per_km", cost_per_km);
	    	carriage_instances.put("coach_count", null);
	    	carriage_instances.put("coach_instances",coach_instances);	
		return carriage_instances;
	}
	
	private HashMap<String,Object> getSleeperCarriageTemplate(){
		HashMap<String,Object>carriage_instances=new HashMap<String,Object>();
	 		String class_type="sleeper";
	 		String alpha_coach_id="S";
	 		double basic_fee=70.9;
	 		double cost_per_km=1.1;
	 		HashMap<String,Object> coach_instances=avalable_coach_instances.get("3_tyre_sleeper");
	 		boolean is_ac=false;
	 		boolean is_sleeper=true;
	 		
	 		carriage_instances.put("is_sleeper", is_sleeper);
	 		carriage_instances.put("is_ac", is_ac);
	 		carriage_instances.put("alpha_coach_id", alpha_coach_id);
	    	carriage_instances.put("class_type", class_type);
	    	carriage_instances.put("basic_fee", basic_fee);
	    	carriage_instances.put("cost_per_km", cost_per_km);
	    	carriage_instances.put("coach_count", null);
	    	carriage_instances.put("coach_instances",coach_instances);	
		return carriage_instances;
	}
	
	private HashMap<String,Object> get3AcSleeperCarriageTemplate(){
		HashMap<String,Object>carriage_instances=new HashMap<String,Object>();
	 		String class_type="3tyre_AC_sleeper";
	 		String alpha_coach_id="3A";
	 		double basic_fee=80.6;
	 		double cost_per_km=1.3;
	 		HashMap<String,Object> coach_instances=avalable_coach_instances.get("3_tyre_sleeper");
	 		boolean is_ac=true;
	 		boolean is_sleeper=true;
	 		
	 		carriage_instances.put("is_sleeper", is_sleeper);
	 		carriage_instances.put("is_ac", is_ac);
	 		carriage_instances.put("alpha_coach_id", alpha_coach_id);
	    	carriage_instances.put("class_type", class_type);
	    	carriage_instances.put("basic_fee", basic_fee);
	    	carriage_instances.put("cost_per_km", cost_per_km);
	    	carriage_instances.put("coach_count", null);
	    	carriage_instances.put("coach_instances",coach_instances);	
		return carriage_instances;
	}
	
	private HashMap<String,Object> get2AcSleeperCarriageTemplate(){
		HashMap<String,Object>carriage_instances=new HashMap<String,Object>();
	 		String class_type="2tyre_AC_sleeper";
	 		String alpha_coach_id="2A";
	 		double basic_fee=90.9;
	 		double cost_per_km=01.4;
	 		HashMap<String,Object> coach_instances=avalable_coach_instances.get("2_tyre_sleeper");
	 		boolean is_ac=true;
	 		boolean is_sleeper=true;
	 		
	 		carriage_instances.put("is_sleeper", is_sleeper);
	 		carriage_instances.put("is_ac", is_ac);
	 		carriage_instances.put("alpha_coach_id", alpha_coach_id);
	    	carriage_instances.put("class_type", class_type);
	    	carriage_instances.put("basic_fee", basic_fee);
	    	carriage_instances.put("cost_per_km", cost_per_km);
	    	carriage_instances.put("coach_count", null);
	    	carriage_instances.put("coach_instances",coach_instances);	
		return carriage_instances;
	}
	
	private HashMap<String,Object> get1AcSleeperCarriageTemplate(){
		HashMap<String,Object>carriage_instances=new HashMap<String,Object>();
	 		String class_type="1tyre_AC_sleeper";
	 		String alpha_coach_id="1A";
	 		double basic_fee=101.0;
	 		double cost_per_km=1.5;
	 		HashMap<String,Object> coach_instances=avalable_coach_instances.get("1_tyre_sleeper");
	 		boolean is_ac=true;
	 		boolean is_sleeper=true;
	 		
	 		carriage_instances.put("is_sleeper", is_sleeper);
	 		carriage_instances.put("is_ac", is_ac);
	 		carriage_instances.put("alpha_coach_id", alpha_coach_id);
	    	carriage_instances.put("class_type", class_type);
	    	carriage_instances.put("basic_fee", basic_fee);
	    	carriage_instances.put("cost_per_km", cost_per_km);
	    	carriage_instances.put("coach_count", null);
	    	carriage_instances.put("coach_instances",coach_instances);	
		return carriage_instances;
	}
	
	public static HashMap<String,HashMap<String,Object>> getAvaiable_carriage_instances() {
		return avaiable_carriage_instances;
	}
	public static ArrayList<String> getAvailable_coach_ids() {
		return available_coach_id_list;
	}
	public static ArrayList<String> getAvailable_class_name_keys() {
		ArrayList<String> temp=new ArrayList<String>();
		for(int i=available_class_name_keys.size()-1;i>=0;i--) {
			temp.add(available_class_name_keys.get(i));
		}
		return temp;
	}
}
