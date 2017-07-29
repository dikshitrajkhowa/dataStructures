package stacks;

/**
 * Array based implementation of stack
 * 
 * @author dikshit.rajkhowa
 * 
 * @param <E>
 */

public class ArrayStack<E> implements Stack<E> {

	public static final int CAPACITY = 1000;

	private E[] data; // generic array used for storage

	private int t = -1;

	public ArrayStack() {
		this(CAPACITY);
	}

	public ArrayStack(int capacity) {
		data = (E[]) new Object[capacity];
	}

	@Override
	public int size() {
		return t+1;
	}

	@Override
	public boolean isEmpty() {
		return t == -1;
	}

	/**
	 * Note well that when pushing an element, t is incremented 
	 * before placing the new element, so that it uses the 
	 * first available cell
	 */
	@Override
	public void push(E e) throws IllegalStateException{
		if(size()==data.length) throw new IllegalStateException("Stack is Full");
		data[++t]=e;
	}

	@Override
	public E top() {
		if(isEmpty()) return null;
		return data[t];
	}

	@Override
	public E pop() {
		if(isEmpty()) return null;
		E answer = data[t];
		data[t]=null;
		t--;
		return answer;
	}

}
