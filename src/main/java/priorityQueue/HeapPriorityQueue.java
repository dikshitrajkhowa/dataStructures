package priorityQueue;

import java.util.Comparator;

import listADT.ArrayList;
import listADT.DynamicArrayList;
import listADT.List;

public class HeapPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {

	protected List<Entry<K,V>> heap = new DynamicArrayList<>( );
	
	public HeapPriorityQueue() {
		super();
	}
	
	public HeapPriorityQueue(Comparator<K> comp) {
		super(comp);
	}
	
	protected int parent(int j) {
		return (j - 1) / 2;
	}
	
	protected int left(int j) {
		return 2 * j + 1;
	}
	
	protected int right(int j) {
		return 2 * j + 2;
	}
	
	protected boolean hasLeft(int j) {
		return left(j) < heap.size();
	}
	
	protected boolean hasRight(int j) {
		return right(j) < heap.size();
	}
	
	protected void swap(int i, int j){
		Entry<K,V> temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}
	
	/** Moves the entry at index j higher, if necessary, to restore the heap property. */
	protected void upheap(int j) {
		while (j > 0) // continue until reaching root (or break statement)
		{
			int p = parent(j);
			if (compare(heap.get(j), heap.get(p)) >= 0)
				break; // heap property verified
			swap(j, p);
			j = p;
		}
	}
	
	/** Moves the entry at index j lower, if necessary, to restore the heap property. */
	protected void downheap(int j){
		while (hasLeft(j)){ // continue to bottom (or break statement)
			int leftIndex = left(j);
			int smallChildIndex = leftIndex; //although right may be smaller
			if (hasRight(j)){
				int rightIndex = right(j);
				if (compare(heap.get(leftIndex), heap.get(rightIndex)) > 0)
				{
					smallChildIndex = rightIndex;
				}
				
			}
			
			if (compare(heap.get(smallChildIndex), heap.get(j)) >= 0)
			{
				break;//heap property has been restored
			}
			
			swap(j, smallChildIndex);
			j = smallChildIndex; // continue at position of the child
		}
	}
	
	@Override
	public int size() {
		return heap.size();
	}

	@Override
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		checkKey(key);
		Entry<K,V> newItem = new PQEntry<>(key,value);
		heap.add(heap.size(), newItem);// add to the end of the list
		upheap(heap.size()-1); // upheap newly added entry
		
		return newItem;
		
	}

	@Override
	public Entry<K, V> min() {
		if(heap.isEmpty()) return null;
		return heap.get(0);
	}

	@Override
	public Entry<K, V> removeMin() {
		Entry<K, V> min = heap.get(0);
		swap(0, heap.size()-1); //put minimum item at the end
		heap.remove(heap.size()-1); // remove the min from the list
		downheap(0);//fix the root
		
		
		return min;
	}
	
	/** Creates a priority queue initialized with the given key-value pairs. */
	public HeapPriorityQueue(K[] keys, V[] values) {
		super();
		for (int j = 0; j < Math.min(keys.length, values.length); j++)
			heap.add(heap.size(),new PQEntry<>(keys[j], values[j]));
		heapify();
	}

	/** Performs a bottom-up construction of the heap in linear time. */
	protected void heapify( ) { int startIndex = parent(size( )-1); // start at PARENT of last entry
	for (int j=startIndex; j >= 0; j--) // loop until processing the root
	downheap(j);
	}
	

}
