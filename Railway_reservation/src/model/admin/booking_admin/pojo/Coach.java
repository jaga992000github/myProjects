package model.admin.booking_admin.pojo;
import java.util.*;

public class Coach {
	private String coach_id;
	private int total_seats;
	private int total_rows;
	private int total_col;
	private boolean is_sleeper;
	private int[] seat_ratio;//to split seats
	private HashMap<HashMap<String,Object>,Seat> coach_seats;//to map seats by row,col, and seat no
	private Stop from_stop;
	private Stop to_stop;
	private Queue<Seat> available_seats;
	private int available_confirm_seats_count;
	
	public Coach() {
		
	}
	public Coach (HashMap<String,Object> coach_instances) {
		this.coach_id=(String) coach_instances.get("coach_id");
		this.total_rows=(int) coach_instances.get("total_rows");
		this.total_col=(int) coach_instances.get("total_col");
		this.total_seats=total_col*total_rows;
		this.seat_ratio=(int[]) coach_instances.get("seat_ratio");
		this.is_sleeper=(boolean)coach_instances.get("is_sleeper");
		this.coach_seats= bindSeats();
		this.available_seats=refresh();
	}
	private HashMap<HashMap<String, Object>, Seat> bindSeats(){
		int row=0,col=0;
		Seat seat =new Seat();
		char[] seat_pos= {'W','M','A'};
		HashMap<Character,Character> birth_allocation=new HashMap<Character,Character>();
		birth_allocation.put('W','L');
		birth_allocation.put('M','M');
		birth_allocation.put('A','U');
		birth_allocation.put('2','U');//second single side
		HashMap<HashMap<String, Object>, Seat> coach_seats=new HashMap<HashMap<String, Object>, Seat>();
		int seat_no=1;
		for(int i=1;i<=this.total_rows;i++) {
			row=i;
			int seat_ratio_index=0;//to split according to ratio
			int second_side_seat_count=seat_ratio[1];
//-----------------//System.out.println();//0000000000000000000000000000000000000000000000000000000
			for(int j=1;j<=this.total_col;j++) {
				HashMap<String, Object> seat_instances=new HashMap<String, Object>();
				col=j;
				seat_instances.put("seat_no", seat_no);
				seat_instances.put("is_RAC_replacable", false);
				if(seat_ratio_index==0) {
					seat_instances.put("seat_position",(char)seat_pos[j-1]);
					if(this.is_sleeper&&this.seat_ratio[seat_ratio_index]==1) {//to put second window upper in rac (sinngle side)
						if(i%2==0) {
							seat_instances.put("birth_position", birth_allocation.get('2'));}
							else {
								seat_instances.put("birth_position", birth_allocation.get(seat_instances.get("seat_position")));
								seat_instances.put("is_RAC_replacable", true);
							}
					}
					else if(this.is_sleeper) {
						seat_instances.put("birth_position", birth_allocation.get(seat_instances.get("seat_position")));
					}
					else {
						seat_instances.put("birth_position",'0');
					}
					if(j==this.seat_ratio[0]) {
						seat_ratio_index=1;
					}
//-----------------//
//+++++++++++++++++//System.out.println(seat_instances.get("seat_position")+" seat no"+ seat_no+" birth "+seat_instances.get("birth_position")+" left RAC "+seat_instances.get("RAC_replacable"));//00000000000000000000000000000000000000
				}
				else if(seat_ratio_index==1) {
					seat_instances.put("seat_position",seat_pos[second_side_seat_count-1]);
					second_side_seat_count--;
					if(this.is_sleeper&&this.seat_ratio[seat_ratio_index]==1) {
						if(i%2==0) {
						seat_instances.put("birth_position", birth_allocation.get('2'));}
						else {
							seat_instances.put("birth_position", birth_allocation.get(seat_instances.get("seat_position")));
							seat_instances.put("is_RAC_replacable", true);
						}
					}
					else if(this.is_sleeper) {
						seat_instances.put("birth_position", birth_allocation.get(seat_instances.get("seat_position")));
					}
					else {
						seat_instances.put("birth_position",'0');
					}
//------------------//
//+++++++++++++++++//System.out.println(seat_instances.get("seat_position")+" seat no"+ seat_no+" birth "+seat_instances.get("birth_position")+" right RAC "+seat_instances.get("RAC_replacable"));//000000000000000000000000000000000000
				}
				seat_instances.put("booked_status",false);
				seat=new Seat(seat_instances);
				HashMap<String,Object> seat_map=new HashMap<String,Object>();
				seat_map.put("row",row);
				seat_map.put("col",col);
				seat_map.put("seat_no", seat_no);
				coach_seats.put(seat_map, seat);
				//System.out.println(seat);
				seat_no++;
			}
		}	
//+++++++++++++++++//System.out.println("\n");	
		return coach_seats;
	}

	
	public String toString() {
		Seat seat=new Seat();
		int row=0,col=0;
		int seat_no=1;
		
		
		String str="\nCoach: "+this.coach_id+"("+getAvailable_confirm_seats_count()+")";
		for(int i=1;i<=total_rows;i++) {
			str+="\n";
			row=i;
			if(i%2==0) {
				str+="---------------------------------\n";
			}
			for(int j=1;j<=total_col;j++) {
				col=j;
				HashMap<String,Object> seat_graph=new HashMap<String,Object>();
				seat_graph.put("seat_no",seat_no);
//--------------//System.out.println(seat_no);//000000000000000000000000
				seat_graph.put("row",row);
				seat_graph.put("col",col);
				seat=coach_seats.get(seat_graph);
//---------------//System.out.println(seat);//0000000000000000000000000000
				if(seat.is_booked()&&seat.getBooked_as().equals("confirm")) {
					str+=" ["+seat.getSeat_no()+"] ";
				}
				else if(seat.getBooked_as().equals("RAC")) {
					str+="(("+seat.getSeat_no()+"))";
				}
				else {
					str+="  "+seat.getSeat_no()+"  ";
				}
				seat_no++;
				if(j==seat_ratio[0]) {
					str+="----";//to split according to ratio
				}
			}
		}
		return str;
	}
	
	
	Queue<Seat> refresh() {
		Queue<Seat>available_seats=new LinkedList<Seat>();
		int row,col;
		Seat seat;
		int seat_no=1;
		for(int i=1;i<=total_rows;i++) {
			row=i;
			for(int j=1;j<=total_col;j++){
				col=j;
				HashMap<String,Object> seat_graph=new HashMap<String,Object>();
				seat_graph.put("seat_no",seat_no);
				seat_graph.put("row",row);
				seat_graph.put("col",col);
				seat=coach_seats.get(seat_graph);
				//seat.setBooked_as("vacant");
				//seat.setIs_booked(false);
				seat.setIs_booked(!checkSeatAvailabilityInRoute(seat));
				if(!seat.is_booked()) {
					available_seats.add(seat);
				//	System.out.println(seat_no);
				}
				else {
					seat.setBooked_as("confirm");
				}
				seat_no++;
			}
		}this.available_confirm_seats_count=available_seats.size();
		this.available_seats=available_seats;
		return available_seats;
	}
	
	
	private boolean checkSeatAvailabilityInRoute(Seat seat) {
		if(seat.getEngaging_stop()==null) {
			//System.out.println("0_true");
			return true;
		}
		if(from_stop==null||to_stop==null) {
			//System.out.println("1_true");
			return true;
		}
		double from_stop_km=from_stop.getKm_from_start();
		double to_stop_km=to_stop.getKm_from_start();
		double eng_stop_km=seat.getEngaging_stop().getKm_from_start();
		double vac_stop_km=seat.getVcant_stop().getKm_from_start();
		if(from_stop_km<eng_stop_km
				&&to_stop_km<=eng_stop_km) {
			//System.out.println("2_true");
			return true;
		}
		else if(from_stop_km>=vac_stop_km
				&&to_stop_km>vac_stop_km) {
			//System.out.println("3_true");
			return true;
		}//System.out.println("fase");
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	public String getCoach_id() {
		return coach_id;
	}
	public void setCoach_id(String coach_id) {
		this.coach_id = coach_id;
	}
	public int getTotal_seats() {
		return total_seats;
	}
	public void setTotal_seats(int total_seats) {
		this.total_seats = total_seats;
	}
	public int getTotal_rows() {
		return total_rows;
	}
	public void setTotal_rows(int total_rows) {
		this.total_rows = total_rows;
	}
	public int getTotal_col() {
		return total_col;
	}
	public void setTotal_col(int total_col) {
		this.total_col = total_col;
	}

	public HashMap<HashMap<String,Object>,Seat> getCoach_seats() {
		return coach_seats;
	}

	public void setCoachSeats(HashMap<HashMap<String,Object>,Seat> coach_seats) {
		this.coach_seats = coach_seats;
	}

	public int[] getSeat_ratio() {
		return seat_ratio;
	}

	public void setSeat_ratio(int[] seat_ratio) {
		this.seat_ratio = seat_ratio;
	}

	public boolean isIs_sleeper() {
		return is_sleeper;
	}
	public void setIs_sleeper(boolean is_sleeper) {
		this.is_sleeper = is_sleeper;
	}
	public int getAvailable_confirm_seats_count() {
		return  this.available_confirm_seats_count;
	}
	public Queue<Seat> getAvailable_seats(){
		return this.available_seats;
	}
	
	
	public void setPassengerRoute(Stop from_stop,Stop to_stop) {
		//System.out.println(from_stop.getName());
		this.from_stop = from_stop;
		this.to_stop = to_stop;
	}
}
