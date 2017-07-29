package binaryTree;

import java.util.ArrayList;
import java.util.List;

import binaryTree.LinkedBinaryTree.Node;

public class Client1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Tree as given in the TreeTraversal.png
		
		LinkedBinaryTree<String> t1= new LinkedBinaryTree<String>();
//		Position<String> root = t1.addRoot("P");
//		Position<String> f = t1.addLeft(root, "F");
//		Position<String> s = t1.addRight(root, "S");
//		
//		Position<String> b = t1.addLeft(f, "B");
//		Position<String> h = t1.addRight(f, "H");
//		
//		Position<String> r = t1.addLeft(s, "R");
//		Position<String> y = t1.addRight(s, "Y");
//		
//		Position<String> g = t1.addLeft(h, "G");
//		
//		Position<String> t = t1.addLeft(y, "T");
//		Position<String> z = t1.addRight(y, "Z");
//		
//		Position<String> w = t1.addRight(t, "W");
//		
		Node<String> root = (Node<String>) t1.addRoot("P");
		Node<String> f = (Node<String>)t1.addLeft(root, "F");
		Node<String> s = (Node<String>)t1.addRight(root, "S");
		
		Node<String> b = (Node<String>)t1.addLeft(f, "B");
		Node<String> h = (Node<String>)t1.addRight(f, "H");
		
		Node<String> r = (Node<String>)t1.addLeft(s, "R");
		Node<String> y = (Node<String>)t1.addRight(s, "Y");
		
		Node<String> g = (Node<String>)t1.addLeft(h, "G");
		
		Node<String> t = (Node<String>)t1.addLeft(y, "T");
		Node<String> z = (Node<String>)t1.addRight(y, "Z");
		
		Node<String> w = (Node<String>)t1.addRight(t, "W");
		
		
		
		
//		
		Iterable<Position<String>> preorder = t1.preorder(); 
		Iterable<Position<String>> inorder = t1.inorder(); 
		Iterable<Position<String>> postorder = t1.postorder(); 
		
		Iterable<Position<String>> breadhFirst = t1.breadthfirst();
		
		System.out.println("Inorder");
		for(Position<String> p:inorder)
		{
			System.out.print(""+p.getElement()+" ");
		}
		
		System.out.println("\nPreorder");
		for(Position<String> p:preorder)
		{
			System.out.print(""+p.getElement()+" ");
		}
		
		System.out.println("\nPostorder");
		for(Position<String> p:postorder)
		{
			System.out.print(""+p.getElement()+" ");
		}
		
		System.out.println("\nBreadth First");
		for(Position<String> p:breadhFirst)
		{
			System.out.print(""+p.getElement()+" ");
		}
		
		System.out.println("\nPrinting Tree\n");
		List<Position<String>> treeNode = new ArrayList<Position<String>>();
		treeNode.add(root);
		t1.printTree(treeNode,0);
		System.out.println("******************************");
		t1.printTree1(treeNode, 0);
	
		
		

	}
	
	

}
