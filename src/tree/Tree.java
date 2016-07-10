package tree;

public class Tree {

	// root Node
	Node<?> root;

	// Constructor
	public Tree(Node<?> root) {
		this.root = root;
	}

	// Top view from the root
	public String topView() {
		String output = "";
		output = this.leftView(this.root);
		output += this.rightView(this.root.getRight());
		return output;
	}

	private String leftView(Node<?> node) {
		String output = "";
		if (node != null) {
			output = this.leftView(node.getLeft());
			output += node.data.toString();
		}
		return output;
	}

	private String rightView(Node<?> node) {
		String output = "";
		if (node != null) {
			output = node.data.toString();
			output += this.rightView(node.getRight());
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
