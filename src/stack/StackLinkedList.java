package stack;

public class StackLinkedList<E> implements Stack<E> {

	private Node top;
	private int size;

	// Constructor
	public StackLinkedList() {
		this.size = 0;
		this.top = null;
	}

	// Pushing element on top
	@Override
	public Stack<E> push(E element) {
		this.top = new Node(element, top);
		this.size++;
		return this;
	}

	// Popping stack top
	@Override
	public E pop() {
		if (this.size == 0) {
			throw new java.util.NoSuchElementException();
		}
		E tmp = this.top.data;
		this.top = this.top.next;
		this.size--;
		return tmp;
	}

	// Returning Stack top
	@Override
	public E peek() {
		if (this.size == 0) {
			throw new java.util.EmptyStackException();
		}
		return this.top.data;
	}

	// Checks if the stack is empty or not
	@Override
	public boolean empty() {
		boolean isEmpty;
		if (this.size == 0) {
			isEmpty = true;
		} else {
			isEmpty = false;
		}
		return isEmpty;
	}

	// Searching position of obj in the stack. -1 if not in the stack
	@Override
	public int search(Object obj) {
		int position = -1;
		Node tmp = this.top;
		for (int i = 1; i <= this.size; i++) {
			if (tmp.data.equals(obj)) {
				position = i;
				break;
			}
			tmp = tmp.next;
		}
		return position;
	}

	@Override
	public String toString() {
		String output = "";
		Node tmp = this.top;
		while (tmp != null) {
			output += "[" + tmp.data.toString() + "]";
			if (tmp.next != null) {
				output += ",";

			}
			tmp = tmp.next;
		}
		return output;
	}

	public int size() {
		return this.size;
	}

	// Node for Linked List
	private class Node {
		E data;
		Node next;

		Node(E data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

}
