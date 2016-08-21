package list.testsuite.linkedList;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import list.LinkedList;

// The hashCode function has to always give the same result of 2 lists with the same objects in the same order
public class LinkedListEqualsAndHashCodeTests {

	LinkedList<Integer> ll1, ll2;

	@Test
	public void equalsSameObject() {
		ll1 = new LinkedList<Integer>();
		assertEquals(true, ll1.equals(ll1));
	}

	@Test
	public void equalsNullObject() {
		ll1 = new LinkedList<Integer>();
		assertEquals(false, ll1.equals(null));
	}

	@Test
	public void equalsTwoEmptyLists() {
		ll1 = new LinkedList<Integer>();
		ll2 = new LinkedList<Integer>();

		assertEquals(true, ll1.equals(ll2));
		assertEquals(true, ll2.equals(ll1));
		assertEquals(ll1.hashCode(), ll2.hashCode());
	}

	@Test
	public void equalsTwoEqualIntegerSingleItemLists() {
		ll1 = new LinkedList<Integer>();
		ll2 = new LinkedList<Integer>();

		ll1.add(1);
		ll2.add(1);

		assertEquals(true, ll1.equals(ll2));
		assertEquals(true, ll2.equals(ll1));
		assertEquals(ll1.hashCode(), ll2.hashCode());
	}

	@Test
	public void equalsTwoEqualIntegerMultipleItemLists() {
		ll1 = new LinkedList<Integer>();
		ll2 = new LinkedList<Integer>();

		ll1.add(1);
		ll1.add(2);
		ll1.add(5);
		ll1.add(22);
		ll2.add(1);
		ll2.add(2);
		ll2.add(5);
		ll2.add(22);

		assertEquals(true, ll1.equals(ll2));
		assertEquals(true, ll2.equals(ll1));
		assertEquals(ll1.hashCode(), ll2.hashCode());
	}

	@Test
	public void equalsTwoNonEqualIntegerSingleItemLists() {
		ll1 = new LinkedList<Integer>();
		ll2 = new LinkedList<Integer>();

		ll1.add(1);
		ll2.add(2);

		assertEquals(false, ll1.equals(ll2));
		assertEquals(false, ll2.equals(ll1));

		assertThat(ll1.hashCode(), is(not(ll2.hashCode())));
	}

	@Test
	public void equalsTwoNonEqualIntegerDifferentSizeItemLists() {
		ll1 = new LinkedList<Integer>();
		ll2 = new LinkedList<Integer>();

		ll1.add(1);
		ll1.add(2);
		ll2.add(2);

		assertEquals(false, ll1.equals(ll2));
		assertEquals(false, ll2.equals(ll1));

		assertThat(ll1.hashCode(), is(not(ll2.hashCode())));
	}

	@Test
	public void equalsTwoNonEqualIntegerSameSizeSameElementsDifferentOrderLists() {
		ll1 = new LinkedList<Integer>();
		ll2 = new LinkedList<Integer>();

		ll1.add(1);
		ll1.add(2);
		ll2.add(2);
		ll2.add(1);

		assertEquals(false, ll1.equals(ll2));
		assertEquals(false, ll2.equals(ll1));

		assertThat(ll1.hashCode(), is(not(ll2.hashCode())));
	}

}
