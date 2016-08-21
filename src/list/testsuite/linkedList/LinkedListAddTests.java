package list.testsuite.linkedList;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import list.LinkedList;

public class LinkedListAddTests {

	LinkedList<Integer> ll;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	// Adding single item
	@Test
	public void addIntegerItemToList() {
		ll = new LinkedList<Integer>();
		ll.add(1);
		assertEquals(Integer.valueOf(1), ll.get(0));
	}

	// Adding multiple items
	@Test
	public void addIntegerItemsToList() {
		ll = new LinkedList<Integer>();
		ll.add(1);
		ll.add(2);
		ll.add(3);

		assertEquals(Integer.valueOf(1), ll.get(0));
		assertEquals(Integer.valueOf(2), ll.get(1));
		assertEquals(Integer.valueOf(3), ll.get(2));
	}

	// Testing the add(Obj, index) function
	@Test
	public void addIntegerItemsWithIndexToList1() {
		ll = new LinkedList<Integer>();
		ll.add(1, 0);

		assertEquals(Integer.valueOf(1), ll.get(0));
		assertEquals(1, ll.size());
	}

	@Test
	public void addIntegerItemsWithIndexToList2() {
		ll = new LinkedList<Integer>();
		ll.add(1, 0);
		ll.add(2, 0);
		ll.add(3, 0);

		assertEquals(Integer.valueOf(3), ll.get(0));
		assertEquals(Integer.valueOf(2), ll.get(1));
		assertEquals(Integer.valueOf(1), ll.get(2));
		assertEquals(3, ll.size());
	}

	@Test
	public void addIntegerItemsWithIndexToList3() {
		ll = new LinkedList<Integer>();
		ll.add(1);
		ll.add(2);
		ll.add(3, 1);

		assertEquals(Integer.valueOf(1), ll.get(0));
		assertEquals(Integer.valueOf(3), ll.get(1));
		assertEquals(Integer.valueOf(2), ll.get(2));
		assertEquals(3, ll.size());
	}

	@Test
	public void addIntegerItemsWithIndexToEndOfList() {
		ll = new LinkedList<Integer>();
		ll.add(1);
		ll.add(2);
		ll.add(3, 2);

		assertEquals(Integer.valueOf(1), ll.get(0));
		assertEquals(Integer.valueOf(2), ll.get(1));
		assertEquals(Integer.valueOf(3), ll.get(2));
		assertEquals(3, ll.size());
	}

	// Adding object to negative index
	@Test
	public void addIntegerItemWithNegativeIndexThrowsIndexOutOfBoundsException() {
		ll = new LinkedList<Integer>();
		ll.add(1);
		ll.add(2);

		thrown.expect(IndexOutOfBoundsException.class);
		ll.add(3, -1);

		assertEquals(2, ll.size());
	}

	// Adding object to negative index
	@Test
	public void addIntegerItemWithTooLargeIndexThrowsIndexOutOfBoundsException() {
		ll = new LinkedList<Integer>();
		ll.add(1);
		ll.add(2);

		thrown.expect(IndexOutOfBoundsException.class);
		ll.add(3, 3);

		assertEquals(2, ll.size());
	}

}
