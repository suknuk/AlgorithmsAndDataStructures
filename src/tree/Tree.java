package tree;

import java.util.ArrayList;

public class Tree {

	// root Node
	Node<?> root;

	public Tree() {
		this.root = null;
	}

	// Constructor
	public Tree(Node<?> root) {
		this.root = root;
	}

	// Inserting Node at the right position with the hashCode() method
	// Returns true if node was inserted, false if not
	@SuppressWarnings("unchecked")
	public boolean insertNode(@SuppressWarnings("rawtypes") Node node) {
		@SuppressWarnings("rawtypes")
		Node tmp = this.root;
		boolean inserted = false;

		// Tree is empty
		if (this.root == null) {
			this.root = node;
			inserted = true;
		}

		while (!inserted) {
			// Look left
			if (node.data.hashCode() < tmp.data.hashCode()) {
				// insert node at position if null
				if (tmp.getLeft() == null) {
					tmp.setLeft(node);
					inserted = true;
					// Iterate further left
				} else {
					tmp = tmp.getLeft();
				}
				// Look right
			} else if (node.data.hashCode() > tmp.data.hashCode()) {
				// insert node at position if null
				if (tmp.getRight() == null) {
					tmp.setRight(node);
					inserted = true;
					// Iterate further right
				} else {
					tmp = tmp.getRight();
				}
			} else {
				// If hashCode is the same, this method will not work
				System.out.println("Node double detected");
				break;
			}
		}

		return inserted;
	}

	// Breath first search
	public ArrayList<Node<?>> BFS() {
		ArrayList<Node<?>> output = new ArrayList<Node<?>>();
		ArrayList<Node<?>> actualLevel = new ArrayList<Node<?>>();
		actualLevel.add(this.root);
		ArrayList<Node<?>> nextLevel;// = new ArrayList<Node>();

		// While there are Nodes in the current depth
		while (actualLevel.size() != 0) {
			nextLevel = new ArrayList<Node<?>>();
			// Iterate all Nodes of the current level which are in order
			for (Node<?> n : actualLevel) {
				output.add(n);
				// Left then right
				if (n.getLeft() != null) {
					nextLevel.add(n.getLeft());
				}
				if (n.getRight() != null) {
					nextLevel.add(n.getRight());
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
		if (node.getLeft() != null) {
			height += height(node.getLeft());
		}
		if (node.getRight() != null) {
			height = Math.max(height, height(node.getRight()));
		}

		return height;
	}

	// Returns the items of the Tree in "in Order" form
	public String inOrder() {
		return inOrder(root);
	}

	private String inOrder(Node<?> node) {
		String output = "";
		String left = "";
		String middle = "";
		String right = "";

		if (node.getLeft() != null) {
			left = inOrder(node.getLeft()) + " ";
		}

		middle = node.data.toString();

		if (node.getRight() != null) {
			right = " " + inOrder(node.getRight());
		}

		output = left + middle + right;

		return output;
	}

	// Returns the items of the Tree in post Order form
	public String postOrder() {
		return postOrder(root);
	}

	private String postOrder(Node<?> node) {
		String output = "";
		if (node.getLeft() != null) {
			output += postOrder(node.getLeft()) + " ";
		}
		if (node.getRight() != null) {
			output += postOrder(node.getRight()) + " ";
		}
		output += node.data.toString();
		return output;
	}

	// Returns the items of the Tree in pre Order form
	public String preOrder() {
		return preOrder(root);
	}

	private String preOrder(Node<?> node) {
		String output = node.data.toString();
		if (node.getLeft() != null) {
			output += " " + preOrder(node.getLeft());
		}
		if (node.getRight() != null) {
			output += " " + preOrder(node.getRight());
		}
		return output;
	}
}
