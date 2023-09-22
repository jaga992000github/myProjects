package matrix;

import java.util.ArrayList;

import search_interfaces.BFS;

public class Working {
	public static void main(String[] args) {
		Matrix<Integer> matrix=new Matrix<Integer>(4,4);
		int count=1;
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				matrix.getVertex(i, j).setValue(count);
				count++;
			}
		}
		System.out.println(matrix);
		BFS<Vertex<Integer>> bfs =new Vertex<Integer>(matrix);
		
		Vertex<Integer> start=matrix.getVertex(0, 0);
		Vertex<Integer> end=matrix.getVertex(3,3);
//		System.out.println("\nst-"+start+"\nend-"+end);
		ArrayList<Vertex<Integer>>sp=bfs.getShortestPath(start, end);
		System.out.println(sp); 
	}
}
