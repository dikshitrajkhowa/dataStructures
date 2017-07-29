package maps;


public interface Map<K, V> {
	
	int size();

	boolean isEmpty();

	V get(K key);

	/**
	 * If M does not have an entry with key equal to k, 
	 * then adds entry (k,v) to M and returns null; 
	 * else, replaces with v the existing value of the entry 
	 * with key equal to k and returns the old value.
	 */
	V put(K key, V value);

	V remove(K key);

	Iterable<K> keySet();

	Iterable<V> values();

	Iterable<Entry<K, V>> entrySet();
}