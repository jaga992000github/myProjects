package graph;

import java.util.ArrayList;

import search_interfaces.BFS;

public class Working {
	public static void main(String[] args) {
		Graph<Vertex<Integer>> graph=new Graph<Vertex<Integer>>();
		Vertex<Integer> v1=new Vertex<Integer>(graph, 1);
		Vertex<Integer> v2=new Vertex<Integer>(graph, 2);
		Vertex<Integer> v3=new Vertex<Integer>(graph, 3);
		Vertex<Integer> v4=new Vertex<Integer>(graph, 4);
		Vertex<Integer> v5=new Vertex<Integer>(graph, 5);
		Vertex<Integer> v6=new Vertex<Integer>(graph, 6);
		Vertex<Integer> v7=new Vertex<Integer>(graph, 7);
		
		v1.connectVertexBiDirectionally(v7);
		v1.connectVertexBiDirectionally(v2);
		v1.connectVertexBiDirectionally(v3);
		
		v2.connectVertexBiDirectionally(v3);
		v2.connectVertexBiDirectionally(v4);
		
		v3.connectVertexBiDirectionally(v4);
		
		v4.connectVertexBiDirectionally(v7);
		
		BFS<Vertex<Integer>> bfs=v1;
		ArrayList<Vertex<Integer>> sp=bfs.getShortestPath(v1, v4);
		System.out.println(sp);
	}
}
