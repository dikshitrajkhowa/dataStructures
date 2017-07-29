package iteratorImplementation2;

public class MyContainerIterator implements Iterator {

	private int current = 0;
	private MyContainer container;

	MyContainerIterator(MyContainer c) {
		container = c;
	}

	@Override
	public boolean hasNext() {
		return current < container.size;
	}

	@Override
	public Object next() {
		return container.items[ current++ ];
	}

}
