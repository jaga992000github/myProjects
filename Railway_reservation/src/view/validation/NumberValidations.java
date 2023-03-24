package view.validation;


import java.util.ArrayList;
import java.util.Scanner;


public class NumberValidations {
	Scanner scan=new Scanner(System.in);
	
	public int validateIntegerInput() {
		int num=0;
		while(true) {
		//	System.out.println("\nenter the Number");
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
	
	public String validateSelectionValue(ArrayList<String> values_list) {
		String selected_value="";
		for(int i=0;i<values_list.size();i++) {
			String value=values_list.get(i);
			System.out.println((i+1)+":->"+value);
		}
		while(true) {
			int selected_value_id=validateIntegerInput();
			if((selected_value_id>values_list.size())||(selected_value_id<1)) {
				System.out.println("Please enter "
						+ "\ngiven Numbers only\n");
			}
			else {
			selected_value=values_list.get(selected_value_id-1);
			break;
			}
		}
		System.out.println(selected_value+" -Selected\n");
		return selected_value;
	}
	public int validateSelectionNumber(ArrayList<String> values_list) {
		String selected_value="";
		int selected_value_id=0;
		for(int i=0;i<values_list.size();i++) {
			String value=values_list.get(i);
			System.out.println((i+1)+":->"+value);
		}
		while(true) {
			selected_value_id=validateIntegerInput();
			if((selected_value_id>values_list.size())||(selected_value_id<1)) {
				System.out.println("Please enter "
						+ "\ngiven Numbers only\n");
			}
			else {
			selected_value=values_list.get(selected_value_id-1);
			break;
			}
		}
		System.out.println(selected_value+" -Selected\n");
		return selected_value_id;
	}
	
	public int validateTrainNoInput(){
		int train_no=0;
		while(train_no<100000||train_no>999999) {
			System.out.println("Enter a 6 digit number");
			train_no=validateIntegerInput();
			if(train_no<100000||train_no>999999) {
				System.out.println("the number must be 6 digit");
			}
		}
		return train_no;
	}
	public boolean validateBooleanInput() {
		System.out.println("1->yes"
				+ "\n0->no");
		int num;
		boolean flag=true;
		while(true) {
			num=validateIntegerInput();
			if(num==1) {
				flag= true;
				break;
			}
			else if(num==0) {
				flag= false;
				break;
			}
			else {
				System.out.println("Please enter\n"
						+ "given Numbers only");
			}
		}
		return flag;
	}
	
	public double validateDoubleInput() {
		double num=0;
		while(true) {
			//System.out.println("enter the Number");
			String  str_num=scan.next();
			try {
				num=Double.parseDouble(str_num);
				break;
			}
			catch(NumberFormatException e) {
			System.out.println("please Enter number only");	
			}
		}
		return num;
	}
	public int[] validateSeatRatioInput(){
		int[] seat_ratio=new int[2];
		ArrayList<String> values_list=new ArrayList<String>();
		values_list.add("1:1");values_list.add("1:2");values_list.add("1:3");
		values_list.add("2:1");values_list.add("2:2");values_list.add("2:3");
		values_list.add("3:1");values_list.add("3:2");values_list.add("3:3");
		String selection=validateSelectionValue(values_list);
		seat_ratio[0]=Integer.parseInt(selection.charAt(0)+"");
		seat_ratio[1]=Integer.parseInt(selection.charAt(2)+"");	
		return seat_ratio;
	}
//	public static void main(String[] args) {
//		NumberValidations nv =new NumberValidations();
//		System.out.println(nv.validateBooleanInput());;
//	}
}
