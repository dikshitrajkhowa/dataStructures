package queue;

/**
 * Implementation of the queue ADT using a fixed-length array.
 * 
 * The queue is modeled with a circular array,that wraps around the end.
 * 
 * The goal of the enqueue method is to add a new element to the back of the queue.
 * We need to determine the proper index at which to place the new element. 
 * Although we do not explicitly maintain an instance variable for the back of the queue, 
 * we compute the index of the next opening based on the formula: avail = (f + sz) % data.length;
 * 
 * Note that we are using the size of the queue as it exists prior to the addition of 
 * the new element. As a sanity check, for a queue with capacity 10, current size 3,
 * and first element at index 5, its three elements are stored at indices 5, 6, and 7, and
 * the next element should be added at index 8, computed as (5+3) % 10. As a case
 * with wraparound, if the queue has capacity 10, current size 3, and first element at
 * index 8, its three elements are stored at indices 8, 9, and 0, and the next element
 * should be added at index 1, computed as (8+3) % 10.
 * 
 * @author dikshit.rajkhowa
 * 
 */
public class ArrayQueue<E> implements Queue<E> {

	private E[] data; // generic array used for storage
	private int f = 0; // index of the front element
	private int sz = 0; // current number of elements

	public static final int CAPACITY = 1000;

	public ArrayQueue() {
		this(CAPACITY);
	}

	public ArrayQueue(int capacity) {
		data = (E[]) new Object[capacity];
	}

	public int size() {
		return sz;
	}

	public boolean isEmpty() {
		return (sz == 0);
	}
	
	/** Inserts an element at the rear of the queue. */
	
	public void enqueue(E e) throws IllegalStateException{
		if (sz == data.length) throw new IllegalStateException("Queue is full");
		int avail = (f + sz) % data.length; //index of the next opening
		data[avail] = e;
		sz++;
	}
	
	/** Returns, but does not remove, the first element of the queue (null if empty). */
	public E first( ) {
		if (isEmpty( )) return null;
		return data[f];
	}
	
	/** Removes and returns the first element of the queue (null if empty). */
	public E dequeue( ){
		if (isEmpty( )) return null;
		E answer = data[f];
		data[f] = null;
		f = (f + 1) % data.length;
		sz--;
		return answer;
	}

}
