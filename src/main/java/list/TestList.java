package list;


public class TestList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
//		list.addFirst(23);
//		list.addLast(32);
//		list.addLast(34);
//		list.addLast(32);
//		
//		list.display();
		
		
		CircularLinkedList<Integer> list = new CircularLinkedList<Integer>();
		list.addFirst(23);
		list.addLast(32);
		list.addLast(34);
		list.addLast(32);
		
		list.display();
		
		list.rotate();
		list.display();
		
		

	}

}
