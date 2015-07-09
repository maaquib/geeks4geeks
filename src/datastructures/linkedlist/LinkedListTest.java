package datastructures.linkedlist;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList<Integer> myList = new LinkedList<Integer>(12);
		myList.append(15);
		myList.append(11);
		myList.append(5);
		myList.append(6);
		myList.append(2);
		myList.push(3);
		myList.insertAfter(6, 10);
		myList.delete(11);
		// System.out.println(myList.getCount());
		// System.out.println(myList.getNth(6));
		// myList.printMiddle();
		// myList.printReverse();
		// myList.print();
		// myList.reverse();
		System.out.println(myList.detectLoop());
		myList.print();
	}

}
