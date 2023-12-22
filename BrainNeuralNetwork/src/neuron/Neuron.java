package neuron;

import java.util.ArrayList;

public class Neuron {
	private ArrayList<Double> inputs;
	private ArrayList<Double> outputs;
	private Neuclei neuclei=new Neuclei();
	private Axon axon=new Axon();

	public void setInputs(ArrayList<Double> inputs) {
		this.inputs = inputs;
	}
	public ArrayList<Double> getOutputs() {
		return outputs;
	}
	
	
	
}
