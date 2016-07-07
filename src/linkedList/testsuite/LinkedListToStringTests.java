package linkedList.testsuite;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import linkedList.LinkedList;

public class LinkedListToStringTests {
	LinkedList ll;

	@Test
	public void emptyListString() {
		ll = new LinkedList();

		assertEquals(null, ll.toString());
	}

	@Test
	public void singleItemString() {
		ll = new LinkedList();
		ll.push(1);
		assertEquals("[1]", ll.toString());
	}

	@Test
	public void multipleItemsString() {
		ll = new LinkedList();
		ll.push(1);
		ll.push(3);
		ll.push(2);
		assertEquals("[2],[3],[1]", ll.toString());
	}
}
