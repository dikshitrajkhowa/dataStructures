package stacks;

public interface Stack<E> {

	/**
	 * Returns the number of elements in the stack.
	 * 
	 * @return number of elements in the stack
	 */
	int size();
	
	/**
	 * Tests whether the stack is empty.
	 * @return true if the stack is empty, false otherwise
	 */
	boolean isEmpty( );
	
	void push(E e);
	
	/**
	 * Returns, but does not remove, the element at the top of the stack.
	 * @return
	 */
	E top( );
	
	/**
	 * Removes and returns the top element from the stack.
	 */
	
	E pop( );
}
