package view.validation;

import java.util.ArrayList;
import java.util.Scanner;

import view.admin.booking_admin.pojo_instances_templates.CarriageInstancesTemplates;
import view.admin.booking_admin.pojo_instances_templates.CoachInstancesTemplates;
import view.admin.booking_admin.pojo_instances_templates.RouteInstancesTemplates;
import view.admin.booking_admin.pojo_instances_templates.TrainInstancesTemplates;

public class DuplicateValidations {
	Scanner scan=new Scanner(System.in);
	
	public String checkDuplicateTrainNames() {
		TrainInstancesTemplates tit=new TrainInstancesTemplates();
		ArrayList<String> available_train_names=tit.getAvailable_train_names();
		String train_name="";
		while(true) {
			System.out.println("Enter train_name");
			train_name=scan.next();
			if(available_train_names.contains(train_name)) {
				System.out.println("this name already entered\n"
						+ "try another name");
			}
			else {
				break;
			}
		}
		return train_name;
	}
	@SuppressWarnings("unlikely-arg-type")
	public int checkDuplicateTrainNumbers() {
		TrainInstancesTemplates tit=new TrainInstancesTemplates();
		NumberValidations nv=new NumberValidations();
		ArrayList<String> available_train_numbers=tit.getAvailabe_train_instances_keys();
		int train_number=0;
		while(true) {
			System.out.println("Enter train_number");
			train_number=nv.validateTrainNoInput();
			if(available_train_numbers.contains(train_number)) {
				System.out.println("this number already entered\n"
						+ "try another number");
			}
			else {
				break;
			}
		}
		return train_number;
	}
	public String checkDuplicateClassTypes() {
		ArrayList<String> available_class_types=CarriageInstancesTemplates.getAvailable_class_name_keys();
		String class_type_name="";
		while(true) {
			System.out.println("Enter class_type_name");
			class_type_name=scan.next();
			if(available_class_types.contains(class_type_name)) {
				System.out.println("this class_type_name already entered\n"
						+ "try another class_type_name");
			}
			else {
				break;
			}
		}
		return class_type_name;
	}
	public String checkDuplicateCoachId() {
		ArrayList<String> available_coach_id=CarriageInstancesTemplates.getAvailable_coach_ids();
		String coach_id="";
		while(true) {
			System.out.println("Enter coach Alpha ID");
			coach_id=scan.next();
			if(available_coach_id.contains(coach_id)) {
				System.out.println("this coach_id already entered\n"
						+ "try another coach_id");
			}
			else {
				break;
			}
		}
		return coach_id;
	}
	public String checkDuplicateCoachNames() {
		ArrayList<String> available_coach_name=CoachInstancesTemplates.getAvailable_coach_keys();
		String coach_name="";
		while(true) {
			System.out.println("Enter coach_name");
			coach_name=scan.next();
			if(available_coach_name.contains(coach_name)) {
				System.out.println("this coach_name already entered\n"
						+ "try another coach_name");
			}
			else {
				break;
			}
		}
		return coach_name;
	}
	public String checkDuplicateRouteNames() {
		ArrayList<String> available_route_names=RouteInstancesTemplates.getAvailable_route_instances_keys();
		String route_name="";
		String rt="";
		while(true) {
			System.out.println("Enter route_name");
			route_name=scan.next();
			if(available_route_names.contains(route_name)) {
				System.out.println("this route_name already entered\n"
						+ "try another route_name");
			}
			else {
				rt="route_"+available_route_names.size()+"("+route_name+")";
				break;
			}
		}
		return rt;
	}
}
