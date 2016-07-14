package hashMap;

public class HashMap {

	private final static int DEFAULT_TABLE_SIZE = 128;

	HashEntry[] table;

	// Constructor
	public HashMap() {
		table = new HashEntry[DEFAULT_TABLE_SIZE];
		for (int i = 0; i < table.length; i++) {
			table[i] = null;
		}
	}

	// Returning value from key position
	public String get(int key) {
		int hash = (key % table.length);
		if (table[hash] == null) {
			throw new NullPointerException();
		}
		if (table[hash].getNext() == null) {
			return table[hash].getValue();
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

	public void put(int key, String value) {
		// Reducing hash to fit in the table
		int hash = (key % table.length);
		System.out.println("hash : " + hash + ", key : " + key + ", value : " + value);
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

	// Class to store the elements
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
