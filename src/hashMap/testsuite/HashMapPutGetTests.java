package hashMap.testsuite;

import static org.junit.Assert.*;

import org.junit.Test;

import hashMap.HashMap;

public class HashMapPutGetTests {

	HashMap table;

	@Test
	public void hashMapPutAndGetTest() {
		table = new HashMap();
		String e1 = "hello";
		String e2 = "my";
		String e3 = "dear";
		table.put(e1.hashCode(), e1);
		table.put(e2.hashCode(), e2);
		table.put(e3.hashCode(), e3);

		assertEquals("hello", table.get(e1.hashCode()));
		assertEquals("my", table.get(e2.hashCode()));
		assertEquals("dear", table.get(e3.hashCode()));

	}

	@Test
	public void hashMapPutAndGetSameHashTest() {
		table = new HashMap();
		String e1 = "hello";
		String e2 = "my";
		String e3 = "dear";
		table.put(e1.hashCode(), e1);
		table.put(e2.hashCode(), e2);
		table.put(e3.hashCode(), e3);

		// e2 has hash 3500, reduced to 44
		String e22 = "double";
		int e22_key = 44;

		table.put(e22_key, e22);

		assertEquals("double", table.get(e22_key));
		assertEquals("my", table.get(e2.hashCode()));
	}

}
