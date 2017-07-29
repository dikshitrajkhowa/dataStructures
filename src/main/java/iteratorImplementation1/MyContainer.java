package iteratorImplementation1;

import org.apache.log4j.Logger;

/**
 * Demo of a simple collection class with an iterator
 * 
 * @author dikshit.rajkhowa
 * 
 */
public class MyContainer {

	final static Logger logger = Logger.getLogger(MyContainer.class);
	
	Object[] items;
	int size;
	int cursor;

	//construct a container with default n elements capacity
	public MyContainer() {
		this.size = 3;
		items = new Object[size];
		cursor = 0;
		
		
	}

	// simply reject if the array is full
	public void add(Object obj) {

		if (cursor == size) {
			logger.info("Resizing container from "+size+" to "+size*2);
			resize();
		}

		items[cursor] = obj;
		cursor++;

	}

	private void resize() {

		Object[] itemsNew = new Object[size * 2];

//		for (int i = 0; i < size; i++) {
//			itemsNew[i] = items[i];
//			items[i] = null;
//		}
		
		System.arraycopy(items, 0, itemsNew, 0, size);
		
		items = itemsNew;
		itemsNew = null;
		size = size * 2;

	}

	public MyContainerIterator iterator() {
		{
			return new MyContainerIterator(this);
		}
	}
}
