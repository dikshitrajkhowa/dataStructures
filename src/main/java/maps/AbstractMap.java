package maps;

import java.util.Iterator;

public abstract class AbstractMap<K, V> implements Map<K, V> {

	public boolean isEmpty() {
		return size() == 0;
	}

	// Support for public keySet method
	private class KeyIterator implements Iterator<K> {

		private Iterator<Entry<K, V>> entries = entrySet().iterator();

		@Override
		public boolean hasNext() {
			return entries.hasNext();
		}

		@Override
		public K next() {
			return entries.next().getKey();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private class KeyIterable implements Iterable<K> {
		public Iterator<K> iterator() {
			return new KeyIterator();
		}
	}

	public Iterable<K> keySet() {
		return new KeyIterable();
	}

	// Support for public values method...
	private class ValueIterator implements Iterator<V> {
		private Iterator<Entry<K, V>> entries = entrySet().iterator(); //

		public boolean hasNext() {
			return entries.hasNext();
		}

		public V next() {
			return entries.next().getValue();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private class ValueIterable implements Iterable<V> {

		@Override
		public Iterator<V> iterator() {
			return new ValueIterator();
		}
	}

	public Iterable<V> values() {
		return new ValueIterable();
	}

	// ---------------- nested MapEntry class ----------------

	protected static class MapEntry<K, V> implements Entry<K, V> {

		private K key; // key
		private V value; // value

		public MapEntry(K k, V v) {
			key = k;
			value = v;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		// utilities not exposed as part of the Entry interface
		protected void setKey(K k) {
			key = k;
		}

		protected V setValue(V val) {
			V old = value;
			value = val;
			return old;
		}

	}
}
