package linkedList.testsuite;

import static org.junit.Assert.*;

import org.junit.Test;

import linkedList.LinkedList;

public class LinkedListPushTests {

	LinkedList ll;
	
	@Test
	public void pushSingleItem() {
		ll = new LinkedList();
		ll.push(1);
		
		assertEquals(1,ll.get(0));
		assertEquals(1,ll.size());
	}
	
	@Test
	public void pushMultipleItems() {
		ll = new LinkedList();
		ll.push(1);
		ll.push(2);
		ll.push(3);
		
		assertEquals(3,ll.get(0));
		assertEquals(2,ll.get(1));
		assertEquals(1,ll.get(2));
		assertEquals(3,ll.size());
	}

}
