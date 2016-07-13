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
		/*
		 * Data == root.data flag. If this is the case, we create an additional
		 * node above the root which points to the root and let this node be the
		 * parent of the root. This parent node will get deleted before the
		 * method terminates
		 */
		boolean isRoot = false;

		// Deleting root and hence all children
		if (data.equals(this.root.getData())) {
			isRoot = true;
			Node<E> falseParent = new Node<E>();
			falseParent.setRight(this.root);
			this.root = falseParent;

		}

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
			}
			// case 2: node has left child
			else if (node.hasLeft() && !node.hasRight()) {
				// is node left or right child of parent
				if (parent.hasLeft() && parent.getLeft().equals(node)) {
					parent.setLeft(node.getLeft());
				} else {
					parent.setRight(node.getLeft());
				}
			}
			// case 3: node has right child
			else if (!node.hasLeft() && node.hasRight()) {
				// is node left or right child of parent
				if (parent.hasLeft() && parent.getLeft().equals(node)) {
					parent.setLeft(node.getRight());
				} else {
					parent.setRight(node.getRight());
				}
			}
			// case 4: node has left and right children
			else {
				// Searching lowest node of the right sub-tree
				Node<E> tmp = node.getRight();
				Node<E> tmpParent = node;
				while (tmp.hasLeft()) {
					tmpParent = tmp;
					tmp = tmp.getLeft();
				}
				
				// adding lowest node in right sub tree to parent
				if (parent.hasLeft() && parent.getLeft().equals(node)) {
					parent.setLeft(tmp);
				} else {
					parent.setRight(tmp);
				}

				/*
				 * if right child has no children on its own, we set replace
				 * node with node.right with null as the above loop deals only
				 * with sub-trees larger than 1 child. Without this, we would
				 * get an infinite loop
				 */
				if (tmpParent.getRight().getData().equals(tmp.getData())) {
					tmpParent.setRight(null);
				} else {
					tmpParent.setLeft(null);
				}

				// adding references of to be deleted node
				tmp.setLeft(node.getLeft());
				tmp.setRight(node.getRight());
			}
			removed = true;
		}

		// Change root to new root if temporary root was used
		if (isRoot) {
			this.root = this.root.getRight();
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
