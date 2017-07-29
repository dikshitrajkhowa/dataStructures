package positionalList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A doubly linked list implementation of a PositionalList
 * @author dikshit.rajkhowa
 *
 * @param <E>
 */
public class LinkedPositionalList<E> implements PositionalList<E> {

	private Node<E> header;
	private Node<E> trailer;
	private int size = 0;
	
	public LinkedPositionalList( ){
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}
	

	// public accessor methods
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public Position<E> first() {
		return position(header.getNext());
	}

	@Override
	public Position<E> last() {
		return position(trailer.getPrev());
	}

	@Override
	public Position<E> before(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		
		return position(node.getPrev());
	}

	@Override
	public Position<E> after(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return position(node.getNext());
	}

	@Override
	public Position<E> addFirst(E e) {
	
		return addBetween(e, header, header.getNext());
	}

	@Override
	public Position<E> addLast(E e) {
		return addBetween(e, trailer.getPrev(), trailer);
	}

	@Override
	public Position<E> addBefore(Position<E> p, E e)throws IllegalArgumentException {
		Node<E> curr = validate(p);
		return addBetween(e, curr.getPrev(),curr );
	}

	@Override
	public Position<E> addAfter(Position<E> p, E e)throws IllegalArgumentException {
		Node<E> curr = validate(p);
		return addBetween(e, curr,curr.getNext() );
	}

	/** Replaces the element stored at Position p and returns the replaced element. */
	
	@Override
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E answer = node.getElement( );
		node.setElement(e);
		return answer;
	}

	@Override
	public E remove(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		Node<E> pred = node.getPrev();
		Node<E> succ = node.getNext();
		
		pred.setNext(succ);
		succ.setPrev(pred);
		size--;
		
		E answer = node.getElement();
		node.setElement(null);
		node.setPrev(null);
		node.setNext(null);
		
		return answer;
	}
	
	// private utilities
	/** Validates the position and returns it as a node.*/
	
	private Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid p");
		
		Node<E> node = (Node<E>) p;
		if (node.getNext( ) == null){
			throw new IllegalArgumentException("p is no longer in the list");
		}
		return node;
	}
	
	/** Returns the given node as a Position (or null, if it is a sentinel). */
	private Position<E> position(Node<E> node) {
		if (node == header || node == trailer)
			return null; // do not expose user to the sentinels
		
		return node;
	}
	
	
	/** Adds element e to the linked list between the given nodes. */
	private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
		Node<E> newest = new Node<>(e, pred, succ);
		pred.setNext(newest);
		succ.setPrev(newest);
		
		return newest;
	}
	
	private static class Node<E> implements Position<E>{
	
		private E element; // reference to the element stored at this node
		private Node<E> prev;
		private Node<E> next;
	
		public Node(E element, Node<E> prev, Node<E> next) {
			super();
			this.element = element;
			this.prev = prev;
			this.next = next;
		}
	
	
		@Override
		public E getElement() throws IllegalStateException {
			if (next == null) throw new IllegalStateException("Position no longer valid");
			return element;
		}
	
		public Node<E> getPrev() {
			return prev;
		}
	
		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}
	
		public Node<E> getNext() {
			return next;
		}
	
		public void setNext(Node<E> next) {
			this.next = next;
		}
	
		public void setElement(E element) {
			this.element = element;
		}		
		
	}
	
	//---------------- nested PositionIterator class ----------------
	private class PositionIterator implements Iterator<Position<E>>{
		private Position<E> cursor = first(); // position of the next element to report
		private Position<E> recent = null; // position of last reported element
		
		/** Tests whether the iterator has a next object. */
		public boolean hasNext() {
			return (cursor != null);
		}
		
		/** Returns the next position in the iterator. */
		public Position<E> next() throws NoSuchElementException{
			if (cursor == null) throw new NoSuchElementException("nothing left");
			recent = cursor;// element at this position might later be removed
			cursor = after(cursor);
			return recent;
			
		}
		
		/** Removes the element returned by most recent call to next. */
		public void remove( ) throws IllegalStateException{
			if (recent == null) throw new IllegalStateException("nothing to remove");
			LinkedPositionalList.this.remove(recent); // remove from outer list
			recent = null; // do not allow remove again until next is called
		}
		
	}
	
	//---------------- nested PositionIterable class ----------------
	private class PositionIterable implements Iterable<Position<E>> {

		@Override
		public Iterator<Position<E>> iterator() {
			return new PositionIterator();
		}

	}

	/** Returns an iterable representation of the list's positions. */
	public Iterable<Position<E>> positions(){
		return new PositionIterable( );
	}
	
	//---------------- nested ElementIterator class ----------------
	/* This class adapts the iteration produced by positions() to return elements. */
	private class ElementIterator implements Iterator<E>{
		Iterator<Position<E>> posIterator = new PositionIterator( );
		public boolean hasNext() 
		{
			return posIterator.hasNext( ); 
		}
		
		public E next( ) { return posIterator.next( ).getElement( ); }
		public void remove( ) { posIterator.remove( ); }
		
	}
	
	/** Returns an iterator of the elements stored in the list. */
	@Override
	public Iterator<E> iterator() {
		return new ElementIterator( );
	}

}
