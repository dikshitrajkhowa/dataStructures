package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

	/** Factory function to create a new node storing element e. */
	
	protected Node<E> createNode(E e, Node<E> parent,Node<E> left, Node<E> right){
		return new Node<E>(e, parent, left, right);
	}
	
	// LinkedBinaryTree instance variables
	protected Node<E> root = null;
	private int size = 0;
	private int depth =0;
	private int width =0;
	
	
	// constructs an empty binary tree
	public LinkedBinaryTree() {
		
	}
	
	/** Validates the position and returns it as a node. */
	protected Node<E> validate(Position<E> p) throws IllegalArgumentException{
		if (!(p instanceof Node))
			throw new IllegalArgumentException("Not valid position type");
		
		Node<E> node = (Node<E>) p;
		
		if (node.getParent( ) == node)
			throw new IllegalArgumentException("p is no longer in the tree");
		return node;
	}

	// accessor methods (not already implemented in AbstractBinaryTree)
	public int size( ) {
		return size;
	}
	
	/** Returns the root Position of the tree (or null if tree is empty). */
	public Position<E> root( ){
		return root;
	}
	
	/** Returns the Position of p's parent (or null if p is root). */
	public Position<E> parent(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return node.getParent();
	}
	
	/** Returns the Position of p's left child (or null if no child exists). */
	public Position<E> left(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return node.getLeft();
	}
	
	/** Returns the Position of p's right child (or null if no child exists). */
	public Position<E> right(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return node.getRight();
	}
	
	/** Places element e at the root of an empty tree and returns its new Position. */
	
	public Position<E> addRoot(E e) throws IllegalStateException{
		if (!isEmpty( )) throw new IllegalStateException("Tree is not empty");
		root = createNode(e, null, null, null);
		size=1;
		return root;
	}
	
	/** Creates a new left child of Position p storing element e; returns its Position. */
	public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException
	{
		Node<E> parent = validate(p);
		if(parent.getLeft() !=null)
			throw new IllegalArgumentException("Left child already added");
		
		Node<E> child = createNode(e, parent, null, null);
		parent.setLeft(child);
		size++;
		return child;
	}
	
	/** Creates a new right child of Position p storing element e; returns its Position. */
	public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException
	{
		Node<E> parent = validate(p);
		if(parent.getRight() !=null)
			throw new IllegalArgumentException("Right child already added");
		
		Node<E> child = createNode(e, parent, null, null);
		parent.setRight(child);
		size++;
		return child;
	}
	
	/** Replaces the element at Position p with e and returns the replaced element. */
	public E set(Position<E> p, E e) throws IllegalArgumentException{
		Node<E> node = validate(p);
		E temp = node.getElement( );
		node.setElement(e);
		
		return temp;
	}
	
	/** Attaches trees t1 and t2 as left and right subtrees of external p. */
	public void attach(Position<E> p, LinkedBinaryTree<E> t1,LinkedBinaryTree<E> t2) throws IllegalArgumentException{
		Node<E> node = validate(p);
		if (isInternal(p)) throw new IllegalArgumentException("p must be a leaf");
		
		size += t1.size( ) + t2.size( );
		
		// attach t1 as left subtree of node
		if (!t1.isEmpty( )) {
			t1.root.setParent(node);
			node.setLeft(t1.root);
			t1.root = null;
			t1.size = 0;
		}
		
		// attach t2 as right subtree of node
		if (!t2.isEmpty()) {
			t2.root.setParent(node);
			node.setRight(t2.root);
			t2.root = null;
			t2.size = 0;
		}
	}
	
	
	
	/** Removes the node at Position p and replaces it with its child, if any. */
	public E remove(Position<E> p) throws IllegalArgumentException{
		
		Node<E> node = validate(p);
		
		if (numChildren(p) == 2) throw new IllegalArgumentException("p has two children");
		
		Node<E> child = (node.getLeft( ) != null ? node.getLeft( ) : node.getRight( ) );
		if (child != null)
			child.setParent(node.getParent( )); // child’s grandparent becomes its parent
		if (node == root)
			root = child; // child becomes root
		else {
			Node<E> parent = node.getParent( );
			if (node == parent.getLeft( ))
			{
				parent.setLeft(child);
			}else
				parent.setRight(child);
		}
		
		size--;
		E temp = node.getElement( );
		node.setElement(null);
		node.setLeft(null);
		node.setRight(null);
		node.setParent(node);
		return temp;
	}
	
	public void printTree(List<Position<E>> treeNode,int level)
	{
		List<Position<E>> next = new ArrayList<Position<E>>();
		depth=level;
		
		System.out.print("Level => "+level+" ==>  ");
		
		for(Position<E> p: treeNode)
		{
			System.out.print(p.getElement()+" ");
			
			if(left(p)!=null) next.add(left(p));
			if(right(p)!=null) next.add(right(p));
		}
		
		System.out.println();
		
		if(next.size()>0) printTree(next,++level);
		
		
		
	}
	
	public void printTree1(List<Position<E>> treeNode,int level)
	{
		List<Position<E>> next = new ArrayList<Position<E>>();
		
		System.out.print("Level => "+level+" ==>  ");
		int x=0;
		for(Position<E> p: treeNode)
		{
			System.out.print("("+level+","+x+")"+p.getElement()+" ");
			x++;
			if(left(p)!=null) next.add(left(p));
			if(right(p)!=null) next.add(right(p));
		}
		
		System.out.println();
		
		if(next.size()>0) printTree1(next,++level);
		
		
	}
	
	
	
	 public  int layout(BinaryTree<E> T, Node<E> p, int d, int x) {
		    if (T.left(p) != null)
		      x = layout(T, (Node)T.left(p), d+1, x);     // resulting x will be increased
		    p.setX(x++);                      // post-increment x
		    p.setY(d);
		    if (T.right(p) != null)
		      x = layout(T,(Node) T.right(p), d+1, x);    // resulting x will be increased
		    return x;
		  }
	
	// nested node class
	protected static class Node<E> implements Position<E> {
		private E element;
		private Node<E> parent;
		private Node<E> left;
		private Node<E> right;
		private int x;
		private int y;

		/** Constructs a node with the given element and neighbors. */

		public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
			element = e;
			parent = above;
			left = leftChild;
			right = rightChild;
		}

		public E getElement() {
			return element;
		}

		public void setElement(E element) {
			this.element = element;
		}

		public Node<E> getParent() {
			return parent;
		}

		public void setParent(Node<E> parent) {
			this.parent = parent;
		}

		public Node<E> getLeft() {
			return left;
		}

		public void setLeft(Node<E> left) {
			this.left = left;
		}

		public Node<E> getRight() {
			return right;
		}

		public void setRight(Node<E> right) {
			this.right = right;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}
		
		

	}

	


}
