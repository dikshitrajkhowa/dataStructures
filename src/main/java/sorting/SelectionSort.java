package sorting;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {

	static int steps=0;
	//In iteration i, find the position with minimum element, call it minPostion, exchange data[i] & data[minPosition]
	public static void selectionSort(int[] data) {
		int n = data.length;
		
		for(int i =0; i < n;i++)
		{
			int minPosition =i;
			for(int j = i+1;j < n;j++)
			{
				if(less(data[j],data[minPosition]))
				{
					minPosition = j;
				}
			}
			
			exch(data,i,minPosition);
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
		selectionSort(data);


	}

	
}
