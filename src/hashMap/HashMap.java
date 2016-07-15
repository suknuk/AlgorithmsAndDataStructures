package hashMap;

public interface HashMap<K,V> {

	final static int DEFAULT_TABLE_SIZE = 128;
	
	/*
	 * Returning value from key position
	 */
	public V get(K key);

	/*
	 * Putting the value with a key into the hashmap
	 */
	public void put(K key, V value);

	/*
	 * removing Entry with key 'key'
	 */
	public void remove(K key);
	
	/*
	 * Setting the threshold
	 */
	public void setThreshold(float threshold);
	
	/*
	 * Size of the array
	 */
	public int getSize();

}
