package list;

public class Node<E> {
	private E element; // reference to the element stored at this node
	private Node<E> next; // reference to the subsequent node in the circularLinkedList

	public Node(E e, Node<E> n) {
		element = e;
		next = n;
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

}
