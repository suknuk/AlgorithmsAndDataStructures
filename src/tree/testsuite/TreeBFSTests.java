package tree.testsuite;

import static org.junit.Assert.*;

import org.junit.Test;

import tree.Node;
import tree.Tree;

public class TreeBFSTests {

	@Test
	public void levelOrderTest1() {
		Node<Integer> n1 = new Node<Integer>(1);
		Node<Integer> n2 = new Node<Integer>(2);
		Node<Integer> n3 = new Node<Integer>(3);
		Node<Integer> n4 = new Node<Integer>(4);
		Node<Integer> n5 = new Node<Integer>(5);
		Node<Integer> n6 = new Node<Integer>(6);

		/*
		        3
		      /   \
		     5     2
		    / \    /
		   1   4  6
			BFS is 3 -> 5 -> 2 -> 1 -> 4 -> 6.
		 */
		
		n3.setLeft(n5);
		n3.setRight(n2);
		n5.setLeft(n1);
		n5.setRight(n4);
		n2.setLeft(n6);
	  
		Tree<Integer> t = new Tree<Integer>(n3);

		String bfs = "";
		for (Node<?> n : t.BFS()){
			bfs += n.getData().toString();
		}
		assertEquals("352146",bfs);
	}

	@Test
	public void levelOrderTest2() {
		Node<Integer> n1 = new Node<Integer>(1);
		Node<Integer> n2 = new Node<Integer>(2);
		Node<Integer> n3 = new Node<Integer>(3);
		Node<Integer> n4 = new Node<Integer>(4);
		Node<Integer> n5 = new Node<Integer>(5);
		Node<Integer> n6 = new Node<Integer>(6);
		Node<Integer> n7 = new Node<Integer>(7);

		/*
		        1
		      /   \
		     2     3
		    / \    /\
		   4   5  6  7
			level order traversal is 3 -> 5 -> 2 -> 1 -> 4 -> 6.
		 */
		
		n1.setLeft(n2);
		n1.setRight(n3);
		n2.setLeft(n4);
		n2.setRight(n5);
		n3.setLeft(n6);
		n3.setRight(n7);
	  
		Tree<Integer> t = new Tree<Integer>(n1);
		
		String bfs = "";
		for (Node<?> n : t.BFS()){
			bfs += n.getData().toString();
		}
		assertEquals("1234567",bfs);
	}
}
