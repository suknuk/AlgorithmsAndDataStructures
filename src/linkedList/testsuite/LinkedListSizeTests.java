package linkedList.testsuite;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import linkedList.LinkedList;

public class LinkedListSizeTests {

	LinkedList ll;

	// Testing List length
	@Test
	public void listSizeNoItem() {
		ll = new LinkedList();

		assertEquals(0, ll.size());
	}

	@Test
	public void listSizeOneItem() {
		ll = new LinkedList();
		ll.add(1);

		assertEquals(1, ll.size());
	}

	@Test
	public void listSizeMultipleItems() {
		ll = new LinkedList();
		ll.add(1);
		ll.add(2);
		ll.add(3);

		assertEquals(3, ll.size());
	}

	@Test
	public void listSizeAddingAndDeletingItems1() {
		ll = new LinkedList();
		ll.add(1);
		ll.add(2);
		ll.add(3);

		ll.remove(0);
		ll.remove(0);
		ll.remove(0);

		assertEquals(0, ll.size());
	}

	@Test
	public void listSizeAddingAndDeletingItems2() {
		ll = new LinkedList();
		ll.add(1);
		ll.add(2);
		ll.add(3);

		ll.remove(0);
		ll.remove(0);

		assertEquals(1, ll.size());
	}

	@Test
	public void listSizeAddingAndDeletingItems3() {
		ll = new LinkedList();
		ll.add(1);
		ll.add(2);
		ll.remove(0);
		ll.remove(0);
		ll.add(1);

		assertEquals(1, ll.size());
	}
}
