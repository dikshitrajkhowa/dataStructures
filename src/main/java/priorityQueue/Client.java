package priorityQueue;

public class Client {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		HeapPriorityQueue<Integer, String> queue = new HeapPriorityQueue<Integer, String>();
		queue.insert(7, "dddd");
		queue.insert(3, "aaa");
		queue.insert(1, "fff");
		queue.insert(8, "sss");
		queue.insert(9, "Asd");
		
		while(queue.size()!=0)
		{
			System.out.println(""+queue.removeMin().getValue());
			Thread.sleep(1000);
		}

	}

}
