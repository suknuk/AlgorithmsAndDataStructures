package linkedList;

public class LinkedList {
	Node head;
	
	private class Node{
		Object data;
		Node next;
		
		Object get(){
			return data;
		}
		
		Node getNext(){
			return next;
		}
		
		void setData(Object newData){
			this.data = newData;
		}
		
		void setNext(Node newNext){
			this.next = newNext;
		}
	}
}
