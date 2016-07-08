package linkedList.testsuite;

import static org.junit.Assert.*;

import org.junit.Test;

import linkedList.LinkedList;

public class LinkedListMergeTests {

	LinkedList<Integer> ll1, ll2, mergedList, testList;

	@Test
	public void mergingTwoEqualSizedLists() {
		ll1 = new LinkedList<Integer>();
		ll2 = new LinkedList<Integer>();
		mergedList = new LinkedList<Integer>();
		testList = new LinkedList<Integer>();
		
		ll1.add(2);
		ll1.add(3);
		ll2.add(1);
		ll2.add(4);

		//mergedList = LinkedList.merge(ll1, ll2);

		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);

		assertEquals(true, testList.equals(mergedList));

	}

}
