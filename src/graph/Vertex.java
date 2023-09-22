package graph;

import java.util.ArrayList;

import search_interfaces.BFS;

public class Vertex<T> implements BFS<Vertex<T>> {
	private T value;
	private Graph<Vertex<T>> graph;
	private ArrayList<Vertex<T>> nearByVertices=new ArrayList<Vertex<T>>();
	private int search_height;
	private boolean is_visited=false;
	
	public Vertex(Graph<Vertex<T>> graph,T value){
		
		this.value=value;
		this.graph=graph;
		this.graph.addVertex((Vertex<Vertex<T>>) this);
	}
	
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

	@Override
	public ArrayList<Vertex<T>> getNearByObj(Vertex<T> obj) {
		// TODO Auto-generated method stub
		return obj.getNearByVertices();
	}

	@Override
	public boolean getIsVisited(Vertex<T> obj) {
		// TODO Auto-generated method stub
		return obj.is_visited;
	}

	@Override
	public void setIsVisited(Vertex<T> obj, boolean bool_val) {
		// TODO Auto-generated method stub
		obj.is_visited=bool_val;
	}

	@Override
	public void setSearchHeight(int high, Vertex<T> obj) {
		// TODO Auto-generated method stub
		obj.search_height=high;
	}

	@Override
	public int getSearchHeight(Vertex<T> obj) {
		// TODO Auto-generated method stub
		return obj.search_height;
	}
}
