package queue;

import list.CircularLinkedList;

public class LinkedCircularQueue<E> implements CircularQueue<E> {

	/** The primary storage for elements of the queue */
	CircularLinkedList<E> circle = new CircularLinkedList<>();

	public LinkedCircularQueue() {
	}

	@Override
	public int size() {
		return circle.size();
	}

	@Override
	public boolean isEmpty() {
		return circle.isEmpty();
	}

	@Override
	public void enqueue(E e) {
		circle.addLast(e);
	}

	@Override
	public E dequeue() {
		return circle.removeFirst();
	}

	@Override
	public E first() {

		return circle.first();
	}

	/**
	 * Rotates the front element of the queue to the back of the queue. This is
	 * a shorthand for enqueue(doubleEndedQueue()), except that it does nothing if the
	 * queue is empty, and it is implemented more efficiently so that no nodes
	 * are created or destroyed.
	 */

	@Override
	public void rotate() {
		circle.rotate();
	}

}
