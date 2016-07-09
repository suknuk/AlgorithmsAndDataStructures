package tree;

public class Tree {

	// root Node
	Node<?> root;

	// Constructor
	public Tree(Node<?> root) {
		this.root = root;
	}
	
	// Returns the items of the Tree in "in Order" form
	public String inOrder() {
		return inOrder(root);
	}

	private String inOrder(Node<?> root) {
		String output = "";
		String left = "";
		String middle = "";
		String right = "";
		
		if (root.getLeft() != null) {
			left = inOrder(root.getLeft()) + " ";
		}
		
		middle = root.data.toString();
		
		if (root.getRight() != null) {
			right = " " + inOrder(root.getRight());
		}
		
		output = left + middle + right;
		
		return output;
	}
	
	// Returns the items of the Tree in post Order form
	public String postOrder() {
		return postOrder(root);
	}

	private String postOrder(Node<?> root) {
		String output = "";
		if (root.getLeft() != null) {
			output += postOrder(root.getLeft()) + " ";
		}
		if (root.getRight() != null) {
			output += postOrder(root.getRight()) + " ";
		}
		output += root.data.toString();
		return output;
	}
	
	// Returns the items of the Tree in pre Order form
	public String preOrder() {
		return preOrder(root);
	}

	private String preOrder(Node<?> root) {
		String output = root.data.toString();
		if (root.getLeft() != null) {
			output += " " + preOrder(root.getLeft());
		}
		if (root.getRight() != null) {
			output += " " + preOrder(root.getRight());
		}
		return output;
	}
}
