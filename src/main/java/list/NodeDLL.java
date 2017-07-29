package list;

//Node for doubly linked list

public class NodeDLL<E> {
	
	private E element;
	private NodeDLL<E> prev;
	private NodeDLL<E> next;
	
	public NodeDLL(E element, NodeDLL<E> prev, NodeDLL<E> next) {
		super();
		this.element = element;
		this.prev = prev;
		this.next = next;
	}

	public NodeDLL<E> getPrev() {
		return prev;
	}

	public void setPrev(NodeDLL<E> prev) {
		this.prev = prev;
	}

	public NodeDLL<E> getNext() {
		return next;
	}

	public void setNext(NodeDLL<E> next) {
		this.next = next;
	}

	public E getElement() {
		return element;
	}
	
	

}
