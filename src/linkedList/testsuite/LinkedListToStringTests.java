package linkedList.testsuite;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import linkedList.LinkedList;

public class LinkedListToStringTests {
	LinkedList<Integer> ll;

	@Test
	public void emptyObjectListString() {
		ll = new LinkedList<Integer>();

		assertEquals(null, ll.toString());
	}

	@Test
	public void singleIntegerItemString() {
		ll = new LinkedList<Integer>();
		ll.push(1);
		assertEquals("[1]", ll.toString());
	}

	@Test
	public void multipleIntegerItemsString() {
		ll = new LinkedList<Integer>();
		ll.push(1);
		ll.push(3);
		ll.push(2);
		assertEquals("[2],[3],[1]", ll.toString());
	}
}
