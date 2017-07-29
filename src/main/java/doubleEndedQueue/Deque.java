package doubleEndedQueue;

/**
 * Interface for a double-ended queue: a collection of elements that can be
 * inserted and removed at both ends; this interface is a simplified version of
 * java.util.Deque.
 * 
 * @author dikshit.rajkhowa
 * 
 * @param <E>
 */
public interface Deque<E> {

	int size();

	boolean isEmpty();

	/**
	 * Returns, but does not remove, the first element of the deque (null if
	 * empty).
	 */
	E first();

	/**
	 * Returns, but does not remove, the last element of the deque (null if
	 * empty).
	 */
	E last();

	void addFirst(E e);

	void addLast(E e);

	E removeFirst();

	E removeLast();

}
