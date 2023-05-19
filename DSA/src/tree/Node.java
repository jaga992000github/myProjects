package tree;

import java.util.ArrayList;

public class Node<T> {
	private Tree<T> tree;
	private ArrayList<Node<T>> children=new ArrayList<Node<T>>();
	private T value;
	private int height;
	private Node<T> parent;
	
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

}
