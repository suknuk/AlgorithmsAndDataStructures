package linkedList;

public class LinkedList {
	private Node head;

	public LinkedList() {
	}

	public void add(Object data) {
		Node newNode = new Node(data);
		// empty Linked List
		if (this.head == null) {
			head = newNode;
		}
		// non empty Linked List, find last item in chain and add the node
		else {
			Node tempNode = head;
			while (tempNode.getNext() != null) {
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(newNode);
		}
	}

	// Returns the size of the list
	public int size() {
		int counter = 0;
		// List has elements
		if (head != null) {
			Node tmp = head;
			// iterate through every node
			while (tmp != null) {
				counter++;
				tmp = tmp.getNext();
			}
		}
		return counter;
	}

	@Override
	public String toString() {
		String output;
		if (head == null) {
			output = null;
		} else {
			output = "";
			// Iterating through every node in chain
			Node tmp = head;
			while (tmp != null) {
				output += "[" + tmp.getData().toString() + "]";
				tmp = tmp.getNext();
				if (tmp != null){
					output += ",";
				}
			}
		}
		return output;
	}

	private class Node {
		// data of this node carried, can be any Object
		Object data;
		// reference to next Node in chain, null if there is none
		Node next;

		// empty Node constructor
		public Node() {
			this(null, null);
		}

		// Node constructor with value
		@SuppressWarnings("unused")
		public Node(Object dataValue) {
			this(dataValue, null);
		}

		// Node constructor with value and next Node
		public Node(Object dataValue, Node nextNode) {
			this.data = dataValue;
			this.next = nextNode;
		}

		Object getData() {
			return data;
		}

		Node getNext() {
			return next;
		}

		void setData(Object newData) {
			this.data = newData;
		}

		void setNext(Node newNext) {
			this.next = newNext;
		}
	}
}
