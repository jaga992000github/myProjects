package control.admin.booking_admin.initializer;

import view.admin.booking_admin.pojo_instances_templates.*;
public class ViewInitializer {
	TemplateInterface template;
	
	public  ViewInitializer(){
		template =new CoachInstancesTemplates();
		template.initiaze();
		template =new CarriageInstancesTemplates();
		template.initiaze();
		template =new RouteInstancesTemplates();
		template.initiaze();
		template =new TrainInstancesTemplates();
		template.initiaze();
	}
	
}
