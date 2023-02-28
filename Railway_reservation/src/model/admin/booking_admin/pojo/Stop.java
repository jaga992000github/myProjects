package model.admin.booking_admin.pojo;

import java.time.LocalTime;
import java.util.HashMap;

public class Stop {
	private String name;
	private int km_from_start;
	private long waiting_time;
	private LocalTime starting_time;
	private LocalTime reaching_time;
	private Stop previous_stop;
	private Stop next_stop;
	
	public Stop(HashMap<String,Object> stop_instances) {
		super();
		this.name = (String) stop_instances.get("name");
		this.km_from_start = (int) stop_instances.get("km_from_start");
		this.waiting_time = (long) stop_instances.get("waiting_time");
		if(previous_stop!=null) {
			this.starting_time=this.getPrevious_stop().reaching_time.plusMinutes(this.getPrevious_stop().getWaiting_time());
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKm_from_start() {
		return km_from_start;
	}
	public void setKm_from_start(int km_from_start) {
		this.km_from_start = km_from_start;
	}
	public long getWaiting_time() {
		return waiting_time;
	}
	public void setWaiting_time(long waiting_time) {
		this.waiting_time = waiting_time;
	}
	public LocalTime getStarting_time() {
		return starting_time;
	}
	public void setStarting_time(LocalTime starting_time) {
		this.starting_time = starting_time;
	}
	public LocalTime getReaching_time() {
		return reaching_time;
	}
	public void setReaching_time(LocalTime reaching_time) {
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
