package model.admin.booking_admin.pojo;

import java.time.LocalTime;
import java.util.*;


public class Train {
	private String train_name;
	private int train_no;
	private float train_speed;
	private LinkedList<Stop> train_route;
	private HashMap<String,Carriage> carriages;
	private LocalTime train_starting_time;
	private LocalTime train_reaching_time;
	
	public String toString () {
		String str="";
		str=getTrainDetails();
			for(Map.Entry<String,Carriage>carriage:this.carriages.entrySet()) {
				str+=carriage.getValue().toString();
			}
			
		return str;
	}
	public String getTrainDetails() {
		String str="";
	    str="\n-Train Name:"+this.train_name
				+ "\n-Train No:"+this.train_no
				+ "\n-Train route:"
				+ "\n-From "+this.train_route.getFirst().getName()+" To "+this.train_route.getLast().getName()
				+"\n-Starting at-"+this.train_starting_time.toString()
				+"\n-Reach at-"+this.train_reaching_time.toString()
				+ "\n";
	    return str;
	}
	
	public Train (HashMap<String,Object> train_instances) {
		this.train_name=(String) train_instances.get("train_name");
		this.train_no=(int) train_instances.get("train_no");
		this.train_speed=(float) train_instances.get("train_speed");
		ArrayList<HashMap<String,Object>>stop_instances_list=(ArrayList<HashMap<String, Object>>) train_instances.get("stop_instances_list");
		this.train_starting_time=(LocalTime) train_instances.get("train_starting_time");
		this.train_route=bindStops(stop_instances_list);
		this.train_reaching_time=train_route.getLast().getReaching_time();
		this.carriages=bindCarriage((ArrayList<HashMap<String, Object>>) train_instances.get("carriage_list"));
	}
	
	private LinkedList<Stop> bindStops(ArrayList<HashMap<String,Object>>stop_instances_list){
		LinkedList<Stop> train_route=new LinkedList<Stop>();
		int index=0;
		for(HashMap<String,Object> stop_instances:stop_instances_list) {
			Stop stop =new Stop(stop_instances);
			if(index==0) {
				stop.setPrevious_stop(null);
				stop.setStarting_time(this.train_starting_time);
				stop.setReaching_time(this.train_starting_time.minusMinutes(stop.getWaiting_time()));
				Stop next_stop=new Stop(stop_instances_list.get(index+1));
				stop.setNext_stop(next_stop);
			}
			else {
				stop.setPrevious_stop(train_route.get(index-1));
				
			}
			if(index==stop_instances_list.size()-1) {
				stop.setNext_stop(null);
			}
			if (index>0) {
				//Stop next_stop=new Stop(stop_instances_list.get(index+1));
				//stop.setNext_stop(next_stop);
				stop.getPrevious_stop().setNext_stop(stop);
			}
			stop.setTiming(train_speed);
			//System.out.println(stop);
			train_route.add(stop);
			index++;
		}
		System.out.println(train_route);
		return train_route;
	}
	
	
	
	private HashMap<String,Carriage> bindCarriage(ArrayList<HashMap<String,Object>>carriage_list){
		HashMap<String,Carriage> carriages=new HashMap<String,Carriage>();
		for(HashMap<String,Object> carriage_instances:carriage_list) {
			HashMap<String,Object>coach_instances=(HashMap<String, Object>) carriage_instances.get("coach_instances");
			Carriage carriage=new Carriage(carriage_instances);
			carriages.put(carriage.getClass_type(), carriage);
		}
		return carriages;
	}
	

	
	public LocalTime getTrain_starting_time() {
		return train_starting_time;
	}
	public void setTrain_starting_time(LocalTime train_starting_time) {
		this.train_starting_time = train_starting_time;
	}
	
	public LocalTime getTrain_reaching_time() {
		return train_reaching_time;
	}
	public void setTrain_reaching_time(LocalTime train_reaching_time) {
		this.train_reaching_time = train_reaching_time;
	}
	public HashMap<String, Carriage> getCarriages() {
		return carriages;
	}

	public void setCarriages(HashMap<String, Carriage> carriages) {
		this.carriages = carriages;
	}

	public String getTrain_name() {
		return train_name;
	}
	public void setTrain_name(String train_name) {
		this.train_name = train_name;
	}
	public int getTrain_no() {
		return train_no;
	}
	public void setTrain_no(int train_no) {
		this.train_no = train_no;
	}
	public float getTrain_speed() {
		return train_speed;
	}

	public void setTrain_speed(float train_speed) {
		this.train_speed = train_speed;
	}
	public LinkedList<Stop> getTrain_route() {
		return train_route;
	}
	public void setTrain_route(LinkedList<Stop> train_route) {
		this.train_route = train_route;
	}

}
