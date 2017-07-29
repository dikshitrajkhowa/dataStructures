package sorting;

import java.util.Arrays;

public class BubbleSort {

	/***
	 *** Algorithm
	 *** 
	 *** Compare each pair of adjacent elements from the beginning of an array
	 * and, if they are in reversed order, swap them. If at least one swap has
	 * been done, repeat step 1.
	 *** 
	 *** In every pass, the biggest elements keep moving towards the right. After
	 * 1st pass, we'll have the biggest in rightmost. In 2nd pass, we'll have
	 * 2nd biggest on last -1 position
	 *** 
	 ***/

	public void bubbleSort(int[] arr) {
		boolean swapped = true;
		int j = 0;
		int tmp;
		while (swapped) {
			swapped = false;
			j++;
			// in every one for loop, the largest element is pushed towards the
			// right,
			for (int i = 0; i < arr.length - j; i++) {
				if (arr[i] > arr[i + 1]) {
					tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
					swapped = true;
				}
			}
		}
	}
	public static void main(String ...args)
	{
		int a[] = new int[]{98,34,12,7,4,3,-3};
		
		System.out.println("Before sorting ::  "+Arrays.toString(a));
		
		new BubbleSort().bubbleSort(a);
		
		System.out.println("After sorting ::  "+Arrays.toString(a));
		
		
		
	}

}

/***
 *** Average and worst case complexity of bubble sort is O(n2). Also, it makes
 * O(n2) swaps in the worst case - when the list is already in desc sorted
 * Bubble sort is adaptive. It means that for almost sorted array it gives O(n)
 * estimation
 ***/
