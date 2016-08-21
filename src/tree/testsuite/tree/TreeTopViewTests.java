package tree.testsuite.tree;

import static org.junit.Assert.*;

import org.junit.Test;

import tree.Node;
import tree.Tree;

public class TreeTopViewTests {

	@Test
	public void topViewTest1() {
		Node<Integer> n1 = new Node<Integer>(1);
		Node<Integer> n2 = new Node<Integer>(2);
		Node<Integer> n3 = new Node<Integer>(3);
		Node<Integer> n4 = new Node<Integer>(4);
		Node<Integer> n5 = new Node<Integer>(5);
		Node<Integer> n6 = new Node<Integer>(6);
		Node<Integer> n7 = new Node<Integer>(7);
		Node<Integer> n8 = new Node<Integer>(8);
		Node<Integer> n9 = new Node<Integer>(9);

		n3.setLeft(n5);
		n3.setRight(n2);
		n5.setLeft(n1);
		n5.setRight(n4);
		n2.setLeft(n6);
		n2.setRight(n7);
		n1.setRight(n9);
		n7.setLeft(n8);
		
		/*
	       3
	     /   \
	    5     2
	   / \   / \
	  1   4 6   7
	   \       /
	    9     8
	  Top View : 1 -> 5 -> 3 -> 2 -> 7
	  */
	  
		Tree<Integer> t = new Tree<Integer>(n3);
		
		String topView = "";
		for (Node<?> n : t.topView()){
			topView += n.getData().toString();
		}

		assertEquals("15327",topView);
	}
	
	@Test
	public void topViewTest2() {
		Node<Integer> n1 = new Node<Integer>(1);
		Node<Integer> n2 = new Node<Integer>(2);
		Node<Integer> n3 = new Node<Integer>(3);
		Node<Integer> n4 = new Node<Integer>(4);

		n1.setLeft(n2);
		n1.setRight(n3);
		n2.setLeft(n4);
	  
		Tree<Integer> t = new Tree<Integer>(n1);
		
		String topView = "";
		for (Node<?> n : t.topView()){
			topView += n.getData().toString();
		}

		assertEquals("4213",topView);
	}

}
