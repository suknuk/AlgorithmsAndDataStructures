package tree.testsuite;

import static org.junit.Assert.*;

import org.junit.Test;

import tree.Node;
import tree.Tree;

public class TreePreOrderTests {

	@Test
	public void preOrderTest1() {
		Node<Integer> n1 = new Node<Integer>(1);
		Node<Integer> n2 = new Node<Integer>(2);
		Node<Integer> n3 = new Node<Integer>(3);
		Node<Integer> n4 = new Node<Integer>(4);
		Node<Integer> n5 = new Node<Integer>(5);
		Node<Integer> n6 = new Node<Integer>(6);
		
		n3.setLeft(n5);
		n3.setRight(n2);
		n5.setLeft(n1);
		n5.setRight(n4);
		n2.setLeft(n6);
		
		Tree t = new Tree(n3);
		
		assertEquals("3 5 1 4 2 6", t.preOrder());
	}
	
	@Test
	public void preOrderTest2() {
		Node<Integer> n1 = new Node<Integer>(1);
		Node<Integer> n2 = new Node<Integer>(2);
		Node<Integer> n3 = new Node<Integer>(3);
		Node<Integer> n4 = new Node<Integer>(4);
		Node<Integer> n5 = new Node<Integer>(5);
		Node<Integer> n6 = new Node<Integer>(6);
		
		n1.setLeft(n3);
		n3.setLeft(n2);
		n3.setRight(n4);
		n4.setRight(n5);
		n5.setRight(n6);
		
		Tree t = new Tree(n1);
		
		assertEquals("1 3 2 4 5 6", t.preOrder());
	}

}
