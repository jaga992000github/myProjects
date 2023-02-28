package view.admin.booking_admin.inputs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
	
public class TrainInputs {
	Scanner scan=new Scanner(System.in);
	private int numberExceptionHandle() {
		int num=0;
		while(true) {
			String  str_num=scan.next();
			try {
				num=Integer.parseInt(str_num);
				break;
			}
			catch(NumberFormatException e) {
			System.out.println("please Enter number only");	
			}
		}
		return num;
	}
	public HashMap<String,Object> getTrainDetails(){
		HashMap<String,Object> train_instances=new HashMap<String,Object>();
		//System.out.println("Enter Train Name");
		String train_name="MangloreXpress";//scan.next();
		//System.out.println("Enter Train No");
		int train_no=1234;//scan.nextInt();
		//System.out.println("Enter Route");
		ArrayList<HashMap<String,Object>>stop_instances_list =new ArrayList<HashMap<String,Object>>();
	
		HashMap<String,Object> stop_instances1=new HashMap<String,Object>();
		stop_instances1.put("name","chennai");
		stop_instances1.put("km_from_start",0);
		stop_instances1.put("wating_time",5);
		stop_instances_list.add(stop_instances1);
		
		HashMap<String,Object> stop_instances2=new HashMap<String,Object>();
		stop_instances2.put("name","viluppuram");
		stop_instances2.put("km_from_start",5);
		stop_instances2.put("wating_time",5);
		stop_instances_list.add(stop_instances2);
		
		HashMap<String,Object> stop_instances3=new HashMap<String,Object>();
		stop_instances3.put("name","tiruppur");
		stop_instances3.put("km_from_start",14);
		stop_instances3.put("wating_time",5);
		stop_instances_list.add(stop_instances3);
		
		HashMap<String,Object> stop_instances4=new HashMap<String,Object>();
		stop_instances4.put("name","erode");
		stop_instances4.put("km_from_start",27);
		stop_instances4.put("wating_time",5);
		stop_instances_list.add(stop_instances4);
		
		HashMap<String,Object> stop_instances5=new HashMap<String,Object>();
		stop_instances5.put("name","coimbatore");
		stop_instances5.put("km_from_start",32);
		stop_instances5.put("wating_time",5);
		stop_instances_list.add(stop_instances5);
//		while(true) {
//			System.out.println("1->add Stop"
//						+ "\n0->finish");
//			int decide=scan.nextInt();
//			if(decide==1) {
//				System.out.println("Enter Stop Name");
//				String name=scan.next();
//				System.out.println("Enter Stop KM from stat");
//				int km_from_start=scan.nextInt();
//				System.out.println("Enter Stop Name");
//				int wating_time=scan.nextInt();
//				
//				HashMap<String,Object> stop_instances=new HashMap<String,Object>();
//				stop_instances.put("name",name);
//				stop_instances.put("km_from_start",km_from_start);
//				stop_instances.put("wating_time",wating_time);
//				train_route.addLast(stop_instances);
//			}
//			else {
//				break;
//			}	
//		}
		
		ArrayList<HashMap<String,Object>> carriage_list=getCarriageDetails();
		
		train_instances.put("train_name",  train_name);
		train_instances.put("train_no",  train_no);
		train_instances.put("stop_instances_list",  stop_instances_list);
		train_instances.put("carriage_list", carriage_list);
		
		return train_instances;
	}
	
	
	public HashMap<String,Object> getCoachDetails(String coach_id){
	 		//System.out.println("Enter Seat ratio");
	 		int[] seat_ratio={1,3};//new int[2];
	 		//int col_sum=0;
//	 		for(int i=0;i<2;i++) {
// 			seat_ratio[i]=scan.nextInt();
//	 			col_sum+=seat_ratio[i];
//	 		}
	 		int total_col=seat_ratio[0]+seat_ratio[1];//col_sum;
	 		//System.out.println("Enter total row ");
	 		int total_rows=4;//scan.nextInt();
	 		int total_seats=total_col*total_rows;
//	 		System.out.println("having Sleeper facility"
//	 				+ "\n1->yes"
//	 				+ "\n0->No");
	 		boolean sleeper_facility=true;//scan.nextBoolean();
	 		//System.out.println("Enter the cost");
	 		int cost=100;//scan.nextInt();
	 		
	 		HashMap<String,Object> coach_instances=new HashMap<String,Object>();
 			coach_instances.put("seat_ratio", seat_ratio);
 			coach_instances.put("total_col", total_col);
 			coach_instances.put("total_rows", total_rows);
 			coach_instances.put("total_seats", total_seats);
 			coach_instances.put("coach_id", coach_id);
 			coach_instances.put("sleeper_facility",sleeper_facility);
 			
	 			
		return coach_instances;
	}
	public  ArrayList<HashMap<String,Object>> getCarriageDetails(){
		ArrayList<HashMap<String,Object>> carriage_list=new ArrayList<HashMap<String,Object>>();
		HashMap<String,Object>carriage_instances=new HashMap<String,Object>();
		int letter_ascii_count=0;
//		while(true) {
//	    	System.out.println("1->add new Coach"
//	    			+ "\n0->finish");
//	    	int decide=scan.nextInt();
//	    	if(decide==0) {
//	    		break;
//	    	}
	    	//System.out.println("Enter coach class type");
	 		String class_type="Sleeper";//scan.next();
	 		//System.out.println("Enter Basic fee");
	    	int basic_fee=100;//scan.nextInt();
	    	//System.out.println("Enter cost per KM");
	    	int cost_per_km=1;//scan.nextInt();
	    	//System.out.println("Enter  how many coach");
	 		int coach_count=4;//scan.nextInt();
	    	
	 		int letter_ascii=(65+letter_ascii_count);
	 		char letter=(char)letter_ascii;
	 		String coach_id=letter+"";
	 		HashMap<String,Object> coach_instances=getCoachDetails(coach_id);
	    	letter_ascii_count+=1;
	    	
	    	
	    	carriage_instances.put("class_type", class_type);
	    	carriage_instances.put("basic_fee", basic_fee);
	    	carriage_instances.put("cost_per_km", cost_per_km);
	    	carriage_instances.put("coach_count", coach_count);
	    	carriage_instances.put("coach_instances",coach_instances);	
	    	carriage_list.add(carriage_instances);
//		}
		return carriage_list;
	}
}
