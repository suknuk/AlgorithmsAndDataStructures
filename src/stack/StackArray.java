package stack;

public class StackArray<E> implements Stack<E> {

	private E[] stack;
	private int size;

	// Constructor
	@SuppressWarnings("unchecked")
	public StackArray() {
		this.stack = (E[]) new Object[2];
		this.size = 0;
	}

	// Pushing new element on top of the stack
	@Override
	public Stack<E> push(E element) {
		if (this.stack.length == this.size) {
			this.resizeStack(this.size * 2);
		}
		this.size++;
		this.stack[this.size - 1] = element;
		return this;
	}

	// Resizing the stack
	private void resizeStack(int newSize) {
		@SuppressWarnings("unchecked")
		E[] newStack = (E[]) new Object[newSize];
		System.arraycopy(this.stack, 0, newStack, 0, this.size);
		this.stack = newStack;
	}

	// Popping top of the stack
	@Override
	public E pop() {
		if (this.size == 0) {
			throw new java.util.NoSuchElementException();
		} else {
			E top = this.stack[this.size - 1];
			this.stack[this.size - 1] = null;
			this.size--;

			// Eliminating unused stack size (1,2,4,8,16, etc)
			if (this.size * 2 == this.stack.length) {
				this.resizeStack(this.size);
			}
			return top;
		}
	}

	// Returning the top item of the stack
	@Override
	public E peek() {
		return this.stack[size - 1];
	}

	// Checking if the stack is empty
	@Override
	public boolean empty() {
		boolean isEmpty;
		if (this.size > 0) {
			isEmpty = false;
		} else {
			isEmpty = true;
		}
		return isEmpty;
	}

	// Items in the stack
	public int size() {
		return this.size;
	}

	// How many E blocks are reserved
	public int stackSize() {
		return this.stack.length;
	}

	// Searching position of obj in the stack. -1 if not in the stack
	@Override
	public int search(Object obj) {
		int position = -1;
		for (int i = 0; i < this.size; i++) {
			if (this.stack[i].equals(obj)){
				position = i;
				break;
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		return this.stack.toString();
	}

}
