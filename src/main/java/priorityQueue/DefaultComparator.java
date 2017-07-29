package priorityQueue;

import java.util.Comparator;

/**
 * A DefaultComparator class that implements a comparator
 * based upon the natural ordering of its element type
 * 
 * @author dikshit.rajkhowa
 *
 * @param <E>
 */
public class DefaultComparator<E> implements Comparator<E> {

	@Override
	public int compare(E a, E b) {
		return ((Comparable<E>) a).compareTo(b);
	}
}
