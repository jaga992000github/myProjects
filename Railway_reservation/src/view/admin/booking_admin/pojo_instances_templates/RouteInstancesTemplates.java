package view.admin.booking_admin.pojo_instances_templates;

import java.util.ArrayList;
import java.util.HashMap;

public class RouteInstancesTemplates implements TemplateInterface {
	private static HashMap<String,ArrayList<HashMap<String,Object>>> available_route_instances=new HashMap<String,ArrayList<HashMap<String,Object>>>();
	private static ArrayList<String> available_route_instances_keys=new ArrayList<String>();
	

	@Override
	public void initiaze() {
		addNewTemplate("route_1(ChennaiToCoimbatore)", getChennaiToCoimbatoreRoute());
		addNewTemplate("route_2(TiruppurToTiruchi)", getTiruppurToTiruchiRoute());
		addNewTemplate("route_3(MaduraiToTirupathi)", getMaduraiToTirupathiRoute());
	}
	
	
	public void addNewTemplate(String template_name,ArrayList<HashMap<String, Object>> template_instances) {
		available_route_instances.put(template_name, template_instances);
		available_route_instances_keys.add(template_name);
	}

	private ArrayList<HashMap<String,Object>> getChennaiToCoimbatoreRoute() {
		
		ArrayList<HashMap<String,Object>>stop_instances_list =new ArrayList<HashMap<String,Object>>();
		HashMap<String,Object> stop_instances1=new HashMap<String,Object>();
		stop_instances1.put("name","chennai");
		stop_instances1.put("km_from_start",0.0);
		stop_instances1.put("waiting_time",(long)5);
		stop_instances_list.add(stop_instances1);
		
		HashMap<String,Object> stop_instances2=new HashMap<String,Object>();
		stop_instances2.put("name","viluppuram");
		stop_instances2.put("km_from_start",5.0);
		stop_instances2.put("waiting_time",(long)5);
		stop_instances_list.add(stop_instances2);
		
		HashMap<String,Object> stop_instances3=new HashMap<String,Object>();
		stop_instances3.put("name","tiruppur");
		stop_instances3.put("km_from_start",14.0);
		stop_instances3.put("waiting_time",(long)5);
		stop_instances_list.add(stop_instances3);
		
		HashMap<String,Object> stop_instances4=new HashMap<String,Object>();
		stop_instances4.put("name","erode");
		stop_instances4.put("km_from_start",27.0);
		stop_instances4.put("waiting_time",(long)5);
		stop_instances_list.add(stop_instances4);
		
		HashMap<String,Object> stop_instances5=new HashMap<String,Object>();
		stop_instances5.put("name","coimbatore");
		stop_instances5.put("km_from_start",32.0);
		stop_instances5.put("waiting_time",(long)5);
		stop_instances_list.add(stop_instances5);
		
		return stop_instances_list;
	}
	
	private ArrayList<HashMap<String,Object>> getTiruppurToTiruchiRoute() {
		
		ArrayList<HashMap<String,Object>>stop_instances_list =new ArrayList<HashMap<String,Object>>();
		HashMap<String,Object> stop_instances1=new HashMap<String,Object>();
		stop_instances1.put("name","tiruppur");
		stop_instances1.put("km_from_start",0.0);
		stop_instances1.put("waiting_time",(long)15);
		stop_instances_list.add(stop_instances1);
		
		HashMap<String,Object> stop_instances2=new HashMap<String,Object>();
		stop_instances2.put("name","vellakkovil");
		stop_instances2.put("km_from_start",30.3);
		stop_instances2.put("waiting_time",(long)5);
		stop_instances_list.add(stop_instances2);
		
		HashMap<String,Object> stop_instances3=new HashMap<String,Object>();
		stop_instances3.put("name","karur");
		stop_instances3.put("km_from_start",43.7);
		stop_instances3.put("waiting_time",(long)7);
		stop_instances_list.add(stop_instances3);
		
		HashMap<String,Object> stop_instances4=new HashMap<String,Object>();
		stop_instances4.put("name","kullithalai");
		stop_instances4.put("km_from_start",72.9);
		stop_instances4.put("waiting_time",(long)5);
		stop_instances_list.add(stop_instances4);
		
		HashMap<String,Object> stop_instances5=new HashMap<String,Object>();
		stop_instances5.put("name","tiruchirapalli");
		stop_instances5.put("km_from_start",93.3);
		stop_instances5.put("waiting_time",(long)10);
		stop_instances_list.add(stop_instances5);

		
		return stop_instances_list;
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
	
	public static ArrayList<String> getAvailable_route_instances_keys() {
		return available_route_instances_keys;
	}

	public HashMap<String, ArrayList<HashMap<String, Object>>> getAvailable_route_instances() {
		return available_route_instances;
	}
}
