package tree;

public class BinaryTree<E> extends Tree<E> {

	// Constructors
	public BinaryTree() {
		super();
	}

	public BinaryTree(Node<Integer> root) {
		super(root);
	}

	// Removing Node
	public void remove(E data) {
		
	}

	// Inserting Node at the right position with the hashCode() method
	// Returns true if node was inserted, false if not
	public boolean insert(E data) {
		@SuppressWarnings("unchecked")
		Node<E> tmp = (Node<E>) this.root;
		boolean inserted = false;

		Node<E> node = new Node<E>(data);

		// Tree is empty
		if (this.root == null) {
			this.root = node;
			inserted = true;
		}

		while (!inserted) {
			// Look left
			if (node.getData().hashCode() < tmp.getData().hashCode()) {
				// insert node at position if null
				if (!tmp.hasLeft()) {
					tmp.setLeft(node);
					inserted = true;
					// Iterate further left
				} else {
					tmp = tmp.getLeft();
				}
				// Look right
			} else if (node.getData().hashCode() > tmp.getData().hashCode()) {
				// insert node at position if null
				if (!tmp.hasRight()) {
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
}
