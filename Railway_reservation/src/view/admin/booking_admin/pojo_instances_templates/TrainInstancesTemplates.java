package view.admin.booking_admin.pojo_instances_templates;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class TrainInstancesTemplates implements TemplateInterface{
	private static HashMap<String,HashMap<String,Object>> avaiable_train_instances= new HashMap<String,HashMap<String,Object>>();
	private static ArrayList<String> availabe_train_instances_keys=new  ArrayList<String>();
	private static ArrayList<String> available_train_names=new ArrayList<String>();
	private RouteInstancesTemplates rit=new RouteInstancesTemplates();
	private HashMap<String,HashMap<String,Object>> avaiable_carriage_instances=CarriageInstancesTemplates.getAvaiable_carriage_instances();
	
	
	@Override
	public void initiaze() {
		addNewTrainTemplate(getTrain_1_instances());
		addNewTrainTemplate(getTrain_2_instances());
		addNewTrainTemplate(getTrain_3_instances());
		addNewTrainTemplate(getFilledTrain_instances());
	}
	
	public void addNewTrainTemplate(HashMap<String,Object> train_instances) {
		avaiable_train_instances.put((int) train_instances.get("train_no")+"",train_instances);
		availabe_train_instances_keys.add((int) train_instances.get("train_no")+"");
		available_train_names.add((String)train_instances.get("train_name"));
	}
	
	private LocalDateTime getCurrentTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.now();
		dateTime.format(formatter);
		return dateTime;
	}
	
	private HashMap<String,Object> getTrain_1_instances(){
		
		HashMap<String,Object> train_instances=new HashMap<String,Object>();
		String train_name="train_1";
		int train_no=1234;
		ArrayList<HashMap<String,Object>>stop_instances_list = 
				rit.getAvailable_route_instances().get("route_1(ChennaiToCoimbatore)");
		double train_speed=90;
		String str_train_starting_time=getCurrentTime().plusHours(2)+"";
		LocalDateTime train_starting_time=LocalDateTime.parse(str_train_starting_time);

		
		ArrayList<HashMap<String,Object>> carriage_list=new ArrayList<HashMap<String,Object>>();
		HashMap<String,Object> s_carriage=avaiable_carriage_instances.get("sleeper");
		HashMap<String,Object> a3_carriage=avaiable_carriage_instances.get("3tyre_AC_sleeper");
		HashMap<String,Object> a2_carriage=avaiable_carriage_instances.get("2tyre_AC_sleeper");
		HashMap<String,Object> a1_carriage=avaiable_carriage_instances.get("1tyre_AC_sleeper");
		s_carriage.put("coach_count",3);
		a3_carriage.put("coach_count",2);
		a2_carriage.put("coach_count",2);
		a1_carriage.put("coach_count",2);
		carriage_list.add(s_carriage);
		carriage_list.add(a3_carriage);
		carriage_list.add(a2_carriage);
		carriage_list.add(a1_carriage);
	
		train_instances.put("train_name",  train_name);
		train_instances.put("train_no",  train_no);
		train_instances.put("train_speed",  train_speed);
		train_instances.put("train_starting_time",  train_starting_time);
		train_instances.put("stop_instances_list",  stop_instances_list);
		train_instances.put("carriage_list", carriage_list);
		
		return train_instances;
	}
	
	private HashMap<String,Object> getTrain_2_instances(){
		
		HashMap<String,Object> train_instances=new HashMap<String,Object>();
		String train_name="train_2";
		int train_no=1661;
		ArrayList<HashMap<String,Object>>stop_instances_list =
				rit.getAvailable_route_instances().get("route_2(TiruppurToTiruchi)");
		double train_speed=100;
		String str_train_starting_time=getCurrentTime().plusHours(1)+"";
		LocalDateTime train_starting_time=LocalDateTime.parse(str_train_starting_time);
		
		
		ArrayList<HashMap<String,Object>> carriage_list=new ArrayList<HashMap<String,Object>>();
		HashMap<String,Object> s_carriage=avaiable_carriage_instances.get("sleeper");
		HashMap<String,Object> a3_carriage=avaiable_carriage_instances.get("3tyre_AC_sleeper");
		HashMap<String,Object> a2_carriage=avaiable_carriage_instances.get("2tyre_AC_sleeper");
		HashMap<String,Object> a1_carriage=avaiable_carriage_instances.get("1tyre_AC_sleeper");
		s_carriage.put("coach_count",4);
		a3_carriage.put("coach_count",2);
		a2_carriage.put("coach_count",2);
		a1_carriage.put("coach_count",3);
		carriage_list.add(s_carriage);
		carriage_list.add(a3_carriage);
		carriage_list.add(a2_carriage);
		carriage_list.add(a1_carriage);
	
		train_instances.put("train_name",  train_name);
		train_instances.put("train_no",  train_no);
		train_instances.put("train_speed",  train_speed);
		train_instances.put("train_starting_time",  train_starting_time);
		train_instances.put("stop_instances_list",  stop_instances_list);
		train_instances.put("carriage_list", carriage_list);
		
		return train_instances;
	}
	
	private HashMap<String,Object> getTrain_3_instances(){
		
		HashMap<String,Object> train_instances=new HashMap<String,Object>();
		String train_name="train_3";
		int train_no=1678;
		ArrayList<HashMap<String,Object>>stop_instances_list =
				rit.getAvailable_route_instances().get("route_3(MaduraiToTirupathi)");
		double train_speed=110;
		String str_train_starting_time=getCurrentTime().plusDays(2)+"";
		LocalDateTime train_starting_time=LocalDateTime.parse(str_train_starting_time);
		
		ArrayList<HashMap<String,Object>> carriage_list=new ArrayList<HashMap<String,Object>>();
		HashMap<String,Object> s_carriage=avaiable_carriage_instances.get("sleeper");
		HashMap<String,Object> a3_carriage=avaiable_carriage_instances.get("3tyre_AC_sleeper");
		HashMap<String,Object> a2_carriage=avaiable_carriage_instances.get("2tyre_AC_sleeper");
		HashMap<String,Object> a1_carriage=avaiable_carriage_instances.get("1tyre_AC_sleeper");
		s_carriage.put("coach_count",4);
		a3_carriage.put("coach_count",4);
		a2_carriage.put("coach_count",3);
		a1_carriage.put("coach_count",2);
		carriage_list.add(s_carriage);
		carriage_list.add(a3_carriage);
		carriage_list.add(a2_carriage);
		carriage_list.add(a1_carriage);
	
		train_instances.put("train_name",  train_name);
		train_instances.put("train_no",  train_no);
		train_instances.put("train_speed",  train_speed);
		train_instances.put("train_starting_time",  train_starting_time);
		train_instances.put("stop_instances_list",  stop_instances_list);
		train_instances.put("carriage_list", carriage_list);
		
		return train_instances;
	}
