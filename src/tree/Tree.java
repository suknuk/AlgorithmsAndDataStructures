package tree;

import java.util.ArrayList;

public class Tree<E> {

	// root Node
	Node<?> root;

	public Tree() {
		this.root = null;
	}

	// Constructor
	public Tree(Node<?> root) {
		this.root = root;
	}

	// Searching for the a node with 'data'
	@SuppressWarnings("unchecked")
	public Node<E> search(E data) {
		Node<E> foundNode = null;

		// Searching all nodes with BFS
		for (Node<?> cur : this.BFS()){
			if (cur.getData().equals(data)){
				foundNode = (Node<E>) cur;
				break;
			}
		}

		return foundNode;
	}

	// Breath first search
	public ArrayList<Node<?>> BFS() {
		ArrayList<Node<?>> output = new ArrayList<Node<?>>();
		ArrayList<Node<?>> actualLevel = new ArrayList<Node<?>>();
		actualLevel.add((Node<?>) this.root);
		ArrayList<Node<?>> nextLevel;

		// While there are Nodes in the current depth
		while (actualLevel.size() != 0) {
			nextLevel = new ArrayList<Node<?>>();
			// Iterate all Nodes of the current level which are in order
			for (Node<?> n : actualLevel) {
				output.add((Node<?>) n);
				// Left then right
				if (n.hasLeft()) {
					nextLevel.add((Node<?>) n.getLeft());
				}
				if (n.hasRight()) {
					nextLevel.add((Node<?>) n.getRight());
				}
			}
			actualLevel = nextLevel;
		}
		return output;
	}

	// Top view from the root
	public ArrayList<Node<?>> topView() {
		ArrayList<Node<?>> output = new ArrayList<Node<?>>();
		output.addAll(this.leftView(this.root));
		output.addAll(this.rightView(this.root.getRight()));
		return output;
	}

	private ArrayList<Node<?>> leftView(Node<?> node) {
		ArrayList<Node<?>> output = new ArrayList<Node<?>>();
		if (node != null) {
			output.addAll(this.leftView(node.getLeft()));
			output.add(node);
		}
		return output;
	}

	private ArrayList<Node<?>> rightView(Node<?> node) {
		ArrayList<Node<?>> output = new ArrayList<Node<?>>();
		if (node != null) {
			output.add(node);
			output.addAll(this.rightView(node.getRight()));
		}
		return output;
	}

	// Height of the Tree
	public int height() {
		return this.height(this.root);
	}

	private int height(Node<?> node) {
		int height = 1;
		if (node.hasLeft()) {
			height += height(node.getLeft());
		}
		if (node.hasRight()) {
			height = Math.max(height, height(node.getRight()));
		}

		return height;
	}

	// Returns the nodes of the Tree in "in Order" form
	public ArrayList<Node<?>> inOrder() {
		return inOrder(root);
	}

	private ArrayList<Node<?>> inOrder(Node<?> node) {
		ArrayList<Node<?>> output = new ArrayList<Node<?>>();
		ArrayList<Node<?>> left = new ArrayList<Node<?>>();
		ArrayList<Node<?>> middle = new ArrayList<Node<?>>();
		;
		ArrayList<Node<?>> right = new ArrayList<Node<?>>();

		if (node.hasLeft()) {
			left.addAll(inOrder(node.getLeft()));
		}

		middle.add(node);

		if (node.hasRight()) {
			right.addAll(inOrder(node.getRight()));
		}

		output.addAll(left);
		output.addAll(middle);
		output.addAll(right);

		return output;
	}

	// Returns the nodes of the Tree in post Order form
	public ArrayList<Node<?>> postOrder() {
		return postOrder(root);
	}

	private ArrayList<Node<?>> postOrder(Node<?> node) {
		ArrayList<Node<?>> output = new ArrayList<Node<?>>();
		if (node.hasLeft()) {
			output.addAll(postOrder(node.getLeft()));
		}
		if (node.hasRight()) {
			output.addAll(postOrder(node.getRight()));
		}
		output.add(node);
		return output;
	}

	// Returns the nodes of the Tree in pre Order form
	public ArrayList<Node<?>> preOrder() {
		return preOrder(root);
	}

	private ArrayList<Node<?>> preOrder(Node<?> node) {
		ArrayList<Node<?>> output = new ArrayList<Node<?>>();
		output.add(node);
		if (node.hasLeft()) {
			output.addAll(preOrder(node.getLeft()));
		}
		if (node.hasRight()) {
			output.addAll(preOrder(node.getRight()));
		}
		return output;
	}
}
