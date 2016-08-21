package list.testsuite.linkedList;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import list.LinkedList;

public class LinkedListRemovingExceptionTests {

	LinkedList<Integer> ll;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void removingIntegerItemEmptyListThrowsIndexOutOfBoundsException() {
		ll = new LinkedList<Integer>();
		ll.add(1);
		ll.remove(0);

		// ll.get(0) does not exist
		thrown.expect(IndexOutOfBoundsException.class);
		ll.remove(0);

		assertEquals(0, ll.size());
	}

	@Test
	public void removingIntegerItemNegativeIndexThrowsIndexOutOfBoundsException() {
		ll = new LinkedList<Integer>();
		ll.add(1);

		thrown.expect(IndexOutOfBoundsException.class);
		ll.remove(-1);

		assertEquals(1, ll.size());
	}

	@Test
	public void removingIntegerItemIndexTooLargeThrowsIndexOutOfBoundsException1() {
		ll = new LinkedList<Integer>();
		ll.add(1);

		thrown.expect(IndexOutOfBoundsException.class);
		ll.remove(1);

		assertEquals(1, ll.size());
	}

	@Test
	public void removingIntegerItemIndexTooLargeThrowsIndexOutOfBoundsException2() {
		ll = new LinkedList<Integer>();
		ll.add(1);
		ll.add(1123);
		ll.add(1431);

		thrown.expect(IndexOutOfBoundsException.class);
		ll.remove(3);

		assertEquals(3, ll.size());
	}
}
