package recursion;

public class PrintStar {

	public static void printStar(int n)
	{
		if(n==0)
		{
			System.out.println("");
		}else
		{
			System.out.println("*");
			printStar(n-1);
		}
	}
	
	
	public static void main(String[] args) {
		printStar(5);

	}

}
