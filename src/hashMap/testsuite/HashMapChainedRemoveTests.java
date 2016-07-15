package hashMap.testsuite;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import hashMap.HashMapChained;

public class HashMapChainedRemoveTests {

	HashMapChained<Integer,String> map;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void hashMapRemoveNoChaningTest() {
		map = new HashMapChained<Integer,String>();
		String e1 = "hello";
		String e2 = "my";
		String e3 = "dear";
		map.put(e1.hashCode(), e1);
		map.put(e2.hashCode(), e2);
		map.put(e3.hashCode(), e3);

		map.remove(e1.hashCode());

		thrown.expect(NullPointerException.class);
		assertEquals("hello", map.get(e1.hashCode()));
	}

	@Test
	public void hashMapRemoveFirstEntryInChainedListTest() {
		map = new HashMapChained<Integer,String>();
		String e1 = "hello";
		String e2 = "my";
		String e3 = "dear";

		map.put(e1.hashCode(), e1);
		map.put(82, e2); // e1 has hash 82 and key 99162322
		map.put(e3.hashCode(), e3);

		map.remove(e1.hashCode());

		assertEquals("my", map.get(82));

		thrown.expect(NullPointerException.class);
		@SuppressWarnings("unused")
		String get_e1 = map.get(e1.hashCode());
	}

	@Test
	public void hashMapRemoveLastEntryInChainedListTest() {
		map = new HashMapChained<Integer,String>();
		String e1 = "hello";
		String e2 = "my";
		String e3 = "dear";

		/*
		 * e1 has hash 82 and key 99162322
		 */
		map.put(e1.hashCode(), e1);
		map.put(82, e2);
		map.put(128 + 82, e3);

		map.remove(128 + 82);

		assertEquals("hello", map.get(e1.hashCode()));
		assertEquals("my", map.get(82));

		thrown.expect(NullPointerException.class);
		@SuppressWarnings("unused")
		String get_e1 = map.get(128 + 82);
	}

	@Test
	public void hashMapRemoveMiddleEntryInChainedListTest() {
		map = new HashMapChained<Integer,String>();
		String e1 = "hello";
		String e2 = "my";
		String e3 = "dear";

		/*
		 * e1 has hash 82 and key 99162322
		 */
		map.put(e1.hashCode(), e1);
		map.put(82, e2);
		map.put(128 + 82, e3);

		map.remove(82);

		assertEquals("hello", map.get(e1.hashCode()));
		assertEquals("dear", map.get(128 + 82));

		thrown.expect(NullPointerException.class);
		@SuppressWarnings("unused")
		String get_e1 = map.get(82);
	}

}
