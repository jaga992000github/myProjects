package neuron;

import java.util.ArrayList;

public class Axon {
	private double neuro_transmitter_value;
	private ArrayList<AxonTerminal> terminals;
	
	
	
	public Axon() {
		terminals=new ArrayList<AxonTerminal>();
	}
	private class AxonTerminal{
		private Dendrite dendrite;
		private double neuro_transmitter_value;
	}
	
	public void fillTerminals() {
		double share=neuro_transmitter_value/terminals.size();
		for(AxonTerminal terminal:terminals) {
			terminal.neuro_transmitter_value=share;
		}
	}
	public void sendOutputs() {
		for(AxonTerminal terminal:terminals) {
			terminal.dendrite.setInput(terminal.neuro_transmitter_value);
			terminal.neuro_transmitter_value=0;
		}
	}
}
