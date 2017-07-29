package sorting;
/**
 * Sedgewick
 */
import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

	static int steps=0;
	public static void insertionSort(int[] data)
	{
		int n=data.length;
		
		for(int i = 1;i < n;i++)
		{
			for(int j=i; j > 0;j--)
			{
				if(less(data[j],data[j-1]))
				{
					exch(data,j,j-1);
				}
			}
			System.out.println("Step "+ ++steps +" -> "+Arrays.toString(data));
		}
		
	}
	private static void exch(int[] data, int i, int j) {
		int temp =data[i];
		data[i] =data[j];
		data[j] =temp;
		
	}
	private static boolean less(int i, int j) {
		return i < j;
	}
	public static void main(String[] args) {
		int data[ ] = new int[10];
		Random rand = new Random( );
		rand.setSeed(System.currentTimeMillis( ));
		for (int i = 0; i < data.length; i++)
		{
			data[i] = rand.nextInt(100);
		}
		
		System.out.println(""+Arrays.toString(data));
		insertionSort(data);

	}

}
