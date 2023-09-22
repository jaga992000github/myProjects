package graph;

import java.util.ArrayList;

public class Graph<T> {
	private ArrayList<Vertex<T>> Vertices=new ArrayList<Vertex<T>>();
	
	public ArrayList<Vertex<T>> getVertices() {
		return Vertices;
	}
	
	public void addVertex(Vertex<T> vertex) {
		Vertices.add(vertex);
	}
}
