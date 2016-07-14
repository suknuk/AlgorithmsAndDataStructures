package hashMap;

public class HashMapChained implements HashMap {

	HashEntry[] map;

	private float threshold = 0.75f;
	/*
	 * Is 96 if DEFAULT_TABLE_SIZE is 128
	 */
	private int maxSize = (int)(HashMap.DEFAULT_TABLE_SIZE * this.threshold);
	private int size = 0;

	/*
	 * Constructor
	 */
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

	private void resize() {
		HashEntry[] oldMap = this.map;
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
				HashEntry tmp = oldMap[i];
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
	public String get(int key) {
		int hash = (key % this.map.length);
		if (this.map[hash] == null) {
			throw new NullPointerException();
		}
		/*
		 * Entry without chaining
		 */
		if (this.map[hash].getNext() == null) {
			/*
			 * Checking if the entry has the same key and not just the same hash
			 */
			if (this.map[hash].getKey() == key) {
				return this.map[hash].getValue();
			} else {
				throw new NullPointerException();
			}
			/*
			 * Chained entries
			 */
		} else {
			HashEntry tmp = this.map[hash];
			while (tmp.getNext() != null && tmp.getKey() != key) {
				tmp = tmp.getNext();
			}
			if (tmp.getKey() == key) {
				return tmp.getValue();
			} else {
				throw new NullPointerException();
			}
		}
	}

	/*
	 * Putting the value with a key into the hashmap
	 */
	public void put(int key, String value) {
		/*
		 * Reducing hash to fit in the table
		 */
		int hash = (key % this.map.length);
		/*
		 * No entry at the position found
		 */
		if (this.map[hash] == null) {
			this.map[hash] = new HashEntry(key, value);
			this.size++;
		} else {
			/*
			 * Entry already exists in this position, we hence seek the end of
			 * the list
			 */
			HashEntry tmp = this.map[hash];
			while (tmp.getNext() != null) {
				tmp = tmp.getNext();
			}
			if (tmp.getKey() == key) {
				tmp.setValue(value);
			} else {
				tmp.setNext(new HashEntry(key, value));
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
	public void remove(int key) {
		int hash = (key % this.map.length);
		if (this.map[hash] == null) {
			throw new NullPointerException();
		}
		/*
		 * Entry without chaining -> we can delete without worrying about the
		 * entries with the same hash
		 */
		if (this.map[hash].getNext() == null) {
			if (this.map[hash].getKey() == key) {
				this.map[hash] = null;
				this.size--;
			} else {
				throw new NullPointerException();
			}
		} else {
			/*
			 * case 1: entry is the first item in the chain
			 */
			if (this.map[hash].getKey() == key) {
				this.map[hash] = this.map[hash].getNext();
			} else {
				HashEntry tmp = this.map[hash];
				HashEntry tmpParent = null;
				while (tmp.getNext() != null && tmp.getKey() != key) {
					tmpParent = tmp;
					tmp = tmp.getNext();
				}
				/*
				 * case 2: end of chained list and entry with key was not found
				 */
				if (tmp.getNext() == null && tmp.getKey() != key) {
					throw new NullPointerException();
				}
				/*
				 * case 3: entry with key was found, hence tmp is entry with
				 * corresponding key
				 */
				else if (tmp.getKey() == key) {
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
	private class HashEntry {

		int key;
		String value;
		HashEntry next;

		HashEntry(int key, String value) {
			this.key = key;
			this.value = value;
		}

		int getKey() {
			return this.key;
		}

		void setValue(String value) {
			this.value = value;
		}

		String getValue() {
			return this.value;
		}

		void setNext(HashEntry next) {
			this.next = next;
		}

		HashEntry getNext() {
			return this.next;
		}
	}
}
