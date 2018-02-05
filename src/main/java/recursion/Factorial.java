package recursion;

public class Factorial {

	public static void main(String[] args) {
		System.out.println("\nFactorial :: " + factorialIllustrated(5));

	}

	public static int factorial(int n) {
		if (n < 0)
			throw new IllegalArgumentException("Please enter a positive number");
		if (n == 0) {
			return 1;
		}
		else {
			return n * factorial(n - 1);
		}

	}

	public static int factorialIllustrated(int n) {
		if (n < 0)
			throw new IllegalArgumentException("Please enter a positive number");
		if (n == 0) {
			System.out.println("\nReached Base Case = 1\n");
			return 1;
		}

		else {
			System.out.println("Calling " + n + " * factorial(" + (n - 1)+ ")");
			int x = factorialIllustrated(n-1);
			
			System.out.println("Computing " + n + " * factorial(" + (n - 1)+ ") => "+n+" * "+x +" = "+(n*x));
			return n * x;
		}

	}

}
