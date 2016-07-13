package tree.testsuite;

import static org.junit.Assert.*;

import org.junit.Test;

import tree.BinaryTree;
import tree.Node;

public class BinaryTreeRemoveTests {

	@Test
	public void removeNodeNoChildrenTest() {
		BinaryTree<Integer> t = new BinaryTree<Integer>();
		t.insert(1);
		t.insert(4);
		t.insert(3);
		t.insert(5);

		t.remove(5);
		
		String bfs = "";
		for (Node<?> n : t.BFS()) {
			bfs += n.getData().toString();
		}

		assertEquals("143", bfs);
	}
	
	@Test
	public void removeNodeLeftChildTest1() {
		BinaryTree<Integer> t = new BinaryTree<Integer>();
		t.insert(3);
		t.insert(2);
		t.insert(1);
		t.insert(5);
		t.insert(4);
		t.insert(6);

		t.remove(2);
		
		String bfs = "";
		for (Node<?> n : t.BFS()) {
			bfs += n.getData().toString();
		}

		assertEquals("31546", bfs);
	}
	
	@Test
	public void removeNodeLeftChildTest2() {
		BinaryTree<Integer> t = new BinaryTree<Integer>();
		t.insert(4);
		t.insert(3);
		t.insert(2);
		t.insert(1);
		t.insert(5);
		t.insert(6);
		t.insert(7);

		t.remove(3);
		
		String bfs = "";
		for (Node<?> n : t.BFS()) {
			bfs += n.getData().toString();
		}

		assertEquals("425167", bfs);
	}
	
	@Test
	public void removeNodeRightChildTest1() {
		BinaryTree<Integer> t = new BinaryTree<Integer>();
		t.insert(4);
		t.insert(3);
		t.insert(2);
		t.insert(1);
		t.insert(5);
		t.insert(6);
		t.insert(7);

		t.remove(5);
		
		String bfs = "";
		for (Node<?> n : t.BFS()) {
			bfs += n.getData().toString();
		}

		assertEquals("436271", bfs);
	}
	
	@Test
	public void removeNodeRightChildTest2() {
		BinaryTree<Integer> t = new BinaryTree<Integer>();
		t.insert(3);
		t.insert(2);
		t.insert(1);
		t.insert(5);
		t.insert(4);
		t.insert(6);
		t.insert(7);

		t.remove(6);
		
		String bfs = "";
		for (Node<?> n : t.BFS()) {
			bfs += n.getData().toString();
		}

		assertEquals("325147", bfs);
	}

}
