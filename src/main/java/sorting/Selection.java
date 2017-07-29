package sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * Selection addresses the following problem
 * 	Given an array of N elements, find the kth largest element
 * 
 * The following code, based on quicksort algo and hence known as quick select, is described below
 * 
 * Partition the array  so that
 * 
 * 	Entry a[j] is in place
 * 	All entries to the left of j are smaller than or equal to  a[j]
 * 	All entries to the right of j are larger than or equal to a[j]
 * 
 * Repeat in one subarray, depending on j; finished when j equals k
 * 	if j < k set lo = j+1
 * 	if j > k set hi = j-1
 * 
 * Repeat the process till j = k
 * 	
 * 
 * 
 * @author dikshit.rajkhowa
 *
 */
public class Selection {

	public static int select(int [] a, int k)
	{
		if(k > a.length-1) return a[a.length-1];
		if(k < 0) return a[0];
		
		
		int lo = 0, hi = a.length-1;
		
		while(hi > lo)
		{
			int j = partition(a, lo, hi);
			if( j < k) lo = j+1;
			if(j > k) hi = j-1;
			else return a[k];
		}
		return a[k];
	}
	
	private static int partition(int[] a, int lo, int hi) {
		int i = lo, j = hi + 1;

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
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;

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
		int i = 14;
		System.out.println("Array :: "+Arrays.toString(data));
//		QuickSort.quickSort(data);
//		System.out.println("Sorted :: "+Arrays.toString(data));
		System.out.println(i+"th element is :: "+select(data, i));

	}

}
