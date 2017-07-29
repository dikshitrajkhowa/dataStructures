package stacks;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack<Integer> s1 = new LinkedStack<Integer>();
		
		s1.push(0);
		System.out.println(s1.pop());
		s1.push(1);
		System.out.println(s1.pop());
		s1.push(2);
	
	
		s1.push(3);
		s1.push(4);
	
		System.out.println(s1.pop());
		System.out.println(s1.pop());
	
		
		s1.push(5);
	
		s1.push(6);
		System.out.println(s1.pop());
		System.out.println(s1.pop());
	
		s1.push(7);
	
		s1.push(8);
		
		s1.push(9);
	
	
	}

	/**
	 * Suppose that an intermixed sequence of 10 push and 10 pop operations are performed 
	 * on a LIFO stack. The push operations add the values 0 through 9 to the stack, in the 
	 * order given; the intermixed pop operations delete and print out the return values 
	 * Which of the following output sequence(s) could occur? Check all that apply.
	 */
}
