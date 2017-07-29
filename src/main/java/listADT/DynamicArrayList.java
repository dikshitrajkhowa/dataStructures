package listADT;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This uses an array based implementation
 * It includes a resize method
 * 
 * @author dikshit.rajkhowa
 * 
 * @param <E>
 */
public class DynamicArrayList<E> implements List<E> {

	public static final int CAPACITY = 16;
	private E[] data;
	private int size;

	public DynamicArrayList() {
		this(CAPACITY);
	}

	public DynamicArrayList(int capacity) {
		data = (E[]) new Object[capacity];
	}

	@Override
	public int size() {
		return size;
		// we cant use data.size because it will always return CAPACITY
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		return data[i];
	}

	/**
	 * Replaces the element at index i with e, and returns the replaced element.
	 */
	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		E temp = data[i];
		data[i] = e;
		return temp;
	}

	/**
	 * Inserts element e to be at index i, shifting all subsequent elements
	 * later.
	 */
	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		if (size == data.length)
			resize(2*data.length);

		for (int k = size - 1; k >= i; k--) {
			data[k + 1] = data[k];
		}
		data[i] = e;
		size++;

	}

	/**
	 * Removes/returns the element at index i, shifting subsequent elements
	 * earlier.
	 */
	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		E temp = data[i];
		for (int k = i; k <= size - 1; k++) {
			data[k] = data[k + 1];
		}
		data[size - 1] = null;
		size--;

		return temp;
	}

	private void checkIndex(int index, int size) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Illegal index :" + index);

	}

	/** Resizes internal array to have given capacity >= size. */
	protected void resize(int capacity) {
		E[] temp = (E[]) new Object[capacity]; // safe cast; compiler may give warning
		for (int k = 0; k < size; k++)
			temp[k] = data[k];
		data = temp; // start using the new array
	}

	// nested ArrayIterator class

	private class ArrayIterator implements Iterator<E> {
		private int j = 0; // index of the next element to report
		private boolean removable = false; // can remove be called at this time?

		@Override
		public boolean hasNext() {
			return j < size;
		}

		@Override
		public E next() throws NoSuchElementException {
			if (j == size)
				throw new NoSuchElementException("No next element");
			removable = true; // this element can subsequently be removed
			return data[j++]; // post-increment j, so it is ready for future
								// call to next

		}

		@Override
		public void remove() throws IllegalStateException {
			if (!removable)
				throw new IllegalStateException("nothing to remove");
			DynamicArrayList.this.remove(j - 1); // that was the last one returned
			j--;// next element has shifted one cell to the left
			removable = false; // do not allow remove again until next is called

		}

	}
	
	
	@Override
	public Iterator<E> iterator() {
		return new ArrayIterator();
	}

}
