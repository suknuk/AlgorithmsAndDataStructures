package linkedList.testsuite;

import static org.junit.Assert.*;

import org.junit.Test;

import linkedList.LinkedList;

public class LinkedListRemoveDuplicatesTests {

	LinkedList<Integer> ll;
	
	@Test
	public void removingDuplicatesEmptyList() {
		ll = new LinkedList<Integer>();
		
		ll.removeDuplicates();
		
		assertEquals(0, ll.size());
	}
	
	@Test
	public void removingDuplicates() {
		ll = new LinkedList<Integer>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(1);
		ll.add(1);
		
		ll.removeDuplicates();
		
		assertEquals(3, ll.size());
	}
	
	@Test
	public void removingMultipleDuplicates() {
		ll = new LinkedList<Integer>();
		ll.add(1);
		ll.add(3);
		ll.add(2);
		ll.add(2);
		ll.add(3);
		ll.add(1);
		ll.add(1);
		ll.add(2);
		ll.add(3);
		
		ll.removeDuplicates();
		
		assertEquals(3, ll.size());
	}
	
	@Test
	public void removingDuplicatesWithoutDuplicates() {
		ll = new LinkedList<Integer>();
		ll.add(1);
		ll.add(6);
		ll.add(3);
		ll.add(4);
		ll.add(7);
		
		ll.removeDuplicates();
		
		assertEquals(5, ll.size());
	}
}
