package list;


public class CircularLinkedList<E> {

	// instance variables of the CircularlyLinkedList
	private Node<E> tail = null; // we store tail (but not head)
	private int size = 0; // number of nodes in the circularLinkedList

	// constructs an initially empty list
	public CircularLinkedList() {
	}

	// access methods
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	// returns (but does not remove) the first element
	public E first() {
		if (isEmpty())
			return null;
		return tail.getNext().getElement(); // the head is *after* the tail
	}
	
	// returns (but does not remove) the last element
	
	public E last( ) {
		if (isEmpty( )) return null;
		return tail.getElement( );
	}
	
	// update methods
	
	//rotate the first element to the back of the list
	public void rotate()
	{
		if(tail!=null)
		{
			tail = tail.getNext();//since head, the first element is referenced by tail.getNext()
		}
	}
	
	//adds element to the front of the list
	public void addFirst(E e)
	{
		if(size==0)
		{
			tail = new Node<>(e,null);
			tail.setNext(tail);//link to itself circularly
		}else
		{
			Node<E> newest = new Node<>(e,tail.getNext());//the earlier head, which is tail.getNext becomes the new head's next
			tail.setNext(newest); //the new node becomes the next of the tail
		}
		size++;
	}
	
	//adds element to the tail
	
	public void addLast(E e)
	{
		addFirst(e);//first add the element to the front, so this new element becomes tail.getNext();
		tail=tail.getNext();
		
	}
	
	//removes the first element
	
	public E removeFirst()
	{
		if(isEmpty())
		{
			return null;
		}
		Node<E> head = tail.getNext();
		if(head==tail)
		{
			tail=null;
		}else
		{
			tail.setNext(head.getNext());
		}
		size--;
		return head.getElement();
	}
	
	//Display elements
	
		 public void display()
		 {
			 System.out.print("\nCircular Linked List = ");
			 
			 if(size==0)
			 {
				 System.out.println("empty\n");
				 return;
			 }
			 
			Node start = tail.getNext();
			
			System.out.print(start.getElement() +" -> ");
			
			Node nxt = start.getNext();
			while(nxt.getNext()!= start)
			{
				System.out.print(nxt.getElement() +" ->");
				nxt = nxt.getNext();
			}
			System.out.println(nxt.getElement());
			 
		 }
			
}












