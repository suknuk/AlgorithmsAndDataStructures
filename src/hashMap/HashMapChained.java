package hashMap;

public class HashMapChained<K, V> implements HashMap<K, V> {

	HashEntry<K, V>[] map;

	private float threshold = 0.75f;
	/*
	 * Is 96 if DEFAULT_TABLE_SIZE is 128
	 */
	private int maxSize = (int) (HashMap.DEFAULT_TABLE_SIZE * this.threshold);
	private int size = 0;

	/*
	 * Constructor
	 */
	@SuppressWarnings("unchecked")
	public HashMapChained() {
		this.map = new HashEntry[DEFAULT_TABLE_SIZE];
	}

	public HashMapChained(float threshold) {
		this();
		this.threshold = threshold;
	}

	/*
	 * Setting the threshold
	 */
	public void setThreshold(float threshold) {
		this.threshold = threshold;
	}

	/*
	 * Calculating a hash key
	 */
	public int hash(K key) {
		return Math.abs(key.hashCode() % this.map.length);
	}

	@SuppressWarnings("unchecked")
	private void resize() {
		HashEntry<K, V>[] oldMap = this.map;
		/*
		 * New map has 2 x the size
		 */
		int newTableSize = this.map.length * 2;
		this.maxSize = (int) (this.threshold * newTableSize);
		this.size = 0;
		this.map = new HashEntry[newTableSize];

		/*
		 * Copying all chained HashEntries into the new table
		 */
		for (int i = 0; i < oldMap.length; i++) {
			if (oldMap[i] != null) {
				HashEntry<K, V> tmp = oldMap[i];
				while (tmp != null) {
					this.put(tmp.getKey(), tmp.getValue());
					tmp = tmp.getNext();
				}
			}
		}
	}

	/*
	 * Returning value from key position
	 */
	public V get(K key) {
		int hash = this.hash(key);
		if (this.map[hash] == null) {
			throw new NullPointerException();
		}
		/*
		 * Iterating over chained list until we find or not find the Entry
		 */
		else {
			HashEntry<K, V> tmp = this.map[hash];
			while (tmp.getNext() != null && (tmp.getKey().equals(key) == false)) {
				tmp = tmp.getNext();
			}
			if (tmp.getKey().equals(key)) {
				return tmp.getValue();
			} else {
				throw new NullPointerException();
			}
		}
	}

	/*
	 * Putting the value with a key into the hashmap
	 */
	public void put(K key, V value) {
		/*
		 * Reducing hash to fit in the table
		 */
		int hash = this.hash(key);
		/*
		 * No entry at the position found
		 */
		if (this.map[hash] == null) {
			this.map[hash] = new HashEntry<K, V>(key, value);
			this.size++;
		} else {
			/*
			 * Entry already exists in this position, we hence seek the end of
			 * the list
			 */
			HashEntry<K, V> tmp = this.map[hash];
			while (tmp.getNext() != null) {
				tmp = tmp.getNext();
			}
			if (tmp.getKey().equals(key)) {
				tmp.setValue(value);
			} else {
				tmp.setNext(new HashEntry<K, V>(key, value));
				this.size++;
			}
		}
		if (this.size >= this.maxSize) {
			this.resize();
		}
	}

	/*
	 * removing Entry with key 'key'
	 */
	public void remove(K key) {
		int hash = this.hash(key);
		if (this.map[hash] == null) {
			throw new NullPointerException();
		}
		/*
		 * Entry without chaining -> we can delete without worrying about the
		 * entries with the same hash
		 */
		if (this.map[hash].getNext() == null) {
			if (this.map[hash].getKey().equals(key)) {
				this.map[hash] = null;
				this.size--;
			} else {
				throw new NullPointerException();
			}
		} else {
			/*
			 * case 1: entry is the first item in the chain
			 */
			if (this.map[hash].getKey().equals(key)) {
				this.map[hash] = this.map[hash].getNext();
			} else {
				HashEntry<K, V> tmp = this.map[hash];
				HashEntry<K, V> tmpParent = null;
				while (tmp.getNext() != null && (tmp.getKey().equals(key) == false)) {
					tmpParent = tmp;
					tmp = tmp.getNext();
				}
				/*
				 * case 2: end of chained list and entry with key was not found
				 */
				if (tmp.getNext() == null && (tmp.getKey().equals(key) == false)) {
					throw new NullPointerException();
				}
				/*
				 * case 3: entry with key was found, hence tmp is entry with
				 * corresponding key
				 */
				else if (tmp.getKey().equals(key)) {
					tmpParent.setNext(tmp.getNext());
				}
				this.size--;
			}
		}
	}

	public int getSize() {
		return this.size;
	}

	public int getMapSize() {
		return this.map.length;
	}

	/*
	 * Class to store the entries
	 */
	static class HashEntry<K, V> {

		K key;
		V value;
		HashEntry<K, V> next;

		HashEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		K getKey() {
			return this.key;
		}

		void setValue(V value) {
			this.value = value;
		}

		V getValue() {
			return this.value;
		}

		void setNext(HashEntry<K, V> next) {
			this.next = next;
		}

		HashEntry<K, V> getNext() {
			return this.next;
		}
	}
}
