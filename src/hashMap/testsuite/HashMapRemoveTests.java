package hashMap.testsuite;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import hashMap.HashMap;

public class HashMapRemoveTests {

	HashMap table;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void hashMapRemoveNoChaningTest() {
		table = new HashMap();
		String e1 = "hello";
		String e2 = "my";
		String e3 = "dear";
		table.put(e1.hashCode(), e1);
		table.put(e2.hashCode(), e2);
		table.put(e3.hashCode(), e3);

		table.remove(e1.hashCode());

		thrown.expect(NullPointerException.class);
		assertEquals("hello", table.get(e1.hashCode()));
	}

	@Test
	public void hashMapRemoveFirstEntryInChainedListTest() {
		table = new HashMap();
		String e1 = "hello";
		String e2 = "my";
		String e3 = "dear";

		table.put(e1.hashCode(), e1);
		table.put(82, e2); // e1 has hash 82 and key 99162322
		table.put(e3.hashCode(), e3);

		table.remove(e1.hashCode());

		assertEquals("my", table.get(82));

		thrown.expect(NullPointerException.class);
		@SuppressWarnings("unused")
		String get_e1 = table.get(e1.hashCode());
	}

	@Test
	public void hashMapRemoveLastEntryInChainedListTest() {
		table = new HashMap();
		String e1 = "hello";
		String e2 = "my";
		String e3 = "dear";

		/*
		 * e1 has hash 82 and key 99162322
		 */
		table.put(e1.hashCode(), e1);
		table.put(82, e2);
		table.put(128 + 82, e3);

		table.remove(128 + 82);

		assertEquals("hello", table.get(e1.hashCode()));
		assertEquals("my", table.get(82));

		thrown.expect(NullPointerException.class);
		@SuppressWarnings("unused")
		String get_e1 = table.get(128 + 82);
	}

	@Test
	public void hashMapRemoveMiddleEntryInChainedListTest() {
		table = new HashMap();
		String e1 = "hello";
		String e2 = "my";
		String e3 = "dear";

		/*
		 * e1 has hash 82 and key 99162322
		 */
		table.put(e1.hashCode(), e1);
		table.put(82, e2);
		table.put(128 + 82, e3);

		table.remove(82);

		assertEquals("hello", table.get(e1.hashCode()));
		assertEquals("dear", table.get(128 + 82));

		thrown.expect(NullPointerException.class);
		@SuppressWarnings("unused")
		String get_e1 = table.get(82);
	}

}
