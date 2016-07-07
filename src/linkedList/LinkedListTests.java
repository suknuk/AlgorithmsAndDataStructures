package linkedList;

public class LinkedListTests {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		
		System.out.println(ll.toString());
		System.out.println(ll.size());
		System.out.println(ll.get(0));
		
		ll.push(5);
		System.out.println(ll.toString());
		System.out.println(ll.size());
		
		ll.add(6, 0);
		ll.add(7, 1);
		System.out.println(ll.toString());
		System.out.println(ll.size());
		
		ll.add(8, ll.size());
		System.out.println(ll.toString());
		System.out.println(ll.size());
		
		ll.remove(0);
		System.out.println(ll.toString());
		ll.remove(ll.size()-1);
		System.out.println(ll.toString());
		
		ll.remove(2);
		System.out.println(ll.toString());
		
		ll.reverseList();
		System.out.println(ll.toString());
		
		LinkedList ll1 = new LinkedList();
		LinkedList ll2 = new LinkedList();
		
		System.out.println(ll1.equals(ll2));
		
		ll1.add(1);
		System.out.println(ll1.equals(ll2));
		ll1.add(2);
		ll1.add(3);
		ll2.add(1);
		ll2.add(2);
		System.out.println(ll1.equals(ll2));
		ll2.add(3);
		
		System.out.println(ll1.equals(ll2));
		
		System.out.println(ll1.hashCode());
		System.out.println(ll2.hashCode());
		

	}

}
