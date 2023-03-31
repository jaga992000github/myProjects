package view.validation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class TimeValidations {
	Scanner scan=new Scanner(System.in);
	
	public LocalDate validateInputDate() {
		NumberValidations nv=new NumberValidations();
		ArrayList<String> values_list=new ArrayList<String>(2);
		values_list.add("today");
		values_list.add("select date");
		LocalDate selected_date;
		String selection=nv.validateSelectionValue(values_list);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		if(selection.equals("today")) {
			selected_date=LocalDate.now();
			System.out.println(selected_date.format(formatter)+"-selected\n");
		}
		else {
			while(true) {
				try {
					System.out.println("Enter date in this format (dd/MM/yyyy)");
					String str = scan.next();
					selected_date = LocalDate.parse(str, formatter);
					System.out.println(selected_date.format(formatter)+"-selected\n");
					break;	
				}
				catch(Exception e) {
					System.out.println("Please enter date in"
							+ "\ngiven format only\n");
				}
			}
		}
		return selected_date;
	}
	
	public LocalTime validateInputTime() {
		NumberValidations nv=new NumberValidations();
		ArrayList<String> values_list=new ArrayList<String>(2);
		values_list.add("current_time");
		values_list.add("select_time");
		LocalTime selected_time;
		String selection=nv.validateSelectionValue(values_list);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		if(selection.equals("current_time")) {
			selected_time=LocalTime.now();
			System.out.println(selected_time.format(formatter)+"-selected");
		}
		else {
			while(true) {
				try {
					System.out.println("Enter date in this format (HH:mm)");
					String str = scan.next();
					selected_time = LocalTime.parse(str, formatter);
					System.out.println(selected_time.format(formatter)+"-selected");
					break;	
				}
				catch(Exception e) {
					System.out.println("Please enter time in"
							+ "\ngiven format only\n");
				}
			}
		}
		return selected_time;
	
	}
	
	public LocalDateTime validateInputDateTime() {
		LocalDate selected_date=validateInputDate();
		LocalTime selected_time=validateInputTime();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime selected_date_time=LocalDateTime.of(selected_date, selected_time);
		System.out.println(selected_date_time.format(formatter));
		return selected_date_time;
	}
	public LocalDateTime avoidOldTime(LocalDateTime starting_time) {
		LocalDateTime old_st_time=starting_time;
		LocalDateTime new_st_time=null;
		while(true) {
			new_st_time=validateInputDateTime();
			if(new_st_time.getDayOfMonth()==old_st_time.getDayOfMonth()&&
			   new_st_time.getMonthValue()== old_st_time.getMonthValue()	) {
				System.out.println("This day is same as old day"
						+ "please enter new day");
			}
			else {
				break;
			}
		}
		return new_st_time;
	}
}
