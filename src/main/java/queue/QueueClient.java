package queue;

public class QueueClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayQueue<Integer> que = new ArrayQueue<Integer>();
		
		que.enqueue(0);
		
		que.enqueue(1);
		
		que.enqueue(2);
		
		que.enqueue(3);
		
		
		que.enqueue(4);
		
		que.enqueue(5);
		
		que.enqueue(6);
		
		que.enqueue(7);
		
		System.out.print(" "+que.dequeue());
		System.out.print(" "+que.dequeue());
		System.out.print(" "+que.dequeue());
		System.out.print(" "+que.dequeue());
		System.out.print(" "+que.dequeue());
		System.out.print(" "+que.dequeue());
		System.out.print(" "+que.dequeue());
		System.out.print(" "+que.dequeue());
		que.enqueue(8);
		
		que.enqueue(9);
		System.out.print(" "+que.dequeue());
	
		
		
				
		
//		System.out.print(" "+que.dequeue())asdasaS;
//		
//		
//		
//		
//		
		

	}

}
