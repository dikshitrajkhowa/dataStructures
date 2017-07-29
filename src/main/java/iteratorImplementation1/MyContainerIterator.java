package iteratorImplementation1;

//An iterator class that steps through a MyContainer

public class MyContainerIterator {
	private int current = 0;
	private MyContainer container;

	MyContainerIterator(MyContainer c) {
		container = c;
	}

	public boolean hasNext() {
		return current < container.size;
	}

	public Object next() {
		return container.items[current++];
	}
}
