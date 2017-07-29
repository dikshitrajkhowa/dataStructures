package listADT;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Integer> list;
		
		list= new ArrayList<Integer>();
		
		list.add(0, 1);
		list.add(1, 2);
		list.add(1, 3);
		list.add(1, 4);
			
		System.out.println(" "+list);

	}

}
