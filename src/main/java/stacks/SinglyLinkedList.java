package stacks;



public class SinglyLinkedList<E> {
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


	 class Node<E> {
			private E element; // reference to the element stored at this node
			private Node<E> next; // reference to the subsequent node

			public Node(E e, Node<E> n) {
				element = e;
				next = n;
			}

			public E getElement() {
				return element;
			}

			public void setElement(E element) {
				this.element = element;
			}

			public Node<E> getNext() {
				return next;
			}

			public void setNext(Node<E> next) {
				this.next = next;
			}

		}
}
