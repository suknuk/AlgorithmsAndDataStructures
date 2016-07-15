package hashMap.testsuite;

import static org.junit.Assert.*;

import org.junit.Test;

import hashMap.HashMapChained;


public class HashMapChainedPutGetTests {

	HashMapChained<Integer,String> map;

	@Test
	public void hashMapPutAndGetTest() {
		map = new HashMapChained<Integer,String>();
		String e1 = "hello";
		String e2 = "my";
		String e3 = "dear";
		map.put(e1.hashCode(), e1);
		map.put(e2.hashCode(), e2);
		map.put(e3.hashCode(), e3);

		assertEquals("hello", map.get(e1.hashCode()));
		assertEquals("my", map.get(e2.hashCode()));
		assertEquals("dear", map.get(e3.hashCode()));

	}

	@Test
	public void hashMapPutAndGetSameHashTest() {
		map = new HashMapChained<Integer,String>();
		String e1 = "hello";
		String e2 = "my";
		String e3 = "dear";
		map.put(e1.hashCode(), e1);
		map.put(e2.hashCode(), e2);
		map.put(e3.hashCode(), e3);

		// e2 has hash 3500, reduced to 44
		String e22 = "double";
		int e22_key = 44;

		map.put(e22_key, e22);

		assertEquals("double", map.get(e22_key));
		assertEquals("my", map.get(e2.hashCode()));
	}

}
