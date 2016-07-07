package linkedList.testsuite;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import linkedList.LinkedList;

public class LinkedListReverseTests {

	LinkedList ll;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void reverseEmptyList() {
		ll = new LinkedList();
		ll.reverseList();
		
		assertEquals(0,ll.size());
		
		thrown.expect(IndexOutOfBoundsException.class);
		ll.get(0);
	}
	
	@Test
	public void reverseSingleItemList() {
		ll = new LinkedList();
		ll.add(1);
		ll.reverseList();
		
		assertEquals(1,ll.get(0));
		assertEquals(1,ll.size());
	}
	
	@Test
	public void reverseTwoItemsList() {
		ll = new LinkedList();
		ll.add(1);
		ll.add(2);
		ll.reverseList();
		
		assertEquals(2,ll.get(0));
		assertEquals(1,ll.get(1));
		assertEquals(2,ll.size());
	}
	
	@Test
	public void reverseManyItemsList() {
		ll = new LinkedList();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		ll.add(6);
		
		ll.reverseList();
		
		assertEquals(6,ll.get(0));
		assertEquals(5,ll.get(1));
		assertEquals(4,ll.get(2));
		assertEquals(3,ll.get(3));
		assertEquals(2,ll.get(4));
		assertEquals(1,ll.get(5));
		assertEquals(6,ll.size());
	}

}
