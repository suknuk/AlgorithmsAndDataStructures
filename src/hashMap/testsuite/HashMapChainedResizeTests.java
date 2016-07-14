package hashMap.testsuite;

import static org.junit.Assert.*;

import org.junit.Test;

import hashMap.HashMap;
import hashMap.HashMapChained;

public class HashMapChainedResizeTests {

	HashMapChained map;

	@Test
	public void hashMapRemoveNoChaningTest() {
		map = new HashMapChained();
		/*
		 * Inserting 95 entries, as the default threshold is 0.75 with 128
		 * default array size. The table should hence resize at 96
		 */
		for (int i = 0; i < 95; i++) {
			map.put(i, "" + i);
		}

		/*
		 * Should be 95 entries and array[128]
		 */
		assertEquals(95, map.getSize());
		assertEquals(128, map.getMapSize());

		map.put(96, "96");
		assertEquals(96, map.getSize());
		/*
		 * Should be 96 entries and array[256]
		 */
		assertEquals(96, map.getSize());
		assertEquals(256, map.getMapSize());
	}

	@Test
	public void hashMapRemoveChainedEntriesTest() {
		map = new HashMapChained();
		/*
		 * Inserting 95 entries, all with the same hash. The calculation of
		 * i*map.getMapSize() will always give the hash of 0, hence all entries
		 * should be at map[0]
		 */
		for (int i = 0; i < 95; i++) {
			map.put(i * HashMap.DEFAULT_TABLE_SIZE, "" + i);
		}

		/*
		 * Should be 95 entries and array[128]
		 */
		assertEquals(95, map.getSize());
		assertEquals(128, map.getMapSize());

		map.put(95 * map.getMapSize(), "95");
		assertEquals(96, map.getSize());
		/*
		 * Should be 96 entries and array[256]
		 */
		assertEquals(96, map.getSize());
		assertEquals(256, map.getMapSize());

		/*
		 * Testing the access for some variables
		 */
		assertEquals("0", map.get(0));
		assertEquals("10", map.get(10*HashMap.DEFAULT_TABLE_SIZE));
		assertEquals("95", map.get(95*HashMap.DEFAULT_TABLE_SIZE));
	}

}
