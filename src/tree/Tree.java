package tree;

import java.util.ArrayList;

public class Tree<E> {

	// root Node
	Node<E> root;

	public Tree() {
		this.root = null;
	}

	// Constructor
	public Tree(Node<E> root) {
		this.root = root;
	}

	public int count() {
		return this.BFS().size();
	}

	// Searching for the a node with 'data'
	public Node<E> search(E data) {
		Node<E> foundNode = null;

		// Searching all nodes with BFS
		for (Node<E> cur : this.BFS()) {
			if (cur.getData() != null) {
				if (cur.getData().equals(data)) {
					foundNode = (Node<E>) cur;
					break;
				}
			}
		}
		return foundNode;
	}

	// Removing Node by setting reference from parent to null
	// Stupid function, if node has children, they will be deleted also
	public boolean remove(E data) {
		boolean removed = false;

		// Deleting root and hence all children
		if (data.equals(this.root.getData())) {
			this.root = null;
			removed = true;
		} else {
			Node<E> parent = this.parent(data);
			if (parent != null) {
				if (parent.hasLeft() && parent.getLeft().getData().equals(data)) {
					parent.setLeft(null);
				} else {
					parent.setRight(null);
				}
			}
		}
		return removed;
	}

	// Finding parent of node
	public Node<E> parent(E data) {
		Node<E> parent = null;
		ArrayList<Node<E>> allNodes = this.BFS();
		for (Node<E> tmp : allNodes) {
			if (tmp.hasLeft()) {
				if (tmp.getLeft().getData().equals(data)) {
					parent = tmp;
					break;
				}
			}
			if (tmp.hasRight()) {
				if (tmp.getRight().getData().equals(data)) {
					parent = tmp;
					break;
				}
			}
		}
		return parent;
	}

	// Breath first search
	public ArrayList<Node<E>> BFS() {
		return this.BFS(this.root);
	}

	// BFS from node different than node
	public ArrayList<Node<E>> BFS(Node<E> node) {
		ArrayList<Node<E>> output = new ArrayList<Node<E>>();
		ArrayList<Node<E>> iteratingLevel = new ArrayList<Node<E>>();
		iteratingLevel.add((Node<E>) node);
		ArrayList<Node<E>> nextLevel;

		// While there are Nodes in the current depth
		while (iteratingLevel.size() != 0) {
			nextLevel = new ArrayList<Node<E>>();
			// Iterate all Nodes of the current level which are in order
			for (Node<E> n : iteratingLevel) {
				output.add((Node<E>) n);
				// Left then right
				if (n.hasLeft()) {
					nextLevel.add((Node<E>) n.getLeft());
				}
				if (n.hasRight()) {
					nextLevel.add((Node<E>) n.getRight());
				}
			}
			iteratingLevel = nextLevel;
		}
		return output;
	}

	// Top view from the root
	public ArrayList<Node<E>> topView() {
		ArrayList<Node<E>> output = new ArrayList<Node<E>>();
		output.addAll(this.leftView(this.root));
		output.addAll(this.rightView(this.root.getRight()));
		return output;
	}

	private ArrayList<Node<E>> leftView(Node<E> node) {
		ArrayList<Node<E>> output = new ArrayList<Node<E>>();
		if (node != null) {
			output.addAll(this.leftView(node.getLeft()));
			output.add(node);
		}
		return output;
	}

	private ArrayList<Node<E>> rightView(Node<E> node) {
		ArrayList<Node<E>> output = new ArrayList<Node<E>>();
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

	private int height(Node<E> node) {
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
	public ArrayList<Node<E>> inOrder() {
		return inOrder(root);
	}

	private ArrayList<Node<E>> inOrder(Node<E> node) {
		ArrayList<Node<E>> output = new ArrayList<Node<E>>();
		ArrayList<Node<E>> left = new ArrayList<Node<E>>();
		ArrayList<Node<E>> middle = new ArrayList<Node<E>>();
		;
		ArrayList<Node<E>> right = new ArrayList<Node<E>>();

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
	public ArrayList<Node<E>> postOrder() {
		return postOrder(root);
	}

	private ArrayList<Node<E>> postOrder(Node<E> node) {
		ArrayList<Node<E>> output = new ArrayList<Node<E>>();
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
	public ArrayList<Node<E>> preOrder() {
		return preOrder(root);
	}

	private ArrayList<Node<E>> preOrder(Node<E> node) {
		ArrayList<Node<E>> output = new ArrayList<Node<E>>();
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
