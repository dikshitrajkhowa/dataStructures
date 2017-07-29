package maps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnsortedTableMap<K, V> extends AbstractMap<K, V> {

	/** Underlying storage for the map of entries. */
	private ArrayList<MapEntry<K, V>> table = new ArrayList<>();

	/** Constructs an initially empty map. */
	public UnsortedTableMap() {
	}

	/** Returns the index of an entry with equal key, or -1 if none found. */
	private int findIndex(K key) {
		int n = table.size();

		for (int j = 0; j < n; j++) {
			if (table.get(j).getKey().equals(key))
				return j;
		}

		return -1;
	}

	@Override
	public int size() {
		return table.size();
	}

	@Override
	public V get(K key) {
		int position = findIndex(key);
		if (position == -1)
			return null;

		return table.get(position).getValue();

	}

	@Override
	public V put(K key, V value) {

		int position = findIndex(key);
		if (position == -1) {
			table.add(new MapEntry<>(key, value));
			return null;
		} else {
			return table.get(position).setValue(value);
		}

	}

	/** Removes the entry with the specified key (if any) and returns its value. */
	@Override
	public V remove(K key) {
		int j = findIndex(key);
		int n = size();
		if (j == -1)
			return null;
		V answer = table.get(j).getValue();

		if (j != n - 1) {
			table.set(j, table.get(n - 1));// relocate last entry to ’hole’
											// created by removal
		}

		table.remove(n - 1);// remove last entry of table

		return answer;

	}

	private class EntryIterable implements Iterable<Entry<K, V>> {

		@Override
		public Iterator<Entry<K, V>> iterator() {
			return new EntryIterator();
		}

	}

	private class EntryIterator implements Iterator<Entry<K, V>> {

		private int j = 0;

		@Override
		public boolean hasNext() {
			return j < table.size();
		}

		@Override
		public Entry<K, V> next() {
			if (j == table.size())
				throw new NoSuchElementException();
			return table.get(j++);
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();

		}

	}

	@Override
	public Iterable<maps.Entry<K, V>> entrySet() {
		return new EntryIterable( );
	}
}
