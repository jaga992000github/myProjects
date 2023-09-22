package tree;

import java.util.ArrayList;
import java.util.HashMap;

public class Tree<T> {
	private Node<T> root;
	private HashMap<T,Node<T>> node_map;
	private HashMap<Integer,ArrayList<Node<T>>> height_map=new HashMap<Integer,ArrayList<Node<T>>>();
	
	@Override
	public String toString() {
		String str="";
		int i=1;
		while(height_map.get(i)!=null) {
			str+=height_map.get(i)+"\n";
			i++;
		}
		return str;
	}
	
	public ArrayList<Node<T>> getNodesByHeight(int height) {
		return height_map.get(height);
	}
	public void setRoot(Node<T> root) {
		ArrayList<Node<T>> nodes=new ArrayList<Node<T>>();
		root.setParent(null);
		nodes.add(root);
		root.setHeight(1);
		height_map.put(1, nodes);
	}
	public Node<T> getRoot() {
		return root;
	}
	public HashMap<T,Node<T>> getNode_map() {
		return node_map;
	}
	
	public HashMap<Integer,ArrayList<Node<T>>> getHeight_map() {
		return height_map;
	}

}
