package model.admin.booking_admin.pojo;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;

public class Stop {
	private String name;
	private double km_from_start;
	private long waiting_time;
	private LocalDateTime starting_time;
	private LocalDateTime reaching_time;
	private Stop previous_stop;
	private Stop next_stop;
	
	public Stop(HashMap<String,Object> stop_instances) {
		super();
		this.name = (String) stop_instances.get("name");
		this.km_from_start = (double) stop_instances.get("km_from_start");
		this.waiting_time = (long) stop_instances.get("waiting_time");
	}
	
	public void setTiming(double train_speed) {
		if(previous_stop!=null) {
			this.reaching_time=this.getPrevious_stop().starting_time.plusSeconds(calculateTravelSeconds(train_speed));
			this.starting_time=this.reaching_time.plusMinutes(this.waiting_time);
		}
	}
	
	public String toString() {
		String str="\n-name:"+this.name
				+ "\n-km_from_start:"+this.km_from_start
				+"\n-waiting_time:"+this.waiting_time
				+"\n-reaching_time:"+this.reaching_time
				+"\n-starting_time:"+this.starting_time;
		  if(this.previous_stop!=null&&this.next_stop!=null) {
			  str+="\n-prev_top_name:"+this.previous_stop.getName()
			  +"\n-next_stop_name:"+this.next_stop.getName()+"\n";
		  }
		  else if(this.previous_stop==null&&this.next_stop!=null) {
			  str+="\n-prev_top_name:"+"null"
			  +"\n-next_stop_name:"+this.next_stop.getName()+"\n";
		  }
		  else if(this.previous_stop!=null&&this.next_stop==null) {
			  str+="\n-prev_top_name:"+this.previous_stop.getName()
			  +"\n-next_stop_name:"+"null"+"\n";
		  }
		return str;
	}
	private double calcuateKmPerMinute(double train_speed) {
		double km_per_min=(train_speed/60);
		return km_per_min;
	}
	
	private long calculateTravelSeconds(double train_speed){
		double accurate_secs;
		double current_stop_km=this.km_from_start;
		double previous_stop_km=0;
		if(this.getPrevious_stop()!=null) {
			previous_stop_km=this.getPrevious_stop().getKm_from_start();
		}
		double km_between_stops=current_stop_km-previous_stop_km;
		accurate_secs=calcuateKmPerMinute(train_speed)*km_between_stops;
		long secs=Math.round(accurate_secs*60);
		//System.out.println(accurate_secs);
		//System.out.println(secs);
		return secs;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getKm_from_start() {
		return km_from_start;
	}
	public void setKm_from_start(double km_from_start) {
		this.km_from_start = km_from_start;
	}
	public long getWaiting_time() {
		return waiting_time;
	}
	public void setWaiting_time(long waiting_time) {
		this.waiting_time = waiting_time;
	}
	public LocalDateTime getStarting_time() {
		return starting_time;
	}
	public void setStarting_time(LocalDateTime starting_time) {
		this.starting_time = starting_time;
	}
	public LocalDateTime getReaching_time() {
		return reaching_time;
	}
	public void setReaching_time(LocalDateTime reaching_time) {
		this.reaching_time = reaching_time;
	}
	public Stop getPrevious_stop() {
		return previous_stop;
	}
	public void setPrevious_stop(Stop previous_stop) {
		this.previous_stop = previous_stop;
	}
	public Stop getNext_stop() {
		return next_stop;
	}
	public void setNext_stop(Stop next_stop) {
		this.next_stop = next_stop;
	}
}
