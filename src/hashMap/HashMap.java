package hashMap;

public class HashMap {

	private final static int DEFAULT_TABLE_SIZE = 128;

	HashEntry[] table;

	/*
	 * Constructor
	 */
	public HashMap() {
		table = new HashEntry[DEFAULT_TABLE_SIZE];
		for (int i = 0; i < table.length; i++) {
			table[i] = null;
		}
	}

	/*
	 * Returning value from key position
	 */
	public String get(int key) {
		int hash = (key % table.length);
		if (table[hash] == null) {
			throw new NullPointerException();
		}
		/*
		 * Entry without chaining
		 */
		if (table[hash].getNext() == null) {
			/*
			 * Checking if the entry has the same key and not just the same hash
			 */
			if (table[hash].getKey() == key) {
				return table[hash].getValue();
			} else {
				throw new NullPointerException();
			}
			/*
			 * Chained entries
			 */
		} else {
			HashEntry tmp = table[hash];
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
		int hash = (key % table.length);
		/*
		 * No entry at the position found
		 */
		if (table[hash] == null) {
			table[hash] = new HashEntry(key, value);
		} else {
			/*
			 * Entry already exists in this position, we hence seek the end of
			 * the list
			 */
			HashEntry tmp = table[hash];
			while (tmp.getNext() != null) {
				tmp = tmp.getNext();
			}
			if (tmp.getKey() == key) {
				tmp.setValue(value);
			} else {
				tmp.setNext(new HashEntry(key, value));
			}
		}
	}

	/*
	 * removing Entry with key 'key'
	 */
	public void remove(int key) {
		int hash = (key % table.length);
		if (table[hash] == null) {
			throw new NullPointerException();
		}
		/*
		 * Entry without chaining -> we can delete without worrying about the
		 * entries with the same hash
		 */
		if (table[hash].getNext() == null) {
			if (table[hash].getKey() == key) {
				table[hash] = null;
			} else {
				throw new NullPointerException();
			}
		} else {
			/*
			 * case 1: entry is the first item in the chain
			 */
			if (table[hash].getKey() == key) {
				table[hash] = table[hash].getNext();
			} else {
				HashEntry tmp = table[hash];
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
			}
		}
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
