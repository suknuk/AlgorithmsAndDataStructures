package list.testsuite.linkedList;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import list.LinkedList;

public class LinkedListSizeTests {

	LinkedList<Integer> ll;

	// Testing List length
	@Test
	public void listSizeNoItem() {
		ll = new LinkedList<Integer>();

		assertEquals(0, ll.size());
	}

	@Test
	public void listSizeOneIntegerItem() {
		ll = new LinkedList<Integer>();
		ll.add(1);

		assertEquals(1, ll.size());
	}

	@Test
	public void listSizeMultipleIntegerItems() {
		ll = new LinkedList<Integer>();
		ll.add(1);
		ll.add(2);
		ll.add(3);

		assertEquals(3, ll.size());
	}

	@Test
	public void listSizeAddingAndDeletingIntegerItems1() {
		ll = new LinkedList<Integer>();
		ll.add(1);
		ll.add(2);
		ll.add(3);

		ll.remove(0);
		ll.remove(0);
		ll.remove(0);

		assertEquals(0, ll.size());
	}

	@Test
	public void listSizeAddingAndDeletingIntegerItems2() {
		ll = new LinkedList<Integer>();
		ll.add(1);
		ll.add(2);
		ll.add(3);

		ll.remove(0);
		ll.remove(0);

		assertEquals(1, ll.size());
	}

	@Test
	public void listSizeAddingAndDeletingIntegerItems3() {
		ll = new LinkedList<Integer>();
		ll.add(1);
		ll.add(2);
		ll.remove(0);
		ll.remove(0);
		ll.add(1);

		assertEquals(1, ll.size());
	}
}
