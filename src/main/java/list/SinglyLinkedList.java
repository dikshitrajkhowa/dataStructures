package list;


/**
 * 
 * @author dikshit.rajkhowa
 *
 * @param <E>
 */
public class SinglyLinkedList<E> implements Cloneable{

	// instance variables of the SinglyLinkedList
	private Node<E> head = null; // head node of the SinglyLinkedList (or null if empty)
	private Node<E> tail = null; // last node of the SinglyLinkedList (or null if empty)
	private int size = 0; // number of nodes in the SinglyLinkedList

	public SinglyLinkedList() {
	} // constructs an initially empty SinglyLinkedList

	// access methods
	public int size() {
		return size;
	}
	
	

	public boolean isEmpty( ) { return size == 0; }
	
	// returns (but does not remove) the first element
	public E first( ) {
		if (isEmpty( )) return null;
		return head.getElement( );
	}
	
	// returns (but does not remove) the last element
	
	public E last( ) {
		if (isEmpty( )) return null;
		return tail.getElement( );
	}
	
	// update methods
	
	// adds element e to the front of the SinglyLinkedList
	public void addFirst(E e) {
		head = new Node<>(e, head);// create and link a new node
		if (size == 0)
		{
			tail = head;// special case: new node becomes tail also
		}
		size++;
	}
	
	// adds element e to the end of the circularLinkedList
	public void addLast(E e) { 
		Node<E> newest = new Node<>(e, null); // node will eventually be the tail
		if (isEmpty( ))
		{
			head = newest; // special case: previously empty circularLinkedList
		}else
		{
			tail.setNext(newest); // new node after existing tail
		}
		tail = newest; // new node becomes the tail
		size++;
	}
	
	// removes and returns the first element
	public E removeFirst( ) { 
		if (isEmpty( )) return null; // nothing to remove
		E answer = head.getElement( );
		head = head.getNext( ); // will become null if SinglyLinkedList had only one node
		size--;
		
		if (size == 0)
		{
			tail = null; // special case as SinglyLinkedList is now empty
		}
		return answer;
	}
	
	//Display elements
	
	 public void display()
	 {
		 System.out.print("\nSingly Linked List = ");
		 
		 if(size==0)
		 {
			 System.out.println("empty\n");
			 return;
		 }
		 
		 //single element
		 if(head.getNext()==null)
		 {
			 System.out.println(head.getElement());
		 }
		 
		 Node<E> ptr = head;
		 System.out.print(head.getElement()+ "->");
		 ptr = head.getNext();
		 
		 while(ptr.getNext()!=null)
		 {
			 System.out.print(ptr.getElement()+"->");
			 ptr = ptr.getNext();
		 }
		 System.out.print(ptr.getElement()+ "\n");
		 
	 }

	@Override
	public boolean equals(Object obj) {

		if(obj ==null) return false;
		if(getClass() !=obj.getClass()) return false;
		SinglyLinkedList<E> other = (SinglyLinkedList<E>) obj;
		if(size!=other.size) return false;
		
		Node<E> walkA = head;
		Node<E> walkB = other.head;
		
		while(walkA!=null)
		{
			if(walkA!=walkB) return false;
			walkA=walkA.getNext();
			walkB=walkB.getNext();
		}
		return true;
	}

	@Override
	protected SinglyLinkedList<E> clone() throws CloneNotSupportedException {
		// always use inherited Object.clone() to create the initial copy
		SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone( ); // safe cast
		
		if (size > 0) {
			other.head = new Node<>(head.getElement( ), null);
			Node<E> walk = head.getNext( ); // walk through remainder of original list
			Node<E> otherTail = other.head; // remember most recently created node
			
			while (walk != null) {
				Node<E> newest = new Node<>(walk.getElement( ), null);
				otherTail.setNext(newest); // link previous node to this one
				otherTail = newest;
				walk = walk.getNext( );
			}
		}
		
		return other;
	}
	

}























