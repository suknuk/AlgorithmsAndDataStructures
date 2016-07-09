package hashTable;

public class HashTable<K,V> {

	private final static int TABLE_SIZE = 128;
	
	HashEntry[] table;
	
	HashTable(){
	}
	
	private class HashEntry{
		
		K key;
		V value;
		
		private HashEntry(){
		}
		
		HashEntry(K key,V value){
			this.key = key;
			this.value = value;
		}
		
		K getKey(){
			return this.key;
		}
		
		V getValue(){
			return this.value;
		}
	}
	
}
