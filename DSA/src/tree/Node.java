package tree;

import java.util.ArrayList;

import search_interfaces.BFS;

public class Node<T> implements BFS<Node<T>>{
	private Tree<T> tree;
	private ArrayList<Node<T>> children=new ArrayList<Node<T>>();
	private T value;
	private int height;
	private Node<T> parent;
	private boolean is_visited=false;
	private  int search_height;
	
	@Override
	public String toString() {
		String str=value.toString();
		return str;
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Node(Tree<T> tree,T value) {
		this.tree=tree;
		this.value=value;
	}
	
	public void addChild(Node<T> child) {
		ArrayList<Node<T>> child_list=tree.getNodesByHeight(this.getHeight()+1);
		if(child_list==null) {
			ArrayList<Node<T>> new_child_list=new ArrayList<Node<T>>();
			tree.getHeight_map().put(this.getHeight()+1, new_child_list);
			child_list=new_child_list;
		}
		child.setHeight(height+1);
		child.setParent(this);
		child_list.add(child);
		children.add(child);
	}
	public ArrayList<Node<T>> getSiblings(){
		return getParent().getChildren();
	}
	public ArrayList<Node<T>> getNodeWithSimilarHeight(){
		return tree.getNodesByHeight(height);
	}
	
	public ArrayList<Node<T>> getChildren(){
		return children;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}

	public Node<T> getParent() {
		return parent;
	}

	public void setParent(Node<T> parent) {
		this.parent = parent;
	}
	
	

	@Override
	public ArrayList<Node<T>> getNearByObj(Node<T> obj) {
		// TODO Auto-generated method stub
		ArrayList<Node<T>> nearby_obj=new ArrayList<Node<T>>();
		if(obj.getChildren()!=null) {
			for(Node<T> i:obj.getChildren()) {
				nearby_obj.add(i);
			}
		}
		if(obj.getParent()!=null) {
			nearby_obj.add(obj.getParent());
		}
		
		return nearby_obj;
	}

	@Override
	public boolean getIsVisited(Node<T> obj) {
		// TODO Auto-generated method stub
		return obj.is_visited;
	}

	@Override
	public void setIsVisited(Node<T> obj, boolean bool_val) {
		// TODO Auto-generated method stub
		obj.is_visited=bool_val;
	}

	@Override
	public void setSearchHeight(int high, Node<T> obj) {
		// TODO Auto-generated method stub
		obj.search_height=high;
	}

	@Override
	public int getSearchHeight(Node<T> obj) {
		// TODO Auto-generated method stub
		return obj.search_height;
	}

}
