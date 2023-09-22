package matrix;

import java.util.ArrayList;

import search_interfaces.BFS;

public class Vertex<T> implements BFS<Vertex<T>>{
	private Matrix<T> matrix;
	private T value;
	private ArrayList<Vertex<T>>near_by_verices=new ArrayList<Vertex<T>>();;
	private int row;
	private int col;
	private boolean  isVisited=false;
	private  int search_height;
	
	

	public Vertex(Matrix<T> matrix) {
		super();
		this.matrix=matrix;
	}
	@Override
	public String toString() {
		if(value==null) {
			return null;
		}
		return value.toString();
	}
	
	public Vertex<T> getTopVertex(){
		Vertex<T> vertex=matrix.getVertex(row-1, col);
		return vertex;
	}
	public Vertex<T> getBottomVertex(){
		Vertex<T> vertex=matrix.getVertex(row+1, col);
		return vertex;
	}
	public Vertex<T> getLeftVertex(){
		Vertex<T> vertex=matrix.getVertex(row, col-1);
		return vertex;
	}
	public Vertex<T> getRightVertex(){
		Vertex<T> vertex=matrix.getVertex(row, col+1);
		return vertex;
	}
	public Vertex<T> getBottomLeftVertex(){
		Vertex<T> vertex=matrix.getVertex(row+1, col-1);
		return vertex;
	}
	public Vertex<T> getBottomRightVertex(){
		Vertex<T> vertex=matrix.getVertex(row+1, col+1);
		return vertex;
	}
	public Vertex<T> getTopLeftVertex(){
		Vertex<T> vertex=matrix.getVertex(row-1, col-1);
		return vertex;
	}
	public Vertex<T> getTopRightVertex(){
		Vertex<T> vertex=matrix.getVertex(row-1, col+1);
		return vertex;
	}
	
	private void checkAndAdd(Vertex<T> vertex) {
		if(vertex!=null) {
			near_by_verices.add(vertex);
		}
	}
	
	public ArrayList<Vertex<T>> getNear_by_verices() {
		checkAndAdd(getTopVertex());
		checkAndAdd(getBottomVertex());
		checkAndAdd(getLeftVertex());
		checkAndAdd(getRightVertex());
//		checkAndAdd(getBottomLeftVertex());
//		checkAndAdd(getBottomRightVertex());
//		checkAndAdd(getTopLeftVertex());
//		checkAndAdd(getTopRightVertex());
		return near_by_verices;
	}
	
	
	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
	@Override
	public ArrayList<Vertex<T>> getNearByObj(Vertex<T> obj) {
		// TODO Auto-generated method stub
		//System.out.println(obj);
		Vertex<T> vertex= obj;
		return vertex.getNear_by_verices();
	}
	@Override
	public void setIsVisited(Vertex<T> obj,boolean bool_val) {
		// TODO Auto-generated method stub
		obj.isVisited=bool_val;
		return;
	}
	@Override
	public boolean getIsVisited(Vertex<T> obj) {
		// TODO Auto-generated method stub
		return obj.isVisited;
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
