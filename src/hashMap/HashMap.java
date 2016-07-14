package hashMap;

public interface HashMap {

	final static int DEFAULT_TABLE_SIZE = 128;
	
	/*
	 * Returning value from key position
	 */
	public String get(int key);

	/*
	 * Putting the value with a key into the hashmap
	 */
	public void put(int key, String value);

	/*
	 * removing Entry with key 'key'
	 */
	public void remove(int key);
	
	/*
	 * Setting the threshold
	 */
	public void setThreshold(float threshold);
	
	/*
	 * Size of the array
	 */
	public int getSize();

}
