package neuron;

import java.util.ArrayList;

public class Neuclei {
	private ArrayList<Dendrite> dendrite_list;
	
	public Neuclei() {
		dendrite_list=new ArrayList<Dendrite>();
	}
	
	private double getWeight() {
		double sum=0.0;
		for(Dendrite dendrite:dendrite_list) {
			sum+=dendrite.getInput();
		}
		return sum;
	}
	
	
}
