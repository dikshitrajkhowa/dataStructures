package recursion;

public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] data ={3,4,5,6,7,8,9,10,11,12,13,14,25,36,38};
		System.out.println(binarySearch(data, 25, 0, data.length));
		

	}

	public static boolean binarySearch(int[ ] data, int target, int low, int high) {
		if (low > high)
		{
			return false;
		}else
		{
			int mid = (low + high) / 2;
			if (target == data[mid])
			{
				return true;
			}else if (target < data[mid])
			{
				return binarySearch(data, target, low, mid - 1); // recur left of the middle
			}else
			{
				return binarySearch(data, target, mid + 1, high); // recur right of the middle
			}
		}
	}
}
