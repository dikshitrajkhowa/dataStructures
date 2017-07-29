package recursion;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println(""+(-16 % 31));
		
//		quiz(5);
		int a[] = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
		System.out.println(" "+fun(a, 4));
		
//		System.out.println(F(0,4));

	}
	
	static void quiz(int i)
    {
        if (i > 1)
        {
        	System.out.println("- "+i);
            quiz(i / 2);
            quiz(i / 2);
        }
       System.out.println("*");
    }
	
	static int  fun(int b[], int size) {
		if (size == 1)
		return b[size - 1];
		else return b[size] + fun(b, size - 1);
	}

	static boolean F(int low, int high)
	{
		if (low >= high)
		return false;
		else
		return !F(low + 2, high + 1);
		}

}
