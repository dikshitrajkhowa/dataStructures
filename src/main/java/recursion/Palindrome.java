package recursion;

public class Palindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "racehcar";
		System.out.println(" "+s+" is a palindrome :: "+palindrome(s));

	}

	// check the first and last letters for equality, and run the algorithm
	// again for the middle section of the word. Perform a boolean AND on the
	// two answers and return the result.
	public static boolean palindrome(String s)
	{
		if(s.length() ==1)
		{
			return true;
		}else if (s.length() == 2) {
			return s.charAt(0)==s.charAt(s.length()-1);
		}else
		{
			boolean firstLastEqual = s.charAt(0)==s.charAt(s.length()-1);
			boolean mid = palindrome(s.substring(1,s.length()-1));
			
			return firstLastEqual && mid;
		}
	}
}
