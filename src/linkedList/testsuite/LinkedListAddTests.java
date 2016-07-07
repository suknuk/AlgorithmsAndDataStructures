package linkedList.testsuite;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import linkedList.LinkedList;

public class LinkedListAddTests {

	LinkedList ll;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	// Adding single item
	@Test
	public void addItemToList() {
		ll = new LinkedList();
		ll.add(1);
		assertEquals(1, ll.get(0));
	}

	// Adding multiple items
	@Test
	public void addItemsToList() {
		ll = new LinkedList();
		ll.add(1);
		ll.add(2);
		ll.add(3);

		assertEquals(1, ll.get(0));
		assertEquals(2, ll.get(1));
		assertEquals(3, ll.get(2));
	}

	// Testing the add(Obj, index) function
	@Test
	public void addItemsWithIndexToList1() {
		ll = new LinkedList();
		ll.add(1, 0);

		assertEquals(1, ll.get(0));
		assertEquals(1, ll.size());
	}

	@Test
	public void addItemsWithIndexToList2() {
		ll = new LinkedList();
		ll.add(1, 0);
		ll.add(2, 0);
		ll.add(3, 0);

		assertEquals(3, ll.get(0));
		assertEquals(2, ll.get(1));
		assertEquals(1, ll.get(2));
		assertEquals(3, ll.size());
	}

	@Test
	public void addItemsWithIndexToList3() {
		ll = new LinkedList();
		ll.add(1);
		ll.add(2);
		ll.add(3, 1);

		assertEquals(1, ll.get(0));
		assertEquals(3, ll.get(1));
		assertEquals(2, ll.get(2));
		assertEquals(3, ll.size());
	}

	@Test
	public void addItemsWithIndexToEndOfList() {
		ll = new LinkedList();
		ll.add(1);
		ll.add(2);
		ll.add(3, 2);

		assertEquals(1, ll.get(0));
		assertEquals(2, ll.get(1));
		assertEquals(3, ll.get(2));
		assertEquals(3, ll.size());
	}

	// Adding object to negative index
	@Test
	public void addItemWithNegativeIndexThrowsIndexOutOfBoundsException() {
		ll = new LinkedList();
		ll.add(1);
		ll.add(2);

		thrown.expect(IndexOutOfBoundsException.class);
		ll.add(3, -1);

		assertEquals(2, ll.size());
	}

	// Adding object to negative index
	@Test
	public void addItemWithTooLargeIndexThrowsIndexOutOfBoundsException() {
		ll = new LinkedList();
		ll.add(1);
		ll.add(2);

		thrown.expect(IndexOutOfBoundsException.class);
		ll.add(3, 3);

		assertEquals(2, ll.size());
	}

}
