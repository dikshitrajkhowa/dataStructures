package sorting;

import java.util.Arrays;
import java.util.Random;

import utils.Clock;

public class MergeSort {


	@SuppressWarnings("rawtypes")
	public static Comparable[] mergeSort(Comparable[] list)  {
		//If list is empty; no need to do anything
        if (list.length <= 1) {
            return list;
        }
        
      //Split the array in half in two parts
        Comparable[] left = new Comparable[list.length / 2];
        Comparable[] right = new Comparable[list.length - left.length];
        
        //populate elements in the left and right subarrays
        System.arraycopy(list, 0, left, 0, left.length);
        System.arraycopy(list, left.length, right, 0, right.length);
		
        
        //Sort each half recursively
        mergeSort(left);
        mergeSort(right);
        
        //Merge both halves together, overwriting to original array
        merge(left, right, list);
		return list;
				
	}
	
	
	
	public static void merge(Comparable[] left, Comparable[] right,Comparable[] merged) {

		// Index Position in first array - starting with first element
		int iLeft = 0;

		// Index Position in second array - starting with first element
		int iRight = 0;

		// Index Position in merged array - starting with first position
		int iMerged = 0;

		// Compare elements at iFirst and iSecond, and move smaller element at iMerged
		while (iLeft < left.length && iRight < right.length) {

			if (left[iLeft].compareTo(right[iRight]) < 0) {
				merged[iMerged] = left[iLeft];
				iLeft++;
			} else {
				merged[iMerged] = right[iRight];
				iRight++;
			}
			iMerged++;

		}
		
		 //copy remaining elements from both halves - each half will have already sorted elements
		//at this stage either left or right will already be done

		System.arraycopy(left, iLeft, merged, iMerged, left.length-iLeft);
		System.arraycopy(right, iRight, merged, iMerged, right.length-iRight);
	}
	
	
	
	public static void main(String[] args) {
//		int n = 1000000;
		int n = 10;
		Integer[] input = new Integer[n];

		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		for (int i = 0; i < n; i++) {
			input[i] = rand.nextInt(100);
		}

		System.out.println(""+Arrays.toString(input));
		
		Clock.start();
		
		mergeSort(input);
		
		System.out.println(""+Arrays.toString(input));
		Clock.stop();
	}



}
