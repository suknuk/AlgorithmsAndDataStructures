package tree;

public class Node<E> {
	E data;
	private Node<E> left;
	private Node<E> right;
	
	// Constructor
	public Node(E data) {
		this.data = data;
	}

	// Getters and setters
	public Node<E> getLeft() {
		return left;
	}

	public void setLeft(Node<E> left) {
		this.left = left;
	}

	public Node<E> getRight() {
		return right;
	}

	public void setRight(Node<E> right) {
		this.right = right;
	}
}
