package matrix;

import java.util.HashMap;

public class Matrix<T>{
	private HashMap<HashMap<String,Integer>,Vertex<T>> vertex_map=new HashMap<HashMap<String,Integer>,Vertex<T>>();
	private int row_count;
	private  int col_count;
	
	public Matrix(int row_count,int col_count) {
		this.row_count=row_count;
		this.col_count=col_count;
		for(int i=0;i<row_count;i++) {
			for(int j=0;j<col_count;j++) {
				Vertex<T> vertex=new Vertex<T>(this);
				addVertex(i,j,vertex);
			}
		}
	}
	@Override
	public String toString() {
		String str="";
		for(int i=0;i<row_count;i++) {
			if(i>0) {
				str+="\n";
			}
			for(int j=0;j<col_count;j++) {
				str+=getVertex(i,j)+",";
			}
		}
		return str;
	}
	
	public int getRow_count() {
		return row_count;
	}

	public int getCol_count() {
		return col_count;
	}

	public Vertex<T> getVertex(int row,int col) {
		HashMap<String,Integer> postion_map=new HashMap<String,Integer>();
		postion_map.put("row", row);
		postion_map.put("col", col);
		return vertex_map.get(postion_map);
	}
	
	public void addVertex(int row,int col,Vertex<T> vertex) {
		HashMap<String,Integer> postion_map=new HashMap<String,Integer>();
		postion_map.put("row", row);
		postion_map.put("col", col);
		vertex.setRow(row);
		vertex.setCol(col);
		vertex_map.put(postion_map, vertex);
	}
	
}
