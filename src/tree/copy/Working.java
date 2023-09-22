package tree.copy;

public class Working {
	public static void main(String[] args) {
		Tree<Integer> tree=new Tree<Integer>();
		Node<Integer> root=new Node<Integer>(tree,1);
		Node<Integer> node_2=new Node<Integer>(tree,2);
		Node<Integer> node_3=new Node<Integer>(tree,3);
		Node<Integer> node_4=new Node<Integer>(tree,4);
		Node<Integer> node_5=new Node<Integer>(tree,5);
		Node<Integer> node_6=new Node<Integer>(tree,6);
		Node<Integer> node_7=new Node<Integer>(tree,7);
		tree.setRoot(root);
		
		root.addChild(node_2);
		root.addChild(node_3);
		
		node_2.addChild(node_4);
		node_2.addChild(node_5);
		
		node_3.addChild(node_6);
		node_3.addChild(node_7);
		
		System.out.println(tree);
	}
}
