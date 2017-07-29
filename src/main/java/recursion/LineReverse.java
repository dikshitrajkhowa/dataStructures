package recursion;

import java.util.Scanner;

/**
 * Reversing a line without using any 
 * data structure
 * @author dikshit.rajkhowa
 *
 */
public class LineReverse {

	public static void reverse(Scanner in)
	{
		if(in.hasNextLine())
		{
			String line = in.nextLine();
			reverse(in);
			System.out.println(line);		
		}
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		reverse(in);

	}

}
