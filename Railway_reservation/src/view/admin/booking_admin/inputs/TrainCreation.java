package view.admin.booking_admin.inputs;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import control.admin.booking_admin.initializer.ModelInitializer;
import control.admin.booking_admin.initializer.ViewInitializer;
import model.admin.booking_admin.pojo.Carriage;
import model.admin.booking_admin.pojo.Coach;
import model.admin.booking_admin.pojo.Train;
import view.admin.booking_admin.pojo_instances_templates.*;
import view.validation.NumberValidations;
import view.validation.TimeValidations;

public class TrainCreation {
	private GetDetails gd =new GetDetails();
	private NumberValidations nv =new NumberValidations();
	
	public HashMap<String,Object> createTrain(){
		HashMap<String,Object> train_instances = null;
		TrainInstancesTemplates tit=new TrainInstancesTemplates();
		if(decide("Train")) {
			train_instances=tit.getAvaiable_train_instances()
					.get(nv.validateSelection(tit.getAvailabe_train_instances_keys()));
			System.out.println("Enter new train starting time");
			TimeValidations tv=new 	TimeValidations();
			LocalDateTime train_starting_time=tv.avoidOldTime((LocalDateTime) train_instances.get("train_starting_time"));
			train_instances.replace("train_starting_time", train_starting_time);
		}
		else {
			train_instances=gd.getTrainDetails();
			ArrayList<HashMap<String, Object>>stop_instances_list=createRoute();
			ArrayList<HashMap<String,Object>> carriage_list=createCarriagesList();
			train_instances.put("stop_instances_list", stop_instances_list);
			train_instances.put("carriage_list", carriage_list);
			tit.addNewTrainTemplate(train_instances);
		}
		
		return train_instances;
	}
	
	private ArrayList<HashMap<String, Object>> createRoute(){
		ArrayList<HashMap<String, Object>> route_instances = null;
		RouteInstancesTemplates rit=new RouteInstancesTemplates();
		if(decide("Route")) {
			route_instances=rit.getAvailable_route_instances()
					.get(nv.validateSelection(rit.getAvailable_route_instances_keys()));
		}
		else {
			route_instances=gd.getRouteDetails();
			System.out.println(route_instances);
			String route_name=gd.getRouteName();
			rit.addNewTemplate(route_name, route_instances);
		}
		
		return route_instances;
	}
	private ArrayList<HashMap<String,Object>> createCarriagesList(){
		System.out.println("Give Route Details");
		ArrayList<HashMap<String,Object>> carriage_list=new ArrayList<HashMap<String,Object>>();
		while(true) {
    		System.out.println("add new Carriage");
    		if(!nv.validateBooleanInput()) {
    			break;
    		}
		HashMap<String,Object> carriage_instances=createCarriage();
		carriage_list.add(carriage_instances);
		}
		return carriage_list;
	}
	
	private HashMap<String,Object> createCarriage(){
		HashMap<String,Object> carriage_instances = null;
		CarriageInstancesTemplates crit=new CarriageInstancesTemplates();
		if(decide("Carriage")) {
			carriage_instances=crit.getAvaiable_carriage_instances()
					.get(nv.validateSelection(crit.getAvailable_class_name_keys()));
			System.out.println("enter coach count");
			int coach_count=nv.validateIntegerInput();
			carriage_instances.put("coach_count", coach_count);
		}
		else {
			carriage_instances=gd.getCarriageDetails();
			HashMap<String,Object> coach_instances=createCoach();
			carriage_instances.put("coach_instances",coach_instances);
			crit.addNewCarriageTemplate(carriage_instances);
		}
		
		return carriage_instances;
	}
	private HashMap<String,Object> createCoach(){
		HashMap<String,Object> coach_instances = null;
		CoachInstancesTemplates chit=new CoachInstancesTemplates();
		if(decide("Coach")) {
			coach_instances=chit.getAvalable_coach_instances()
					.get(nv.validateSelection(chit.getAvailable_coach_keys()));
		}
		else {
			coach_instances=gd.getCoachDetails();
			String coach_name=gd.getCoachName();
			chit.addNewCoachTemplate(coach_name, coach_instances);
		}
		return coach_instances;
	}
	
	private boolean decide(String temp_name) {
		System.out.println("Give "+temp_name+" Details");
		System.out.println("Want To use "+temp_name+" Templates");
		return nv.validateBooleanInput();
	}
	static {
		new ViewInitializer();
		new ModelInitializer();
	}
	public static void main(String[] args) {
		Train train=new Train(new TrainCreation().createTrain());
		TrainInstancesTemplates tit=new TrainInstancesTemplates();
		int size=tit.getAvaiable_train_instances().size();
		System.out.println(train);
		System.out.println(size);
	}
	
}
