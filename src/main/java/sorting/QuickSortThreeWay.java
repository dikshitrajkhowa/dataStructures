package sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * Three way quicksort implementation, used when there are lots of duplicate
 * keys
 * 
 * Let v be partitioning item a[lo].
	Scan i from left to right.
		– (a[i] < v): exchange a[lt] with a[i]; increment both lt and i
		– (a[i] > v): exchange a[gt] with a[i]; decrement gt
		– (a[i] == v): increment i
 * 
 * 
 * 
 */
public class QuickSortThreeWay {

	public static void sort(Comparable[] data) {
		sort(data,0,data.length-1);
		
	}
	public static void sort(Comparable[] a, int lo, int hi) {
		
		if(hi <= lo) return;
		int lt = lo, gt = hi;
		Comparable v = a[lo];
		int i = lo;
		
		while( i <=gt)
		{
			int cmp = a[i].compareTo(v);
			if (cmp < 0) exch(a, lt++, i++);
			else if (cmp > 0) exch(a, i, gt--);
			else i++;
		}
	}

	private static void exch(Comparable[] data, int i, int j) {
		Comparable temp =data[i];
		data[i] =data[j];
		data[j] =temp;
		
		
	}

	public static void main(String[] args) {
//		Integer data[ ] = new Integer[10];
//		Random rand = new Random( );
//		rand.setSeed(System.currentTimeMillis( ));
//		for (int i = 0; i < data.length; i++) {
//			data[i] = rand.nextInt(100);
//		}
//		
		
		String [] data = {"A","B","C","D","P","P","P","P","P","V","W","Y","Z","X"};

		System.out.println("Initial :: "+Arrays.toString(data));
		sort(data);
		System.out.println("Sorted  :: "+Arrays.toString(data));

	}

	

}
