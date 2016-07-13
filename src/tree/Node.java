package tree;

public class Node<E> {
	private E data;
	private Node<E> left;
	private Node<E> right;

	// Constructor
	public Node(E data) {
		this.data = data;
	}

	// Getters and setters - should be self-explaining
	public E getData() {
		return this.data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public boolean hasLeft() {
		boolean var;
		if (this.left != null) {
			var = true;
		} else {
			var = false;
		}
		return var;
	}

	public boolean hasRight() {
		boolean var;
		if (this.right != null) {
			var = true;
		} else {
			var = false;
		}
		return var;
	}

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
