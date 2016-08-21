package tree;

public class HeapTree<E> extends Tree<E>{

	/*
	 * peeking the root node
	 */
	public E peek(){
		return this.root.getData();
	}
	
	/*
	 * There is no remove method in the TreeHeap data structure
	 */
	@Override
	public boolean remove(E data){
		throw new UnsupportedOperationException("Not supported");
	}
}
