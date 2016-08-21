package list.testsuite.linkedList;

import static org.junit.Assert.*;

import org.junit.Test;

import list.LinkedList;

public class LinkedListPushTests {

	LinkedList<Integer> ll;

	@Test
	public void pushSingleIntegerItem() {
		ll = new LinkedList<Integer>();
		ll.push(1);

		assertEquals(Integer.valueOf(1), ll.get(0));
		assertEquals(1, ll.size());
	}

	@Test
	public void pushMultipleIntegerItems() {
		ll = new LinkedList<Integer>();
		ll.push(1);
		ll.push(2);
		ll.push(3);

		assertEquals(Integer.valueOf(3), ll.get(0));
		assertEquals(Integer.valueOf(2), ll.get(1));
		assertEquals(Integer.valueOf(1), ll.get(2));
		assertEquals(3, ll.size());
	}

}