private HashMap<String,Object> getFilledTrain_instances(){
		
		HashMap<String,Object> train_instances=new HashMap<String,Object>();
		String train_name="filled_train";
		int train_no=1677;
		ArrayList<HashMap<String,Object>>stop_instances_list =
				rit.getAvailable_route_instances().get("route_4(9StopRoute)");
		double train_speed=110;
		String str_train_starting_time=getCurrentTime().plusHours(2)+"";
		LocalDateTime train_starting_time=LocalDateTime.parse(str_train_starting_time);
		
		ArrayList<HashMap<String,Object>> carriage_list=new ArrayList<HashMap<String,Object>>();
		HashMap<String,Object> s_carriage=avaiable_carriage_instances.get("sleeper");
		s_carriage.put("coach_count",2);

		carriage_list.add(s_carriage);
	
		train_instances.put("train_name",  train_name);
		train_instances.put("train_no",  train_no);
		train_instances.put("train_speed",  train_speed);
		train_instances.put("train_starting_time",  train_starting_time);
		train_instances.put("stop_instances_list",  stop_instances_list);
		train_instances.put("carriage_list", carriage_list);
		
		return train_instances;
	}
	
	public  ArrayList<String> getAvailabe_train_instances_keys() {
		return availabe_train_instances_keys;
	}
	public HashMap<String, HashMap<String, Object>> getAvaiable_train_instances() {
		return TrainInstancesTemplates.avaiable_train_instances;
	}

	public ArrayList<String> getAvailable_train_names() {
		return available_train_names;
	}
}
