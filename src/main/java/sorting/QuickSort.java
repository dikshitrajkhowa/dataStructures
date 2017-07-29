package sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * 
 * @author dikshit.rajkhowa
 * 
 * Partitioning : 
 * 	Phase 1 :: Repeat until i and j pointers cross
 * 			i ) Scan i from left to right as long as a[i] < a[lo]
 * 		    ii) Scan j from right to left as long as a[j] > a[lo]
 * 		   iii) Exchange a[i] with a[j]
 * 	
 * 	Phase 2 :: When the pointers cross
 * 			Exchange a[lo] with a[j], j is the partitioning element
 *
 */
public class QuickSort {

	public static void quickSort(int[] a) {
		sort(a,0,a.length-1);
		
	}
	
	private static void sort(int[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int j = partition(a, lo, hi);

		sort(a, lo, j - 1);
		sort(a, j + 1, hi);

	}


	private static int partition(int[] a, int lo, int hi) {
		int i = lo, j = hi+1;

		while (true) {
			while (less(a[++i], a[lo]))// find item on left to swap
			{
				if (i == hi)
					break;
			}

			while (less(a[lo], a[--j]))// find item on right to swap
			{
				if (j == lo)
					break;
			}
			if (i >= j)
				break; // check if pointers cross
			exch(a, i, j); // swap
		}
		exch(a, lo, j); // swap with partitioning element

		return j; // return index of item now known to be in place
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
		for (int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(100);
		}
		
//		int data[] ={72, 91, 38, 79, 25, 20, 91, 0, 99, 82};
//		int data[] ={1,2,3,4};
		System.out.println("Initial :: "+Arrays.toString(data));
		
		
//		int p = partition(data, 0, data.length-1);
//		System.out.println("After partition :: "+Arrays.toString(data));
//		System.out.println("Partitioned at :: "+p);
		
		quickSort(data);
		System.out.println("Sorted  :: "+Arrays.toString(data));

	}

	

}


