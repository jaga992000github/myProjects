package graph;

import java.util.ArrayList;

public class Vertex<T> {
	private T value;
	private Graph graph;
	private ArrayList<Vertex<T>> nearByVertices=new ArrayList<Vertex<T>>();
	
	
	@Override
	public String toString() {
		String str=value.toString();
		return str;
	}
	
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public Graph getGraph() {
		return graph;
	}
	public void setGraph(Graph graph) {
		this.graph = graph;
	}
	public ArrayList<Vertex<T>> getNearByVertices() {
		return nearByVertices;
	}
	public void connectVertexUniDirectionally(Vertex<T> vertex) {
		nearByVertices.add(vertex);
	}
	public void connectVertexBiDirectionally(Vertex<T> vertex) {
		nearByVertices.add(vertex);
		vertex.getNearByVertices().add(this);
	}
}
