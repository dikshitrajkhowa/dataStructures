package binaryTree1;

/**
 * ADT for binary tree node
 *
 */
public interface BinNode<E> {

	public E element();

	public void setElement(E v);

	public BinNode<E> left();

	public BinNode<E> right();

	public boolean isLeaf();

}
