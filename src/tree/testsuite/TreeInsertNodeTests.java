package tree.testsuite;

import static org.junit.Assert.*;

import org.junit.Test;

import tree.Node;
import tree.Tree;

public class TreeInsertNodeTests {

	@Test
	public void insertNodeTest1() {
		Node<Integer> n1 = new Node<Integer>(1);
		Node<Integer> n2 = new Node<Integer>(2);
		Node<Integer> n3 = new Node<Integer>(3);
		Node<Integer> n4 = new Node<Integer>(4);
		Node<Integer> n6 = new Node<Integer>(6);
		Node<Integer> n7 = new Node<Integer>(7);
		
		/*
	        4
	       / \
	      2   7
	     / \
	    1   3
    
    	insert 6
    
	         4
	       /   \
	      2     7
	     / \   /
	    1   3 6
		*/
		
		n4.setLeft(n2);
		n4.setRight(n7);
		n2.setLeft(n1);
		n2.setRight(n3);
		
		Tree t = new Tree(n4);
		
		t.insertNode(n6);
		
		String bfs = "";
		for (Node<?> n : t.BFS()){
			bfs += n.getData().toString();
		}
		
		assertEquals("427136",bfs);
	}
	
	@Test
	public void insertNodeTest2() {
		Node<Integer> n1 = new Node<Integer>(1);
		Node<Integer> n2 = new Node<Integer>(2);
		Node<Integer> n3 = new Node<Integer>(3);
		Node<Integer> n4 = new Node<Integer>(4);
		Node<Integer> n5 = new Node<Integer>(5);
		Node<Integer> n6 = new Node<Integer>(6);
		
		
		n1.setLeft(n2);
		n1.setRight(n5);
		n5.setRight(n6);
		n2.setLeft(n3);
		
		Tree t = new Tree(n1);
		
		t.insertNode(n4);
		
		String bfs = "";
		for (Node<?> n : t.BFS()){
			bfs += n.getData().toString();
		}
		
		assertEquals("125346",bfs);
	}
}
