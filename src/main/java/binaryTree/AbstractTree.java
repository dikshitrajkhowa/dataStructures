package binaryTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import queue.LinkedQueue;
import queue.Queue;

public abstract class AbstractTree<E> implements Tree<E> {

	public boolean isInternal(Position<E> p) {
		return numChildren(p) > 0;
	}

	public boolean isExternal(Position<E> p) {
		return numChildren(p) == 0;
	}

	public boolean isRoot(Position<E> p) {
		return p == root();
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int numChildren(Position<E> p) throws IllegalArgumentException {
		int count=0;
		
		for(Position<E> child:children(p))
			count++;
		return count;
	}

	
	  @Override
	  public int size() {
	    int count=0;
	    for (Position<E> p : positions()) count++;
	    return count;
	  }
	  
	  
	  /** 
	   * Returns the number of levels separating Position p from the root.
	   */
	  public int depth(Position<E> p) throws IllegalArgumentException {
		  if(isRoot(p))
			  return 0;
		  else {
			return 1+depth(p);
		}
	  }
	  
	  /** Returns the height of the tree.
	   *
	   * Note: This implementation works, but runs in O(n^2) worst-case time.
	   */
	  private int heightBad() {             // works, but quadratic worst-case time
	    int h = 0;
	    for (Position<E> p : positions())
	      if (isExternal(p))                // only consider leaf positions
	        h = Math.max(h, depth(p));
	    return h;
	  }
	  
	  /**
	   * Returns the height of the subtree rooted at Position p.
	   
	   */
	  public int height(Position<E> p) throws IllegalArgumentException {
	    int h = 0;                          // base case if p is external
	    for (Position<E> c : children(p))
	      h = Math.max(h, 1 + height(c));
	    return h;
	  }
	  
	//---------- support for various iterations of a tree ----------

	  //---------------- nested ElementIterator class ----------------

	private class ElementIterator implements Iterator<E> {
		Iterator<Position<E>> posIterator = positions().iterator();

		public boolean hasNext() {
			return posIterator.hasNext();
		}

		public E next() {
			return posIterator.next().getElement();
		} // return element!

		public void remove() {
			posIterator.remove();
		}

	}
	
	/**
	 * Returns an iterator of the elements stored in the tree.
	 * 
	 * @return iterator of the tree's elements
	 */
	@Override
	public Iterator<E> iterator() {
		return new ElementIterator();
	}

	 /**
	   * Returns an iterable collection of the positions of the tree.
	   * @return iterable collection of the tree's positions
	   */
	  @Override
	public Iterable<Position<E>> positions() {
		return preorder();
	}

	
	 
	/**
	 * Returns an iterable collection of positions of the tree, reported in
	 * preorder.
	 * 
	 * @return iterable collection of the tree's positions in preorder
	 */
	public Iterable<Position<E>> preorder() {
		List<Position<E>> snapshot = new ArrayList<>();
		
		 if (!isEmpty())
		 {
			 preorderSubtree(root(), snapshot);   // fill the snapshot recursively
		 }
		return snapshot;
	}

	public void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
		 snapshot.add(p);                       // for preorder, we add position p before exploring subtrees
		  for (Position<E> c : children(p))
		      preorderSubtree(c, snapshot);
		
	}
	
	 /**
	   * Adds positions of the subtree rooted at Position p to the given
	   * snapshot using a postorder traversal
	   * @param p       Position serving as the root of a subtree
	   * @param snapshot  a list to which results are appended
	   */
	  private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
	    for (Position<E> c : children(p))
	      postorderSubtree(c, snapshot);
	    snapshot.add(p);                       // for postorder, we add position p after exploring subtrees
	  }

	  /**
	   * Returns an iterable collection of positions of the tree, reported in postorder.
	   * @return iterable collection of the tree's positions in postorder
	   */
	  public Iterable<Position<E>> postorder() {
	    List<Position<E>> snapshot = new ArrayList<>();
	    if (!isEmpty())
	      postorderSubtree(root(), snapshot);   // fill the snapshot recursively
	    return snapshot;
	  }

	  /**
	   * Returns an iterable collection of positions of the tree in breadth-first order.
	   * @return iterable collection of the tree's positions in breadth-first order
	   */
	  public Iterable<Position<E>> breadthfirst() {
	    List<Position<E>> snapshot = new ArrayList<>();
	    if (!isEmpty()) {
	      Queue<Position<E>> fringe = new LinkedQueue<>();
	      fringe.enqueue(root());                 // start with the root
	      while (!fringe.isEmpty()) {
	        Position<E> p = fringe.dequeue();     // remove from front of the queue
	        snapshot.add(p);                      // report this position
	        for (Position<E> c : children(p))
	          fringe.enqueue(c);                  // add children to back of queue
	      }
	   
	    }
	    return snapshot;
	  }
	  
	  
	  
	
}
















