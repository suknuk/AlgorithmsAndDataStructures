package stack;

public interface Stack <E>{
	// pushing an element on top
	Stack<E> push(E element);
	// returning and popping the top element
	E pop();
	// returning the top element
	E peek();
	boolean empty();
	// returning index of obj
	int search(Object obj);
}
