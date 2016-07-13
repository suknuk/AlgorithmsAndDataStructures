package tree;

public class BinaryTree<E> extends Tree<E> {

	// Constructors
	public BinaryTree() {
		super();
	}

	public BinaryTree(Node<E> root) {
		super(root);
	}

	@Override
	// Removing Node with children
	public boolean remove(E data) {
		boolean removed = false;

		// Deleting root and hence all children
		if (data.equals(this.root.getData())) {
			this.root = null;
			removed = true;
		} else {
			// Getting parent and node references
			Node<E> parent = super.parent(data);
			Node<E> node = super.search(data);

			if (parent != null && node != null) {

				// case 1: node has no children
				if (!node.hasLeft() && !node.hasRight()) {
					if (parent.hasLeft() && parent.getLeft().getData().equals(data)) {
						parent.setLeft(null);
					} else {
						parent.setRight(null);
					}
					removed = true;
				}
				// case 2: node has left child
				else if (node.hasLeft() && !node.hasRight()) {
					// is node left or right child of parent
					if (parent.hasLeft() && parent.getLeft().equals(node)) {
						parent.setLeft(node.getLeft());
					} else {
						parent.setRight(node.getLeft());
					}
					removed = true;
				}
				// case 3: node has right child
				else if (!node.hasLeft() && node.hasRight()) {
					// is node left or right child of parent
					if (parent.hasLeft() && parent.getLeft().equals(node)) {
						parent.setLeft(node.getRight());
					} else {
						parent.setRight(node.getRight());
					}
					removed = true;
				}
				// case 4: node has left and right children
				else {
					/*
					 * Calculating size of both sub trees. Take the most right
					 * child of the left node if left side tree is larger and
					 * vice versa
					 */
				}
			}
		}
		return removed;
	}

	// Inserting Node at the right position with the hashCode() method
	// Returns true if node was inserted, false if not
	public boolean insert(E data) {
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
