package list;

public class DoublyLinkedList<E> {

	// instance variables of the DoublyLinkedList
	private NodeDLL<E> header; // header sentinel
	private NodeDLL<E> trailer; // trailer sentinel
	private int size = 0; // number of elements in the list

	/** Constructs a new empty list. */
	public DoublyLinkedList() {

		header = new NodeDLL<>(null, null, null); // create header
		trailer = new NodeDLL<>(null, header, null); // trailer is preceded by header
		header.setNext(trailer); // header is followed by trailer

	}

	public int size() {
		return size;
	}
	
	public boolean isEmpty( )
	{
		return size==0;
	}
	
	/** Returns (but does not remove) the first element of the list. */
	public E first( ) {
		if(isEmpty())
		{
			return null;
		}else
			return header.getNext().getElement();
	}

	
	/** Returns (but does not remove) the last element of the list. */
	
	public E last( ) {
		if(isEmpty())
			return null;
		return trailer.getPrev().getElement();
					
	}
	
	public void addFirst(E e) {
		addBetween(e,header,header.getNext());
	}

	public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer);
	}
	
	public E removeFirst()
	{
		if(isEmpty()) return null;
		return remove(header.getNext());
	}
	
	public E removeLast()
	{
		if(isEmpty()) return null;
		return remove(trailer.getPrev());
	}
	
	private E remove(NodeDLL<E> node) {
		NodeDLL<E> pred = node.getPrev();
		NodeDLL<E> succ= node.getNext();
		
		pred.setNext(succ);
		succ.setPrev(pred);
		size--;
		return node.getElement();
		
	}

	private void addBetween(E e, NodeDLL<E> predecessor, NodeDLL<E> successor) {
		NodeDLL<E> newNode = new NodeDLL<E>(e, predecessor, successor);
		predecessor.setNext(newNode);
		successor.setPrev(newNode);
		size++;
		
	}
	
	//Display elements
	
		 public void display()
		 {
			 System.out.print("\nDoubly Linked List = ");
			 
			 if(size==0)
			 {
				 System.out.println("empty\n");
				 return;
			 }
			 
			 NodeDLL current = header.getNext();
			
			 while(current!=trailer)
			 {
				 System.out.print(current.getElement() + "<=>");
				 current = current.getNext();
			 }
			 
				 
		 }	
		 
	
		 //Test
		 
		 public static void main(String[] args) {
				DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
				list.addFirst(23);
				list.addLast(32);
				list.addLast(34);
				list.addLast(32);
				
				list.display();
				

			}
	
}























