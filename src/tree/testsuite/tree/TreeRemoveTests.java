package tree.testsuite.tree;

import static org.junit.Assert.*;

import org.junit.Test;

import tree.Node;
import tree.Tree;

public class TreeRemoveTests {

	@Test
	public void insertRemoveTest1() {
		Node<Integer> n1 = new Node<Integer>(1);
		Node<Integer> n2 = new Node<Integer>(2);
		Node<Integer> n3 = new Node<Integer>(3);
		Node<Integer> n4 = new Node<Integer>(4);
		Node<Integer> n5 = new Node<Integer>(5);
		Node<Integer> n6 = new Node<Integer>(6);
		Node<Integer> n7 = new Node<Integer>(7);

		n1.setLeft(n2);
		n1.setRight(n3);
		n2.setLeft(n4);
		n2.setRight(n5);
		n3.setLeft(n6);
		n3.setRight(n7);
		
		Tree<Integer> t = new Tree<Integer>(n1);
		
		String bfs = "";
		for (Node<?> n : t.BFS()) {
			bfs += n.getData().toString();
		}

		assertEquals("1234567", bfs);
		
		t.remove(7);
		
		bfs = "";
		for (Node<?> n : t.BFS()) {
			bfs += n.getData().toString();
		}

		assertEquals("123456", bfs);
	}
}
