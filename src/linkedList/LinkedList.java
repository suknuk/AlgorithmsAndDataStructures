package linkedList;

public class LinkedList {
	private Node head;
	private int length;

	public LinkedList() {
	}

	// Adding object at the end of the list
	public void add(Object data) {
		Node newNode = new Node(data);
		// empty List
		if (this.head == null) {
			this.head = newNode;
			this.length = 1;
		}
		// Non empty Linked List, find last item in chain and add the node
		else {
			Node tempNode = this.head;
			while (tempNode.getNext() != null) {
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(newNode);
			this.length++;
		}
	}

	// Adding object at the front of the list
	public void push(Object data) {
		Node newNode = new Node(data);
		// empty List
		if (this.head == null) {
			this.head = newNode;
			this.length = 1;
		}
		// Replace Head with newNode and add reference to old head.next to new
		// head
		else {
			Node tmp = this.head;
			this.head = newNode;
			this.head.setNext(tmp);
			this.length++;
		}
	}

	// Return object at index
	public Object get(int index) {
		Object dataAtPosition;
		// Index must be 0 or higher and must not be higher than the length of
		// the list
		if (index < 0 || index >= this.length) {
			dataAtPosition = new IndexOutOfBoundsException();
		} else {
			Node tmp = this.head;
			// Finding the Node by iterating the list until the index is found
			while (index != 0) {
				tmp = tmp.getNext();
				index--;
			}
			dataAtPosition = tmp.getData();
		}
		return dataAtPosition;
	}

	// Returns the size of the list
	public int size() {
		return this.length;
	}

	// Calculates the size of the list
	public int calculateSize() {
		int counter = 0;
		// List has elements
		if (this.head != null) {
			Node tmp = this.head;
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
		if (this.head == null) {
			output = null;
		} else {
			output = "";
			// Iterating through every node in chain
			Node tmp = this.head;
			while (tmp != null) {
				output += "[" + tmp.getData().toString() + "]";
				tmp = tmp.getNext();
				if (tmp != null) {
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
		@SuppressWarnings("unused")
		public Node() {
			this(null, null);
		}

		// Node constructor with value
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

		@SuppressWarnings("unused")
		void setData(Object newData) {
			this.data = newData;
		}

		void setNext(Node newNext) {
			this.next = newNext;
		}
	}
}
