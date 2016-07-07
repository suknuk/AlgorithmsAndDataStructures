package linkedList.testsuite;

import static org.junit.Assert.*;

import org.junit.Test;

import linkedList.LinkedList;

public class LinkedListAddTests {

	LinkedList ll;
	
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

}
