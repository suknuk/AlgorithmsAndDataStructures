package linkedList.testsuite;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import linkedList.LinkedList;

public class LinkedListReverseTests {

	LinkedList<Integer> ll;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void reverseEmptyObjectList() {
		ll = new LinkedList<Integer>();
		ll.reverseList();

		assertEquals(0, ll.size());

		thrown.expect(IndexOutOfBoundsException.class);
		ll.get(0);
	}

	@Test
	public void reverseSingleIntegerItemList() {
		ll = new LinkedList<Integer>();
		ll.add(1);
		ll.reverseList();

		assertEquals(Integer.valueOf(1), ll.get(0));
		assertEquals(1, ll.size());
	}

	@Test
	public void reverseTwoIntegerItemsList() {
		ll = new LinkedList<Integer>();
		ll.add(1);
		ll.add(2);
		ll.reverseList();

		assertEquals(Integer.valueOf(2), ll.get(0));
		assertEquals(Integer.valueOf(1), ll.get(1));
		assertEquals(2, ll.size());
	}

	@Test
	public void reverseManyIntegerItemsList() {
		ll = new LinkedList<Integer>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		ll.add(6);

		ll.reverseList();

		assertEquals(Integer.valueOf(6), ll.get(0));
		assertEquals(Integer.valueOf(5), ll.get(1));
		assertEquals(Integer.valueOf(4), ll.get(2));
		assertEquals(Integer.valueOf(3), ll.get(3));
		assertEquals(Integer.valueOf(2), ll.get(4));
		assertEquals(Integer.valueOf(1), ll.get(5));
		assertEquals(6, ll.size());
	}

}
